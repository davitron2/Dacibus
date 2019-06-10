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
     private int IdCuenta;
    private double costoTotal;
    private int idMesa;
    private int IdOrden;
    private int idUsuario;
    private String fecha;
    private String estado;

    public Cuenta(int IdCuenta, double costoTotal, int idMesa, int IdOrden, int idUsuario, String fecha, String estado) {
        this.IdCuenta = IdCuenta;
        this.costoTotal = costoTotal;
        this.idMesa = idMesa;
        this.IdOrden = IdOrden;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    public Cuenta(){
        
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdOrden() {
        return IdOrden;
    }

    public void setIdOrden(int IdOrden) {
        this.IdOrden = IdOrden;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
