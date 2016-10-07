package ru.innopolis.cource5;

/**
 * Created by innopolis on 07.10.16.
 */
public class MethronomThread implements Runnable {

    private Metronom metronom;
    private Alarm alarm;

    public MethronomThread(Metronom metronom, Alarm alarm) {
        this.metronom = metronom;
        this.alarm = alarm;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            metronom.incSeconds();
            System.out.println(String.format("%d seconds", metronom.getSecond()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (alarm.checkConditions()) {
                //doSome
                synchronized (Practic.monitor){
                    Practic.checkWait.set(true);
                    Practic.monitor.notifyAll();

                }
            }
        }
    }
}
