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
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import logica.ComprobarCampos;
import logica.Regalo;
import logica.Tabla;

import java.awt.Toolkit;

@SuppressWarnings({ "serial", "unused" })
public class VentanaRegalos extends JDialog {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JScrollPane scrollRegalos;
	private JScrollPane scrollSeleccion;
	private JTable tablaRegalos;
	private JTable tablaRegalosSeleccionados;
	private JButton btCancelar;
	private JButton btnNewButton_3;
	private JPanel panel_2;
	private JButton btEliminarRegalo;
	private JButton btEliminarTodo;
	private JLabel lbPuntos;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private VentanaPuntos vpunto;
	private VentanaPrincipal vp;
	private DefaultTableModel modelo;
	private Tabla tabla;
	private VentanaDatos vd;
	private VentanaCarro vc;
	private ComprobarCampos cc;
	private JPanel panel_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lbMisPuntos;
	
	private boolean regis = false;

	/**
	 * Create the dialog.
	 */
	public VentanaRegalos(VentanaPuntos vpuntos, VentanaPrincipal vpp, VentanaDatos vdd, VentanaCarro vcc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegalos.class.getResource("/img/logo.jpg.png")));
		cc = new ComprobarCampos();
		vpunto = vpuntos;
		vp = vpp;
		vd = vdd;
		vc = vcc;
		tabla = new Tabla();
		modelo = new DefaultTableModel();
		tablaRegalos = new JTable();
		tablaRegalos.setFont(new Font("Dialog", Font.BOLD, 17));
		tablaRegalos.setDefaultRenderer(Object.class, tabla);
		tablaRegalos.setModel(modelo);
		
		tablaRegalosSeleccionados = new JTable();
		tablaRegalosSeleccionados.setFont(new Font("Dialog", Font.BOLD, 17));
		tablaRegalosSeleccionados.setDefaultRenderer(Object.class, tabla);
		tablaRegalosSeleccionados.setModel(modelo);
		
		
		setBounds(100, 100, 843, 666);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getPanel_1(), BorderLayout.CENTER);
		
		tabla.añadirRegalos(tablaRegalos, vp.getRegalos(), vp);
		puntos();
		cargarRegalos();
		lbPuntos.setText(""+totalPuntos());
		setLocationRelativeTo(null);
		registrado();
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getLblNewLabel(), BorderLayout.WEST);
			panel.add(getPanel_3(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("   Regalos.");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		}
		return lblNewLabel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getScrollRegalos());
			panel_1.add(getScrollSeleccion());
			panel_1.add(getBtCancelar());
			panel_1.add(getPanel_2());
			panel_1.add(getLbPuntos());
			panel_1.add(getLblNewLabel_2());
			panel_1.add(getBtnNewButton());
			panel_1.add(getBtEliminarTodo());
			panel_1.add(getBtEliminarRegalo());
			panel_1.add(getLblNewLabel_4());
			panel_1.add(getLbMisPuntos());
		}
		return panel_1;
	}
	private JScrollPane getScrollRegalos() {
		if (scrollRegalos == null) {
			scrollRegalos = new JScrollPane();
			scrollRegalos.setBounds(10, 11, 490, 525);
			scrollRegalos.setViewportView(getTablaRegalos());
		}
		return scrollRegalos;
	}
	private JScrollPane getScrollSeleccion() {
		if (scrollSeleccion == null) {
			scrollSeleccion = new JScrollPane();
			scrollSeleccion.setBounds(510, 11, 307, 433);
			scrollSeleccion.setViewportView(getTablaRegalosSeleccionados());
		}
		return scrollSeleccion;
	}
	private JTable getTablaRegalos() {
			tablaRegalos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Nombre", "Puntos"
				}
			));
			tablaRegalos.setFont(new Font("Dialog", Font.BOLD, 13));
			tablaRegalos.setShowVerticalLines(false);
			tablaRegalos.setShowHorizontalLines(false);
			tablaRegalos.setShowGrid(false);
		return tablaRegalos;
	}
	private JTable getTablaRegalosSeleccionados() {
			tablaRegalosSeleccionados.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Puntos", 
				}
			));
			tablaRegalosSeleccionados.setFont(new Font("Dialog", Font.BOLD, 13));
			tablaRegalosSeleccionados.setShowVerticalLines(false);
			tablaRegalosSeleccionados.setShowHorizontalLines(false);
			tablaRegalosSeleccionados.setShowGrid(false);
		return tablaRegalosSeleccionados;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btCancelar.setMnemonic('n');
			btCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
			btCancelar.setBounds(722, 559, 95, 23);
		}
		return btCancelar;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("A\u00F1adir");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					añadirRegalo();
					lbPuntos.setText(""+totalPuntos());
				}
			});
			btnNewButton_3.setToolTipText("A\u00F1ade el regalo seleccionado a la lista.");
			btnNewButton_3.setMnemonic('A');
			btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnNewButton_3;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(10, 547, 490, 35);
			panel_2.add(getBtnNewButton_3());
		}
		return panel_2;
	}
	private JButton getBtEliminarRegalo() {
		if (btEliminarRegalo == null) {
			btEliminarRegalo = new JButton("Eliminar");
			btEliminarRegalo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					eliminar();
					lbPuntos.setText(""+totalPuntos());
				}
			});
			btEliminarRegalo.setBounds(603, 455, 89, 27);
			btEliminarRegalo.setMnemonic('e');
			btEliminarRegalo.setFont(new Font("Dialog", Font.BOLD, 14));
			btEliminarRegalo.setToolTipText("Elimina el regalo seleccionado.");
		}
		return btEliminarRegalo;
	}
	private JButton getBtEliminarTodo() {
		if (btEliminarTodo == null) {
			btEliminarTodo = new JButton("Vaciar");
			btEliminarTodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					tabla.limpiar(tablaRegalosSeleccionados);
					lbPuntos.setText(""+totalPuntos());
				}
			});
			btEliminarTodo.setBounds(510, 455, 75, 27);
			btEliminarTodo.setFont(new Font("Dialog", Font.BOLD, 14));
			btEliminarTodo.setToolTipText("Elimina todos los regalos");
			btEliminarTodo.setMnemonic('v');
		}
		return btEliminarTodo;
	}
	private JLabel getLbPuntos() {
		if (lbPuntos == null) {
			lbPuntos = new JLabel("");
			lbPuntos.setFont(new Font("Dialog", Font.BOLD, 14));
			lbPuntos.setHorizontalAlignment(SwingConstants.CENTER);
			lbPuntos.setBounds(613, 493, 79, 23);
		}
		return lbPuntos;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel();
			lblNewLabel_2.setText("Total puntos:");
			lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel_2.setBounds(510, 493, 109, 23);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Confirmar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(compararPuntos() == false)
					{
						JOptionPane.showMessageDialog(null, "No tiene los suficientes puntos para llevarse los regalos seleccionados.");
					}
					else if(tablaRegalosSeleccionados.getRowCount() == 0 && tablaRegalosSeleccionados.getSelectedRow() == -1)
					{
						JOptionPane.showMessageDialog(null, "No ha seleccionado regalos.");
					}
					else
					{
						guardar();
						dispose();
						JOptionPane.showMessageDialog(null, "Sus regalos se han añadido al pedido");
					}
				}
			});
			btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
			btnNewButton.setToolTipText("Confirmar art\u00EDculos de regalo.");
			btnNewButton.setMnemonic('C');
			btnNewButton.setBounds(603, 559, 109, 23);
		}
		return btnNewButton;
	}
	
	/**
	 * Método que calcula los puntos actuales del cliente
	 */
	private void puntos(){
		String nif = vd.getNIF();
		for(int i=0; i<vp.getClient().size(); i++)
		{
			if(vp.getClient().get(i).getNIF().equals(nif))
			{
				String value = String.valueOf(vp.getClient().get(i).getPuntos() + puntosActuales());
				lbMisPuntos.setText((value));
			}
		}		
	}
	
	/**
	 * Método para añadir los regalos seleccionados a la tabla
	 */
	private void añadirRegalo(){
		Object [] fila = new Object[2];
		if(tablaRegalos.getSelectedRow() != -1)
		{
			String nombre = (String) tablaRegalos.getValueAt(tablaRegalos.getSelectedRow(), 1);
			String puntos = String.valueOf(tablaRegalos.getValueAt(tablaRegalos.getSelectedRow(), 2));
				
			fila[0] = nombre;
			fila[1] = puntos;
				
			((DefaultTableModel) tablaRegalosSeleccionados.getModel()).addRow(fila);
		}
	}
	
	/**
	 * Método que añade los regalos seleccionados a la tabla
	 */
	private void cargarRegalos(){
		Object [] fila = new Object[2];
		for(int j=0; j<vp.getReg().size(); j++)
		{
			String nombre = vp.getReg().get(j).getDenominacion();
			String puntos = String.valueOf(vp.getReg().get(j).getValor());
			
			fila[0] = nombre;
			fila[1] = puntos;
			
			((DefaultTableModel) tablaRegalosSeleccionados.getModel()).addRow(fila);
		}
	}
	
	/**
	 * Método que calcula el total de puntos de los regalos seleccionados
	 * @return true o false
	 */
	private int totalPuntos(){
		int total = 0;
		for(int i=0; i<tablaRegalosSeleccionados.getRowCount(); i++)
		{
			total = total + Integer.parseInt((String) tablaRegalosSeleccionados.getValueAt(i, 1));
		}
		return total;
	}
	
	/**
	 * Método que elimina un regalo seleccionado.
	 */
	private void eliminar(){
		try{
			DefaultTableModel modelo = (DefaultTableModel) tablaRegalosSeleccionados.getModel();
			//String valor = (String) tablaRegalosSeleccionados.getValueAt(tablaRegalosSeleccionados.getSelectedRow(), 0);
			modelo.removeRow(tablaRegalosSeleccionados.getSelectedRow());
		}catch(Exception e){
			
		}	
	}
	
	/**
	 * Método que no se canjean regalos si no tienes puntos suficientes
	 * @return true o false
	 */
	private boolean compararPuntos(){
		try
		{
			int puntos = Integer.parseInt(lbPuntos.getText());
			int misPuntos = Integer.parseInt(lbMisPuntos.getText());
			
			if(puntos > misPuntos)
			{
				return false;
			}
		}catch(Exception e){
		}
		return true;
		
	}
	
	/**
	 * Guarda los regalos seleccionados en una lista
	 */
	private void guardar(){
		vp.getReg().clear();
		for(int i=0; i<tablaRegalosSeleccionados.getRowCount(); i++)
		{
			for(int j=0; j<vp.getRegalos().size(); j++)
			{
				if(tablaRegalosSeleccionados.getValueAt(i, 0).equals(vp.getRegalos().get(j).getDenominacion()))
				{
					vp.getReg().add(new Regalo(vp.getRegalos().get(j).getCodigo(), vp.getRegalos().get(j).getCategoria(),
							vp.getRegalos().get(j).getDenominacion(), vp.getRegalos().get(j).getValor()));
				}
			}
		}
	}
	
	
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.add(getLblNewLabel_3());
		}
		return panel_3;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\u00C9chele un vistazo a nuestros regalos y escoja los que m\u00E1s le gusten.");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 15));
			lblNewLabel_3.setBounds(10, 0, 678, 34);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Mis puntos:");
			lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel_4.setBounds(510, 520, 89, 23);
		}
		return lblNewLabel_4;
	}
	private JLabel getLbMisPuntos() {
		if (lbMisPuntos == null) {
			lbMisPuntos = new JLabel("0");
			lbMisPuntos.setHorizontalAlignment(SwingConstants.CENTER);
			lbMisPuntos.setFont(new Font("Dialog", Font.BOLD, 14));
			lbMisPuntos.setBounds(613, 519, 79, 23);
		}
		return lbMisPuntos;
	}
	
	/**
	 * Método que calcula los puntos totales de la actualCompra 
	 * @return
	 */
	private int puntosActuales(){
		int puntos = 0;
		for(int i=0; i<vc.getArticulosCarro().size(); i++)
		{
			puntos = puntos + vc.getArticulosCarro().get(i).getPuntosCompra() * vc.getArticulosCarro().get(i).getStock();
		}
		return puntos;
	}
	
	/**
	 * Método para saber si el usuario está registrado o no y darle los puntos de la actual compra.
	 */
	private void registrado(){
		if(cc.recorrerNif(vd.getNIF(), vp.getClient()) == true)
		{
			lbMisPuntos.setText(String.valueOf(puntosActuales()));		
		}
	}
}
