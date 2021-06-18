package catan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResourcesCard extends JPanel {
	protected int resourceNumber = 0;
	protected JLabel lblResource = new JLabel();
	protected ImagePanel image;
	
	protected static Font font = new Font("Calibri", Font.PLAIN, 20);
	
	public ResourcesCard(String resourceName) {
		lblResource.setText("" + resourceNumber);
		lblResource.setFont(font);
		
		File file;
		if(resourceName.equals("tree")) {
			file = new File("src/catan/tree.png");
		}
		else if(resourceName.equals("rock")) {
			file = new File("src/catan/rock.png");
		}
		else if(resourceName.equals("bricks")) {
			file = new File("src/catan/bricks.png");
		}
		else if(resourceName.equals("wool")) {
			file = new File("src/catan/sheep.png");
		}
		else if(resourceName.equals("wheat")) {
			file = new File("src/catan/wheat.png");
		}
		else {
			file = null;
		}
		image = new ImagePanel(file);//trows exception
		image.setBackground(Color.WHITE);
		
		JPanel pnlLabel = new JPanel();
		pnlLabel.add(lblResource);
		pnlLabel.setBackground(Color.WHITE);
		
		setLayout(new BorderLayout());
		add(image, BorderLayout.CENTER);
		add(pnlLabel, BorderLayout.SOUTH);	
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
    }

	public int getResourceNumber() {
		return resourceNumber;
	}

	public void setResourceNumber(int resourceNumber) {
		this.resourceNumber = resourceNumber;
		lblResource.setText("" + resourceNumber);
	}

}
