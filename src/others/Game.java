package others;

import characters.*;
import doors.*;
import objects.*;

import java.util.Scanner;

public class Game {


	// ***** ATTRIBUTES *****

	private final Hero hero;


	// ***** CONSTRUCTORS *****

	public Game(String heroName)
	{

		// ROOMS CREATION
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


		// DOORS CREATION
		Door secretPassage = new BurnableDoor(archivesRoom);
		Door experimAndConda = new InfectedRoomDoor(experimentsRoom, condamnedSAS);
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
		Door condaAndDesert = new Door(condamnedSAS, desertedRoom);
		Door experimAndCold = new Door(experimentsRoom, coldRoom);
		Door coldAndGarb = new Door(coldRoom, garbageRoom);
		Door dirtAndDecon = new Door(dirtyChangingRoom, decontaminationRoom);


		// HERO CREATION
		this.hero = new Hero(heroName, animalRoom);


		// ANIMALS CREATION
		Animal cat = new Animal("Cat",1,Script.CAT_TEXT01,Script.CAT_TEXT02,Script.CAT_DESCRIPT);
		Animal mouse = new Animal("Mouse",2,Script.MOUSE_TEXT01,Script.MOUSE_TEXT02,Script.MOUSE_DESCRIPT);
		Animal monkey = new Monkey("Monkey",3,Script.MONKEY_TEXT01,Script.MONKEY_TEXT02,Script.MONKEY_TEXT03,Script.MONKEY_DESCRIPT);


		// OBJECTS CREATION
		Weapon club = new Weapon("Club");
		Potion potion = new Potion("Potion");
		Banana banana = new Banana("Banana");
		Stick stick = new Stick("Stick");
		Flint flint = new Flint("Flint");
		Fuse fuse = new Fuse("Fuse");
		Bescherelle catB = new Bescherelle("Bescherelle");
		Bescherelle mouseB = new Bescherelle("Bescherelle");
		Bescherelle monkeyB = new Bescherelle("Bescherelle");
		Key k1 = new Key("Key1");
		Key k2 = new Key("Key2");
		ElectricityMeter electricityMeter = new ElectricityMeter("ElectricMeter",coldRoom);
		Locker locker = new Locker("Locker",this.hero);
		NaziPoster naziPoster = new NaziPoster("NaziPoster",this.hero);
		SexyPoster sexyPoster = new SexyPoster("SexyPoster",this.hero);
		Walkman walkman = new Walkman("Walkman");
		
		
		// DOORS ADDING TO ROOMS
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
		experimentsRoom.addDoor(experimAndCold, "left");
		experimentsRoom.addDoor(experimAndDirty, "left");
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


		// ANIMALS ADDING TO ROOMS
		animalRoom.addAnimal(cat);
		experimentsRoom.addAnimal(monkey);
		experimentsRoom.addAnimal(mouse);


		// OBJECTS ADDING TO ROOMS
		coldRoom.addObject(banana);
		garbageRoom.addObject(stick);
		productsReserve.addObject(potion);
		archivesRoom.addObject(club);
		transferRoom.addObject(flint);
		animalRoom.addObject(catB);
		archivesRoom.addObject(mouseB);
		desertedRoom.addObject(monkeyB);
		transferRoom.addObject(electricityMeter);
		changingRoom.addObject(locker);
		experimentsRoom.addObject(naziPoster);
		changingRoom.addObject(sexyPoster);
		locker.addObj(walkman);
		
		// ENEMIES ADDING TO ROOMS
		meetingRoom.addAndCreateEnemy("Account guy", 10, 1, k1,
				Script.ACCOUNTGUY_DEFAULT, Script.ACCOUNTGUY_ATTACK, Script.ACCOUNTGUY_DEFEAT,Script.ACCOUNTGUY_DESCRIPT);
		desertedRoom.addAndCreateEnemy("Zombie Nazi", 15, 3, fuse,
				Script.ZOMBIE_DEFAULT, Script.ZOMBIE_ATTACK, Script.ZOMBIE_DEFEAT,Script.ZOMBIEDESCRIPT);
		decontaminationRoom.addAndCreateEnemy("SUPER-NAZI", 20, 6, k2,
				Script.BOSS_DEFAULT, Script.BOSS_ATTACCK, Script.BOSS_DEFEAT,Script.BOSS_DESCRIPT);

	}


