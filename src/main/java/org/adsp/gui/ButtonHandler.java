package org.adsp.gui;

import org.adsp.patterns.collections.Iterator.Internal.AllCandidates;
import org.adsp.patterns.collections.Iterator.Candidate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonHandler implements ActionListener {
    FrameUI frame;

    public ButtonHandler(FrameUI frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(FrameUI.EXIT)) {
            System.exit(0);
        }
        if (e.getActionCommand().equals(FrameUI.SHOW_ALL)) {
            AllCandidates ac = new AllCandidates();
            StringBuilder selectedCandidates = new StringBuilder("Name --- Cert Type --- Location" + "\n" + "--------------------------------------");
            while (ac.hasNext()) {
                Candidate c = (Candidate) ac.next();
                selectedCandidates
                        .append("\n")
                        .append(c.getName())
                        .append(" - ")
                        .append(c.getCertificationType())
                        .append(" - ")
                        .append(c.getLocation());
            }
            frame.setSelectedCandidates(selectedCandidates.toString());
        }
    }
}
