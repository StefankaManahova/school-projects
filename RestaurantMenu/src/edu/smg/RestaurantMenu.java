package edu.smg;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;


public class RestaurantMenu {

	public static void main(String[] args) {
		JFrame frame =  new JFrame();
		frame.setSize(800,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		frame.add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
	    
		JPanel firstMenuPanel = new JPanel();
		mainPanel.add(firstMenuPanel);
		firstMenuPanel.setLayout(new BoxLayout(firstMenuPanel,BoxLayout.Y_AXIS));
		
		JPanel secondMenuPanel = new JPanel();
		mainPanel.add(secondMenuPanel);
		secondMenuPanel.setLayout(new BoxLayout(secondMenuPanel,BoxLayout.Y_AXIS));
		
		JPanel thirdMenuPanel = new JPanel();
		mainPanel.add(thirdMenuPanel);
		thirdMenuPanel.setLayout(new BoxLayout(thirdMenuPanel,BoxLayout.Y_AXIS));
		
		JPanel billPanel = new JPanel();
		mainPanel.add(billPanel);
		billPanel.setLayout(new BoxLayout(billPanel,BoxLayout.Y_AXIS));
		
		//first column of menu
		    JLabel space1 = new JLabel("\n");
		    firstMenuPanel.add(space1);
		
		ImageIcon imgKirschtorte = new ImageIcon("edu/images/kirschtorte.jpg");		
		JLabel kirschtorte = new JLabel("Schwarzwälder Kirschtorte",imgKirschtorte,JLabel.CENTER);
		firstMenuPanel.add(kirschtorte);
		
		JLabel lblKirschtortePrice = new JLabel("4,99 lv");
		firstMenuPanel.add(lblKirschtortePrice);
		   
		
		JButton orderKirschtorte = new JButton("Order");
		firstMenuPanel.add(orderKirschtorte);
		
		    JLabel space2 = new JLabel("\n\n");
		    firstMenuPanel.add(space2);
		
		ImageIcon imgEclaires = new ImageIcon("edu/images/eclaires.jpg");
		JLabel eclaires  = new JLabel("Eclaires with raspberries",imgEclaires,JLabel.CENTER);
		firstMenuPanel.add(eclaires);
		
		JLabel lblEclairesPrice = new JLabel("4,39 lv");
		firstMenuPanel.add(lblEclairesPrice);
		    
		JButton orderEclaires = new JButton("Order");
		firstMenuPanel.add(orderEclaires);
		
		    JLabel space3 = new JLabel("\n\n");
		    firstMenuPanel.add(space3);
		
		JLabel biscuitCake  = new JLabel("Biscuit cake");
		firstMenuPanel.add(biscuitCake);
		
		JLabel lblBiscuitCakePrice = new JLabel("4,49 lv");
		firstMenuPanel.add(lblBiscuitCakePrice);
		
		JButton orderBiscuitCake = new JButton("Order");
		firstMenuPanel.add(orderBiscuitCake);
		
		//second column of the menu
		
		JLabel menu = new JLabel("Menu",JLabel.CENTER);
//	    menu.setAlignmentX(JLabel.LEFT_ALIGNMENT);
//	    menu.setAlignmentY(JLabel.TOP_ALIGNMENT);
		secondMenuPanel.add(menu);
		
		
		JLabel chocolateCake = new JLabel("Chocolate cake");
		secondMenuPanel.add(chocolateCake);
		
		JLabel lblChocolateCakePrice = new JLabel("4,79 lv");
		secondMenuPanel.add(lblChocolateCakePrice);
		    
		JButton orderChocolateCake = new JButton("Order");
		secondMenuPanel.add(orderChocolateCake);
		
		     JLabel space4= new JLabel("\n\n");
		     secondMenuPanel.add(space4);
		
		JLabel cheesecake = new JLabel("Cheesecake with blueberries");
		secondMenuPanel.add(cheesecake);
		
		JLabel lblCheesecakePrice = new JLabel("4,39 lv");
		secondMenuPanel.add(lblCheesecakePrice);
		    
		JButton orderCheesecake = new JButton("Order");
		secondMenuPanel.add(orderCheesecake);
	
		    JLabel space5 = new JLabel("\n\n");
		    secondMenuPanel.add(space5);
		
		JLabel cremeBrulee = new JLabel("Creme brulee");
		secondMenuPanel.add(cremeBrulee);
		
		JLabel lblCremeBruleePrice = new JLabel("4,39 lv");
		secondMenuPanel.add(lblCremeBruleePrice);
		
		JButton orderCremeBrulee = new JButton("Order");
		secondMenuPanel.add(orderCremeBrulee);
		
		
		//third column of menu
		   JLabel space6 = new JLabel("\n");
		   thirdMenuPanel.add(space6);
		   
		JLabel sundae = new JLabel("Sundae");
		thirdMenuPanel.add(sundae);
		
		JLabel lblSundaePrice = new JLabel("3,99 lv");
		thirdMenuPanel.add(lblSundaePrice);
		
		JButton orderSundae = new JButton("Order");
		thirdMenuPanel.add(orderSundae);
		
		   JLabel space7= new JLabel("\n\n");
		   thirdMenuPanel.add(space7);
		   
		JLabel cupcakes = new JLabel("6 cupcakes");
		thirdMenuPanel.add(cupcakes);
		
		JLabel lblCupcakesPrice = new JLabel("4,29 lv");
		thirdMenuPanel.add(lblCupcakesPrice);
		
		JButton orderCupcakes = new JButton("Order");
		thirdMenuPanel.add(orderCupcakes);
		   
		   JLabel space8 = new JLabel("\n\n");
		   thirdMenuPanel.add(space8);
		
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
		 
		 bill.setText("Bill");
		 
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
     
		frame.setVisible(true);
	}

}
