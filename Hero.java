import java.util.Random;

public abstract class Hero {
    private int PV;
    private int armure;
    private int degats;
    public Food[] foods;
    public Potion[] potions;

    public void defend() {
        setArmure(getArmure() + 1);
    }

    public int getDommageCible() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public int getArmure() {
        return armure;
    }

    public void setArmure(int armure) {
        this.armure = armure;
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public Hero(int lifepoint, int armor, int wepondomage){
        this.setPV(lifepoint);
        this.setArmure(armor);
        this.setDegats(wepondomage);
        this.foods = new Food[2];
        foods[0] = new pain();
        foods[1] = new pomme();
        this.potions = new Potion[2];
        potions[0] = new potionMana();
        potions[1] = new potionVie();
        System.out.println("Dans son sac il y a" + foods[0] + foods[1] + potions[0] + potions[1] +"\n");
    }

    public int attack(int wepondomage) {return wepondomage;};
}

class Warrior extends Hero {
    public Warrior (int lifepoint, int armor, int wepondomage) {
        super(lifepoint, armor, wepondomage);
    }

    @Override
    public int attack(int wepondomage) {
        int degats;
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
        degats = 0;
        if ((nombreAleatoire >= 0) && (nombreAleatoire <= 5)) {
            degats = wepondomage * 2;
        }
        if ((nombreAleatoire > 5) && (nombreAleatoire <= 75)) {
            degats = wepondomage;
        }
        if ((nombreAleatoire > 75) && (nombreAleatoire >= 85)) {
            degats = wepondomage / 2;
        }
        if ((nombreAleatoire > 95) && (nombreAleatoire >= 100)) {
            degats = 0;
        }
        return degats;
    }
}

abstract class SpellCaster extends Hero {
    private int manapoint;
    public SpellCaster(int lifepoint, int armor, int wepondomage, int manapoint){
        super(lifepoint, armor, wepondomage);
        this.setManapoint(manapoint);
    }
    public int getManapoint() {
        return manapoint;
    }
    public void setManapoint(int manapoint) {
        this.manapoint = manapoint;
    }
}

class Healer extends SpellCaster{
    public Healer (int lifepoint, int armor, int wepondomage, int manapoint){
        super(lifepoint, armor, wepondomage,manapoint);
    }
    
    @Override
    public int attack(int wepondomage) {
        int degats;
        int manapoint = getManapoint();
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
        degats = 0;
        setManapoint(manapoint - 10);
        System.out.print("\nil lui reste " + getManapoint() + " points de mana");

        if ((nombreAleatoire >= 0) && (nombreAleatoire <= 5)) {
            degats = wepondomage * 2;
        }
        if ((nombreAleatoire > 5) && (nombreAleatoire <= 75)) {
            degats = wepondomage;
        }
        if ((nombreAleatoire > 75) && (nombreAleatoire >= 85)) {
            degats = wepondomage / 2;
        }
        if ((nombreAleatoire > 95) && (nombreAleatoire >= 100)) {
            degats = 0;
        }
        return degats;
    }
}

class MAGE extends SpellCaster{
    public MAGE (int lifepoint, int armor, int wepondomage, int manapoint){
        super(lifepoint, armor, wepondomage,manapoint);
    }
    
    @Override
    public int attack(int wepondomage) {
        int degats;
        int manapoint = getManapoint();
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
        degats = 0;
        setManapoint(manapoint - 10);
        System.out.print("\nil lui reste " + getManapoint() + " points de mana");

        if ((nombreAleatoire >= 0) && (nombreAleatoire <= 5)) {
            degats = wepondomage * 2;
        }
        if ((nombreAleatoire > 5) && (nombreAleatoire <= 75)) {
            degats = wepondomage;
        }
        if ((nombreAleatoire > 75) && (nombreAleatoire >= 85)) {
            degats = wepondomage / 2;
        }
        if ((nombreAleatoire > 95) && (nombreAleatoire >= 100)) {
            degats = 0;
        }
        return degats;
    }
}

class Hunter extends Hero {
    private int arrows;

    public int getarrows() {
        return arrows;
    }

    public void setarrows(int arrows) {
        this.arrows = arrows;
    }


    public Hunter(int lifepoint, int armor, int wepondomage, int arrows) {
        super(lifepoint, armor, wepondomage);
        this.arrows = arrows;
    }
    
    @Override
    public int attack(int wepondomage) {
        int degats;
        int arrows = getarrows();
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(100 - 0 + 1) + 0;
        degats = 0;
        setarrows(arrows--);
        System.out.print("\nil lui reste " + getarrows() + " flèche(s)");

        if ((nombreAleatoire >= 0) && (nombreAleatoire <= 5)) {
            degats = wepondomage * 2;
        }
        if ((nombreAleatoire > 5) && (nombreAleatoire <= 75)) {
            degats = wepondomage;
        }
        if ((nombreAleatoire > 75) && (nombreAleatoire >= 85)) {
            degats = wepondomage / 2;
        }
        if ((nombreAleatoire > 95) && (nombreAleatoire >= 100)) {
            degats = 0;
        }
        return degats;
    }
}
