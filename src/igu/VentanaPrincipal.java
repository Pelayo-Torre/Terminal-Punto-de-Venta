package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.help.*;

import java.net.*;
import java.io.*;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import org.jvnet.substance.SubstanceLookAndFeel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import java.awt.CardLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import logica.Articulo;
import logica.Cliente;
import logica.FileHelper;
import logica.Regalo;
import logica.Tabla;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ListSelectionModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Toolkit;

import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

@SuppressWarnings({ "unused", "serial" })
public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelNorte;
	private JLabel lblEiiMarket;
	private JPanel panel_1;
	private JPanel panelIzquierda;
	private JPanel panelCentro;
	private JPanel panel;
	private JButton btInicioSesion;
	private JButton btCarrito;
	private JLabel lblNewLabel_3;
	private JMenuBar menuBar;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextArea txtrPuedesConsultarTodos;
	private JPanel panel_5;
	public boolean  regis = false;
	public boolean abrir = true;
	private JButton btConsolas;
	private JButton btFotograf�a;
	private JButton btTelefonia;
	private JButton btOrdenadores;
	private JButton btVideoVigilancia;
	private JPanel panel_6;
	private JPanel panelNovedades;
	private JPanel panelMasVendidos;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane;
	private FileHelper file;
	private JPanel panelNov;
	private DefaultTableModel modelo;
	private Tabla tabla;
	private JTable tablaNovedades;
	private JScrollPane scrollPane_1;
	private JTable tablaMasVendidos;
	private static VentanaDatos cc;
	private static VentanaPuntos vpunto;
	
	//Categorias al azar
	private boolean conVid = false;
	private boolean fotVi = false;
	private boolean tef = false;
	private boolean ordena = false;
	private boolean videoVigi = false;
	

	public String nombreUsuario;
	
	private ArrayList <Articulo> TodosArticulos;
	private ArrayList <Articulo> telefonos;
	private ArrayList <Articulo> videovigilancia;
	private ArrayList <Articulo> consolas;
	private ArrayList <Articulo> fotografia;
	private ArrayList <Articulo> ordenadores;
	private ArrayList <String> contrase�a;
	private ArrayList <String> usuario;
	private ArrayList <String> nif;
	
	private ArrayList <String> moro;
	
	private ArrayList <Cliente> client;
	private ArrayList <Regalo> regalos;
	
	private ArrayList<String> carro = new ArrayList<String>();
	private ArrayList<String>repetidos = new ArrayList<String>();
	
	
	private JPanel panelBotonesNovedades;
	private JButton botonA�adirNovedades;
	private JButton botonVerMasNovedades;
	private JPanel panelBotonesMasVendidos;
	private JButton botonA�adirMasVendidos;
	private JButton botonVerMasVendidos;
	
	private static VentanaCarro vc;
	private static InicioSesion is;
	
	private Productos productos;
	private JButton btInicio;
	private JLabel lblNewLabel;
	private JLabel lbOferta;
	
	private boolean inicioSesion = false;
	
	public boolean isInicioSesion(){
		return inicioSesion;
	}
	public void setInicioSesionTrue() {
		this.inicioSesion = true;
	}

	public void setInicioSesionFalse(){
		this.inicioSesion = false;
	}

	private ArrayList <Regalo> reg = new ArrayList<Regalo>();
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem ayuda;
	
	public ArrayList<Regalo> getReg(){
		return reg;
	}

	
	private static VentanaFactura vf;
	
	public ArrayList<String> getMoro(){
		return moro;
	}
	
	public boolean isConVid() {
		return conVid;
	}

	public boolean isFotVi() {
		return fotVi;
	}

	public boolean isTef() {
		return tef;
	}

	public boolean isOrdena() {
		return ordena;
	}

	public boolean isVideoVigi() {
		return videoVigi;
	}

	public JTable getTabNovedades(){
		return tablaNovedades;
	}
	
	public JTable getTabMasVendidos(){
		return tablaMasVendidos;
	}
	
	public boolean isRegis() {
		return regis;
	}
	public String getNombreUsuario(){
		return nombreUsuario;
	}
	public ArrayList<Articulo> getTodosArticulos() {
		return TodosArticulos;
	}
	public ArrayList<Articulo> getTelefonos() {
		return telefonos;
	}
	public ArrayList<Articulo> getVideovigilancia() {
		return videovigilancia;
	}
	public ArrayList<Articulo> getConsolas() {
		return consolas;
	}
	public ArrayList<Articulo> getFotografia() {
		return fotografia;
	}
	public ArrayList<Articulo> getOrdenadores() {
		return ordenadores;
	}
	public ArrayList<Cliente> getClient(){
		return client;
	}
	public ArrayList<Regalo> getRegalos(){
		return regalos;
	}
	
	public ArrayList<String> getCarro() {
		return carro;
	}
	public ArrayList<String> getRepetidos() {
		return repetidos;
	}
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					VentanaPrincipal frame = new VentanaPrincipal(vc, cc, is, vf);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public VentanaPrincipal(VentanaCarro vcc, VentanaDatos ccc, InicioSesion iss, VentanaFactura vff) throws IOException {
		setTitle("EII Market");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.jpg.png")));
		
		vf=vff;
		vc = vcc;
		cc = ccc;
		is = iss;
		
		file = new FileHelper();
		
		file.leerDatosMorosos("files/morosos.dat");
		file.leerDatosArticulo("files/articulos.dat");
		file.leerDatosClientes("files/clientes.dat");
		file.leerDatosArticuloMasVendido("files/masVendidos.dat");
		file.leerDatosArticuloNovedades("files/novedades.dat");
		file.leerDatosRegalos("files/regalos.dat");
		
		
		tabla = new Tabla();
		modelo =new DefaultTableModel();
		
		tablaNovedades = new JTable();
		tablaNovedades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tablaNovedades.setFont(new Font("Dialog", Font.BOLD, 17));
		tablaNovedades.setDefaultRenderer(Object.class, tabla);
		tablaNovedades.setModel(modelo);
		
		tablaMasVendidos = new JTable();
		tablaMasVendidos.setFont(new Font("Dialog", Font.BOLD, 17));
		tablaMasVendidos.setDefaultRenderer(Object.class, tabla);
		tablaMasVendidos.setModel(modelo);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 962);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		repetidos.add("d");
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		contentPane.add(getPanelIzquierda(), BorderLayout.WEST);
		contentPane.add(getPanel_2_1(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		telefonos = file.getTelefonos();
		videovigilancia = file.getVideovigilancia();
		consolas = file.getConsolas();
		fotografia = file.getFotografia();
		ordenadores = file.getOrdenadores();
		TodosArticulos = file.getArticulos();
		client = file.getCliente();
		regalos = file.getRegalos();
		moro = file.getMorosos();
		for(int i=0; i<moro.size(); i++)
		{
			System.out.println(moro.get(i));
		}
		
		
		categoriasAzar();
		tabla.a�adirArticulos(tablaMasVendidos, file.getArticulosMasVendidos(), this);
		tabla.a�adirArticulos(tablaNovedades, file.getArticulosNovedades(), this);
		cargaAyuda();
	}
	
	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setLayout(new BorderLayout(0, 0));
			panelNorte.add(getLblEiiMarket(), BorderLayout.WEST);
			panelNorte.add(getPanel_1(), BorderLayout.CENTER);
		}
		return panelNorte;
	}
	private JLabel getLblEiiMarket() {
		if (lblEiiMarket == null) {
			lblEiiMarket = new JLabel("EII Market");
			lblEiiMarket.setFont(new Font("Segoe WP Black", Font.PLAIN, 43));
			lblEiiMarket.setForeground(Color.ORANGE);
			lblEiiMarket.setBackground(Color.WHITE);
		}
		return lblEiiMarket;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getPanel_4(), BorderLayout.EAST);
			panel_1.add(getLblNewLabel_3(), BorderLayout.SOUTH);
			panel_1.add(getLblNewLabel_4(), BorderLayout.NORTH);
			panel_1.add(getLblNewLabel_5(), BorderLayout.CENTER);
		}
		return panel_1;
	}
	private JPanel getPanelIzquierda() {
		if (panelIzquierda == null) {
			panelIzquierda = new JPanel();
			panelIzquierda.setLayout(new BorderLayout(0, 0));
			panelIzquierda.add(getPanel_2(), BorderLayout.CENTER);
			panelIzquierda.add(getPanel_3_1(), BorderLayout.NORTH);
		}
		return panelIzquierda;
	}
	private JPanel getPanel_2_1() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setLayout(new BorderLayout(0, 0));
			panelCentro.add(getPanel_6(), BorderLayout.CENTER);
		}
		return panelCentro;
	}
	private JPanel getPanel_4() {
		if (panel == null) {
			panel = new JPanel();
			FlowLayout fl_panel = new FlowLayout(FlowLayout.LEADING, 5, 5);
			panel.setLayout(fl_panel);
			panel.add(BtInicio());
			panel.add(getBtInicioSesion());
			panel.add(getBtCarrito());
		}
		return panel;
	}
	private JButton getBtInicioSesion() {
		if (btInicioSesion == null) {
			btInicioSesion = new JButton("Iniciar sesi\u00F3n");
			btInicioSesion.setMnemonic('I');
			btInicioSesion.setFont(new Font("Dialog", Font.BOLD, 12));
			btInicioSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaInicioSesion();
				}
			});
		}
		return btInicioSesion;
	}
	private JButton getBtCarrito() {
		if (btCarrito == null) {
			btCarrito = new JButton("Carro");
			btCarrito.setMnemonic('C');
			btCarrito.setFont(new Font("Dialog", Font.BOLD, 12));
			btCarrito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						mostrarVentanaCarrito();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btCarrito;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel(".");
			lblNewLabel_3.setBackground(Color.BLACK);
			lblNewLabel_3.setForeground(Color.BLACK);
			lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 5));
		}
		return lblNewLabel_3;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
		}
		return menuBar;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("    EII Market es una de las tiendas online m\u00E1s populares a nivel nacional. \r\n\t\t      ");
			lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("    Te ofrecemos multitud de art\u00EDculos tecnol\u00F3gicos, visite nuestros cat\u00E1logos.");
			lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return lblNewLabel_5;
	}
	
	/**
	 * M�todo para mostrar la ventana del carro
	 * @throws IOException
	 */
	private void mostrarVentanaCarrito() throws IOException{
		VentanaCarro vc= new VentanaCarro(this, is);
		vc.setVisible(true);
	}
	
	/**
	 * M�todo para mostrar la ventana de inicio sesi�n
	 */
	private void mostrarVentanaInicioSesion(){
		InicioSesion is = new InicioSesion(this);
		is.setVisible(true);
	}

	/**
	 * M�todo para la ventana ver m�s en novedades
	 */
	private void mostrarVentanaVerMasNovedades(){
		VerMas v = new VerMas(this);
		v.buscarArticulos(tablaNovedades, TodosArticulos);
		v.setVisible(true);
	}
	
	/**
	 * M�todo para mostrar la ventana ver m�s en mas vendidos
	 */
	private void mostrarVentanaVerMasMasVendidos(){
		VerMas v = new VerMas(this);
		v.buscarArticulos(tablaMasVendidos, TodosArticulos);
		v.setVisible(true);
	}
	
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getPanel_5(), BorderLayout.CENTER);
		}
		return panel_2;
	}
	private JPanel getPanel_3_1() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getTxtrPuedesConsultarTodos());
		}
		return panel_3;
	}
	private JTextArea getTxtrPuedesConsultarTodos() {
		if (txtrPuedesConsultarTodos == null) {
			txtrPuedesConsultarTodos = new JTextArea();
			txtrPuedesConsultarTodos.setFont(new Font("Dialog", Font.PLAIN, 15));
			txtrPuedesConsultarTodos.setEditable(false);
			txtrPuedesConsultarTodos.setText("Puedes consultar todos nuestros \r\nart\u00EDculos haciendo click en las \r\nsiguientes categor\u00EDas:");
		}
		return txtrPuedesConsultarTodos;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.add(getBtConsolas());
			panel_5.add(getBtFotograf�a());
			panel_5.add(getBtTelefonia());
			panel_5.add(getBtOrdenadores());
			panel_5.add(getBtVideoVigilancia());
			panel_5.add(getLblNewLabel());
			panel_5.add(getLbOferta());
		}
		return panel_5;
	}
	private JButton getBtConsolas() {
		if (btConsolas == null) {
			btConsolas = new JButton("Consolas y Videojuegos");
			btConsolas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaProductosConsolas();
				}
			});
			btConsolas.setMnemonic('s');
			btConsolas.setFont(new Font("Dialog", Font.BOLD, 14));
			btConsolas.setBounds(0, 0, 233, 37);
		}
		return btConsolas;
	}
	
	
	private JButton getBtFotograf�a() {
		if (btFotograf�a == null) {
			btFotograf�a = new JButton("Fotograf\u00EDa y v\u00EDdeo");
			btFotograf�a.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaProductosFotografia();
				}
			});
			btFotograf�a.setMnemonic('F');
			btFotograf�a.setFont(new Font("Dialog", Font.BOLD, 14));
			btFotograf�a.setBounds(0, 40, 233, 37);
		}
		return btFotograf�a;
	}
	private JButton getBtTelefonia() {
		if (btTelefonia == null) {
			btTelefonia = new JButton("Telefon\u00EDa m\u00F3vil");
			btTelefonia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaProductosTelefonia();
				}
			});
			btTelefonia.setMnemonic('T');
			btTelefonia.setFont(new Font("Dialog", Font.BOLD, 14));
			btTelefonia.setBounds(0, 80, 233, 37);
		}
		return btTelefonia;
	}
	private JButton getBtOrdenadores() {
		if (btOrdenadores == null) {
			btOrdenadores = new JButton("Ordenadores y tablets");
			btOrdenadores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaProductosOrdenadores();
				}
			});
			btOrdenadores.setMnemonic('O');
			btOrdenadores.setFont(new Font("Dialog", Font.BOLD, 14));
			btOrdenadores.setBounds(0, 121, 233, 37);
		}
		return btOrdenadores;
	}
	private JButton getBtVideoVigilancia() {
		if (btVideoVigilancia == null) {
			btVideoVigilancia = new JButton("Videovigilancia");
			btVideoVigilancia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaProductosVideovigilancia();
				}
			});
			btVideoVigilancia.setMnemonic('V');
			btVideoVigilancia.setFont(new Font("Dialog", Font.BOLD, 14));
			btVideoVigilancia.setBounds(0, 162, 233, 37);
		}
		return btVideoVigilancia;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(new GridLayout(2, 0, 0, 0));
			panel_6.add(getPanelNovedades());
			panel_6.add(getPanelMasVendidos());
		}
		return panel_6;
	}
	private JPanel getPanelNovedades() {
		if (panelNovedades == null) {
			panelNovedades = new JPanel();
			panelNovedades.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panelNovedades.setLayout(new BorderLayout(0, 0));
			panelNovedades.add(getLblNewLabel_2(), BorderLayout.NORTH);
			panelNovedades.add(getScrollPane(), BorderLayout.CENTER);
			panelNovedades.add(getPanelBotonesNovedades(), BorderLayout.SOUTH);
		}
		return panelNovedades;
	}
	private JPanel getPanelMasVendidos() {
		if (panelMasVendidos == null) {
			panelMasVendidos = new JPanel();
			panelMasVendidos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panelMasVendidos.setLayout(new BorderLayout(0, 0));
			panelMasVendidos.add(getLblNewLabel_1(), BorderLayout.NORTH);
			panelMasVendidos.add(getScrollPane_1(), BorderLayout.CENTER);
			panelMasVendidos.add(getPanelBotonesMasVendidos(), BorderLayout.SOUTH);
		}
		return panelMasVendidos;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("PRODUCTOS M\u00C1S VENDIDOS");
			lblNewLabel_1.setForeground(Color.RED);
			lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("NOVEDADES");
			lblNewLabel_2.setForeground(Color.RED);
			lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		}
		return lblNewLabel_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTablaNovedades());
			
		}
		return scrollPane;
	}
	
	
	private JTable getTablaNovedades() {
		tablaNovedades.setModel(new DefaultTableModel(
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
		tablaNovedades.setShowVerticalLines(false);
		tablaNovedades.setShowHorizontalLines(false);
		tablaNovedades.setShowGrid(false);

	return tablaNovedades;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTablaMasVendidos());
		}
		return scrollPane_1;
	}
	private JTable getTablaMasVendidos() {
			
			tablaMasVendidos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "Nombre", "Precio","Puntos"
				}
			)
			{
				public boolean isCellEditable(int row, int column){
					return false;
				}
			});
			tablaMasVendidos.setShowVerticalLines(false);
			tablaMasVendidos.setShowHorizontalLines(false);
			tablaMasVendidos.setShowGrid(false);
		
		return tablaMasVendidos;
	}
	
	
	private JPanel getPanelBotonesNovedades() {
		if (panelBotonesNovedades == null) {
			panelBotonesNovedades = new JPanel();
			panelBotonesNovedades.add(getBotonA�adirNovedades());
			panelBotonesNovedades.add(getBotonVerMasNovedades());
		}
		return panelBotonesNovedades;
	}
	private JButton getBotonA�adirNovedades() {
		if (botonA�adirNovedades == null) {
			botonA�adirNovedades = new JButton("A\u00F1adir");
			botonA�adirNovedades.setToolTipText("A\u00F1adir el elemento seleccionado al carrito.");
			botonA�adirNovedades.setMnemonic('A');
			botonA�adirNovedades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tabla.comprobarUnidades(tablaNovedades, TodosArticulos) == false)
					{
						JOptionPane.showMessageDialog(null, "Las existencias de este producto se han terminado.");
					}
					else
					{
						tabla.a�adirCarro(tablaNovedades, repetidos, carro);
					}
				}
			});
			botonA�adirNovedades.setFont(new Font("Dialog", Font.BOLD, 15));
		}
		return botonA�adirNovedades;
	}
	private JButton getBotonVerMasNovedades() {
		if (botonVerMasNovedades == null) {
			botonVerMasNovedades = new JButton("Ver m\u00E1s");
			botonVerMasNovedades.setToolTipText("Haga click para mostrar m\u00E1s informaci\u00F3n acerca del producto.");
			botonVerMasNovedades.setMnemonic('r');
			botonVerMasNovedades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobarNovedades();
					
				}
			});
			botonVerMasNovedades.setFont(new Font("Dialog", Font.BOLD, 15));
		}
		return botonVerMasNovedades;
	}
	private JPanel getPanelBotonesMasVendidos() {
		if (panelBotonesMasVendidos == null) {
			panelBotonesMasVendidos = new JPanel();
			panelBotonesMasVendidos.add(getBotonA�adirMasVendidos());
			panelBotonesMasVendidos.add(getBotonVerMasVendidos());
		}
		return panelBotonesMasVendidos;
	}
	private JButton getBotonA�adirMasVendidos() {
		if (botonA�adirMasVendidos == null) {
			botonA�adirMasVendidos = new JButton("A\u00F1adir");
			botonA�adirMasVendidos.setToolTipText("A\u00F1adir el elemento seleccionado al carrito.");
			botonA�adirMasVendidos.setMnemonic('�');
			botonA�adirMasVendidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tabla.comprobarUnidades(tablaMasVendidos, TodosArticulos) == false)
					{
						JOptionPane.showMessageDialog(null, "Las existencias de este producto se han terminado.");
					}
					else
					{
						tabla.a�adirCarro(tablaMasVendidos, repetidos, carro);
					}
				}
			});
			botonA�adirMasVendidos.setFont(new Font("Dialog", Font.BOLD, 15));
		}
		return botonA�adirMasVendidos;
	}
	private JButton getBotonVerMasVendidos() {
		if (botonVerMasVendidos == null) {
			botonVerMasVendidos = new JButton("Ver m\u00E1s");
			botonVerMasVendidos.setToolTipText("Haga click para mostrar m\u00E1s informaci\u00F3n acerca del producto.");
			botonVerMasVendidos.setMnemonic('m');
			botonVerMasVendidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobarMasVendidos();
					
				}
			});
			botonVerMasVendidos.setFont(new Font("Dialog", Font.BOLD, 15));
		}
		return botonVerMasVendidos;
	}
	
	/**
	 * M�todo para mostrar la ventana consolas
	 */
	private void mostrarVentanaProductosConsolas(){
		Productos prod = new Productos(this);
		prod.botonConsolas();
		prod.setVisible(true);
	}
	
	/**
	 * M�todo para mostrar la ventana fotograf�a
	 */
	private void mostrarVentanaProductosFotografia(){
		Productos prod = new Productos(this);
		prod.botonFotografia();
		prod.setVisible(true);
	}
	
	/**
	 * M�todo para mostrar la ventana telefon�a m�vil
	 */
	private void mostrarVentanaProductosTelefonia(){
		Productos prod = new Productos(this);
		prod.botonTelefonos();
		prod.setVisible(true);
	}
	
	/**
	 * M�todo para mostrar la ventana de ordenadores
	 */
	private void mostrarVentanaProductosOrdenadores(){
		Productos prod = new Productos(this);
		prod.botonOrdenadores();
		prod.setVisible(true);
	}
	
	/**
	 * Ventana para mostrar la ventana de productos de vigilancia
	 */
	private void mostrarVentanaProductosVideovigilancia(){
		Productos prod = new Productos(this);
		prod.botonVideovigilancia();
		prod.setVisible(true);	
	}
	
	private JButton BtInicio() {
		if (btInicio == null) {
			btInicio = new JButton("");
			btInicio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					for(int i=0; i<client.size(); i++)
					{
						if(btInicio.getText().equals(client.get(i).getUsuario()))
						{
							JOptionPane.showMessageDialog(null, "Bienvenido.\n"
									+ "Echale un vistazo a todos nuestros productos y ll�vate los que m�s te gusten.\nMis puntos: " + client.get(i).getPuntos());
						}
					}
				}
			});
			btInicio.setVisible(false);
		}
		return btInicio;
	}
	
	public JButton getBtInicio() {
		return btInicio;
	}
	
	/**
	 * M�todo que elige una categor�a al azar que estar� en oferta
	 */
	private void categoriasAzar(){
		int aleatorio = (int) (Math.random()*5);
		if(aleatorio == 0)
		{
			conVid = true;
			lbOferta.setText("Consolas y videojuegos");
		}
		else if(aleatorio == 1)
		{
			fotVi = true;
			lbOferta.setText("Fotograf�a y v�deo");
		}
		else if(aleatorio == 2)
		{
			tef = true;
			lbOferta.setText("Telefon�a m�vil");
		}
		else if(aleatorio == 3)
		{
			ordena = true;
			lbOferta.setText("Ordenadores y tablets");
		}
		else
		{
			videoVigi = true;
			lbOferta.setText("Videovigilancia");
		}
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Categor\u00EDa en oferta:");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
			lblNewLabel.setBounds(10, 221, 213, 37);
		}
		return lblNewLabel;
	}
	private JLabel getLbOferta() {
		if (lbOferta == null) {
			lbOferta = new JLabel("");
			lbOferta.setForeground(Color.BLUE);
			lbOferta.setFont(new Font("Dialog", Font.BOLD, 15));
			lbOferta.setBounds(10, 255, 213, 20);
		}
		return lbOferta;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("EII Market");
			mnNewMenu.setMnemonic('K');
			mnNewMenu.setFont(new Font("Dialog", Font.BOLD, 13));
			mnNewMenu.add(getMntmNewMenuItem());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Salir");
			mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			mntmNewMenuItem.setMnemonic('l');
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			mntmNewMenuItem.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return mntmNewMenuItem;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("Ayuda");
			mnNewMenu_1.setMnemonic('Y');
			mnNewMenu_1.setFont(new Font("Dialog", Font.BOLD, 13));
			mnNewMenu_1.add(getAyuda());
			mnNewMenu_1.add(getMntmNewMenuItem_1());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("Acerca de");
			mntmNewMenuItem_1.setMnemonic('d');
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Pelayo Garc�a Torre.\nEscuela de Ingenier�a Inform�tica, Oviedo\nUO251143\nEII MARKET V9.0");
				}
			});
			mntmNewMenuItem_1.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return mntmNewMenuItem_1;
	}
	
	/**
	 * M�todo para cargar la ayuda
	 */
	private void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		   try {
			    File fichero = new File("help/Ayuda.hs");
			    hsURL = fichero.toURI().toURL();
			    hs = new HelpSet(null, hsURL);
		}

		    catch (Exception e){
		      System.out.println("Ayuda no encontrada");
		     return;
		   }

		   HelpBroker hb = hs.createHelpBroker();
		   hb.initPresentation();

		   hb.enableHelpKey(getRootPane(),"introduccion", hs);
		   hb.enableHelpOnButton(ayuda, "introduccion", hs);
		   hb.enableHelp(lbOferta, "alias html concreto", hs);
		   
		 }
	private JMenuItem getAyuda() {
		if (ayuda == null) {
			ayuda = new JMenuItem("Mostrar");
			ayuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
			ayuda.setMnemonic('o');
			ayuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			ayuda.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return ayuda;
	}
	
	/**
	 * M�todo que comprueba que se haya seleccionado un producto para mostrar su informaci�n
	 */
	private void comprobarMasVendidos(){
		
			if(tablaMasVendidos.getRowCount() != 0 && tablaMasVendidos.getSelectedRow() != -1)
			{
				mostrarVentanaVerMasMasVendidos();
			}
	}
	/**
	 * M�todo que comprueba que se haya seleccionado un producto para mostrar su informaci�n
	 */
	private void comprobarNovedades(){
		
			if(tablaNovedades.getRowCount() != 0 && tablaNovedades.getSelectedRow() != -1)
			{
				mostrarVentanaVerMasNovedades();
			}
	}
}

