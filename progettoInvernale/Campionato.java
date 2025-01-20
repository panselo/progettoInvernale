import java.util.ArrayList;

public class Campionato {

    private ArrayList<Squadra> squadre;
    private int indice;

    // Costruttore
    public Campionato() {
        squadre = new ArrayList<Squadra>();
        indice = 0;
    }

    // Metodo per aggiungere una squadra
    public void aggiungiSquadra(Squadra squadra) {
        if (squadre.size() < 10) {
            squadre.add(squadra);
        } else {
            System.out.println("Impossibile aggiungere altre squadre.");
        }
    }

    // Metodo per ottenere una squadra tramite indice
    public Squadra getSquadra(int index) {
        return squadre.get(index);
    }

    // Metodo per stampare la classifica
    public void stampaClassifica() {
        squadre.sort(Squadra::compareTo);
        // In questo modo ho ordinato le squadre in base ai punti
        System.out.println("Classifica del campionato:");
        for (Squadra sq : squadre) {
            System.out.println(sq);
        }
    }

    public void eliminaSquadra(int indice){
        squadre.remove(indice);
    }

    public void modificaPartita(int indice, int set, String nome){
        int partiteVinte = squadre.get(indice).getPartiteVinte();
        int partitePerse = squadre.get(indice).getPartitePerse();
        int punti = squadre.get(indice).getPunti();
        squadre.set(indice, new Squadra(nome, set, partiteVinte, partitePerse, punti));
    }
}
