package shapes;

public class Rectangle {
    int rectXPos, rectYPos, rectWidth, rectHeight, color;

    public Rectangle(int rectXPos, int rectYPos, int rectWidth, int rectHeight, int color) {
        this.rectXPos = rectXPos;
        this.rectYPos = rectYPos;
        this.rectWidth = rectWidth;
        this.rectHeight = rectHeight;
        this.color = color;
    }

    public int getRectXPos() {
        return rectXPos;
    }

    public void setRectXPos(int rectXPos) {
        this.rectXPos = rectXPos;
    }

    public int getRectYPos() {
        return rectYPos;
    }

    public void setRectYPos(int rectYPos) {
        this.rectYPos = rectYPos;
    }

    public int getRectWidth() {
        return rectWidth;
    }

    public void setRectWidth(int rectWidth) {
        this.rectWidth = rectWidth;
    }

    public int getRectHeight() {
        return rectHeight;
    }

    public void setRectHeight(int rectHeight) {
        this.rectHeight = rectHeight;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
