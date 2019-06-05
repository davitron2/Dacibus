/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.scene.chart.PieChart;

/**
 *
 * @author Cesar
 */
public class Cuenta {
    
    int costoTotal;
    int idMesa;
    int idUsuario;
    String fecha;

    
    public Cuenta(){
        
    }
    
    
    
    public Cuenta(int costoTotal, int idMesa, int idUsuario, String fecha) {
        this.costoTotal = costoTotal;
        this.idMesa = idMesa;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
