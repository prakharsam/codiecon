package com.coviam.codiecon.email;

public class InterviewerTiming {

    private String RedirectLink;

    public InterviewerTiming() {
    }

    public InterviewerTiming(String redirectLink) {
        RedirectLink = redirectLink;
    }

    public String getRedirectLink() {
        return RedirectLink;
    }

    public void setRedirectLink(String redirectLink) {
        RedirectLink = redirectLink;
    }
}
