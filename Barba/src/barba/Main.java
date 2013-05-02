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
	
	private boolean running = false;
	
	private Hero hero;
	

	public Main() {
		
		setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setPreferredSize(getMinimumSize());
		setMaximumSize(getMinimumSize());
		
		hero = new Hero(10, 10, 10, 10, 10, 10, 10, 10);
		
	}

	private void render(){
		BufferStrategy bs = getBufferStrategy();
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_WIDTH);
		
		hero.render(g);
		
		bs.show();
	}
	
	private void update(float delta){
		hero.update();
	}
	
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Barba!");
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
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			delta = System.currentTimeMillis() - now;
		}
	}

}
