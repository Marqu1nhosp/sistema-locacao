package Obj;

public class Funcionario extends Pessoa{
    private String cargo;
    private String cpf;
    
public void setCPF(String cpf){
    this.cpf = cpf;
}
    
public String getCPF(){
    return cpf;
}

    public void setCargo(String cargo){
       this.cargo = cargo;
    }
    
    public String getCargo(){
        return cargo;
    }
}