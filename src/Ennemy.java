public abstract class Ennemy {

    // ***** CONSTANTS *****
    private final int DEFAULT_HP = 30;
    private final int DEFAULT_DAMAGE = 7;

    // ***** ATTRIBUTES *****

    private int hp;
    private int damage;
    private Obj item; //C'est l'objet que l'ennemi va loot à la fin du combat
    private boolean state; //true = vivant
    private String opening;
    private String attack;
    private String defeat;

    // ***** CONSTRUCTORS *****

    Ennemy(Obj loot){
        this.hp = DEFAULT_HP;
        this.damage = DEFAULT_DAMAGE;
        this.item = loot;
    }

    Ennemy(int hp, int atk, Obj loot){
        this.hp = hp;
        this.damage = atk;
        this.item = loot;
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

    public void damage(int damage){
        this.hp -= damage;
    }

    public void Heal(int heal){
        this.hp += heal;
    }

    public void Kill(){
        this.state = false;
    }

    public void Loot(){
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
}
