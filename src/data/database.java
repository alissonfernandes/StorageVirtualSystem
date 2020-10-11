package data;

import control.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import data.Conexao;
import control.Produto;

public class Database {
	
	public static void cadastrar() throws SQLException{
		Conexao connect = new Conexao();
		connect.connect();
		
		String insert = "insert into produto(id, nome, preco, tipo, desconto, gtin, descricao, quantidade)"
						+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = Conexao.iserirDado(insert);
		
		try {
			System.out.println(Produto.getPreco());
			
			ps.setInt(1, Produto.getId());
			ps.setString(2, Produto.getNome());
			ps.setFloat(3, Produto.getPreco());
			ps.setString(4, Produto.getTipo());
			ps.setFloat(5, Produto.getDesconto());
			ps.setInt(6, Produto.getGtin());
			ps.setString(7, Produto.getDescr());
			ps.setInt(8, Produto.getQuant());
			
			int res = ps.executeUpdate();
			
			if(res == 1) {
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
			} else if (res == 0) {
				JOptionPane.showMessageDialog(null, "Dado n�o inserido:\nErro desconhecido", "Falha na inser��o", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception error) {
			JOptionPane.showMessageDialog(null, error, "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
		
		connect.desconnection();
	}
}
