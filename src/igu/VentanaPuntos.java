package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import logica.Cliente;
import logica.ComprobarCampos;
import logica.Regalo;

import java.awt.Toolkit;

@SuppressWarnings({ "unused", "serial" })
public class VentanaPuntos extends JDialog {
	private JLabel lblNewLabel;
	private JPanel panel;
	private JRadioButton rbDescuento;
	private JRadioButton rbRegalos;
	private JRadioButton rbAcumular;
	private JButton btRegalos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btCancelar;
	private JButton btConfirmar;
	private JLabel lbDescuento;
	private JLabel lblNewLabel_2;
	private JLabel lbAcumular;

	private VentanaPrincipal vp;
	private VentanaCarro vc;
	private VentanaDatos vd;
	private ComprobarCampos cc;
	
	private boolean descuento = false;
	private boolean acumular = false;
	
	public void modificarDescuento(){
		descuento = false;
	}
	
	public void modificarAcumular(){
		acumular = false;
	}
	
	public boolean isDescuento() {
		return descuento;
	}
	public boolean isAcumular() {
		return acumular;
	}
	
	
	/**
	 * Create the dialog.
	 */
	public VentanaPuntos(VentanaDatos vdd, VentanaPrincipal vpp, VentanaCarro vcc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPuntos.class.getResource("/img/logo.jpg.png")));
		cc = new ComprobarCampos();
		vp = vpp;
		vc = vcc;
		vd = vdd;
		setTitle("Canjear puntos");
		setBounds(100, 100, 590, 312);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getPanel());
		setLocationRelativeTo(null);
		registrado();
		btRegalos.setEnabled(true);
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Escoja la forma de canjear sus puntos:");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
			lblNewLabel.setBounds(10, 11, 478, 33);
		}
		return lblNewLabel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(null);
			panel.setBounds(10, 45, 554, 221);
			panel.add(getRbDescuento());
			panel.add(getRbRegalos());
			panel.add(getRbAcumular());
			panel.add(getBtRegalos());
			panel.add(getBtCancelar());
			panel.add(getBtConfirmar());
			panel.add(getLbDescuento());
			panel.add(getLblNewLabel_2());
			panel.add(getLbAcumular());
		}
		return panel;
	}
	private JRadioButton getRbDescuento() {
		if (rbDescuento == null) {
			rbDescuento = new JRadioButton("Descuento en valor monetario.");
			rbDescuento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btRegalos.setEnabled(false);
				}
			});
			buttonGroup.add(rbDescuento);
			rbDescuento.setToolTipText("Se descontar\u00E1 1\u20AC por punto.");
			rbDescuento.setMnemonic('D');
			rbDescuento.setFont(new Font("Dialog", Font.PLAIN, 15));
			rbDescuento.setBounds(6, 67, 303, 23);
		}
		return rbDescuento;
	}
	private JRadioButton getRbRegalos() {
		if (rbRegalos == null) {
			rbRegalos = new JRadioButton("Canjearse en art\u00EDculos de regalo.");
			rbRegalos.setSelected(true);
			rbRegalos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btRegalos.setEnabled(true);
				}
			});
			buttonGroup.add(rbRegalos);
			rbRegalos.setMnemonic('j');
			rbRegalos.setFont(new Font("Dialog", Font.PLAIN, 15));
			rbRegalos.setBounds(6, 7, 255, 23);
		}
		return rbRegalos;
	}
	private JRadioButton getRbAcumular() {
		if (rbAcumular == null) {
			rbAcumular = new JRadioButton("Acumular para futuras compras.");
			rbAcumular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btRegalos.setEnabled(false);
				}
			});
			buttonGroup.add(rbAcumular);
			rbAcumular.setMnemonic('l');
			rbAcumular.setFont(new Font("Dialog", Font.PLAIN, 15));
			rbAcumular.setBounds(6, 127, 303, 23);
		}
		return rbAcumular;
	}
	private JButton getBtRegalos() {
		if (btRegalos == null) {
			btRegalos = new JButton("Regalos");
			btRegalos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaRegalos();
				}
			});
			btRegalos.setToolTipText("Haga click para mostrar los regalos.");
			btRegalos.setMnemonic('R');
			btRegalos.setFont(new Font("Dialog", Font.BOLD, 15));
			btRegalos.setEnabled(false);
			btRegalos.setBounds(182, 191, 95, 23);
		}
		return btRegalos;
	}
	
	/**
	 * Método para generar la ventana regalos.
	 */
	private void mostrarVentanaRegalos(){
		VentanaRegalos vr = new VentanaRegalos(this, vp, vd,vc );
		vr.setVisible(true);
	}
	
	
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btCancelar.setMnemonic('C');
			btCancelar.setFont(new Font("Dialog", Font.BOLD, 15));
			btCancelar.setBounds(459, 191, 95, 23);
		}
		return btCancelar;
	}
	private JButton getBtConfirmar() {
		if (btConfirmar == null) {
			btConfirmar = new JButton("Confirmar Compra");
			btConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de confirmar la compra?","Confirmar compra", JOptionPane.YES_OPTION);
					if(respuesta == JOptionPane.YES_OPTION)
					{
						vd.dispose();
						dispose();
						if(rbDescuento.isSelected())
						{
							descuento = true;
							vp.getReg().clear();
							mostrarFactura();
						}
						else if(rbAcumular.isSelected())
						{
							try {
								modificarPuntos();
								acumular = true;
								vp.getReg().clear();
								if(serVip() == true)
								{
									JOptionPane.showMessageDialog(null, "Por ser VIP, ha obtenido: "+puntosDobles()+"\nSi no fuese VIP, hubiese obtenido: "+puntosCarro());
								}
								mostrarFactura();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else
						{
							mostrarFactura();
						}
					}
				}
			});
			btConfirmar.setFont(new Font("Dialog", Font.BOLD, 15));
			btConfirmar.setMnemonic('n');
			btConfirmar.setBounds(288, 191, 161, 23);
		}
		return btConfirmar;
	}
	
	/**
	 * Método para generar la ventana factura.
	 */
	private void mostrarFactura(){
		VentanaFactura f = new VentanaFactura(this, vd, vc, vp);
		f.setVisible(true);
	}
	
	private JLabel getLbDescuento() {
		if (lbDescuento == null) {
			lbDescuento = new JLabel("Se le descontar\u00E1 1\u20AC por punto acumulado.");
			lbDescuento.setFont(new Font("Dialog", Font.PLAIN, 13));
			lbDescuento.setBounds(37, 97, 517, 23);
		}
		return lbDescuento;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Podr\u00E1 canjear sus puntos en regalos siempre y cuando tenga los puntos suficientes.");
			lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(37, 37, 507, 23);
		}
		return lblNewLabel_2;
	}
	private JLabel getLbAcumular() {
		if (lbAcumular == null) {
			lbAcumular = new JLabel("Los puntos que consiga se le acumular\u00E1n para la pr\u00F3xima compra.");
			lbAcumular.setFont(new Font("Dialog", Font.PLAIN, 13));
			lbAcumular.setBounds(37, 157, 507, 23);
		}
		return lbAcumular;
	}
	
	/**
	 * Método para saber si el usuario está o no registrado y según sea, elegir las opciones correspondientes.
	 */
	private void registrado(){
		if(cc.recorrerNif(vd.getNIF(), vp.getClient()) == true){
			rbDescuento.setVisible(false);
			rbAcumular.setVisible(false);
			lbDescuento.setVisible(false);
			lbAcumular.setVisible(false);
			btRegalos.setVisible(true);
		}
	}
	
	/**
	 * Método que te calcula los puntos de los artículos del carrito
	 * @return puntos
	 */
	private int puntosCarro(){
		int puntos = 0;
		for(int i=0; i<vc.getArticulosCarro().size(); i++)
		{
			puntos = puntos + vc.getArticulosCarro().get(i).getPuntosCompra() * vc.getArticulosCarro().get(i).getStock();
		}
		return puntos;
	}
	
	/**
	 * Método que modifica los puntos del cliente si ha elegido la opción de acumular puntos
	 * @throws IOException
	 */
	private void modificarPuntos() throws IOException{
		BufferedWriter write = new BufferedWriter(new FileWriter("files/clientes.dat"));
		write.write("");
		write.close();
		Cliente cliente;
		for(int i=0; i<vp.getClient().size(); i++)
		{
			
			if(vp.getClient().get(i).getNIF().equals(vd.getNIF()))
			{
				if(vp.getClient().get(i).getVip().equals("VIP"))
				{
					cliente = new Cliente(vp.getClient().get(i).getVip(),vp.getClient().get(i).getNombre(), vp.getClient().get(i).getApellidos(),
							vp.getClient().get(i).getNIF(), vp.getClient().get(i).getUsuario(),
							vp.getClient().get(i).getContraseña(), vp.getClient().get(i).getTelefono(),
							vp.getClient().get(i).getTarjeta(),(puntosCarro()*2)+vp.getClient().get(i).getPuntos());
					cliente.grabarRegistro("clientes", cliente);
				}
				else
				{
					cliente = new Cliente(vp.getClient().get(i).getVip(),vp.getClient().get(i).getNombre(), vp.getClient().get(i).getApellidos(),
							vp.getClient().get(i).getNIF(), vp.getClient().get(i).getUsuario(),
							vp.getClient().get(i).getContraseña(), vp.getClient().get(i).getTelefono(),
							vp.getClient().get(i).getTarjeta(),puntosCarro()+vp.getClient().get(i).getPuntos());
					cliente.grabarRegistro("clientes", cliente);
				}			
			}
			else
			{
				cliente = new Cliente(vp.getClient().get(i).getVip(), vp.getClient().get(i).getNombre(), vp.getClient().get(i).getApellidos(),
						vp.getClient().get(i).getNIF(), vp.getClient().get(i).getUsuario(),
						vp.getClient().get(i).getContraseña(), vp.getClient().get(i).getTelefono(),
						vp.getClient().get(i).getTarjeta(),vp.getClient().get(i).getPuntos());
				
				cliente.grabarRegistro("clientes", cliente);
			}
			
			
		}
	}
	
	/**
	 * Método que comprueba si el usuario es vip o no y duplica o no los puntos
	 * @return puntos del usuario en cada caso.
	 */
	private int puntosDobles(){
		int puntos = 0;
		puntos = puntosCarro()*2;
		return puntos;
	}
	
	private boolean serVip(){
		for(int i=0; i<vp.getClient().size(); i++)
		{
			if(vp.getClient().get(i).getVip().equals("VIP") && vp.getClient().get(i).getNIF().equals(vd.getNIF()))
			{
				return true;
			}
		}
		return false;
	}
	
}
