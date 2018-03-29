package logica;

public class Articulo {

	private String codigo;
	private String categoria;
	private String subcategoria;
	private String denominacion;
	private String descripcion;
	private double precio;
	private int puntosCompra;
	private int stock;
	


	public Articulo(String cod, String cat, String subcat, String deno, String descrip, double pre, int puntos, int st){
		codigo = cod;
		categoria = cat;
		subcategoria = subcat;
		denominacion = deno;
		descripcion = descrip;
		precio = pre;
		puntosCompra = puntos;
		stock = st;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPuntosCompra() {
		return puntosCompra;
	}

	public void setPuntosCompra(int puntosCompra) {
		this.puntosCompra = puntosCompra;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toString(){
		return(getCodigo()+";"+getCategoria()+";"+getSubcategoria()+";"+getDenominacion()+";"+getDescripcion()+";"+getPrecio()+";"+getPuntosCompra()+";"+getStock());
	}
	
	
	
	
}
