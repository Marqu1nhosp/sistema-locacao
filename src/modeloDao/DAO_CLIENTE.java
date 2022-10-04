package modeloDao;
import connect.ConectaBD;
import Obj.Cliente;
import Obj.Pessoa;

import java.sql.*;
import javax.swing.JOptionPane;
//import java.util.*;

/**
 *
 * @author Marcos
 */
public class DAO_CLIENTE {
    
    private Connection con = null;
    
    public DAO_CLIENTE(){
       con = ConectaBD.getConexaoMySQL();
    }
    
    public void inserePessoa(Cliente c){
        String sql = "insert into pessoas (nome, idade ,telefone, endereco,sexo,cpf)" +
                "values(?,?,?,?,?,?)";
        
        
        try{
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,c.getNome());
		stmt.setString(2,c.getIdade());
		stmt.setString(3,c.getTelefone());
	        stmt.setString(4,c.getEndereco());
                stmt.setString(5,c.getSexo());
                stmt.setString(6,c.getCPF());
                stmt.execute();
		JOptionPane.showMessageDialog (null, "Cadastrado com sucesso");
                stmt.close();
	}catch(SQLException e){
                        JOptionPane.showMessageDialog (null, "Erro ao cadastrar!");
			throw new RuntimeException(e);
	  } 
    }
    
    
    public Cliente busca(String n){

		
		Cliente c = new Cliente(); 
                
                
               
		try{
			String sql = "select * from pessoas where cpf = ?"; 
			PreparedStatement stmt = con.prepareStatement(sql);
                        
			stmt.setString(1,n);
			
			ResultSet rs = stmt.executeQuery();
                        
                       
			
			
			while(rs.next()){
                            
				
				if(rs.getString("cpf").contains(n)){
				       
                                        c.setNome(rs.getString("nome"));
					c.setEndereco(rs.getString("endereco"));
					c.setIdade(rs.getString("idade"));
                                       c.setCPF(rs.getString("cpf"));
                                       c.setTelefone(rs.getString("telefone"));
                                       c.setSexo(rs.getString("sexo"));
				}
			}
			
			rs.close();
			stmt.close();
			return c;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

public void apaga(String n){
		
		String sql = "delete from pessoas " +
			"where nome=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,n);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
public void altera(Cliente c){

		String sql = "update pessoas set " +
			"nome=?, idade=?, telefone=? , endereco=?, sexo=?, cpf=?" +
			"where nome=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,c.getNome());
                        stmt.setString(2,c.getIdade());
                        stmt.setString(3,c.getTelefone());
                        stmt.setString(4,c.getEndereco());
                        stmt.setString(5,c.getSexo());
                        stmt.setString(6,c.getCPF());
                        stmt.setString(7,c.getNome());
			
			stmt.execute();
                        JOptionPane.showMessageDialog (null, "Alterado com sucesso");
			stmt.close();
		} catch (SQLException e) {
                    JOptionPane.showMessageDialog (null, "Erro ao alterar");
			throw new RuntimeException(e);
		}
	}

}
    

