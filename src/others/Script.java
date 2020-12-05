package others;

public class Script {

    public static final String DEFAULT_NARRATOR = "GUID VOICE";

    // === WELCOME MESSAGES ===

    public static final String WELCOME_MESSAGE =
            "\n\n\n\t\t=========================================  WELCOME  ==========================================" +
            "\n\t\t==                                                                                          ==" +
            "\n\t\t==  Hello and welcome to our game The Colossal Caveman Adventure.                           ==" +
            "\n\t\t==  This game is the product of many hours of work and deserves to be fully appreciated.    ==" +
            "\n\t\t==  Therefore if you are reluctant to a little dirty humor, if you hate bad scenarios       ==" +
            "\n\t\t==  or if you have a heavy history with Nazism: DO NOT PLAY THIS GAME !                     ==" +
            "\n\t\t==  Conversely, we wish you a good game and hope for a good return.                         ==" +
            "\n\t\t==                                                                                          ==" +
            "\n\t\t==============================================================================================";

    public static final String SYNOPSIS =
            "\n\n\n\t\t=====================================  SYNOPSIS  =======================================" +
            "\n\t\t==                                                                                    ==" +
            "\n\t\t== A caveman found frozen in the Arctic during 1984.                                  ==" +
            "\n\t\t== A team of Nazis researchers thaws it and took him prisoner of their laboratory.    ==" +
            "\n\t\t== You play this man and your goal is to escape from here alive...                    ==" +
            "\n\t\t==                                                                                    ==" +
            "\n\t\t========================================================================================" +
            "\n\n\t\tWrite : help, and press enter to get the list of available commands\n\n";

    //BEGIN
    public static final String NAZI_BLAHBLAH = "Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah\n" +
                                               doSpaces("Nazi Researcher") + "Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah\n" +
                                               doSpaces("Nazi Researcher") + "Blah Blah Blah...(Nazi Blah Blah)\n\n";
    public static final String OTHER_NAZI_BLAHBLAH = "Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah\n" +
                                                     doSpaces("Other Nazi Researcher") + "Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah\n" +
                                                     doSpaces("Other Nazi Researcher") + "Blah Blah Blah ?\n\n";
    public static final String NAZI_JOKE = "Blah ? Blah Blah...BLAH ! (Nazi Joke)\n\n";
    public static final String NAZI_LAUGH = "HAACH HACH HACH HACH HACH HACH ! (Nazi Laugh)\n\n";
    public static final String CONTEXT_01 = "Wow, it's really cold in here...\n\n";
    public static final String CONTEXT_02 = "...You're hearing weird voices...\n\n";
    public static final String CONTEXT_03 = "Nazis leave the room\n\n";
    public static final String CONTEXT_04 = "You're finally waking up.";

    // === ENDING MESSAGES ===

    public static final String YOU_WIN =
            "\nYou managed to run away from the lab and escape those fucking Nazis ! You are free !\n" +
                    "\n36 years later you are the head of the stock exchange, rising star of cinema and " +
                    "\npresident of the United States of America. Women run after you and men envy you, you" +
                    "\nare voted the sexiest man in the world and your three children, Gaëtan, Benjamin and" +
                    "\nMathieu, have obtained a superb rating for their Java project.\n" +
                    "\n" +
                    "(Thanks for them...)\n\n";

    public static final String YOU_LOOSE = "\nI thought this game was easy, you suck on a keyboard...\nYou remind me of Psychology students ...\n";
    public static final String GAME_OVER = "\nYou will quit the game in 5 seconds...\nSee you later ";
    public static final String CREDITS =
            "\n\n\n\t\t======================== CREDITS ========================\n" +
            "\t\t=========================================================\n" +
            "\t\t===  SCENARIO :                                       ===\n" +
            "\t\t===                                 BENJAMIN CHEVAIS  ===\n" +
            "\t\t===                                   GAETAN FREJOUX  ===\n" +
            "\t\t===                                    MATHIEU NIORD  ===\n" +
            "\t\t===                                                   ===\n" +
            "\t\t===  STORYBOARD :                                     ===\n" +
            "\t\t===                                 BENJAMIN CHEVAIS  ===\n" +
            "\t\t===                                   GAETAN FREJOUX  ===\n" +
            "\t\t===                                    MATHIEU NIORD  ===\n" +
            "\t\t===                                                   ===\n" +
            "\t\t===  DEVELOPMENT :                                    ===\n" +
            "\t\t===                                 BENJAMIN CHEVAIS  ===\n" +
            "\t\t===                                   GAETAN FREJOUX  ===\n" +
            "\t\t===                                    MATHIEU NIORD  ===\n" +
            "\t\t===                                                   ===\n" +
            "\t\t===  SPECIAL GUESTS :                                 ===\n" +
            "\t\t===                                                   ===\n" +
            "\t\t===    IN THE ROLE OF HOUGA BOUGA :             YOU   ===\n" +
            "\t\t===                                                   ===\n" +
            "\t\t===    IN THE ROLE OF THE ACCOUNT GUY : AFIDA TURNER  ===\n" +
            "\t\t===    IN THE ROLE OF THE ZOMBIE NAZI : AFIDA TURNER  ===\n" +
            "\t\t===    IN THE ROLE OF THE SUPER-NAZI  : AFIDA TURNER  ===\n" +
            "\t\t===                                                   ===\n" +
            "\t\t===    ORIGINAL SOUND TRACK :         JONNY HALLIDAY  ===\n" +
            "\t\t===    COFFEE OFFICER :                        WOMAN  ===\n" +
            "\t\t===    OPERATIONS DIRECTOR :         THE RENDER DATE  ===\n" +
            "\t\t===                                                   ===\n" +
            "\t\t=========================================================\n" +
            "\t\t=========================================================\n";

