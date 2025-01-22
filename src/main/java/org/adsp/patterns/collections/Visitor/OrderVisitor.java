package org.adsp.patterns.collections.Visitor;

public class OrderVisitor implements VisitorInterface {
    private double orderTotal;

    public OrderVisitor() {
    }

    @Override
    public void visit(NonCaliforniaOrder inp_order) {
        orderTotal = orderTotal + inp_order.getOrderAmount();
    }

    @Override
    public void visit(CaliforniaOrder inp_order) {
        orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalTax();
    }

    @Override
    public void visit(OverseasOrder inp_order) {
        orderTotal = orderTotal + inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    }

    public double getOrderTotal() {
        return orderTotal;
    }
}
