/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Cesar
 */
public class Producto {
    
    String nombreProducto;
    String categoriaProducto;
    double precio;
    
    public Producto(){
        
    }
    
    public Producto(String nombreProducto, String categoriaProducto, double precio) {
        this.nombreProducto = nombreProducto;
        this.categoriaProducto = categoriaProducto;
        this.precio = precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    

}
