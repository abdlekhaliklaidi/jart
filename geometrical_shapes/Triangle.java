package geometrical_shapes;
import java.awt.Color;
import java.util.Random;


public class Triangle implements Drawable {
    private Point point,point2,point3;
    private Color color;

    public Triangle(Point point,Point point2,Point point3){
        this.point = point;
        this.point3 = point3;
        this.point2 = point2;
        this.color = getColor();
    }


    @Override
    public void draw(Displayable displayable) {
        Line line1 = new Line(point, point2, color);
        Line line2 = new Line(point, point3, color);
        Line line3 = new Line(point3, point2, color);
        line1.draw(displayable);
        line2.draw(displayable);
        line3.draw(displayable);        
    }

    @Override
    public Color getColor() {
        Random rng = new Random();
        return new Color(rng.nextInt(256),rng.nextInt(256),rng.nextInt(256));
    }
}