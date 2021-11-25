package org.github.zsun.java.puruan_training.java_basics.chapter3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

class Test implements Cloneable {
    private int i;
    private List<String> list;

    public Test() {
    }

    public Test(int i, List<String> list) {
        this.i = i;
        this.list = list;
    }

    public int getI() {
        return this.i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public List<String> getList() {
        return this.list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Test copy() {
        List<String> l = new ArrayList<>(this.getList().size());
        l.addAll(this.getList());
        return new Test(this.getI(), l);
    }
}

public class DeepCopy {

    public static void ShallowCopy() {
        Test test = new Test();
        Test test1 = test;

        System.out.println(test == test1);
        test.setI(1);
        System.out.println(test1.getI());
    }

    public static void CloneCopy() {
        Test test = new Test();
        Test test1 = null;
        try {
            test1 = (Test) test.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        test.setI(1);
        System.out.println(test1.getI());
    }

    public static void CloneCopyIssue() {
        Test test = new Test();
        test.setList(new ArrayList<>());

        Test test1 = null;
        try {
            test1 = (Test) test.clone();
            test1.getList().add("abc");
            test.getList().add("def");
            System.out.println(test.getList()); // [abc, def]
            System.out.println(test1.getList()); // [abc, def]
            // the list is not cloneable, so the two list are just the same
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static void SelfCopy() {
        Test test = new Test();
        test.setList(new ArrayList<>());

        Test test1 = test.copy();
        test.getList().add("abc");
        test1.getList().add("def");

        System.out.println(test.getList()); // [abc]
        System.out.println(test1.getList()); // [def]
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = DeepCopy.class.getMethods();
        for (Method method : methods) {
            boolean aStatic = Modifier.isStatic(method.getModifiers());
            if (aStatic) {
                if (!"main".equals(method.getName())) {
                    method.invoke(null);
                }
            }
        }
        Set<Test> a = new HashSet<>();
    }
}
