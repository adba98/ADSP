package org.adsp.patterns.collections.composite;

public class File extends FileSystemPart {
    private final long size;

    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    public long getComponentSize() {
        return size;
    }
}
