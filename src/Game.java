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
		Door changAndEntry = new CondemnedDoor(changingRoom, entry);

		Door meetAndArch = new DestructableDoor(meetingRoom, archivesRoom);

		Door transfAndMeet = new LockedKeyDoor(1, transferRoom, meetingRoom);
		Door decontAndExit = new LockedKeyDoor(2, decontaminationRoom, exit);

		Door animAndTransf = new SecretCodeDoor("MOT DE PASSE DU CHAT", animalRoom, transferRoom);
		Door experimAndReserv = new SecretCodeDoor("MOT DE PASSE DE LA SOURIS", experimentsRoom, productsReserve);
		Door experimAndDirty = new SecretCodeDoor("MOT DE PASSE DU SINGE", experimentsRoom, dirtyChangingRoom);

		Door transfAndChang = new Door(transferRoom, changingRoom);
		Door transfAndExper = new Door(transferRoom, experimentsRoom);
		Door experAndMort = new Door(experimentsRoom, mortuary);
		Door experAndConda = new Door(experimentsRoom, condamnedSAS);
		Door condaAndDesert = new Door(condamnedSAS, desertedRoom);
		Door experAndCold = new Door(experimentsRoom, coldRoom);
		Door coldAndGarb = new Door(coldRoom, garbageRoom);
		Door dirtAndDecon = new Door(dirtyChangingRoom, decontaminationRoom);


		// We add the doors to the rooms


		// We add the animals to the rooms

		// We add the objects to the rooms

		// We add the enemies to the rooms

		// We create the Hero
		this.hero = new Hero(heroName, animalRoom);
	}

	// ***** METHODS *****

	// Getter


	// Setter


	// Display


	public void DisplayEnvironment()
	{

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

}
