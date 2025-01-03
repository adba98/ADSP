package org.adsp.patterns.collections.Iterator.Internal;

import org.adsp.patterns.collections.Iterator.Candidate;
import org.adsp.utils.FileUtil;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Vector;

public class AllCandidates {
    private Vector<Candidate> data;
    Enumeration<Candidate> ec;
    Candidate nextCandidate;

    public AllCandidates() {
        initialize();
        ec = data.elements();
    }

    private void initialize() {
        data = new Vector<>();
        FileUtil util = new FileUtil();

        Vector<String> dataLines = util.fileToVector("src/main/resources/Candidates.txt");
        for (int i = 0; i < dataLines.size(); i++) {
            String str = dataLines.elementAt(i);
            StringTokenizer st = new StringTokenizer(str, ",");
            data.add(new Candidate(st.nextToken(), st.nextToken(), st.nextToken()));
        }
    }

    public boolean hasNext() {
        nextCandidate = null;
        if (ec.hasMoreElements()) {
            nextCandidate = ec.nextElement();
        }
        return (nextCandidate != null);
    }

    public Object next() {
        if (nextCandidate == null) {
            throw new NoSuchElementException();
        } else {
            return nextCandidate;
        }
    }
}
