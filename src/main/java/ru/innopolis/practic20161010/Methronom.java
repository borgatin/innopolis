package ru.innopolis.practic20161010;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by innopolis on 10.10.16.
 */
public class Methronom {
    private AtomicInteger seconds = new AtomicInteger(0);

    int getSecond() {
        return seconds.get();
    }

    void incSeconds(){
        seconds.incrementAndGet();
    }


}
