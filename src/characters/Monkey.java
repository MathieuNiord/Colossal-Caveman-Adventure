package characters;

import others.*;

public class Monkey extends Animal{

	// ***** ATTRIBUTES *****
	
	/*This attribute is used to know if the Characters.Monkey
	 got the Objects.Banana that he asked for*/
	private boolean hungry = true;
	public final String noHungryDialog;
	
	
	// ***** CONSTRUCTOR *****

	public Monkey(String name, int bLevel, String noBeschDialog, String beschDialog,String hungryDialog,String desc) {
		super(name, bLevel, noBeschDialog, beschDialog,desc);
		this.noHungryDialog = hungryDialog;
	}

	
	// ***** METHODS *****

	// === GETTER ===

	public boolean getHungry() {
		return this.hungry;
	}

	// === SETTER ===


	// === COMMANDS ===
	
	@Override
	public void talk(Hero h) {

		if(h.getObjs().containsKey("Banana")){
			h.getObjs().remove("Banana");
			
			this.hungry = false;
		}

		System.out.print(("\n" + this.NAME + " :\n"));
		if(this.beschLevel>h.getBLevel()){
			Game.printLetterByLetter(this.noBeschDialog);
		}
		else if(this.hungry){
			Game.printLetterByLetter(this.beschDialog);
		}
		else{
			Game.printLetterByLetter(this.noHungryDialog);
		}
	}

}
