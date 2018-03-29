package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FileHelper {
	DecimalFormat decimal = new DecimalFormat("0.00");
	
	private ArrayList <Articulo> articulos = new ArrayList<Articulo>();
	private ArrayList <Articulo> telefonos = new ArrayList<Articulo>();
	private ArrayList <Articulo> videovigilancia = new ArrayList<Articulo>();
	private ArrayList <Articulo> consolas = new ArrayList<Articulo>();
	private ArrayList <Articulo> fotografia = new ArrayList<Articulo>();
	private ArrayList <Articulo> ordenadores = new ArrayList<Articulo>();
	
	private ArrayList <Articulo> articulosMasVendidos = new ArrayList<Articulo>();
	private ArrayList <Articulo> articulosNovedades = new ArrayList<Articulo>();
	
	private ArrayList <Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList <Regalo> regalos = new ArrayList<Regalo>();
	private ArrayList <String> morosos = new ArrayList<String>();
	
	public ArrayList<String> getMorosos(){
		return morosos;
	}

	public ArrayList<Regalo> getRegalos(){
		return regalos;
	}	
	public ArrayList<Articulo> getArticulosMasVendidos() {
		return articulosMasVendidos;
	}
	public ArrayList<Articulo> getArticulosNovedades() {
		return articulosNovedades;
	}
	public ArrayList<Articulo> getTelefonos() {
		return telefonos;
	}
	public ArrayList<Articulo> getFotografia() {
		return fotografia;
	}
	public ArrayList<Articulo> getOrdenadores() {
		return ordenadores;
	}
	public ArrayList<Articulo> getVideovigilancia() {
		return videovigilancia;
	}
	public ArrayList<Articulo> getConsolas() {
		return consolas;
	}
	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}
	public ArrayList<Cliente> getCliente(){
		return clientes;
	}
	
	/**
	 * Método auxiliar para cargar las líneas de los articulos más vendidos
	 * @param reader
	 * @throws IOException
	 */
	private void cargarLineasArticuloMasVendido(BufferedReader reader) throws IOException{
		while(reader.ready())
		{
			String linea = reader.readLine();
			String[] datos = linea.split(";");
			articulosMasVendidos.add(new Articulo(datos[0],datos[1],datos[2],datos[3],datos[4],(Double.parseDouble(datos[5])),Integer.parseInt(datos[6]), Integer.parseInt(datos[7])));
		}
	}	

	/**
	 * Método para leer el fichero proporcionado
	 * @param fileName
	 * @throws IOException
	 */
	public void leerDatosArticuloMasVendido(String fileName) throws IOException{
		BufferedReader input = new BufferedReader(new FileReader (fileName));
		try{
			cargarLineasArticuloMasVendido(input);
			input.close();
		}catch(FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}	
	}
	
	/**
	 * Método para cargar las líneas del fichero novedades
	 * @param reader
	 * @throws IOException
	 */
	private void cargarLineasArticuloNovedades(BufferedReader reader) throws IOException{
		while(reader.ready())
		{
			String linea = reader.readLine();
			String[] datos = linea.split(";");
			articulosNovedades.add(new Articulo(datos[0],datos[1],datos[2],datos[3],datos[4],Double.parseDouble(datos[5]),Integer.parseInt(datos[6]), Integer.parseInt(datos[7])));
		}
	}	

	/**
	 * Método para leer el fichero novedades
	 * @param fileName
	 * @throws IOException
	 */
	public void leerDatosArticuloNovedades(String fileName) throws IOException{
		BufferedReader input = new BufferedReader(new FileReader (fileName));
		try{
			cargarLineasArticuloNovedades(input);
			input.close();
		}catch(FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}	
	}
	
	
	/**
	 * Método para cargar las líneas de los artículos
	 * @param reader
	 * @throws IOException
	 */
	private void cargarLineasArticulo(BufferedReader reader) throws IOException{
		while(reader.ready())
		{
			String linea = reader.readLine();
			String[] datos = linea.split(";");
			articulos.add(new Articulo(datos[0],datos[1],datos[2],datos[3],datos[4],Double.parseDouble(datos[5]),Integer.parseInt(datos[6]), Integer.parseInt(datos[7])));
			if(datos[0].startsWith("TM-"))
			{
				telefonos.add(new Articulo(datos[0],datos[1],datos[2],datos[3],datos[4],Double.parseDouble(datos[5]),Integer.parseInt(datos[6]), Integer.parseInt(datos[7])));
			}
			else if(datos[0].startsWith("VI-"))
			{
				videovigilancia.add(new Articulo(datos[0],datos[1],datos[2],datos[3],datos[4],Double.parseDouble(datos[5]),Integer.parseInt(datos[6]), Integer.parseInt(datos[7])));
			}
			else if(datos[0].startsWith("CV-"))
			{
				consolas.add(new Articulo(datos[0],datos[1],datos[2],datos[3],datos[4],Double.parseDouble(datos[5]),Integer.parseInt(datos[6]), Integer.parseInt(datos[7])));
			}
			else if(datos[0].startsWith("FV-"))
			{
				fotografia.add(new Articulo(datos[0],datos[1],datos[2],datos[3],datos[4],Double.parseDouble(datos[5]),Integer.parseInt(datos[6]), Integer.parseInt(datos[7])));
			}
			else if(datos[0].startsWith("OT-"))
			{
				ordenadores.add(new Articulo(datos[0],datos[1],datos[2],datos[3],datos[4],Double.parseDouble(datos[5]),Integer.parseInt(datos[6]), Integer.parseInt(datos[7])));
			}
		}
	}	

	/**
	 * Método para leer los artículos
	 * @param fileName
	 * @throws IOException
	 */
	public void leerDatosArticulo(String fileName) throws IOException{
		BufferedReader input = new BufferedReader(new FileReader (fileName));
		try{
			cargarLineasArticulo(input);
			input.close();
		}catch(FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}	
	}
	
	/**
	 * Método para cargar los clientes 
	 * @param reader
	 * @throws IOException
	 */
	private void cargarLineasClientes(BufferedReader reader) throws IOException{
		while(reader.ready())
		{
			String linea = reader.readLine();
			String[] datos = linea.split(";");
			clientes.add(new Cliente(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6], Integer.parseInt(datos[7]), Integer.parseInt(datos[8])));
		}
	}	

	/**
	 * Método para leer los datos del fichero clientes
	 * @param fileName
	 * @throws IOException
	 */
	public void leerDatosClientes(String fileName) throws IOException{
		BufferedReader input = new BufferedReader(new FileReader (fileName));
		try{
			cargarLineasClientes(input);
			input.close();
		}catch(FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}	
	}
	
	/**
	 * Método para carggar los regalos.
	 * @param reader
	 * @throws IOException
	 */
	private void cargarLineasRegalos(BufferedReader reader) throws IOException{
		while(reader.ready())
		{
			String linea = reader.readLine();
			String[] datos = linea.split(";");
			regalos.add(new Regalo(datos[0], datos[1], datos[2], Integer.parseInt(datos[3])));
		}
	}	

	/**
	 * Método para leer del fichero regalos
	 * @param fileName
	 * @throws IOException
	 */
	public void leerDatosRegalos(String fileName) throws IOException{
		BufferedReader input = new BufferedReader(new FileReader (fileName));
		try{
			cargarLineasRegalos(input);
			input.close();
		}catch(FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}	
	}
	
	
	/**
	 * Método para cargar los clientes morosos 
	 * @param reader
	 * @throws IOException
	 */
	private void cargarLineasMorosos(BufferedReader reader) throws IOException{
		while(reader.ready())
		{
			String linea = reader.readLine();
			morosos.add((linea));
		}
	}	

	/**
	 * Método para leer los datos del fichero clientes
	 * @param fileName
	 * @throws IOException
	 */
	public void leerDatosMorosos(String fileName) throws IOException{
		BufferedReader input = new BufferedReader(new FileReader (fileName));
		try{
			cargarLineasMorosos(input);
			input.close();
		}catch(FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}	
	}
	
}
