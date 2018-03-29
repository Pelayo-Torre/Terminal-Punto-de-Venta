package logica;

import igu.VentanaPrincipal;

import java.awt.Component;
import java.awt.Image;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class Tabla extends DefaultTableCellRenderer{
	
	/**
	 * Método para insertar en la tabla imágenes botones...
	 */
	@Override
	public Component getTableCellRendererComponent(JTable tabla, Object objeto, boolean art, boolean art2, int i, int j){
		//Comprobamos que el objeto pasado como parámetro es una instancia de una JLabel para añadir la imagen en la tabla
		if(objeto instanceof JLabel)
		{
			JLabel etiqueta = (JLabel) objeto;
			return etiqueta;
		}
		if(objeto instanceof JButton)
		{
			JButton boton = (JButton) objeto;
			return boton;
		}
		if(objeto instanceof JSpinner)
		{
			JSpinner spinner = (JSpinner) objeto;
			return spinner;
		}
		return super.getTableCellRendererComponent(tabla, objeto, art, art2, i, j);
	}
	
	/**
	 * Método para añadir al carro los elementos seleccionados
	 * @param tabla
	 * @param repetidos
	 * @param carro
	 */
	public void añadirCarro(JTable tabla, ArrayList<String>repetidos, ArrayList<String>carro){
		int fila = tabla.getSelectedRow();
		boolean posible = true;
		if(fila != -1)
		{
			String nombre = (String) tabla.getValueAt(fila, 1);
			String precio = (String) String.valueOf(tabla.getValueAt(fila, 2));
			String puntos = (String) String.valueOf(tabla.getValueAt(fila, 3));
			
			for(String m : repetidos)
			{
				if(m.equals(nombre))
				{
					posible =false;
				}		
			}
			if(posible == true)
			{
				carro.add(nombre);
				carro.add(precio);
				carro.add(puntos);
				repetidos.add(nombre);
			}
		}
	}
	
	/**
	 * Método para añadir los artículos a las tablas
	 * @param tabla
	 * @param articulos
	 * @param vp
	 */
	@SuppressWarnings("unused")
	public void añadirArticulos(JTable tabla,ArrayList<Articulo>articulos, VentanaPrincipal vp){
		Object [] fila = new Object[4];
		DefaultTableCellRenderer cell = new DefaultTableCellRenderer();
		BigDecimal decimal;
		for(int i=0; i<articulos.size();i++)
		{
			
			ImageIcon foto = new ImageIcon(getClass().getResource("/img/"+articulos.get(i).getCodigo()+".jpg"));
			Image img = foto.getImage();
			Image img2 = img.getScaledInstance(90, 100, Image.SCALE_SMOOTH);
			ImageIcon foto2 = new ImageIcon(img2);
			JLabel lbFoto = new JLabel();
			lbFoto.setIcon(foto2);
			lbFoto.setHorizontalAlignment(SwingConstants.CENTER);

			
			fila[0] = lbFoto;
			fila[1] = articulos.get(i).getDenominacion();
			if(vp.isConVid() == true && articulos.get(i).getCodigo().startsWith("CV-")
					|| vp.isFotVi() == true && articulos.get(i).getCodigo().startsWith("FV-") 
					|| vp.isTef() == true && articulos.get(i).getCodigo().startsWith("TM-")
					|| vp.isOrdena() == true && articulos.get(i).getCodigo().startsWith("OT-")
					|| vp.isVideoVigi() == true && articulos.get(i).getCodigo().startsWith("VI-"))
			{		
				fila[2] = new BigDecimal((articulos.get(i).getPrecio()*0.9)).setScale(2, RoundingMode.DOWN);
			}
			else
			{
				fila[2] = articulos.get(i).getPrecio();
			}
			fila[3] = articulos.get(i).getPuntosCompra();
			((DefaultTableModel)tabla.getModel()).addRow(fila);	
			tabla.setRowHeight(i, 140);
			
			//Para Centrar el texto en la tabla
			for(int j=0; j<tabla.getColumnCount(); j++)
			{
				DefaultTableColumnModel columnaModelo = (DefaultTableColumnModel) tabla.getColumnModel();
				TableColumn columna = columnaModelo.getColumn(j);
				TableCellRenderer r = columna.getHeaderRenderer();
				int var = 0;
				for(int k=0; k<tabla.getRowCount(); k++)
				{
					r = tabla.getCellRenderer(k, j);
					Component componente = r.getTableCellRendererComponent(tabla, tabla.getValueAt(k, j), false, false, k, j);
					var = Math.max(var, componente.getPreferredSize().width);
				}
				columna.setPreferredWidth(var+2);
			}	
		}		
	}
	
	/**
	 * Método para limpiar la tabla.
	 * @param table
	 */
	public void limpiar(JTable table){
		try{
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			int f = table.getRowCount();
			for(int i=0; f>i; i++)
			{
				modelo.removeRow(0);
			}
		}catch(Exception e){
			
		}
	}
	
	/**
	 * Método para comprobar que haya existencias
	 * @param tabla
	 * @param articulos
	 * @return
	 */
	public boolean comprobarUnidades(JTable tabla, ArrayList<Articulo>articulos){
		for(int i=0; i<articulos.size(); i++)
		{
			if(tabla.getSelectedRow() != -1)
			{
				if(tabla.getValueAt(tabla.getSelectedRow(), 1).equals(articulos.get(i).getDenominacion()))
				{
					if(articulos.get(i).getStock() == 0)
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Método para añadir los regalos a la tabla
	 * @param tabla
	 * @param regalos
	 * @param vp
	 */
	@SuppressWarnings("unused")
	public void añadirRegalos(JTable tabla,ArrayList<Regalo>regalos, VentanaPrincipal vp){
		Object [] fila = new Object[3];
		DefaultTableCellRenderer cell = new DefaultTableCellRenderer();
		
		for(int i=0; i<regalos.size();i++)
		{
			
			ImageIcon foto = new ImageIcon(getClass().getResource("/img/"+regalos.get(i).getCodigo()+".jpg"));
			Image img = foto.getImage();
			Image img2 = img.getScaledInstance(90, 100, Image.SCALE_SMOOTH);
			ImageIcon foto2 = new ImageIcon(img2);
			JLabel lbFoto = new JLabel();
			lbFoto.setIcon(foto2);
			lbFoto.setHorizontalAlignment(SwingConstants.CENTER);

			
			fila[0] = lbFoto;
			fila[1] = regalos.get(i).getDenominacion();
			fila[2] = regalos.get(i).getValor();
			((DefaultTableModel)tabla.getModel()).addRow(fila);	
			tabla.setRowHeight(i, 140);
			
			//Para Centrar el texto en la tabla
			for(int j=0; j<tabla.getColumnCount(); j++)
			{
				DefaultTableColumnModel columnaModelo = (DefaultTableColumnModel) tabla.getColumnModel();
				TableColumn columna = columnaModelo.getColumn(j);
				TableCellRenderer r = columna.getHeaderRenderer();
				int var = 0;
				for(int k=0; k<tabla.getRowCount(); k++)
				{
					r = tabla.getCellRenderer(k, j);
					Component componente = r.getTableCellRendererComponent(tabla, tabla.getValueAt(k, j), false, false, k, j);
					var = Math.max(var, componente.getPreferredSize().width);
				}
				columna.setPreferredWidth(var+2);
			}	
		}		
	}
	
}