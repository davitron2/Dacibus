package modelo;

public class Mesa {

    private int IdMesa;
    private String EdoMesa;

    public Mesa(){
        
    }
    
    public Mesa(int IdMesa, String EdoMesa) {
        this.IdMesa = IdMesa;
        this.EdoMesa = EdoMesa;
    }

    public int getIdMesa() {
        return IdMesa;
    }

    public void setIdMesa(int IdMesa) {
        this.IdMesa = IdMesa;
    }

    public String getEdoMesa() {
        return EdoMesa;
    }

    public void setEdoMesa(String EdoMesa) {
        this.EdoMesa = EdoMesa;
    }

    

}
