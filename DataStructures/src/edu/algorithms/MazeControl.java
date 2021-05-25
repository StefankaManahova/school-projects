package edu.algorithms;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MazeControl extends JPanel {
	private MazePanel mazePanel = new MazePanel();
	private JLabel solution = new JLabel("Можете ли да избягате?");
	
	
	private JButton findPath = new JButton("Потърси път");
	private JButton clearPath = new JButton("Изчисти пътя");
	
	public MazeControl() {

		setLayout(new BorderLayout());
		
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(MazePanel.background);
		solution.setFont(new Font("Calibri", Font.PLAIN, 20));
		labelPanel.add(solution);
		
		
		JPanel buttonsPanel = new JPanel();
		findPath.setFont(new Font("Calibri", Font.PLAIN, 16));
		clearPath.setFont(new Font("Calibri", Font.PLAIN, 16));
		buttonsPanel.add(findPath);
		buttonsPanel.add(clearPath);
		buttonsPanel.setBackground(MazePanel.background);
		
		add(labelPanel,BorderLayout.NORTH);
		add(mazePanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		
		findPath.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				solution.setText(mazePanel.findPath());
			}
		});
		
		clearPath.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mazePanel.clearPath();
			}
		});

	}
}
