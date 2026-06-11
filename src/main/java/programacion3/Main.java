package programacion3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import programacion3.entities.Categoria;
import programacion3.entities.DetallePedido;
import programacion3.entities.Pedido;
import programacion3.entities.Producto;
import programacion3.entities.Usuario;
import programacion3.dtos.UsuarioDTO;

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
        Set<Producto> todosLosProductos = new HashSet<>();

        // CATEGORIAS
        Categoria categoria1 = Categoria.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Electronica")
                .descripcion("Productos tecnologicos")
                .productos(productosElectronica)
                .build();

        Categoria categoria2 = Categoria.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Hogar")
                .descripcion("Productos para el hogar")
                .productos(productosHogar)
                .build();

        Categoria categoria3 = Categoria.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Deporte")
                .descripcion("Productos deportivos")
                .productos(productosDeporte)
                .build();

        // PRODUCTOS
        Producto producto1 = Producto.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Notebook Lenovo")
                .precio(850000.0)
                .descripcion("Notebook gamer")
                .stock(10)
                .imagen("lenovo.jpg")
                .disponible(true)
                .categoria(categoria1)
                .build();

        Producto producto2 = Producto.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Mouse Logitech")
                .precio(25000.0)
                .descripcion("Mouse inalambrico")
                .stock(30)
                .imagen("mouse.jpg")
                .disponible(true)
                .categoria(categoria1)
                .build();

        Producto producto3 = Producto.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Heladera Samsung")
                .precio(600000.0)
                .descripcion("Heladera no frost")
                .stock(5)
                .imagen("heladera.jpg")
                .disponible(true)
                .categoria(categoria2)
                .build();
        Producto producto4 = Producto.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Silla Gamer")
                .precio(50000.0)
                .descripcion("Silla ergonomica")
                .stock(15)
                .imagen("silla.jpg")
                .disponible(true)
                .categoria(categoria2)
                .build();

        Producto producto5 = Producto.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Pelota Futbol")
                .precio(20000.0)
                .descripcion("Pelota profesional")
                .stock(20)
                .imagen("pelota.jpg")
                .disponible(true)
                .categoria(categoria3)
                .build();

        Producto producto6 = Producto.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Teclado Mecanico")
                .precio(45000.0)
                .descripcion("Teclado RGB")
                .stock(2)
                .imagen("teclado.jpg")
                .disponible(true)
                .categoria(categoria1)
                .build();

        Producto producto7 = Producto.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Monitor Samsung 24")
                .precio(180000.0)
                .descripcion("Monitor Full HD")
                .stock(12)
                .imagen("monitor.jpg")
                .disponible(true)
                .categoria(categoria1)
                .build();

        Producto producto8 = Producto.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Microondas")
                .precio(120000.0)
                .descripcion("Microondas 20 litros")
                .stock(8)
                .imagen("microondas.jpg")
                .disponible(true)
                .categoria(categoria2)
                .build();

        Producto producto9 = Producto.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Licuadora")
                .precio(35000.0)
                .descripcion("Licuadora 1.5 litros")
                .stock(18)
                .imagen("licuadora.jpg")
                .disponible(true)
                .categoria(categoria2)
                .build();

        Producto producto10 = Producto.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Mancuernas 10kg")
                .precio(40000.0)
                .descripcion("Par de mancuernas")
                .stock(10)
                .imagen("mancuernas.jpg")
                .disponible(true)
                .categoria(categoria3)
                .build();


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

        todosLosProductos.addAll(productosElectronica);
        todosLosProductos.addAll(productosHogar);
        todosLosProductos.addAll(productosDeporte);

        System.out.println("\n /// PRODUCTOS DISPONIBLES ///");

        productosElectronica.stream()
                .filter(Producto::getDisponible)
                .forEach(System.out::println);

        productosHogar.stream()
                .filter(Producto::getDisponible)
                .forEach(System.out::println);

        productosDeporte.stream()
                .filter(Producto::getDisponible)
                .forEach(System.out::println);

        System.out.println("\n /// PRODUCTOS CON STOCK MENOR A 5 ///");

        todosLosProductos.stream()
                .filter(producto -> producto.getStock() < 5)
                .forEach(System.out::println);


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
        DetallePedido detalle1 = DetallePedido.builder()
                .cantidad(2)
               .subtotal(producto1.getPrecio() * 2)
               .producto(producto1)
                .build();

        DetallePedido detalle2 = DetallePedido.builder()
               .cantidad(1)
               .subtotal(producto2.getPrecio())
                .producto(producto2)
                .build();

        DetallePedido detalle3 = DetallePedido.builder()
                .cantidad(1)
                .subtotal(producto3.getPrecio())
                .producto(producto3)
                .build();

        // PEDIDO 1
        Pedido pedido1 = new Pedido();

        pedido1.setFecha(LocalDate.now());
        pedido1.setEstado(Estado.PENDIENTE);
        pedido1.setFormaPago(FormaPago.TARJETA);

        pedido1.addDetallePedido(detalle1);
        pedido1.addDetallePedido(detalle2);

        int cantidadItems = pedido1.getDetalles()
                .stream()
                .mapToInt(DetallePedido::getCantidad)
                .sum();

        System.out.println("\n /// CANTIDAD DE ITEMS PEDIDOS ///");
        System.out.println(cantidadItems);


        // PEDIDO 2
        Pedido pedido2 = new Pedido();

        pedido2.setFecha(LocalDate.now());
        pedido2.setEstado(Estado.CONFIRMADO);
        pedido2.setFormaPago(FormaPago.EFECTIVO);

        pedido2.addDetallePedido(detalle3);


        // PEDIDO 3
        Pedido pedido3 = new Pedido();

        pedido3.setFecha(LocalDate.now());
        pedido3.setEstado(Estado.TERMINADO);
        pedido3.setFormaPago(FormaPago.TRANSFERENCIA);

        pedido3.addDetallePedido(detalle1);
        pedido3.addDetallePedido(detalle3);


        // SETS DE PEDIDOS
        Set<Pedido> pedidosUsuario1 = new HashSet<>();
        Set<Pedido> pedidosUsuario2 = new HashSet<>();


        // USUARIOS
        Usuario usuario1 = Usuario.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Juan")
                .apellido("Perez")
                .mail("juan@gmail.com")
                .celular("34561234")
                .password("1234")
                .rol(Rol.ADMIN)
                .pedidos(pedidosUsuario1)
                .build();

        Usuario usuario2 = Usuario.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Maria")
                .apellido("Lopez")
                .mail("maria@gmail.com")
                .celular("34567890")
                .password("5678")
                .rol(Rol.USUARIO)
                .pedidos(pedidosUsuario2)
                .build();

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuario1.getId(),
                usuario1.getNombre(),
                usuario1.getApellido(),
                usuario1.getMail(),
                usuario1.getCelular(),
                usuario1.getPedidos()
        );

        System.out.println();
        System.out.println("/// USUARIO DTO ///");
        System.out.println(usuarioDTO);

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
        Producto productoNuevo = Producto.builder()
                .eliminado(false)
                .createdAt(LocalDateTime.now())
                .nombre("Notebook Lenovo")
                .precio(999999.0)
                .descripcion("Otro producto")
                .stock(5)
                .imagen("otra.jpg")
                .disponible(true)
                .categoria(categoria1)
                .build();

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
        usuario1.addPedido(pedido1);
        usuario1.addPedido(pedido2);

        usuario2.addPedido(pedido3);

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("miUnidad");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Persistir categorías
        em.persist(categoria1);
        em.persist(categoria2);
        em.persist(categoria3);

        // Persistir productos
        em.persist(producto1);
        em.persist(producto2);
        em.persist(producto3);
        em.persist(producto4);
        em.persist(producto5);
        em.persist(producto6);
        em.persist(producto7);
        em.persist(producto8);
        em.persist(producto9);
        em.persist(producto10);

        // Persistir usuarios
        em.persist(usuario1);
        em.persist(usuario2);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}