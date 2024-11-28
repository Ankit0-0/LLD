package org.LLD.observer.finalLoggers;

import org.LLD.observer.LogObserver;

public class ConsoleLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("CONSOLE: " + message);
    }
}
