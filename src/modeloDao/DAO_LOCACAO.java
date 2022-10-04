package modeloDao;
import connect.ConectaBD;
import java.sql.*;
import javax.swing.JOptionPane;
import Obj.Locacoes;
import Obj.Veiculo;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Lucas
 */
public class DAO_LOCACAO {
    
    private Connection con = null;
    
    public DAO_LOCACAO(){
        con = ConectaBD.getConexaoMySQL();
    }
    
    public void Aluga(Locacoes l){
        String sql = "insert into locacoes (cpf, data_inicio, data_fim, placa_veiculo, funcionario, modelo, tipo )" +
                "values(?,?,?,?,?,?,?)";
        
        
        try{
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,l.getCPF());
		stmt.setString(2,l.getData_incio());
		stmt.setString(3,l.getData_fim());
	        stmt.setString(4,l.getPlaca());
                stmt.setString(5,l.getFuncionario());
		stmt.setString(6,l.getModelo());
                stmt.setString(7,l.getTipo());
                stmt.execute();
		JOptionPane.showMessageDialog (null, "Cadastrado com sucesso");
                stmt.close();
	}catch(SQLException e){
                        JOptionPane.showMessageDialog (null, "Erro ao cadastrar!");
			throw new RuntimeException(e);
	  } 
    }
    
    
 public Locacoes busca(String c){

		Locacoes l = new Locacoes(); 
                
                try{
			String sql = "select * from locacoes where cpf = ?"; 
			PreparedStatement stmt = con.prepareStatement(sql);
                        
			stmt.setString(1,c);
			
			ResultSet rs = stmt.executeQuery();
                        
                       while(rs.next()){
                            if(rs.getString("cpf").contains(c)){
				       
                                       l.setCPF(rs.getString("cpf"));
				       l.setData_incio(rs.getString("data_inicio"));
				       l.setData_fim(rs.getString("data_fim"));
                                       l.setPlaca(rs.getString("placa_veiculo"));
                                       l.setFuncionario(rs.getString("funcionario"));
                                       l.setModelo(rs.getString("modelo"));
                                       l.setTipo(rs.getString("tipo"));
				}
			}
			
			rs.close();
			stmt.close();
			return l;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

  
 
public void altera(Locacoes l){

		String sql = "update locacoes set " +
			"cpf=?, data_inicio=?, data_fim=?, placa_veiculo=?, funcionario=?, modelo=?, tipo=?" +
			"where cpf=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,l.getCPF());
                        stmt.setString(2,l.getData_incio());
                        stmt.setString(3,l.getData_fim());
                        stmt.setString(4,l.getPlaca());
                        stmt.setString(5,l.getFuncionario());
                        stmt.setString(6,l.getModelo());
                        stmt.setString(7,l.getTipo());
                        stmt.setString(8,l.getCPF());
			
			stmt.execute();
                        JOptionPane.showMessageDialog (null, "Alterado com sucesso");
			stmt.close();
		} catch (SQLException e) {
                    JOptionPane.showMessageDialog (null, "Erro ao alterar");
			throw new RuntimeException(e);
		}
	}

public List<Veiculo> lista(){
		
		try{
			List<Veiculo> Veiculo = new ArrayList<Veiculo>();
			PreparedStatement stmt = con.prepareStatement("select * from veiculos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Veiculo v = new Veiculo();
				v.setModelo(rs.getString("modelo"));
                                v.setTipo(rs.getString("tipo"));
				v.setMarca(rs.getString("marca"));
                                v.setPlaca(rs.getString("placa"));
				v.setAno(rs.getString("ano"));
				v.setCor(rs.getString("cor"));
				v.setValor_diaria(rs.getString("valor_diaria"));
				v.setStatus(rs.getString("status_disponivel"));
				
				Veiculo.add(v);
			}
			
			rs.close();
			stmt.close();
			return Veiculo;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
 