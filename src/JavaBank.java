import java.util.Scanner;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob Ramirez
 */
public class JavaBank {

    public static Scanner Leer = new Scanner(System.in);
    public static Prestamo[] Lista;
    public static int contador=0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int Numero = 0;
        char tipo;
        boolean Veri;

        System.out.print("\n\n-----------------------------Prestamos Bancarios-----------------------------");
        System.out.print("\n\nCantidad de Clientes a Registrar = ");
        Numero = Leer.nextInt();
        Lista = new Prestamo[Numero];

        System.out.print("\n\n------------------------Adicion de Clientes------------------------");

        do{
            System.out.print("\n\n\tTipo de Prestamo = ");
            tipo = Leer.next().charAt(0);

            Veri = AdicionCliente(tipo);

            if(Veri)
                System.out.print("\n\nAlmacenamiento Exitoso");
            System.out.print("\n\nImposible almacenamiento en el sistema");

            System.out.print("\n\n\tContinuar 1. Si 2. No = ");
            Numero = Leer.nextInt();
        }while(Numero == 1);

        System.out.print("\n\n------------------------Monto Total Pendiente de Pago------------------------");
        System.out.print("\n\n\tTotal Monto = "+montoTotalPendiente());

        System.out.print("\n\n------------------------Imprimir Detalle de Clientes------------------------");
        ImprimirDetalleMensual();

    }

    public static boolean AdicionCliente(char tipo){
            for(int A=0; A<Lista.length;A++){
                if(Lista[A] == null){
                    System.out.print("\n\n\tNombre del Cliente  = ");
                    String Nombre = Leer.next();
                    System.out.print("\tMonto del Prestamo  = ");
                    double Monto = Leer.nextDouble();
                    System.out.print("\tNumero de Cuotas    = ");
                    int Cuotas = Leer.nextInt();

                    if(tipo=='V'){
                        System.out.print("\tDesea usar BanProvi = ");
                        boolean Ban = Leer.nextBoolean();
                        Lista[A] = new PrestamoVivienda(Monto,Cuotas,Nombre,Ban);
                    }else{
                        System.out.print("\n\n\tSerie del Auto     = ");
                        String Serie = Leer.next();
                        Lista[A] = new PrestamoAuto(Monto,Cuotas,Nombre,Serie);
                    }

                    return true;
                }
            }

            return false;
        }

        public static double montoTotalPendiente(){
            double montoTotal = 0.0;

            for(Prestamo dato : Lista){
                if(dato!=null){
                    montoTotal += dato.saldoPendiente();
                }
            }

            return montoTotal;
        }

        public static void ImprimirDetalleMensual(){
            for(Prestamo dato : Lista){
                if(dato!=null){
                    System.out.print("\n\n\tNombre del Cliente = "+dato.getNombre());
                    if(dato instanceof PrestamoVivienda){
                        System.out.print("\n\tTipo de Prestamo = Prestamo de Vivienda");
                    }else{
                        System.out.print("\n\tTipo de Prestamo = Prestamo de Auto/n/n");
                    }
                }
            }
        }


    }
