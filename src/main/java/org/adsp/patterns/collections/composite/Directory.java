package org.adsp.patterns.collections.composite;

import java.util.Enumeration;
import java.util.Vector;

public class Directory extends FileSystemPart {
    Vector<FileSystemPart> dirContents = new Vector<>();
    //individual files/sub folders collection

    public Directory(String cName) {
        super(cName);
    }

    public void addComponent(FileSystemPart fc) throws CompositeException {
        dirContents.add(fc);
    }

    public long getComponentSize() {
        long sizeOfAllFiles = 0;
        Enumeration<FileSystemPart> e = dirContents.elements();
        while (e.hasMoreElements()) {
            FileSystemPart component = (FileSystemPart) e.nextElement();
            sizeOfAllFiles = sizeOfAllFiles + (component.getComponentSize());
        }
        return sizeOfAllFiles;
    }
}
