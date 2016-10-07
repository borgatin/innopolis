package ru.innopolis.cource5;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by innopolis on 07.10.16.
 */
public class Practic {
    static Object monitor = new Object();
    static AtomicBoolean checkWait = new AtomicBoolean(false);
    public static void main(String[] args) {
        Practic p = new Practic();
        Metronom metronom = new Metronom();
        Alarm alarm = new Alarm();
        alarm.addCondition(5);
        alarm.setMetronom(metronom);
        //Запуск потока будильника
        Thread alarmThread = new Thread(alarm);
        alarmThread.start();
        //Запуск потока метронома
        Runnable methronomThreadR = new MethronomThread(metronom, alarm);
        Thread methronomThread = new Thread(methronomThreadR);
        methronomThread.start();










    }
}
