import java.awt.*;

public class Mario extends  PixelGameEngine{
    public Mario()
    {
        super(500,500,"Mario");
        int[] pixels = getPixels();
    }

    public static void main(String[] args)
    {
        Mario mario = new Mario();
        Thread gameThread = new Thread(mario);
        gameThread.start();
    }

    int red = Color.red.getRGB();

    @Override
    public void render() {
        updateBackground();
        // Your render

        drawSquare(x,100,100,200,red);
        super.render();
    }

    int x = 1;

    // 1 / 24 seconds
    @Override
    public void update() {
        x+=10;

        super.update();
    }

    int wait = x;
    public void drawSquare(int squareXPos,int squareYPos,int squareWidth,int squareHeight,int color) {
        if(pixels != null)
        {
            if(squareXPos >= width || squareYPos >= height)
                return;
            int pixelStartIndex = (width * squareYPos) + squareXPos;
            for(int a=0;a<squareHeight;a++)
            {
                for(int b=0;b<squareWidth;b++)
                {
                    int nextXPos = b + squareXPos;
                    int nextYPos = squareYPos + a;
                    if(!inScreenCoordinates(nextXPos,nextYPos)){
                        continue;
                    }
                    int processIndex = pixelStartIndex + b + (a*width);
                    if(inPixelArray(processIndex))
                    {
                        pixels[processIndex] = color;
                    }
                }
            }
        }
    }

    public boolean inScreenCoordinates(int x,int y){
        if(x >= width)
            return false;
        if(y >= height)
            return false;
        return true;
    }

    public boolean inPixelArray(int index) {
        if (index >= 0 && index < pixels.length)
            return true;
        return false;
    }
}
