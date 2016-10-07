package ru.innopolis.cource5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by innopolis on 07.10.16.
 */
public class Alarm implements Runnable {

    private int[] conditions = new int[10];
    private  int conditionsIndex = 0;
    private Metronom metronom;
    public void addCondition(int i) {
        if (conditionsIndex < 10) {
            conditions[conditionsIndex] = i;
            conditionsIndex++;
        } else
            throw new IndexOutOfBoundsException("Нельхя добавлять больше 10 условий");
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            checkConditions();
            System.out.println("alarm checked");
            Practic.checkWait.set(false);
            synchronized (Practic.monitor) {
                while (!Practic.checkWait.get()) {
                    try {
                        Practic.monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }


    }

    public boolean checkConditions() {

        int seconds = metronom.getSecond();
        if (seconds != 0)
            for (int i = 0; i < conditionsIndex; i++) {
                if (seconds % conditions[i] == 0) {
                    System.out.println(String.format("Прошло %d секунд", seconds));
                    return true;
                }
            }
        return false;
    }

    public void setMetronom(Metronom metronom) {
        this.metronom = metronom;
    }
}
