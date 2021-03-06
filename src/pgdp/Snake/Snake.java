package pgdp.Snake;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class Snake {

	SnakeHead head;
	Queue<SnakeElement> body;
	Apple apple;

	public Snake() {
		body = new ArrayDeque<>();
		head = new SnakeHead(Color.MAGENTA, new Point(0, 0));
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
		Random rand = new Random();
		Point[] tmp = new Point[1];
		do {
			tmp[0] = new Point(rand.nextInt(15), rand.nextInt(12));
		} while (body.stream().anyMatch(element -> element.getPosition().equals(tmp[0])));
		return new Apple(tmp[0]);
	}

	private void moveHead() {
//		head.getPosition().x += Math.sin(Math.toRadians(head.getDirection()));
//		head.getPosition().y += Math.sin(Math.toRadians(head.getDirection()));
		if(Math.abs(head.getDirection()-90)<0.05)
			head.getPosition().y++;
		else if(Math.abs(head.getDirection()-180)<0.05)
			head.getPosition().x--;
		else if(Math.abs(head.getDirection()-270)<0.05)
			head.getPosition().y--;
		else head.getPosition().x++;
			
	}

	private void moveBody() {
		body.add(new SnakeElement(Color.green, new Point(head.getPosition().x, head.getPosition().y)));
		body.remove();
	}

	public void turnTo(double direction) {
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
	public Color getColor() {
		return color;
	}

}