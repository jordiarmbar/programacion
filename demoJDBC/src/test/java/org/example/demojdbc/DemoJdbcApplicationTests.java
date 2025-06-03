package org.example.demojdbc;

import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DemoJdbcApplicationTests {

    @Autowired
    ProductoRepository repo;

    @BeforeEach
    void setUp() {
        repo.borrarTodos();
        repo.insertar(new Producto(null, "Salami", 13000.0, 1));
        repo.insertar(new Producto(null, "Patatas Bravas", 7.0, 190));
    }

    @Test
    void buscarTodos() {
        List<Producto> productos = repo.buscarTodos();
        assertEquals(2, productos.size(), "Debería haber 2 productos después de setUp()");
    }

    @Test
    void buscar() {
        Producto p = repo.buscarUno("Salami");
        assertNotNull(p, "El producto 'Salami' debería existir");
        assertEquals("Salami", p.getNombre());
    }

    @Test
    void insertar() {
        int countBefore = repo.buscarTodos().size();
        repo.insertar(new Producto(null, "Nuevo Producto", 10.0, 50));
        assertEquals(countBefore + 1, repo.buscarTodos().size());
    }

    @Test
    void borrar() {
        Producto salami = repo.buscarUno("Salami");
        assertNotNull(salami, "El producto 'Salami' debería existir");
        repo.borrar(salami);
        assertNull(repo.buscarUno("Salami"), "El producto 'Salami' debería haberse borrado");
    }
}