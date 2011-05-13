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

        double partes = montoPrestamo/longi;
        double Intereses = (getTasaInteres()*montoPrestamo)/longi;

        for(int A=0; A<cuotas.length; A++)
           cuotas[A].sumarIntereses(Intereses);

        for(int A=0; A<cuotaSeguro.length;A++)
            cuotaSeguro[A]=new Cuota(partes,false);
    }

    public double getTasaInteres(){
        double tasaInteres = 0.25;
        return tasaInteres;

    }

    public double saldoPendiente(){
        double saldoPendiente = 0.0;
        for(Cuota x : cuotaSeguro){
            if(x!=null&&x.getPagada()==false){
                saldoPendiente+=x.getPagoMensual();
            }
        }
        for(Cuota s: cuotas){
            if(s != null&&s.getPagada()==false){
                saldoPendiente+=s.getPagoMensual();

            }
        }
        return saldoPendiente;
    }




}
