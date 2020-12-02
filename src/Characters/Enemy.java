package Characters;

import Others.*;
import Objects.*;
import Interfaces.*;

public class Enemy implements Lookable {

    // ***** CONSTANTS *****
    private static final int DEFAULT_HP = 30;
    private static final int DEFAULT_DAMAGE = 7;
    private static final String DEFAULT_NAME = "Ennemy_TEST";

    // ***** ATTRIBUTES *****

    public final String NAME;
    private int hp;
    private final int damage;
    private Obj item; //C'est l'objet que l'ennemi va loot à la fin du combat
    private boolean state = true; //true = vivant
    private final String opening;
    private final String attack;
    private final String defeat;
    private final String description;
    //Je pensais ajouter un healcounter de manière à ce que l'ennemi puisse se soigner un certain nb de fois au cours du combat

    // ***** CONSTRUCTORS *****

    public Enemy(String name, int hp, int dmg, Obj loot, String op, String atk, String dft, String desc) {
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
    public int getHP() {
        return this.hp;
    }

    //On souhaite connaître les dégâts d'attaque de l'ennemi
    public int getDamage() {
        return this.damage;
    }

    //On souhaite savoir si l'ennemi a perdu
    public boolean isDefeat() {
        if (this.hp <= 0) {
            this.state = false;
        }
        return !this.state;
    }

    //On souhaite connaître l'objet que possède l'ennemi
    public Obj getItem() {
        return this.item;
    }

    // Setter

    public void takeDamage(int damage) throws InterruptedException {
        if (this.hp > 0 && this.state) {
            this.hp -= damage;
        }
        else if (hp <= 0 && this.state) {
            this.state = false;
            Game.printLetterByLetter(this.defeat);
        }
    }

    public void Heal(int heal) {
        if (this.state && this.hp > 0) {
            this.hp += heal;
        }
    }

    public void Loot() {
        //TODO drop l'item au joueur
        this.item = null;
    }

    // Display

    public void opening() throws InterruptedException {
        Game.printLetterByLetter(this.opening);
    }

    public void attack() throws InterruptedException {
        Game.printLetterByLetter(this.attack);
    }

    public void defeat() throws InterruptedException {
        Game.printLetterByLetter(this.defeat);
    }
    
    public void look() throws InterruptedException {
        Game.printLetterByLetter(this.description);
    }
}
