package edu.algorithms;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectionSortControl extends JPanel {
	private SelectionSortPanel sortingPanel = new SelectionSortPanel();
	private JButton nextStepBtn = new JButton("NextStep");

	public SelectionSortControl() {

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
