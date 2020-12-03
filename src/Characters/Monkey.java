package Characters;

import Others.*;

public class Monkey extends Animal{

	// ***** ATTRIBUTES *****
	
	/*This attribute is used to know if the Characters.Monkey
	 got the Objects.Banana that he asked for*/
	private boolean hungry = true;
	public final String hungryDialog;
	
	
	// ***** CONSTRUCTOR *****

	public Monkey(String name, int bLevel, String noBeschDialog, String beschDialog,String hungryDialog,String desc) {
		super(name, bLevel, noBeschDialog, beschDialog,desc);
		this.hungryDialog = hungryDialog;
	}

	
	// ***** METHODS *****


	// === SETTER ===

	public void setUnHungry() {
		this.hungry = false;
	}


	// === COMMANDS ===
	
	@Override
	public void talk(Hero h) throws InterruptedException {
		
		if(h.getObjs().containsKey("Objects.Banana")){
			h.getObjs().remove("Objects.Banana");
			
			this.hungry = false;
		}
		
		if(this.beschLevel>h.getBLevel()){
			Game.printLetterByLetter(Script.MONKEY_TEXT01);
		}
		else if(this.hungry){
			Game.printLetterByLetter(Script.MONKEY_TEXT02);
		}
		else{
			Game.printLetterByLetter(Script.MONKEY_TEXT03);
		}
	}

}
