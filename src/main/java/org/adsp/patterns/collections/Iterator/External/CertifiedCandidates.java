package org.adsp.patterns.collections.Iterator.External;

import org.adsp.patterns.collections.Iterator.Candidate;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CertifiedCandidates implements Iterator<Candidate> {
    AllCandidates ac;
    String certificationType;
    Candidate nextCandidate;
    Enumeration<Candidate> ec;

    public CertifiedCandidates(AllCandidates inp_ac, String certType) {
        ac = inp_ac;
        certificationType = certType;
        ec = inp_ac.getAllCandidates();
    }

    @Override
    public boolean hasNext() {
        boolean matchFound = false;
        while (ec.hasMoreElements()) {
            Candidate tempObj = ec.nextElement();
            if (tempObj.getCertificationType().equals(certificationType)) {
                matchFound = true;
                nextCandidate = tempObj;
                break;
            }
        }
        if (!matchFound) {
            nextCandidate = null;
        }
        return matchFound;
    }

    @Override
    public Candidate next() {
        if (nextCandidate == null) {
            throw new NoSuchElementException();
        } else {
            return nextCandidate;
        }
    }
}
