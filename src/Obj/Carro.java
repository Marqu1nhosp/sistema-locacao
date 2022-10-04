/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obj;

public class Carro extends Veiculo{
    private String quantPortas;
    private String tracao, cambio;
    private String tetoSolar;
    
    public void setQuantPortas(String quantPortas){
        this.quantPortas = quantPortas;
    }
    
    public String getQuantPortas(){
        return quantPortas;
    }
    
    public void setTracao(String tracao){
        this.tracao = tracao;
    }
    
    public String getTracao(){
        return tracao;
    }
    
    public void setCambio(String cambio){
        this.cambio = cambio;
    }
    
    public String getCambio(){
        return cambio;
    }
    
    public void setTetoSolar(String tetoSolar){
        this.tetoSolar = tetoSolar;
    }
    
    public String getTetoSolar(){
        return tetoSolar;
    }
    
}
