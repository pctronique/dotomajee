/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.pctronique.project.config;

import fr.pctronique.conf.ConfigEmail;
import java.util.Date;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author pctronique
 */
public class MessageEmail {

    private Session session;
    private String msgFrom;
    private String msgto;
    private String msgObj;
    private String msgTxt;

    public MessageEmail() {
        FileConfig fileConfig = new FileConfig();
        ConfigEmail configEmail = new ConfigEmail(fileConfig.getFile());
        this.session = Session.getInstance(configEmail.getProp());
    }

    public MessageEmail getFrom(String from) {
        this.msgFrom = from;
        return this;
    }

    public MessageEmail getTo(String to) {
        this.msgto = to;
        return this;
    }

    public MessageEmail getObj(String obj) {
        this.msgObj = obj;
        return this;
    }

    public MessageEmail getTxt(String txt) {
        this.msgTxt = txt;
        return this;
    }

    public MessageEmail getSend() throws Exception {
        return this.getSend(false);
    }

    public MessageEmail getSend(boolean debug) throws Exception {
        MimeMessage message = new MimeMessage(this.session);
        message.setFrom(new InternetAddress(this.msgFrom));
        InternetAddress[] internetAddresses = new InternetAddress[1];
        internetAddresses[0] = new InternetAddress(this.msgto);
        message.setRecipients(Message.RecipientType.TO, internetAddresses);
        message.setSubject(this.msgObj);
        message.setText(this.msgTxt);
        message.setHeader("X-Mailer", "Java");
        message.setSentDate(new Date());
        this.session.setDebug(debug);
        Transport.send(message);
        return this;
    }

}
