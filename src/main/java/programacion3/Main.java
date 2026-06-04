package programacion3;

import programacion3.entities.Categoria;
import programacion3.entities.DetallePedido;
import programacion3.entities.Pedido;
import programacion3.entities.Producto;
import programacion3.entities.Usuario;

import programacion3.enums.Estado;
import programacion3.enums.FormaPago;
import programacion3.enums.Rol;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // SETS DE PRODUCTOS
        Set<Producto> productosElectronica = new HashSet<>();
        Set<Producto> productosHogar = new HashSet<>();
        Set<Producto> productosDeporte = new HashSet<>();


        // CATEGORIAS
        Categoria categoria1 = new Categoria(
                1L,
                false,
                LocalDateTime.now(),
                "Electronica",
                "Productos tecnologicos",
                productosElectronica
        );

        Categoria categoria2 = new Categoria(
                2L,
                false,
                LocalDateTime.now(),
                "Hogar",
                "Productos para el hogar",
                productosHogar
        );

        Categoria categoria3 = new Categoria(
                3L,
                false,
                LocalDateTime.now(),
                "Deporte",
                "Productos deportivos",
                productosDeporte
        );


        // PRODUCTOS
        Producto producto1 = new Producto(
                1L,
                false,
                LocalDateTime.now(),
                "Notebook Lenovo",
                850000.0,
                "Notebook gamer",
                10,
                "lenovo.jpg",
                true,
                categoria1
        );

        Producto producto2 = new Producto(
                2L,
                false,
                LocalDateTime.now(),
                "Mouse Logitech",
                25000.0,
                "Mouse inalambrico",
                30,
                "mouse.jpg",
                true,
                categoria1
        );

        Producto producto3 = new Producto(
                3L,
                false,
                LocalDateTime.now(),
                "Heladera Samsung",
                600000.0,
                "Heladera no frost",
                5,
                "heladera.jpg",
                true,
                categoria2
        );

        Producto producto4 = new Producto(
                4L,
                false,
                LocalDateTime.now(),
                "Silla Gamer",
                50000.0,
                "Silla ergonomica",
                15,
                "silla.jpg",
                true,
                categoria2
        );

        Producto producto5 = new Producto(
                5L,
                false,
                LocalDateTime.now(),
                "Pelota Futbol",
                20000.0,
                "Pelota profesional",
                20,
                "pelota.jpg",
                true,
                categoria3
        );

        Producto producto6 = new Producto(
                6L,
                false,
                LocalDateTime.now(),
                "Teclado Mecanico",
                45000.0,
                "Teclado RGB",
                25,
                "teclado.jpg",
                true,
                categoria1
        );

        Producto producto7 = new Producto(
                7L,
                false,
                LocalDateTime.now(),
                "Monitor Samsung 24",
                180000.0,
                "Monitor Full HD",
                12,
                "monitor.jpg",
                true,
                categoria1
        );

        Producto producto8 = new Producto(
                8L,
                false,
                LocalDateTime.now(),
                "Microondas",
                120000.0,
                "Microondas 20 litros",
                8,
                "microondas.jpg",
                true,
                categoria2
        );

        Producto producto9 = new Producto(
                9L,
                false,
                LocalDateTime.now(),
                "Licuadora",
                35000.0,
                "Licuadora 1.5 litros",
                18,
                "licuadora.jpg",
                true,
                categoria2
        );

        Producto producto10 = new Producto(
                10L,
                false,
                LocalDateTime.now(),
                "Mancuernas 10kg",
                40000.0,
                "Par de mancuernas",
                10,
                "mancuernas.jpg",
                true,
                categoria3
        );


        // ADD A LOS SETS
        productosElectronica.add(producto1);
        productosElectronica.add(producto2);

        productosHogar.add(producto3);
        productosHogar.add(producto4);

        productosDeporte.add(producto5);

        productosElectronica.add(producto6);
        productosElectronica.add(producto7);

        productosHogar.add(producto8);
        productosHogar.add(producto9);

        productosDeporte.add(producto10);


        // PRINTS PRODUCTOS
        System.out.println("/// PRODUCTO ///");
        System.out.println(producto1);

        System.out.println();

        System.out.println("/// PRODUCTOS ELECTRONICA ///");
        System.out.println(productosElectronica);

        System.out.println();

        System.out.println("/// PRODUCTOS HOGAR ///");
        System.out.println(productosHogar);

        System.out.println();

        System.out.println("/// PRODUCTOS DEPORTE ///");
        System.out.println(productosDeporte);


        // DETALLES DE PEDIDO
        DetallePedido detalle1 = new DetallePedido(
                2,
                producto1.getPrecio() * 2,
                producto1
        );

        DetallePedido detalle2 = new DetallePedido(
                1,
                producto2.getPrecio(),
                producto2
        );

        DetallePedido detalle3 = new DetallePedido(
                1,
                producto3.getPrecio(),
                producto3
        );


        // PEDIDO 1
        Pedido pedido1 = new Pedido();

        pedido1.setId(1L);
        pedido1.setFecha(LocalDate.now());
        pedido1.setEstado(Estado.PENDIENTE);
        pedido1.setFormaPago(FormaPago.TARJETA);

        pedido1.addDetallePedido(detalle1);
        pedido1.addDetallePedido(detalle2);


        // PEDIDO 2
        Pedido pedido2 = new Pedido();

        pedido2.setId(2L);
        pedido2.setFecha(LocalDate.now());
        pedido2.setEstado(Estado.CONFIRMADO);
        pedido2.setFormaPago(FormaPago.EFECTIVO);

        pedido2.addDetallePedido(detalle3);


        // PEDIDO 3
        Pedido pedido3 = new Pedido();

        pedido3.setId(3L);
        pedido3.setFecha(LocalDate.now());
        pedido3.setEstado(Estado.TERMINADO);
        pedido3.setFormaPago(FormaPago.TRANSFERENCIA);

        pedido3.addDetallePedido(detalle1);
        pedido3.addDetallePedido(detalle3);


        // SETS DE PEDIDOS
        Set<Pedido> pedidosUsuario1 = new HashSet<>();
        Set<Pedido> pedidosUsuario2 = new HashSet<>();

        pedidosUsuario1.add(pedido1);
        pedidosUsuario1.add(pedido2);

        pedidosUsuario2.add(pedido3);


        // USUARIOS
        Usuario usuario1 = new Usuario(
                1L,
                false,
                LocalDateTime.now(),
                "Juan",
                "Perez",
                "juan@gmail.com",
                "34561234",
                "1234",
                Rol.ADMIN,
                pedidosUsuario1
        );

        Usuario usuario2 = new Usuario(
                2L,
                false,
                LocalDateTime.now(),
                "Maria",
                "Lopez",
                "maria@gmail.com",
                "34567890",
                "5678",
                Rol.USUARIO,
                pedidosUsuario2
        );


        // PRINTS PEDIDOS
        System.out.println();

        System.out.println("/// PEDIDOS USUARIO 1 ///");
        System.out.println(usuario1.getPedidos());

        System.out.println();

        System.out.println("/// PEDIDOS USUARIO 2 ///");
        System.out.println(usuario2.getPedidos());


        // USUARIO CON MAS PEDIDOS
        Usuario usuarioConMasPedidos;

        if (usuario1.getPedidos().size() > usuario2.getPedidos().size()) {
            usuarioConMasPedidos = usuario1;
        } else {
            usuarioConMasPedidos = usuario2;
        }

        System.out.println();

        System.out.println("/// USUARIO CON MAS PEDIDOS ///");
        System.out.println(usuarioConMasPedidos.getNombre());
        System.out.println(usuarioConMasPedidos.getPedidos());


        // PRUEBA EQUALS
        Producto productoNuevo = new Producto(
                10L,
                false,
                LocalDateTime.now(),
                "Notebook Lenovo",
                999999.0,
                "Otro producto",
                5,
                "otra.jpg",
                true,
                categoria1
        );

        System.out.println();

        System.out.println("/// COMPARACION EQUALS ///");

        for (Producto producto : productosElectronica) {

            if (producto.equals(productoNuevo)) {
                System.out.println("Producto repetido encontrado:");
                System.out.println(producto);
            } else {
                System.out.println("No coincide con: " + producto.getNombre());
            }
        }

    }
}