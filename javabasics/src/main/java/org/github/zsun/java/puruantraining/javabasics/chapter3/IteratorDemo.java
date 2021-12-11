package org.github.zsun.java.puruantraining.javabasics.chapter3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            arr.add(String.valueOf(i));
        }
        Iterator<String> iterator = arr.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // LinkedList could not specify an initialCapacity
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 5; i < 10; i++) {
            linkedList.add(i);
        }
        Iterator<Integer> iterator1 = linkedList.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        Set<Float> set = new TreeSet<>();
        for (int i = 10; i < 15; i++) {
            set.add(Float.valueOf(i));
        }
        Iterator<Float> iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        // modify and remove while iterating
        IteratorDemo.modifyOnIterating();

        // another way to remove
        IteratorDemo.deleteOnIterating();
    }

    public static void modifyOnIterating() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(i));
        }

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            if (next.getKey() % 2 == 0) {
                iterator.remove();
            }
            if (next.getKey() % 3 == 0) {
                map.put(next.getKey() + 1, "xx");
            }
        }

        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }
    }

    public static void deleteOnIterating() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(i));
        }

        map.entrySet().removeIf(e -> e.getKey() % 3 == 0);

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }
    }
}
