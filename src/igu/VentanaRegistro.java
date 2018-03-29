package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JPasswordField;

import logica.Cliente;
import logica.ComprobarCampos;
import logica.FileHelper;

import java.awt.Toolkit;

@SuppressWarnings({ "unused", "serial" })
public class VentanaRegistro extends JDialog {

	private JPanel contentPane;
	private VentanaRegistro vr;
	private InicioSesion inicio;
	private JLabel lbNombre;
	private JTextField textNombre;
	private JLabel lbApellidos;
	private JTextField textApellidos;
	private JPanel panelDatosUsuario;
	private JLabel lbNombreUsuario;
	private JTextField textNombreUsuario;
	private JLabel lblNewLabel;
	private JTextField textNIF;
	private JLabel lblTelfono;
	private JTextField textTelefono;
	private JLabel lblContrasea;
	private JLabel lblRepetirContrasea;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JPasswordField psContraseña;
	private JPasswordField psRepetirContraseña;
	private Cliente client;
	private boolean registro = false;
	private FileHelper file = new FileHelper();
	private ComprobarCampos cc ;
	private VentanaPrincipal vp;


	/**
	 * Create the frame.
	 */
	public VentanaRegistro(InicioSesion is, VentanaPrincipal vpp) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/img/logo.jpg.png")));
		vp = vpp;
		setResizable(false);
		cc = new ComprobarCampos();
		setTitle("Registro");
		inicio = is;
		setBounds(100, 100, 654, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbNombre());
		contentPane.add(getTextNombre());
		contentPane.add(getLbApellidos());
		contentPane.add(getTextApellidos());
		contentPane.add(getPanelDatosUsuario());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextNIF());
		contentPane.add(getLblTelfono());
		contentPane.add(getTextTelefono());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnCancelar());
		setLocationRelativeTo(null);
	}

	public VentanaRegistro getVr() {
		return vr;
	}

	public void setVr(VentanaRegistro vr) {
		this.vr = vr;
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setLabelFor(getTextNombre());
			lbNombre.setDisplayedMnemonic('N');
			lbNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
			lbNombre.setBounds(24, 30, 64, 22);
		}
		return lbNombre;
	}
	private JTextField getTextNombre() {
		if (textNombre == null) {
			textNombre = new JTextField();
			textNombre.setFont(new Font("Dialog", Font.PLAIN, 13));
			textNombre.setBounds(127, 31, 163, 20);
			textNombre.setColumns(10);
		}
		return textNombre;
	}
	private JLabel getLbApellidos() {
		if (lbApellidos == null) {
			lbApellidos = new JLabel("Apellidos:");
			lbApellidos.setLabelFor(getTextApellidos());
			lbApellidos.setDisplayedMnemonic('A');
			lbApellidos.setFont(new Font("Dialog", Font.PLAIN, 15));
			lbApellidos.setBounds(24, 63, 64, 22);
		}
		return lbApellidos;
	}
	private JTextField getTextApellidos() {
		if (textApellidos == null) {
			textApellidos = new JTextField();
			textApellidos.setFont(new Font("Dialog", Font.PLAIN, 13));
			textApellidos.setBounds(127, 62, 243, 20);
			textApellidos.setColumns(10);
		}
		return textApellidos;
	}
	private JPanel getPanelDatosUsuario() {
		if (panelDatosUsuario == null) {
			panelDatosUsuario = new JPanel();
			panelDatosUsuario.setBorder(new TitledBorder(null, "Datos de usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDatosUsuario.setBounds(24, 174, 383, 127);
			panelDatosUsuario.setLayout(null);
			panelDatosUsuario.add(getLbNombreUsuario());
			panelDatosUsuario.add(getTextNombreUsuario());
			panelDatosUsuario.add(getLblContrasea());
			panelDatosUsuario.add(getLblRepetirContrasea());
			panelDatosUsuario.add(getPsContraseña());
			panelDatosUsuario.add(getPsRepetirContraseña());
		}
		return panelDatosUsuario;
	}
	private JLabel getLbNombreUsuario() {
		if (lbNombreUsuario == null) {
			lbNombreUsuario = new JLabel("Nombre de usuario:");
			lbNombreUsuario.setLabelFor(getTextNombreUsuario());
			lbNombreUsuario.setDisplayedMnemonic('u');
			lbNombreUsuario.setFont(new Font("Dialog", Font.PLAIN, 15));
			lbNombreUsuario.setBounds(10, 23, 138, 22);
		}
		return lbNombreUsuario;
	}
	private JTextField getTextNombreUsuario() {
		if (textNombreUsuario == null) {
			textNombreUsuario = new JTextField();
			textNombreUsuario.setBounds(171, 25, 191, 20);
			textNombreUsuario.setColumns(10);
		}
		return textNombreUsuario;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("NIF:");
			lblNewLabel.setLabelFor(getTextNIF());
			lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
			lblNewLabel.setDisplayedMnemonic('F');
			lblNewLabel.setBounds(24, 96, 64, 22);
		}
		return lblNewLabel;
	}
	private JTextField getTextNIF() {
		if (textNIF == null) {
			textNIF = new JTextField();
			textNIF.setBounds(127, 98, 163, 20);
			textNIF.setColumns(10);
		}
		return textNIF;
	}
	private JLabel getLblTelfono() {
		if (lblTelfono == null) {
			lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setLabelFor(getTextTelefono());
			lblTelfono.setDisplayedMnemonic('T');
			lblTelfono.setFont(new Font("Dialog", Font.PLAIN, 15));
			lblTelfono.setBounds(24, 129, 64, 22);
		}
		return lblTelfono;
	}
	private JTextField getTextTelefono() {
		if (textTelefono == null) {
			textTelefono = new JTextField();
			textTelefono.setBounds(127, 131, 163, 20);
			textTelefono.setColumns(10);
		}
		return textTelefono;
	}
	private JLabel getLblContrasea() {
		if (lblContrasea == null) {
			lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setLabelFor(getPsContraseña());
			lblContrasea.setDisplayedMnemonic('C');
			lblContrasea.setFont(new Font("Dialog", Font.PLAIN, 15));
			lblContrasea.setBounds(10, 56, 120, 22);
		}
		return lblContrasea;
	}
	private JLabel getLblRepetirContrasea() {
		if (lblRepetirContrasea == null) {
			lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a:");
			lblRepetirContrasea.setLabelFor(getPsRepetirContraseña());
			lblRepetirContrasea.setDisplayedMnemonic('p');
			lblRepetirContrasea.setFont(new Font("Dialog", Font.PLAIN, 15));
			lblRepetirContrasea.setBounds(10, 89, 138, 22);
		}
		return lblRepetirContrasea;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Registrarse");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					comprobar();
				}
			});
			btnSiguiente.setMnemonic('R');
			btnSiguiente.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnSiguiente.setBounds(417, 278, 109, 23);
		}
		return btnSiguiente;
	}
	
	/**
	 * Comprueba que todos los campos sean correctos
	 */
	@SuppressWarnings("deprecation")
	private void comprobar(){
		if(camposVacios() == false)
		{
			registro = false;
		} else
			try {
				if(cc.recorrerNif(textNIF.getText(), vp.getClient()) == false)
				{
					registro = false;
					JOptionPane.showMessageDialog(null,"El NIF que ha introducido ya está registrado");
				}
				if(cc.recorrerUsuario(textNombreUsuario.getText(), vp.getClient()) == false)
				{
					registro = false;
					JOptionPane.showMessageDialog(null, "El nombre de usuario que ha introducido ya está registrado");
				}
				if(cc.NIF(textNIF) == true && cc.telefono(textTelefono) == true && cc.usuario(textNombreUsuario) == true 
						&& cc.contraseña(psContraseña) == true && cc.comprobarContraseñas(psContraseña, psRepetirContraseña) == true 
						&& cc.recorrerNif(textNIF.getText(), vp.getClient())  == true && cc.recorrerUsuario(textNombreUsuario.getText(), vp.getClient()) == true)
				{
					registro = true;
				}
			} catch (HeadlessException e) {
				e.printStackTrace();
			}
		if(registro == true){
			client = new Cliente("NOVIP",textNombre.getText(), textApellidos.getText(),textNIF.getText(),textNombreUsuario.getText(), psContraseña.getText(), textTelefono.getText(),0, 0);
			client.grabarRegistro("clientes", client);
			JOptionPane.showMessageDialog(null, "Bienvenido a EII Market.\nPuede visitar nuestros catálogos y escoger los productos que más le gusten.");
			dispose();
		}
	}
	
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCancelar.setMnemonic('L');
			btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnCancelar.setBounds(536, 278, 102, 23);
		}
		return btnCancelar;
	}
	private JPasswordField getPsContraseña() {
		if (psContraseña == null) {
			psContraseña = new JPasswordField();
			psContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
			psContraseña.setEchoChar('*');
			psContraseña.setBounds(171, 59, 191, 20);
		}
		return psContraseña;
	}
	private JPasswordField getPsRepetirContraseña() {
		if (psRepetirContraseña == null) {
			psRepetirContraseña = new JPasswordField();
			psRepetirContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
			psRepetirContraseña.setEchoChar('*');
			psRepetirContraseña.setBounds(171, 92, 191, 20);
		}
		return psRepetirContraseña;
	}
	
	/**
	 * Comprueba que no haya campos vacíos.
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private boolean camposVacios(){
		if(textNombre.getText().length() == 0 || textApellidos.getText().length() == 0 || textNIF.getText().length() == 0
				|| textNombreUsuario.getText().length() == 0 || psContraseña.getText().length() == 0 || psRepetirContraseña.getText().length() == 0)
		{
			JOptionPane.showMessageDialog(null, "Hay campos vacíos");
			return false;
		}	
		else
		{
			return true;
		}
	}
}
