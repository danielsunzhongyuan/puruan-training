package org.github.zsun.java.puruan_training.java_basics.chapter4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileOutDemo {
    public static void main(String[] args) {

        String resource = ZipFileOutDemo.class.getClassLoader().getResource("1.txt").getPath();
        System.out.println("Absolute path " + new File(resource).getAbsolutePath());
        System.out.println("Path " + new File(resource).getPath());
        System.out.println("Parent path " + new File(resource).getParent());
        System.out.println("Absolute path " + new File(resource).getAbsolutePath());
        String zipFileName = "./x.zip";
        String file1 = ZipFileOutDemo.class.getClassLoader().getResource("1.txt").getPath();
        String file2 = ZipFileOutDemo.class.getClassLoader().getResource("2.txt").getPath();
        int zipRes = -1;
        System.out.println(System.getProperty("user.dir"));
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(zipFileName);
                final ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
                final FileInputStream fileFs1 = new FileInputStream(file1);
                final FileInputStream fileFs2 = new FileInputStream(file2);
                final BufferedInputStream bufferedIs1 = new BufferedInputStream(fileFs1);
                final BufferedInputStream bufferedIs2 = new BufferedInputStream(fileFs2)
        ) {
            zipOutputStream.putNextEntry(new ZipEntry("redirect1.txt"));
            while ((zipRes = bufferedIs1.read()) != -1) {
                bufferedOutputStream.write(zipRes);
            }

            // all data would be written to redirect2.txt if not flush here
            bufferedOutputStream.flush();

            zipOutputStream.putNextEntry(new ZipEntry("redirect2.txt"));
            while ((zipRes = bufferedIs2.read()) != -1) {
                bufferedOutputStream.write(zipRes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

