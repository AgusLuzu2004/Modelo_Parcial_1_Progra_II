/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Agustín
 */

// Clase Taller que gestiona los vehículos en un taller mecánico
public class Taller {
    private String nombreTaller; // Nombre del taller
    private List<Vehiculo> inventarioVehiculos; // Inventario de vehículos del taller
    private List<Vehiculo> vehiculosEnReparacion; // Lista de vehículos en reparación

    // Constructor que inicializa los valores del taller
    public Taller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
        this.inventarioVehiculos = new ArrayList<>();
        this.vehiculosEnReparacion = new ArrayList<>();
    }
    
    // Método para agregar un vehículo al taller
    public void agregarVehiculo(Vehiculo vehiculo) {
        Optional<Vehiculo> existe = inventarioVehiculos.stream().filter(v -> v.getCodigoVehiculo().equals(vehiculo.getCodigoVehiculo())).findFirst();
        
        if (existe.isPresent()) {
            throw new IllegalArgumentException("Ya existe un vehiculo con el codigo: " + vehiculo.getCodigoVehiculo());
        }
        
        inventarioVehiculos.add(vehiculo);
    }
    
    // Método para calcular el costo de reparación de un vehículo
    public double calcularCostoReparacion(String codigoVehiculo, int horas) {
        Vehiculo vehiculo = buscarVehiculoPorCodigo(codigoVehiculo);
        
        if (vehiculo.getEstado() != EstadoVehiculo.EN_REPARACION) {
            throw new IllegalArgumentException("El vehiculo no esta en reparacion.");
        }
        
        return vehiculo.calcularCostoReparacion(horas);
    }
    
    // Método para iniciar la reparación de un vehículo
    public void iniciarReparacion(String codigoVehiculo, String descripcion) {
        Vehiculo vehiculo = buscarVehiculoPorCodigo(codigoVehiculo);
        
        if (vehiculo.getEstado() != EstadoVehiculo.EN_REPARACION) {
            throw new IllegalArgumentException("El vehiculo no esta en reparacion.");
        }
        
        vehiculo.iniciarReparacion(nombreTaller, descripcion);
        vehiculosEnReparacion.add(vehiculo);
    }
    
    // Método para finalizar la reparación de un vehículo
    public void finalizarReparacion(String codigoVehiculo) {
        Vehiculo vehiculo = buscarVehiculoPorCodigo(codigoVehiculo);
        
        if (vehiculo.getEstado() != EstadoVehiculo.EN_REPARACION) {
            throw new IllegalArgumentException("El vehiculo no esta en reparacion.");
        }
        
        vehiculo.finalizarReparacion();
        vehiculosEnReparacion.remove(vehiculo);
    }
    
    // Método que devuelve la lista de vehículos disponibles
    public List<Vehiculo> traerVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        
        for (Vehiculo v : inventarioVehiculos) {
            
            if (v.getEstado() == EstadoVehiculo.DISPONIBLE) {
                disponibles.add(v);
            }
        }
        
        return disponibles;
    }
    
    public List<Vehiculo> traerVehiculos(EstadoVehiculo estado) {
        List<Vehiculo> filtrados = new ArrayList<>();
        
        for (Vehiculo v : inventarioVehiculos) {
            
            if (v.getEstado() == estado) {
                filtrados.add(v);
            }
        }
        
        return filtrados;
    }
    
    public List<String> obtenerHistorialReparaciones(String codigoVehiculo) {
        Vehiculo vehiculo = buscarVehiculoPorCodigo(codigoVehiculo);
        return vehiculo.obtenerHistorialReparaciones();
    }
    
    // Método que busca un vehículo por su código
    private Vehiculo buscarVehiculoPorCodigo(String codigoVehiculo) {
        return inventarioVehiculos.stream().filter(v -> v.getCodigoVehiculo().equals(codigoVehiculo)).findFirst().orElseThrow(() -> new IllegalArgumentException("No existe un vehiculo con el codigo: " + codigoVehiculo));
    }

    @Override
    public String toString() {
        return "Taller {" + "nombre del taller = " + nombreTaller + ", inventario de vehiculos = " + inventarioVehiculos + ", vehiculos en reparacion = " + vehiculosEnReparacion + "}";
    }
}