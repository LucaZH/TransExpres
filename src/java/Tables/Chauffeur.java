/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Tables;

import Database.Database;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author luca
 */
@Named(value = "chauffeur")
@RequestScoped
public class Chauffeur extends Database implements Serializable {

    /**
     * Creates a new instance of Chauffeur
     */
    public Chauffeur() {
    }

    private int id;
    private String nom;
    private String prenoms;
    private int age;
    private int CIN;
    private String adresse;
    private int experience;
    private int telephone;
    private int salaire;
    private Part image;

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

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCIN() {
        return CIN;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public void addchauffeur() {
        Database connex = new Database();
        try {
            InputStream imageconv = image.getInputStream();
            Connection con = connex.Connect();
            PreparedStatement pst;
            pst = con.prepareStatement("INSERT INTO chauffeur  VALUES (?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, nom);
            pst.setString(3, prenoms);
            pst.setInt(4, age);
            pst.setInt(5, CIN);
            pst.setString(6, adresse);
            pst.setInt(7, experience);
            pst.setInt(8, telephone);
            pst.setInt(9, salaire);
            pst.setBinaryStream(10, imageconv);

            pst.executeUpdate();
            System.out.println("voiture ajouter");

        } catch (Exception e) {
            System.out.println(e);
//            sy
        }
    }

    public void modifchauffeur(int id) {
        Database connex = new Database();
        try {
            InputStream imageconv = image.getInputStream();
            Connection con = connex.Connect();
            PreparedStatement pst;
            String querymodif = "UPDATE chauffeur  SET nom= ?,prenoms=? ,age= ?,cin_chauffeur=?,adresse=?, experience=?,telephone=?,salaire=?,image_chauffeur=? WHERE id_chauffeur= " + id;
            pst = con.prepareStatement(querymodif);
//            System.out.println(querymodif);
            pst.setString(1, nom);
            pst.setString(2, prenoms);
            pst.setInt(3, age);
            pst.setInt(4, CIN);
            pst.setString(5, adresse);
            pst.setInt(6, experience);
            pst.setInt(7, telephone);
            pst.setInt(8, salaire);
            pst.setBinaryStream(9, imageconv);

            pst.executeUpdate();
            System.out.println("chauffeur modifier");

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void delchauffeur(int id) {
        Database connex = new Database();
        try {
            Connection con = connex.Connect();
            PreparedStatement pst;
            pst = con.prepareStatement("DELETE FROM chauffeur WHERE id_chauffeur = " + id);
//            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("chuaffeur supprimer");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
