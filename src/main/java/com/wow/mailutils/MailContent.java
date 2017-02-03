package com.wow.mailutils;

import java.util.List;

/**
 * Created by kisrosen on 17/1/11.
 */
public class MailContent {
    /**
     * Mail Title
     */
    private String title;

    /**
     * Mail Destination List
     */
    private List<String> toNames;

    /**
     * Mail Copyto List
     */
    private List<String> ccNames;

    /**
     * Who send the mail
     */
    private String mailFrom;

    /**
     * Mail Body Content
     */
    private String mailBody;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getToNames() {
        return toNames;
    }

    public void setToNames(List<String> toNames) {
        this.toNames = toNames;
    }

    public List<String> getCcNames() {
        return ccNames;
    }

    public void setCcNames(List<String> ccNames) {
        this.ccNames = ccNames;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public String getToNamesString()
    {
        StringBuilder toNameString = new StringBuilder();

        for (String toName : this.toNames)
        {
            toNameString.append(toName);
            toNameString.append(",");
        }

        return toNameString.toString();
    }
}
