package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import control.Methods;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        Home frame = new Home();
			frame.setLocationRelativeTo(null);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setVisible(true);
                    } catch (Exception e) {
			e.printStackTrace();
				}
                });
	}

	//Interface principal
	
	public Home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Invictus\\Downloads\\Logo-Tipo-T.ico"));
		setTitle("Controle de Estoque");
		setFont(new Font("Arial", Font.PLAIN, 14));
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
		//Inicio da cria��o do menu superior
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mnConf = new JMenuItem("Configura\u00E7\u00F5es");
		mnInicio.add(mnConf);
		
		JMenuItem mnClose = new JMenuItem("Sair");
		mnClose.addActionListener((e) -> {
                    Methods metodo = new Methods();
                    metodo.sair();
                });
		mnInicio.add(mnClose);
		
		JMenu mnGestao = new JMenu("Gerenciar Produtos");
		menuBar.add(mnGestao);
		
		JMenuItem mnAdic = new JMenuItem("Adicionar Produtos");
		mnAdic.addActionListener((e) -> abrir("adicionar"));
		mnGestao.add(mnAdic);
		
		JMenuItem mnEdit = new JMenuItem("Editar Produtos");
                mnEdit.addActionListener((e) -> {
                    // Metodo a ser implementado
                });
		mnGestao.add(mnEdit);
		
		JMenuItem mnRemov = new JMenuItem("Remover Produtos");
		mnRemov.addActionListener((e) -> abrir("remove"));
		mnGestao.add(mnRemov);
		
		JMenu mnBusca = new JMenu("Busca");
		menuBar.add(mnBusca);
		
		JMenuItem mnBuscNome = new JMenuItem("Buscar Produtos por Nome");
                mnBuscNome.addActionListener((e) -> {
                    //Metodo a ser implementado
                });
		mnBusca.add(mnBuscNome);
		
		JMenuItem mnBuscID = new JMenuItem("Buscar Produtos por ID");
                mnBuscID.addActionListener((e) -> {
                    //Metodo a ser implementado
                });
		mnBusca.add(mnBuscID);
		
		JMenuItem mnBuscQuant = new JMenuItem("Buscar Produtos por Quantidade");
                mnBuscQuant.addActionListener((e) -> {
                    //Metodo a ser implementado
                });
		mnBusca.add(mnBuscQuant);
		
		JMenuItem mnBuscPreco = new JMenuItem("Buscar Produtos por Pre\u00E7o");
                mnBuscPreco.addActionListener((e) -> {
                    //Metodo a ser implementado
                });
		mnBusca.add(mnBuscPreco);
		
		JMenu mnLogist = new JMenu("Entrada / Sa\u00EDda");
		menuBar.add(mnLogist);
		
		JMenuItem mnEntrada = new JMenuItem("Entrada no Estoque");
                mnEntrada.addActionListener((e) -> {
                    //Metodo a ser implemetado
                });
		mnLogist.add(mnEntrada);
		
		JMenuItem mnSaida = new JMenuItem("Saida do Estoque");
                mnSaida.addActionListener((e) -> {
                    //Metodo a ser implementado
                });
		mnLogist.add(mnSaida);
		
		JMenuItem mnBalanco = new JMenuItem("Balan\u00E7o");
                mnBalanco.addActionListener((e) -> {
                    //Metodo a ser implementado
                });
		mnLogist.add(mnBalanco);
		
		JMenu mnExtorno = new JMenu("Devolu\u00E7\u00E3o");
		menuBar.add(mnExtorno);
		
		JMenuItem mnDev = new JMenuItem("Devolu\u00E7\u00E3o");
                mnDev.addActionListener((e) -> {
                    //Implemente aqui o seu codigo
                });
		mnExtorno.add(mnDev);
		
		JMenuItem mnQuebra = new JMenuItem("Quebra");
                mnQuebra.addActionListener((e) -> {
                    //Implemente aqui o seu codigo
                });
		mnExtorno.add(mnQuebra);
		
		JMenuItem mnVencido = new JMenuItem("Vencido");
                mnVencido.addActionListener((e) -> {
                    //Implemente aqui o seu codigo
                });
		mnExtorno.add(mnVencido);
		
		JMenu mnFinanceiro = new JMenu("Financeiro");
		menuBar.add(mnFinanceiro);
		
		JMenuItem mnConsulta = new JMenuItem("Consulta Financeira");
                mnConsulta.addActionListener((e) -> {
                    //Implemente aqui o seu codigo
                });
		mnFinanceiro.add(mnConsulta);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setIcon(new ImageIcon("C:\\Users\\Invictus\\Downloads\\Logo Tipo T.jpg"));
		getContentPane().add(label, BorderLayout.EAST);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	
	//M�todo de verifica��o para abrir novas janelas
	
	private void abrir(String janela) {
		switch(janela) {
			case "adicionar":
				Adicionar adic = new Adicionar();
				adic.setVisible(true);
				JOptionPane.showMessageDialog(null, "Obrigat�rio o preenchimento dos campos ID, Nome, Pre�o\nUtilize o '.' no lugar da ',' em pre�o e desconto, n�o utilize o ponto na casa dos milhares", "ATEN��O", JOptionPane.WARNING_MESSAGE);
				break;
				
			case "remove":
				Remove rmv = new Remove();
				rmv.setVisible(true);
				break;
			
			default:
				break;
		}
	}
}
