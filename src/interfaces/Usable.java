package interfaces;

import characters.*;

//This interface is for Objs usable
public interface Usable {
	void use(Hero h);
	void use(Hero h, String s); // use for conbined objects
}
