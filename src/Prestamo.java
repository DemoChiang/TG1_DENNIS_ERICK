/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laptop
 */
public abstract class Prestamo {
    protected double montoPrestamo;
    protected String nombre;
    protected Cuota cuotas[];

    public Prestamo(double m, int longi, String n){
        montoPrestamo = m;
        cuotas = new Cuota[longi];
        nombre = n;
    }


    public abstract double getTasaInteres();

    public abstract double saldoPendiente();



}
