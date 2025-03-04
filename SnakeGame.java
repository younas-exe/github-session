import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener {
    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int UNIT_SIZE = 25;
    private static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    private static final int DELAY = 150; // Adjust speed
    private final int x[] = new int[GAME_UNITS];
    private final int y[] = new int[GAME_UNITS];
    private int bodyParts = 6;
    private int applesEaten;
    private int appleX;
    private int appleY;
    private boolean running = false;
    private Timer timer;
    private char direction = 'R';
    private boolean gameOver = false;
    private int[][] obstacles;

    public SnakeGame() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        bodyParts = 6;
        applesEaten = 0;
        direction = 'R';
        running = true;
        gameOver = false;

        // Reset snake to start position
        for (int i = 0; i < bodyParts; i++) {
            x[i] = 50 - i * UNIT_SIZE;
            y[i] = 50;
        }

        newApple();
        generateObstacles();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            // Draw Apple
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            // Draw Obstacles
            g.setColor(Color.GRAY);
            for (int[] obs : obstacles) {
                g.fillRect(obs[0], obs[1], UNIT_SIZE, UNIT_SIZE);
            }

            // Draw Snake
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(new Color(45, 180, 0)); // Dark green
                }
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }

            // Draw Score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Ink Free", Font.BOLD, 30));
            g.drawString("Score: " + applesEaten, 10, 30);
        } else {
            gameOverScreen(g);
        }
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U' -> y[0] -= UNIT_SIZE;
            case 'D' -> y[0] += UNIT_SIZE;
            case 'L' -> x[0] -= UNIT_SIZE;
            case 'R' -> x[0] += UNIT_SIZE;
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        // Check if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        // Check if head collides with walls
        if (x[0] < 0 || x[0] >= SCREEN_WIDTH || y[0] < 0 || y[0] >= SCREEN_HEIGHT) {
            running = false;
        }

        // Check if head collides with obstacles
        for (int[] obs : obstacles) {
            if (x[0] == obs[0] && y[0] == obs[1]) {
                running = false;
            }
        }

        if (!running) {
            gameOver = true;
            timer.stop();
        }
    }

    public void newApple() {
        Random random = new Random();
        appleX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        appleY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
    }

    public void generateObstacles() {
        Random random = new Random();
        obstacles = new int[5][2]; // 5 obstacles
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i][0] = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
            obstacles[i][1] = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        }
    }

    public void gameOverScreen(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 50));
        g.drawString("Game Over", SCREEN_WIDTH / 3, SCREEN_HEIGHT / 2 - 50);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        g.drawString("Press 'R' to Restart", SCREEN_WIDTH / 3, SCREEN_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') direction = 'L';
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') direction = 'R';
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') direction = 'U';
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') direction = 'D';
                    break;
                case KeyEvent.VK_R:
                    if (gameOver) {
                        restartGame();
                    }
                    break;
            }
        }
    }

    public void restartGame() {
        startGame();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}