package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;

@SuppressWarnings("unused")
public class Cliente {

	private String vip;
	private String nombre;
	private String apellidos;
	private String NIF;
	private String usuario;
	private String contraseña;
	private String telefono;
	private int tarjeta;
	private int puntos;
	public String usuarioRegistrado;
	public String contraseñaRegistrada;
	
	public Cliente(String vipp, String name, String surname, String nif, String usu, String password, String phone, int tarjet, int points)
	{
		vip = vipp;
		nombre = name;
		apellidos = surname;
		NIF = nif;
		usuario = usu;
		contraseña = password;
		telefono = phone;
		tarjeta = tarjet;
		puntos = points;
	}
	
	

	public String getVip() {
		return vip;
	}



	public void setVip(String vip) {
		this.vip = vip;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public String toString(){
		return(getVip()+";"+getNombre()+";"+getApellidos()+";"+getNIF()+";"+getUsuario()+";"+getContraseña()+";"+getTelefono()+";"+getTarjeta()+";"+getPuntos());
	}
	
	/**
	 * Método para escribir en el fichero un nuevo cliente
	 * @param nombreFichero
	 * @param cliente
	 */
	public void grabarRegistro(String nombreFichero, Cliente cliente){
		try {
		        BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFichero + ".dat",true));
		        String linea = cliente.toString();
		        fichero.write(linea);
		        fichero.newLine();
		        fichero.close();
			}

		catch (FileNotFoundException fnfe) {
		      System.out.println("El archivo no se ha podido guardar");
		    }
		catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}
	}
}
