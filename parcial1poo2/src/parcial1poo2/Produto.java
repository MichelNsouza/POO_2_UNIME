package parcial1poo2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Produto {

	public Produto() {}
	
	
	 public void gravarProduto(Connection Conexao, String descricao, double preco) throws SQLException {   
		 
		 Statement declaracao = Conexao.createStatement();
	 
		 String querySQL = "insert into vendas.produto(Descricao, Preco) values(' "+ descricao +" ', "+ preco +")";
	 
		 declaracao.executeUpdate(querySQL);
	 }
	 
	 public void apagarProduto(Connection conexao, int id) throws SQLException {
		 
	     Statement declaracao = conexao.createStatement();
	    
	     String querySQL = "DELETE FROM vendas.produto WHERE Id = " + id;
	        
	     declaracao.executeUpdate(querySQL);
	}
			 
	 public void atualizarProduto(Connection conexao, int id, String descricao, double preco) throws SQLException {
		 
	     Statement declaracao = conexao.createStatement();
	     
		 String querySQL = "UPDATE vendas.produto SET Descricao ='"+descricao+"' , Preco = "+preco+" WHERE Id = "+id+";";


		 declaracao.executeUpdate(querySQL);
		    
	}

	 public ResultSet listarTodosProdutos(Connection Conexao, JTable table) throws SQLException{ 
		 
		 Statement declaracao = Conexao.createStatement();
		 
		 ResultSet rs = declaracao.executeQuery("SELECT * FROM vendas.produto");
	        
	        String[] colunasTabela = {
		        		"Id",
		        		"Descrição",
		        		"Preço"
	        		}; 
	        
	        DefaultTableModel modeloTabela = new DefaultTableModel(colunasTabela, 0); 

	        if (rs != null) {
	            while (rs.next()) {

	                modeloTabela.addRow(new Object[] { 
	                    rs.getInt("Id"), 
	                    rs.getString("Descricao"), 
	                    rs.getDouble("Preco")
	                });
	            }

	            table.setModel(modeloTabela); 
	        }
	        
		 return rs; 
	}
	 
	 public ResultSet listarProdutoId(Connection Conexao, int id, JTable tableProduto) throws SQLException{ 
		 
		 Statement declaracao = Conexao.createStatement();
		 
		 ResultSet rs = declaracao.executeQuery("SELECT * FROM vendas.produto WHERE Id = "+id+";");
		 
	       String[] colunasTabela = {
		        		"Id",
		        		"Descrição",
		        		"Preço"
	       		}; 
	       
	       DefaultTableModel modeloTabela = new DefaultTableModel(colunasTabela, 0); 

	       if (rs != null) {
	           while (rs.next()) {

	               modeloTabela.addRow(new Object[] { 
	                   rs.getInt("Id"), 
	                   rs.getString("Descricao"), 
	                   rs.getDouble("Preco")
	               });
	           }

	           tableProduto.setModel(modeloTabela); 
	       }
	       
		 return rs; 
	}

	public ResultSet listarProdutoDescricao(Connection Conexao, String descricao, JTable tableProduto) throws SQLException{ 
			 
			 Statement declaracao = Conexao.createStatement();
			 
			 ResultSet rs = declaracao.executeQuery("SELECT * FROM vendas.produto WHERE Descricao = '"+descricao+"';");
		        
		        String[] colunasTabela = {
			        		"Id",
			        		"Descrição",
			        		"Preço"
		        		}; 
		        
		        DefaultTableModel modeloTabela = new DefaultTableModel(colunasTabela, 0); 

		        if (rs != null) {
		            while (rs.next()) {

		                modeloTabela.addRow(new Object[] { 
		                    rs.getInt("Id"), 
		                    rs.getString("Descricao"), 
		                    rs.getDouble("Preco")
		                });
		            }

		            tableProduto.setModel(modeloTabela); 
		        }
			 
			 return rs; 
		}
	 
}

