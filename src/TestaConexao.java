import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
   public static void main(String[] args) throws SQLException {
	

	ConnectionFactory connectionFactory = new ConnectionFactory(); 
	Connection connection = connectionFactory.recuperarconexao();
	
	 System.out.println("conexao obtida");
	
	connection.close();
	
	}

}
