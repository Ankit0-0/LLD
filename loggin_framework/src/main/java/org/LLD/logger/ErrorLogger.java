package org.LLD.logger;

public class ErrorLogger extends AbstractLogger  {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String msg) {
        System.out.println("ERROR: " + msg);
    }
}
