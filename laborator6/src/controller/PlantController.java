package controller;

import robot.Pcmd;
import robot.PlantRobot;
import robot.Ppoz;
import robot.PpozPlant;

public class PlantController extends Thread {
    Ptask ptask;
    Pplant pplant;
    Pwait pwait;
    Pfeedback pfeedback;
    Pcmd pcmd;
    PpozPlant ppozPlant;

    public PlantController(Ptask ptask, Pfeedback pfeedback, Pcmd pcmd, PpozPlant ppozPlant){
        this.ptask = ptask;
        this.pfeedback = pfeedback;
        this.ppozPlant = ppozPlant;
        this.pcmd = pcmd;
        pplant = new Pplant();
        pwait = new Pwait();
    }

    @Override
    public void run() {
        while (true){
            ptask.waitForToken();
            //t1 grd
            if(ptask.x > pplant.x){
                pcmd.setCmd(1);
                ptask.setTask(ptask.x);
                //ptask.x = ptask.x;
            }
            if(ptask.x < pplant.x){
                pcmd.setCmd(-1);
                ptask.setTask(ptask.x);
                //ptask.x = ptask.x;
            }
            if(ptask.x == pplant.x) {
                pcmd.setCmd(0);
            }
            System.out.println("S-a executat controller t1, comanda: " + pcmd.cmd);
            //t2 grd
            ppozPlant.waitForToken();
            pfeedback.setFeedback(ppozPlant.x);
            pplant.x = ppozPlant.x;
            System.out.println("S-a executat controller t2, feedback: " + pfeedback.x);
        }
    }

    public static void main(String[] args) {
        Ptask ptask = new Ptask();
        Pfeedback pfeedback = new Pfeedback();
        Pcmd pcmd = new Pcmd();
        PpozPlant ppozPlant = new PpozPlant();
        PlantRobot plantRobot = new PlantRobot(pcmd,ppozPlant);
        PlantController plantController = new PlantController(ptask,pfeedback,pcmd,ppozPlant);
        plantRobot.start();
        plantController.start();
        ptask.setTask(2);
        try{
            Thread.sleep(8000);
        } catch (InterruptedException ignored) {}
        System.out.println("Plant controller feedback este: " + pfeedback.x);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored){}

    }
}
