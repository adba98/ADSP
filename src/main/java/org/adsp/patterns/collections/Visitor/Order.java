package org.adsp.patterns.collections.Visitor;

public interface Order {
    void accept(OrderVisitor v);
}
