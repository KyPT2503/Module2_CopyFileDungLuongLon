import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Solution {
    public static void main(String[] args) {
        try {
            copyFileUsingStream(new File("one.dat"), new File("three.dat"));
            System.out.println("Copy file completed.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Copy file failed.");
        }
    }

    private static void copyFileUsingJava7Files(File source, File destination) throws IOException {
        Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File destination) throws IOException {
        FileInputStream streamFromSource = null;
        FileOutputStream streamToDestination = null;
        try {
            streamFromSource = new FileInputStream(source);
            streamToDestination = new FileOutputStream(destination);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = streamFromSource.read(buffer)) > 0) {
                streamToDestination.write(buffer, 0, length);
            }
        } finally {
            streamFromSource.close();
            streamToDestination.close();
        }
    }
}
