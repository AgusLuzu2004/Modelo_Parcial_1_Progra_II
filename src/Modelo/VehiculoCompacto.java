/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import java.time.LocalDate;

/**
 *
 * @author Agustín
 */

// Subclase VehiculoCompacto que extiende de Vehiculo
public class VehiculoCompacto extends Vehiculo {
    private int anio; // Año de fabricación del vehículo

    // Constructor que inicializa los valores del vehículo compacto
    public VehiculoCompacto(String codigoVehiculo, String modelo, double precioBase, int anio) {
        super(codigoVehiculo, modelo, precioBase);
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    // Implementación del método abstracto para calcular el costo de reparación
    @Override
    public double calcularCostoReparacion(int horas) {
        double costo = getPrecioBase() * horas;
        
        // Descuento si el vehículo es nuevo
        if (esVehiculoNuevo()) {
            costo *= 0.95;
        }
        
        return costo;
    }
    
    // Método que determina si el vehículo es del año en curso
    public boolean esVehiculoNuevo() {
        return this.anio == LocalDate.now().getYear();
    }

    @Override
    public String toString() {
        return "Vehiculo Compacto {" + "codigo del vehiculo = " + getCodigoVehiculo() + ", modelo = " + getModelo() + ", precio base = " + getPrecioBase() + ", anio = " + anio + ", estado = " + getEstado() + "}";       
    }
}