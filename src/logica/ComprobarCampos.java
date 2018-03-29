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
			char cad = nif.getText().charAt(i);	//charAt te devuelve el caracter que se encuentra en la posici�n i.
			if(i<8)
			{
				if(cad != '0' && cad != '1' &&cad != '2' &&cad != '3' &&cad != '4' &&cad != '5' &&cad != '6' &&cad != '7' &&cad != '8' &&cad != '9')
				{
					JOptionPane.showMessageDialog(null,"NIF incorrecto, por favor introduxca un NIF correcto.\nEl NIF debe de tener 8 d�gitos y 1 letra.");
					return false;
				}
			}
			if(i==8)
			{
				if( cad == '0' || cad == '1' ||cad == '2' ||cad == '3' ||cad == '4' ||cad == '5' ||cad == '6' ||cad == '7' ||cad == '8' ||cad == '9')
				{
					JOptionPane.showMessageDialog(null,"NIF incorrecto, por favor introduxca un NIF correcto.\nEl NIF debe de tener 8 d�gitos y 1 letra.");
					return false;
				}
			}
			if(nif.getText().length() != 9)
			{
				JOptionPane.showMessageDialog(null, "NIF incorrecto, por favor introduxca un NIF correcto.\nEl NIF debe de tener 8 d�gitos y 1 letra.");
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
			char cad = telefono.getText().charAt(i);	//charAt te devuelve el caracter que se encuentra en la posici�n i.
			if(i<9)
			{
				if(cad != '0' && cad != '1' &&cad != '2' &&cad != '3' &&cad != '4' &&cad != '5' &&cad != '6' &&cad != '7' &&cad != '8' &&cad != '9')
				{
					JOptionPane.showMessageDialog(null,"N�mero de tel�fono incorrecto, por favor introduzca un n�mero correcto.\nEl n�mero de tel�fono debe contener 9 d�gitos.");
					return false;
				}
			}
			if(telefono.getText().length() != 9)
			{
				JOptionPane.showMessageDialog(null, "N�mero de tel�fono incorrecto, por favor introduzca un n�mero correcto.\nEl n�mero de tel�fono debe contener 9 d�gitos.");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * M�todo que comprueba que la contrase�a sea correcta
	 * @param psContrase�a
	 * @return true si lo es, false si no
	 */
	@SuppressWarnings("deprecation")
	public boolean contrase�a(JPasswordField psContrase�a){
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
		if(!((psContrase�a.getText().contains(cadena0) || psContrase�a.getText().contains(cadena1) ||psContrase�a.getText().contains(cadena2) ||
				psContrase�a.getText().contains(cadena3) ||psContrase�a.getText().contains(cadena4) ||psContrase�a.getText().contains(cadena5) ||
				psContrase�a.getText().contains(cadena6) ||psContrase�a.getText().contains(cadena7) ||psContrase�a.getText().contains(cadena8) ||
				psContrase�a.getText().contains(cadena9)) && psContrase�a.getText().length() >= 8))
		{
			JOptionPane.showMessageDialog(null,"Contrase�a incorrecta, por favor introduzca una contrase�a correcta.\nLa contrase�a debe tener como m�nimo 8 caracteres alfanum�ricos.");
			return false;
		}
		else
		{
			return true;
		}	
	}
	
	/**
	 * Comprueba que las dos contrase�as sean iguales
	 * @param psContrase�a
	 * @param psRepetirContrase�a
	 * @return true si los son false si no
	 */
	@SuppressWarnings("deprecation")
	public boolean comprobarContrase�as(JPasswordField psContrase�a, JPasswordField psRepetirContrase�a){
		if (!(psContrase�a.getText().equals(psRepetirContrase�a.getText())))
		{
			JOptionPane.showMessageDialog(null, "Las contrase�as no coinciden");
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
			JOptionPane.showMessageDialog(null,"Nombre de usuario incorrecto, por favor introduzca un nombre de usuario correcto.\nEl nombre de usuario debe contener como m�ximo 20 caracteres alfanum�ricos y sin espacios.");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * M�todo para recorrer las listas y comprobar que el usuario est� o no registrado
	 * @param nombreUsuario
	 * @param contrase�a
	 * @return true si est� registrado, false en caso contrario.
	 * @throws IOException
	 */
	public boolean recorrer(String nombreUsuario, String contrase�a, ArrayList<Cliente>cliente) throws IOException{
		for(int i=0; i<cliente.size(); i++)
		{
			if(cliente.get(i).getUsuario().equals(nombreUsuario) && cliente.get(i).getContrase�a().equals(contrase�a))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * M�todo para recorrer los nif de todos los clientes
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
	 * M�todo para recorrer todos los nombres de usuarios de los clientes
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
