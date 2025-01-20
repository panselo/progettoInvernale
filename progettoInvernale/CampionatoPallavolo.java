import java.util.Scanner;

public class CampionatoPallavolo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Campionato campionato = new Campionato();

        System.out.println("Benvenuto nel Campionato di Pallavolo Bergamasco!");

        int scelta = -1;
        while (scelta != 4) {

            System.out.println("\nScegli un'opzione:");
            System.out.println("1. Aggiungi una squadra");
            System.out.println("2. Registra risultati di una partita");
            System.out.println("3. Visualizza la classifica");
            System.out.println("4. Esci");
            System.out.println("5. Elimina squadra");
            System.out.println("6. Modfica dati di un squadra");
            System.out.print("Inserisci la tua scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    // Aggiunta squadra
                    System.out.print("Nome della squadra: ");
                    String nomeSquadra = scanner.nextLine();
                    campionato.aggiungiSquadra(new Squadra(nomeSquadra));
                    System.out.println("Squadra " + nomeSquadra + " aggiunta.");
                    break;

                case 2:
                    // Registrazione risultati
                    System.out.print("Nome della squadra: ");
                    String nome = scanner.nextLine();
                    Squadra squadra = trovaSquadra(campionato, nome);

                    if (squadra != null) {
                        System.out.print("Set vinti: ");
                        int setVinti = scanner.nextInt();
                        System.out.print("Vittoria (1 per sì, 0 per no): ");
                        int vittoria = scanner.nextInt();
                        scanner.nextLine();

                        squadra.registraPartita(setVinti, vittoria == 1);
                        System.out.println("Risultati aggiornati.");
                    } else {
                        System.out.println("Squadra non trovata.");
                    }
                    break;

                case 3:
                    // Visualizza classifica
                    campionato.stampaClassifica();
                    break;

                case 4:
                    System.out.println("Grazie per aver visionato il campionato!");
                    break;

                case 5:
                    System.out.println("Che squadra vuoi eliminare (indice)?");
                    int index = scanner.nextInt();
                    campionato.eliminaSquadra(index);
                    break;

                case 6:
                    System.out.println("Che squadra vuoi modificare (indice)?");
                    int indice = scanner.nextInt();
                    System.out.println("Inserisci il nuovo nome");
                    String nome2 = scanner.next();
                    System.out.println("Inserisci i nuovi set");
                    int set = scanner.nextInt();
                    campionato.modificaPartita(indice, set, nome2);
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        }

    }

    // Metodo per trovare una squadra
    public static Squadra trovaSquadra(Campionato campionato, String nome) {
        for (int i = 0; i < 10; i++) {
            Squadra squadra = campionato.getSquadra(i);
            if (squadra != null && squadra.getNome().equalsIgnoreCase(nome)) {
                return squadra;
            }
        }
        return null;
    }
}

