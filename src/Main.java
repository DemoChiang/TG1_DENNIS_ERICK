
import java.util.Scanner;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob Ramirez
 */
public class Main {

    public static Scanner Leer = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int Numero = 0;
        JavaBank Clientes;
        char tipo;

        System.out.print("/n/n-----------------------------Prestamos Bancarios-----------------------------");
        System.out.print("/n/nCantidad de Clientes a Registrar = ");
        Numero = Leer.nextInt();

        Clientes = new JavaBank(Numero);
        Numero = 0;

        System.out.print("/n/n------------------------Adicion de Clientes------------------------");

        do{
            System.out.print("/n/n/tTipo de Prestamo = ");
            tipo = Leer.next().charAt(0);
            Clientes.AdicionCliente(tipo);
            System.out.print("/n/n/tContinuar 1. Si 2. No = ");
            Numero = Leer.nextInt();
        }while(Numero == 1);

        System.out.print("/n/n------------------------Monto Total Pendiente de Pago------------------------");
        System.out.print("/n/n/tTotal Monto = "+Clientes.montoTotalPendiente());

        System.out.print("/n/n------------------------Imprimir Detalle de Clientes------------------------");
        Clientes.ImprimirDetalleMensual();

    }

    public static class JavaBank{

        public Prestamo[] Lista;
        public int Contador;

        public JavaBank(int Elementos){
            Lista = new Prestamo[Elementos];
            Contador = 0;
        }

        public boolean AdicionCliente(char tipo){
            for(Prestamo dato : Lista){
                if(dato != null){
                    System.out.print("/n/n/tNombre del Cliente  = ");
                    String Nombre = Leer.next();
                    System.out.print("/tMonto del Prestamo  = ");
                    double Monto = Leer.nextDouble();
                    System.out.print("/tNumero de Cuotas    = ");
                    int Cuotas = Leer.nextInt();

                    if(tipo=='V'){
                        System.out.print("/tDesea usar BanProvi = ");
                        boolean Ban = Leer.nextBoolean();
                        dato = new PrestamoVivienda(Monto,Nombre,Cuotas,Ban);
                    }else{
                        System.out.print("/n/n/tSerie del Auto     = ");
                        String Serie = Leer.next();
                        dato = new PrestamoAuto(Monto,Nombre,Cuotas,Serie);
                    }

                    return true;
                }
            }

            return false;
        }

        public double montoTotalPendiente(){
            double montoTotal = 0.0;

            for(Prestamo dato : Lista){
                if(dato!=null){
                    montoTotal += dato.saldoPendiente();
                }
            }

            return montoTotal;
        }

        public void ImprimirDetalleMensual(){
            for(Prestamo dato : Lista){
                if(dato!=null){
                    System.out.print("/n/n/tNombre del Cliente = "+dato.getNombre());
                    if(dato instanceof PrestamoVivienda)
                        System.out.print("/n/tTipo de Prestamo = Prestamo de Vivienda");
                     System.out.print("/n/tTipo de Prestamo = Prestamo de Auto");
                }
            }
        }

    }

}
