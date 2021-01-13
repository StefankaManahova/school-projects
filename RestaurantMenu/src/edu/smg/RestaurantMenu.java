package edu.smg;

//importing all necessary libraries
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;


public class RestaurantMenu {

	public static void main(String[] args) {
		//creating the frame
		JFrame frame =  new JFrame();
		frame.setSize(960,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//creating a main panel which would contain all other elements
		JPanel mainPanel = new JPanel();
		frame.add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
	    
		//creating three columns in the menu using three panels
		JPanel firstMenuPanel = new JPanel();
		mainPanel.add(firstMenuPanel);
		firstMenuPanel.setLayout(new BoxLayout(firstMenuPanel,BoxLayout.Y_AXIS));
		
		JPanel secondMenuPanel = new JPanel();
		mainPanel.add(secondMenuPanel);
		secondMenuPanel.setLayout(new BoxLayout(secondMenuPanel,BoxLayout.Y_AXIS));
		
		JPanel thirdMenuPanel = new JPanel();
		mainPanel.add(thirdMenuPanel);
		thirdMenuPanel.setLayout(new BoxLayout(thirdMenuPanel,BoxLayout.Y_AXIS));
		
		//creating the panel for the bill
		JPanel billPanel = new JPanel();
		mainPanel.add(billPanel);
		billPanel.setLayout(new BoxLayout(billPanel,BoxLayout.Y_AXIS));
		
		//first column of menu
		    JLabel space1 = new JLabel("\n");
		    firstMenuPanel.add(space1);
		
//		JPanel pnlKirschtorteImage = new JPanel();
//	    firstMenuPanel.add(pnlKirschtorteImage);
//	    Graphics g = pnlKirschtorteImage.getGraphics();
//	    
//		File kirschtorteFile = new File("C:/Users/User/git/school-projects/RestaurantMenu/src/edu/smg/edu/cafe/images/kirschtorte.jpg");
//		try {
//			Image imgKirschtorte = ImageIO.read(kirschtorteFile);
//			g.drawImage(imgKirschtorte,0,0,null);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
		
		//creating an instance of the ImagePanel subclass to JPanel, which overrides the paintComponent method
		File kirschtorteFile = new File("C:/Users/User/git/school-projects/RestaurantMenu/src/edu/smg/edu/cafe/images/kirschtorte.jpg");
		ImagePanel pnlKirschtorteImage = new ImagePanel(kirschtorteFile);
		pnlKirschtorteImage.setSize(180,135);
        firstMenuPanel.add(pnlKirschtorteImage);
		 
	    	
		JLabel kirschtorte = new JLabel("Schwarzwälder Kirschtorte");
		firstMenuPanel.add(kirschtorte);
		
		JLabel lblKirschtortePrice = new JLabel("4,99 lv");
		firstMenuPanel.add(lblKirschtortePrice);
		   
		
		JButton orderKirschtorte = new JButton("Order");
		firstMenuPanel.add(orderKirschtorte);
		
		    JLabel space2 = new JLabel("\n\n");
		    firstMenuPanel.add(space2);
		    
		File eclairesFile = new File("C:/Users/User/git/school-projects/RestaurantMenu/src/edu/smg/edu/cafe/images/eclaires.jpg");
	    ImagePanel pnlEclairesImage = new ImagePanel(eclairesFile);
	    pnlEclairesImage.setSize(180,135);
	    firstMenuPanel.add(pnlEclairesImage);
	     
		JLabel eclaires  = new JLabel("Eclaires with raspberries");
		firstMenuPanel.add(eclaires);
		
		JLabel lblEclairesPrice = new JLabel("4,39 lv");
		firstMenuPanel.add(lblEclairesPrice);
		    
		JButton orderEclaires = new JButton("Order");
		firstMenuPanel.add(orderEclaires);
		
		    JLabel space3 = new JLabel("\n\n");
		    firstMenuPanel.add(space3);
		    
		File biscuitCakeFile = new File("C:/Users/User/git/school-projects/RestaurantMenu/src/edu/smg/edu/cafe/images/biscuit_cake.jpg");
		ImagePanel pnlBiscuitCakeImage = new ImagePanel(biscuitCakeFile);
	    pnlBiscuitCakeImage.setSize(180,135);
	    firstMenuPanel.add(pnlBiscuitCakeImage);
		     
		JLabel biscuitCake  = new JLabel("Biscuit cake");
		firstMenuPanel.add(biscuitCake);
		
		JLabel lblBiscuitCakePrice = new JLabel("4,49 lv");
		firstMenuPanel.add(lblBiscuitCakePrice);
		
		JButton orderBiscuitCake = new JButton("Order");
		firstMenuPanel.add(orderBiscuitCake);
		
		//second column of menu
		
		JLabel menu = new JLabel("Menu",JLabel.CENTER);
//	    menu.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//	    menu.setAlignmentY(JLabel.TOP_ALIGNMENT);
		secondMenuPanel.add(menu);
		
		File chocolateCakeFile = new File("C:/Users/User/git/school-projects/RestaurantMenu/src/edu/smg/edu/cafe/images/chocolate-cake.jpg");
		ImagePanel pnlChocolateCakeImage = new ImagePanel(chocolateCakeFile);
	    pnlChocolateCakeImage.setSize(180,135);
	    secondMenuPanel.add(pnlChocolateCakeImage);
	    
		JLabel chocolateCake = new JLabel("Chocolate cake");
		secondMenuPanel.add(chocolateCake);
		
		JLabel lblChocolateCakePrice = new JLabel("4,79 lv");
		secondMenuPanel.add(lblChocolateCakePrice);
		    
		JButton orderChocolateCake = new JButton("Order");
		secondMenuPanel.add(orderChocolateCake);
		
		     JLabel space4= new JLabel("\n\n");
		     secondMenuPanel.add(space4);
		
		File cheesecakeFile = new File("C:/Users/User/git/school-projects/RestaurantMenu/src/edu/smg/edu/cafe/images/cheesecake.jpg");
		ImagePanel pnlCheesecakeImage = new ImagePanel(cheesecakeFile);
		pnlCheesecakeImage.setSize(180,135);
		secondMenuPanel.add(pnlCheesecakeImage);
		
		JLabel cheesecake = new JLabel("Cheesecake with blueberries");
		secondMenuPanel.add(cheesecake);
		
		JLabel lblCheesecakePrice = new JLabel("4,39 lv");
		secondMenuPanel.add(lblCheesecakePrice);
		    
		JButton orderCheesecake = new JButton("Order");
		secondMenuPanel.add(orderCheesecake);
	
		    JLabel space5 = new JLabel("\n\n");
		    secondMenuPanel.add(space5);
		    
		File cremeBruleeFile = new File("C:/Users/User/git/school-projects/RestaurantMenu/src/edu/smg/edu/cafe/images/creme_brulee.jpg");
		ImagePanel pnlCremeBruleeImage = new ImagePanel(cremeBruleeFile);
		pnlCremeBruleeImage.setSize(180,135);
		secondMenuPanel.add(pnlCremeBruleeImage);
		
		JLabel cremeBrulee = new JLabel("Creme brulee");
		secondMenuPanel.add(cremeBrulee);
		
		JLabel lblCremeBruleePrice = new JLabel("4,39 lv");
		secondMenuPanel.add(lblCremeBruleePrice);
		
		JButton orderCremeBrulee = new JButton("Order");
		secondMenuPanel.add(orderCremeBrulee);
		
		
		//third column of menu
		   JLabel space6 = new JLabel("\n");
		   thirdMenuPanel.add(space6);
		   
		File sundaeFile = new File("C:/Users/User/git/school-projects/RestaurantMenu/src/edu/smg/edu/cafe/images/sundae.jpg");
		ImagePanel pnlSundaeImage = new ImagePanel(sundaeFile);
		pnlSundaeImage.setSize(180,135);
		thirdMenuPanel.add(pnlSundaeImage);
			   
		JLabel sundae = new JLabel("Sundae");
		thirdMenuPanel.add(sundae);
		
		JLabel lblSundaePrice = new JLabel("3,99 lv");
		thirdMenuPanel.add(lblSundaePrice);
		
		JButton orderSundae = new JButton("Order");
		thirdMenuPanel.add(orderSundae);
		
		   JLabel space7= new JLabel("\n\n");
		   thirdMenuPanel.add(space7);
		   
		File cupcakesFile = new File("C:/Users/User/git/school-projects/RestaurantMenu/src/edu/smg/edu/cafe/images/cupcakes.jpg");
		ImagePanel pnlCupcakesImage = new ImagePanel(cupcakesFile);
		pnlCupcakesImage.setSize(180,135);
		thirdMenuPanel.add(pnlCupcakesImage);
		
		JLabel cupcakes = new JLabel("6 cupcakes");
		thirdMenuPanel.add(cupcakes);
		
		JLabel lblCupcakesPrice = new JLabel("4,29 lv");
		thirdMenuPanel.add(lblCupcakesPrice);
		
		JButton orderCupcakes = new JButton("Order");
		thirdMenuPanel.add(orderCupcakes);
		   
		   JLabel space8 = new JLabel("\n\n");
		   thirdMenuPanel.add(space8);
		   
		 File wafflesFile = new File("C:/Users/User/git/school-projects/RestaurantMenu/src/edu/smg/edu/cafe/images/waffles.jpg");
		 ImagePanel pnlWafflesImage = new ImagePanel(wafflesFile);
		 pnlWafflesImage.setSize(180,135);
		 thirdMenuPanel.add(pnlWafflesImage);
		 
		 JLabel waffles = new JLabel("3 waffles with berries");
		 thirdMenuPanel.add(waffles);
		 
		 JLabel lblWafflesPrice = new JLabel("4,29 lv");
			thirdMenuPanel.add(lblWafflesPrice);
		 
		 JButton orderWaffles = new JButton("Order");
		 thirdMenuPanel.add(orderWaffles);
		 
		 
		 //bill
		 JTextArea bill= new JTextArea();
		 JScrollPane scrollPane = new JScrollPane(bill); 
		 
		 bill.setEditable(false);
		 billPanel.add(scrollPane);
		 
		  
		 bill.setText("                                    Bill                                  ");
		 
		    JLabel space9 = new JLabel("\n\n");
		    billPanel.add(space9);
		 
		 JLabel lblbill = new JLabel("Bill:");
		 billPanel.add(lblbill);
		 
		 JLabel lblbillValue = new JLabel("0,00 lv");
		 billPanel.add(lblbillValue);
		 
		    JLabel space10 = new JLabel("\n\n");
		    billPanel.add(space10);
		    
		 JButton goodbye = new JButton("Goodbye");
		 billPanel.add(goodbye);
		   
		   JLabel space11 = new JLabel("\n\n");
		   billPanel.add(space11);
		
		//adding functionality to the "Order" buttons
		orderKirschtorte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final double kirschtortePrice = 4.99;

        		bill.append("\nSchwarzwälder Kirschtorte..........." + kirschtortePrice);
        		
        		String billValue = lblbillValue.getText().replace(",",".").replace("l","").replace("v", "");
        		double sum = Double.parseDouble(billValue);
			    sum += kirschtortePrice;
			    sum = (int)(100*sum)/100.0;
			    
			    billValue = Double.toString(sum) +" lv";
			    billValue.replace(".",",");
			    lblbillValue.setText(billValue);
			}
		});
		
		
		orderEclaires.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final double eclairesPrice = 4.39;

        		bill.append("\nEclaires with raspberries.............." + eclairesPrice);
        		
        		String billValue = lblbillValue.getText().replace(",",".").replace("l","").replace("v", "");
        		double sum = Double.parseDouble(billValue);
			    sum += eclairesPrice;
			    sum = (int)(100*sum)/100.0;
			    
			    billValue = Double.toString(sum) +" lv";
			    billValue.replace(".",",");
			    lblbillValue.setText(billValue);
			}
		});
		
		
		orderBiscuitCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final double biscuitCakePrice = 4.49;

        		bill.append("\nBiscuit cake......................................" + biscuitCakePrice);
        		
        		String billValue = lblbillValue.getText().replace(",",".").replace("l","").replace("v", "");
        		double sum = Double.parseDouble(billValue);
			    sum += biscuitCakePrice;
			    sum = (int)(100*sum)/100.0;
			    
			    billValue = Double.toString(sum) +" lv";
			    billValue.replace(".",",");
			    lblbillValue.setText(billValue);
			}
		});
		orderChocolateCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final double chocolateCakePrice = 4.79;

        		bill.append("\nChocolate cake..............................." + chocolateCakePrice);
        		
        		String billValue = lblbillValue.getText().replace(",",".").replace("l","").replace("v", "");
        		double sum = Double.parseDouble(billValue);
			    sum += chocolateCakePrice;
			    sum = (int)(100*sum)/100.0;
			    
			    billValue = Double.toString(sum) +" lv";
			    billValue.replace(".",",");
			    lblbillValue.setText(billValue);
			}
		});
		
		
		orderCheesecake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final double cheesecakePrice = 4.39;

        		bill.append("\nCheesecake with blueberries......" + cheesecakePrice);
        		
        		String billValue = lblbillValue.getText().replace(",",".").replace("l","").replace("v", "");
        		double sum = Double.parseDouble(billValue);
			    sum += cheesecakePrice;
			    sum = (int)(100*sum)/100.0;
			    
			    billValue = Double.toString(sum) +" lv";
			    billValue.replace(".",",");
			    lblbillValue.setText(billValue);
			}
		});
		
		
		orderCremeBrulee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final double cremeBruleePrice = 4.39;

        		bill.append("\nCreme Brulee.................................." + cremeBruleePrice);
        		
        		String billValue = lblbillValue.getText().replace(",",".").replace("l","").replace("v", "");
        		double sum = Double.parseDouble(billValue);
			    sum += cremeBruleePrice;
			    sum = (int)(100*sum)/100.0;
			    
			    billValue = Double.toString(sum) +" lv";
			    billValue.replace(".",",");
			    lblbillValue.setText(billValue);
			}
		});
		
		
		orderSundae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final double sundaePrice = 3.99;

        		bill.append("\nSundae............................................." + sundaePrice);
        		
        		String billValue = lblbillValue.getText().replace(",",".").replace("l","").replace("v", "");
        		double sum = Double.parseDouble(billValue);
			    sum += sundaePrice;
			    sum = (int)(100*sum)/100.0;
			    
			    billValue = Double.toString(sum) +" lv";
			    billValue.replace(".",",");
			    lblbillValue.setText(billValue);
			}
		});
		
		
		orderCupcakes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final double cupcakesPrice = 4.29;

        		bill.append("\n6 cupcakes......................................" + cupcakesPrice);
        		
        		String billValue = lblbillValue.getText().replace(",",".").replace("l","").replace("v", "");
        		double sum = Double.parseDouble(billValue);
			    sum += cupcakesPrice;
			    sum = (int)(100*sum)/100.0;
			    
			    billValue = Double.toString(sum) +" lv";
			    billValue.replace(".",",");
			    lblbillValue.setText(billValue);
			}
		});
		
		
		orderWaffles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final double wafflesPrice = 4.29;

        		bill.append("\n3 waffles with berries....................." + wafflesPrice);
        		
        		String billValue = lblbillValue.getText().replace(",",".").replace("l","").replace("v", "");
        		double sum = Double.parseDouble(billValue);
			    sum += wafflesPrice;
			    sum = (int)(100*sum)/100.0;
			    
			    billValue = Double.toString(sum) +" lv";
			    billValue.replace(".",",");
			    lblbillValue.setText(billValue);
			}
		});
		
		//adding functionality to the "Goodbye" button
		goodbye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bill.setText("                                    Bill                                  ");
				lblbillValue.setText("0,00 lv");
			}
			
		});

		
		   frame.setVisible(true);
    
	}

}
