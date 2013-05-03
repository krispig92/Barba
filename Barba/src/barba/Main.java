package barba;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;


import java.awt.Canvas;


public class Main extends Canvas implements Runnable {
	
	private static final int WINDOW_WIDTH = 800; 
	private static final int WINDOW_HEIGHT = 600;
	
	private boolean isOccupied[][] = new boolean[WINDOW_WIDTH][WINDOW_HEIGHT];
	private boolean running = false;
	
	private Hero hero;
	private Controller controller;
	private Box box;
	

	public Main() {
		
		setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setPreferredSize(getMinimumSize());
		setMaximumSize(getMinimumSize());
		
		controller = new Controller(this);
		hero = new Hero(10, 10, 10, 10, 10, 10, 10, 10);
		box = new Box(100, 100, 50, 50);
		addBoxToArray(box);					//lägger till koordinater till array
		
	}

	private void render(){
		BufferStrategy bs = getBufferStrategy();
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_WIDTH);
		
		box.render(g);
		hero.render(g);
		
		heroHitTest();
		
		bs.show();
	}
	
	private void update(double delta){
		hero.update(delta, controller);
	}
	
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Barba, The Game!");
		Main main = new Main();
		window.add(main);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		main.start();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void start() {
		if(! running) {
			createBufferStrategy(2);
			Thread t = new Thread(this);
			running = true;
			t.start();
		}
	}
	
	public void run() {
		long delta = 0;
		
		while(running) {
			long now = System.currentTimeMillis();
			update(delta);
			render();
			System.out.println(16-delta);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			delta = System.currentTimeMillis() - now;
		}
	}
	
	public void addBoxToArray(Box box){
		for (int i = box.getX(); i < box.getWidth(); i++) {
			for (int j = box.getY(); j < box.getHeight(); j++) {
				isOccupied[i][j] = true;
			}
		}
	}
	
	
//	public void heroHitTest(){
		int width = 0;
		width = (int)(hero.getWidth()+hero.getX());
		width += hero.x; 
		int height = (int)(hero.getHeight()+hero.getY());
		width += hero.y;
		
		System.out.println(width);
		
		if(isOccupied[(int)hero.getX()][(int)hero.getY()] || isOccupied[width][height]){
			hero.setX(hero.getX()-10);
		}
	}

}
