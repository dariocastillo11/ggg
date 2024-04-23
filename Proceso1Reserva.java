public class Proceso1Reserva implements Runnable{
    private Avion avion;
    private Listas listas;

    //constructor del proceso de reserva
    public Proceso1Reserva(Avion avion, Listas listas){
        this.avion = avion;
        this.listas = listas;
    }

    //método run
    @Override
    public void run(){
        while(true){ //se debe ejecutar continuamente
            Asiento asiento = avion.getUnAsiento();
            if(asiento.getEstado().equals("disponible")){
                avion.setearAsiento(asiento, "ocupado"); //se setea el estado del asiento como OCUPADO
                listas.registrarReserva(asiento); //se registra la reserva en un array de PENDIENTES
                System.out.println(Thread.currentThread().getName() + "ha reservado el asiento " + asiento.getNumero());
                System.out.println(Thread.currentThread().getName() + " reservó exitosamente.");
            }else{System.out.println(Thread.currentThread().getName()+"no se encontro un asiento disponible");}
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}

