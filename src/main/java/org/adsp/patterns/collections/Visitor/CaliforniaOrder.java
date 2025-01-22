package org.adsp.patterns.collections.Visitor;

public class CaliforniaOrder implements Order {
    private final double orderAmount;
    private final double additionalTax;

    public CaliforniaOrder(double inp_orderAmount, double inp_additionalTax) {
        orderAmount = inp_orderAmount;
        additionalTax = inp_additionalTax;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getAdditionalTax() {
        return additionalTax;
    }

    @Override
    public void accept(OrderVisitor v) {
        v.visit(this);
    }
}
