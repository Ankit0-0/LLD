package org.LLD;

public class FileLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("Write to file: " + message);
    }
}
