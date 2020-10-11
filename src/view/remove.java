package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Arquivos;
import control.Methods;
import control.Produto;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Remove extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtProd;
	private JTextField txtPreco;
	private JTextField txtQuant;
	private JTextField txtGtin;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        Remove frame = new Remove();
                        frame.setVisible(true);
                    } catch (Exception e) {
			e.printStackTrace();
                    }
                });
	}

	//Interface de remo��o dos itens
	public Remove() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 319, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(63, 11, 118, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JButton btnVerif = new JButton("Verificar");
		JButton btnExcluir = new JButton("Excluir");
		JButton btnCancelar = new JButton("Cancelar");
		
		btnVerif.addActionListener((e) -> {
                    //Chama o m�todo para verificar se o valor no campo ID � inteiro;
                    Methods verificar = new Methods();
                    if(verificar.verifInt(txtID.getText())) {
                        //Chama o m�todo conclus�o para mostrar se � o produto que deve ser excluido
			if(conclusao(txtID.getText())) {
                            btnVerif.setEnabled(false);
                            txtID.setEnabled(false);
                            btnExcluir.setEnabled(true);
			}
                    }
                });
		btnVerif.setBounds(204, 10, 89, 23);
		contentPane.add(btnVerif);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(7, 14, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Produto:");
		lblNome.setBounds(7, 116, 46, 14);
		contentPane.add(lblNome);
		
		txtProd = new JTextField();
		txtProd.setEditable(false);
		txtProd.setColumns(10);
		txtProd.setBounds(75, 113, 118, 20);
		contentPane.add(txtProd);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(7, 141, 46, 14);
		contentPane.add(lblPreo);
		
		txtPreco = new JTextField();
		txtPreco.setEditable(false);
		txtPreco.setColumns(10);
		txtPreco.setBounds(75, 138, 118, 20);
		contentPane.add(txtPreco);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(7, 166, 60, 14);
		contentPane.add(lblQuantidade);
		
		txtQuant = new JTextField();
		txtQuant.setEditable(false);
		txtQuant.setColumns(10);
		txtQuant.setBounds(75, 163, 118, 20);
		contentPane.add(txtQuant);
		
		btnExcluir.addActionListener((e) -> {
                    Methods metodo = new Methods();
                    if(metodo.confirm("Excluir", "Cancelar", "Isso excluira totalmente o item do seu sistema,\n e n�o ter� como recupera-lo\nDeseja prosseguir?")) {
                        Arquivos.excluirItem(txtID.getText());
                    }
                });
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(204, 190, 89, 23);
		contentPane.add(btnExcluir);
		
		txtGtin = new JTextField();
		txtGtin.setEditable(false);
		txtGtin.setColumns(10);
		txtGtin.setBounds(75, 191, 118, 20);
		contentPane.add(txtGtin);
		
		JLabel lblGtin = new JLabel("GTIN:");
		lblGtin.setBounds(7, 191, 60, 14);
		contentPane.add(lblGtin);
		
		btnCancelar.addActionListener((e) -> {
                    btnExcluir.setEnabled(false);
                    btnVerif.setEnabled(true);
                    txtID.setEnabled(true);
                    txtProd.setText("");
                    txtPreco.setText("");
                    txtQuant.setText("");
                    txtGtin.setText("");
                });
		btnCancelar.setBounds(204, 60, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	//M�todo para procurar o item e retornar o valor que foi adicionado no objeto para o TextField
	private boolean conclusao(String id) {
		boolean value = false;
		
		if(Arquivos.verifNotID(id) == false) {
			JOptionPane.showMessageDialog(null, "Esse ID n�o existe nos registros", "ID Inexistente", JOptionPane.ERROR_MESSAGE);
			value = false;
		} else {
			String nome = Arquivos.procurarNome(txtID.getText());
			String preco = Arquivos.procurarPreco(txtID.getText());
			String gtin = Arquivos.procurarGtin(txtID.getText());
			String quant = Arquivos.procurarQuant(txtID.getText());
			
			txtProd.setText(nome);
			txtPreco.setText(preco);
			txtQuant.setText(quant);
			txtGtin.setText(gtin);
			
			value = true;
		}
		
		return value;
	}
}
