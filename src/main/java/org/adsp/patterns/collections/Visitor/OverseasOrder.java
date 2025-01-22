package org.adsp.patterns.collections.Visitor;

public class OverseasOrder implements Order {
    private final double orderAmount;
    private final double additionalSH;

    public OverseasOrder(double inp_orderAmount, double inp_additionalSH) {
        orderAmount = inp_orderAmount;
        additionalSH = inp_additionalSH;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getAdditionalSH() {
        return additionalSH;
    }

    @Override
    public void accept(OrderVisitor v) {
        v.visit(this);
    }
}
