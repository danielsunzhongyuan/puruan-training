package org.github.zsun.java.puruantraining.javabasics.chapter2;

public class Question {
    public static void main(String[] args) {
        int digits = 3;
    }
    public static void main2(String[] args) {
        long i = 1;
        while (true) {
            long numberN = i * 99L;
            if (9 == getMultiple(numberN)) {
                System.out.println("end: " + numberN);
                break;
            }
            i++;
        }
    }

    private static long getMultiple(long numberN) {
        int result = 1;
        long tmp = numberN;
        while (tmp > 0) {
            result *= tmp % 10;
            tmp /= 10;
            if (tmp == 0) {
                break;
            }
            if (result > 9 || result == 0) {
                break;
            }
        }
        return result;
    }


}
