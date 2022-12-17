import java.util.Random;

public abstract class Enemy {
    private int pv;
    private int bouclier;
    private int dommages;
    public Enemy (int pv, int bouclier, int dommages){
        this.setPv(pv);
        this.setBouclier(bouclier);
        this.setdommage(dommages);
    }

    public void setBouclier(int bouclier) {
        this.bouclier = bouclier;
    }
    public int getBouclier() {
        return bouclier;
    }

    public void setdommage(int domage) {
        this.dommages = domage;
    }
    public int getdommage() {
        return dommages;
    }


    public void setPv(int pv) {
        this.pv = pv;
    }
    public int getPv() {
        return pv;
    }


    public int attack(int dommage) {
        int degats;
        Random rand = new Random();
        int nbRandom = rand.nextInt(100 - 0 + 1) + 0;
        degats = 0;

        if ((nbRandom >= 0) && (nbRandom <= 5)) {
            degats = dommage * 2;
        }
        if ((nbRandom > 5) && (nbRandom <= 75)) {
            degats = dommage;
        }
        if ((nbRandom > 75) && (nbRandom >= 85)) {
            degats = dommage / 2;
        }
        if ((nbRandom > 95) && (nbRandom >= 100)) {
            degats = 0;
        }
        return degats;
    }
}

class BasicEnemy extends Enemy {
    public BasicEnemy (int lifepoint, int defense, int domage){
        super(lifepoint, defense, domage);
    }
}

class Boss extends Enemy {
    public Boss (int lifepoint, int defense,int domage){
        super(lifepoint, defense, domage);
    }
}

