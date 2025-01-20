public class Team {

    protected String nome;

    // Costruttore
    public Team(String nome) {
        this.nome = nome;
    }

    // Getter per il nome
    public String getNome() {
        return nome;
    }

    // Metodo per stampare informazioni base
    public void stampaDettagli() {
        System.out.println("Team: " + nome);
    }
}
