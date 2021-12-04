package org.github.zsun.java.puruan_training.java_basics.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String content = "";
        System.out.println("input is: ");
        try {
            content = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("output is: " + content);
    }
}
