
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macuser
 */
public class Kiosco {
    private ArrayList<Producto> inventario;
    private ArrayList<Venta> historialVentas;
    
    
    //recordar que si no imnportamos java.util.ArrayList no nos van a funcionar los Arrays
    public Kiosco(){
        inventario = new ArrayList<>();
        historialVentas = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto){
        inventario.add(producto);
    }
    
    public void mostrarProductos(){
        for (Producto producto : inventario) {
            System.out.println(producto);
        }
    }
    
    public void realizarVenta(String nombreProducto, int cantidad) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equals(nombreProducto)) {
                if (producto.getCantidadEnStock() >= cantidad) {
                    producto.setCantidadEnStock(producto.getCantidadEnStock() - cantidad);
                    historialVentas.add(new Venta(producto, cantidad));
                    System.out.println("Venta realizada.");
                } else {
                    System.out.println("Stock insuficiente.");
                }
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void imprimirHistorialVentas() {
        imprimirVentasRecursivamente(0);
    }

    private void imprimirVentasRecursivamente(int index) {
        if (index < historialVentas.size()) {
            System.out.println(historialVentas.get(index));
            imprimirVentasRecursivamente(index + 1);
        }
    }
    

}
