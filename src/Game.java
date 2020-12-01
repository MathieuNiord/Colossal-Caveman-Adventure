import java.util.Map;
import java.util.Scanner;

public class Game {

	// ***** ATTRIBUTES *****
	private final Hero hero;
	private Map<String,Place> places;

	// ***** CONSTRUCTORS *****

	public Game(String heroName)
	{
		// We create the rooms
		Place animalRoom = new Place("Animal-room", false, true);
		Place transferRoom = new Place("Transfer-Room", false, true);
		Place changingRoom = new Place("Changing-room", false, true);
		Place entry = new Place("Entry", false, true);
		Place meetingRoom = new Place("Meeting-room", false, true);
		Place archivesRoom = new Place("Archives-room", false, true);
		Place experimentsRoom = new Place("Experiments-room", false, true);
		Place mortuary = new Place("Mortuary", false, true); // on éclaire la pièce ?
		Place condamnedSAS = new Place("Condamned-sas", true, true);
		Place desertedRoom = new Place("Deserted-room", false, true);
		Place productsReserve = new Place("Products-reserve", false, true);
		Place garbageRoom = new Place("Garbage-room", false, true);
		Place coldRoom = new Place("Cold-room", false, false);
		Place dirtyChangingRoom = new Place("Dirty-changing-room", false, true); // est ce qu'on pourrait pas l'enlever ?
		Place decontaminationRoom = new Place("Decontamination-room", false, true);
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
		
		//We create Animals
		Animal cat = new Animal("Cat",1,Script.CAT_TEXT01,Script.CAT_TEXT02);
		Animal mouse = new Animal("Mouse",2,Script.MOUSE_TEXT01,Script.MOUSE_TEXT02);
		Animal monkey = new Monkey("Monkey",3,Script.MONKEY_TEXT01,Script.MOUSE_TEXT02,Script.MONKEY_TEXT03);
		
		//We create Objects
		Weapon club = new Weapon("Club",5);
		
		Heal potion = new Heal("Potion",50);
		
		Item banana = new Item("Banana");
		Item stick = new Item("Stick");
		Item silex = new Item("Silex");
		
		Bescherelle b1 = new Bescherelle("Bescherelle");
		
		// We add the doors to the rooms (2 * 15 doors + secret passage)
		animalRoom.addDoor(animAndTransf, "up");

		changingRoom.addDoor(transfAndChang, "up");
		changingRoom.addDoor(changAndEntry, "down");

		entry.addDoor(changAndEntry, "up"); // doit on vraiment lui ajouter la porte ?

		transferRoom.addDoor(animAndTransf, "down");
		transferRoom.addDoor(transfAndChang, "down");
		transferRoom.addDoor(transfAndMeet, "right");
		transferRoom.addDoor(transfAndExper, "up");

		meetingRoom.addDoor(transfAndMeet, "left");
		meetingRoom.addDoor(meetAndArch, "right");

		archivesRoom.addDoor(meetAndArch, "left");

		experimentsRoom.addDoor(transfAndExper, "down");
		experimentsRoom.addDoor(experimAndMort, "right");
		experimentsRoom.addDoor(experimAndConda, "up");
		experimentsRoom.addDoor(experimAndReserv, "up");
		experimentsRoom.addDoor(experimAndCold, "right");
		experimentsRoom.addDoor(experimAndDirty, "right");

		mortuary.addDoor(experimAndMort, "left");
		mortuary.addDoor(secretPassage, "down");

		condamnedSAS.addDoor(experimAndConda, "down");
		condamnedSAS.addDoor(condaAndDesert, "up");

		desertedRoom.addDoor(condaAndDesert, "down");

		productsReserve.addDoor(experimAndReserv, "down");

		coldRoom.addDoor(experimAndCold, "right");
		coldRoom.addDoor(coldAndGarb, "up");

		garbageRoom.addDoor(coldAndGarb, "down");

		dirtyChangingRoom.addDoor(experimAndDirty, "right");
		dirtyChangingRoom.addDoor(dirtAndDecon, "left");

		decontaminationRoom.addDoor(dirtAndDecon, "right");
		decontaminationRoom.addDoor(decontAndExit, "left");

		exit.addDoor(decontAndExit, "right");  // doit on vraiment lui ajouter la porte ?


		// We add the animals to the rooms
		animalRoom.addAnimal(cat);
		experimentsRoom.addAnimal(monkey);
		experimentsRoom.addAnimal(mouse);
		
		// We add the objects to the rooms
		coldRoom.addObject(banana);
		garbageRoom.addObject(stick);
		productsReserve.addObject(potion);
		archivesRoom.addObject(club);
		transferRoom.addObject(silex);
		animalRoom.addObject(b1);

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
	public void help() throws InterruptedException {
		Game.printLetterByLetter(Script.HELP_DEFAULT);
	}

	public void displayEnvironment()
	{
		System.out.println(this.hero.getPlace().toString());
	}

	// Other
	
	public void Play() throws InterruptedException {
		printLetterByLetter(Script.DEFAULT_WELCOME);
		sysClear();
		this.displayEnvironment();
		while(this.hero.isAlive()&& !this.hero.getPlace().getName().equals("Exit")){
			this.PlayATurn();
		}
	}

	public void PlayATurn() throws InterruptedException {
		//Used to store inputs
		
		System.out.print("Command :>");
		int count;
		String input;
		String[] tabInput = new String[0];
		//Création d'un scanner pour lire les inputs.
		Scanner scanner = new Scanner(System.in);
		if(scanner.hasNext()){
			input= scanner.nextLine();
			tabInput = input.split(" ");
		}
		count = tabInput.length;
		switch (count){
			case 1:
				switch (tabInput[0]) {
					case "help" -> this.help();
					case "quit"-> this.hero.quit();
					case "look"-> printLetterByLetter(this.hero.getPlace().toString());
					case "inventory"->printLetterByLetter(this.hero.getObjs().keySet().toString());
					default-> System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;
			case 2:
				switch (tabInput[0]) {
					case "go" -> this.hero.go(tabInput[1]);
					case "take" -> this.hero.take(tabInput[1]);
					case "use" -> this.hero.use(tabInput[1]);
					case "look" -> printLetterByLetter(this.hero.getPlace().toString());
					case "talk" -> this.hero.talk(tabInput[1]);
					default -> System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;
			default : System.out.println("Wrong input, write \"help\" if you're lost with commands");
		}
	}

	public static void printLetterByLetter(String s) throws InterruptedException{
		
		int len = s.length();
		for(int i = 0 ; i < len; i++){
			char c = s.charAt(i);
			System.out.print(c);
			if( c=='.' || c=='?' || c==',' || c=='!')
			{
				Thread.sleep(1000);
			}
			
			Thread.sleep(20);
		}
		System.out.println();
	}

	//Pour clean la console s'il y a besoin
	public static void sysClear(){
		for (int i = 0; i < 100; i++){
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Game g = new Game("Gaetan");
		g.Play();
		
	}
	
}
