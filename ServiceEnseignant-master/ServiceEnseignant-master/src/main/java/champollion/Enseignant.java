package champollion;

import java.util.*;

public class Enseignant extends Personne {

    private ArrayList<UE> enseignement;
    private ArrayList<Intervention> interventionsplanifiées;
    private ArrayList<ServicePrevu> servicePrevu = new ArrayList<>();

    public Enseignant(String nom, String email) {
        super(nom, email);
        this.enseignement = new ArrayList<UE>();
        this.interventionsplanifiées = new ArrayList<Intervention>();
        this.servicePrevu = new ArrayList<ServicePrevu>();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        float lesheuresTD = 0;
        for(ServicePrevu service : servicePrevu){
            lesheuresTD += (service.getVolumeCM() * 1.5);
            lesheuresTD += (service.getVolumeTD() * 1);
            lesheuresTD += (service.getVolumeTP() * 0.75);
        }
    return Math.round(lesheuresTD);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        float lesheuresUE = 0;
        for(ServicePrevu service : servicePrevu){
            if (service.getUe().equals(ue)) {
                lesheuresUE += (service.getVolumeCM() * 1.5);
                lesheuresUE += (service.getVolumeTD() * 1);
                lesheuresUE += (service.getVolumeTP() * 0.75);
            }
        }
        return Math.round(lesheuresUE);
    }
    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu servicep = new ServicePrevu(volumeCM, volumeTD, volumeTP);
            servicePrevu.add(servicep);
    }
    
    public void ajouteIntervention(Intervention i){
        Intervention intervention = new Intervention(i.getDebut(), i.getDuree(),i.getHeureDebut(), i.getMatiere(), i.getType());
            interventionsplanifiées.add(intervention);
    }

    public boolean enSousService(){
        if (heuresPrevues() < 192) {
            return true;
        }
        else{
            return false;
        }
    }
    
    public int resteAPlanifier(UE ue, TypeIntervention type){
        ServicePrevu sp = ue.getService(this);
        int nbHeurePlanif = 0;
        for(int i = 0; i < this.interventionsplanifiées.size(); i++){
            if(this.interventionsplanifiées.get(i).getType() == type){
                nbHeurePlanif += this.interventionsplanifiées.get(i).getDuree();
            }
        }

        return (sp.getVolumeCM() - nbHeurePlanif);
    }
}
