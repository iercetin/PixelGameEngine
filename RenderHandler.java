import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class RenderHandler {
	Graphics graphics;
	BufferedImage bufferedImage;
	int[] pixels;
	int width, height;
	BufferStrategy bufferStrategy;
	
	static int black = new Color(0,0,0).getRGB();
	
	public RenderHandler(Graphics graphics,BufferedImage bufferedImage,Canvas canvas,int[] pixels,int width,int height)
	{
		this.graphics 		= graphics;
		this.bufferedImage 	= bufferedImage;
		this.pixels 		= pixels;
		this.width 			= width;
		this.height 		= height;
		bufferStrategy 	= canvas.getBufferStrategy();
	}
	
	public void render()
	{
		// add bufferedImage to graphics
		graphics.drawImage(bufferedImage, 0, 0, width, height, null);
		// show next bufferStrategy
		bufferStrategy.show();
	}
	
	public void backgroundUpdate()
	{
		for(int x=0;x<pixels.length;x++)
		{
			pixels[x] = black;
		}
	}
	
	public void drawSquare(int squareXPos,int squareYpos,int squareWidth,int squareHeight,int color)
	{
		if(pixels != null)
		{
			int pixelStartIndex = (width * squareYpos) + squareXPos;	
			for(int a=0;a<squareHeight;a++)
			{
				for(int b=0;b<squareWidth;b++)
				{
					int processIndex = pixelStartIndex + b + (a*width);
					pixels[processIndex] = color;
				}
			}
		}
	}
	
	public void drawGameSquare(GameSquare gameSquare)
	{
		drawSquare(gameSquare.getSquareXPos(), gameSquare.getSquareYpos(), gameSquare.getSquareWidth(), gameSquare.getSquareHeight(),gameSquare.getColor());
	}

}