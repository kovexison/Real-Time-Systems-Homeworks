package controller;

import java.util.concurrent.Semaphore;

public class Ptask {
    Semaphore s = new Semaphore(0);
    public int x;

    public void waitForToken(){
        try{
            s.acquire();
        } catch (InterruptedException ignored){ }
    }

    public void setTask(int task){
        this.x = task;
        s.release();
    }
}
