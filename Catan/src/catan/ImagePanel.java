package catan;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private Image image;

    public ImagePanel(File file) {
       try {                
          image = ImageIO.read(file);
       } catch (IOException e) {
    	   e.printStackTrace();
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (this.getWidth() - image.getWidth(getRootPane())) / 2;
        int y = (this.getHeight() - image.getHeight(getRootPane())) / 2;
        g.drawImage(image, x, y, this);       
        
    }
}