	// ***** METHODS *****

	
	// === COMMANDS ===

	public void battle(Hero hero, Enemy enemy){

		System.out.println(Script.BATTLE_BEGIN + enemy.NAME);
		sysClear();
		System.out.print(enemy.NAME + " :");
		enemy.opening();
		Scanner sc = new Scanner(System.in);
		String input;
		String[] tabInput;
		int count;
		System.out.println(Script.BATTLE_HELP);

		while (hero.isAlive() && !enemy.isDefeat()) {

			//ENEMY TURN
			System.out.println("========== " + enemy.NAME + " turn : ==========\n");
			enemy.attack();
			hero.setLife(-(enemy.getDamage()));
			//HERO TURN
			System.out.println("========== Your turn : ==========\n\nLIFE : " + hero.getHP() + "\n");
			System.out.print("Choice :>");
			input = sc.nextLine();
			tabInput = input.split(" ");
			count = tabInput.length;	//Au cas où je préfère récupérer le nombre de mots

			switch (count) {

				case 1 :
					switch (tabInput[0]) {
						case "attack" -> hero.attack(enemy);	//Si le joueur veut attaquer on attaque directement l'ennemi
						case "heal" -> hero.heal();				//Si le joueur veut se soigner on appelle la mèthode qui permet de se soigner
						default -> printLetterByLetter("\nHaha I know you can't read but make a little effort if you don't want to end up in mush...You pass your turn !\n");	//Sinon tant pis pour lui
					}
					break;

				case 2 :
					switch (tabInput[0]) {
						case "attack" -> printLetterByLetter("Why did you knock " + tabInput[1] + " !? You pass your turn !\n");	//Cette ligne juste pour le style
						case "heal" -> printLetterByLetter("You cannot cure " + enemy.NAME + ". On the other hand you will take a hit\n");	//Cette ligne juste pour le style
						default -> printLetterByLetter("A moment... What is " + tabInput[1] + " ? Ohw Gosh pay attention !\n");
					}
					break;

				default : printLetterByLetter("Whatever ! You pass your turn !\n");
			}

		}
		//ONCE ENEMY IS DEFEATED
		System.out.println("============= END OF THE BATTLE : " + enemy.NAME + " DEFEATED =============");
		printLetterByLetter("\nGood Game, you defeat this bad Nazi crap !\n");
		
		hero.getPlace().addObject(enemy.getItem());
		hero.take(enemy.getItem().NAME);
		hero.getPlace().getItems().remove(enemy.getItem().NAME);
		printLetterByLetter("An object fell from the corpse of " + enemy.NAME + ". Looks like a " + enemy.getItem().NAME + "\n");
		enemy.loot();
		hero.getPlace().setEnemy(null);
	}

	public void help() {
		System.out.println(Script.HELP_DEFAULT);
	}


	// === OTHER ===

	public void Play(){
		sysClear();
		printLetterByLetter(Script.SYNOPSIS);
		while(this.hero.isAlive()&& !this.hero.getPlace().getName().equals("Exit")){
			//this.displayEnvironment();//===================================================modif
			this.PlayATurn();
		}
		this.gameOver();
	}

