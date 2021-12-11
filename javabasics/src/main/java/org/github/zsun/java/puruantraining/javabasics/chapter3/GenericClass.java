package org.github.zsun.java.puruantraining.javabasics.chapter3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}

class WareHouse<T> {
    private List<T> products;

    public WareHouse() {
        this.products = new ArrayList<>();
    }

    public void add(T item) {
        this.products.add(item);
    }

    public void printAll() {
        Iterator<T> iterator = this.products.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            System.out.println(next.toString());
        }
    }
}

public class GenericClass {
    public static void main(String[] args) {
        WareHouse<String> stringWareHouse = new WareHouse<>();
        stringWareHouse.add("aaa");
        stringWareHouse.add("bbb");
        stringWareHouse.printAll();

        WareHouse<Item> itemWareHouse = new WareHouse<>();
        itemWareHouse.add(new Item("ccc"));
        itemWareHouse.add(new Item("ddd"));
        itemWareHouse.printAll();
    }
}
