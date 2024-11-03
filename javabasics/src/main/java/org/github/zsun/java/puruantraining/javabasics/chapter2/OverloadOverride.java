package org.github.zsun.java.puruantraining.javabasics.chapter2;

class Base {
    public void print() {
    }

    public void print(int row) {
    }

    public void print(String type) {
    }
}

class child extends Base {
    public void print() {
    }

    // return type does not count when trying to overload a new method
//    public String print(int row) {}

    @Override
    public void print(String type) {
    }

    // overload
    public void print(int row, String type) {
    }

    public void print(String type,int row) {
    }
}

public class OverloadOverride {

    public static void main(String[] args) {
    }
}
