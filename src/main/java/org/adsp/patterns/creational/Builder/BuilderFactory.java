package org.adsp.patterns.creational.Builder;

public class BuilderFactory {
    public UIBuilder getUIBuilder(String str) {
        UIBuilder builder = null;
        if (str.equals("FrameUI.CANDIDATE_SRCH")) {
            builder = new CandidateSearchBuilder();
        } else if (str.equals("FrameUI.EMPLOYER_SRCH")) {
            builder = new EmpSearchBuilder();
        }
        return builder;
    }
}
