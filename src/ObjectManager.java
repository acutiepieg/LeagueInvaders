import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship ship;
	int score;

	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	ArrayList<Projectile> project = new ArrayList<Projectile>();
	ArrayList<Alien> alien = new ArrayList<Alien>();

	public void addProjectile(Projectile p) {
		project.add(p);
	}

	public void addAlien(Alien a) {
		alien.add(a);
	}

	ObjectManager(Rocketship ship) {
		this.ship = ship;
		score = 0;
	}

	public void update() {
		ship.update();
		for (Projectile p : project) {
			p.update();
		}
		for (Alien a : alien) {
			a.update();
		}
	}

	public void draw(Graphics g) {
		ship.draw(g);
		for (Projectile p : project) {
			p.draw(g);
		}
		for (Alien a : alien) {
			a.draw(g);
		}
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.wWidth), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < project.size(); i++ ) {
			if(project.get(i).isAlive == false) {
				project.remove(i);
			}
		}
		
		for (int i = 0; i < alien.size(); i++) {
		if(alien.get(i).isAlive == false) {
			alien.remove(i);
		}
		}
			
		}
	
	public void checkCollision() {
		for (Alien a : alien) {
			if (ship.collisionBox.intersects(a.collisionBox)) {
				ship.isAlive = false;
			}

			for (Projectile p : project) {
				if (a.collisionBox.intersects(p.collisionBox)) {
					a.isAlive = false;
					score ++;
		}
	
			}
		}
	}
	
	public int getScore(int score) {
		return score;
		
	}

}
