package org.LLD.observer.finalLoggers;

import org.LLD.observer.LogObserver;

public class FileLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Write to file: " + message);
    }
}
