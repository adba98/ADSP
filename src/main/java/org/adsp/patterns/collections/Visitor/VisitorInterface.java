package org.adsp.patterns.collections.Visitor;

public interface VisitorInterface {
    void visit(NonCaliforniaOrder nco);
    void visit(CaliforniaOrder co);
    void visit(OverseasOrder oo);
}
