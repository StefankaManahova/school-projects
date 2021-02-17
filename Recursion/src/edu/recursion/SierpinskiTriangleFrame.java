package edu.recursion;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;;

public class SierpinskiTriangleFrame extends JFrame {
	static int r = 0, gr = 0, b = 255;



	//private JTextField jtfOrder = new JTextField("0", 5); // Order
	private static int order = 0;
	private JButton higherOrder = new JButton("+");
	private JButton lowerOrder = new JButton("-");
	private SierpinskiTrianglePanel trianglePanel = new SierpinskiTrianglePanel(); // To display the pattern

	public SierpinskiTriangleFrame() {
// Panel to hold label, text field, and a button
		JPanel panel = new JPanel();
		panel.add(lowerOrder);
		panel.add(higherOrder);
		higherOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lowerOrder.setHorizontalAlignment(SwingConstants.CENTER);
// Add a Sierpinski triangle panel to the frame
		add(trianglePanel);
		add(panel, BorderLayout.SOUTH);
 ///Register a listener
		lowerOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(order>=1 && order<=8){
					order--;
				    trianglePanel.setOrder(order);
				}
			}
		});
		
		higherOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(order>=0 && order<=7) {
					order++;
					trianglePanel.setOrder(order);
				}
			}
		});

	}
}
