/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author thepoet
 */
public class club {
    
    private int id_club;
    private String nomClub,descClub;
    
    public club() {
    }

    public club(int id_club, String nomClub, String descClub) {
        this.id_club = id_club;
        this.nomClub = nomClub;
        this.descClub = descClub;
    }
    
     public club(String nomClub, String descClub) {
        this.nomClub = nomClub;
        this.descClub = descClub;
    }

    public int getId_club() {
        return id_club;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public String getDescClub() {
        return descClub;
    }

    public void setDescClub(String descClub) {
        this.descClub = descClub;
    }

    @Override
    public String toString() {
         return "Club{" + "id=" + id_club + ", nom=" + nomClub + ", etat=" + descClub + '}'; 
    }
     
    
    
}
