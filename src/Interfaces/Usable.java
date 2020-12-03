package Interfaces;

import Characters.*;

public interface Usable {
	void use(Hero h) throws InterruptedException;
	void use(Hero h, String s);
}
