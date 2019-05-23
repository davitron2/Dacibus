package modelo;

public class Mesa {

    
    private int NumMe;
    private int Capacidad;
    private String EdoMesa;

    
    
    public Mesa(){
        
    }
    
    
    public Mesa(int NumMe, int Capacidad, String EdoMesa) {
        this.NumMe = NumMe;
        this.Capacidad = Capacidad;
        this.EdoMesa = EdoMesa;
    }

    public int getNumMe() {
        return NumMe;
    }

    public void setNumMe(int NumMe) {
        this.NumMe = NumMe;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public String getEdoMesa() {
        return EdoMesa;
    }

    public void setEdoMesa(String EdoMesa) {
        this.EdoMesa = EdoMesa;
    }
    
    
    
    
    
    

    
    

}
