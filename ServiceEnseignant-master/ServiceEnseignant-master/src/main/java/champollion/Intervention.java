package champollion;

import java.util.Date;

public class Intervention {
    private Date debut;
    private int duree;
    private boolean annulee = false;
    private int heureDebut;
    private UE matiere;
    private TypeIntervention type;
    
    public Intervention(Date debut, int duree, int heureDebut, UE matiere, TypeIntervention type){
        this.debut = debut;
        this.duree = duree;
        this.heureDebut = heureDebut;
        this.matiere = matiere;
        this.type = type;
    }
    
    public Date getDebut() {
        return this.debut;
    }

    public int getDuree() {
        return this.duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public int getHeureDebut() {
        return this.heureDebut;
    }

    public UE getMatiere() {
        return this.matiere;
    }
    
    public TypeIntervention getType() {
        return this.type;
    }

}
