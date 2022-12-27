package io.cherrytechnologies.webfluxpractise.util;

import java.time.Duration;

public class SleepUtil {
    public static void sleepSecond(long milliSeconds){
        try {
            Thread.sleep(Duration.ofMillis(milliSeconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
