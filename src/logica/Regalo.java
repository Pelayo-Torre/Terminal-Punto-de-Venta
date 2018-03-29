package logica;

public class Regalo {

	private String codigo;
	private String categoria;
	private String denominacion;
	private int valor;
	
	public Regalo(String cod, String cat, String deno, int val)
	{
		codigo = cod;
		categoria = cat;
		denominacion = deno;
		valor = val;
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

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String toString(){
		return(getCodigo()+";"+getCategoria()+";"+getDenominacion()+";"+getValor());
	}
}
