package Voluntariado;

public class Agenda {
	private String titulo, data, hora, descrição, ação;

	public Agenda(String titulo, String data, String hora, String descrição, String ação) {
		super();
		this.titulo = titulo;
		this.data = data;
		this.hora = hora;
		this.descrição = descrição;
		this.ação = ação;
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

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public String getAção() {
		return ação;
	}

	public void setAção(String ação) {
		this.ação = ação;
	}
	
	
	
}
