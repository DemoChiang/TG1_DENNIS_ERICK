/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laptop
 */
class Cuota {
    private double pagoMensual;
    private boolean pagada;

    public Cuota(double pm, boolean p){
        pagoMensual = pm;
        pagada = p;
    }

    public void sumarIntereses(double Int){
        pagoMensual += Int;
    }

    public double getPagoMensual(){
        return pagoMensual;
    }

    public boolean getPagada(){
        return pagada;
    }

}
