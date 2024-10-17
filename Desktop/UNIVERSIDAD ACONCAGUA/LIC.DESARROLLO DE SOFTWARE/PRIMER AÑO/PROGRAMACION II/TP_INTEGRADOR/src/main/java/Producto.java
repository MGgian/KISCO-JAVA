/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macuser
 */
public class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;

    public Producto(String nombre, double precio, int cantidadStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }
    
    // Getters y setters
    public String getNombre() { 
        return nombre; 
    }
    
    public double getPrecio() { 
        return precio; 
    }
    
    public int getCantidadEnStock() { 
        return cantidadStock; 
    }
    
    public void setCantidadEnStock(int cantidadEnStock) { 
        this.cantidadStock = cantidadEnStock; 
    }
    
    @Override
    public String toString() {
        return nombre + " - Precio: $" + precio + " - Stock: " + cantidadStock;
    }
}
