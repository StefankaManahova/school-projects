package edu.smg;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CafeMenu {
	
    static double sum = 0.00;
    final static double kirschtortePrice = 4.99;
	final static double eclairesPrice = 4.39;
	final static  double biscuitCakePrice = 4.49;
	final static double chocolateCakePrice = 4.79;
	final static double cheesecakePrice = 4.39;
	final static double cremeBruleePrice = 4.39;
	final static double sundaePrice = 3.99;
	final static double cupcakesPrice = 4.29;
	final static double wafflesPrice = 4.29;
	
	
	public static void main(String[] args) {
		
		//creating the frame
		JFrame frame =  new JFrame();
		frame.setSize(920,700);
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
		    JLabel space1 = new JLabel("\n\n");
		    firstMenuPanel.add(space1);
		    
		
		//creating an instance of the ImagePanel subclass to JPanel, which overrides the paintComponent method
		File kirschtorteFile = new File("src/resources/kirschtorte.jpg");
		ImagePanel pnlKirschtorteImage = new ImagePanel(kirschtorteFile);
		pnlKirschtorteImage.setSize(180,135);
        firstMenuPanel.add(pnlKirschtorteImage);
		 
	    	
		JLabel kirschtorte = new JLabel("Schwarzwälder Kirschtorte");
		firstMenuPanel.add(kirschtorte);
		
		JLabel lblKirschtortePrice = new JLabel(writtenAsPrice(kirschtortePrice));
		firstMenuPanel.add(lblKirschtortePrice);
		   
		
		JButton orderKirschtorte = new JButton("Order");
		firstMenuPanel.add(orderKirschtorte);
		
		    JLabel space2 = new JLabel("\n\n");
		    firstMenuPanel.add(space2);
		    
		File eclairesFile = new File("src/resources/eclaires.jpg");
	    ImagePanel pnlEclairesImage = new ImagePanel(eclairesFile);
	    pnlEclairesImage.setSize(180,135);
	    firstMenuPanel.add(pnlEclairesImage);
	     
		JLabel eclaires  = new JLabel("Eclaires with raspberries");
		firstMenuPanel.add(eclaires);
		
		JLabel lblEclairesPrice = new JLabel(writtenAsPrice(eclairesPrice));
		firstMenuPanel.add(lblEclairesPrice);
		    
		JButton orderEclaires = new JButton("Order");
		firstMenuPanel.add(orderEclaires);
		
		    JLabel space3 = new JLabel("\n\n");
		    firstMenuPanel.add(space3);
		   
		File biscuitCakeFile = new File("src/resources/biscuit_cake.jpg");
		ImagePanel pnlBiscuitCakeImage = new ImagePanel(biscuitCakeFile);
	    pnlBiscuitCakeImage.setSize(180,135);
	    firstMenuPanel.add(pnlBiscuitCakeImage);
		
		     
		JLabel biscuitCake  = new JLabel("Biscuit cake");
		firstMenuPanel.add(biscuitCake);
		
		JLabel lblBiscuitCakePrice = new JLabel(writtenAsPrice(biscuitCakePrice));
		firstMenuPanel.add(lblBiscuitCakePrice);
		
		JButton orderBiscuitCake = new JButton("Order");
		firstMenuPanel.add(orderBiscuitCake);
		
		//second column of menu
		Font font = new Font("Serif",Font.ITALIC|Font.BOLD,18);
		JLabel menu = new JLabel("            Menu");
		menu.setFont(font);
		secondMenuPanel.add(menu);
		
		File chocolateCakeFile = new File("src/resources/chocolate-cake.jpg");
		ImagePanel pnlChocolateCakeImage = new ImagePanel(chocolateCakeFile);
	    pnlChocolateCakeImage.setSize(180,135);
	    secondMenuPanel.add(pnlChocolateCakeImage);
	    
		JLabel chocolateCake = new JLabel("Chocolate cake");
		secondMenuPanel.add(chocolateCake);
		
		JLabel lblChocolateCakePrice = new JLabel(writtenAsPrice(chocolateCakePrice));
		secondMenuPanel.add(lblChocolateCakePrice);
		    
		JButton orderChocolateCake = new JButton("Order");
		secondMenuPanel.add(orderChocolateCake);
		
		     JLabel space4= new JLabel("\n\n");
		     secondMenuPanel.add(space4);
		
		File cheesecakeFile = new File("src/resources/cheesecake.jpg");
		ImagePanel pnlCheesecakeImage = new ImagePanel(cheesecakeFile);
		pnlCheesecakeImage.setSize(180,135);
		secondMenuPanel.add(pnlCheesecakeImage);
		
		JLabel cheesecake = new JLabel("Cheesecake with blueberries");
		secondMenuPanel.add(cheesecake);
		
		JLabel lblCheesecakePrice = new JLabel(writtenAsPrice(cheesecakePrice));
		secondMenuPanel.add(lblCheesecakePrice);
		    
		JButton orderCheesecake = new JButton("Order");
		secondMenuPanel.add(orderCheesecake);
	
		    JLabel space5 = new JLabel("\n\n");
		    secondMenuPanel.add(space5);
		    
		File cremeBruleeFile = new File("src/resources/creme_brulee.jpg");
		ImagePanel pnlCremeBruleeImage = new ImagePanel(cremeBruleeFile);
		pnlCremeBruleeImage.setSize(180,135);
		secondMenuPanel.add(pnlCremeBruleeImage);
		
		JLabel cremeBrulee = new JLabel("Creme brulee");
		secondMenuPanel.add(cremeBrulee);
		
		JLabel lblCremeBruleePrice = new JLabel(writtenAsPrice(cremeBruleePrice));
		secondMenuPanel.add(lblCremeBruleePrice);
		
		JButton orderCremeBrulee = new JButton("Order");
		secondMenuPanel.add(orderCremeBrulee);
		
		
		//third column of menu
		   JLabel space6 = new JLabel("\n\n");
		   thirdMenuPanel.add(space6);
		   
		File sundaeFile = new File("src/resources/sundae.jpg");
		ImagePanel pnlSundaeImage = new ImagePanel(sundaeFile);
		pnlSundaeImage.setSize(180,135);
		thirdMenuPanel.add(pnlSundaeImage);
			   
		JLabel sundae = new JLabel("Sundae");
		thirdMenuPanel.add(sundae);
		
		JLabel lblSundaePrice = new JLabel(writtenAsPrice(sundaePrice));
		thirdMenuPanel.add(lblSundaePrice);
		
		JButton orderSundae = new JButton("Order");
		thirdMenuPanel.add(orderSundae);
		
		   JLabel space7= new JLabel("\n\n");
		   thirdMenuPanel.add(space7);
		   
		File cupcakesFile = new File("src/resources/cupcakes.jpg");
		ImagePanel pnlCupcakesImage = new ImagePanel(cupcakesFile);
		pnlCupcakesImage.setSize(180,135);
		thirdMenuPanel.add(pnlCupcakesImage);
		
		JLabel cupcakes = new JLabel("6 cupcakes");
		thirdMenuPanel.add(cupcakes);
		
		JLabel lblCupcakesPrice = new JLabel(writtenAsPrice(cupcakesPrice));
		thirdMenuPanel.add(lblCupcakesPrice);
		
		JButton orderCupcakes = new JButton("Order");
		thirdMenuPanel.add(orderCupcakes);
		   
		   JLabel space8 = new JLabel("\n\n");
		   thirdMenuPanel.add(space8);
		   
		 File wafflesFile = new File("src/resources/waffles.jpg");
		 ImagePanel pnlWafflesImage = new ImagePanel(wafflesFile);
		 pnlWafflesImage.setSize(180,135);
		 thirdMenuPanel.add(pnlWafflesImage);
		 
		 JLabel waffles = new JLabel("3 waffles with berries");
		 thirdMenuPanel.add(waffles);
		 
		 JLabel lblWafflesPrice = new JLabel(writtenAsPrice(wafflesPrice));
			thirdMenuPanel.add(lblWafflesPrice);
		 
		 JButton orderWaffles = new JButton("Order");
		 thirdMenuPanel.add(orderWaffles);
		 
		 
		 //bill
		 JTextArea bill= new JTextArea(7,13);
		 JScrollPane scrollPane = new JScrollPane(bill); 
		 
		 bill.setEditable(false);
		 billPanel.add(scrollPane);
		 
		  
		 bill.setText("                                Bill");
		 
		    JLabel space9 = new JLabel("\n\n");
		    billPanel.add(space9);
		 
		 JLabel lblbill = new JLabel("Bill:");
		 billPanel.add(lblbill);
		 
		 JLabel lblbillValue = new JLabel("0,00 lv.");
		 billPanel.add(lblbillValue);
		 
		    JLabel space10 = new JLabel("\n\n");
		    billPanel.add(space10);
		    
		 JButton pay = new JButton("Pay");
		 billPanel.add(pay);
		   
		   JLabel space11 = new JLabel("\n\n");
		   billPanel.add(space11);
		
		//adding functionality to the "Order" buttons
		orderKirschtorte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				bill.append("\nSchwarzwälder Kirschtorte..........." + kirschtortePrice);
        		lblbillValue.setText(addToSum(kirschtortePrice));//adds the price to the total value of the bill
			
			}
		});
		
		
		orderEclaires.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
        		bill.append("\nEclaires with raspberries.............." + eclairesPrice);
        		lblbillValue.setText(addToSum(eclairesPrice));
			
			}
		});
		
		
		orderBiscuitCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

        		bill.append("\nBiscuit cake......................................" + biscuitCakePrice);
        		lblbillValue.setText(addToSum(biscuitCakePrice));
			
			}
		});
		orderChocolateCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

        		bill.append("\nChocolate cake..............................." + chocolateCakePrice);
        		lblbillValue.setText(addToSum(chocolateCakePrice));
			
			}
		});
		
		
		orderCheesecake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
        		bill.append("\nCheesecake with blueberries......" + cheesecakePrice);
        		lblbillValue.setText(addToSum(cheesecakePrice));
		
			}
		});
		
		
		orderCremeBrulee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

        		bill.append("\nCreme Brulee.................................." + cremeBruleePrice);
        		lblbillValue.setText(addToSum(cremeBruleePrice));
	
			}
		});
		
		
		orderSundae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
        		bill.append("\nSundae............................................." + sundaePrice);
        		lblbillValue.setText(addToSum(sundaePrice));
			}
		});
		
		
		orderCupcakes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
        		bill.append("\n6 cupcakes......................................" + cupcakesPrice);
        		lblbillValue.setText(addToSum(cupcakesPrice));
			
			}
		});
		
		
		orderWaffles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
        		bill.append("\n3 waffles with berries....................." + wafflesPrice);
        		lblbillValue.setText(addToSum(wafflesPrice));
			
			}
		});
		
		//adding functionality to the "Goodbye" button
	    pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bill.setText("                                Bill");
				if(sum!=0) {
					sum = 0.00;
					DecimalFormat formatter = new DecimalFormat("0.00");
					lblbillValue.setText(formatter.format(sum).replace('.', ',') + " lv.");
					JOptionPane.showMessageDialog(null,"Thank you for choosing us!\nYour order will arrive in no longer than 1 hour.\nHave a nice day and enjoy your sweets!","Successful order",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});

		
		   frame.setVisible(true);
    
	}
	
	public static String addToSum(double price)
	{
		sum += price;
		DecimalFormat formatter = new DecimalFormat("0.00");
		String result = formatter.format(sum) + " lv";
		result = result.replace('.',',') + ".";
		return result;
	}
	
	public static String writtenAsPrice(double price) {//returns the price written as "$,$$ lv."
		return Double.toString(price).replace('.', ',') + " lv.";
	}

}
