package com.example.msvcproductos;

import com.example.msvcproductos.entities.Producto;
import com.example.msvcproductos.repositories.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MsvcProductosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcProductosApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(ProductoRepository productoRepository) {
        return args -> {
            // Limpia la tabla para evitar duplicados al reiniciar
            productoRepository.deleteAll();

            Producto p1 = new Producto();
            p1.setNombre("Laptop Gamer");
            p1.setDescripcion("Laptop de 15.6 pulgadas, 16GB RAM, 512GB SSD, ideal para desarrollo y videojuegos.");
            p1.setPrecio(1200.50);

            Producto p2 = new Producto();
            p2.setNombre("Mouse Logitech");
            p2.setDescripcion("Mouse ergonómico inalámbrico con alta precisión y batería de larga duración.");
            p2.setPrecio(45.99);

            Producto p3 = new Producto();
            p3.setNombre("Teclado Mecánico");
            p3.setDescripcion("Teclado mecánico RGB switches red, respuesta ultra rápida para oficina o gaming.");
            p3.setPrecio(85.00);

            Producto p4 = new Producto();
            p4.setNombre("Monitor 27 Pulgadas");
            p4.setDescripcion("Monitor IPS Full HD de 27\", marcos ultradelgados y tecnología de protección visual.");
            p4.setPrecio(250.00);

            productoRepository.saveAll(List.of(p1, p2, p3, p4));
        };
    }
}