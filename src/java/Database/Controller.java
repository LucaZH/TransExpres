/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Database;

import Tables.Chauffeur;
import Tables.Commande;
import Tables.Message;
import Tables.Voiture;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author luca
 */
@Named(value = "controller")
@RequestScoped
public class Controller implements Serializable {

    /**
     * Creates a new instance of Controller
     */
    public Controller() {
    }

    Query query = new Query();
    private List<Message> ListMessage = new ArrayList<Message>();
    private List<Commande> ListCommande = new ArrayList<Commande>();
    private List<Voiture> ListVoiture = new ArrayList<Voiture>();
    private List<Chauffeur> ListChauffeur = new ArrayList<Chauffeur>();

    public List<Message> getListMessage() {
        ListMessage = query.getallmessage();
        return ListMessage;
    }

    public void setListMessage(List<Message> ListMessage) {
        this.ListMessage = ListMessage;
    }

    public List<Commande> getListCommande() {
        ListCommande = query.getallcommande();
        return ListCommande;
    }

    public void setListCommande(List<Commande> ListCommande) {
        this.ListCommande = ListCommande;
    }

    public List<Voiture> getListVoiture() {
        ListVoiture = query.getallvoiture();
        return ListVoiture;
    }

    public void setListVoiture(List<Voiture> ListVoiture) {
        this.ListVoiture = ListVoiture;
    }

    public List<Chauffeur> getListChauffeur() {
        ListChauffeur = query.getallchauffeur();
        return ListChauffeur;
    }

    public void setListChauffeur(List<Chauffeur> ListChauffeur) {
        this.ListChauffeur = ListChauffeur;
    }

}
