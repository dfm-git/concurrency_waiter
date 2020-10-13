package es.centroafuera.psp.ejemplosJava;

public class Cliente extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (Main.barraDelBar) {
                    if (!Main.barraDelBar.isEmpty()) {
                        System.out.println("Voy a beberme un " + Main.barraDelBar.get(0));
                        Main.barraDelBar.remove(0);
                        sleep(2000);
                    } else {
                        Main.barraDelBar.notify();
                    }
                }
            } catch(InterruptedException e){
                    e.printStackTrace();
            }
        }
    }
}
