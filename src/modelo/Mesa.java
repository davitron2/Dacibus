package modelo;

public class Mesa {

int numeroMesa;
int capacidadMesa;
String estadoMesa;


    public Mesa(){
        
    }

    public Mesa(int numeroMesa, int capacidadMesa, String estadoMesa) {
        this.numeroMesa = numeroMesa;
        this.capacidadMesa = capacidadMesa;
        this.estadoMesa = estadoMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidadMesa() {
        return capacidadMesa;
    }

    public void setCapacidadMesa(int capacidadMesa) {
        this.capacidadMesa = capacidadMesa;
    }

    public String getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(String estadoMesa) {
        this.estadoMesa = estadoMesa;
    }
}
