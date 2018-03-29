package logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class Factura {
	
	private GregorianCalendar calendar = new GregorianCalendar();
	
	public Factura(){
		
	}

	/**
	 * Método para generar la factura
	 * @param nombre
	 * @param apellidos
	 * @param nif
	 * @param lista
	 * @param regalos
	 * @param clientes
	 * @param consolas
	 * @param fotografia
	 * @param telefonia
	 * @param ordenadores
	 * @param videovigilancia
	 * @param des
	 * @param acumular
	 * @throws IOException
	 */
	public void generarFactura(String nombre, String apellidos, String nif, ArrayList<Articulo>lista,
			ArrayList <Regalo> regalos,ArrayList<Cliente> clientes, boolean consolas, boolean fotografia,
			boolean telefonia, boolean ordenadores, boolean videovigilancia, boolean des, boolean acumular) throws IOException{
		
		String dia = String.valueOf(calendar.get(Calendar.DATE));
		String mes = String.valueOf(calendar.get(Calendar.MONTH)+1);
		String año = String.valueOf(calendar.get(Calendar.YEAR));
		String var = nif+"--"+dia+"-"+mes+"-"+año;
		BufferedWriter writer = new BufferedWriter(new FileWriter("files/"+var));
		
		writer.write("                          FACTURA - EII MARKET - "+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.MONTH)+1+"/"+calendar.get(Calendar.YEAR));
		writer.newLine();
		writer.write("----------------------------------------------------------------------------------------------");
		writer.newLine();
		writer.write("NOMBRE: "+nombre+" "+apellidos+"    NIF: "+nif);
		writer.newLine();
		writer.write("----------------------------------------------------------------------------------------------");
		writer.newLine();
		writer.newLine();
		writer.write("                        ** RELACION DE ARTICULOS COMPRADOS **");
		writer.newLine();
		writer.newLine();
		writer.write("Denominacion / Código / Unidades / Total artículo");
		writer.newLine();
		writer.write("----------------------------------------------------");
		writer.newLine();
		double coste = 0;
		double descuento = 0;
		double noDescuento = 0;
		double total = 0;
		double puntosCliente = 0;
		double ptotal = 0;
		DecimalFormat decimal = new DecimalFormat("0.00");
		for(int i=0; i<lista.size(); i++)
		{
			if((consolas == true && lista.get(i).getCategoria().contains("Consolas")) || (fotografia == true && lista.get(i).getCategoria().contains("Fotografía")) 
					|| (telefonia == true && lista.get(i).getCategoria().contains("Telefonía"))
					|| (ordenadores == true && lista.get(i).getCategoria().contains("Ordenadores"))
					|| (videovigilancia == true && lista.get(i).getCategoria().contains("Videovigilancia")))
			{
				writer.newLine();
				writer.write("* "+lista.get(i).getDenominacion()+" / "+lista.get(i).getCodigo()+
						" / "+lista.get(i).getStock()+" / "+((lista.get(i).getPrecio()*lista.get(i).getStock()))+"€"+" (*)");	
				descuento = ((double) ((lista.get(i).getPrecio()*lista.get(i).getStock())));
			}
			else
			{
				writer.newLine();
				writer.write("* "+lista.get(i).getDenominacion()+" / "+lista.get(i).getCodigo()+
						" / "+lista.get(i).getStock()+" / "+lista.get(i).getPrecio()*lista.get(i).getStock()+"€");
				noDescuento = (double) (lista.get(i).getPrecio()*lista.get(i).getStock());
			}
			ptotal = ptotal + lista.get(i).getPuntosCompra()*lista.get(i).getStock();
			total = descuento + noDescuento;
			descuento = 0;
			noDescuento = 0;
			coste = coste + total;
		}
		writer.newLine();
		writer.write("...");
		writer.newLine();
		writer.newLine();
		writer.write("  (*) Artículo/s con descuento aplicado del 10%");
		if(regalos.size() != 0)
		{
			writer.newLine();
			writer.newLine();
			writer.write("                          ** RELACIÓN DE ARTICULOS REGALADOS **");
			writer.newLine();
			writer.newLine();
			writer.write("Denominacion / Código / Unidades / Total artículo");
			writer.newLine();
			writer.write("----------------------------------------------------");
			for(int i=0; i<regalos.size(); i++)
			{
				writer.newLine();
				writer.write("* "+regalos.get(i).getDenominacion()+" / "+regalos.get(i).getCodigo());
			}
			writer.newLine();
			writer.write("...");
		}
		writer.newLine();
		writer.newLine();
		writer.write("Total Artículos. . . . . . . . . . . . . . . . . . . . . . . ."+decimal.format(coste)+"€");
		if(des == true)
		{
			for(int i=0; i<clientes.size(); i++)
			{
				if(clientes.get(i).getNIF().equals(nif))
				{
					puntosCliente = clientes.get(i).getPuntos();				
				}
			}
			double puntosTotales = puntosCliente + ptotal;
			double costeTotal = coste - puntosTotales;
			writer.newLine();
			writer.write("Descuento por puntos. . . . . . . . . . . . . . . . . . . . . . . ."+puntosTotales+"€");
			writer.newLine();
			writer.write("TOTAL FACTURA. . . . . . . . . . . . . . . . . . . . . . . . . . .."+costeTotal+"€");
		}
		if(acumular == true)
		{
			writer.newLine();
			writer.write("TOTAL FACTURA. . . . . . . . . . . . . . . . . . . . . . . . . . .."+coste+"€");
		}
		writer.close();
	}

}
