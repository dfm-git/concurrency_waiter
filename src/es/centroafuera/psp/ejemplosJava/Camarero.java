package es.centroafuera.psp.ejemplosJava;

public class Camarero extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (Main.barraDelBar) {
                    Main.barraDelBar.wait();
                    String cocacola = "Coca-Cola";
                    Main.barraDelBar.add(cocacola);
                    System.out.println("Voy a añadir un " + cocacola);

                    String fanta = "Fanta";
                    Main.barraDelBar.add(fanta);
                    System.out.println("Voy a añadir una " + fanta);

                    String vino = "Vino";
                    Main.barraDelBar.add(vino);
                    System.out.println("Voy a añadir un " + vino);

                    sleep(5000);
                    Main.barraDelBar.notify();
                }
            } catch(InterruptedException e){
                    e.printStackTrace();
            }
        }
    }
}
