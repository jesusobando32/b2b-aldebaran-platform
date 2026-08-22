package com.example.ApiRestSB;

import com.example.ApiRestSB.modelos.Orden;
import com.example.ApiRestSB.modelos.Perfil;
import com.example.ApiRestSB.modelos.Producto;
import com.example.ApiRestSB.repositorios.OrdenRepository;
import com.example.ApiRestSB.repositorios.PerfilRepository;
import com.example.ApiRestSB.repositorios.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final PerfilRepository perfilRepository;
    private final ProductoRepository productoRepository;
    private final OrdenRepository ordenRepository;

    public DataSeeder(PerfilRepository perfilRepository, ProductoRepository productoRepository, OrdenRepository ordenRepository) {
        this.perfilRepository = perfilRepository;
        this.productoRepository = productoRepository;
        this.ordenRepository = ordenRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Solo inyectar si la base de datos está vacía
        if (perfilRepository.count() == 0) {
            
            // 1. Inyectar Clientes/Perfiles
            Perfil p1 = new Perfil("Carlos", "Gómez", "1990-05-15", "carlos@mail.com", "100", "555-0001", 500.0f, 0, "A1234567890"); // Cliente regular
            Perfil p2 = new Perfil("María", "López", "1985-08-22", "maria@mail.com", "101", "555-0002", 1200.0f, 1, "A1234567890"); // Empleado
            Perfil p3 = new Perfil("Admin", "General", "1980-01-01", "admin@mail.com", "102", "555-0003", 9999.0f, 2, "A1234567890"); // Administrador
            Perfil p4 = new Perfil("Luis", "Pérez", "1992-11-30", "luis@mail.com", "103", "555-0004", 150.0f, 0, "A1234567890");
            Perfil p5 = new Perfil("Ana", "Martínez", "1995-04-10", "ana@mail.com", "104", "555-0005", 300.0f, 0, "A1234567890");
            
            perfilRepository.saveAll(List.of(p1, p2, p3, p4, p5));

            // 2. Inyectar Productos
            Producto prod1 = new Producto("PRD-001", "Harina Pan", "Harina de maíz precocida 1kg", "Disponible", 1.50f);
            Producto prod2 = new Producto("PRD-002", "Arroz Mary", "Arroz blanco tipo I 1kg", "Disponible", 1.20f);
            Producto prod3 = new Producto("PRD-003", "Aceite Mazeite", "Aceite vegetal de maíz 1L", "Disponible", 3.50f);
            Producto prod4 = new Producto("PRD-004", "Pasta Primor", "Pasta larga espagueti 500g", "Disponible", 0.90f);
            Producto prod5 = new Producto("PRD-005", "Azúcar Montalbán", "Azúcar refinada 1kg", "Disponible", 1.10f);
            Producto prod6 = new Producto("PRD-006", "Café Fama de América", "Café molido tostado 500g", "Disponible", 4.00f);
            Producto prod7 = new Producto("PRD-007", "Leche Campestre", "Leche en polvo completa 1kg", "Disponible", 7.50f);
            Producto prod8 = new Producto("PRD-008", "Atún Margarita", "Atún en aceite vegetal 140g", "Agotado", 2.20f);
            Producto prod9 = new Producto("PRD-009", "Mantequilla Mavesa", "Margarina con sal 500g", "Disponible", 2.50f);
            Producto prod10 = new Producto("PRD-010", "Queso Llanero", "Queso blanco duro llanero 1kg", "Disponible", 6.00f);

            productoRepository.saveAll(List.of(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10));

            // 3. Inyectar Órdenes
            String[] productosO1 = {"Harina Pan", "Arroz Mary", "Aceite Mazeite"};
            int[] cantidadesO1 = {4, 2, 1};
            Orden o1 = new Orden(100, productosO1, cantidadesO1, "Pendiente", "2026-08-20", "2026-08-23");

            String[] productosO2 = {"Café Fama de América", "Leche Campestre"};
            int[] cantidadesO2 = {1, 1};
            Orden o2 = new Orden(103, productosO2, cantidadesO2, "Entregado", "2026-08-15", "2026-08-16");

            String[] productosO3 = {"Pasta Primor", "Mantequilla Mavesa", "Queso Llanero"};
            int[] cantidadesO3 = {5, 2, 1};
            Orden o3 = new Orden(104, productosO3, cantidadesO3, "Procesando", "2026-08-21", "2026-08-24");

            String[] productosO4 = {"Azúcar Montalbán"};
            int[] cantidadesO4 = {10};
            Orden o4 = new Orden(100, productosO4, cantidadesO4, "Cancelado", "2026-08-10", "2026-08-12");

            String[] productosO5 = {"Harina Pan", "Atún Margarita"};
            int[] cantidadesO5 = {2, 6};
            Orden o5 = new Orden(104, productosO5, cantidadesO5, "Entregado", "2026-08-18", "2026-08-19");

            ordenRepository.saveAll(List.of(o1, o2, o3, o4, o5));
            
            System.out.println("======================================================");
            System.out.println("✅ DATOS INYECTADOS CORRECTAMENTE (FULL)");
            System.out.println("======================================================");
        }
    }
}
