package Voluntariado;

public class Agenda {
	private String titulo, data, hora, descri��o, a��o;

	public Agenda(String titulo, String data, String hora, String descri��o, String a��o) {
		super();
		this.titulo = titulo;
		this.data = data;
		this.hora = hora;
		this.descri��o = descri��o;
		this.a��o = a��o;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescri��o() {
		return descri��o;
	}

	public void setDescri��o(String descri��o) {
		this.descri��o = descri��o;
	}

	public String getA��o() {
		return a��o;
	}

	public void setA��o(String a��o) {
		this.a��o = a��o;
	}
	
	
	
}
