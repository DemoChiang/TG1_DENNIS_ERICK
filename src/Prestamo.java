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
    protected Cuota[] cuotas;

    public Prestamo(double m, int longi, String n){
        montoPrestamo = m;
        cuotas = new Cuota[longi];
        nombre = n;

        double partes = montoPrestamo/longi;

        for(int A=0; A<cuotas.length;A++){
            cuotas[A]=new Cuota(partes,false);
        }
    }

    public String getNombre(){
        return nombre;
    }


    public abstract double getTasaInteres();

    public abstract double saldoPendiente();



}
