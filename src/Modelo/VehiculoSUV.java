/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

/**
 *
 * @author Agustín
 */

// Subclase VehiculoSUV que extiende de Vehiculo
public class VehiculoSUV extends Vehiculo {
    private boolean traccionIntegral; // Indica si el vehículo tiene tracción en las cuatro ruedas

    // Constructor que inicializa los valores del vehículo SUV
    public VehiculoSUV(String codigoVehiculo, String modelo, double precioBase, boolean traccionIntegral) {
        super(codigoVehiculo, modelo, precioBase);
        this.traccionIntegral = traccionIntegral;
    }

    public boolean isTraccionIntegral() {
        return traccionIntegral;
    }

    public void setTraccionIntegral(boolean traccionIntegral) {
        this.traccionIntegral = traccionIntegral;
    }

    // Implementación del método abstracto para calcular el costo de reparación
    @Override
    public double calcularCostoReparacion(int horas) {
        double costo = getPrecioBase() * horas;
        
        // Aumenta el costo si el vehículo tiene tracción integral
        if (esTraccionIntegral()) {
            costo *= 1.10;
        }
        
        return costo;
    }
    
    public boolean esTraccionIntegral() {
        return this.traccionIntegral;
    }

    @Override
    public String toString() {
        return "Vehiculo SUV {" + "codigo del vehiculo = " + getCodigoVehiculo() + ", modelo = " + getModelo() + ", precio base = " + getPrecioBase() + ", traccion integral = " + traccionIntegral + ", estado = " + getEstado() + "}";
    }
}