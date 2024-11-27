package org.LLD.logger;

public class DebugLogger extends AbstractLogger{
    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String msg) {
        System.out.println("DEBUG: " + msg);
    }
}
