package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Circle implements Drawable {
    private Point center;
    private int radius;
    private Color color;

    public Circle(Point center, int radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public static Circle random(int width, int height) {
        Point center = Point.random(width, height);
        Random rng = new Random();

        // int radius = rng.nextInt(Math.min(width, height) / 4) + 1;
        int radius = rng.nextInt(Math.min(width, height) / 2) + 5;

        Color color = randomColor(rng);

        return new Circle(center, radius, color);
    }

    private static Color randomColor(Random rng) {
        return new Color(
            rng.nextInt(256), 
            rng.nextInt(256), 
            rng.nextInt(256)   
        );
    }

    @Override
    public void draw(Displayable displayable) {
        int r = radius;
        int cx = center.x;
        int cy = center.y;

        int width = Integer.MAX_VALUE;
        int height = Integer.MAX_VALUE;
 
        if (displayable instanceof Image) {
            width = ((Image) displayable).getWidth();
            height = ((Image) displayable).getHeight();
        }

        for (int j = -r; j <= r; j++) {
            for (int i = -r; i <= r; i++) {
                int distSq = i * i + j * j;
                if (distSq >= r * r - r && distSq <= r * r + r) {
                    int x = cx + i;
                    int y = cy + j;

                    if (x >= 0 && x < width && y >= 0 && y < height) {
                        displayable.display(x, y, getColor());
                    }
                }
            }
        }
    }

    @Override
    public Color getColor() {
        return color;
    }
}
