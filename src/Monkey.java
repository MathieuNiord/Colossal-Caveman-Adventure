public class Monkey extends Animal{
	
	// ***** CONSTANTS *****
	
	// ***** ATTRIBUTES *****
	
	/*This attribut is used to know if the Monkey
	 got the Banana that he asked for*/
	private boolean hungry;
	public final String hungryDialog;
	
	
	// ***** CONSTRUCTORS *****
	public Monkey(String name, int bLevel, String noBeschDialog, String beschDialog,String hungryDialog) {
		super(name, bLevel, noBeschDialog, beschDialog);
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
		
		if(!this.hungry){
			super.talk(h);
		}
		else{
		
		}
	}
}
