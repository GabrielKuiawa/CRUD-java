import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemcao {

	public static void main(String[] args) throws SQLException {


		ConnectionFactory connectionFactory = new ConnectionFactory(); 
		Connection connection = connectionFactory.recuperarconexao();
		
	    PreparedStatement stm = connection. prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
        stm.setInt(1, 2);
	    stm.execute();
        
        Integer linhasmodificadas  = stm.getUpdateCount();
	
        System.out.println("linhas " + linhasmodificadas);
	
	}

}
