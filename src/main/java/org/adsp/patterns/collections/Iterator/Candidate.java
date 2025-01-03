package org.adsp.patterns.collections.Iterator;

public class Candidate {
    private final String name;
    private final String certificationType;
    private final String location;

    public Candidate(String name, String certificationType, String location) {
        this.name = name;
        this.certificationType = certificationType;
        this.location = location;
    }

    public String getCertificationType() {
        return certificationType;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
