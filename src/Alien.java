import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	public void update() {
		super.update();
		y = y  + 5;
	}
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
}
}