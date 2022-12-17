import java.util.Scanner;
import java.util.Random;

public class Game {
    public Hero[] heroes;
    private int nbHero;
    private Enemy[] ennemi;
    private int tourJoueur;
    private int tourEnnemi;
    private int turn;
    private int nbEnnemi;

    public void setHero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est le nombre de héro ?");
        nbHero = scanner.nextInt();
        this.heroes = new Hero[nbHero];
        for (int i = 1; i<= nbHero; i++){
            System.out.println("\nQuel type d'héro n° " + i + "\n ?"
                    + "1. Warrior\n"
                    + "2. Hunter\n"
                    + "3. Mage\n"
                    + "4. Healer\n");
            int classe = scanner.nextInt();
            if (classe == 1){
                heroes[i-1] = new Warrior(10, 5, 5);
                System.out.println("Warrior créé\n");
            }
            if (classe == 2) {
                heroes[i-1] = new Hunter(7, 3, 10, 50);
                System.out.println("Hunter créé\n");
            }
            if (classe == 3) {
                heroes[i-1] = new MAGE(5, 2, 15, 75);
                System.out.println("Mage créé\n");
            }
            if (classe == 4) {
                heroes[i-1] = new Healer(6, 1, 5, 100);
                System.out.println("Healer créé\n");
            }
        }
    }

    public void play() {
        System.out.println("--- Bienvenu dans ce jeu ! ---");
        setHero();
        System.out.println("L'aventure va débuter dans le dongon de Verael \n"
        + "ce dongon est l'ancienne tour d'un mage du chaos");
        fightgenerator();
        levelup();
        System.out.println("Bravo, vous voici au 2ème étage de la tour ! Cheer up !");
        fightgenerator();
        levelup();
        System.out.println("Bravo, vous voici au 3ème étage de la tour ! Cheer up !");
        fightgenerator();
        levelup();
        System.out.println("Bravo, vous voici au 4ème étage de la tour !Cheer up !");
        fightgenerator();
        levelup();
        System.out.println("Bravo, vous voici au 5ème étage de la tour ! Cheer up !");
        fightgenerator();
        levelup();
        System.out.println("Bravo, vous voici au 6ème étage de la tour ! Cheer up !");
        fightgenerator();
        levelup();
        System.out.println("Bravo, vous voici au 7ème étage de la tour ! Cheer up !");
        fightgenerator();
        levelup();
        System.out.println("Bravo, vous voici au 8ème étage de la tour ! Cheer up !");
        fightgenerator();
        levelup();
        System.out.println("Bravo, vous voici au 9ème étage de la tour ! Cheer up !");
        fightgenerator();
        levelup();
        System.out.println("Bravo, vous voici au 10ème étage de la tour qui est le dernier \nil y a un boss ! Fighting (");
        Random rand = new Random();
        this.ennemi = new Enemy[0];
        ennemi[0]= new Boss(rand.nextInt(20 - 15 + 1) + 15, rand.nextInt(15 - 10 + 1) + 10, rand.nextInt(15 - 10 + 1) + 10);
        System.out.println("Vous avez fini le jeu, félicitations !");
        System.exit(0);
    }

    public void fightgenerator() {
        Random rand = new Random();
        nbEnnemi = rand.nextInt(3 - 2 + 1) + 2;
        this.ennemi = new Enemy[nbEnnemi];
        System.out.println(" Let's fight, un groupe de " + nbEnnemi + " ennemis sont en vue !");
        for (int i = 1; i<= nbEnnemi; i++){
            ennemi[i - 1] = new BasicEnemy(rand.nextInt(10 - 7 + 1) + 7, rand.nextInt(3 - 2 + 1) + 2, rand.nextInt(5 - 3 + 1) + 3);
            System.out.println("Ennemi n° " + i +" attaque " + ennemi[i - 1].getdommage() + ", défense "
             + ennemi[i- 1].getBouclier() + ", point de vie " + ennemi[i - 1].getPv());
        }
        fight();
    }

    public void fight() {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nle combat commence il a ");
        int combat = 1;
        this.tourJoueur = 0;
        this.tourEnnemi = 0;
        this.turn = 0;

        while(combat == 1){
            if(turn == 0){
                System.out.println("Héro n° " + (tourJoueur +1) +" attaque " + heroes[tourJoueur].getDommageCible() + ", défense "
             + heroes[tourJoueur].getArmure() + " , point de vie " + heroes[tourJoueur].getPV()
             + "\nQue voulez-vous faire ?"
             + "\n1: Attaquer ?"
             +"\n2: Défendre ?"
             +"\n3: Utiliser les objets ?");

                int action = scanner.nextInt();
                if (action == 1){
                    System.out.println("Le héro lance une attaque de " + heroes[tourJoueur].attack(heroes[tourJoueur].getDommageCible())
                    +" Quelle est la cible que vous souhaitez atteindre ?");
                    int cible = (scanner.nextInt() - 1);
                    int degats = heroes[tourJoueur].attack(heroes[tourJoueur].getDommageCible());
                    if (degats - ennemi[cible].getBouclier() > 0) {
                        ennemi[cible].setPv(ennemi[cible].getPv() - (degats - ennemi[cible].getBouclier()));
                        System.out.println("L'ennemi " + (cible + 1) + "a subit l'attaque");
                    }

                    else {
                        System.out.println("L'ennemi n°" + (cible + 1) + "a bloqué l'attaque");
                    }
                    ennemi[cible].setBouclier(ennemi[cible].getBouclier() - (degats / 3));
                }

                if(action == 2){
                    heroes[tourJoueur].defend();
                }

                else{
                    System.out.println("Ressources trouvées dans le sac :\n"
                    + "1. " + heroes[tourJoueur].foods[0]
                    + "\n2. " + heroes[tourJoueur].foods[1]
                    + "\3. " + heroes[tourJoueur].potions[0]
                    + "\4. " + heroes[tourJoueur].potions[1] + "\n");
                    int conso = scanner.nextInt();
                   heroes[tourJoueur].foods[0].useConsomable(tourJoueur, conso, heroes);
                }

                if(nbHero -1 == tourJoueur){
                    tourJoueur = 0;
                }

                else{
                    tourJoueur++;
                }

                turn = 1;
            }

            if(turn == 1){
                System.out.println("L'ennemi " + (tourEnnemi +1) + " attaque " + ennemi[tourEnnemi].getdommage() + ", défense "
                + ennemi[tourEnnemi].getBouclier() + ", point de vie " + ennemi[tourEnnemi].getPv() +" vous attaque !");
                int degats =  ennemi[tourEnnemi].attack(ennemi[tourEnnemi].getdommage());
                int cible = (rand.nextInt(nbHero - 1 + 1) + 1) -1;
                if (degats - heroes[cible].getArmure() > 0){
                    heroes[cible].setPV(heroes[cible].getPV() - (degats - heroes[cible].getArmure()));
                    System.out.println("Le héro " + (cible+1) + "a subit l'attaque");
                }
                else{
                    System.out.println("Le héros" + (cible + 1) + "a bloqué l'attaque");
                }
                heroes[cible].setArmure(heroes[cible].getArmure() - (degats / 3));
                if (nbEnnemi -1 == tourEnnemi) {
                    tourEnnemi = 0;
                } else {
                    tourEnnemi++;
                }
                turn =0;
            }
                combat = checklifepoint();
        }

        System.out.println("C'est la fin de ce combat");
    }

    public int checklifepoint(){
        int sommePVheros = 0;
        int sommePVennemi = 0;
        for (int i = 1; i <= nbEnnemi; i++) {
            if (ennemi[i - 1].getPv() <= 0){
                ennemi[i - 1].setBouclier(0);
                ennemi[i - 1].setPv(0);
                ennemi[i - 1].setdommage(0);
                System.out.println("L'ennemi " + i + "est mort");
            }
            sommePVennemi += ennemi[i - 1].getPv();
        }
        for (int i = 1; i<= nbHero; i++){
            if(heroes[i - 1].getPV() <= 0){
                heroes[i - 1].setArmure(0);
                heroes[i - 1].setPV(0);
                heroes[i - 1].setDegats(0);
                System.out.println("Le héro " + i + "est mort");
            }
            sommePVheros += heroes[i - 1].getPV();
        }
        if(sommePVennemi <=0){
            System.out.println("Le combat est terminé, vous avez gagné !");
            return 0;
        }
        if (sommePVheros <= 0) {
            System.out.println("Le combat est terminé mais vous n'avez pas gagné :( Prenez votre revanche, vous y arriverez !");
            System.exit(0);
        }
        return 1;
    }

    public void levelup(){
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i<= nbHero; i++){
            System.out.println("\nmontée de niveau du héro " + i + "\n"
                    + " attaque " + heroes[i-1].getDommageCible() + ", défense " + heroes[i-1].getArmure() + ", point de vie " + heroes[i-1].getPV()
                    + "\nQuel critère voulez-vous augmenter ?\n"
                    + "1 : La vie du héro\n"
                    + "2 : La défense du héro\n"
                    + "3 : L'attaque du héro \n");

            int choix = scanner.nextInt();
            if (choix == 1){
                heroes[i-1].setPV(heroes[i-1].getPV() + 5);
            }
            if (choix == 2){
                heroes[i-1].setArmure(heroes[i-1].getArmure() + 5);
            }
            if (choix == 3){
                heroes[i-1].setDegats(heroes[i-1].getDommageCible() + 5);
            }
        }
    }
}

