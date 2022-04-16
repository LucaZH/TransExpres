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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author luca
 */
@Named(value = "voiture")
@RequestScoped
public class Voiture extends Database implements Serializable {

    /**
     * Creates a new instance of Voiture
     */
    public Voiture() {
    }
    private int id;
    private String num_voiture;
    private String Type;
    private int nbplace;
    private String itinearaire1;
    private String heure_dep1;
    private String itinearaire2;
    private String heure_dep2;
    private int id_chauff;
    private String active;
    private Part image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum_voiture() {
        return num_voiture;
    }

    public void setNum_voiture(String num_voiture) {
        this.num_voiture = num_voiture;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

    public String getItinearaire1() {
        return itinearaire1;
    }

    public void setItinearaire1(String itinearaire1) {
        this.itinearaire1 = itinearaire1;
    }

    public String getHeure_dep1() {
        return heure_dep1;
    }

    public void setHeure_dep1(String heure_dep1) {
        this.heure_dep1 = heure_dep1;
    }

    public String getItinearaire2() {
        return itinearaire2;
    }

    public void setItinearaire2(String itinearaire2) {
        this.itinearaire2 = itinearaire2;
    }

    public String getHeure_dep2() {
        return heure_dep2;
    }

    public void setHeure_dep2(String heure_dep2) {
        this.heure_dep2 = heure_dep2;
    }

    public int getId_chauff() {
        return id_chauff;
    }

    public void setId_chauff(int id_chauff) {
        this.id_chauff = id_chauff;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public void addvoiture() {
        Database connex = new Database();
        try {
            InputStream imageconv = image.getInputStream();
            Connection con = connex.Connect();
            PreparedStatement pst;
            pst = con.prepareStatement("INSERT INTO automobile  VALUES (NULL,?,?,?,?,?,?,?,?,?)");
//            pst.setInt(1, );
            pst.setString(1, num_voiture);
            pst.setString(2, Type);
            pst.setInt(3, nbplace);
            pst.setString(4, itinearaire1);
            pst.setString(5, heure_dep1);
            pst.setString(6, itinearaire2);
            pst.setString(7, heure_dep2);
            pst.setInt(8, id_chauff);
            pst.setBinaryStream(9, imageconv);

            pst.executeUpdate();
            System.out.println("Voiture ajouter");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delvoiture(int id) {
        Database connex = new Database();
        try {
            Connection con = connex.Connect();
            PreparedStatement pst;
            pst = con.prepareStatement("DELETE FROM automobile WHERE id = " + id);
            pst.executeUpdate();
            System.out.println("Voiture supprimer");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void modifvoiture(int id_) {

        Database connex = new Database();
        try {
            InputStream imageconv = image.getInputStream();
            Connection con = connex.Connect();
            PreparedStatement pst;
            String querymodif = "UPDATE automobile SET num_voiture=?,type=?,nombre_de_place=?,itineraire_1=?,heure_de_depart_1=?,itineraire_2=?,heure_de_depart_2=?,id_chauffeur=?,image_auto=? where id = " + id_;
            System.out.println(querymodif);
            pst = con.prepareStatement(querymodif);
            pst.setString(1, num_voiture);
            pst.setString(2, Type);
            pst.setInt(3, nbplace);
            pst.setString(4, itinearaire1);
            pst.setString(5, heure_dep1);
            pst.setString(6, itinearaire2);
            pst.setString(7, heure_dep2);
            pst.setInt(8, id_chauff);
            pst.setBinaryStream(9, imageconv);
//            pst.setInt(10, id);
            pst.executeUpdate();
            System.out.println("Voiture modifier");

        } catch (Exception e) {
            System.out.println("-----------------------ERROR ----------------------------");
            System.out.println(e);
        }
    }

    public void getimageVoiture(int id) {
        Database db = new Database();
        Connection con = db.Connect();
        Statement stmt = null;
        ResultSet rs;
        InputStream sImage;
        try {

            stmt = con.createStatement();
            String strSql = "select image_auto from automobile where id =" + id;
            rs = stmt.executeQuery(strSql);
            while (rs.next()) {
                sImage = rs.getBinaryStream("image_auto");

            }

        } catch (Exception e) {
            System.out.println("----------------Error--------");
        }

    }

}
