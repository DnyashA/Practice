package Sync;

public class Bank {
   private int intTo;
    private int intFrom = 220;

    public synchronized void calc(long lngtimeout, int intTransaction) {
        System.out.println("Initial data: " + intTo + ", " + intFrom + ", " + Thread.currentThread().getName());
        intFrom -= intTransaction;
        try {
            Thread.sleep(lngtimeout);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        intTo += intTransaction;
        System.out.println("Final data: " + intTo + ", " + intFrom + ", " + Thread.currentThread().getName());
    }
}
