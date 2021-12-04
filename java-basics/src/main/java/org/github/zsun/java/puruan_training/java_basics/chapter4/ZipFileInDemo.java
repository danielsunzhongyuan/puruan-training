package org.github.zsun.java.puruan_training.java_basics.chapter4;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileInDemo {
    public static void main(String[] args) {
        int count;
        try (FileInputStream fileInputStream = new FileInputStream("./x.zip");
             ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream))) {
            ZipEntry ze = null;
            while ((ze = zipInputStream.getNextEntry()) != null) {
                System.out.println("file name is: " + ze);
                while ((count = zipInputStream.read()) != -1) {
                    System.out.write(count);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e2) {

        }
    }
}
