import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	public void update() {
		y++;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.drawRect(x, y, width, height);

}
}