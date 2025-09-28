package geometrical_shapes;

import java.awt.Color;
// import java.util.Random;

public class Line implements Drawable {
    private Point start, end;
    private Color color;
    
    // Constructeur
    public Line(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public Line(Point start, Point end) {
        this(start, end, Color.WHITE); 
    }

    // public static Line random(int width, int height) {
    //     return new Line(Point.random(width, height), Point.random(width, height));
    // }
    
     public static Line random(int width, int height) {
        Point start = Point.random(width, height);
        Point end = Point.random(width, height);

        Color color = Color.WHITE;

        return new Line(start, end, color);
    }

    @Override
    public void draw(Displayable displayable) { // Bresenham's algorithm To draw a straight line between two points on a pixel grid
        int dx = Math.abs(end.x - start.x);
        int dy = Math.abs(end.y - start.y);
        int sx = start.x < end.x ? 1 : -1;
        int sy = start.y < end.y ? 1 : -1;
        int err = dx - dy;
        int x = start.x;
        int y = start.y;

        while (true) {
            displayable.display(x, y, getColor());
            if (x == end.x && y == end.y) {
                break;
            }
            // equation error
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x += sx;
            }
            if (e2 < dx) {
                err += dx;
                y += sy;
            }
        }
    }

    @Override
    public Color getColor() {
        return color;
    }
}
