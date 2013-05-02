package barba;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends StaticObject {

	public Block(int x, int y, int width, int height) {
		super(x,y,width,height);
		
	}
	public void render(Graphics2D g){
		
		
		g.drawRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		
	}

}
