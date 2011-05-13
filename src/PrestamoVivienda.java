/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laptop
 */
public class PrestamoVivienda extends Prestamo {
    public boolean usaBanprovi;

    public PrestamoVivienda(double m, int longi, String n, boolean v){
        super(m,longi,n);
        usaBanprovi = v;
        double Intereses = (getTasaInteres()*montoPrestamo)/longi;

        for(int A=0; A<cuotas.length; A++)
            cuotas[A].sumarIntereses(Intereses);
    }

    public double getTasaInteres(){
        double tasaInteres = 0.0;
        if(usaBanprovi){
            tasaInteres = 0.10;
        }else{
           tasaInteres = 0.20;
        }
        return tasaInteres;
    }

    public double saldoPendiente(){
        double saldoPendiente = 0.0;
        for(Cuota x: cuotas){
            if(x!=null&&x.getPagada()==false){
                saldoPendiente+=x.getPagoMensual();
            }
        }
        return saldoPendiente+57000;
    }




}
