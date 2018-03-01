import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {

	final static int wHeight = 800;
	final static int wWidth = 500;

	JFrame window;
	GamePanel gp;

	public static void main(String[] args) {
		LeagueInvaders li = new LeagueInvaders();
		li.setup();
	}

	public LeagueInvaders() {
		window = new JFrame();
		gp = new GamePanel();

	}

	public void setup() {
		window.add(gp);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(wWidth, wHeight);
		window.getContentPane().setPreferredSize(new Dimension(wWidth, wHeight));
		window.addKeyListener(gp);

		gp.startGame();
	}

}
