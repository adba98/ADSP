package org.adsp.patterns.collections.Visitor;

public class NonCaliforniaOrder implements Order {
    private final double orderAmount;

    public NonCaliforniaOrder(double inp_orderAmount) {
        orderAmount = inp_orderAmount;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    @Override
    public void accept(OrderVisitor v) {
        v.visit(this);
    }
}
