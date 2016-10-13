package ru.innopolis.cource5;

import java.util.IntSummaryStatistics;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by innopolis on 07.10.16.
 */
public class Metronom {
    private AtomicInteger seconds = new AtomicInteger(0);

    public  int getSecond() {
        return seconds.get();
    }

    public  void incSeconds(){
        seconds.incrementAndGet();
    }


}
