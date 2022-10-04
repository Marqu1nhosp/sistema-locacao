package Obj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lucas
 */
public class Cliente extends Pessoa {
private String cnpj;
private String cpf;

public void setCPF(String cpf){
    this.cpf = cpf;
}
    
public String getCPF(){
    return cpf;
}

    
    
public void setCnpj(String cnpj){
    this.cnpj = cnpj;
}
    
public String getCnpj(){
    return cnpj;
}
}
