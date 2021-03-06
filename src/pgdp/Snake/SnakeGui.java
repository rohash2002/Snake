package pgdp.Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeGui extends JFrame implements KeyListener {

	private final JPanel panel;
	private final Snake snake;

	public SnakeGui(Snake snake, int size) {
		super("Snake Game");
		this.snake = snake;
		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				snake.body.stream().forEach(element->{
					
				});
			}
		};
		panel.setBackground(Color.DARK_GRAY);
		panel.setPreferredSize(new Dimension(size, size));
		add(panel);
		pack();
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

	}

	public void runGame() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT -> turnTo(0);
		case KeyEvent.VK_UP -> turnTo(90);
		case KeyEvent.VK_LEFT -> turnTo(180);
		case KeyEvent.VK_DOWN -> turnTo(270);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void turnTo(double dir) {

	}
}
