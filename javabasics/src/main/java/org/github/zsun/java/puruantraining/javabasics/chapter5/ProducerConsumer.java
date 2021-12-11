package org.github.zsun.java.puruantraining.javabasics.chapter5;

class ProductData {
    private int number;
    private boolean flag = true;

    public synchronized void produce(int number) {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        this.number = number;
        flag = false;
        notify();
    }

    public synchronized int consume() {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        flag = true;
        notify();
        return this.number;
    }
}

class Producer extends Thread {
    private ProductData s;

    Producer(ProductData s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 50000; i++) {
            s.produce(i);
            System.out.println("P[" + i + "] Product.");
        }
    }
}

class Consumer extends Thread {
    private ProductData s;
    Consumer(ProductData s) {
        this.s = s;
    }

    @Override
    public void run() {
        int i;
        do {
            i = s.consume();
            System.out.println("p[" + i + "] consume.");
            i++;
        } while (i != 50001);
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        ProductData s = new ProductData();
        new Producer(s).start();
        new Consumer(s).start();
    }
}
