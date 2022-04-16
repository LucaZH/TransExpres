/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Tables;

import Database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author luca
 */
@Named(value = "commande")
@RequestScoped
public class Commande {

    /**
     * Creates a new instance of Commande
     */
    public Commande() {
    }
    private int id;
    private String nom;
    private String prenom;
    private int CIN;
    private int tel;
    private String email;
    private String adresse;
    private String date_co;
    private String heure_co;
    private String itineraire;
    private String num_voiture;
    private int nb_place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCIN() {
        return CIN;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDate_co() {
        return date_co;
    }

    public void setDate_co(String date_co) {
        this.date_co = date_co;
    }

    public String getHeure_co() {
        return heure_co;
    }

    public void setHeure_co(String heure_co) {
        this.heure_co = heure_co;
    }

    public String getItineraire() {
        return itineraire;
    }

    public void setItineraire(String itineraire) {
        this.itineraire = itineraire;
    }

    public String getNum_voiture() {
        return num_voiture;
    }

    public void setNum_voiture(String num_voiture) {
        this.num_voiture = num_voiture;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public void reserver() {
        Database connex = new Database();
        try {
            Connection con = connex.Connect();
            PreparedStatement pst;
            pst = con.prepareStatement("INSERT INTO commandes  VALUES (NULL,?, ?, ?,?, ?, ?,?, ?, ?,?, ?)");
            pst.setString(1, date_co);
            pst.setString(2, heure_co);
            pst.setString(3, itineraire);
            pst.setInt(4, CIN);
            pst.setInt(5, nb_place);
            pst.setString(6, num_voiture);
            pst.setString(7, nom);
            pst.setString(8, prenom);
            pst.setInt(9, tel);
            pst.setString(10, email);
            pst.setString(11, adresse);

            pst.executeUpdate();
            System.out.println("Message envoyer");

        } catch (Exception e) {
            System.out.println(e);
//            sy
        }
    }
}
