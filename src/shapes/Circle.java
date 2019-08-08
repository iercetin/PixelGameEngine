package shapes;

public class Circle {
    int xCenter,yCenter,radius, color;

    public Circle(int xCenter, int yCenter, int radius, int color) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
        this.color = color;
    }

    public int getxCenter() {
        return xCenter;
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public int getyCenter() {
        return yCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
