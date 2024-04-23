import java.util.ArrayList;
import java.util.Random;

public class Listas {
    private ArrayList<Asiento> pendientes;
    private ArrayList<Asiento> confirmadas;
    private ArrayList<Asiento> canceladas;
    private ArrayList<Asiento> verificadas;
    private Random random;

    public Listas() {
        pendientes = new ArrayList<>();
        confirmadas = new ArrayList<>();
        canceladas = new ArrayList<>();
        verificadas = new ArrayList<>();
        random = new Random();
    }

    /**
     * Con este método se accede al array correspondiente
     */
    public synchronized ArrayList<Asiento> getRegPendientes(){
        return pendientes;
    }

    public synchronized ArrayList<Asiento> getRegConfirmadas(){
        return confirmadas;
    }

    public synchronized ArrayList<Asiento> getRegCanceladas(){
        return canceladas;
    }

    public synchronized ArrayList<Asiento> getRegVerificadas(){
        return verificadas;
    }

    /**
     * Estos métodos agregan un asiento al array correspondiente
     */
    public synchronized void registrarReserva(Asiento asiento){

        pendientes.add(asiento);
    }

    public synchronized void registrarPago(Asiento asiento){
        confirmadas.add(asiento);
    }

    public synchronized void registrarCancelacion(Asiento asiento){
        canceladas.add(asiento);
    }

    public synchronized void registrarVerificacion(Asiento asiento){
        verificadas.add(asiento);
    }


    /**
     * Este método elimina una asiento del array correspondiente
     */
    public synchronized void eliminarPendiente(Asiento asiento){
        pendientes.remove(asiento);
    }

    public synchronized void eliminarConfirmada(Asiento asiento){
        confirmadas.remove(asiento);
    }

    /**
     * Este método se utiliza para obtener una de las reservas de cualquiera
     * de las listas que necesite. Es decir de la lista que pase por parámetro
     */

    public synchronized Asiento getUnAsientoCualquiera(ArrayList<Asiento> registro){
        int nroAleatorio = random.nextInt(registro.size());
        return registro.get(nroAleatorio);
    }

    public synchronized String info(){
        Integer nCancelados = 0;
        for(Asiento asiento: canceladas){
            nCancelados++;
        }
        Integer nVerificados = 0;
        for(Asiento asiento: verificadas){
            nVerificados++;
        }
        return "Verificados: " + nVerificados  + "\nCancelados: " + nCancelados;
    }
}
