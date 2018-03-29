package igu;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;


import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import logica.Articulo;

import logica.Tabla;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Productos extends JDialog {
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panelFiltrar;
	private JPanel panel_3;
	private JLabel lbTitulo;
	private JPanel panel_4;
	private JLabel lbDescripcion;
	private JPanel panel_5;
	private JPanel panel_6;
	private JButton btInicio;
	private JButton btCarro;
	private JPanel panel_8;
	private JScrollPane scrollPane;
	private JPanel panelBotonesSur;
	private JButton btAñadir;
	private JButton btVerMas;
	private JPanel panel_7;
	private JPanel panel_9;
	private JButton btCancelar;
	private DefaultTableModel modelo;
	private Tabla tabla;

	private JTable table;
	private VentanaPrincipal vp;

	private InicioSesion is;
	private JTextArea txtrPuedeFiltrarLos;
	private JRadioButton rbMenos50;
	private JRadioButton rbMas50;
	private JRadioButton rbMas100;
	private JPanel panel_10;
	private JRadioButton rbMas500;
	private JRadioButton rbTodos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private ArrayList <Articulo> menor50 = new ArrayList <Articulo>();
	private ArrayList <Articulo> menor99 = new ArrayList <Articulo>();
	private ArrayList <Articulo> menor499 = new ArrayList <Articulo>();
	private ArrayList <Articulo> mas500 = new ArrayList <Articulo>();
	private ArrayList <Articulo> todos = new ArrayList <Articulo>();
	
	private ArrayList <Articulo> lista1 = new ArrayList <Articulo>();
	private ArrayList <Articulo> lista2 = new ArrayList <Articulo>();
	private ArrayList <Articulo> lista3 = new ArrayList <Articulo>();
	private ArrayList <Articulo> lista4 = new ArrayList <Articulo>();
	private ArrayList <Articulo> lista5 = new ArrayList <Articulo>();
	
	private JLabel lbOferta;
	private JLabel lblNewLabel;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	private JRadioButton radio4;
	private JRadioButton radio5;
	private JLabel lblNewLabel_1;
	


	/**
	 * Create the dialog.
	 */
	public Productos(VentanaPrincipal vpp) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Productos.class.getResource("/img/logo.jpg.png")));
		this.vp = vpp;
		
		tabla = new Tabla();
		modelo = new DefaultTableModel();
		table = new JTable();
		table.setFont(new Font("Dialog", Font.BOLD, 17));
		table.setDefaultRenderer(Object.class, tabla);
		table.setModel(modelo);
		
		setTitle("Productos");
		setBounds(100, 100, 1126, 735);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel_3(), BorderLayout.NORTH);
		getContentPane().add(getPanel(), BorderLayout.WEST);
		getContentPane().add(getPanel_8(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
	}
	
	/**
	 * Método que carga la ventana consolas
	 */
	public void botonConsolas(){
		lbTitulo.setText("Consolas y Videojuegos");
		filtrar();
		filtrarCategorias();
		radio1.setVisible(true);
		radio2.setVisible(true);
		radio3.setVisible(true);
		radio4.setVisible(true);
		radio5.setVisible(true);
		radio1.setText("PlayStation");
		radio1.setMnemonic('y');
		radio2.setText("Xbox");
		radio2.setMnemonic('X');
		radio3.setText("Wii");
		radio3.setMnemonic('W');
		radio4.setText("DS");
		radio4.setMnemonic('D');
		radio5.setText("Otras");
		radio5.setMnemonic('O');
		lbDescripcion.setText("   Aquí podrá encontrar todo tipo de consolas y juegos.");
		tabla.añadirArticulos(table, vp.getConsolas(), vp);
		if(vp.isConVid() == true)
		{
			lbOferta.setText("OFERTA 10%");
		}
		
	}
	
	/**
	 * Método que carga la ventana forografía
	 */
	public void botonFotografia(){
		lbTitulo.setText("Fotografía y Vídeo");
		filtrar();
		filtrarCategorias();
		radio1.setVisible(true);
		radio2.setVisible(true);
		radio3.setVisible(true);
		radio4.setVisible(true);
		radio1.setText("Cámaras Réflex");
		radio1.setMnemonic('f');
		radio2.setText("Cámaras Compactas");
		radio2.setMnemonic('p');
		radio3.setText("Videocámaras");
		radio3.setMnemonic('V');
		radio4.setText("Accesorios");
		radio4.setMnemonic('o');
		lbDescripcion.setText("   Aquí podrá encontrar todo tipo de cámaras y videocámaras.");
		tabla.añadirArticulos(table, vp.getFotografia(), vp);
		if(vp.isFotVi() == true)
		{
			lbOferta.setText("OFERTA 10%");
		}
	}
	
	/**
	 * Método que carga la ventana de teléfonos
	 */
	public void botonTelefonos(){
		lbTitulo.setText("Telefonía Móvil");
		filtrar();
		lbDescripcion.setText("   Aquí podrá encontrar teléfonos móviles de diferentes marcas.");
		tabla.añadirArticulos(table, vp.getTelefonos(), vp);
		if(vp.isTef() == true)
		{
			lbOferta.setText("OFERTA 10%");
		}
	}
	
	/**
	 * Método que carga la ventana de ordenadores
	 */
	public void botonOrdenadores(){
		lbTitulo.setText("Ordenadores y Tablets");
		filtrar();
		filtrarCategorias();
		radio1.setVisible(true);
		radio2.setVisible(true);
		radio3.setVisible(true);
		radio4.setVisible(true);
		radio1.setText("Sobremesa");
		radio1.setMnemonic('b');
		radio2.setText("Portátiles");
		radio2.setMnemonic('P');
		radio3.setText("Tablets");
		radio3.setMnemonic('l');
		radio4.setText("Accesorios");
		radio4.setMnemonic('o');
		lbDescripcion.setText("   Aquí podrá encontrar ordenadores, tablets y accesorios.");
		tabla.añadirArticulos(table, vp.getOrdenadores(), vp);
		if(vp.isOrdena() == true)
		{
			lbOferta.setText("OFERTA 10%");
		}
	}
	
	/**
	 * Método que carga la ventana de vigilancia.
	 */
	public void botonVideovigilancia(){
		lbTitulo.setText("Videovigilancia");
		filtrar();
		filtrarCategorias();
		radio1.setVisible(true);
		radio2.setVisible(true);
		radio3.setVisible(true);
		radio1.setText("Cámaras");
		radio1.setMnemonic('s');
		radio2.setText("Micrófonos");
		radio2.setMnemonic('f');
		radio3.setText("Kits");
		radio3.setMnemonic('K');
		lbDescripcion.setText("   Aquí podrá encontrar todo tipo de videocámaras, micrófonos y kits de vigilancia.");
		tabla.añadirArticulos(table, vp.getVideovigilancia(), vp);
		if(vp.isVideoVigi() == true)
		{
			lbOferta.setText("OFERTA 10%");
		}
	}
	
	/**
	 * Método que muestra la ventana ver más.
	 */
	private void mostrarVentanaVerMas(){
		VerMas v = new VerMas(vp);
		v.buscarArticulos(table, vp.getTodosArticulos());
		v.setVisible(true);
	}
	
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_2(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getPanelFiltrar(), BorderLayout.CENTER);
		}
		return panel_2;
	}
	private JPanel getPanelFiltrar() {
		if (panelFiltrar == null) {
			panelFiltrar = new JPanel();
			panelFiltrar.setLayout(new BorderLayout(0, 0));
			panelFiltrar.add(getTxtrPuedeFiltrarLos(), BorderLayout.NORTH);
			panelFiltrar.add(getPanel_10(), BorderLayout.CENTER);
		}
		return panelFiltrar;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new BorderLayout(0, 0));
			panel_3.add(getLbTitulo(), BorderLayout.WEST);
			panel_3.add(getPanel_4(), BorderLayout.CENTER);
		}
		return panel_3;
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("");
			lbTitulo.setForeground(Color.RED);
			lbTitulo.setFont(new Font("Dialog", Font.BOLD, 36));
		}
		return lbTitulo;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getLbDescripcion());
			panel_4.add(getPanel_5(), BorderLayout.EAST);
		}
		return panel_4;
	}
	private JLabel getLbDescripcion() {
		if (lbDescripcion == null) {
			lbDescripcion = new JLabel("");
			lbDescripcion.setForeground(Color.WHITE);
			lbDescripcion.setFont(new Font("Dialog", Font.BOLD, 17));
		}
		return lbDescripcion;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(new BorderLayout(0, 0));
			panel_5.add(getPanel_6(), BorderLayout.SOUTH);
		}
		return panel_5;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.add(getBtInicio());
			panel_6.add(getBtCarro());
		}
		return panel_6;
	}
	private JButton getBtInicio() {
		if (btInicio == null) {
			btInicio = new JButton("Iniciar Sesi\u00F3n");
			btInicio.setMnemonic('I');
			btInicio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaInicioSesion();
				}
			});
			btInicio.setFont(new Font("Dialog", Font.BOLD, 12));
		}
		return btInicio;
	}
	private JButton getBtCarro() {
		if (btCarro == null) {
			btCarro = new JButton("Carro");
			btCarro.setMnemonic('C');
			btCarro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						mostrarVentanaCarrito();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btCarro.setFont(new Font("Dialog", Font.BOLD, 12));
		}
		return btCarro;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setLayout(new BorderLayout(0, 0));
			panel_8.add(getScrollPane(), BorderLayout.CENTER);
			panel_8.add(getPanelBotonesSur(), BorderLayout.SOUTH);
		}
		return panel_8;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	
	private JPanel getPanelBotonesSur() {
		if (panelBotonesSur == null) {
			panelBotonesSur = new JPanel();
			panelBotonesSur.setLayout(new BorderLayout(0, 0));
			panelBotonesSur.add(getPanel_7(), BorderLayout.CENTER);
			panelBotonesSur.add(getPanel_9(), BorderLayout.EAST);
		}
		return panelBotonesSur;
	}
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("A\u00F1adir");
			btAñadir.setMnemonic('A');
			btAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tabla.comprobarUnidades(table, vp.getTodosArticulos()) == false)
					{
						JOptionPane.showMessageDialog(null, "Las existencias de este producto se han terminado.");
					}
					else
					{
						tabla.añadirCarro(table, vp.getRepetidos(), vp.getCarro());
					}
				}
			});
			btAñadir.setToolTipText("Seleccione un producto y haga click para a\u00F1adir el producto al carro");
			btAñadir.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btAñadir;
	}
	private JButton getBtVerMas() {
		if (btVerMas == null) {
			btVerMas = new JButton("Ver m\u00E1s");
			btVerMas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobarNovedades();
				}
			});
			btVerMas.setMnemonic('r');
			btVerMas.setToolTipText("Seleccione un producto y haga click para mostrar toda la informaci\u00F3n acerca del producto");
			btVerMas.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btVerMas;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.add(getBtAñadir());
			panel_7.add(getBtVerMas());
		}
		return panel_7;
	}
	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.add(getBtCancelar());
		}
		return panel_9;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cerrar");
			btCancelar.setMnemonic('e');
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btCancelar;
	}
	
	/**
	 * Método que muestra la ventana del carro
	 * @throws IOException
	 */
	private void mostrarVentanaCarrito() throws IOException{
		VentanaCarro vc= new VentanaCarro(vp, is);
		vc.setVisible(true);
	}
	
	/**
	 * Método que muestra la ventana Inicio de sesión
	 */
	private void mostrarVentanaInicioSesion(){
		InicioSesion is = new InicioSesion(vp);
		is.setVisible(true);
	}
	
	private JTable getTable() {
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Nombre", "Precio", "Puntos"
				}
			)
			{
				public boolean isCellEditable(int row, int column){
					return false;
				}
			});
			table.setShowGrid(false);
			table.setShowHorizontalLines(false);
			table.setShowVerticalLines(false);
		
		return table;
	}
	private JTextArea getTxtrPuedeFiltrarLos() {
		if (txtrPuedeFiltrarLos == null) {
			txtrPuedeFiltrarLos = new JTextArea();
			txtrPuedeFiltrarLos.setFont(new Font("Dialog", Font.PLAIN, 15));
			txtrPuedeFiltrarLos.setEditable(false);
			txtrPuedeFiltrarLos.setText("Puede filtrar los productos\r\nseleccionando cualquiera \r\nde la siguientes opciones:");
		}
		return txtrPuedeFiltrarLos;
	}
	private JRadioButton getRbMenos50() {
		if (rbMenos50 == null) {
			rbMenos50 = new JRadioButton("Menos de 50\u20AC");
			rbMenos50.setMnemonic('M');
			buttonGroup.add(rbMenos50);
			rbMenos50.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					tabla.limpiar(table);
					tabla.añadirArticulos(table, menor50, vp);
				}
			});
			rbMenos50.setBounds(5, 49, 168, 31);
			rbMenos50.setFont(new Font("Dialog", Font.BOLD, 15));
		}
		return rbMenos50;
	}
	private JRadioButton getRbMas50() {
		if (rbMas50 == null) {
			rbMas50 = new JRadioButton("Entre 50\u20AC y 99\u20AC");
			rbMas50.setMnemonic('n');
			buttonGroup.add(rbMas50);
			rbMas50.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabla.limpiar(table);
					tabla.añadirArticulos(table, menor99, vp);
				}
			});
			rbMas50.setBounds(5, 83, 168, 31);
			rbMas50.setFont(new Font("Dialog", Font.BOLD, 15));
		}
		return rbMas50;
	}
	private JRadioButton getRbMas100() {
		if (rbMas100 == null) {
			rbMas100 = new JRadioButton("Entre 100\u20AC y 499\u20AC");
			rbMas100.setMnemonic('1');
			buttonGroup.add(rbMas100);
			rbMas100.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabla.limpiar(table);
					tabla.añadirArticulos(table, menor499, vp);
				}
			});
			rbMas100.setBounds(5, 117, 168, 31);
			rbMas100.setFont(new Font("Dialog", Font.BOLD, 15));
		}
		return rbMas100;
	}
	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.setLayout(null);
			panel_10.add(getRbMenos50());
			panel_10.add(getRbMas50());
			panel_10.add(getRbMas100());
			panel_10.add(getRbMas500());
			panel_10.add(getRbTodos());
			panel_10.add(getLbOferta());
			panel_10.add(getLblNewLabel());
			panel_10.add(getRadio1());
			panel_10.add(getRadio2());
			panel_10.add(getRadio3());
			panel_10.add(getRadio4());
			panel_10.add(getRadio5());
			panel_10.add(getLblNewLabel_1());
		}
		return panel_10;
	}
	private JRadioButton getRbMas500() {
		if (rbMas500 == null) {
			rbMas500 = new JRadioButton("M\u00E1s de 500\u20AC");
			rbMas500.setMnemonic('5');
			buttonGroup.add(rbMas500);
			rbMas500.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabla.limpiar(table);
					tabla.añadirArticulos(table, mas500, vp);
				}
			});
			rbMas500.setFont(new Font("Dialog", Font.BOLD, 15));
			rbMas500.setBounds(5, 151, 168, 31);
		}
		return rbMas500;
	}
	private JRadioButton getRbTodos() {
		if (rbTodos == null) {
			rbTodos = new JRadioButton("Todos");
			rbTodos.setMnemonic('T');
			rbTodos.setSelected(true);
			buttonGroup.add(rbTodos);
			rbTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabla.limpiar(table);
					tabla.añadirArticulos(table, todos, vp);
				}
			});
			rbTodos.setFont(new Font("Dialog", Font.BOLD, 15));
			rbTodos.setBounds(5, 287, 167, 31);
		}
		return rbTodos;
	}
	
	/**
	 * Método para filtrar los productos según el precio
	 */
	private void filtrar(){
		for(int i=0; i<vp.getTodosArticulos().size(); i++){
			if(vp.getTodosArticulos().get(i).getPrecio() < 50){
				if(lbTitulo.getText().startsWith("Consolas") && vp.getTodosArticulos().get(i).getCodigo().startsWith("CV-")){
					menor50.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Fotografía") && vp.getTodosArticulos().get(i).getCodigo().startsWith("FV-")){
					menor50.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Telefonía") && vp.getTodosArticulos().get(i).getCodigo().startsWith("TM-")){
					menor50.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Ordenadores") && vp.getTodosArticulos().get(i).getCodigo().startsWith("OT-")){
					menor50.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Videovigilancia") && vp.getTodosArticulos().get(i).getCodigo().startsWith("VI-")){
					menor50.add(vp.getTodosArticulos().get(i));
				}
			}
			else if(vp.getTodosArticulos().get(i).getPrecio() >= 50 && vp.getTodosArticulos().get(i).getPrecio() <= 99)
			{
				if(lbTitulo.getText().startsWith("Consolas") && vp.getTodosArticulos().get(i).getCodigo().startsWith("CV-")){
					menor99.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Fotografía") && vp.getTodosArticulos().get(i).getCodigo().startsWith("FV-")){
					menor99.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Telefonía") && vp.getTodosArticulos().get(i).getCodigo().startsWith("TM-")){
					menor99.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Ordenadores") && vp.getTodosArticulos().get(i).getCodigo().startsWith("OT-")){
					menor99.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Videovigilancia") && vp.getTodosArticulos().get(i).getCodigo().startsWith("VI-")){
					menor99.add(vp.getTodosArticulos().get(i));
				}
			}
			else if(vp.getTodosArticulos().get(i).getPrecio() >= 100 && vp.getTodosArticulos().get(i).getPrecio() <= 499)
			{
				if(lbTitulo.getText().startsWith("Consolas") && vp.getTodosArticulos().get(i).getCodigo().startsWith("CV-")){
					menor499.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Fotografía") && vp.getTodosArticulos().get(i).getCodigo().startsWith("FV-")){
					menor499.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Telefonía") && vp.getTodosArticulos().get(i).getCodigo().startsWith("TM-")){
					menor499.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Ordenadores") && vp.getTodosArticulos().get(i).getCodigo().startsWith("OT-")){
					menor499.add(vp.getTodosArticulos().get(i));	
				}
				else if(lbTitulo.getText().startsWith("Videovigilancia") && vp.getTodosArticulos().get(i).getCodigo().startsWith("VI-")){
					menor499.add(vp.getTodosArticulos().get(i));
				}
			}
			else if(vp.getTodosArticulos().get(i).getPrecio() >= 500)
			{
				if(lbTitulo.getText().startsWith("Consolas") && vp.getTodosArticulos().get(i).getCodigo().startsWith("CV-")){
					mas500.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Fotografía") && vp.getTodosArticulos().get(i).getCodigo().startsWith("FV-")){
					mas500.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Telefonía") && vp.getTodosArticulos().get(i).getCodigo().startsWith("TM-")){
					mas500.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Ordenadores") && vp.getTodosArticulos().get(i).getCodigo().startsWith("OT-")){
					mas500.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Videovigilancia") && vp.getTodosArticulos().get(i).getCodigo().startsWith("VI-")){
					mas500.add(vp.getTodosArticulos().get(i));
				}
			}
			if(vp.getTodosArticulos().get(i).getPrecio() >= 0)
			{
				if(lbTitulo.getText().startsWith("Consolas") && vp.getTodosArticulos().get(i).getCodigo().startsWith("CV-")){
					todos.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Fotografía") && vp.getTodosArticulos().get(i).getCodigo().startsWith("FV-")){
					todos.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Telefonía") && vp.getTodosArticulos().get(i).getCodigo().startsWith("TM-")){
					todos.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Ordenadores") && vp.getTodosArticulos().get(i).getCodigo().startsWith("OT-")){
					todos.add(vp.getTodosArticulos().get(i));
				}
				else if(lbTitulo.getText().startsWith("Videovigilancia") && vp.getTodosArticulos().get(i).getCodigo().startsWith("VI-")){
					todos.add(vp.getTodosArticulos().get(i));
				}
			}
		}
	}
	private JLabel getLbOferta() {
		if (lbOferta == null) {
			lbOferta = new JLabel("");
			lbOferta.setForeground(Color.BLUE);
			lbOferta.setFont(new Font("Dialog", Font.BOLD, 24));
			lbOferta.setHorizontalAlignment(SwingConstants.CENTER);
			lbOferta.setBounds(5, 199, 154, 39);
		}
		return lbOferta;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Precio:");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel.setBounds(10, 11, 154, 31);
		}
		return lblNewLabel;
	}
	private JRadioButton getRadio1() {
		if (radio1 == null) {
			radio1 = new JRadioButton("");
			radio1.setVisible(false);
			radio1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					tabla.limpiar(table);
					tabla.añadirArticulos(table, lista1, vp);
				}
			});
			buttonGroup.add(radio1);
			radio1.setFont(new Font("Dialog", Font.BOLD, 15));
			radio1.setBounds(5, 321, 168, 31);
		}
		return radio1;
	}
	private JRadioButton getRadio2() {
		if (radio2 == null) {
			radio2 = new JRadioButton("");
			radio2.setVisible(false);
			radio2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					tabla.limpiar(table);
					tabla.añadirArticulos(table, lista2, vp);
				}
			});
			buttonGroup.add(radio2);
			radio2.setFont(new Font("Dialog", Font.BOLD, 15));
			radio2.setBounds(5, 355, 199, 31);
		}
		return radio2;
	}
	private JRadioButton getRadio3() {
		if (radio3 == null) {
			radio3 = new JRadioButton("");
			radio3.setVisible(false);
			radio3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					tabla.limpiar(table);
					tabla.añadirArticulos(table, lista3, vp);
				}
			});
			buttonGroup.add(radio3);
			radio3.setFont(new Font("Dialog", Font.BOLD, 15));
			radio3.setBounds(5, 389, 169, 31);
		}
		return radio3;
	}
	private JRadioButton getRadio4() {
		if (radio4 == null) {
			radio4 = new JRadioButton("");
			radio4.setVisible(false);
			radio4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					tabla.limpiar(table);
					tabla.añadirArticulos(table, lista4, vp);
				}
			});
			buttonGroup.add(radio4);
			radio4.setFont(new Font("Dialog", Font.BOLD, 15));
			radio4.setBounds(5, 423, 168, 31);
		}
		return radio4;
	}
	private JRadioButton getRadio5() {
		if (radio5 == null) {
			radio5 = new JRadioButton("");
			radio5.setVisible(false);
			radio5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					tabla.limpiar(table);
					tabla.añadirArticulos(table, lista5, vp);
				}
			});
			buttonGroup.add(radio5);
			radio5.setFont(new Font("Dialog", Font.BOLD, 15));
			radio5.setBounds(5, 457, 168, 31);
		}
		return radio5;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Subcategor\u00EDas:");
			lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel_1.setBounds(5, 249, 159, 31);
		}
		return lblNewLabel_1;
	}
	
	/**
	 * Método para filtrar los productos según ñas categorías.
	 */
	private void filtrarCategorias(){
		for(int i=0; i<vp.getTodosArticulos().size(); i++)
		{
			if(lbTitulo.getText().startsWith("Consolas") && vp.getTodosArticulos().get(i).getCodigo().startsWith("CV-"))
			{
				if(vp.getTodosArticulos().get(i).getCodigo().startsWith("CV-PS")){
					lista1.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("CV-XB")){
					lista2.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("CV-WI")){
					lista3.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("CV-DS")){
					lista4.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("CV-OT")){
					lista5.add(vp.getTodosArticulos().get(i));
				}
			}
			else if(lbTitulo.getText().startsWith("Fotografía") && vp.getTodosArticulos().get(i).getCodigo().startsWith("FV-"))
			{
				if(vp.getTodosArticulos().get(i).getCodigo().startsWith("FV-CR")){
					lista1.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("FV-CC")){
					lista2.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("FV-VI")){
					lista3.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("FV-AC")){
					lista4.add(vp.getTodosArticulos().get(i));
				}
			}
			else if(lbTitulo.getText().startsWith("Ordenadores") && vp.getTodosArticulos().get(i).getCodigo().startsWith("OT-"))
			{
				if(vp.getTodosArticulos().get(i).getCodigo().startsWith("OT-SO")){
					lista1.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("OT-PO")){
					lista2.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("OT-TA")){
					lista3.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("OT-AC")){
					lista4.add(vp.getTodosArticulos().get(i));
				}
			}
			else if(lbTitulo.getText().startsWith("Videovigilancia") && vp.getTodosArticulos().get(i).getCodigo().startsWith("VI-"))
			{
				if(vp.getTodosArticulos().get(i).getCodigo().startsWith("VI-CA")){
					lista1.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("VI-MI")){
					lista2.add(vp.getTodosArticulos().get(i));
				}
				else if(vp.getTodosArticulos().get(i).getCodigo().startsWith("VI-KI")){
					lista3.add(vp.getTodosArticulos().get(i));
				}
			}
		}
	}
	
	/**
	 * Método que comprueba que se haya seleccionado un producto para mostrar su información
	 */
	private void comprobarNovedades(){
		
			if(table.getRowCount() != 0 && table.getSelectedRow() != -1)
			{
				mostrarVentanaVerMas();
			}
	}
}
