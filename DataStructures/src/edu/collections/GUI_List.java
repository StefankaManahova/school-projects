package edu.collections;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI_List extends JFrame{
	private LinkedList<Integer> numbers = new LinkedList<>();
	
	private JButton btnSort = new JButton("Sort");
	private JButton btnShuffle= new JButton("Shuffle");
	private JButton btnReverse = new JButton("Reverse");
	private JButton btnEnter = new JButton("Enter");
	private JTextArea txtDisplayList = new JTextArea("");
	private JTextField input = new JTextField("");
	
	GUI_List(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		
		input.setEditable(true);
		input.setBounds(50, 20, 200, 40);
		panel.add(input);
		
		btnEnter.setBounds(260, 20, 80,40);
		panel.add(btnEnter);
		
		txtDisplayList.setEditable(false);
		txtDisplayList.setBounds(50, 100,300, 100);
		panel.add(txtDisplayList);
		
		btnSort.setBounds(70,220,80,40);
		panel.add(btnSort);
		
		btnShuffle.setBounds(160,220,80,40);
		panel.add(btnShuffle);
		
		btnReverse.setBounds(250,220,90,40);
		panel.add(btnReverse);
		
		btnEnter.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				String[] numbersLine = input.getText().split(" ");
				for(int i=0; i<numbersLine.length; i++) {
					if(isInteger(numbersLine[i])){
						Integer number = Integer.parseInt(numbersLine[i]);
				        
						if(!numbers.contains(number)) {
				        	
				        	numbers.addLast(number);
					}
				}
				txtDisplayList.setText(numbers.toString());
			}
		  }
		});
		
		btnSort.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				Collections.sort(numbers);
				txtDisplayList.setText(numbers.toString());
			}
		});
		
		btnReverse.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				Collections.sort(numbers,Collections.reverseOrder());
				txtDisplayList.setText(numbers.toString());
			}
		});
		
		btnShuffle.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				Collections.shuffle(numbers);
				txtDisplayList.setText(numbers.toString());
			}
		});
		

	}
	
	public boolean isInteger(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
