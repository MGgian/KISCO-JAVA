/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author macuser
 */

//import java.util.Scanner;
//        
//public class Main {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        Scanner scanner = new Scanner(System.in);
//        Kiosco kiosco = new Kiosco(); // aca estamos creando una instancia del kiosco
//        
//         // Productos iniciales
//        kiosco.agregarProducto(new Producto("Gaseosa", 150.0, 20));
//        kiosco.agregarProducto(new Producto("Chocolate", 200.0, 15));
//        kiosco.agregarProducto(new Producto("Papas fritas", 100.0, 30));
//
//        boolean continuar = true;
//        
//        // Menú principal
//        while (continuar) {
//            System.out.println("\n*** Bienvenido al sistema de Kiosco ***");
//            System.out.println("1. Mostrar productos");
//            System.out.println("2. Realizar venta");
//            System.out.println("3. Ver historial de ventas");
//            System.out.println("4. Agregar nuevo producto");
//            System.out.println("5. Salir");
//            System.out.print("Elige una opción: ");
//            int opcion = scanner.nextInt();
//            scanner.nextLine();  // Limpiar el buffer
//
//            switch (opcion) {
//                case 1 -> {
//                    // Mostrar productos disponibles
//                    System.out.println("\nProductos en el inventario:");
//                    kiosco.mostrarProductos();
//                }
//
//                case 2 -> {
//                    // Realizar venta
//                    System.out.print("\nIngrese el nombre del producto: ");
//                    String nombreProducto = scanner.nextLine();
//                    System.out.print("Ingrese la cantidad que desea comprar: ");
//                    int cantidad = scanner.nextInt();
//                    kiosco.realizarVenta(nombreProducto, cantidad);
//                }
//
//                case 3 -> {
//                    // Ver historial de ventas
//                    System.out.println("\nHistorial de ventas:");
//                    kiosco.imprimirHistorialVentas();
//                }
//
//                case 4 -> {
//                    // Agregar nuevo producto
//                    System.out.print("\nIngrese el nombre del nuevo producto: ");
//                    String nuevoNombre = scanner.nextLine();
//                    System.out.print("Ingrese el precio del producto: ");
//                    double nuevoPrecio = scanner.nextDouble();
//                    System.out.print("Ingrese la cantidad en stock: ");
//                    int nuevoStock = scanner.nextInt();
//                    kiosco.agregarProducto(new Producto(nuevoNombre, nuevoPrecio, nuevoStock));
//                    System.out.println("Producto agregado exitosamente.");
//                }
//
//                case 5 -> {
//                    // Salir del programa
//                    continuar = false;
//                    System.out.println("Saliendo del sistema...");
//                }
//
//                default -> System.out.println("Opción no válida, intente nuevamente.");
//            }
//        }
//
//        scanner.close();
//    }
//}

//------------------------------------------
//------------------------------------------
//------------------------------------------

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kiosco kiosco = new Kiosco(); // Creamos una instancia del kiosco
        
        // Productos iniciales
        kiosco.agregarProducto(new Producto("Gaseosa", 150.0, 20));
        kiosco.agregarProducto(new Producto("Chocolate", 200.0, 15));
        kiosco.agregarProducto(new Producto("Papas fritas", 100.0, 30));

        boolean continuar = true;

        // Menú principal
        while (continuar) {
            System.out.println("\n*** Bienvenido al sistema de Kiosco ***");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Realizar venta");
            System.out.println("3. Ver historial de ventas");
            System.out.println("4. Agregar nuevo producto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = 0;
            // Capturamos excepciones de entrada inválida en el menú
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();  // Limpiar el buffer para evitar un ciclo infinito
                continue; // Reiniciar el ciclo si la opción no es válida
            }

            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1 -> {
                    // Mostrar productos disponibles
                    System.out.println("\nProductos en el inventario:");
                    kiosco.mostrarProductos();
                }

                case 2 -> {
                    // Realizar venta
                    System.out.print("\nIngrese el nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese la cantidad que desea comprar: ");
                    int cantidad = 0;

                    // Capturamos excepciones de entrada inválida en la cantidad
                    try {
                        cantidad = scanner.nextInt();
                        if (cantidad <= 0) {
                            System.out.println("La cantidad debe ser mayor que cero.");
                            continue;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingrese un número entero válido.");
                        scanner.nextLine(); // Limpiar el buffer
                        continue;
                    }

                    // Realizar la venta si los datos son válidos
                    kiosco.realizarVenta(nombreProducto, cantidad);
                }

                case 3 -> {
                    // Ver historial de ventas
                    System.out.println("\nHistorial de ventas:");
                    kiosco.imprimirHistorialVentas();
                }

                case 4 -> {
                    // Agregar nuevo producto
                    System.out.print("\nIngrese el nombre del nuevo producto: ");
                    String nuevoNombre = scanner.nextLine();

                    // Validación de precio del producto
                    double nuevoPrecio = 0;
                    System.out.print("Ingrese el precio del producto: ");
                    try {
                        nuevoPrecio = scanner.nextDouble();
                        if (nuevoPrecio <= 0) {
                            System.out.println("El precio debe ser mayor que cero.");
                            continue;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingrese un precio válido.");
                        scanner.nextLine(); // Limpiar el buffer
                        continue;
                    }

                    // Validación de stock
                    int nuevoStock = 0;
                    System.out.print("Ingrese la cantidad en stock: ");
                    try {
                        nuevoStock = scanner.nextInt();
                        if (nuevoStock < 0) {
                            System.out.println("El stock no puede ser negativo.");
                            continue;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingrese un número entero válido.");
                        scanner.nextLine(); // Limpiar el buffer
                        continue;
                    }

                    // Agregar el nuevo producto si los datos son válidos
                    kiosco.agregarProducto(new Producto(nuevoNombre, nuevoPrecio, nuevoStock));
                    System.out.println("Producto agregado exitosamente.");
                }

                case 5 -> {
                    // Salir del programa
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                }

                default -> System.out.println("Opción no válida, intente nuevamente.");
            }
        }

        scanner.close();
    }
}

    
    

