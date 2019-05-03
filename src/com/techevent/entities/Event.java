/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techevent.entities;




/**
 *
 * @author Ahmed Abdessamed
 */
public class Event {
    int id;
    int user_id;
    String titre ; 
    String description ;
    String affiche;
    String nbrplaces ;
    String localisation;
    String dateevent ;
    String hdebut;
    String hfin ;
     int  prix ;
     String categorie;
     String type ;

    public Event(int id, String titre, String description, String nbrplaces) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.nbrplaces = nbrplaces;
    }

     
     
     
     
    public Event(int id, int user_id, String titre, String description) {
        this.id = id;
        this.user_id = user_id;
        this.titre = titre;
        this.description = description;
    }

    public Event(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public Event(int id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }
    

    
    
    
    
    public Event(int user_id, String titre, String description, String affiche, String nbrplaces, String localisation, String dateevent, String hdebut, String hfin, int prix, String categorie, String type) {
        this.user_id = user_id;
        this.titre = titre;
        this.description = description;
        this.affiche = affiche;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.dateevent = dateevent;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.prix = prix;
        this.categorie = categorie;
        this.type = type;
    }
  

     
     
     
     
     
    public Event(int id, int user_id, String titre, String description, String affiche, String nbrplaces, String localisation, String dateevent, String hdebut, String hfin, int prix, String categorie, String type) {
        this.id = id;
        this.user_id = user_id;
        this.titre = titre;
        this.description = description;
        this.affiche = affiche;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.dateevent = dateevent;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.prix = prix;
        this.categorie = categorie;
        this.type = type;
    }

    public Event(int id, String titre, String description, String nbrplaces, String localisation, String dateevent, String hdebut, String hfin, int prix, String categorie, String type) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.dateevent = dateevent;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.prix = prix;
        this.categorie = categorie;
        this.type = type;
    }

    
    
    
    
    
    public Event(int id, int user_id, String titre, String description, String nbrplaces, String localisation, String dateevent, String hdebut, String hfin, int prix, String categorie, String type) {
        this.id = id;
        this.user_id = user_id;
        this.titre = titre;
        this.description = description;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.dateevent = dateevent;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.prix = prix;
        this.categorie = categorie;
        this.type = type;
    }

    public Event(String titre, String description, String nbrplaces, String localisation, String dateevent, String hdebut, String hfin, int prix, String categorie, String type) {
        this.titre = titre;
        this.description = description;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.dateevent = dateevent;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.prix = prix;
        this.categorie = categorie;
        this.type = type;
    }

    public Event(String titre, String description, String affiche, String nbrplaces, String localisation, String dateevent, String hdebut, String hfin, int prix, String categorie, String type) {
        this.titre = titre;
        this.description = description;
        this.affiche = affiche;
        this.nbrplaces = nbrplaces;
        this.localisation = localisation;
        this.dateevent = dateevent;
        this.hdebut = hdebut;
        this.hfin = hfin;
        this.prix = prix;
        this.categorie = categorie;
        this.type = type;
    }

    public Event() {
    }

   
   
     
    
    
     
     
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public String getNbrplaces() {
        return nbrplaces;
    }

    public void setNbrplaces(String nbrplaces) {
        this.nbrplaces = nbrplaces;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDateevent() {
        return dateevent;
    }

    public void setDateevent(String dateevent) {
        this.dateevent = dateevent;
    }

    public String getHdebut() {
        return hdebut;
    }

    public void setHdebut(String hdebut) {
        this.hdebut = hdebut;
    }

    public String getHfin() {
        return hfin;
    }

    public void setHfin(String hfin) {
        this.hfin = hfin;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", user_id=" + user_id + ", titre=" + titre + ", description=" + description + ", affiche=" + affiche + ", nbrplaces=" + nbrplaces + ", localisation=" + localisation + ", dateevent=" + dateevent + ", hdebut=" + hdebut + ", hfin=" + hfin + ", prix=" + prix + ", categorie=" + categorie + ", type=" + type + '}';
    }
     
     
     
     
     
     
     
     
     
}