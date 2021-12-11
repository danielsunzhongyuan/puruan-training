package org.github.zsun.java.puruantraining.javabasics.chapter3;

import java.util.ArrayList;
import java.util.List;

class Father {
}

class Child extends Father {
}

public class GenericDeepInside {
    public static void copy(List<? super Father> dest, List<? extends Father> src) {
        for (int i = 0, length = src.size(); i < length; i++) {
            dest.add(src.get(i));
        }
    }

    public static void main(String[] args) {
        List<? extends Father> list1 = new ArrayList<>();
        List<? super Father> list2 = new ArrayList<>();
//        List<? super Father> list3 = new ArrayList<Child>(); error
        List<? super Child> list4 = new ArrayList<>();
        List<? super Child> list5 = new ArrayList<>();

        List<?> list6 = new ArrayList<String>();
        //List<?> list7 = new ArrayList<?>(); //error
        //List<T> list8 = new ArrayList<String>(); //error

        Father f = new Father();
        Child s = new Child();

//        list1.add(f);
        list2.add(f);
        list2.add(s);
        list4.add(s);
        //list4.add(f); error

        List<Father> srcFatherList = new ArrayList<Father>();
        srcFatherList.add(f);

        List<Father> destFatherList = new ArrayList<Father>();
        copy(destFatherList,srcFatherList);
        System.out.println(destFatherList.size());
    }
}
