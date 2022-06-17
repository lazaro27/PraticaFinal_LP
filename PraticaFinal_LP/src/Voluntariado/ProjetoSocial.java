package Voluntariado;

import java.awt.EventQueue;
import java.util.ArrayList;

public class ProjetoSocial {
	
	private String titulo, objetivo, endereco, data, status;
				
	public ProjetoSocial(String titulo, String objetivo, String endereco, String data, String status) {
		super();
		this.titulo = titulo;
		this.objetivo = objetivo;
		this.endereco = endereco;
		this.data = data;
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static void main(String[] args) {		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
										
			     	Tela frame = new Tela();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			
	}

	}


