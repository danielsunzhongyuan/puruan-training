package org.github.zsun.java.puruantraining.javabasics.chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        Collections.sort(strings);
        for (String s : strings) {
            System.out.println("s = " + s);
//            strings.remove("two");
        }
    }
}
