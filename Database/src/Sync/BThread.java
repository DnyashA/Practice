package Sync;

public class BThread extends Thread {
    private Bank bankWork;
    private int intTrans;
    private long lngSleep;

    public void run(){
        bankWork.calc(lngSleep, intTrans);
    }

    BThread(Bank bnk, int trans, long sleep){
        bankWork = bnk;
        intTrans = trans;
        lngSleep = sleep;
    }
}
