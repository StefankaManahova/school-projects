package catan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DiceControl extends JPanel{
	protected DicePanel dicePanel = new DicePanel();
	protected JButton roll = new JButton("Roll");
	
	protected Font font = new Font("Calibri", Font.PLAIN, 20);
	
	public DiceControl() {
		setLayout(new BorderLayout());
		
		roll.setFont(font);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.add(roll);
		
		add(dicePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		roll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dicePanel.roll();
			}
		});
	}
}
