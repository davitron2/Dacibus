
package modelo;

public class Utensilios {
    private int IdUtensilios;
    private String Tipo;
    private int CantDispo;
    private int IdProducto;

    public int getIdUtensilios() {
        return IdUtensilios;
    }

    public void setIdUtensilios(int IdUtensilios) {
        this.IdUtensilios = IdUtensilios;
    }

 
    public int getCantDispo() {
        return CantDispo;
    }

    public void setCantDispo(int CantDispo) {
        this.CantDispo = CantDispo;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
