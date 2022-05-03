package controller;

import java.util.concurrent.Semaphore;

public class Pfeedback {
    Semaphore s = new Semaphore(0);
    public int x;

    public void waitForToken() {
        try {
            s.acquire();
        } catch (InterruptedException ignored) {
        }
    }

    public void setFeedback(int feedback) {
        this.x = feedback;
        s.release();
    }
}
