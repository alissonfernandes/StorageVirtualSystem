package control;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Methods {
	
	/*
	 * M�todo para sair do sistema com seguran�a
	 * Ainda ser� implementado uma verifica��o para fazer o fechamento correto do sistema
	 * fechando todos os arquivos e verificando se n�o ter� nenhum arquivo prejudicado com o fechamento
	 */
	public void sair() {
		int res = 1;
		Object[] options = { "Sair", "Cancelar" };
		res = JOptionPane.showOptionDialog(null, "Deseja realmente fechar o sistema?", "Sair", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(res == 0) {
			try {
				FileReader arq = new FileReader("data/products.pdt");
				BufferedReader ler = new BufferedReader(arq);
			
				arq.close();
				ler.close();
				
				System.exit(0);
			} catch(Exception error) {
				JOptionPane.showMessageDialog(null, error, "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	//M�todo de cria��o de janela de confirma��o generica
	public boolean confirm(String ir, String voltar, String msg) {
		int res = 1;
		Object[] options = { ir, voltar };
		res = JOptionPane.showOptionDialog(null, msg, ir, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(res == 0) {
			return true;
		}
		
		return false;
	}
	
	//M�todo que verifica se o valor � inteiro
	public boolean verifInt(String valor) {
		boolean value = false;
		
		try {
			Integer.parseInt(valor);
			value = true;
		} catch(Exception error) {
			JOptionPane.showMessageDialog(null, "O campo ID n�o pode esta vazio ou contem caracteres e pontua��o\n" + 
											"O campo ID pode apenas conter numeros inteiros", 
											"Falha ao identiidicar produto", JOptionPane.ERROR_MESSAGE);
			value = false;
		}
		
		return value;
	}
}
