package interfaces;

import characters.*;

public interface Usable {
	void use(Hero h) throws InterruptedException;
	void use(Hero h, String s);
}
