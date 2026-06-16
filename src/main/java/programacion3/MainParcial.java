package programacion3;

import programacion3.entities.Categoria;
import programacion3.entities.Producto;
import programacion3.repository.CategoriaRepository;
import programacion3.repository.ProductoRepository;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.List;

public class MainParcial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CategoriaRepository categoriaRepo = new CategoriaRepository();
        ProductoRepository productoRepo = new ProductoRepository();

        int opcion;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("6 - Alta Categoria");
            System.out.println("7 - Baja Categoria");
            System.out.println("8 - Modificar Categoria");
            System.out.println("9 - Listar Categorias");
            System.out.println("10 - Alta Producto");
            System.out.println("11 - Baja Producto");
            System.out.println("12 - Modificar Producto");
            System.out.println("13 - Listar Productos");
            System.out.println("14 - Productos por Categoria");
            System.out.println("0 - Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 6:

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Descripcion: ");
                    String descripcion = sc.nextLine();

                    Categoria categoria = Categoria.builder()
                            .nombre(nombre)
                            .descripcion(descripcion)
                            .eliminado(false)
                            .createdAt(LocalDateTime.now())
                            .build();

                    categoria = categoriaRepo.guardar(categoria);

                    System.out.println("Categoria guardada correctamente.");
                    System.out.println("ID generado: " + categoria.getId());

                    break;

                case 7:

                    System.out.print("Ingrese ID de la categoria: ");
                    Long idEliminar = sc.nextLong();
                    sc.nextLine();

                    boolean eliminada = categoriaRepo.eliminarLogico(idEliminar);

                    if (eliminada) {
                        System.out.println("Categoria eliminada correctamente.");
                    } else {
                        System.out.println("No existe una categoria con ese ID.");
                    }

                    break;

                case 8:

                    System.out.print("Ingrese ID de la categoria: ");
                    Long idModificar = sc.nextLong();
                    sc.nextLine();

                    var categoriaOpt = categoriaRepo.buscarPorId(idModificar);

                    if (categoriaOpt.isEmpty()) {

                        System.out.println("No existe una categoria con ese ID.");

                    } else {

                        Categoria categoriaModificar = categoriaOpt.get();

                        System.out.println("\nValores actuales:");
                        System.out.println("Nombre: " + categoriaModificar.getNombre());
                        System.out.println("Descripcion: " + categoriaModificar.getDescripcion());

                        System.out.print("Nuevo nombre: ");
                        categoriaModificar.setNombre(sc.nextLine());

                        System.out.print("Nueva descripcion: ");
                        categoriaModificar.setDescripcion(sc.nextLine());

                        categoriaRepo.guardar(categoriaModificar);

                        System.out.println("Categoria modificada correctamente.");
                    }

                    break;

                case 9:

                    System.out.println("\n=== CATEGORIAS ACTIVAS ===");

                    categoriaRepo.listarActivos().forEach(c ->
                            System.out.println(
                                    "ID: " + c.getId()
                                            + " | Nombre: " + c.getNombre()
                                            + " | Descripcion: " + c.getDescripcion()
                            )
                    );

                    break;

                case 10:

                    System.out.println("\n=== CATEGORIAS DISPONIBLES ===");

                    categoriaRepo.listarActivos().forEach(c ->
                            System.out.println(
                                    "ID: " + c.getId()
                                            + " | Nombre: " + c.getNombre()
                            )
                    );

                    System.out.print("Ingrese ID de la categoria: ");
                    Long idCategoria = sc.nextLong();
                    sc.nextLine();

                    var categoriaProductOpt = categoriaRepo.buscarPorId(idCategoria);

                    if (categoriaProductOpt.isEmpty()) {

                        System.out.println("No existe una categoria con ese ID.");

                    } else {

                        Categoria categoriaSeleccionada = categoriaProductOpt.get();

                        System.out.print("Nombre: ");
                        String nombreProducto = sc.nextLine();

                        System.out.print("Precio: ");
                        Double precio = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Descripcion: ");
                        String descripcionProducto = sc.nextLine();

                        System.out.print("Stock: ");
                        int stock = sc.nextInt();
                        sc.nextLine();

                        Producto producto = Producto.builder()
                                .nombre(nombreProducto)
                                .precio(precio)
                                .descripcion(descripcionProducto)
                                .stock(stock)
                                .imagen("")
                                .disponible(true)
                                .categoria(categoriaSeleccionada)
                                .eliminado(false)
                                .createdAt(LocalDateTime.now())
                                .build();

                        producto = productoRepo.guardar(producto);

                        System.out.println("Producto guardado correctamente.");
                        System.out.println("ID generado: " + producto.getId());
                    }

                    break;

                case 11:

                    System.out.print("Ingrese ID del producto a eliminar: ");
                    Long idEliminarProducto = sc.nextLong();
                    sc.nextLine();

                    var productoOpt = productoRepo.buscarPorId(idEliminarProducto);

                    if (productoOpt.isEmpty()) {

                        System.out.println("No existe un producto con ese ID.");

                    } else if (productoOpt.get().isEliminado()) {

                        System.out.println("El producto ya fue dado de baja.");

                    } else {

                        productoRepo.eliminarLogico(idEliminarProducto);

                        System.out.println("Producto eliminado correctamente.");
                    }

                    break;

                case 12:

                    System.out.print("Ingrese ID del producto a modificar: ");
                    Long idModificarProducto = sc.nextLong();
                    sc.nextLine();

                    var productoModificarOpt = productoRepo.buscarPorId(idModificarProducto);

                    if (productoModificarOpt.isEmpty()) {

                        System.out.println("No existe un producto con ese ID.");

                    } else {

                        Producto productoModificar = productoModificarOpt.get();

                        System.out.println("\n=== DATOS ACTUALES ===");
                        System.out.println("Nombre: " + productoModificar.getNombre());
                        System.out.println("Precio: " + productoModificar.getPrecio());
                        System.out.println("Stock: " + productoModificar.getStock());

                        System.out.print("Nuevo nombre: ");
                        productoModificar.setNombre(sc.nextLine());

                        System.out.print("Nuevo precio: ");
                        productoModificar.setPrecio(sc.nextDouble());

                        System.out.print("Nuevo stock: ");
                        productoModificar.setStock(sc.nextInt());
                        sc.nextLine();

                        productoRepo.guardar(productoModificar);

                        System.out.println("Producto modificado correctamente.");
                    }

                    break;

                case 13:

                    System.out.println("\n=== PRODUCTOS ACTIVOS ===");

                    productoRepo.listarActivos().forEach(p ->
                            System.out.println(
                                    "ID: " + p.getId()
                                            + " | Nombre: " + p.getNombre()
                                            + " | Precio: $" + p.getPrecio()
                                            + " | Stock: " + p.getStock()
                                            + " | Categoria: " + p.getCategoria().getNombre()
                            )
                    );

                    break;

                case 14:

                    System.out.println("\n=== CATEGORIAS DISPONIBLES ===");

                    categoriaRepo.listarActivos().forEach(c ->
                            System.out.println(
                                    "ID: " + c.getId()
                                            + " | Nombre: " + c.getNombre()
                            )
                    );

                    System.out.print("Seleccione el ID de la categoria: ");
                    Long idCategoriaReporte = sc.nextLong();
                    sc.nextLine();

                    List<Producto> productosCategoria =
                            productoRepo.buscarPorCategoria(idCategoriaReporte);

                    if (productosCategoria.isEmpty()) {

                        System.out.println(
                                "No hay productos asociados a esa categoria."
                        );

                    } else {

                        System.out.println("\n=== PRODUCTOS ENCONTRADOS ===");

                        productosCategoria.forEach(p ->
                                System.out.println(
                                        "ID: " + p.getId()
                                                + " | Nombre: " + p.getNombre()
                                                + " | Precio: $" + p.getPrecio()
                                                + " | Stock: " + p.getStock()
                                )
                        );
                    }

                    break;

                case 0:

                    System.out.println("Fin del programa");
                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
}