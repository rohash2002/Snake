package pgdp.Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
				snake.body.stream().forEach(element -> {
					g.setColor(element.getColor());
					g.fillOval(50 * element.getPosition().x, 50 * element.getPosition().y, 50, 50);
				});
				g.setColor(snake.apple.getColor());
				g.fillOval(50 * snake.apple.getPosition().x, 50 * snake.apple.getPosition().y, 50, 50);
				g.setColor(snake.head.getColor());
				g.fillOval(50 * snake.head.getPosition().x, 50 * snake.head.getPosition().y, 50, 50);
			}
		};
		panel.setBackground(Color.DARK_GRAY);
		panel.setPreferredSize(new Dimension(300, 300));
		add(panel);
		pack();
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		this.addKeyListener(this);

	}

	public static void main(String[] args) {
		SnakeGui gui = new SnakeGui(new Snake(), 10);
		gui.runGame();
	}

	public void runGame() {
		while (true) {
			int frequency = 250;
			panel.repaint();
			snake.walk();
			if (snake.body.stream().anyMatch(element -> element.getPosition().equals(snake.head.getPosition())))
				break;
			try {
				Thread.sleep(frequency);
			} catch (InterruptedException e) {
			}
		}
		lose();
	}

	private void lose() {
		JFrame loser = new JFrame("YOU LOSE");
		loser.setBounds(500,300,250,100);
		JLabel tf = new JLabel("GAME OVER. Your final score: " + snake.body.size());
		loser.add(tf);
		loser.setVisible(true);
		loser.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT -> turnTo(0);
		case KeyEvent.VK_UP -> turnTo(270);
		case KeyEvent.VK_LEFT -> turnTo(180);
		case KeyEvent.VK_DOWN -> turnTo(90);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void turnTo(double dir) {
		snake.turnTo(dir);
	}
}
