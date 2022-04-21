import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

		public static void main(String[] args) throws SQLException {
		     
			ConnectionFactory connectionFactory = new ConnectionFactory(); 
			Connection connection = connectionFactory.recuperarconexao();
			
			PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICACAO FROM PRODUTO");
			stm.execute();
			
			ResultSet rst = stm.getResultSet();
			
			while(rst.next()) {
				Integer id = rst.getInt("ID");
				System.out.println(id);
			String nome = rst.getNString("NOME");
			System.out.println(nome);
			String descricacao = rst.getNString("DESCRICACAO"); 
		    System.out.println(descricacao);
			}
		connection.close();

	}

}
