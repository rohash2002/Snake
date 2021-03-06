package pgdp.Snake;

import java.awt.Color;
import java.awt.Point;

public class SnakeHead extends SnakeElement {

	private double direction = 0;

	public SnakeHead(Color color, Point position) {
		super(color, position);
		// TODO Auto-generated constructor stub
	}

	public synchronized double getDirection() {
		return direction;
	}

	public synchronized void setDirection(double direction) {
		this.direction = direction;
	}

}
