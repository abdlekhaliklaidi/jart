package geometrical_shapes;


import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Image implements Displayable {
    private BufferedImage canvas;
    private int width;
    private int height;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        java.awt.Graphics2D g = canvas.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.dispose();
    }

    @Override
    public void display(int x, int y, Color color) {
        if (x >= 0 && y >= 0 && x < width && y < height) {
            canvas.setRGB(x, y, color.getRGB());
        }
    }

    @Override
    public void save(String path) {
        try {
            File output = new File(path);
            ImageIO.write(canvas, "png", output);
            System.out.println("Image saved to: " + output.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
