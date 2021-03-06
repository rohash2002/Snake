package pgdp.Snake;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;

public class Snake {

	SnakeHead head;
	Queue<SnakeElement> body;
	Apple apple;

	public Snake() {
		body = new ArrayDeque<>();
		head = new SnakeHead(Color.cyan, new Point(0, 0));
		apple = spawnApple();
	}

	public void walk() {

		if (head.getPosition().equals(apple.getPosition())) {
			body.add(new SnakeElement(Color.green, new Point(head.getPosition().x, head.getPosition().y)));
			apple = spawnApple();
		}
		moveBody();
		moveHead();

	}

	public Apple spawnApple() {
		return null;
	}

	private void moveHead() {

		head.getPosition().x += Math.sin(Math.toRadians(head.getDirection()));
		head.getPosition().y += Math.sin(Math.toRadians(head.getDirection()));

	}

	private void moveBody() {

		body.add(new SnakeElement(Color.green, new Point(head.getPosition().x, head.getPosition().y)));
		body.remove();

	}

	private void turnTo(double direction) {

		if (head.getDirection() + 180 == direction || head.getDirection() - 180 == direction) {
			return;
		} else
			head.setDirection(direction);
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