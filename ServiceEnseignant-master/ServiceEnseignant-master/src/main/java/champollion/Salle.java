package champollion;

import java.util.HashSet;
import java.util.Set;

public class Salle {

    private final int capacite;
    private final String intitule;

    private Set<Intervention> occ = new HashSet<>();

    public Salle(int capacite, String intitule) {
        this.capacite = capacite;
        this.intitule = intitule;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getIntitule() {
        return intitule;
    }

    public void addOccupation(Intervention intervention){
        occ.add(intervention);
    }
}