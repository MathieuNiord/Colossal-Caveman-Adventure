package Interfaces;

import Characters.*;

public interface Usable {
	public void use(Hero h) throws InterruptedException;
	public void use(Hero h, String s);
}
