package barba;

public class DynamicObject {
	
	public double x, y, width, height, speedX, speedY, netForceX, netForceY;
	public double gravity = 10;
	
	
	public DynamicObject(double x, double y, double width, double height, double speedX, double speedY, 
			double netForceX, double netForceY) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speedX = speedX;
		this.speedY = speedY;
		this.netForceX = netForceX;
		this.netForceY = netForceY;
	}
}
