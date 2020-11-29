import java.util.Map;

public class Game {

	// ***** ATTRIBUTES *****
	private Hero hero;
	private Map<String,Place> places;

	// ***** CONSTRUCTORS *****

	public Game(String heroName)
	{
		// We create the rooms
		Place animalRoom = new Place("Animal room", false, true);
		Place transferRoom = new Place("Transfer room", false, true);
		Place changingRoom = new Place("Changing room", false, true);
		Place entry = new Place("Entry", false, true);
		Place meetingRoom = new Place("Meeting room", false, true);
		Place archivesRoom = new Place("Archives room", false, true);
		Place experimentsRoom = new Place("Experiments room", false, true);
		Place mortuary = new Place("Mortuary", false, true); // on éclaire la pièce ?
		Place condamnedSAS = new Place("Condamned sas", true, true);
		Place desertedRoom = new Place("Deserted room", false, true);
		Place productsReserve = new Place("Products reserve", false, true);
		Place garbageRoom = new Place("Garbage room", false, true);
		Place coldRoom = new Place("Cold room", false, false);
		Place dirtyChangingRoom = new Place("Dirty changing room", false, true); // est ce qu'on pourrait pas l'enlever ?
		Place decontaminationRoom = new Place("Decontamination room", false, true);
		Place exit = new Place("Exit", false, true);


		// We create the doors
		Door secretPassage = new Door(archivesRoom);

		Door changAndEntry = new CondemnedDoor(changingRoom, entry);

		Door meetAndArch = new DestructableDoor(meetingRoom, archivesRoom);

		Door transfAndMeet = new LockedKeyDoor(1, transferRoom, meetingRoom);
		Door decontAndExit = new LockedKeyDoor(2, decontaminationRoom, exit);

		Door animAndTransf = new SecretCodeDoor("IT", animalRoom, transferRoom);
		Door experimAndReserv = new SecretCodeDoor("S A GREAT", experimentsRoom, productsReserve);
		Door experimAndDirty = new SecretCodeDoor("GAME", experimentsRoom, dirtyChangingRoom);

		Door transfAndChang = new Door(transferRoom, changingRoom);
		Door transfAndExper = new Door(transferRoom, experimentsRoom);
		Door experimAndMort = new Door(experimentsRoom, mortuary);
		Door experimAndConda = new Door(experimentsRoom, condamnedSAS);
		Door condaAndDesert = new Door(condamnedSAS, desertedRoom);
		Door experimAndCold = new Door(experimentsRoom, coldRoom);
		Door coldAndGarb = new Door(coldRoom, garbageRoom);
		Door dirtAndDecon = new Door(dirtyChangingRoom, decontaminationRoom);


		// We add the doors to the rooms (2 * 15 doors + secret passage)
		animalRoom.addDoor(animAndTransf);

		changingRoom.addDoor(transfAndChang);
		changingRoom.addDoor(changAndEntry);

		entry.addDoor(changAndEntry); // doit on vraiment lui ajouter la porte ?

		transferRoom.addDoor(animAndTransf);
		transferRoom.addDoor(transfAndChang);
		transferRoom.addDoor(transfAndMeet);
		transferRoom.addDoor(transfAndExper);

		meetingRoom.addDoor(transfAndMeet);
		meetingRoom.addDoor(meetAndArch);

		archivesRoom.addDoor(meetAndArch);

		experimentsRoom.addDoor(transfAndExper);
		experimentsRoom.addDoor(experimAndMort);
		experimentsRoom.addDoor(experimAndConda);
		experimentsRoom.addDoor(experimAndReserv);
		experimentsRoom.addDoor(experimAndCold);
		experimentsRoom.addDoor(experimAndDirty);

		mortuary.addDoor(experimAndMort);
		mortuary.addDoor(secretPassage);

		condamnedSAS.addDoor(experimAndConda);
		condamnedSAS.addDoor(condaAndDesert);

		desertedRoom.addDoor(condaAndDesert);

		productsReserve.addDoor(experimAndReserv);

		coldRoom.addDoor(experimAndCold);
		coldRoom.addDoor(coldAndGarb);

		garbageRoom.addDoor(coldAndGarb);

		dirtyChangingRoom.addDoor(experimAndDirty);
		dirtyChangingRoom.addDoor(dirtAndDecon);

		decontaminationRoom.addDoor(dirtAndDecon);
		decontaminationRoom.addDoor(decontAndExit);

		exit.addDoor(decontAndExit);  // doit on vraiment lui ajouter la porte ?


		// We add the animals to the rooms
		animalRoom.addAndCreateAnimal("Animal", "cat", 1);

		experimentsRoom.addAndCreateAnimal("Animal", "mouse", 2);
		experimentsRoom.addAndCreateAnimal("Monkey", "monkey", 3);

		// We add the objects to the rooms


		// We add the enemies to the rooms
		meetingRoom.addAndCreateEnemy("Account guy", 10, 1, null, Script.ACCOUNTGUY_DEFAULT, Script.ACCOUNTGUY_ATTACK, Script.ACCOUNTGUY_DEFEAT);
		desertedRoom.addAndCreateEnemy("Zombie Nazi", 15, 3, null, Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK, Script.ZOMBIE_DEFEAT);
		decontaminationRoom.addAndCreateEnemy("NOM DU BOSS", 20, 6, null, Script.BOSS_DEFAULT, Script.BOSS_ATTACCK, Script.BOSS_DEFEAT);

		// We create the Hero
		this.hero = new Hero(heroName, animalRoom);
	}

	// ***** METHODS *****

	// Getter
	public Hero getHero() {
		return this.hero;
	}

	public Map<String, Place> getPlaces() {
		return this.places;
	}

	// Setter


	// Display


	public void DisplayEnvironment()
	{
		System.out.println(this.hero.getPlace().toString());
	}

	// Other

	public void VerifAction(String[] cmd)
	{

	}

	public void Play()
	{

	}

	public void PlayATurn()
	{

	}

	public static void printLetterByLetter(String s) throws InterruptedException{
		
		int len = s.length();
		for(int i = 0 ; i < len; i++){
			char c = s.charAt(i);
			System.out.print(c);
			if( c=='.' || c=='?' || c==',' || c=='!')
			{
				if(i!=len-1){
					if(s.charAt(i+1)!=c){
						System.out.println();
					}
				}
				Thread.sleep(600);
			}
			
			Thread.sleep(100);
		}
	}
	
	/*public static void main(String[] args) throws InterruptedException {
		Game.printLetterByLetter("Test,I'm a test ?Yes,you're a test !OK then.Good Test...\n");
	}*/
}
