package modeloDao;
import connect.ConectaBD;
import Obj.Veiculo;
import Obj.Moto;

import java.sql.*;
import javax.swing.JOptionPane;
//import java.util.*;

/**
 *
 * @author Marcos
 */
public class DAO_MOTO {
    
    private Connection con = null;
    
    public DAO_MOTO(){
        con = ConectaBD.getConexaoMySQL();
    }
    
    public void insereMoto(Moto m){
        String sql = "insert into veiculos (tipo, placa , chassi, marca, modelo, estado, ano, cor, combustivel, valor_diaria,cilindradas , vel_max) " +
                "values('Moto',?,?,?,?,?,?,?,?,?,?,?)";
        
        
        try{
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,m.getPlaca());
		stmt.setString(2,m.getChassi());
	        stmt.setString(3,m.getMarca());
                stmt.setString(4,m.getModelo());
                stmt.setString(5,m.getEstado());
		stmt.setString(6,m.getAno());
		stmt.setString(7,m.getCor());
		stmt.setString(8,m.getCombustivel());
		stmt.setString(9,m.getValor_diaria());
		stmt.setString(10,m.getCilindradas());
		stmt.setString(11,m.getVelMax());

                stmt.execute();
		JOptionPane.showMessageDialog (null, "Cadastrado com sucesso");
                stmt.close();
	}catch(SQLException e){
                        JOptionPane.showMessageDialog (null, "Erro ao cadastrar!");
			throw new RuntimeException(e);
	  } 
    }
    
    
    public Moto busca(String n){

		
		Moto m = new Moto(); 
                
                
               
		try{
			String sql = "select * from veiculos where placa = ?"; 
			PreparedStatement stmt = con.prepareStatement(sql);
                        
			stmt.setString(1,n);
			
			ResultSet rs = stmt.executeQuery();
                        
                       
			
			
			while(rs.next()){
                            
				
				if(rs.getString("placa").contains(n)){
				       
                                        
					m.setPlaca(rs.getString("placa"));
					m.setChassi(rs.getString("chassi"));
                                        m.setMarca(rs.getString("marca"));
                                        m.setModelo(rs.getString("modelo"));
                                        m.setEstado(rs.getString("estado"));
					m.setAno(rs.getString("ano"));
					m.setStatus(rs.getString("status_disponivel"));
					m.setDescricao(rs.getString("descricao"));
					m.setCor(rs.getString("cor"));
					m.setCombustivel(rs.getString("combustivel"));
					m.setValor_diaria(rs.getString("valor_diaria"));
					m.setCilindradas(rs.getString("cilindradas"));
					m.setVelMax(rs.getString("vel_max"));
				}
			}
			
			rs.close();
			stmt.close();
			return m;
			
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
                        JOptionPane.showMessageDialog (null, "Exluido com sucesso");
			stmt.close();
		} catch (SQLException e) {
                    JOptionPane.showMessageDialog (null, "Erro ao exluir");
			throw new RuntimeException(e);
		}
	}
public void altera(Moto m){

	String sql = "update veiculos set " +
	"placa = ?, chassi=?, marca=?, modelo=?, estado=?, ano=?, cor=?, combustivel=?, valor_diaria=?, cilindradas=?, vel_max=?" +
				" where placa=?";
	
		

try{
	PreparedStatement stmt = con.prepareStatement(sql);
	
				 stmt.setString(1,m.getPlaca());
		                 stmt.setString(2,m.getChassi());
		                 stmt.setString(3,m.getMarca());
			         stmt.setString(4,m.getModelo());
				 stmt.setString(5,m.getEstado());
				 stmt.setString(6,m.getAno());
				 stmt.setString(7,m.getCor());
				 stmt.setString(8,m.getCombustivel());
				 stmt.setString(9,m.getValor_diaria());
				 stmt.setString(10,m.getCilindradas());
				 stmt.setString(11,m.getVelMax());
                                 stmt.setString(12,m.getPlaca());
				 
	
	stmt.execute();
			JOptionPane.showMessageDialog (null, "Alterado com sucesso");
	stmt.close();
} catch (SQLException e) {
			JOptionPane.showMessageDialog (null, "Erro ao alterar");
	throw new RuntimeException(e);
}
	}

}
    


