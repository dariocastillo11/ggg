import java.util.ArrayList;
import java.util.Random;
public class Avion {
    private Asiento asiento;
    private ArrayList<Asiento> asientos;
    private Random random;

    public Avion() {
        random = new Random();
        asientos = new ArrayList<Asiento>();
        for (int i = 0; i < 186; i++) {
            asientos.add(asiento = new Asiento(i));
        }
    }

        public String printMatriz() {
            Integer totalOcupados = 0;
            for (Asiento asiento : asientos) {
                if (asiento.getEstado().equals("ocupado")) {
                    totalOcupados++;
                }
            }
            return " Ocupación final: " + totalOcupados.toString() + " asientos";
        }


    public synchronized void setearAsiento(Asiento asiento, String estado) {
        asiento.setEstado(estado);
        asientos.set(asiento.getNumero(), asiento);
    }


    public synchronized Asiento getUnAsiento() {
        return asientos.get(random.nextInt(asientos.size()));
    }
}