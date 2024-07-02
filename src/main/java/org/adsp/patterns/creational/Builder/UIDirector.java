package org.adsp.patterns.creational.Builder;

public class UIDirector {
    private final UIBuilder builder;

    public UIDirector(UIBuilder builder) {
        this.builder = builder;
    }

    public void build() {
        builder.addUIControls();
        builder.initialize();
    }
}
