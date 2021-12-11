package org.github.zsun.java.puruantraining.javabasics.chapter2;

public class StringDemo {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = "abc";
        System.out.println(a == b);
        System.out.println(a == c);

        String d = b.intern();
        System.out.println(a == d);

        String x = new String("xyz");
        String y = x.intern();
        String z = "xyz";
        System.out.println(y == z);
    }
}
