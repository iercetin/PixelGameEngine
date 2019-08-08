import engine.PixelGameEngine;
import shapes.Circle;
import shapes.Rectangle;

import java.awt.*;

// This is an example game made using PixelGameEngine
public class ExampleGame extends PixelGameEngine {
    static int red = new Color(255,0,0).getRGB();
    int[] pixels = getPixels();

    public static void main(String[] args) {
        ExampleGame pixel 	= new ExampleGame(700,700);
        Thread thread 	= new Thread(pixel);
        thread.start();
    }

    // Example Game Objects
    Rectangle player1;
    Circle player2;


    int player1X = 10;

    public ExampleGame(int width, int height) {
        // Start Coding Here..
        super(width, height,"ExampleGame");
        // Control your pixels here
        int[] pixels = getPixels();

        player1 = new Rectangle(100, 100, 10, 10, red);
        player2 = new Circle(100,100,30,red);

        System.out.println("Pixels: "+pixels.length);
    }

    // Render is called as much as possible (Depends on your computers speed)
    @Override
    public void render() {
        updateBackground();
        drawRectangle(player1);
        //drawRectangle(player2);
        drawCircle(player2);

        player1.setRectXPos(getMouseX() - player1.getRectWidth() / 2);
        player1.setRectYPos(getMouseY() - player1.getRectHeight() / 2);

        player2.setxCenter(getMouseX());
        player2.setyCenter(getMouseY());

        super.render();
    }

    // Update is called every 1 / 24 seconds
    // Update Your Game Variables Here
    @Override
    public void update() {
        player1.setRectXPos(getMouseX() - player1.getRectWidth() / 2);
        player1.setRectYPos(getMouseY() - player1.getRectHeight() / 2);
    }
}