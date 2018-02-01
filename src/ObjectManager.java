import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship ship;

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
		for (Alien a : alien) {
			if (a.isAlive == false) {
				alien.remove(a);
			}
		}
		for (Projectile p : project) {
			if (p.isAlive == false) {
				project.remove(p);
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
		
		}
	
			}
		}
	}

}
