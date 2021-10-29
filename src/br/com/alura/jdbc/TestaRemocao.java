package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ? "); // prepare statement congela a query pra pordemos usá-la do jeito q declaramos aqui, por isso q podemos usar aqueles '?'
		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount(); // retorna quantas linhas foram modificadas após a ação
		
		System.out.println("Linhas modificadas: " + linhasModificadas);
	}
	
}
