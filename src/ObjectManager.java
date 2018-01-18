import java.awt.Graphics;

public class ObjectManager {

	Rocketship ship;
	Array
	
	public ObjectManager(Rocketship ship) {
	this.ship = ship;
}

public void update() {
	ship.update();
}
public void draw(Graphics g) {
	ship.draw(g);
}


}
