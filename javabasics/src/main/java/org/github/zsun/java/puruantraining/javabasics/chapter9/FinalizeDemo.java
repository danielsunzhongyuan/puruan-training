package org.github.zsun.java.puruantraining.javabasics.chapter9;

public class FinalizeDemo {
    private static FinalizeDemo obj = null;

    protected void finalize() throws Throwable {
        System.out.println("In finalize()");
        obj = this;
    }

    public static void main(String[] args) throws InterruptedException {
        obj = new FinalizeDemo();
        obj = null;
        System.gc();

        // without sleep, gc could be able to run faster than line 8, then obj would be null (Not alive)
        // but with this sleep, even only sleep 1 millisecond, obj would be assigned to "this" at line 8,
        // then obj would be not null (Still alive)
        Thread.sleep(1);
        if (obj != null) {
            System.out.println("Still alive");
        } else {
            System.out.println("Not alive");
        }
    }
}
