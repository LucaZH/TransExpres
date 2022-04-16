/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Tables.Chauffeur;
import Tables.Commande;
import Tables.Message;
import Tables.Voiture;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luca
 */
public class Query extends Database implements Serializable {

    public List<Message> getallmessage() {
        List<Message> Listemessage = new ArrayList<Message>();
        try {
            ps = Connect().prepareStatement("select * from messages");
            ResultSet rs = ps.executeQuery();
            Message mess;
           
            while (rs.next()) {
                mess = new Message();
                mess.setId(rs.getInt("id"));
                mess.setUsername(rs.getString("username"));
                mess.setEmail(rs.getString("email"));
                mess.setMessages(rs.getString("message"));
                Listemessage.add(mess);
                System.out.println("Parcourue");
            }
            return Listemessage;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Commande> getallcommande() {
        List<Commande> Listecommande = new ArrayList<Commande>();
        try {
            ps = Connect().prepareStatement("select * from commandes");
            ResultSet rs = ps.executeQuery();
            Commande co;
            while (rs.next()) {
                co = new Commande();
                co.setId(rs.getInt("id_co"));
                co.setNom(rs.getString("nom_client"));
                co.setPrenom(rs.getString("prenom_client"));
                co.setTel(rs.getInt("tel"));
                co.setAdresse(rs.getString("adresse"));
                co.setEmail(rs.getString("email"));
                co.setCIN(rs.getInt("cin_client"));
                co.setDate_co(rs.getString("date_co"));
                co.setHeure_co(rs.getString("heure_co"));
                co.setItineraire(rs.getString("itineraire"));
                co.setNb_place(rs.getInt("nbplace"));
                co.setNum_voiture(rs.getString("num_voiture"));
                Listecommande.add(co);
                
            }
            System.out.println("Parcourue commande");
            return Listecommande;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Voiture> getallvoiture() {
        List<Voiture> Listevoiture = new ArrayList<Voiture>();
        try {
            ps = Connect().prepareStatement("select * from automobile");
            ResultSet rs = ps.executeQuery();
            Voiture voit;
//            InputStream imageconv = voit.image.getInputStream();
            while (rs.next()) {
                voit = new Voiture();
                voit.setId(rs.getInt("id"));
                voit.setNum_voiture(rs.getString("num_voiture"));
                voit.setType(rs.getString("type"));
                voit.setNbplace(rs.getInt("nombre_de_place"));
                voit.setItinearaire1(rs.getString("itineraire_1"));
                voit.setHeure_dep1(rs.getString("heure_de_depart_1"));
                voit.setItinearaire2(rs.getString("itineraire_2"));
                voit.setHeure_dep2(rs.getString("heure_de_depart_2"));
                voit.setId_chauff(rs.getInt("id_chauffeur"));
//                voit.setImage(rs.getBinaryStream());
                Listevoiture.add(voit);
                
            }
            System.out.println("Parcourue voiture");
            return Listevoiture;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Chauffeur> getallchauffeur() {
        List<Chauffeur> Listechauffeur = new ArrayList<Chauffeur>();
        try {
            ps = Connect().prepareStatement("select * from chauffeur");
            ResultSet rs = ps.executeQuery();
            Chauffeur chauff;
//            InputStream imageconv = voit.image.getInputStream();
            while (rs.next()) {
                chauff = new Chauffeur();
                chauff.setId(rs.getInt("id_chauffeur"));
                chauff.setNom(rs.getString("nom"));
                chauff.setPrenoms(rs.getString("prenoms"));
                chauff.setAge(rs.getInt("age"));
                chauff.setCIN(rs.getInt("cin_chauffeur"));
                chauff.setAdresse(rs.getString("adresse"));
                chauff.setExperience(rs.getInt("experience"));
                chauff.setTelephone(rs.getInt("telephone"));
                chauff.setSalaire(rs.getInt("salaire"));
//                voit.setImage(rs.getBinaryStream("image_chauffeur"));
                Listechauffeur.add(chauff);
                
            }
            System.out.println("Parcourue chauffeur");
            return Listechauffeur;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
