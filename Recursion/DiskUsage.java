package Recursion;

import java.io.File;
import java.util.Arrays;

public class DiskUsage {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(new File("AlgorithmAnalysis").list()).toList());
        System.out.println(usage(new File("AlgorithmAnalysis")));
    }
    public static long usage(File root){
        long total = root.length();
        System.out.println("root - " + root + " = " + total);
        if (root.isDirectory()){
            for (String childName : root.list()){
                File child = new File(root,childName);
                total += usage(child);
            }
        }
        return total;
    }
}
