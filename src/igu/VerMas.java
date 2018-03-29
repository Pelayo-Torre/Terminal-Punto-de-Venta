package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import logica.Articulo;
import logica.Tabla;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings({ "unused", "serial" })
public class VerMas extends JDialog {
	private JLabel lbImagen;
	private JLabel lblNewLabel_1;
	private JLabel lbPrecio;
	private JScrollPane scrollPane;
	private JButton btCerrar;
	private Tabla tabla;
	private VentanaPrincipal vp;
	private JTextArea textArea;
	private JLabel lbNombre;

	
	/**
	 * Create the dialog.
	 */
	public VerMas(VentanaPrincipal vpp) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerMas.class.getResource("/img/logo.jpg.png")));
		setTitle("Artículo");
		vp = vpp;
		setBounds(100, 100, 711, 305);
		getContentPane().setLayout(null);
		getContentPane().add(getLbImagen());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLbPrecio());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtCerrar());		
		getContentPane().add(getLbNombre());
		setLocationRelativeTo(null);
	}
	private JLabel getLbImagen() {
		if (lbImagen == null) {
			lbImagen = new JLabel("");
			lbImagen.setHorizontalAlignment(SwingConstants.CENTER);
			lbImagen.setBounds(10, 11, 205, 244);
		}
		return lbImagen;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Precio:");
			lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(233, 235, 46, 20);
		}
		return lblNewLabel_1;
	}
	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("");
			lbPrecio.setFont(new Font("Dialog", Font.PLAIN, 13));
			lbPrecio.setBounds(283, 235, 85, 20);
		}
		return lbPrecio;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(233, 50, 452, 161);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JButton getBtCerrar() {
		if (btCerrar == null) {
			btCerrar = new JButton("Cerrar");
			btCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btCerrar.setMnemonic('C');
			btCerrar.setFont(new Font("Dialog", Font.BOLD, 13));
			btCerrar.setBounds(596, 232, 89, 23);
		}
		return btCerrar;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setWrapStyleWord(true);
			textArea.setFont(new Font("Dialog", Font.PLAIN, 14));
			textArea.setLineWrap(true);
			textArea.setEditable(false);
		}
		return textArea;
	}
	
	/**
	 * Método que busca el artículo y lo muestra
	 * @param tabla
	 * @param articulos
	 */
	public void buscarArticulos(JTable tabla, ArrayList<Articulo> articulos){
		DecimalFormat decimal = new DecimalFormat("0.00");
		if(tabla.getSelectedRow() != -1)
		{
			String nombre = (String) tabla.getValueAt(tabla.getSelectedRow(), 1);
			for(int j=0; j<articulos.size(); j++)
			{
				if(articulos.get(j).getDenominacion().equals(nombre))
				{
					lbNombre.setText(articulos.get(j).getDenominacion());
					textArea.setText(articulos.get(j).getDescripcion());
					
					if(vp.isConVid() == true && vp.getTodosArticulos().get(j).getCodigo().startsWith("CV-")
							|| vp.isFotVi() == true && vp.getTodosArticulos().get(j).getCodigo().startsWith("FV-") 
							|| vp.isTef() == true && vp.getTodosArticulos().get(j).getCodigo().startsWith("TM-")
							|| vp.isOrdena() == true && vp.getTodosArticulos().get(j).getCodigo().startsWith("OT-")
							|| vp.isVideoVigi() == true && vp.getTodosArticulos().get(j).getCodigo().startsWith("VI-"))
					{		
						String precio = decimal.format(articulos.get(j).getPrecio()*0.9); 	
						lbPrecio.setText(precio+"€");
					}
					else
					{
						lbPrecio.setText(String.valueOf(articulos.get(j).getPrecio())+"€");
					}
					
					ImageIcon foto = new ImageIcon(getClass().getResource("/img/"+articulos.get(j).getCodigo()+".jpg"));
					Image img = foto.getImage();
					Image img2 = img.getScaledInstance(125, 135, Image.SCALE_SMOOTH);
					ImageIcon foto2 = new ImageIcon(img2);
					lbImagen.setIcon(foto2);
					lbImagen.setHorizontalAlignment(SwingConstants.CENTER);
				}
			}
		}
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("");
			lbNombre.setFont(new Font("Dialog", Font.BOLD, 17));
			lbNombre.setBounds(233, 11, 353, 28);
		}
		return lbNombre;
	}
}
