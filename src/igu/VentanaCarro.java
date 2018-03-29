package igu;

import java.awt.BorderLayout;





import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import logica.Articulo;
import logica.Cliente;
import logica.FileHelper;
import logica.Tabla;





import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.Toolkit;

@SuppressWarnings("serial")
public class VentanaCarro extends JDialog {

	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JButton btnVaciarCarro;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private VentanaPrincipal vpp;
	@SuppressWarnings("unused")
	private FileHelper file;
	private JTable table;
	private DefaultTableModel modelo; 
	private Tabla tabla;
	private InicioSesion is;
	private boolean confirmar = false;
	private int unidades = 0;
	

	private ArrayList <Cliente> cli;
	private JSpinner spinner;
	
	private ArrayList <Articulo> articulosCarro = new ArrayList <Articulo>(); 
	private JButton btEliminar;
	private JLabel lblUnidades;
	
	public JTable getTablaCarro(){
		return table;
	}

	public ArrayList<Articulo> getArticulosCarro() {
		return articulosCarro;
	}

	public ArrayList <Cliente> getCli(){
		return cli;
	}
	
	/**
	 * @throws IOException 
	 * Create the frame.
	 * @throws   
	 */
	public VentanaCarro(VentanaPrincipal vp, InicioSesion iss) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaCarro.class.getResource("/img/logo.jpg.png")));
		is =iss;
		vpp = vp;
		file = new FileHelper();
		cli = vp.getClient();
		modelo =new DefaultTableModel();
		table = new JTable();
		tabla = new Tabla();
		table.setDefaultRenderer(Object.class, tabla);
		table.setModel(modelo);
		
		
		setTitle("Ventana del carrito");		
		setBounds(100, 100, 853, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			contentPane.add(getPanel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.add(getBtnVaciarCarro());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnCancelar());
		contentPane.add(getSpinner());
		contentPane.add(getBtEliminar());
		contentPane.add(getLblUnidades());
		setLocationRelativeTo(null);
		recorrer();
	}

	private JPanel getPanel() throws IOException {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(35, 45, 778, 302);
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JScrollPane getScrollPane() throws IOException {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JButton getBtnVaciarCarro() {
		if (btnVaciarCarro == null) {
			btnVaciarCarro = new JButton("Vaciar Carro");
			btnVaciarCarro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vpp.getCarro().clear();
					vpp.getRepetidos().clear();
					tabla.limpiar(table);
				}
			});
			btnVaciarCarro.setToolTipText("Haga click para eliminar todos los productos del carro.");
			btnVaciarCarro.setMnemonic('V');
			btnVaciarCarro.setFont(new Font("Dialog", Font.BOLD, 13));
			btnVaciarCarro.setBounds(45, 358, 113, 37);
		}
		return btnVaciarCarro;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setToolTipText("");
			btnSiguiente.setMnemonic('S');
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobar();
				}
			});
			btnSiguiente.setFont(new Font("Dialog", Font.BOLD, 13));
			btnSiguiente.setBounds(538, 358, 113, 37);
		}
		return btnSiguiente;
	}
	
	/**
	 * Método que comprueba que no supere el nº de unidades disponibles y que muestra la ventana de datos
	 */
	private void comprobar(){
		if(table.getRowCount() == 0 && table.getSelectedRow() == -1)
		{
			btnSiguiente.setEnabled(false);
			confirmar = false;
		}
		else
		{
			if(maximoUnidades() == false)
			{
				confirmar = false;
				JOptionPane.showMessageDialog(null, "Ha superado el número de existencias del artículo"+
						"\n Únicamente disponemos de "+unidades+" unidades.");
			}
			if(maximoUnidades() == true)
			{
				confirmar = true;
			}
		}
		if(confirmar == true)
		{
			try {
				guardar();
				mostrarVentanaConfirmarCompra();			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	/**
	 * Método que muestra la ventana de confirmar compra
	 * @throws IOException
	 */
	private void mostrarVentanaConfirmarCompra() throws IOException{
		VentanaDatos cc = new VentanaDatos(this, is, vpp);
		cc.setVisible(true);
		//cc.setModal(true);
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Seguir Comprando");
			btnCancelar.setMnemonic('C');
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setFont(new Font("Dialog", Font.BOLD, 13));
			btnCancelar.setBounds(661, 357, 152, 39);
		}
		return btnCancelar;
	}
	public JTable getTable() {
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Unidades", "Precio", "Puntos"
				}
			)
			{
				public boolean isCellEditable(int row, int column){
					return false;
				}
			});
			
		return table;
	}
	
	/**
	 * Método que recorre los artículos de la liosta y los muestra en el carro
	 */
	private void recorrer(){	
		Object [] fila = new Object[5];
		for(int i=0; i<vpp.getCarro().size();i++)
		{
			for(int j=0 ;j<vpp.getTodosArticulos().size(); j++)
			{
				if(vpp.getCarro().get(i).equals(vpp.getTodosArticulos().get(j).getDenominacion()))
				{
					fila[0] = vpp.getTodosArticulos().get(j).getDenominacion();
					fila[1] = spinner.getValue().toString();
					
					if(vpp.isConVid() == true && vpp.getTodosArticulos().get(j).getCodigo().startsWith("CV-")
							|| vpp.isFotVi() == true && vpp.getTodosArticulos().get(j).getCodigo().startsWith("FV-") 
							|| vpp.isTef() == true && vpp.getTodosArticulos().get(j).getCodigo().startsWith("TM-")
							|| vpp.isOrdena() == true && vpp.getTodosArticulos().get(j).getCodigo().startsWith("OT-")
							|| vpp.isVideoVigi() == true && vpp.getTodosArticulos().get(j).getCodigo().startsWith("VI-"))
					{		
						fila[2] = new BigDecimal((vpp.getTodosArticulos().get(j).getPrecio()*0.9)).setScale(2, RoundingMode.DOWN);
					}
					else
					{
						fila[2] = vpp.getTodosArticulos().get(j).getPrecio();
					}	
					fila[3] = vpp.getTodosArticulos().get(j).getPuntosCompra();
					((DefaultTableModel) table.getModel()).addRow(fila);
				}
			}
			
		}
	}
	
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					table.setValueAt(spinner.getValue().toString(), table.getSelectedRow(), 1);
				}
			});
			
			spinner.setFont(new Font("Dialog", Font.PLAIN, 13));
			spinner.setToolTipText("Haga click para aumentar o decrementar el n\u00FAmero de unidades del producto seleccionado.");
			spinner.setBounds(375, 358, 52, 37);
		}
		return spinner;
	}
	
	
	/**
	 * Método que guarda en una lista los artículos del carro que se hayan escogido para la compra
	 */
	private void guardar(){
		for(int i=0; i<table.getRowCount(); i++)
		{
			for(int j=0; j<vpp.getTodosArticulos().size(); j++)
			{
				if(String.valueOf(table.getValueAt(i, 0)).equals(vpp.getTodosArticulos().get(j).getDenominacion()))
				{
					articulosCarro.add(new Articulo(vpp.getTodosArticulos().get(j).getCodigo(),
							vpp.getTodosArticulos().get(j).getCategoria(), vpp.getTodosArticulos().get(j).getSubcategoria(),
							vpp.getTodosArticulos().get(j).getDenominacion(), vpp.getTodosArticulos().get(j).getDescripcion(),
							Double.parseDouble(String.valueOf(table.getValueAt(i, 2))), vpp.getTodosArticulos().get(j).getPuntosCompra(),
							Integer.parseInt((String) table.getValueAt(i, 1))));
					
				}
			}
		}
	}
	
	
	private JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton("Eliminar");
			btEliminar.setMnemonic('E');
			btEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					eliminar();
				}
			});
			btEliminar.setToolTipText("Haga click para eliminar el producto seleccionado.");
			btEliminar.setFont(new Font("Dialog", Font.BOLD, 13));
			btEliminar.setBounds(168, 359, 113, 34);
		}
		return btEliminar;
	}
	
	/**
	 * Método para eliminar un producto del carro
	 */
	private void eliminar(){
		try{
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			String valor = (String) table.getValueAt(table.getSelectedRow(), 0);
			modelo.removeRow(table.getSelectedRow());
			for(int i=0; i<vpp.getRepetidos().size(); i++)
			{
				for(int j=0; j<vpp.getCarro().size(); j++)
				{
					if(vpp.getRepetidos().get(i).equals(valor) && vpp.getCarro().get(j).equals(valor))
					{
						vpp.getRepetidos().remove(i);
						vpp.getCarro().remove(j);
					}
				}
			}
		}catch(Exception e){
			
		}	
	}
	
	/**
	 * Método para llevar el contador de las unidades de cada producto.
	 * @return unidades máximas de cada producto
	 */
	private boolean maximoUnidades(){
		if(table.getSelectedRow() != -1)
		{
			String nombre = (String) table.getValueAt(table.getSelectedRow(), 0);
			String unidadesSeleccionadas = (String) table.getValueAt(table.getSelectedRow(), 1);
			for(int i=0; i<vpp.getTodosArticulos().size(); i++)
			{
				if(vpp.getTodosArticulos().get(i).getDenominacion().equals(nombre))
				{
					unidades = vpp.getTodosArticulos().get(i).getStock();
					if(Integer.parseInt(unidadesSeleccionadas) > unidades)
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setDisplayedMnemonic('U');
			lblUnidades.setLabelFor(getSpinner());
			lblUnidades.setFont(new Font("Dialog", Font.BOLD, 15));
			lblUnidades.setBounds(291, 358, 74, 34);
		}
		return lblUnidades;
	}
}
