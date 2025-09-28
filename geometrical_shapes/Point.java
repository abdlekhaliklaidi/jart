package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Point implements Drawable {
    public int x, y;
    private Color color;
    
    // Constructeur
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = randomColor();
    }

    public static Point random(int width, int height) {
        Random rng = new Random();
        return new Point(rng.nextInt(width), rng.nextInt(height));
    }
    
    private Color randomColor() {
        Random rng = new Random(); // Create a new Random object from the Random class
        return new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
    }

    @Override // Redefine a function
    public void draw(Displayable displayable) {
        displayable.display(x, y, getColor());
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
        // return this.color;
    }
}
