public class GameSquare 
{
	int squareXPos, squareYPos, squareWidth, squareHeight, color;
	public GameSquare(int squareXPos, int squareYpos, int squareWidth, int squareHeight, int color) 
	{
		this.squareXPos 	= squareXPos;
		this.squareYPos 	= squareYpos;
		this.squareWidth 	= squareWidth;
		this.squareHeight 	= squareHeight;
		this.color 			= color;
	}
	public int getSquareXPos() {
		return squareXPos;
	}
	public void setSquareXPos(int squareXPos) {
		this.squareXPos = squareXPos;
	}
	public int getSquareYPos() {
		return squareYPos;
	}
	public void setSquareYPos(int squareYpos) {
		this.squareYPos = squareYpos;
	}
	public int getSquareWidth() {
		return squareWidth;
	}
	public void setSquareWidth(int squareWidth) {
		this.squareWidth = squareWidth;
	}
	public int getSquareHeight() {
		return squareHeight;
	}
	public void setSquareHeight(int squareHeight) {
		this.squareHeight = squareHeight;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}

	
}
