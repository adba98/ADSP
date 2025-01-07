package org.adsp.patterns.collections.Iterator.External;

import org.adsp.patterns.collections.Iterator.Candidate;
import org.adsp.utils.FileUtil;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class AllCandidates {
    private Vector<Candidate> data;

    public AllCandidates() {
        initialize();
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

    public Enumeration<Candidate> getAllCandidates() {
        return data.elements();
    }

    public Iterator<Candidate> getCertifiedCandidates(String type) {
        return new CertifiedCandidates(this, type);
    }
}
