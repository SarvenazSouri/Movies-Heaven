/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package films;

/**
 *
 * @author isi
 */
public class Films {
    private String id;
    private String titre;
    private String annee;
    private String pays;
    private String langue;
    private int duree;
    private String resume;
    private String genre;               
    private String realisateur;         
    private String scenariste;          
    private String acteur;              
    private String poster;  
    private String annonce;
    
    public Films(){}

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
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the annee
     */
    public String getAnnee() {
        return annee;
    }

    /**
     * @param annee the annee to set
     */
    public void setAnnee(String annee) {
        this.annee = annee;
    }

    /**
     * @return the pays
     */
    public String getPays() {
        return pays;
    }

    /**
     * @param pays the pays to set
     */
    public void setPays(String pays) {
        this.pays = pays;
    }

    /**
     * @return the langue
     */
    public String getLangue() {
        return langue;
    }

    /**
     * @param langue the langue to set
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }

    /**
     * @return the duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * @return the resume
     */
    public String getResume() {
        return resume;
    }

    /**
     * @param resume the resume to set
     */
    public void setResume(String resume) {
        this.resume = resume;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the realisateur
     */
    public String getRealisateur() {
        return realisateur;
    }

    /**
     * @param realisateur the realisateur to set
     */
    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    /**
     * @return the scenariste
     */
    public String getScenariste() {
        return scenariste;
    }

    /**
     * @param scenariste the scenariste to set
     */
    public void setScenariste(String scenariste) {
        this.scenariste = scenariste;
    }

    /**
     * @return the acteur
     */
    public String getActeur() {
        return acteur;
    }

    /**
     * @param acteur the acteur to set
     */
    public void setActeur(String acteur) {
        this.acteur = acteur;
    }

    /**
     * @return the poster
     */
    public String getPoster() {
        return poster;
    }

    /**
     * @param poster the poster to set
     */
    public void setPoster(String poster) {
        this.poster = poster;
    }

    /**
     * @return the annonce
     */
    public String getAnnonce() {
        return annonce;
    }

    /**
     * @param annonce the annonce to set
     */
    public void setAnnonce(String annonce) {
        this.annonce = annonce;
    }
    
    @Override    
    public String toString() {         
        return String.format("'%s', '%s', '%s', '%s', '%s', %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s'",                 
                id, titre, annee, pays, langue, duree, resume, genre, realisateur, scenariste, acteur, poster, annonce);     
    }
}
