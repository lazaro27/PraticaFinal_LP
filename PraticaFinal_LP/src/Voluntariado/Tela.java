package Voluntariado;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.List;

public class Tela extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JLabel lblNewLabel_1;
	private JTextField textFieldObjetivo;
	private JLabel lblNewLabel_2;
	private JTextField textFieldEndereco;
	private JLabel lblNewLabel_3;
	private JTextField textFieldData;
	private JLabel lblNewLabel_4;
	private JTextField textFieldStatus;
	private JLabel lblNewLabel_5;
	private JButton btnCarregar;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JTextField AgData;
	private JTextField AgHora;
	private JTextField AgDescricao;
	private JTextField AgAcao;
	private JButton btnNewButton_2;
	private List list_1;


	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 0, 1000, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PROJETO SOCIAL");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(393, 11, 198, 22);
		contentPane.add(lblNewLabel);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(122, 67, 164, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		lblNewLabel_1 = new JLabel("T\u00EDtulo:");
		lblNewLabel_1.setBounds(20, 70, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldObjetivo = new JTextField();
		textFieldObjetivo.setBounds(122, 98, 164, 20);
		contentPane.add(textFieldObjetivo);
		textFieldObjetivo.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Objetivo:");
		lblNewLabel_2.setBounds(20, 101, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(122, 134, 164, 20);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Endereco:");
		lblNewLabel_3.setBounds(20, 137, 70, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(122, 165, 164, 20);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Data inicio:");
		lblNewLabel_4.setBounds(20, 168, 70, 14);
		contentPane.add(lblNewLabel_4);
		
		textFieldStatus = new JTextField();
		textFieldStatus.setBounds(122, 196, 164, 20);
		contentPane.add(textFieldStatus);
		textFieldStatus.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Status:");
		lblNewLabel_5.setBounds(20, 199, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Enviar");
		  getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ProjetoSocial p1 = new ProjetoSocial(textFieldTitulo.getText(),textFieldObjetivo.getText(),textFieldEndereco.getText(),textFieldData.getText(),textFieldStatus.getText());				
				textFieldTitulo.setText("");//Limpa o Jtext Field
				textFieldObjetivo.setText("");
				textFieldEndereco.setText("");
				textFieldData.setText("");
				textFieldStatus.setText("");
				Salvar.percistirProjetos(p1);	
				try {
					Salvar.salvarProjeto();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					//Tela.this.dispose();

			}
			
		});
		
		btnNewButton.setBounds(155, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		List list = new List();
		list.setBounds(461, 67, 497, 183);
		contentPane.add(list);
		
		
		btnCarregar = new JButton("Carregar Projetos");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> ArrayDados = new ArrayList<>();
				list.add("****************************** PROJETOS *****************************");
				
				try {
					ArrayDados = Salvar.carregar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(int i= 0; i < ArrayDados.size() ; i++) {
					list.add(ArrayDados.get(i));
				}
				
				list.add("");
			}
		});
		btnCarregar.setBounds(296, 121, 142, 64);
		contentPane.add(btnCarregar);
		
		btnNewButton_1 = new JButton("Editar Dados");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux = 0;
				String titulo = JOptionPane.showInputDialog("Digite o titulo do prjeto:");
				ArrayList<String> Agendas = new ArrayList<>();
				try {
					Agendas = Salvar.carregarAgenda();//Carregas os dados do arquivo .txt para um ArrayList
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				for(int i= 0; i<Agendas.size(); i++) {
					if(Agendas.get(i).contains(titulo)) {			
						aux = i;
					}else {
						titulo = JOptionPane.showInputDialog("PROJETO NÃO ENCONTRADO OU INEXISTENTE!\nDIGITE UM TÍTULO DE PROJETO EXITSTENTE:");
					}
				}
				
				String nova = JOptionPane.showInputDialog(" Atual>> " + Agendas.get(aux) + "\nDigite a nova Agenda");
				Agendas.set(aux, nova);
				try {
					Salvar.AlteraAgenda(Agendas);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(296, 262, 142, 64);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Cadastro do projeto:");
		lblNewLabel_6.setBounds(20, 38, 142, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Cadastro Agenda:");
		lblNewLabel_7.setBounds(20, 312, 142, 14);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Data:");
		lblNewLabel_8.setBounds(20, 352, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Hora:");
		lblNewLabel_9.setBounds(20, 391, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_10.setBounds(20, 424, 89, 14);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("A\u00E7\u00E3o:");
		lblNewLabel_11.setBounds(20, 457, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		AgData = new JTextField();
		AgData.setBounds(122, 349, 164, 20);
		contentPane.add(AgData);
		AgData.setColumns(10);
		
		AgHora = new JTextField();
		AgHora.setBounds(122, 388, 164, 20);
		contentPane.add(AgHora);
		AgHora.setColumns(10);
		
		AgDescricao = new JTextField();
		AgDescricao.setBounds(122, 421, 164, 20);
		contentPane.add(AgDescricao);
		AgDescricao.setColumns(10);
		
		AgAcao = new JTextField();
		AgAcao.setBounds(122, 454, 164, 20);
		contentPane.add(AgAcao);
		AgAcao.setColumns(10);
		
		JButton EnviarAg = new JButton("Enviar");
		EnviarAg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String tituloAg = JOptionPane.showInputDialog("A Qual titulo pertence Esta Agenda?");
			
			Agenda ag = new Agenda(tituloAg, AgData.getText(), AgHora.getText(), AgDescricao.getText(),AgAcao.getText());
			AgData.setText("");
			AgHora.setText("");
			AgDescricao.setText("");
			AgAcao.setText("");
			
			try {
				Salvar.salvarAgenda(ag);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		EnviarAg.setBounds(155, 501, 89, 23);
		contentPane.add(EnviarAg);
		
		list_1 = new List();
		list_1.setBounds(463, 345, 496, 179);
		contentPane.add(list_1);
		
		btnNewButton_2 = new JButton("Carregar Agendas");
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> ArrayAgenda = new ArrayList<>();
				list_1.add("******************************AGENDA ATUALIZADA*****************************");
				try {
					ArrayAgenda = Salvar.carregarAgenda();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				for(int i= 0; i < ArrayAgenda.size() ; i++) {
					list_1.add(ArrayAgenda.get(i));
				}
				list_1.add("");				
			}
		});
		btnNewButton_2.setBounds(296, 381, 142, 64);
		contentPane.add(btnNewButton_2);
		
				
	}
}