    public static final String THANKING_PLAYER = "\n...WE THANK YOU FOR PARTICIPATING IN OUR PROJECT\n\n\n";


    // === BATTLE ===

    public static final String BATTLE_BEGIN = "\n=========== BAAAAAAAATTLE ===========\n\nYou come face to face with a ";

    public static final String BATTLE_HELP = "\n=========== LIST OF COMMANDS ===========\n - attack\n - heal\n\nBEWARE OF WHAT YOU'RE WRITING OR YOU COULD HAVE A BAD PRESENT...\n\n";

    // === HERO ===
    public static final String ANGRY_HERO = "HOOOUGA BOOUGAAA !\n";


    // === ANIMALS ===

    //Cat
    public static final String CAT_TEXT01 = "Meeeeew mew meeew mew\n";

    public static final String CAT_TEXT02 = "Hello where are you from I came from Germany.\n" +
            doSpaces("Cat") +  "I saw all those \"glorious soldier\" who left you here.\n" +
            doSpaces("Cat") +  "They laughed and the boss said you were a stupid frenchy\n" +
            doSpaces("Cat") +  "caveman who could never find a way out of this mansion !\n" +
            doSpaces("Cat") +  "Another said that for sure no one will find the password\n" +
            doSpaces("Cat") +  "because it is too smart, two letters I ... T. IT, IT, IT\n" +
            doSpaces("Cat") +  "is the password !\n" +
            doSpaces("Cat") +  "What a funny password, who came up with this great idea ?\n" +
            doSpaces("Cat") +  "Definitely someone in a psychology degree course, haha, of\n" +
            doSpaces("Cat") +  "course you have to be smart and quirky if you want to come\n" +
            doSpaces("Cat") +  "up with those kinds of passwords or become a Nazi.\n";

    public static final String CAT_DESCRIPT = "Ohw easy man ! It's one of those Nazi cats !\n";

    //Mouse
    public static final String MOUSE_TEXT01 = "krrih krrih…\n";

    public static final String MOUSE_TEXT02 = "Hey handsome ! Are you alone ? You look well built but obviously not very\n" +
            doSpaces("Mouse") +  "smart. Are you in a psychology cursus ? Haha, I’m kidding, or...not ? Are\n" +
            doSpaces("Mouse") +  "you homeless ? Hmm…no matter ! The password is \"S A GREAT\". I heard about\n" +
            doSpaces("Mouse") +  "a potion that would make gas invulnerable in this room. Bye, come see me later.\n";

    public static final String MOUSE_DESCRIPT = "A simple lab mouse locked in its cage. Looks like she's a female.\n";

    //Monkey
    public static final String MONKEY_TEXT01 = "Houhou HahaHaAAA !\n";

    public static final String MONKEY_TEXT02 = "Wuts’up bru ? Com’on u saw all da shit ? Wtf !? I’m a f***ing monky in a\n" +
            doSpaces("Monkey") +  "f***ing mansion in da f***ing 80’s with da return of da f***ing Nazis :\n" +
            doSpaces("Monkey") +  "wut da hell bru ? No waaay a die here ! and u know wut ma man ? A’m starving\n" +
            doSpaces("Monkey") +  "ike a wulf, yep ! Go find me nice food and a give u da password u need for\n" +
            doSpaces("Monkey") +  "escaping those bastards.\n";

    public static final String MONKEY_TEXT03 = "R u kiddin ? u thoght a m a stoopid “cartoon monky” bro ? oh, a see, ‘cause\n" +
            doSpaces("Monkey") +  "a m black… r u a f***ing racist ? … Wait a minute… dat’s not food dumbass,\n" +
            doSpaces("Monkey") +  "it’s a GOLD BANANA !? eh u know wut, a give u da password but only ‘cause\n" +
            doSpaces("Monkey") +  "a m better than u, u know wut u deserve ? dat a grab ma own shit and throw it\n" +
            doSpaces("Monkey") +  "in ur face. Password is GAME, u understand ? u r in da game, in ma game, mine\n" +
            doSpaces("Monkey") +  "not urs ! Pshht, go away !\n";

