package ru.innopolis.practic20161010;

import java.sql.Time;

/**
 * Created by innopolis on 10.10.16.
 */
public class Main {


    public static void main(String[] args) {

        Methronom methronom = new Methronom();
        Box box = new Box();
        Randomize timer = new Randomize(methronom, box);
        Thread t = new Thread(timer);
        t.setName("Randomize");
        t.start();

        ManageThread manageThread = new ManageThread(box, t);
        Thread t2 = new Thread(manageThread);
        t2.setName("ManageThread");
        t2.setDaemon(true);
        t2.start();

    }
}
