package Obj;

import java.sql.Date;
import java.time.*;

public class Locacoes extends Veiculo{
    private String data_inicio,data_fim;
    private float valortotal;
    private String funcionario;
    private String cpf;
   
    

    public void setData_incio(String data_inicio){
        this.data_inicio= data_inicio;
    }

    public String getData_incio(){
        return data_inicio;
    }

    public void setData_fim(String data_fim){
        this.data_fim= data_fim;
    }

    public String getData_fim(){
        return data_fim;
    }

    public void setValor_total(float valortotal){
        this.valortotal = valortotal;
    }

    public float getValor_total(){
        return valortotal;
    }
    
    public void setFuncionario(String funcionario){
        this.funcionario= funcionario;
    }

    public String getFuncionario(){
        return funcionario;
    }

    
    
    public void setCPF(String cpf){
        this.cpf= cpf;
    }

    public String getCPF(){
        return cpf;
    }
    

    
}
