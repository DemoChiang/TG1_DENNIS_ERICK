/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laptop
 */
public class PrestamoAuto extends Prestamo {
    public String serieAutoMotor;
    public Cuota cuotaSeguro[];

    public PrestamoAuto(double m, int longi,String n, String motor){
        super(m, longi, n);
        serieAutoMotor = motor;
        cuotaSeguro = new Cuota[longi];
    }

    public double getTasaInteres(){
        double tasaInteres = 0.25;
        return tasaInteres;

    }

    public double saldoPendiente(){
        double saldoPendiente = 0.0;
        for(Cuota x : cuotaSeguro){
            if(x!=null&&x.pagada==false){
                saldoPendiente+=x.pagoMensual;
            }
        }
        for(Cuota s: cuotas){
            if(s != null&&s.pagada==false){
                saldoPendiente+=s.pagoMensual;

            }
        }
        return saldoPendiente;
    }




}
