import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rocketship extends GameObject {
int speed;
	boolean right;
	boolean left;
	boolean up;
	boolean down;
	
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
	speed = 5;
	right = false;
	left = false;
	up = false;
	down = false;
	}

	public void update() {
	super.update();
		if(right == true) {
	x += speed;
}
else if(left == true) {
	x -= speed;
}
else if(up == true) {
	y -= speed;
}
else if(down == true) {
	y += speed;
}
	}
	public void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

	}

}
