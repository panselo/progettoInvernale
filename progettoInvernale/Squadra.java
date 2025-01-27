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
        setSetVinti(setVinti);
        setPartiteVinte(partiteVinte);
        setPartitePerse(partitePerse);
        setPunti(punti);
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

    public int getSetVinti() {
        return setVinti;
    }

    public int getPartiteVinte() {
        return partiteVinte;
    }

    public int getPartitePerse() {
        return partitePerse;
    }

    public void setPunti(int punti) throws Exception {
        this.punti = punti;
        throw new Exception("Operazione non consentita");
    }

    public void setSetVinti(int setVinti) throws Exception{
        this.setVinti = setVinti;
        throw new Exception("Operazione non consentita");
    }

    public void setPartiteVinte(int partiteVinte) throws Exception {
        this.partiteVinte = partiteVinte;
        throw new Exception("Operazione non consentita");
    }

    public void setPartitePerse(int partitePerse) throws Exception{
        this.partitePerse = partitePerse;
        throw new Exception("Operazione non consetita");
    }
}
