import java.awt.*;

// This is an example game made using PixelGameEngine

public class YourGame extends PixelGameEngine{

	public static void main(String[] args)
	{
		YourGame pixel 	= new YourGame(700,700);
		Thread thread 	= new Thread(pixel);
		thread.start();
	}

	// Example Game Objects
	GameSquare player1;
	GameSquare player2;

	public YourGame(int width, int height) 
	{
		super(width, height);
		// Start Coding Here..
		player1 		= new GameSquare(100, 100, 20, 20, red);
		player2 		= new GameSquare(100, 100, 20, 20, red);


	}

	// Render is called as much as possible (Depends on your computers speed)
	@Override
	public void render() 
	{
		updateBackground();
		// Render Your Images Here


		player1.setSquareXPos((int) MouseInfo.getPointerInfo().getLocation().getX()-canvas.getLocationOnScreen().x);
		player1.setSquareYPos((int) MouseInfo.getPointerInfo().getLocation().getY()-canvas.getLocationOnScreen().y);

		drawSquare(player1);
		drawSquare(player2);
		
		// Do not delete super.render() and keep it at the last line of the function
		super.render();
	}

	// Update is called every 1 / 24 seconds
	// Update Your Game Variables Here
	@Override
	public void update() 
	{

	}


}
