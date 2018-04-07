/**
 * @author Bob Stofko
 * @version $1.0$
 */

package com.heb.assignment1.model;

public class Email {
    private String recipient;
    private String sender;
    private String subject;
    private String emailMessage;
    private String smtpHost;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    @Override
    public String toString() {
        return "Email{" +
                "recipient='" + recipient + '\'' +
                ", sender='" + sender + '\'' +
                ", subject='" + subject + '\'' +
                ", emailMessage='" + emailMessage + '\'' +
                ", smtpHost='" + smtpHost + '\'' +
                '}';
    }
}
