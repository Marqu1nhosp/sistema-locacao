package Obj;

import java.sql.Date;

public class Veiculo {
  
    
    private String placa;
    private String chassi;
    private String marca;
    private String modelo;
    private String estado;
    private String ano;
    private String status;
    private String descricao;
    private String cor;
    private String combustivel;
    private String valor_diarial;
    private String tipo;



// Placa do carro        
        public void setPlaca(String placa){
                this.placa = placa;
                }
                
        public String getPlaca(){
                return placa;
        }
//Chassi do carro
        public void setChassi(String chassi){
                this.chassi = chassi;
                }
                
        public String getChassi(){
                return chassi;
                }
//Marca do carro 
        public void setMarca(String marca){
                 this.marca = marca;
                }
                    
        public String getMarca(){
                return marca;
                }
//Modelo do carro
        public void setModelo(String modelo){
                this.modelo = modelo;
                }
                        
            public String getModelo(){
                    return modelo;
                    }
//Estado do carro
            public void setEstado(String estado){
                    this.estado = estado;
                    }
                    
            public String getEstado(){
                    return estado;
                    }
//Ano do carro                         
            public void setAno(String ano){
                     this.ano = ano;
                     }
                                
            public String getAno(){
                    return ano;
                    }
//Status de disponibilidade do carro
            public void setStatus(String status){
                    this.status = status;
                    }
                    
            public String getStatus(){
                    return status;
                    }
//Descricao do carro                  
            public void setDescricao(String descricao){
                    this.descricao = descricao;
                    }
                        
            public String getDescricao(){
                    return descricao;
                    }
//Cor do carro            
            public void setCor(String cor){
                    this.cor = cor;
                    }
                            
            public String getCor(){
                    return cor;
                    }
// Quantidade de combutivel do carro        
            public void setCombustivel(String combustivel){
                    this.combustivel = combustivel;
                    }
                                
            public String getCombustivel(){
                    return combustivel;
                    }
// Valor de uma diaria do carro                                
            public void setValor_diaria(String valor_diarial){
                    this.valor_diarial = valor_diarial;
                    }
                                    
            public String getValor_diaria(){
                    return valor_diarial;
                    }
            public void setTipo(String tipo){
                    this.tipo= tipo;
                }

            public String getTipo(){
                     return tipo;
    }
}
