package org.adsp.gui;

import org.adsp.patterns.collections.Visitor.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonHandler implements ActionListener {
    FrameUI frame;

    public ButtonHandler() {
    }

    public ButtonHandler(FrameUI frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        String totalResult;

        if (e.getActionCommand().equals(FrameUI.EXIT)) {
            System.exit(0);
        }
        if (e.getActionCommand().equals(FrameUI.CREATE_ORDER)) {
            String orderType = frame.getOrderType();
            String strOrderAmount = frame.getOrderAmount();
            String strTax = frame.getTax();
            String strSH = frame.getSH();

            double dblOrderAmount;
            double dblTax;
            double dblSH;

            if (strOrderAmount.trim().isEmpty()) {
                strOrderAmount = "0.0";
            }
            if (strTax.trim().isEmpty()) {
                strTax = "0.0";
            }
            if (strSH.trim().isEmpty()) {
                strSH = "0.0";
            }

            dblOrderAmount = Double.parseDouble(strOrderAmount);
            dblTax = Double.parseDouble(strTax);
            dblSH = Double.parseDouble(strSH);

            Order order = createOrder(orderType, dblOrderAmount, dblTax, dblSH);
            OrderVisitor visitor = frame.getOrderVisitor();
            order.accept(visitor);

            frame.setTotalValue(" Order Created Successfully");
        }

        if (e.getActionCommand().equals(FrameUI.GET_TOTAL)) {
            OrderVisitor visitor = frame.getOrderVisitor();
            totalResult = Double.toString(visitor.getOrderTotal());
            totalResult = " Orders Total = " + totalResult;
            frame.setTotalValue(totalResult);
        }
    }

    public Order createOrder(String orderType, double orderAmount, double tax, double SH) {
        if (orderType.equalsIgnoreCase(FrameUI.CA_ORDER)) {
            return new CaliforniaOrder(orderAmount, tax);
        }
        if (orderType.equalsIgnoreCase(FrameUI.NON_CA_ORDER)) {
            return new NonCaliforniaOrder(orderAmount);
        }
        if (orderType.equalsIgnoreCase(FrameUI.OVERSEAS_ORDER)) {
            return new OverseasOrder(orderAmount, SH);
        }
        return null;
    }
}
