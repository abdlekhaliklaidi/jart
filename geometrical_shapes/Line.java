package geometrical_shapes;

import java.awt.Color;

public class Line implements Drawable {
    private Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public static Line random(int width, int height) {
        return new Line(Point.random(width, height), Point.random(width, height));
    }

    @Override
    public void draw(Displayable displayable) {
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
        return Color.WHITE;
    }
}
