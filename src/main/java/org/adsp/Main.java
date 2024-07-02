package org.adsp;

import org.adsp.patterns.collections.composite.CompositeException;
import org.adsp.patterns.collections.composite.Directory;
import org.adsp.patterns.collections.composite.File;
import org.adsp.patterns.collections.composite.FileSystemPart;

public class Main {
    public static void main(String[] args) {
        FileSystemPart mainFolder = new Directory("Year2024");
        FileSystemPart subFolder1 = new Directory("Jan");
        FileSystemPart subFolder2 = new Directory("Feb");

        FileSystemPart folder1File1 = new File("Jan1DataFile.txt", 1000);
        FileSystemPart folder1File2 = new File("Jan2DataFile.txt", 2000);
        FileSystemPart folder2File1 = new File("Feb1DataFile.txt", 3000);
        FileSystemPart folder2File2 = new File("Feb2DataFile.txt", 4000);

        try {
            mainFolder.addComponent(subFolder1);
            mainFolder.addComponent(subFolder2);
            subFolder1.addComponent(folder1File1);
            subFolder1.addComponent(folder1File2);
            subFolder2.addComponent(folder2File1);
            subFolder2.addComponent(folder2File2);
        } catch (CompositeException ex) {
            System.out.println();
        }

        // Client refers to both composite &
        // individual components in a uniform manner
        System.out.println(" Main Folder Size = " + mainFolder.getComponentSize() + "kb");
        System.out.println(" Sub Folder1 Size = " + subFolder1.getComponentSize() + "kb");
        System.out.println(" File1 in Folder1 size = " + folder1File1.getComponentSize() + "kb");
    }
}
