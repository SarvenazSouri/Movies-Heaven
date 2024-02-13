/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clients;

import java.util.Objects;

/**
 *
 * @author isi
 */
public class Clients {
    private String id;
    private String nom;
    private String prenom;
    private String courriel;
    private String tel;
    private String anniversaire;
    private String adresse;
    private String ville;
    private String province;
    private String code_postal;
    private String carte;
    private String no_carte;
    private String exp_mois;
    private String exp_annee;
    private String password;
    private String forfait;
    
    public Clients(){}

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the courriel
     */
    public String getCourriel() {
        return courriel;
    }

    /**
     * @param courriel the courriel to set
     */
    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the anniversaire
     */
    public String getAnniversaire() {
        return anniversaire;
    }

    /**
     * @param anniversaire the anniversaire to set
     */
    public void setAnniversaire(String anniversaire) {
        this.anniversaire = anniversaire;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the code_postal
     */
    public String getCode_postal() {
        return code_postal;
    }

    /**
     * @param code_postal the code_postal to set
     */
    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    /**
     * @return the carte
     */
    public String getCarte() {
        return carte;
    }

    /**
     * @param carte the carte to set
     */
    public void setCarte(String carte) {
        this.carte = carte;
    }

    /**
     * @return the no_carte
     */
    public String getNo_carte() {
        return no_carte;
    }

    /**
     * @param no_carte the no_carte to set
     */
    public void setNo_carte(String no_carte) {
        this.no_carte = no_carte;
    }

    /**
     * @return the exp_mois
     */
    public String getExp_mois() {
        return exp_mois;
    }

    /**
     * @param exp_mois the exp_mois to set
     */
    public void setExp_mois(String exp_mois) {
        this.exp_mois = exp_mois;
    }

    /**
     * @return the exp_annee
     */
    public String getExp_annee() {
        return exp_annee;
    }

    /**
     * @param exp_annee the exp_annee to set
     */
    public void setExp_annee(String exp_annee) {
        this.exp_annee = exp_annee;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the forfait
     */
    public String getForfait() {
        return forfait;
    }

    /**
     * @param forfait the forfait to set
     */
    public void setForfait(String forfait) {
        this.forfait = forfait;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clients other = (Clients) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.courriel, other.courriel)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.anniversaire, other.anniversaire)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }
        if (!Objects.equals(this.province, other.province)) {
            return false;
        }
        if (!Objects.equals(this.code_postal, other.code_postal)) {
            return false;
        }
        if (!Objects.equals(this.carte, other.carte)) {
            return false;
        }
        if (!Objects.equals(this.no_carte, other.no_carte)) {
            return false;
        }
        if (!Objects.equals(this.exp_mois, other.exp_mois)) {
            return false;
        }
        if (!Objects.equals(this.exp_annee, other.exp_annee)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.forfait, other.forfait);
    }
    
    
    
}
