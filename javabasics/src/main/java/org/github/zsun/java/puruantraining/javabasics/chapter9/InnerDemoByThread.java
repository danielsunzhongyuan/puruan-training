package org.github.zsun.java.puruantraining.javabasics.chapter9;

public class InnerDemoByThread {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
           new Thread(new Runnable() {
               @Override
               public void run() {
                   for (int j = 0; j < 5; j++) {
                       System.out.println(Thread.currentThread().getName() + " -- " + j);
                   }
               }
           }).start();
        }
    }
}
