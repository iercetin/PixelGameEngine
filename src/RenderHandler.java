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

	public void drawSquare(int squareXPos,int squareYPos,int squareWidth,int squareHeight,int color) {
		for(int a=0;a<squareHeight;a++) {
			for(int b=0;b<squareWidth;b++) {
				int nextXPos = b + squareXPos;
				int nextYPos = squareYPos + a;
				if(!inScreenCoordinates(nextXPos,nextYPos)){
					continue;
				}
				int processIndex = nextXPos + (nextYPos*width);
				drawPixel(processIndex,color);
			}
		}
	}

	public void drawPixel(int pixelIndex,int colorCode){
		if(inPixelArray(pixelIndex)){
			pixels[pixelIndex] = colorCode;
		}
	}

	public boolean inScreenCoordinates(int x,int y){
		if(x < 0 || x >= width)
			return false;
		if(y < 0 || y >= height)
			return false;
		return true;
	}

	public boolean inPixelArray(int index)
	{
		if(index < pixels.length && index > 0)
		{
			return true;
		}
		return false;
	}
	
	public void drawGameSquare(GameSquare gameSquare)
	{
		drawSquare(gameSquare.getSquareXPos(), gameSquare.getSquareYPos(), gameSquare.getSquareWidth(), gameSquare.getSquareHeight(),gameSquare.getColor());
	}

}
