package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Rectangle implements Drawable {
    private Point p1, p2, p3, p4;  
    private Color color;

    public Rectangle(Point p1, Point p3) {
        this.p1 = p1;
        this.p3 = p3;
        this.p2 = new Point(p3.x, p1.y);
        this.p4 = new Point(p1.x, p3.y);

        this.color = getColor();
    }



    @Override
    public void draw(Displayable displayable) {
        Line line1 = new Line(p1, p2, color);
        Line line2 = new Line(p2, p3, color);
        Line line3 = new Line(p3, p4, color);
        Line line4 = new Line(p4, p1, color);

        line1.draw(displayable);
        line2.draw(displayable);
        line3.draw(displayable);
        line4.draw(displayable);
    }

    @Override
    public Color getColor() {
        Random rng = new Random();
        return new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
    }
}
