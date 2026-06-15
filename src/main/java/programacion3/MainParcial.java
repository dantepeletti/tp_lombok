package programacion3;

import programacion3.entities.Categoria;
import programacion3.repository.CategoriaRepository;
import programacion3.repository.ProductoRepository;

import java.time.LocalDateTime;
import java.util.Scanner;

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