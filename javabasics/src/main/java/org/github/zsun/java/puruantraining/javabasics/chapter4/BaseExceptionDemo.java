package org.github.zsun.java.puruantraining.javabasics.chapter4;

public class BaseExceptionDemo {
    public static void main(String[] args) {
        int i = 0;
        int[] a = {1, 2, 3, 4};
        try {
            System.out.println("Before while.");
            while (i < 5) {
                System.out.println(a[i]);
                i++;
            }
            System.out.println("After while.");
        } catch (Exception e) {
            System.out.println("Exception happens!");
//            System.exit(0);
            return;
        } finally {
            a = null;
            System.out.println("In finally");
        }
        System.out.println("After try-catch");
    }
}
