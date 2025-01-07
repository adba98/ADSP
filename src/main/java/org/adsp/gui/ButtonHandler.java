package org.adsp.gui;

import org.adsp.patterns.collections.Iterator.Candidate;
import org.adsp.patterns.collections.Iterator.External.AllCandidates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

class ButtonHandler implements ActionListener {
    FrameUI frame;

    public ButtonHandler(FrameUI frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(FrameUI.EXIT)) {
            System.exit(0);
        }
        if (e.getActionCommand().equals(FrameUI.GET_CANDIDATES)) {
            String selection = frame.getCertificationType();
            AllCandidates ac = new AllCandidates();
            Iterator<Candidate> certCandidates = ac.getCertifiedCandidates(selection);
            StringBuilder selectedCandidates = new StringBuilder("Name --- Cert Type --- Location" + "\n" + "--------------------------------------");
            while (certCandidates.hasNext()) {
                Candidate c = certCandidates.next();
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
