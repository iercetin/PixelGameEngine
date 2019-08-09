package engine;
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

    public RenderHandler(Graphics graphics,BufferedImage bufferedImage,Canvas canvas,int[] pixels,int width,int height) {
        this.graphics 		= graphics;
        this.bufferedImage 	= bufferedImage;
        this.pixels 		= pixels;
        this.width 			= width;
        this.height 		= height;
        bufferStrategy 	= canvas.getBufferStrategy();
    }

    public void render() {
        // add bufferedImage to graphics
        graphics.drawImage(bufferedImage, 0, 0, width, height, null);
        // show next bufferStrategy
        bufferStrategy.show();
    }

    // Temporary Function!
    public void backgroundUpdate() {
        for(int x=0;x<pixels.length;x++){
            pixels[x] = black;
        }
    }

    // Set pixel using pixel coordinates
    public void setPixel(int x,int y,int color){
        if(inScreenCoordinates(x,y)){
            int pixelIndex = x + (y*width);
            drawPixel(pixelIndex,color);
        }
    }

    // Set pixel directly (Do not use unless necessary)
    private void drawPixel(int pixelIndex,int colorCode){
        if(inPixelArray(pixelIndex)){
            pixels[pixelIndex] = colorCode;
        }
    }

    /**
     * Render Checkers Start
     */

    public boolean inScreenCoordinates(int x,int y){
        if(x < 0 || x >= width)
            return false;
        if(y < 0 || y >= height)
            return false;
        return true;
    }

    public boolean inPixelArray(int index) {
        if(index < pixels.length && index > 0)
            return true;
        return false;
    }

    /**
     * Render Checkers End
     */

    /**
     * Shape Drawers Start
     * */

    // Circle
    private final void circlePoints(int cx, int cy, int x, int y, int color)
    {
        if (x == 0) {
            setPixel( cx, cy + y,color);
            setPixel( cx, cy - y,color);
            setPixel( cx + y, cy,color);
            setPixel( cx - y, cy,color);
        } else
        if (x == y) {
            setPixel( cx + x, cy + y,color);
            setPixel( cx - x, cy + y,color);
            setPixel( cx + x, cy - y,color);
            setPixel( cx - x, cy - y,color);
        } else
        if (x < y) {
            setPixel( cx + x, cy + y,color);
            setPixel( cx - x, cy + y,color);
            setPixel( cx + x, cy - y,color);
            setPixel( cx - x, cy - y,color);
            setPixel( cx + y, cy + x,color);
            setPixel( cx - y, cy + x,color);
            setPixel( cx + y, cy - x,color);
            setPixel( cx - y, cy - x,color);
        }
    }

    public void circleMidpoint(int xCenter, int yCenter, int radius, int color) {
        int x = 0;
        int y = radius;
        int p = (5 - radius*4)/4;

        circlePoints(xCenter, yCenter, x, y, color);
        while (x < y) {
            x++;
            if (p < 0) {
                p += 2*x+1;
            } else {
                y--;
                p += 2*(x-y)+1;
            }
            circlePoints(xCenter, yCenter, x, y, color);
        }
    }

    // Rectangle
    public void drawRectangle(int squareXPos,int squareYPos,int squareWidth,int squareHeight,int color) {
        for(int a=0;a<squareHeight;a++) {
            for(int b=0;b<squareWidth;b++) {
                int nextXPos = b + squareXPos;
                int nextYPos = squareYPos + a;
                setPixel(nextXPos,nextYPos,color);
            }
        }
    }

    // Line Drawers
    void drawLine(int x1,int y1,int x2,int y2,int color){
        // Iterators, counters required by algorithm
        int x, y, dx, dy, dx1, dy1, px, py, xe, ye, i;
        // Calculate line deltas
        dx = x2 - x1;
        dy = y2 - y1;
        // Create a positive copy of deltas (makes iterating easier)
        dx1 = Math.abs(dx);
        dy1 = Math.abs(dy);
        // Calculate error intervals for both axis
        px = 2 * dy1 - dx1;
        py = 2 * dx1 - dy1;

        // The line is X-axis dominant
        if (dy1 <= dx1) {
            // Line is drawn left to right
            if (dx >= 0) {
                x = x1; y = y1; xe = x2;
            } else { // Line is drawn right to left (swap ends)
                x = x2; y = y2; xe = x1;
            }

            setPixel(x, y,color); // Draw first pixel

            // Rasterize the line
            for (i = 0; x < xe; i++) {
                x = x + 1;

                // Deal with octants...
                if (px < 0) {
                    px = px + 2 * dy1;
                } else {
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) {
                        y = y + 1;
                    } else {
                        y = y - 1;
                    }
                    px = px + 2 * (dy1 - dx1);
                }

                // Draw pixel from line span at
                // currently rasterized position
                setPixel(x, y,color);
            }

        } else { // The line is Y-axis dominant

            // Line is drawn bottom to top
            if (dy >= 0) {
                x = x1; y = y1; ye = y2;
            } else { // Line is drawn top to bottom
                x = x2; y = y2; ye = y1;
            }

            setPixel(x, y,color); // Draw first pixel

            // Rasterize the line
            for (i = 0; y < ye; i++) {
                y = y + 1;

                // Deal with octants...
                if (py <= 0) {
                    py = py + 2 * dx1;
                } else {
                    if ((dx < 0 && dy<0) || (dx > 0 && dy > 0)) {
                        x = x + 1;
                    } else {
                        x = x - 1;
                    }
                    py = py + 2 * (dx1 - dy1);
                }

                // Draw pixel from line span at
                // currently rasterized position
                setPixel(x, y,color);
            }
        }
    }

    /**
     * Shape Drawers End
     * */

}

