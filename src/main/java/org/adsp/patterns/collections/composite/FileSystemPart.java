package org.adsp.patterns.collections.composite;

public abstract class FileSystemPart {
    String name;

    public FileSystemPart(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemPart component) throws CompositeException {
        throw new CompositeException("Invalid Operation. Not Supported");
    }

    public abstract long getComponentSize();
}
