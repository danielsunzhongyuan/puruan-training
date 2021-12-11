package org.github.zsun.java.puruantraining.javabasics.chapter3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static void StreamCopyWithIssue() {
        Map<String, Test> map = new HashMap<>();
        map.put("1", new Test());
        map.put("2", new Test());

        map.get("1").setList(new ArrayList<>());
        Map<String, Test> map1 = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        map1.get("1").getList().add("a");
        map.forEach((k, v) -> {
            System.out.println(v.getList());
        }); // 依然被影响了
    }

    /**
     * Here use Gson to serialize
     */
    public static void SerializationCopy() {
        Map<String, Test> map = new HashMap<>();
        map.put("3", new Test());
        map.put("4", new Test());

        map.get("3").setList(new ArrayList<>());

        Gson gson = new Gson();

        String s = gson.toJson(map);
        Type type = new TypeToken<HashMap<String, Test>>() {
        }.getType();
        Map<String, Test> o = gson.fromJson(s, type);

        o.get("3").getList().add("xxx");

        map.forEach((k, v) -> {
            System.out.println(v.getList());
        });

        o.forEach((k, v) -> {
            System.out.println(v.getList());
        });
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
