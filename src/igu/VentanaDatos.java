package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import logica.Cliente;
import logica.ComprobarCampos;

import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.Toolkit;

@SuppressWarnings({ "serial", "unused" })
public class VentanaDatos extends JDialog {
	private JTextField textNombre;
	private JLabel lblApellidos;
	private JTextField textApellidos;
	private JLabel lbNif;
	private JTextField textNif;
	private JLabel lblTarjetaBancaria;
	private JTextField textTarjeta;
	private JLabel lbTelefono;
	private JTextField textTelefono;
	private JButton btCancelar;
	private JButton btSiguiente;
	private InicioSesion is;
	private VentanaPrincipal vp;
	private VentanaCarro vc;
	private ComprobarCampos cc;
	private VentanaFactura vf;
	private String nombre;
	private String apellidos;
	private String NIF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel;
	


	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getNIF() {
		return NIF;
	}
	
	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public VentanaDatos(VentanaCarro vcc, InicioSesion iss, VentanaPrincipal vpp) throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDatos.class.getResource("/img/logo.jpg.png")));
		vp = vpp;
		vc = vcc;	
		is = iss;
		cc = new ComprobarCampos();
		
	
		setTitle("Introducir datos");
		setBounds(100, 100, 578, 282);
		getContentPane().setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre: ");
			lblNombre.setDisplayedMnemonic('N');
			lblNombre.setLabelFor(getTextNombre());
			lblNombre.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNombre.setBounds(10, 46, 68, 29);
			getContentPane().add(lblNombre);
		}
		getContentPane().add(getTextNombre());
		getContentPane().add(getLblApellidos());
		getContentPane().add(getTextApellidos());
		getContentPane().add(getLbNif());
		getContentPane().add(getTextNif());
		getContentPane().add(getLblTarjetaBancaria());
		getContentPane().add(getTextTarjeta());
		getContentPane().add(getLbTelefono());
		getContentPane().add(getTextTelefono());
		getContentPane().add(getBtCancelar());
		getContentPane().add(getBtSiguiente());
		getContentPane().add(getLblNewLabel());
		setLocationRelativeTo(null);
		
		registrado();
	}
	private JTextField getTextNombre() {
		if (textNombre == null) {
			textNombre = new JTextField();
			textNombre.setBounds(155, 46, 192, 29);
			textNombre.setColumns(10);
		}
		return textNombre;
	}
	private JLabel getLblApellidos() {
		if (lblApellidos == null) {
			lblApellidos = new JLabel("Apellidos: ");
			lblApellidos.setDisplayedMnemonic('A');
			lblApellidos.setLabelFor(getTextApellidos());
			lblApellidos.setFont(new Font("Dialog", Font.BOLD, 14));
			lblApellidos.setBounds(10, 86, 104, 29);
		}
		return lblApellidos;
	}
	private JTextField getTextApellidos() {
		if (textApellidos == null) {
			textApellidos = new JTextField();
			textApellidos.setBounds(155, 88, 296, 29);
			textApellidos.setColumns(10);
		}
		return textApellidos;
	}
	private JLabel getLbNif() {
		if (lbNif == null) {
			lbNif = new JLabel("NIF:");
			lbNif.setDisplayedMnemonic('F');
			lbNif.setLabelFor(getTextNif());
			lbNif.setFont(new Font("Dialog", Font.BOLD, 14));
			lbNif.setBounds(10, 126, 112, 29);
		}
		return lbNif;
	}
	private JTextField getTextNif() {
		if (textNif == null) {
			textNif = new JTextField();
			textNif.setBounds(155, 128, 192, 29);
			textNif.setColumns(10);
		}
		return textNif;
	}
	private JLabel getLblTarjetaBancaria() {
		if (lblTarjetaBancaria == null) {
			lblTarjetaBancaria = new JLabel("Tarjeta bancaria:");
			lblTarjetaBancaria.setLabelFor(getTextTarjeta());
			lblTarjetaBancaria.setDisplayedMnemonic('b');
			lblTarjetaBancaria.setFont(new Font("Dialog", Font.BOLD, 14));
			lblTarjetaBancaria.setBounds(10, 166, 125, 29);
		}
		return lblTarjetaBancaria;
	}
	private JTextField getTextTarjeta() {
		if (textTarjeta == null) {
			textTarjeta = new JTextField();
			textTarjeta.setBounds(155, 168, 192, 29);
			textTarjeta.setColumns(10);
		}
		return textTarjeta;
	}
	private JLabel getLbTelefono() {
		if (lbTelefono == null) {
			lbTelefono = new JLabel("Tel\u00E9fono:");
			lbTelefono.setLabelFor(getTextTelefono());
			lbTelefono.setDisplayedMnemonic('T');
			lbTelefono.setFont(new Font("Dialog", Font.BOLD, 14));
			lbTelefono.setBounds(10, 206, 125, 29);
		}
		return lbTelefono;
	}
	private JTextField getTextTelefono() {
		if (textTelefono == null) {
			textTelefono = new JTextField();
			textTelefono.setBounds(155, 208, 192, 29);
			textTelefono.setColumns(10);
		}
		return textTelefono;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Dialog", Font.PLAIN, 13));
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btCancelar.setToolTipText("Cancelar la compra");
			btCancelar.setMnemonic('C');
			btCancelar.setBounds(463, 214, 89, 23);
		}
		return btCancelar;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(cc.NIF(textNif)==false || cc.telefono(textTelefono) == false || camposVacios() == false || moroso() == true)
					{
						
					}
					else
					{
						guardar();
						mostrarPuntos();				
					}
				}
			});
			btSiguiente.setMnemonic('S');
			btSiguiente.setFont(new Font("Dialog", Font.PLAIN, 13));
			btSiguiente.setBounds(364, 214, 87, 23);
		}
		return btSiguiente;
	}
	
	private boolean moroso(){
		for(int j=0; j<vp.getMoro().size(); j++)
		{
			if(vp.getMoro().get(j).equals(textNif.getText()))
			{
				JOptionPane.showMessageDialog(null, "Usted es un cliente MOROSO, o paga lo que debe o no puede comprar productos.");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que muestra la ventana puntos
	 */
	private void mostrarPuntos(){
		VentanaPuntos vpuntos = new VentanaPuntos(this, vp, vc);
		vpuntos.setVisible(true);
	}
	
	/**
	 * Método que alamcena en los atributos los los datos introducidos
	 */
	private void guardar(){
		nombre = textNombre.getText();
		apellidos = textApellidos.getText();
		NIF = textNif.getText();
	}
	
	/**
	 * Método que comprueba si está registrado y ha iniciado sesión  para que salgan los datos automáticamente
	 */
	private void registrado(){
		if(vp.regis == true)
		{
			for(int i=0; i<vc.getCli().size(); i++)
			{
				if(vc.getCli().get(i).getUsuario().equals(vp.getNombreUsuario()))
				{
					textNombre.setText(vc.getCli().get(i).getNombre());
					textApellidos.setText(vc.getCli().get(i).getApellidos());
					textNif.setText(vc.getCli().get(i).getNIF());
					textTelefono.setText(vc.getCli().get(i).getTelefono());
					
					textNombre.setEditable(false);
					textApellidos.setEditable(false);
					textNif.setEditable(false);
					textTelefono.setEditable(false);
				}
			}
		}
		
	}
	
	/**
	 * Comprueba que no haya campos vacíos
	 * @return
	 */
	private boolean camposVacios(){
		if(textNombre.getText().isEmpty() || textApellidos.getText().isEmpty() || textNif.getText().isEmpty() || textTelefono.getText().isEmpty() || textTarjeta.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Hay campos de texto vacíos.\nPor favor rellene todos los campos de texto.");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Rellene los siguientes campos de texto:");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
			lblNewLabel.setBounds(10, 11, 523, 29);
		}
		return lblNewLabel;
	}
	
	
}
