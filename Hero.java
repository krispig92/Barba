package barba;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Hero extends DynamicObject{

	public Hero(double x, double y, double width, double height, double speedX, double speedY, 
											double netForceX, double netForceY) {
		
		super(x, y, width, height, speedX, speedY, netForceX, netForceY);
	}
	
	public void render(Graphics2D g){
		
		g.setColor(Color.YELLOW);
		g.drawOval(5, 5, 5, 5);
		
	
	}
	
	public void update() {
		
	}
}
