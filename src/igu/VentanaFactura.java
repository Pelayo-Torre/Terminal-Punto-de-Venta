package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import logica.Factura;
import logica.Tabla;

import java.awt.Toolkit;

@SuppressWarnings({ "serial", "unused" })
public class VentanaFactura extends JDialog {
	private JTextArea txtrGraciasPorConfiar;
	private JTextField textCodigo;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private VentanaPuntos vpunto;
	private VentanaCarro vc;
	private VentanaPrincipal vp;
	private Factura p;
	private VentanaDatos vd;
	private Tabla tabla;
	GregorianCalendar calendar = new GregorianCalendar();
	
	private String nombre;
	private String apellidos;
	private String NIF;

	

	/**
	 * Create the dialog.
	 */
	public VentanaFactura(VentanaPuntos vpuntos, VentanaDatos vdd, VentanaCarro vcc, VentanaPrincipal vpp) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaFactura.class.getResource("/img/logo.jpg.png")));
		p = new Factura();
		vp = vpp;
		vc = vcc;
		vd = vdd;
		vpunto = vpuntos;
		tabla = new Tabla();
		setTitle("Factura");
		setBounds(100, 100, 459, 218);
		getContentPane().setLayout(null);
		getContentPane().add(getTxtrGraciasPorConfiar());
		getContentPane().add(getTextCodigo());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		textCodigo.setText(generarCodigo());
		setLocationRelativeTo(null);
	}
	private JTextArea getTxtrGraciasPorConfiar() {
		if (txtrGraciasPorConfiar == null) {
			txtrGraciasPorConfiar = new JTextArea();
			txtrGraciasPorConfiar.setText("Gracias por confiar en nosotros. Su pedido llegar\u00E1 en los pr\u00F3ximos d\u00EDas.\r\nSu c\u00F3digo de reclamaci\u00F3n es:");
			txtrGraciasPorConfiar.setFont(new Font("Dialog", Font.PLAIN, 13));
			txtrGraciasPorConfiar.setBounds(10, 11, 423, 53);
		}
		return txtrGraciasPorConfiar;
	}
	private JTextField getTextCodigo() {
		if (textCodigo == null) {
			textCodigo = new JTextField();
			textCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			textCodigo.setFont(new Font("Dialog", Font.BOLD, 18));
			textCodigo.setEditable(false);
			textCodigo.setBounds(10, 75, 423, 42);
			textCodigo.setColumns(10);
		}
		return textCodigo;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Aceptar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			btnNewButton.setMnemonic('A');
			btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 13));
			btnNewButton.setBounds(344, 145, 89, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Factura");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						p.generarFactura(vd.getNombre(),vd.getApellidos(), vd.getNIF(), vc.getArticulosCarro(),vp.getReg(),vp.getClient(), vp.isConVid(), vp.isFotVi(), vp.isTef(), vp.isOrdena(), vp.isVideoVigi(), vpunto.isDescuento(), vpunto.isAcumular());
						btnNewButton_1.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Gracias por su compra");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
					
				}
			});
			btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 13));
			btnNewButton_1.setMnemonic('F');
			btnNewButton_1.setToolTipText("Haga click para generar la factura.");
			btnNewButton_1.setBounds(245, 145, 89, 23);
		}
		return btnNewButton_1;
	}
	
	/**
	 * Genera un String de caracteres alfanuméricos aleatorios de longitud 10.
	 * @return 
	 */
	private String generarCodigo(){
		String base="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		String codigo="";
		Random r=new Random();
		for (int i=0;i<10;i++)
			codigo+= base.charAt(r.nextInt(base.length()));		
		return codigo;
		
	}
	
	/**
	 * Método para inicializar la aplicación para un nuevo usuario.
	 */
	public void inicializar(){
		dispose();
		vc.dispose();
		vd.dispose();
		vpunto.dispose();
		vc.getArticulosCarro().clear();
		tabla.limpiar(vc.getTablaCarro());
		vp.setInicioSesionFalse();
		vp.getCarro().clear();
		vp.getReg().clear();;
		vp.getBtInicio().setVisible(false);
		vp.regis = false;
		vp.abrir = true;
		vp.getRepetidos().clear();
		vpunto.modificarAcumular();
		vpunto.modificarDescuento();
	}
}
