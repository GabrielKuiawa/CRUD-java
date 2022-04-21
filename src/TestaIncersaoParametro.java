

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class TestaIncersaoParametro {

			public static void main(String[] args) throws SQLException {
			
			ConnectionFactory connectionFactory = new ConnectionFactory(); 
			try (Connection connection = connectionFactory.recuperarconexao();){
			
			connection.setAutoCommit(false);
			
			 try(PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricacao) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);){				   
				    
				    adicionarVariavel("maria ", "alan", stm);
				    adicionarVariavel("doida", "thiago", stm);
				    
				    connection.commit();
				    stm.close();
				    connection.close();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("rollback");
				connection.rollback();
			}
			}
	}

			private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm)
					throws SQLException {
				stm.setString(1, nome);
				stm.setString(2, descricao);
				
                        /*     if(nome.equals("celular")) {
                             throw  new RuntimeException("não deu certo");	 
                             }*/
						stm.execute();       

				try (ResultSet rst = stm.getGeneratedKeys();){
				while(rst.next()) {
					Integer id= rst.getInt(1);
					System.out.println("o id é "+id);
				}
				
}
			}
	
}
