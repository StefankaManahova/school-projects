package edu.collections;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SortControl extends JPanel {
	private SortingPanel sortingPanel = new SortingPanel();

	private JButton nextStepBtn = new JButton("NextStep");

	public SortControl() {

		setLayout(new BorderLayout());
		add(sortingPanel, BorderLayout.CENTER);
		add(nextStepBtn, BorderLayout.SOUTH);
		
		nextStepBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				sortingPanel.nextStepInSorting();
			}
		});

	}
}
