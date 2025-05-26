import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class SnakeGame extends JFrame {
public static final int TILE_SIZE = 30,WIDTH = 20, HEIGHT = 20;
public int[] x = new int[100];
public int[] y = new int[100];
public int bodyParts = 3,foodX, foodY;
public char direction = 'R';
public boolean running = false;
public Timer timer;
private Random random;
public SnakeGame() {
random = new Random();
this.setTitle("Snake Game By Nikhil-Coder2k25");
this.setSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setResizable(false);
this.addKeyListener(new KeyAdapter() {
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
}
    }
        });
newFood();
running = true;
timer = new Timer(100, e -> {
if (running) {
move();
checkFood();
checkCollisions();
}
repaint();
});
timer.start();
this.setVisible(true);
}
public void paint(Graphics g) {
super.paint(g);
if (running) {
g.setColor(Color.BLACK);
g.fillOval(foodX * TILE_SIZE, foodY * TILE_SIZE, TILE_SIZE, TILE_SIZE);
for (int i = 0; i < bodyParts; i++) {
if (i == 0) 
g.setColor(Color.BLACK);
else 
g.setColor(new Color(45, 180, 0));
g.fillRect(x[i] * TILE_SIZE, y[i] * TILE_SIZE, TILE_SIZE, TILE_SIZE);
}
} else gameOver(g);
}
private void move() {
for (int i = bodyParts; i > 0; i--) {
x[i] = x[i - 1];
y[i] = y[i - 1];
}
switch (direction) {
case 'U': 
y[0]--; 
break;
case 'D': 
y[0]++; 
break;
case 'L': 
x[0]--; 
break;
case 'R': 
x[0]++; 
break;
}
}
private void checkFood() {
if (x[0] == foodX && y[0] == foodY) {
bodyParts++;
newFood();
}
}
private void newFood() {
foodX = random.nextInt(WIDTH);
foodY = random.nextInt(HEIGHT);
}
private void checkCollisions() {
for (int i = bodyParts; i > 0; i--) {
if (x[0] == x[i] && y[0] == y[i]) running = false;
}
if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) running = false;
if (!running) timer.stop();
}
private void gameOver(Graphics g) {
g.setColor(Color.BLUE);
g.setFont(new Font("Arial", Font.BOLD, 30));
g.drawString("Game Over", WIDTH * TILE_SIZE / 3, HEIGHT * TILE_SIZE / 4);
g.drawString("Nikhil-Coder2k25", WIDTH * TILE_SIZE / 4, HEIGHT * TILE_SIZE / 3);
}
public static void main(String[] args) {
new SnakeGame();
}
}