    public static final String MONKEY_DESCRIPT = "Do you know this monkey ? He calls you with great gestures. Maybe he's family ?\n";


    // === ENNEMIES ===

    //Account Guy
    public static final String ACCOUNTGUY_DEFAULT = "H1 1'M 7H3 4CC0UN7 9UY ! Y0U W4N7 70 83 MY FR13ND ?\n";
    public static final String ACCOUNTGUY_ATTACK = "1'M 83773R 7H4N Y0U ! D13 57000P1D !\n";
    public static final String ACCOUNTGUY_DEFEAT = "4444RRR9H = 1\n";
    public static final String ACCOUNTGUY_DESCRIPT = "He seems lonely, certainly the ACCOUNT GUY. Even Nazis don't understand him.\n";

    //Zombie
    public static final String ZOMBIE_DEFAULT  = "Grrrr…\n";
    public static final String ZOMBIE_ATTACK = "Grrrr…\n";
    public static final String ZOMBIE_DEFEAT = "Aaaaarghrrgrr...\n";
    public static final String ZOMBIEDESCRIPT = "So it was true, the Nazis created zombies ?! However, we are in the 80s, beware of the clichés.\n";

    //Final Boss
    public static final String BOSS_DEFAULT = "Blablablablablablablabla\n";
    public static final String BOSS_ATTACCK = "BlablablACHTUNG !\n";
    public static final String BOSS_DEFEAT = "AAAaarrrgh sooo...\n";
    public static final String BOSS_DESCRIPT = "Wow, what a big and strong man ! He's certainly a kind of final boss...\n";


    // === OBJECTS ===
    
    //Names
    public static final String DEFAULT_CLUB_NAME = "club";
    public static final String DEFAULT_KEY1_NAME = "key_01";
    public static final String DEFAULT_KEY2_NAME = "exit_key";
    public static final String DEFAULT_FUSE_NAME = "missing_fuse";
    public static final String DEFAULT_STICK_NAME = "stick";
    public static final String DEFAULT_FLINT_NAME = "flint";
    public static final String DEFAULT_POTION_NAME = "potion";
    public static final String DEFAULT_BANANA_NAME = "banana";
    public static final String DEFAULT_LOCKER_NAME = "locker";
    public static final String DEFAULT_WALKMAN_NAME = "walkman";
    public static final String DEFAULT_FIREDSTICK_NAME = "fired_stick";
    public static final String DEFAULT_NAZIPOSTER_NAME = "nazi_poster";
    public static final String DEFAULT_SEXYPOSTER_NAME = "sexy_poster";
    public static final String DEFAULT_BESCHERELLE_NAME = "bescherelle";
    public static final String DEFAULT_ELECTRICMETER_NAME = "electric_meter";

    //Descriptions
    public static final String KEY_DESCRIPT = "It's just a key...which can open doors or something, basic !\n";
    public static final String POTION_DESCRIPT = "It looks like a mystic solution.\n";
    public static final String ELECTRICMETER_DESCRIPT ="This electric meter is in operation\n";
    public static final String BANANA_DESCRIPT = "Looks like a banana straight from the 70s.\n";
    public static final String BESCH_DESCRIPT = "An artifact that holds the greatest of powers.\n";
    public static final String FLINT_DESCRIPT = "Just a stone that fell out of your underpants.\n";
    public static final String CLUB_DESCRIPT = "Wow ! Thanks this you're gonna destroy all those creepies\n";
    public static final String SEXY_POSTER = "A poster of a seeexy woman. Yum, what a beauty !\n";
    public static final String ELECTRICMETER_MISSING_DESCRIPT ="A fuse is missing on this electric meter\n";
    public static final String FUSE_DESCRIPT = "It should allow you to restore the power, if only you know how...\n";
    public static final String NAZI_POSTER = "You are looking at this poster. What a ugly Nazi face...\n";
    public static final String STICK_DESCRIPT = "A very basic stick. The researchers may have used it for experiments...\n";
    public static final String FIRED_STICK_DESCRIPT = "The door of the morgue seems dry and this stick is on fire. Try to go through the door to see what gonna happen\n";
    
    
    // === HELP COMMANDS ===

    public static final String HELP_DEFAULT = "List of commands :" +
            "\n- go (location)" +
            "\n- help" +
            "\n- look (Object)" +
            "\n- take (Object)" +
            "\n- use (Object)" +
            "\n- use (Object) (Object)" +
            "\n- inventory" +
            "\n- talk (Somebody)" +
            "\n- quit";

    public static String doSpaces(String size){
        int spaces = size.length() + 3;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < spaces; i++){
            s.append(" ");
        }
        return s.toString();
    }
}
