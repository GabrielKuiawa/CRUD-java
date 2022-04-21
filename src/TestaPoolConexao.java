import java.sql.SQLException;

public class TestaPoolConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
     
		for (int i=0; i < 20;i++ ) {
			connectionFactory.recuperarconexao();
			System.out.println("conexão número " + i);
		}
	}

}
