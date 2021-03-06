package pgdp.Snake;

import java.awt.*;

public class SnakeElement {
	private final Color color;
	private Point position;

	public SnakeElement(Color color, Point position) {
		this.color = color;
		this.position = position;

	}

	public Point getPosition() {
		return position;
	}

	public Color getColor() {
		return color;
	}

}
