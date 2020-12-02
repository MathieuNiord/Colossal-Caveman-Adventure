public class Monkey extends Animal{
	
	// ***** CONSTANTS *****
	
	// ***** ATTRIBUTES *****
	
	/*This attribut is used to know if the Monkey
	 got the Banana that he asked for*/
	private boolean hungry;
	public final String hungryDialog;
	
	
	// ***** CONSTRUCTORS *****
	public Monkey(String name, int bLevel, String noBeschDialog, String beschDialog,String hungryDialog,String desc) {
		super(name, bLevel, noBeschDialog, beschDialog,desc);
		this.hungryDialog = hungryDialog;
	}

	
	// ***** METHODS *****
	
	// Getter
	
	
	
	// Setter
	
	
	
	// Display
	
	
	@Override
	public void talk(Hero h) throws InterruptedException {
		
		if(h.getObjs().containsKey("Banana")){
			h.getObjs().remove("Banana");
			
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
