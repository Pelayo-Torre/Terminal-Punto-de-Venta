package igu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import logica.Cliente;
import logica.ComprobarCampos;
import logica.FileHelper;
import java.awt.Toolkit;
@SuppressWarnings({ "unused", "serial" })
public class InicioSesion extends JDialog {

	private boolean cerrar = false;
	
	private JPanel contentPane;
	private JLabel lblBienvenido;
	private JLabel lblInicieSesin;
	private JLabel lbInicioSesion;
	private JTextField txtNombreUsuario;
	private JLabel lbContraseña;
	private JPasswordField psContraseña;
	private JButton btInicioSesion;
	private JLabel lbltodavaNoEsts;
	private JLabel lblTendrsOfertasDe;
	private JLabel lblPodrsAlmacenar;
	private JLabel lblNewLabel;
	private JButton btRegistrate;
	private VentanaPrincipal vp;

	private JButton btCancelar;
	private JLabel lblDescuentos;
	private FileHelper file;
	private ComprobarCampos cc;
	
	public boolean isCerrar(){
		return cerrar;
	}
	

	
	
	/**
	 * Create the frame.
	 */
	public InicioSesion(VentanaPrincipal vpp) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/img/logo.jpg.png")));
		file= new FileHelper();
		cc = new ComprobarCampos();
		vp = vpp;
		setResizable(false);
		setTitle("Inicio Sesi\u00F3n");
		setBounds(100, 100, 759, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblBienvenido());
		contentPane.add(getLblInicieSesin());
		contentPane.add(getLbInicioSesion());
		contentPane.add(getTxtNombreUsuario());
		contentPane.add(getLbContraseña());
		contentPane.add(getPsContraseña());
		contentPane.add(getBtInicioSesion());
		contentPane.add(getLbltodavaNoEsts());
		contentPane.add(getLblTendrsOfertasDe());
		contentPane.add(getLblPodrsAlmacenar());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtRegistrate());
		contentPane.add(getBtCancelar());
		contentPane.add(getLblDescuentos());
		setLocationRelativeTo(null);
		if(vp.isInicioSesion() == true)
		{
			btInicioSesion.setEnabled(false);
		}
	}
	private JLabel getLblBienvenido() {
		if (lblBienvenido == null) {
			lblBienvenido = new JLabel("Bienvenido");
			lblBienvenido.setForeground(Color.BLACK);
			lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 26));
			lblBienvenido.setHorizontalAlignment(SwingConstants.LEFT);
			lblBienvenido.setBounds(24, 30, 190, 44);
		}
		return lblBienvenido;
	}
	private JLabel getLblInicieSesin() {
		if (lblInicieSesin == null) {
			lblInicieSesin = new JLabel("Inicie Sesi\u00F3n:");
			lblInicieSesin.setFont(new Font("Dialog", Font.PLAIN, 13));
			lblInicieSesin.setBounds(24, 86, 137, 19);
		}
		return lblInicieSesin;
	}
	private JLabel getLbInicioSesion() {
		if (lbInicioSesion == null) {
			lbInicioSesion = new JLabel("Nombre Usuario:");
			lbInicioSesion.setDisplayedMnemonic('N');
			lbInicioSesion.setLabelFor(getTxtNombreUsuario());
			lbInicioSesion.setFont(new Font("Dialog", Font.PLAIN, 15));
			lbInicioSesion.setBounds(24, 116, 155, 33);
		}
		return lbInicioSesion;
	}
	private JTextField getTxtNombreUsuario() {
		if (txtNombreUsuario == null) {
			txtNombreUsuario = new JTextField();
			txtNombreUsuario.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtNombreUsuario.setBounds(24, 146, 222, 33);
			txtNombreUsuario.setColumns(10);
		}
		return txtNombreUsuario;
	}
	private JLabel getLbContraseña() {
		if (lbContraseña == null) {
			lbContraseña = new JLabel("Contrase\u00F1a:");
			lbContraseña.setLabelFor(getPsContraseña());
			lbContraseña.setDisplayedMnemonic('s');
			lbContraseña.setFont(new Font("Dialog", Font.PLAIN, 15));
			lbContraseña.setBounds(24, 190, 155, 33);
		}
		return lbContraseña;
	}
	private JPasswordField getPsContraseña() {
		if (psContraseña == null) {
			psContraseña = new JPasswordField();
			psContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
			psContraseña.setEchoChar('*');
			psContraseña.setBounds(24, 221, 222, 33);
		}
		return psContraseña;
	}
	private JButton getBtInicioSesion() {
		if (btInicioSesion == null) {
			btInicioSesion = new JButton("Iniciar Sesi\u00F3n");
			btInicioSesion.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					camposVacios();
					try {
						if(cc.recorrer(txtNombreUsuario.getText(), psContraseña.getText(), vp.getClient()) == true)
						{
							if(vp.abrir == true)
							{
								vp.regis = true;
								vp.nombreUsuario = txtNombreUsuario.getText();
								vp.abrir = false;
								dispose();
								JOptionPane.showMessageDialog(null, "Bienvenido");
								vp.getBtInicio().setVisible(true);
								vp.getBtInicio().setText(txtNombreUsuario.getText());
								vp.setInicioSesionTrue();
							}
							else
							{
								btInicioSesion.setEnabled(false);
							}
						}
						else
						{
							
							JOptionPane.showMessageDialog(null, "Los datos que ha introducido son inválidos.\nPor favor introduzca los datos correctos.");						
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			btInicioSesion.setFont(new Font("Dialog", Font.PLAIN, 15));
			btInicioSesion.setMnemonic('I');
			btInicioSesion.setBounds(24, 276, 137, 33);
		}
		return btInicioSesion;
	}
	private JLabel getLbltodavaNoEsts() {
		if (lbltodavaNoEsts == null) {
			lbltodavaNoEsts = new JLabel("\u00BFTodav\u00EDa no est\u00E1s registrado?");
			lbltodavaNoEsts.setFont(new Font("Dialog", Font.PLAIN, 18));
			lbltodavaNoEsts.setBounds(370, 39, 314, 33);
		}
		return lbltodavaNoEsts;
	}
	private JLabel getLblTendrsOfertasDe() {
		if (lblTendrsOfertasDe == null) {
			lblTendrsOfertasDe = new JLabel("- Tendr\u00E1s ofertas de los art\u00EDculos en cada sesi\u00F3n.");
			lblTendrsOfertasDe.setFont(new Font("Dialog", Font.PLAIN, 15));
			lblTendrsOfertasDe.setBounds(370, 89, 379, 27);
		}
		return lblTendrsOfertasDe;
	}
	private JLabel getLblPodrsAlmacenar() {
		if (lblPodrsAlmacenar == null) {
			lblPodrsAlmacenar = new JLabel("- Podr\u00E1s almacenar y canjear puntos.");
			lblPodrsAlmacenar.setFont(new Font("Dialog", Font.PLAIN, 15));
			lblPodrsAlmacenar.setBounds(370, 127, 379, 27);
		}
		return lblPodrsAlmacenar;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("- Podr\u00E1s aprovecharte de las \u00FAltimas novedades.");
			lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
			lblNewLabel.setBounds(370, 165, 379, 27);
		}
		return lblNewLabel;
	}
	private JButton getBtRegistrate() {
		if (btRegistrate == null) {
			btRegistrate = new JButton("Reg\u00EDstrate");
			btRegistrate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaRegistro();
				}
			});
			btRegistrate.setMnemonic('R');
			btRegistrate.setFont(new Font("Dialog", Font.PLAIN, 15));
			btRegistrate.setBounds(370, 276, 155, 33);
		}
		return btRegistrate;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btCancelar.setMnemonic('C');
			btCancelar.setFont(new Font("Dialog", Font.PLAIN, 15));
			btCancelar.setBounds(552, 276, 128, 33);
		}
		return btCancelar;
	}
	private JLabel getLblDescuentos() {
		if (lblDescuentos == null) {
			lblDescuentos = new JLabel("- Descuentos");
			lblDescuentos.setFont(new Font("Dialog", Font.PLAIN, 15));
			lblDescuentos.setBounds(370, 203, 379, 27);
		}
		return lblDescuentos;
	}
	
	/**
	 * Método que muestra la ventana registro
	 */
	private void mostrarVentanaRegistro(){
		VentanaRegistro vr = new VentanaRegistro(this, vp);
		vr.setVisible(true);
	}
	
	/**
	 * Método que comprueba que no haya campos vacíos.
	 */
	@SuppressWarnings("deprecation")
	private void camposVacios(){
		if(txtNombreUsuario.getText().length() == 0 || psContraseña.getText().length() == 0)
		{
			JOptionPane.showMessageDialog(null, "Campos de texto vacíos.");
		}
	}
}


