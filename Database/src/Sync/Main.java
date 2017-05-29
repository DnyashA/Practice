package Sync;

public class Main {

    public static void main(String[] args) {
        Bank bankMain = new Bank();
        BThread threadOne = new BThread(bankMain, 100, 2000);
        threadOne.setName("One");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();
        BThread threadTwo = new BThread(bankMain, 50, 300);
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.setName("Two");
        threadTwo.start();
    }
}
