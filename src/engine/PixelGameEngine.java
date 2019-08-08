package engine;

import shapes.Circle;
import shapes.Rectangle;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;



public class PixelGameEngine extends JFrame implements Runnable {
    Canvas canvas;
    Graphics graphics;
    BufferedImage bufferedImage;
    BufferStrategy bufferStrategy;
    RenderHandler handler;

    String name;
    int width, height;
    int[] pixels;

    public int[] getPixels(){ return pixels; };
    public void setPixels(int[] newPixels){ pixels = newPixels; };


    public void render()
    {
        handler.render();
    }

    public void updateBackground()
    {
        handler.backgroundUpdate();
    }

    public void run()
    {
        long lastTime 				= System.nanoTime();
        int framesPerSecond 		= 24;
        double nanoSecondConversion = 1000000000.0 / framesPerSecond;
        double changeInSeconds 		= 0;

        while(true)
        {
            long now = System.nanoTime();
            changeInSeconds += ((now - lastTime) / nanoSecondConversion);
            while(changeInSeconds >= 1)
            {
                update();
                changeInSeconds = 0;
            }
            render();
            lastTime = now;
        }
    }

    public void update() {}

    public PixelGameEngine(int width,int height,String name)
    {
        super(name);
        // Initialize Values
        this.name 	= name;
        this.width 	= width;
        this.height = height;



        // Add Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, width, height);
        setLocationRelativeTo(null);
        setVisible(true);

        // Add Canvas
        canvas = new Canvas();
        super.add(canvas);

        // Add BufferStrategy to canvas
        canvas.createBufferStrategy(2);

        // Get bufferStrategy
        bufferStrategy = canvas.getBufferStrategy();

        // Get graphs from bufferStrategy
        graphics = bufferStrategy.getDrawGraphics();

        // Add graphs to frame
        paint(graphics);

        // create BufferedImage
        bufferedImage = new BufferedImage(width, height, 1);

        // Get pixels (width * height)
        pixels = ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData();

        // Render Handler
        handler = new RenderHandler(graphics, bufferedImage,canvas, pixels, width, height);
    }

    public int getMouseX(){
        return (int) MouseInfo.getPointerInfo().getLocation().getX()-canvas.getLocationOnScreen().x;
    }

    public int getMouseY(){
        return (int) MouseInfo.getPointerInfo().getLocation().getY()-canvas.getLocationOnScreen().y;
    }

    public void drawRectangle(Rectangle rectangle){
        handler.drawRectangle(rectangle.getRectXPos(),rectangle.getRectYPos(),rectangle.getRectWidth(),rectangle.getRectHeight(),rectangle.getColor());
    }

    public void drawCircle(Circle circle){
        handler.circleMidpoint(circle.getxCenter(),circle.getyCenter(),circle.getRadius(),circle.getColor());
    }
}
