package barba;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Hero extends DynamicObject{

	private Image heroImage;
	
	
	

	public Hero(double x, double y, double width, double height, double speedX, double speedY, 
											double netForceX, double netForceY) {
		
		super(x, y, width, height, speedX, speedY, netForceX, netForceY);
		
		try {
			heroImage = ImageIO.read(getClass().getResource("barbapapa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void render(Graphics2D g){
		
		g.translate(x, y);
		
		int width = heroImage.getWidth(null);
		int height = heroImage.getHeight(null);
		
		height = height/2;
		width = width/2;
		
		if(gravity < 0){
			g.rotate(Math.PI);
			g.drawImage(heroImage, -width, -height, width, height, null);
		}
				
		else{
			g.setColor(Color.RED);
			g.drawRect(0, 0, width, height);
			g.drawImage(heroImage, 0, 0, width, height, null);
		}
		g.translate(-x, -y);
	}
		
	
	
	public void update(double delta, Controller controller) {
		delta = delta/1000;
		setSpeedX(0);
		setSpeedY(getSpeedY()+gravity*delta);
		
		
		
		
		rightButton(controller, delta);
		
		leftButton(controller, delta);
		
		downButton(controller, delta);
		
		upButton(controller, delta);
		
		spaceButton(controller, delta);
		
//		System.out.println(x);
		
		x += getSpeedX();
		y += getSpeedY();
		
		if(y > 538){
			speedY = 0;
			y = 538;
		}
		
		if(y < 10){
			speedY = 0;
			y = 10;
		}
		
		if(x < 10){
			x = 10;
		}
		
		if(x > 755){
			x = 755;
		}
	}
	public boolean checkHit(){
		
		
		
		return false;
	}
	
	private void spaceButton(Controller controller, double delta) {
		
		if(controller.characters[KeyEvent.VK_SPACE] && !controller.pressed){
			gravity = gravity*-1;
			controller.pressed = true;	
		}
	}

	private void upButton(Controller controller, double delta) {
		
		if(y >=538 && controller.characters[KeyEvent.VK_UP]){
			setSpeedY(-10);	
		}		
	}

	private void downButton(Controller controller, double delta) {
		
		if(controller.characters[KeyEvent.VK_DOWN]){
			
			if(getSpeedY() == 0){
				setSpeedY(10);
			}
		}
	}

	private void leftButton(Controller controller, double delta) {
		
		if(controller.characters[KeyEvent.VK_LEFT]){
			setSpeedX(-3);
		}
	}

	private void rightButton(Controller controller, double delta) {
		if(controller.characters[KeyEvent.VK_RIGHT]){
			setSpeedX(3);
		}
	}
	
	public Image getHeroImage() {
		return heroImage;
	}
}
