package modeloDao;
import connect.ConectaBD;
import Obj.Funcionario;
import Obj.Pessoa;

import java.sql.*;
import javax.swing.JOptionPane;
//import java.util.*;

/**
 *
 * @author Marcos
 */
public class DAO_FUNCIONARIO {
    
    private Connection con = null;
    
    public DAO_FUNCIONARIO(){
      con = ConectaBD.getConexaoMySQL();
    }
    
    public void inserePessoa(Pessoa p){
        String sql = "insert into pessoas (nome, idade ,telefone, endereco,sexo)" +
                "values(?,?,?,?,?)";
        
        
        try{
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,p.getNome());
		stmt.setString(2,p.getIdade());
		stmt.setString(3,p.getTelefone());
	        stmt.setString(4,p.getEndereco());
                stmt.setString(5,p.getSexo());
                stmt.execute();
		JOptionPane.showMessageDialog (null, "Cadastrado com sucesso");
                stmt.close();
	}catch(SQLException e){
                        JOptionPane.showMessageDialog (null, "Erro ao cadastrar!");
			throw new RuntimeException(e);
	  } 
    }
    
    public void insereFuncionario(Funcionario f){
        String sql = "insert into funcionarios (cargo,cpf)" +
                "values(?,?)";
        
        
        try{
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,f.getCargo());
                stmt.setString(2,f.getCPF());
                stmt.execute();
                stmt.close();
	}catch(SQLException e){
                        JOptionPane.showMessageDialog (null, "Erro ao cadastrar!");
			throw new RuntimeException(e);
	  } 
    }
    
    
    /*
    public void apaga(String n){
		
		String sql = "delete from pessoas " +
			"where id_pessoa=?";
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,n);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
    */
    public Funcionario buscaFuncionarios(String n){

		//Pessoa p = new Pessoa();
		//Pessoa p = new Pessoa();
		Funcionario f = new Funcionario(); 
                
                
               
		try{
			String sql = "select * from funcionarios where cpf = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
                        
			stmt.setString(1,n);
			
			ResultSet rs = stmt.executeQuery();
                        
                       
			
			
			while(rs.next()){
                            
				
			if(rs.getString("cpf").contains(n)){
				       
                    f.setCPF(rs.getString("cpf"));
		    f.setCargo(rs.getString("cargo"));
		    
				}
			}
			
			rs.close();
			stmt.close();
			return f;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
    
    public Pessoa buscaPessoa(String n){

		
		Pessoa p = new Pessoa();
		 
                
                
               
		try{
			String sql = "select * from pessoas where nome = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
                        
			stmt.setString(1,n);
			
			ResultSet rs = stmt.executeQuery();
                        
                       
			
			
			while(rs.next()){
                            
				
			if(rs.getString("nome").contains(n)){
				       
                        p.setNome(rs.getString("nome"));
		        p.setEndereco(rs.getString("endereco"));
			p.setIdade(rs.getString("idade"));
                        p.setTelefone(rs.getString("telefone"));
                        p.setSexo(rs.getString("sexo"));
		    
				}
			}
			
			rs.close();
			stmt.close();
			return p;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
    
    

public void apagaPessoa(String n){
		
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

public void apagaFuncionario(String n){
		
		String sql = "delete from funcionarios " +
			"where cpf=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,n);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

public void alteraPessoa(Pessoa p){
                
		String sql = "update pessoas set " +
			"nome=?, idade=?, telefone=? , endereco=?, sexo=? " +
			"where nome=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,p.getNome());
                        stmt.setString(2,p.getIdade());
                        stmt.setString(3,p.getTelefone());
                        stmt.setString(4,p.getEndereco());
                        stmt.setString(5,p.getSexo());
                        stmt.setString(6,p.getNome());
			
			stmt.execute();
                        JOptionPane.showMessageDialog (null, "Alterado com sucesso");
			stmt.close();
		} catch (SQLException e) {
                    JOptionPane.showMessageDialog (null, "Erro ao alterar");
			throw new RuntimeException(e);
		} 
	}

public void alteraFuncionario(Funcionario f){

		String sql = "update funcionarios set " +
			"cpf=?, cargo=? " +
			"where cpf=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,f.getCPF());
                        stmt.setString(2,f.getCargo());
                        stmt.setString(3,f.getCPF());
                        
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
  
    

