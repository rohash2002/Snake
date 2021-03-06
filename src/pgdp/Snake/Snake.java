package pgdp.Snake;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;

public class Snake {

	SnakeHead head;
	Queue<SnakeElement> body;

	public Snake() {
		body = new ArrayDeque<>();
		head = new SnakeHead(Color.cyan, new Point(0, 0));
	}

	public void walk() {

	}

	public void spawnApple() {

	}
	
	private void moveHead() {
		
		head.getPosition().x++;
		
		
	}
	
	private void moveBody() {
		
	}
	
	private void turnTo(double direction) {
		
	}
	
	

}

class Apple {
	private final Color color;
	private Point position;

	public Apple(Point position) {
		color = Color.red;
		this.position = position;

	}

	public Point getPosition() {
		return position;
	}

}