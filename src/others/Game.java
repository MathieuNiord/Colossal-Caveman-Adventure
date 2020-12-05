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
		Door secretPassage = new BurnableDoor(archivesRoom, null);
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
		Weapon club = new Weapon(Script.DEFAULT_CLUB_NAME);
		Potion potion = new Potion(Script.DEFAULT_POTION_NAME);
		Banana banana = new Banana(Script.DEFAULT_BANANA_NAME);
		Stick stick = new Stick(Script.DEFAULT_STICK_NAME);
		Flint flint = new Flint(Script.DEFAULT_FLINT_NAME);
		Fuse fuse = new Fuse(Script.DEFAULT_FUSE_NAME);
		Bescherelle catB = new Bescherelle(Script.DEFAULT_BESCHERELLE_NAME);
		Bescherelle mouseB = new Bescherelle(Script.DEFAULT_BESCHERELLE_NAME);
		Bescherelle monkeyB = new Bescherelle(Script.DEFAULT_BESCHERELLE_NAME);
		Key k1 = new Key(Script.DEFAULT_KEY1_NAME);
		Key k2 = new Key(Script.DEFAULT_KEY2_NAME);
		ElectricityMeter electricityMeter = new ElectricityMeter(Script.DEFAULT_ELECTRICMETER_NAME,coldRoom);
		Locker locker = new Locker(Script.DEFAULT_LOCKER_NAME,this.hero);
		NaziPoster naziPoster = new NaziPoster(Script.DEFAULT_NAZIPOSTER_NAME);
		SexyPoster sexyPoster = new SexyPoster(Script.DEFAULT_SEXYPOSTER_NAME);
		Walkman walkman = new Walkman(Script.DEFAULT_WALKMAN_NAME);


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

		sysClear();
		System.out.println(Script.BATTLE_BEGIN + enemy.NAME);
		pressAnyKeyToContinue();
		sysClear();
		System.out.print(enemy.NAME + " :");
		enemy.opening();
		enemy.descript();
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
						default -> printLetterByLetter("\nHaha I know you can't read but make a little effort if you don't want to end up in mush...You pass your turn !\n", Script.DEFAULT_NARRATOR);	//Sinon tant pis pour lui
					}
					break;

				case 2 :
					switch (tabInput[0]) {
						case "attack" -> printLetterByLetter("Why did you knock " + tabInput[1] + " !? You pass your turn !\n", Script.DEFAULT_NARRATOR);	//Cette ligne juste pour le style
						case "heal" -> printLetterByLetter("You cannot cure " + enemy.NAME + ". On the other hand you will take a hit\n", Script.DEFAULT_NARRATOR);	//Cette ligne juste pour le style
						default -> printLetterByLetter("A moment... What is " + tabInput[1] + " ? Ohw Gosh pay attention !\n", Script.DEFAULT_NARRATOR);
					}
					break;

				default :
					printLetterByLetter("Whatever ! You pass your turn !\n", Script.DEFAULT_NARRATOR);
			}
		}
		//ONCE ENEMY IS DEFEATED
		System.out.println("============= END OF THE BATTLE : " + enemy.NAME + " DEFEATED =============");
		enemy.defeat();
		printLetterByLetter("\nGood Game, you defeat this bad Nazi crap !\n", Script.DEFAULT_NARRATOR);

		hero.getPlace().addObject(enemy.getItem());
		hero.take(enemy.getItem().NAME);
		printLetterByLetter("An object fell from the corpse of " + enemy.NAME + ". Looks like the " + enemy.getItem().NAME + "\n", Script.DEFAULT_NARRATOR);
		enemy.loot();
		hero.getPlace().setEnemy(null);
	}

	public void help() {
		System.out.println(Script.HELP_DEFAULT);
	}


	// === OTHER ===

	public void Play(){
		sysClear();
		System.out.print(Script.SYNOPSIS + "\n");
		pressAnyKeyToContinue();
		sysClear();
		

		while(this.hero.isAlive() && !this.hero.getPlace().getName().equals("Exit") && !this.hero.isQuit()){
			this.PlayATurn();
		}
		this.gameOver();
	}

	public void PlayATurn(){
		sysClear();
		if (this.hero.getPlace().isContainsEnemies()) {
			battle(this.hero, this.hero.getPlace().getEnemies());
		}
		this.displayEnvironment();
		cmdPush(2);
		System.out.print("\nCurrent HP : " + this.hero.getHP() + "\n");
		this.hero.showInventory();
		System.out.print("\n\nCommand :> ");
		int count; //count of words
		String input; //input String
		String[] tabInput = new String[0]; //Tab of words
		Scanner scanner = new Scanner(System.in); //Scanner for input

		if(scanner.hasNext()){
			input = scanner.nextLine();
			tabInput = input.split(" "); //Split the input into the tab when the char is "space"
		}
		System.out.println();
		count = tabInput.length; //count is equal to the number of words
		switch (count) {

			case 1:
				switch (tabInput[0].toLowerCase()) {
					case "help" -> this.help(); //show commands
					case "quit"-> this.hero.quit(); //exit prompt
					case "inventory"->this.hero.showInventory();
					default-> System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;

			case 2:
				switch (tabInput[0].toLowerCase()) {
					case "go" -> this.hero.go(tabInput[1]);
					case "take" -> this.hero.take(tabInput[1]);
					case "use" -> this.hero.use(tabInput[1]);
					case "look" -> this.hero.lookAt(tabInput[1]);
					case "talk" -> this.hero.talk(tabInput[1]);
					default -> System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;

			case 3:
				switch (tabInput[0].toLowerCase()) {
					case "go" -> this.hero.go(tabInput[1]+" "+tabInput[2]);
					case "look"-> this.hero.lookAt(tabInput[1]+" "+tabInput[2]);
					case "use"-> this.hero.use(tabInput[1],tabInput[2]);
					default -> System.out.println("Wrong input, write \"help\" if you're lost with commands");
				}
				break;

			default : System.out.println("Wrong input, write \"help\" if you're lost with commands");
		}
		pressAnyKeyToContinue();
	}

	public void gameOver() {

		//LOOSE ENDING
		if (this.hero.getHP() <= 0) {

			Scanner sc = new Scanner(System.in);
			String choice;

			sysClear();
			printLetterByLetter(Script.YOU_LOOSE, "NARRATOR");
			cmdPush(30);
			System.out.print("Continue ? : ");
			choice = sc.nextLine();

			switch (choice.toLowerCase()) {

				case "yes", "y", "1" : this.Play();

				default : this.hero.quit();
			}
		}

		//WIN ENDING
		else if (!this.hero.isQuit()){
			sysClear();
			printLetterByLetter(Script.YOU_WIN, "NARRATOR");
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
			printLetterByLetter(Script.THANKING_PLAYER, "DEVELOPERS");

			try {
				Thread.sleep(5000);
			}
			catch (final Exception e) {
				System.out.println("Error");
			}

			pressAnyKeyToContinue();
			this.hero.quit();
		}
		//ONLY QUIT
		else {
			this.hero.quit();
		}
	}


	// === DISPLAY ===

	public void displayEnvironment() {
		System.out.println("\n" + this.hero.getPlace().toString());
	}

	public static void printLetterByLetter(String s, String whom) {
		System.out.print("\n" + whom + " : ");
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
		System.out.print("\nPress Enter key to continue...");
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
		Game.sysClear();
		System.out.println(Script.WELCOME_MESSAGE);
		System.out.print("\n\nPlease, choose your name : ");
		Game g = new Game(sc.nextLine());
		Game.printLetterByLetter("\nOk so you choose \"HOUGA BOUGA\" as gamer tag. You agreed ?\n\n1 - Yes for sure\t2 - Yes I've no other choice\n", Script.DEFAULT_NARRATOR);
		System.out.print("\nAnswer : ");
		sc.nextLine();
		Game.printLetterByLetter("\nAs you want HOUGA BOUGA !\n", Script.DEFAULT_NARRATOR);
		Game.pressAnyKeyToContinue();
		g.Play();
	}

}