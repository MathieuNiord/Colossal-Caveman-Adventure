public class Ennemy {

    // ***** CONSTANTS *****
    private static final int DEFAULT_HP = 30;
    private static final int DEFAULT_DAMAGE = 7;
    private static final String DEFAULT_NAME = "Ennemy_TEST";

    // ***** ATTRIBUTES *****

    private final String NAME;
    private int hp;
    private final int damage;
    private Obj item; //C'est l'objet que l'ennemi va loot à la fin du combat
    private boolean state; //true = vivant
    private final String opening;
    private final String attack;
    private final String defeat;
    private final String description;
    //Je pensais ajouter un healcounter de manière à ce que l'ennemi puisse se soigner un certain nb de fois au cours du combat

    // ***** CONSTRUCTORS *****

    Ennemy(Obj loot, String op, String atk, String dft,String desc){
        this.NAME = DEFAULT_NAME;
        this.hp = DEFAULT_HP;
        this.damage = DEFAULT_DAMAGE;
        this.item = loot;
        this.opening = op;
        this.attack = atk;
        this.defeat = dft;
        this.description=desc;
    }

    Ennemy(String name, int hp, int dmg, Obj loot, String op, String atk, String dft,String desc){
        this.NAME = name;
        this.hp = hp;
        this.damage = dmg;
        this.item = loot;
        this.opening = op;
        this.attack = atk;
        this.defeat = dft;
        this.description=desc;
    
    }

    // ***** METHODS *****

    // Getter

    //On souhaite connaître les points de vies restants de l'ennemi
    public int getHP(){
        return this.hp;
    }

    //On souhaite connaître les dégâts d'attaque de l'ennemi
    public int getDamage(){
        return this.damage;
    }

    //On souhaite savoir si l'ennemi a perdu
    public boolean isDefeat(){
        return !this.state;
    }

    //On souhaite connaître l'objet que possède l'ennemi
    public Obj getItem(){
        return this.item;
    }

    // Setter

    public void takeDamage(int damage){
        System.out.println(Script.ANGRY_HERO);
        if(this.hp > 0 && this.state){
            this.hp -= damage;
        }
        this.Kill();
    }

    public void Heal(int heal){
        if(this.state && this.hp > 0){
            this.hp += heal;
        }
    }

    public void Kill(){
        if(hp <= 0 && this.state){
            this.state = false;
            System.out.println(this.defeat);
        }
    }

    public void Loot(){
        //TODO drop l'item au joueur
        this.item = null;
    }

    // Display

    public void opening(){
        System.out.print(this.opening);
    }

    public void attack(){
        System.out.print(this.attack);
    }

    public void defeat(){
        System.out.print(this.defeat);
    }
    
    public void look() throws InterruptedException {
        Game.printLetterByLetter(this.description);
    }
}
