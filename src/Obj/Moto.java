package Obj;

public class Moto extends Veiculo{
    
    private String cilindradas, vel_max;
    

    public void setCilindradas(String cilindradas){
	  this.cilindradas = cilindradas;
	}

    public String getCilindradas(){
	  return cilindradas;
	}
    
    public void setVelMax(String vel_max){
          this.vel_max = vel_max;
    }
    
    public String getVelMax(){
          return vel_max;
    }
        
}
