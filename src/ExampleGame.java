import engine.PixelGameEngine;
import shapes.Rectangle;

import java.awt.*;

// This is an example game made using PixelGameEngine
public class ExampleGame extends PixelGameEngine {
    static int red = new Color(255,0,0).getRGB();

    public static void main(String[] args) {
        ExampleGame pixel 	= new ExampleGame(700,700);
        Thread thread 	= new Thread(pixel);
        thread.start();
    }

    // Example Game Objects
    Rectangle player1, player2;

    int player1X = 10;

    public ExampleGame(int width, int height)
    {
        // Start Coding Here..
        super(width, height,"ExampleGame");
        // Control your pixels here
        int[] pixels = getPixels();

        player1 = new Rectangle(100, 100, 20, 20, red);
        player2 = new Rectangle(player1X, 50, 20, 20, red);

        System.out.println("Pixels: "+pixels.length);
    }

    // Render is called as much as possible (Depends on your computers speed)
    @Override
    public void render()
    {
        updateBackground();

        drawRectangle(player1);
        drawRectangle(player2);


        super.render();
    }

    // Update is called every 1 / 24 seconds
    // Update Your Game Variables Here
    @Override
    public void update() {
        player1.setRectXPos(getMouseX() - player1.getRectWidth() / 2);
        player1.setRectYPos(getMouseY() - player1.getRectHeight() / 2);

        player1X += 2;
    }
}