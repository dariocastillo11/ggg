import java.util.Random;
import java.util.ArrayList;
public class Proceso3CancValid implements Runnable {
    private Avion avion;
    private Listas listas;
    private Random nroAleatorio;


    public Proceso3CancValid(Avion avion, Listas listas){
    this.avion =avion;
    this.listas=listas;
    this.nroAleatorio = new Random();
    }

    @Override
    public void run()
    {
        while(true){
            if(!listas.getRegConfirmadas().isEmpty()){
                Asiento asiento = listas.getUnAsientoCualquiera(listas.getRegConfirmadas());
                if(cancelarReserva() == true){
                    listas.eliminarConfirmada(asiento);
                    asiento.setEstado("descartado");
                    listas.registrarCancelacion(asiento);
                    avion.setearAsiento(asiento, "descartado");//setea el estado del asiento en el array del avión
                    System.out.println(Thread.currentThread().getName() + " canceló exitosamente la reserva del asiento " + asiento.getNumero());
                }
                else{
                    avion.setearAsiento(asiento, "checked");
                    System.out.println(Thread.currentThread().getName() + " no pudo cancelar la reserva del asiento " + asiento.getNumero() + ". Reserva checkeada.");
                }
                System.out.println(Thread.currentThread().getName() + " canceló/checkeó exitosamente.");
            }
            try {
                Thread.sleep(80);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    /**
     * Método que cancela la reserva con una probabilidad del 10% de éxito
     */
    private Boolean cancelarReserva(){
        return nroAleatorio.nextDouble() < 0.1;
    }
}


