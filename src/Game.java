
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
		Place dirtyChangingRoom = new Place("Dirty changingRoom", false, true); // est ce qu'on pourrait pas l'enlever ?
		Place decontaminationRoom = new Place("Decontamination room", false, true);
		Place exit = new Place("Exit", false, true);


		// We create the doors
		Door secretPassage = new BurnableDoor(archivesRoom);
		
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
		Animal cat = new Animal("Cat",1,Script.CAT_TEXT01,Script.CAT_TEXT02,Script.CAT_DESCRIPT);
		Animal mouse = new Animal("Mouse",2,Script.MOUSE_TEXT01,Script.MOUSE_TEXT02,Script.MOUSE_DESCRIPT);
		Animal monkey = new Monkey("Monkey",3,Script.MONKEY_TEXT01,Script.MOUSE_TEXT02,Script.MONKEY_TEXT03,Script.MONKEY_DESCRIPT);
		
		//We create Objects
		Weapon club = new Weapon("Club",5);
		
		Heal potion = new Heal("Potion");
		
		Banana banana = new Banana("Banana");
		Stick stick = new Stick("Stick");
		Flint flint = new Flint("Flint");
		
		Bescherelle catB = new Bescherelle("Bescherelle");
		Bescherelle mouseB = new Bescherelle("Bescherelle");
		Bescherelle monkeyB = new Bescherelle("Bescherelle");
		
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
		transferRoom.addObject(flint);
		animalRoom.addObject(catB);
		archivesRoom.addObject(mouseB);
		desertedRoom.addObject(monkeyB);

		// We add the enemies to the rooms
		meetingRoom.addAndCreateEnemy("Account guy", 10, 1, null,
				Script.ACCOUNTGUY_DEFAULT, Script.ACCOUNTGUY_ATTACK, Script.ACCOUNTGUY_DEFEAT,Script.ACCOUNTGUY_DESCRIPT);
		desertedRoom.addAndCreateEnemy("Zombie Nazi", 15, 3, null,
				Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK, Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);
		decontaminationRoom.addAndCreateEnemy("NOM DU BOSS", 20, 6, null,
				Script.BOSS_DEFAULT, Script.BOSS_ATTACCK, Script.BOSS_DEFEAT,Script.BOSS_DESCRIPT);

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

	public void displayEnvironment() throws InterruptedException {
		printLetterByLetter(this.hero.getPlace().toString());
	}

	// Other
	
	public void Play() throws InterruptedException {
		printLetterByLetter(Script.DEFAULT_WELCOME);
		pressAnyKeyToContinue();
		sysClear(100);
		this.displayEnvironment();
		while(this.hero.isAlive()&& !this.hero.getPlace().getName().equals("Exit")){
			this.PlayATurn();
		}
		//Die or Win Text
	}

	public void PlayATurn() throws InterruptedException {
		printLetterByLetter("Command :> ");
		int count; //count of words
		String input; //input String
		String[] tabInput = new String[0]; //Tab of words
		
		Scanner scanner = new Scanner(System.in); //Scanner for input
		
		if(scanner.hasNext()){
			input = scanner.nextLine();
			tabInput = input.split(" "); //Split the into the tab when the char is "space"
		}
		count = tabInput.length; //count is egal to the number of words
		switch (count){
			case 1:
				switch (tabInput[0]) {
					case "help" -> this.help(); //show commands
					case "quit"-> this.hero.quit(); //Set the life to 0 so the hero die
					case "look"-> printLetterByLetter(this.hero.getPlace().toString());
					case "inventory"->this.hero.showInventory();
					default-> System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;
			case 2:
				switch (tabInput[0]) {
					case "go" -> this.hero.go(tabInput[1]);
					case "take" -> this.hero.take(tabInput[1]);
					case "use" -> this.hero.use(tabInput[1]);
					case "look" -> this.hero.look(tabInput[1]);
					case "talk" -> this.hero.talk(tabInput[1]);
					default -> System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;
			case 3:
				switch (tabInput[0]) {
					case "go" -> this.hero.go(tabInput[1]+" "+tabInput[2]);
					case "look"->this.hero.look(tabInput[1]+" "+tabInput[2]);
					
					default -> System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
			default : System.out.println("Wrong input, write \"help\" if you're lost with commands");
		}
	}

	public static void printLetterByLetter(String s) throws InterruptedException{
		System.out.println();
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
		
	}

	//Pour clean la console s'il y a besoin
	public static void sysClear(int howmuch){
		for (int i = 0; i < howmuch; i++){
			System.out.println();
		}
	}
	
	public static void pressAnyKeyToContinue() throws InterruptedException {
		printLetterByLetter("Press Enter key to continue...");
		Scanner scanner = new Scanner(System.in);
		try
		{
			scanner.nextLine();
		}
		catch(Exception ignored){}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		printLetterByLetter("Welcome in our Colossal Caveman Adventure ! First we need to get your gamer tag.");
		printLetterByLetter("Answer : ");
		Game g = new Game(sc.nextLine());
		printLetterByLetter("Ok so you choose \"HOUGA BOUGA\" as gamer tag. You agreed ?\n1 - Yes for sure\t2 - Yes I've no other choice");
		printLetterByLetter("Answer : ");
		String noMatter = sc.nextLine();
		printLetterByLetter("As you want HOUGA BOUGA !");
		sysClear(20);
		g.Play();
	}
	
}
