import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeWindow extends JPanel implements ActionListener{

    public static JFrame JFrame;

    public static final int SCALE = 32;
    public static final int WIDTH = 16;
    public static final int HEIGHT = 16;
    public static int speed = 10;
    Timer timer = new Timer(5000/speed, this);

    Snake snake = new Snake(5,6,5,5);
    Apple apple = new Apple(Math.abs((int)(Math.random()*SnakeWindow.WIDTH-1)),Math.abs((int)(Math.random()*SnakeWindow.HEIGHT-1)));


    public SnakeWindow(){
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public void paint (Graphics graphics) {
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,WIDTH*SCALE,HEIGHT*SCALE);

        for (int i = 0; i <WIDTH*SCALE ; i+=SCALE) {
            graphics.setColor(Color.pink);
            graphics.drawLine(i,0,i,HEIGHT*SCALE);
        }

        for (int s = 0; s <HEIGHT*SCALE ; s+=SCALE) {
            graphics.setColor(Color.pink);
            graphics.drawLine(0,s,WIDTH*SCALE,s);
        }

        graphics.setColor(Color.RED);
        graphics.fillOval(apple.posX*SCALE+1,apple.posY*SCALE+1,SCALE-1,SCALE-1);


        for (int i = 0; i < snake.length; i++) {

            graphics.setColor(Color.green);
            graphics.fillRect(snake.sX[i]*SCALE+1,snake.sY[i]*SCALE+1,SCALE-1,SCALE-1);
        }
    }



    public static void main(String[] args) {
       JFrame = new JFrame("Sssnake");
       JFrame.add(new SnakeWindow());
       JFrame.setSize(WIDTH*SCALE+12,HEIGHT*SCALE);
       JFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       JFrame.setVisible(true);
       JFrame.setResizable(false);
       JFrame.setLocationRelativeTo(null);
       JFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\IDEA_projects\\snake\\Snake\\src\\images.jpg"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    snake.move();
    if((snake.sX[0] == apple.posX)&&(snake.sY[0]==apple.posY)){
        apple.setRandomPosition();
        snake.length++;
    }
    repaint();
    }

    public class KeyBoard extends KeyAdapter{
        public void keyPressed(KeyEvent event){

        int key = event.getKeyCode();

        if(key == KeyEvent.VK_UP) snake.direction = 0;
        if(key == KeyEvent.VK_DOWN) snake.direction = 2;
        if(key == KeyEvent.VK_LEFT) snake.direction = 3;
        if(key == KeyEvent.VK_RIGHT) snake.direction = 1;


        }
    }
}
