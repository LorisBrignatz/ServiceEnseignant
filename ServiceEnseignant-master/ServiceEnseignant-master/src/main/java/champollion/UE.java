package champollion;
import java.util.*;

public class UE {
    private final String myIntitule;
    private int heuresCM;
    private int heuresTD;
    private int heuresTP;
    private HashMap<Enseignant, ServicePrevu> intervenant;
    private List<Intervention> seancesplanifiees = new ArrayList<>();

    public UE(String intitule, int heureCM, int heureTD, int heureTP) {
        myIntitule = intitule;
        this.heuresCM = heureCM;
        this.heuresTD = heureTD;
        this.heuresTP = heureTP;
        this.intervenant = new HashMap<Enseignant, ServicePrevu>();
        this.seancesplanifiees = new ArrayList<Intervention>();
    }

    public String getIntitule() {
        return myIntitule;
    }

    public int getHeuresCM(){
        return this.heuresCM;
    }

    public int getHeuresTD(){
        return this.heuresTD;
    }

    public int getHeuresTP(){
        return this.heuresTP;
    }
    
    public ServicePrevu getService(Enseignant e){
        return this.intervenant.get(e);
    }

    public void setHeuresCM(int heuresCM) {
        this.heuresCM = heuresCM;
    }

    public void setHeuresTD(int heuresTD) {
        this.heuresTD = heuresTD;
    }

    public void setHeuresTP(int heuresTP) {
        this.heuresTP = heuresTP;
    }

    public void addIntervenant(Enseignant enseignant, ServicePrevu sp){
        intervenant.put(enseignant, sp);
    }

    public void addSeance(Intervention intervention){
        this.seancesplanifiees.add(intervention);
    }
}