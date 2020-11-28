public class AccountGuy extends Ennemy{

    // ***** CONSTANTS *****
    private final static String OPENING = "H! !'M 7H3 4CC0UN7!N9 9UY! Y0U W4N7 70 83 MY FR!3ND ?";
    private final static String ATTACK = "a+bic+di=a+bic+di×c−dic−di=ac+bdc2+d2+bc−adc2+d2i + ";
    private final static String DAMAGE = "4444RRR9H = 1";

    // ***** ATTRIBUTES *****

    private int hp;
    private int damage;
    private Obj item; //C'est l'objet que l'ennemi va loot à la fin du combat
    private boolean state; //true = vivant
    private String opening;
    private String attack;
    private String defeat;

    // ***** CONSTRUCTORS *****

    AccountGuy(Obj loot){
        super(loot);
        this.opening = OPENING;
        this.attack = ATTACK;
        this.defeat = DAMAGE;
    }

    AccountGuy(int hp, int atk, Obj loot){ //hp = 30, atk = 7
        super(hp, atk, loot);
        this.opening = OPENING;
        this.attack = ATTACK;
        this.defeat = DAMAGE;
    }

    // ***** METHODS *****

    // Getter

    // Setter

    // Display

    @Override
    public void attack() {
        super.attack();
        System.out.print(this.damage);
    }
}
