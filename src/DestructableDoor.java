public class DestructableDoor extends LockableDoor {

    // ***** ATTRIBUTES *****

    // ***** CONSTRUCTORS *****

    DestructableDoor(Place p1, Place p2) {
        super(p1, p2);
    }

    // ***** METHODS *****

    // Getter

    // Setter

    @Override
    public void unlock() {}

    public void unlock(boolean destructed) {
        if (destructed && !this.isUnlock()) { //Ssi le joueur possède un gourdin pour défoncer la porte
            super.unlock();
            super.open();
            System.out.print("WHAT THE HELL DUDE !? IT'S JUST A SIMPLE DOOR ! WHAT'S YOUR F***ING PROBLEM ???\nHum...The door is open yet...\n");
        }
/*        else {
            System.out.print("What didn't you understand in \"it's doomed\" ? STOOOPID CAVEMAN !\n");
        }*/
    }

    //Other

    @Override
    public void go(Hero hero, String s){
        this.unlock(hero.getObjs().containsKey("Club")); //On cherche si le joueur possède le gourdin dans ses items
        if(this.isUnlock()){
            hero.setPlace(this.getPlaces().get(s));     //Si c'est déverrouillé on peut passer
        }
        else{
            System.out.print("Although the outcome is doomed, this door seems DOWNRIGHT fragile.\n"); //Sinon indication
        }
    }

    // Display

}
