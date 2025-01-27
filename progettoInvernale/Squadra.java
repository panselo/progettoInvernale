import java.util.concurrent.ExecutionException;

public class Squadra extends Team {

    private int setVinti;
    private int partiteVinte;
    private int partitePerse;
    private int punti;

    // Costruttore
    public Squadra(String nome) {
        super(nome);
        this.setVinti = 0;
        this.partiteVinte = 0;
        this.partitePerse = 0;
        this.punti = 0;
    }
    public Squadra(String nome, int setVinti, int partiteVinte, int partitePerse, int punti) throws Exception {
        super(nome);
        try{
            setSetVinti(setVinti);
            setPartiteVinte(partiteVinte);
            setPartitePerse(partitePerse);
            setPunti(punti);
        }catch(Exception e){
            System.err.println("Errore!!");
        }

    }

    // Metodo per registrare i risultati della partita
    public void registraPartita(int setVinti, boolean vittoria) {
        this.setVinti += setVinti;
        if (vittoria) {
            this.partiteVinte++;
            this.punti += 3;
        } else {
            this.partitePerse++;
            this.punti = 0;
        }
    }




    public String toString() {
        return "Squadra: " + nome + ", Set vinti: " + setVinti + ", Partite vinte: " + partiteVinte + ", Partite perse: " + partitePerse + ", Punti: " + punti;
    }

    public int getPunti() {
        return punti;
    }

    public int compareTo(Object o) {
        if (o instanceof Squadra) {
            Squadra sq = (Squadra) o;
            if(sq.getPunti()>this.getPunti()) {
                return 1;
            } else if (sq.getPunti()<this.getPunti()) {
                return -1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public int getPartiteVinte() {
        return partiteVinte;
    }

    public int getPartitePerse() {
        return partitePerse;
    }

    public void setPunti(int punti) throws Exception {
        if (punti < 0){
            throw new Exception("Operazione non consentita");
        }
        this.punti = punti;
    }

    public void setSetVinti(int setVinti) throws Exception{
        if (setVinti < 0){
            throw new Exception("Operazione non consentita");
        }
        this.setVinti = setVinti;
    }

    public void setPartiteVinte(int partiteVinte) throws Exception {
        if (partiteVinte < 0){
            throw new Exception("Operazione non consentita");
        }
        this.partiteVinte = partiteVinte;
    }

    public void setPartitePerse(int partitePerse) throws Exception{
        if (partitePerse < 0){
            throw new Exception("Operazione non consetita");
        }
        this.partitePerse = partitePerse;
    }
}