	public void PlayATurn(){
		if (this.hero.getPlace().isContainsEnemies()) {
			battle(this.hero, this.hero.getPlace().getEnemies());
		}
		//this.displayEnvironment(); //=======================================modif origine
		cmdPush(2);	//========================================SAUTS DE LIGNES
		System.out.print("\n\nCommand :> ");
		int count; //count of words
		String input; //input String
		String[] tabInput = new String[0]; //Tab of words

		Scanner scanner = new Scanner(System.in); //Scanner for input

		if(scanner.hasNext()){
			input = scanner.nextLine();
			sysClear();
			this.displayEnvironment();//===================================================modif
			tabInput = input.split(" "); //Split the input into the tab when the char is "space"
		}
		count = tabInput.length; //count is equal to the number of words
		switch (count){
			case 1:
				switch (tabInput[0]) {
					case "help" -> this.help(); //show commands
					case "quit"-> this.hero.quit(); //Set the life to 0 so the hero die
					case "look"-> this.hero.getPlace().look();
					case "inventory"->this.hero.showInventory();
					default-> System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;
			case 2:
				switch (tabInput[0]) {
					case "go" -> this.hero.go(tabInput[1]);
					case "take" -> this.hero.take(tabInput[1]);
					case "use" -> this.hero.use(tabInput[1]);
					case "look" -> this.hero.lookAt(tabInput[1]);
					case "talk" -> this.hero.talk(tabInput[1]);
					default -> System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;
			case 3:
				switch (tabInput[0]) {
					case "go" -> this.hero.go(tabInput[1]+" "+tabInput[2]);
					case "look"-> this.hero.lookAt(tabInput[1]+" "+tabInput[2]);
					case "use"-> this.hero.use(tabInput[1],tabInput[2]);
					default -> System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;
			default : System.out.println("Wrong input, write \"help\" if you're lost with commands");
		}
	}

	public void gameOver() {

		//LOOSE ENDING
		if (this.hero.getHP() <= 0) {

			Scanner sc = new Scanner(System.in);
			String choice;

			sysClear();
			printLetterByLetter(Script.YOU_LOOSE);
			cmdPush(30);
			System.out.print("Continue ? : ");
			choice = sc.nextLine();

			switch (choice) {

				case "yes", "YES", "y", "Y", "1" : this.Play();

				default :
					printLetterByLetter("\nOk as you want mister, goodbye !");

					try {
						Thread.sleep(5000);
						new ProcessBuilder("cmd", "/c", "exit").inheritIO().start().waitFor();
					}
					catch (final Exception e) {
						System.out.println("Error");
					}
			}
		}

		//WIN ENDING
		else {
			sysClear();
			printLetterByLetter(Script.YOU_WIN);
			try {
				Thread.sleep(10000);
			}
			catch (final Exception e) {
				System.out.println("Error");
			}

			//CREDITS
			sysClear();
			System.out.print(Script.CREDITS);

			try {
				Thread.sleep(10000);
			}
			catch (final Exception e) {
				System.out.println("Error");
				
			}

			//THANKING
			sysClear();
			printLetterByLetter(Script.THANKING_PLAYER);

			try {
				Thread.sleep(10000);
			}
			catch (final Exception e) {
				System.out.println("Error");
			}

			pressAnyKeyToContinue();

			//EXIT
			try {
				new ProcessBuilder("cmd", "/c", "exit").inheritIO().start().waitFor();
			}
			catch (final Exception e) {
				System.out.println("Error");
			}
		}
	}


	// === DISPLAY ===

	public void displayEnvironment() {
		System.out.println("\n" + this.hero.getPlace().toString());
	}

	public static void printLetterByLetter(String s) {
		System.out.println();
		int len = s.length();
		try {
			for (int i = 0 ; i < len; i++) {
				char c = s.charAt(i);
				System.out.print(c);
				if ( c=='.' || c=='?' || c==',') {
					Thread.sleep(500);
				}

				Thread.sleep(20);
			}}
		catch (Exception e) {
			System.out.println("Error");
			
		}

	}

	//Pour clean la console s'il y a besoin
	public static void sysClear(){
		try
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch (final Exception e)
		{
			//  Handle any exceptions.
		}
		System.out.flush();
	}

	public static void pressAnyKeyToContinue() {
		printLetterByLetter("Press Enter key to continue...");
		Scanner scanner = new Scanner(System.in);
		try
		{
			scanner.nextLine();
		}
		catch(Exception ignored){}
	}

	public static void cmdPush(int howmuch) {
		for (int i = 0; i < howmuch; i++) {
			System.out.println();
		}
	}
	
	// === MAIN ===

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printLetterByLetter(Script.WELCOME_MESSAGE);
		System.out.print("\n\nPlease, choose your name : ");
		Game g = new Game(sc.nextLine());
		
		printLetterByLetter("Ok so you choose \"HOUGA BOUGA\" as gamer tag. You agreed ?\n" +
				"\n1 - Yes for sure\t2 - Yes I've no other choice\n");
		System.out.print("\n\nAnswer : ");
		sc.nextLine();
		printLetterByLetter("\n\nAs you want HOUGA BOUGA !\n");
		pressAnyKeyToContinue();
		g.Play();
	}
	
}