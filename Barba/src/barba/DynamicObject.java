package barba;

public class DynamicObject {
	
	public double x, y, width, height, speedX, speedY, netForceX, netForceY;
	
	public double gravity = 20;
	
	
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
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public double getNetForceX() {
		return netForceX;
	}

	public void setNetForceX(double netForceX) {
		this.netForceX = netForceX;
	}

	public double getNetForceY() {
		return netForceY;
	}

	public void setNetForceY(double netForceY) {
		this.netForceY = netForceY;
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
}
