package characters;

import others.*;
import objects.*;
import interfaces.*;

public class Enemy implements Lookable {

    
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
    private boolean healed = false;
    //Je pensais ajouter un healcounter de manière à ce que l'ennemi puisse se soigner un certain nb de fois au cours du combat


    // ***** CONSTRUCTOR *****

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


    // === GETTER ===

    //On souhaite savoir si l'ennemi a perdu
    public boolean isDefeat() {
        if (this.hp <= 0) {
            this.state = false;
        }
        return !this.state;
    }

    //On souhaite savoir si l'ennemi s'est déjà soigné
    public boolean isHealed() {
        return this.healed;
    }

    //On souhaite connaître les points de vies restants de l'ennemi
    public int getHP() {
        return this.hp;
    }

    //On souhaite connaître les dégâts d'attaque de l'ennemi
    public int getDamage() {
        return this.damage;
    }

    //On souhaite connaître l'objet que possède l'ennemi
    public Obj getItem() {
        return this.item;
    }


    // === SETTER ===

    public void takeDamage(int damage) {
        if (this.hp > 0 && this.state) {
            this.hp -= damage;
        }
        else if (hp <= 0 && this.state) {
            this.state = false;
            this.defeat();
        }
    }

    public void heal(int heal) {
        if (this.state && this.hp > 0) {
            this.hp += heal;
            System.out.print("\n" + this.NAME + " healed itself.\n" + this.NAME + " gain " + heal + " HP.\n");
        }
    }

    public void loot(){
        this.item=null;
    }

    // === DISPLAY ===

    public void opening() {
        Game.printLetterByLetter(this.opening, this.NAME);
    }

    public void attack() {
        Game.printLetterByLetter(this.attack, this.NAME);
    }

    public void defeat() {
        Game.printLetterByLetter(this.defeat, this.NAME);
    }

    public void descript() {
        Game.printLetterByLetter(this.description, this.NAME);
    }


    // === COMMANDS ===

    public void look() {
        Game.printLetterByLetter(this.description, Script.DEFAULT_NARRATOR);
    }

}
