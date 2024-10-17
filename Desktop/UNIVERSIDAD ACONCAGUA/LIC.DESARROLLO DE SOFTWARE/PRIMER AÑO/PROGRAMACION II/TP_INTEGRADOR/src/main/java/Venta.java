
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macuser
 */
public class Venta {
    
    private Producto producto;
    private int cantidadVendida;
    private Date fecha;

    public Venta(Producto producto, int cantidadVendida) {
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
        this.fecha = new Date();
    }

    @Override
    public String toString() {
        return "Producto: " + producto.getNombre() + ", Cantidad: " + cantidadVendida + ", Fecha: " + fecha;
    }
}

