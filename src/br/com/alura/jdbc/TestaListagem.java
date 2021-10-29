package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO"); // Statement é usado pra lançarmos querys
		stm.execute();
		
		ResultSet rst = stm.getResultSet();	// retorna o resultado da query (select retorna uma lista, no caso, temos uma lista de produtos com id, nome e descricao)
		
		while(rst.next()) { // enquanto houver um prox elemento, faça: (aqui estamos recuperando informações da tabela)
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String nome = rst.getString("NOME");
			System.out.println(nome);
			String descricao = rst.getString("DESCRICAO");	
			System.out.println(descricao);
		}
		
//		boolean resultado = stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
//		// Esse método retorna true para querys que têm retorno (ex: select) e false para querys sem retorno (ex: delete, insert)
//		System.out.println(resultado);
		
		con.close();
	}

}
