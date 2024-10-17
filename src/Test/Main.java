/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package Test;
import Modelo.*;
import java.util.List;

/**
 *
 * @author Agustín
 */

public class Main {

    public static void main(String[] args) {
        Taller taller = new Taller("Taller Central");
        
        System.out.println("1 - Creacion de vehiculos y validacion de datos");
        System.out.println("1-1");
        
        try {
            VehiculoCompacto vehiculo1 = new VehiculoCompacto("ABC123", "Toyota Corolla", 2000.0, 2024);
            System.out.println("Error: Se esperaba una excepcion por longitud incorrecta del codigo.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Excepcion capturada correctamente: " + e.getMessage());
        }
        
        System.out.println("1-2");
        
        try {
            VehiculoCompacto vehiculo2 = new VehiculoCompacto("XYZ5678", "Honda Civic", 2200.0, 2023);
            System.out.println("Vehiculo compacto creado exitosamente:");
            System.out.println(vehiculo2);
        } 
        catch (Exception e) {
            System.out.println("Error al crear vehiculo compacto: " + e.getMessage());
        }
        
        System.out.println("1-3");
        
        try {
            VehiculoSUV vehiculo3 = new VehiculoSUV("QRS7890", "Chevrolet Tahoe", 4000.0, false);
            System.out.println("VehiculoSUV creado exitosamente:");
            System.out.println(vehiculo3);
        } 
        catch (Exception e) {
            System.out.println("Error al crear VehiculoSUV: " + e.getMessage());
        }
        
        System.out.println("\n2 - Calculo de costo de reparacion");
        
        System.out.println("2-1");
        
        try {
            taller.agregarVehiculo(new VehiculoCompacto("XYZ5678", "Honda Civic", 2200.0, 2023));
            taller.iniciarReparacion("XYZ5678", "Cambio de aceite");
            double costo = taller.calcularCostoReparacion("XYZ5678", 5);
            System.out.println("Costo de reparacion para Honda Civic (5 horas): " + costo);
        } 
        catch (Exception e) {
            System.out.println("Error en Test 2-1: " + e.getMessage());
        }
        
        System.out.println("2-2");
        
        try {
            taller.agregarVehiculo(new VehiculoSUV("QRS7890", "Chevrolet Tahoe", 4000.0, false));
            taller.iniciarReparacion("QRS7890", "Reparacion de frenos");
            double costo = taller.calcularCostoReparacion("QRS7890", 3);
            System.out.println("Costo de reparacion para Chevrolet Tahoe (3 horas): " + costo);
        } 
        catch (Exception e) {
            System.out.println("Error en Test 2-2: " + e.getMessage());
        }
        
        System.out.println("\n3 - Gestion de vehiculos en el taller");
        
        System.out.println("3-1");
        
        try {
            VehiculoCompacto vehiculo4 = new VehiculoCompacto("LMN1111", "Volkswagen Polo", 1800.0, 2024);
            VehiculoSUV vehiculo5 = new VehiculoSUV("OPQ2222", "Toyota RAV4", 3000.0, true);
            taller.agregarVehiculo(vehiculo4);
            taller.agregarVehiculo(vehiculo5);
            System.out.println("Vehiculos agregados correctamente al inventario del taller.");
            System.out.println("Inventario actual:");
            System.out.println(taller);
        } 
        catch (Exception e) {
            System.out.println("Error en Test 3-1: " + e.getMessage());
        }
        
        System.out.println("3-2");
        
        try {
            VehiculoSUV vehiculoDuplicado = new VehiculoSUV("LMN1111", "Ford Explorer", 3500.0, true);
            taller.agregarVehiculo(vehiculoDuplicado);
            System.out.println("Error: Se esperaba una excepcion por codigo duplicado.");
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Excepcion capturada correctamente: " + e.getMessage());
        }
        
        System.out.println("\n4 - Consulta de vehiculos disponibles en el taller");
        
        try {
            taller.iniciarReparacion("LMN1111", "Cambio de neumaticos");
        } 
        catch (Exception e) {
            System.out.println("Error al iniciar reparacion para LMN1111: " + e.getMessage());
        }
        
        System.out.println("4-1");
        
        try {
            List<Vehiculo> disponibles = taller.traerVehiculosDisponibles();
            System.out.println("Vehiculos disponibles:");
            
            for (Vehiculo v : disponibles) {
                System.out.println(v);
            }

            List<Vehiculo> enReparacion = taller.traerVehiculos(EstadoVehiculo.EN_REPARACION);
            System.out.println("\nVehiculos en reparacion:");
            
            for (Vehiculo v : enReparacion) {
                System.out.println(v);
            }
        } 
        catch (Exception e) {
            System.out.println("Error en Test 4-1: " + e.getMessage());
        }
    }
}