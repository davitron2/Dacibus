/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author HP
 */
public class Reserva {
    private int IdReserva;
    private String Fecha;
    private String Cliente;
    private int IdMesa;

    public int getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(int IdReserva) {
        this.IdReserva = IdReserva;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public int getIdMesa() {
        return IdMesa;
    }

    public void setIdMesa(int IdMesa) {
        this.IdMesa = IdMesa;
    }
}
