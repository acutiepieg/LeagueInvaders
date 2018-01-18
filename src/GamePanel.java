import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Font titleFont;
	Font startFont;
	GameObject go;
	Rocketship rs;
	ObjectManager om;
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;

	int currentState = MENU_STATE;

	public GamePanel() {
		rs = new Rocketship(250, 700, 50, 50);
om = new ObjectManager(rs);
		timer = new Timer(1000 / 60, this);
		go = new GameObject(100, 100, 100, 100);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		startFont = new Font("Arial", Font.PLAIN, 28);

	}

	public void startGame() {
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();

		}
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		go.draw(g);
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState == END_STATE) {
				currentState = MENU_STATE;
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rs.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rs.left = true;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			rs.up = true;
		}  else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rs.down = true;
		}
	
	} 	
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			rs.right = false;

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rs.left = false;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			rs.up = false;
		}else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rs.down = false;
		}
	}

	public void updateMenuState() {

	}

	public void updateGameState() {
om.update();
		
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.wWidth, LeagueInvaders.wHeight);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("League Invaders", 75, 200);
		g.setFont(startFont);
		g.drawString("Press ENTER to start", 115, 320);
		g.drawString("Press SPACE to get instructions", 49, 440);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, LeagueInvaders.wWidth, LeagueInvaders.wHeight);
		om.draw(g);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.wWidth, LeagueInvaders.wHeight);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 100, 200);
		g.setFont(startFont);
		g.drawString("You killed 0 enemies", 115, 320);
		g.drawString("Press ENTER to restart", 110, 440);
	}
}
