
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macuser
 */
public class ProductoImportado extends Producto {
    
    private Date fechaVencimiento;

    public ProductoImportado(String nombre, double precio, int cantidadEnStock, Date fechaVencimiento) {
        super(nombre, precio, cantidadEnStock);  // Llamada al constructor de la clase Producto
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Vence el: " + fechaVencimiento;
    }
    
}
