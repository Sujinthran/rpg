interface Consomable {
    default void useConsomable(int playerTurn, int conso, Hero[] heroes){
        if (conso == 1){
            heroes[playerTurn].setPV(heroes[playerTurn].getPV() +3);
            heroes[playerTurn].foods[0] = new voide();
        } 
        if (conso == 2) {
            heroes[playerTurn].setPV(heroes[playerTurn].getPV() + 1);
            heroes[playerTurn].foods[1] = new voide();
        }
        if (conso == 3) {
            heroes[playerTurn].setPV(heroes[playerTurn].getPV() + 5);
            heroes[playerTurn].potions[0] = new vide();
        }
        if (conso == 4) {
            //if ((heroes[playerTurn].getClass() == MAGE) || (heroes[playerTurn].getClass() == Healer)){
            //    heroes[playerTurn].setManapoint(heroes[playerTurn].setManapoint() +70);
            //}
            heroes[playerTurn].potions[1] = new vide();
        }
    }
}
