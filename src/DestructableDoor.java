public class DestructableDoor extends LockableDoor {

    // ***** ATTRIBUTES *****

    private boolean weapon = false;

    // ***** CONSTRUCTORS *****

    DestructableDoor(Place p1, Place p2) {
        super(p1, p2);
    }

    // ***** METHODS *****

    // Getter

    // Setter

    @Override
    public void unlock() {
        System.out.print("Although the outcome is doomed, this door seems DOWNRIGHT fragile.\n");
    }



    public void unlock(boolean destructed) {
        if (destructed) {
            super.unlock();
            super.open();
            System.out.print("WHAT THE HELL DUDE !? IT'S JUST A SIMPLE DOOR ! WHAT'S YOUR F***ING PROBLEM ???\nHum...The door is open yet...\n");
        }
        else {
            System.out.print("What didn't you understand in \"it's doomed\" ? STOOOPID CAVEMAN !\n");
        }
    }

    // Display

}
