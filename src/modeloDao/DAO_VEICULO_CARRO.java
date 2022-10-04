package modeloDao;
import connect.ConectaBD;
import Obj.Carro;
import Obj.Veiculo;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class DAO_VEICULO_CARRO {
       
       private Connection con = null;
    
        public DAO_VEICULO_CARRO(){
           con = ConectaBD.getConexaoMySQL();
    }
        
            public void insereCarro(Carro c){
                String sql = "insert into veiculos (tipo, placa , chassi, marca, modelo, estado, ano, cor, "+
                                          "combustivel, valor_diaria, quantPortas, tracao, cambio, tetoSolar)" +
                                          "values('Carro', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        
        try{
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,c.getPlaca());
		stmt.setString(2,c.getChassi());
		stmt.setString(3,c.getMarca());
	        stmt.setString(4,c.getModelo());
                stmt.setString(5,c.getEstado());
                stmt.setString(6,c.getAno());
                stmt.setString(7,c.getCor());
                stmt.setString(8,c.getCombustivel());
                stmt.setString(9,c.getValor_diaria());
                stmt.setString(10,c.getQuantPortas());
                stmt.setString(11,c.getTracao());
                stmt.setString(12,c.getCambio());
                stmt.setString(13,c.getTetoSolar());
                stmt.execute();
		JOptionPane.showMessageDialog (null, "Cadastrado com sucesso");
                stmt.close();
	}catch(SQLException e){
                        JOptionPane.showMessageDialog (null, "Erro ao cadastrar!");
			throw new RuntimeException(e);
	  }
        
       } 
       public Carro busca(String p){

		//Pessoa p = new Pessoa();
		Carro c = new Carro(); 
                
                
               
		try{
			String sql = "select * from veiculos where placa = ?"; 
			PreparedStatement stmt = con.prepareStatement(sql);
                        
			stmt.setString(1,p);
			
			ResultSet rs = stmt.executeQuery();
                        
                       
			//c.setNome("nao encontrado");
			
			while(rs.next()){
                            
				//if(rs.getString("cpf").equals(n)){
				if(rs.getString("placa").contains(p)){
				       
                                       c.setPlaca(rs.getString("placa"));
				       c.setChassi(rs.getString("chassi"));
				       c.setMarca(rs.getString("marca"));
                                       c.setModelo(rs.getString("modelo"));
                                       c.setEstado(rs.getString("estado"));
                                       c.setAno(rs.getString("ano"));
                                       c.setCor(rs.getString("cor"));
				       c.setCombustivel(rs.getString("combustivel"));
				       c.setValor_diaria(rs.getString("valor_diaria"));
                                       c.setQuantPortas(rs.getString("quantPortas"));
                                       c.setTracao(rs.getString("tracao"));
                                       c.setCambio(rs.getString("cambio"));
                                       c.setTetoSolar(rs.getString("tetoSolar"));
                                       
                                      
				}
			}
			//stmt.execute();
			rs.close();
                        
			stmt.close();
			return c;
			
		} catch (SQLException e) {
                      
			throw new RuntimeException(e);
		}
	}
       
       public void apaga(String n){
		
		String sql = "delete from veiculos " +
			"where placa=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,n);
			
			stmt.execute();
                        JOptionPane.showMessageDialog (null, "Carro excluido com sucesso");
			stmt.close();
		} catch (SQLException e) {
                        JOptionPane.showMessageDialog (null, "Erro ao exluir");
			throw new RuntimeException(e);
		}
	}
       
       
       public void altera(Carro c){

		String sql = "update veiculos set " +
			"placa = ?, chassi=?, marca=?, modelo=?, estado=?, ano=?, cor=?, combustivel=?, valor_diaria=?, quantPortas=?, tracao=?, cambio=?, tetoSolar=?" +
                        " where placa=?";
			
		        

		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
                         stmt.setString(1,c.getPlaca());
		         stmt.setString(2,c.getChassi());
		         stmt.setString(3,c.getMarca());
	                 stmt.setString(4,c.getModelo());
                         stmt.setString(5,c.getEstado());
                         stmt.setString(6,c.getAno());
                         stmt.setString(7,c.getCor());
                         stmt.setString(8,c.getCombustivel());
                         stmt.setString(9,c.getValor_diaria());
                         stmt.setString(10,c.getQuantPortas());
                         stmt.setString(11,c.getTracao());
                         stmt.setString(12,c.getCambio());
                         stmt.setString(13,c.getTetoSolar());
                         stmt.setString(14,c.getPlaca());
			
			stmt.execute();
                        JOptionPane.showMessageDialog (null, "Alterado com sucesso");
			stmt.close();
		} catch (SQLException e) {
                    JOptionPane.showMessageDialog (null, "Erro ao alterar");
			throw new RuntimeException(e);
		}
	}
    }

