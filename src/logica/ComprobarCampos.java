package logica;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ComprobarCampos {

	/**
	 * Comprueba que el nif sea correcto
	 * @param nif
	 * @return true si lo es, false si no
	 */
	public boolean NIF(JTextField nif){
		for(int i=0; i<nif.getText().length(); i++)
		{
			char cad = nif.getText().charAt(i);	//charAt te devuelve el caracter que se encuentra en la posición i.
			if(i<8)
			{
				if(cad != '0' && cad != '1' &&cad != '2' &&cad != '3' &&cad != '4' &&cad != '5' &&cad != '6' &&cad != '7' &&cad != '8' &&cad != '9')
				{
					JOptionPane.showMessageDialog(null,"NIF incorrecto, por favor introduxca un NIF correcto.\nEl NIF debe de tener 8 dígitos y 1 letra.");
					return false;
				}
			}
			if(i==8)
			{
				if( cad == '0' || cad == '1' ||cad == '2' ||cad == '3' ||cad == '4' ||cad == '5' ||cad == '6' ||cad == '7' ||cad == '8' ||cad == '9')
				{
					JOptionPane.showMessageDialog(null,"NIF incorrecto, por favor introduxca un NIF correcto.\nEl NIF debe de tener 8 dígitos y 1 letra.");
					return false;
				}
			}
			if(nif.getText().length() != 9)
			{
				JOptionPane.showMessageDialog(null, "NIF incorrecto, por favor introduxca un NIF correcto.\nEl NIF debe de tener 8 dígitos y 1 letra.");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Comprueba que telefono sea correcto.
	 * @param telefono
	 * @return true si lo es falkse si no
	 */
	public boolean telefono(JTextField telefono){
		for(int i=0; i<telefono.getText().length(); i++)
		{
			char cad = telefono.getText().charAt(i);	//charAt te devuelve el caracter que se encuentra en la posición i.
			if(i<9)
			{
				if(cad != '0' && cad != '1' &&cad != '2' &&cad != '3' &&cad != '4' &&cad != '5' &&cad != '6' &&cad != '7' &&cad != '8' &&cad != '9')
				{
					JOptionPane.showMessageDialog(null,"Número de teléfono incorrecto, por favor introduzca un número correcto.\nEl número de teléfono debe contener 9 dígitos.");
					return false;
				}
			}
			if(telefono.getText().length() != 9)
			{
				JOptionPane.showMessageDialog(null, "Número de teléfono incorrecto, por favor introduzca un número correcto.\nEl número de teléfono debe contener 9 dígitos.");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Método que comprueba que la contraseña sea correcta
	 * @param psContraseña
	 * @return true si lo es, false si no
	 */
	@SuppressWarnings("deprecation")
	public boolean contraseña(JPasswordField psContraseña){
		String cadena0 = "0";
		String cadena1 = "1";
		String cadena2 = "2";
		String cadena3 = "3";
		String cadena4 = "4";
		String cadena5 = "5";
		String cadena6 = "6";
		String cadena7 = "7";
		String cadena8 = "8";
		String cadena9 = "9";
		if(!((psContraseña.getText().contains(cadena0) || psContraseña.getText().contains(cadena1) ||psContraseña.getText().contains(cadena2) ||
				psContraseña.getText().contains(cadena3) ||psContraseña.getText().contains(cadena4) ||psContraseña.getText().contains(cadena5) ||
				psContraseña.getText().contains(cadena6) ||psContraseña.getText().contains(cadena7) ||psContraseña.getText().contains(cadena8) ||
				psContraseña.getText().contains(cadena9)) && psContraseña.getText().length() >= 8))
		{
			JOptionPane.showMessageDialog(null,"Contraseña incorrecta, por favor introduzca una contraseña correcta.\nLa contraseña debe tener como mínimo 8 caracteres alfanuméricos.");
			return false;
		}
		else
		{
			return true;
		}	
	}
	
	/**
	 * Comprueba que las dos contraseñas sean iguales
	 * @param psContraseña
	 * @param psRepetirContraseña
	 * @return true si los son false si no
	 */
	@SuppressWarnings("deprecation")
	public boolean comprobarContraseñas(JPasswordField psContraseña, JPasswordField psRepetirContraseña){
		if (!(psContraseña.getText().equals(psRepetirContraseña.getText())))
		{
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Comprueba que el usuario sea correcto
	 * @param nombreUsuario
	 * @return true si lo es false si no
	 */
	public boolean usuario(JTextField nombreUsuario){
		String cadena = " ";
		if(nombreUsuario.getText().length() > 20 || nombreUsuario.getText().contains(cadena))
		{
			JOptionPane.showMessageDialog(null,"Nombre de usuario incorrecto, por favor introduzca un nombre de usuario correcto.\nEl nombre de usuario debe contener como máximo 20 caracteres alfanuméricos y sin espacios.");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Método para recorrer las listas y comprobar que el usuario está o no registrado
	 * @param nombreUsuario
	 * @param contraseña
	 * @return true si está registrado, false en caso contrario.
	 * @throws IOException
	 */
	public boolean recorrer(String nombreUsuario, String contraseña, ArrayList<Cliente>cliente) throws IOException{
		for(int i=0; i<cliente.size(); i++)
		{
			if(cliente.get(i).getUsuario().equals(nombreUsuario) && cliente.get(i).getContraseña().equals(contraseña))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método para recorrer los nif de todos los clientes
	 * @param nif
	 * @param cliente
	 * @return
	 */
	public boolean recorrerNif(String nif, ArrayList<Cliente> cliente){
		for(int i=0; i<cliente.size(); i++)
		{
			if(cliente.get(i).getNIF().equals(nif))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Método para recorrer todos los nombres de usuarios de los clientes
	 * @param usuario
	 * @param cliente
	 * @return
	 */
	public boolean recorrerUsuario(String usuario, ArrayList<Cliente>cliente){
		for(int i=0; i<cliente.size(); i++)
		{
			if(cliente.get(i).getUsuario().equals(usuario))
			{
				return false;
			}
		}
		return true;
	}
	
}
