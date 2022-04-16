/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Tables;

import Database.Database;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.enterprise.context.RequestScoped;

/**
 *
 * @author luca
 */
@Named(value = "message")
@RequestScoped
public class Message extends Database implements Serializable {

    public Message() {
    }
    private int id;
    private String username;
    private String email;
    private String messages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public void envoyer()
    {
        Database connex = new Database();
        try {
            Connection con = connex.Connect();
            PreparedStatement pst;
            pst = con.prepareStatement("INSERT INTO messages  VALUES (NULL,?, ?, ?)");
            pst.setString(1, username);
            pst.setString(2, email);
            pst.setString(3, messages);
            
            pst.executeUpdate();
            System.out.println("Message envoyer");
            

        } catch (Exception e) {
            System.out.println(e);
//            sy
        }
    }
    }

