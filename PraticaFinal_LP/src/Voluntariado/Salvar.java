package Voluntariado;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Salvar {
	
	
	static ArrayList<String> ArrayAgenda = new ArrayList<>();
	static ArrayList<String> ArrayProjetos = new ArrayList<>();
	
	public static void percistirProjetos(ProjetoSocial proj) {
		
		ArrayProjetos.add(proj.getTitulo()+";" +proj.getObjetivo() +";" + proj.getEndereco()+";" + proj.getData() + ";" + proj.getStatus() + "\n");

	}
	
	
	
	public static ArrayList<String> carregar() throws IOException {
		ArrayList<String> dados = new ArrayList<>();

		   
		   //linha por linha 
		   String file = "C:/Users/lazar/eclipse-workspace/PraticaFinal_LP/ProjetoSocial.txt";
	        try(BufferedReader br = new BufferedReader(new FileReader(file))) 
	        {
	            String line;
	            while ((line = br.readLine()) != null) {
	            dados.add(line);
	            
	            }
	            br.close(); 
	        }
	        catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	        

	   
		return dados;
	}
	
	public static ArrayList<String> carregarAgenda() throws IOException {
		ArrayList<String> dadosAgenda = new ArrayList<>();

		   
		   //linha por linha 
		   String file = "C:/Users/lazar/eclipse-workspace/PraticaFinal_LP/Agenda.txt";
	        try(BufferedReader br = new BufferedReader(new FileReader(file))) 
	        {
	            String line;
	            while ((line = br.readLine()) != null) {
	            dadosAgenda.add(line);
	            }
	        }
	        catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	    
	   
		return dadosAgenda;
	}
	
	public static void salvarProjeto()throws IOException {
		java.io.File diretorio = new java.io.File("C:\\Users\\lazar\\eclipse-workspace\\PraticaFinal_LP"); 
		boolean statusDir = diretorio.mkdir();
		System.out.print(statusDir); 
		java.io.File arquivo = new java.io.File(diretorio, "ProjetoSocial.txt");	
		  try { 
			  boolean statusArq = arquivo.createNewFile();
		  System.out.print(statusArq);
		  } catch (IOException e){ 
			  e.printStackTrace(); }
		 
		
		FileWriter arq = new FileWriter("C:\\Users\\lazar\\eclipse-workspace\\PraticaFinal_LP\\ProjetoSocial.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		
		for(String ArrayProjetos : ArrayProjetos) {
			gravarArq.printf(ArrayProjetos);
		}
		
		JOptionPane.showMessageDialog(null, "PROJETO SALVO COM SUCESSO!");
		//ArrayProjetos.forEach(ArrayProjetos->gravarArq.printf(ArrayProjetos));
				
		arq.close();
	}
	
	public static void salvarAgenda(Agenda ag) throws IOException {
		ArrayAgenda.add("Projeto:" + ag.getTitulo() +" /   Agenda: " + ag.getData() + ";" + ag.getHora()+";"+ag.getDescrição()+";"+ag.getAção() + "\n");
		
		java.io.File diretorio = new java.io.File("C:\\Users\\lazar\\eclipse-workspace\\PraticaFinal_LP"); 
		boolean statusDir = diretorio.mkdir();
		System.out.print(statusDir); 
		java.io.File arquivo = new java.io.File(diretorio, "Agenda.txt");	
		  try { 
			  boolean statusArq = arquivo.createNewFile();
		  System.out.print(statusArq);
		  } catch (IOException e){ 
			  e.printStackTrace(); }
		 
		
		FileWriter arq = new FileWriter("C:\\Users\\lazar\\eclipse-workspace\\PraticaFinal_LP\\Agenda.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		
		for(String ArrayAgenda : ArrayAgenda) {
			gravarArq.printf(ArrayAgenda);
		}
		
		
		JOptionPane.showMessageDialog(null, "AGENDA SALVA COM SUCESSO!");
		
		arq.close();
	}
	
	public static void AlteraAgenda(ArrayList<String> ArrayAgendas) throws IOException {
		java.io.File diretorio = new java.io.File("C:\\Users\\lazar\\eclipse-workspace\\PraticaFinal_LP"); 
		boolean statusDir = diretorio.mkdir();
		System.out.print(statusDir); 
		java.io.File arquivo = new java.io.File(diretorio, "Agenda.txt");	
		  try { 
			  boolean statusArq = arquivo.createNewFile();
		  System.out.print(statusArq);
		  } catch (IOException e){ 
			  e.printStackTrace(); }
		 
		
		FileWriter arq = new FileWriter("C:\\Users\\lazar\\eclipse-workspace\\PraticaFinal_LP\\Agenda.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		
		for(int i = 0; i<ArrayAgendas.size(); i++) {
			gravarArq.printf(ArrayAgendas.get(i));
		}
		
		JOptionPane.showMessageDialog(null, "AGENDA *ALTERADA* E SALVA COM SUCESSO!");
		
		arq.close();
		
	}


}
