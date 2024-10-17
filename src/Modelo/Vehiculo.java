/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Agustín
 */

// Clase abstracta Vehiculo que representa las características comunes de todos los vehículos
public abstract class Vehiculo {
    protected String codigoVehiculo; // Código único del vehículo
    protected String modelo; // Modelo del vehículo
    protected double precioBase; // Precio base del vehículo
    protected EstadoVehiculo estado; // Estado actual del vehículo
    protected List<String> historialReparaciones; // Historial de reparaciones del vehículo

    // Constructor que inicializa los valores del vehículo
    public Vehiculo(String codigoVehiculo, String modelo, double precioBase) {
        
        // Validación de que el código del vehículo tenga 7 caracteres
        if (codigoVehiculo == null || codigoVehiculo.length() != 7) {
            throw new IllegalArgumentException("El codigo del vehiculo debe tener 7 caracteres.");
        }
        
        this.codigoVehiculo = codigoVehiculo;
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.estado = EstadoVehiculo.DISPONIBLE; // Por defecto el vehículo está disponible
        this.historialReparaciones = new ArrayList<>();
    }

    // Getters y setters para los atributos del vehículo
    public String getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(String codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    public List<String> getHistorialReparaciones() {
        return historialReparaciones;
    }

    public void setHistorialReparaciones(List<String> historialReparaciones) {
        this.historialReparaciones = historialReparaciones;
    }
    
    // Método abstracto que debe ser implementado por las subclases para calcular el costo de reparación
    public abstract double calcularCostoReparacion(int horas);
    
    // Método que inicia una reparación y registra el historial
    public void iniciarReparacion(String nombreTaller, String descripcion) {
        
        if (this.estado == EstadoVehiculo.EN_REPARACION) {
            throw new IllegalArgumentException("El vehiculo ya esta en reparacion.");
        }
        
        this.estado = EstadoVehiculo.EN_REPARACION;
        String entradaHistorial = String.format("%s: [%s] %s", LocalDate.now(), nombreTaller, descripcion);
        historialReparaciones.add(entradaHistorial); // Añadir entrada al historial
    }
    
    // Método que finaliza la reparación y actualiza el estado del vehículo
    public void finalizarReparacion() {
        
        if (this.estado != EstadoVehiculo.EN_REPARACION) {
            throw new IllegalArgumentException("El vehiculo no esta en reparacion.");
        }
        
        this.estado = EstadoVehiculo.DISPONIBLE;
        String entradaHistorial = String.format("%s: Reparacion finalizada.", LocalDate.now());
        historialReparaciones.add(entradaHistorial); // Añadir entrada al historial
    }
    
    // Método que devuelve el historial de reparaciones
    public List<String> obtenerHistorialReparaciones() {
        return historialReparaciones;
    }

    // Método toString que muestra los detalles del vehículo
    @Override
    public String toString() {
        return "Vehiculo {" + "codigo del vehiculo = " + codigoVehiculo + ", modelo = " + modelo + ", precio base = " + precioBase + ", estado = " + estado + "}";
    }
}