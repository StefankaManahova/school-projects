package catan;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class ExchangePanel extends JPanel {
	protected String[] resources = {"tree","bricks","rock","wheat","wool"};
	JComboBox<String> givenResources = new JComboBox<String>(resources);
	JComboBox<String> receivedResources = new JComboBox<String>(resources);
	JButton btnExchange = new JButton("Exchange");
	
	JLabel lbl1 = new JLabel("Exchange 3 of ");
	JLabel lbl2 = new JLabel(" for 1 of ");
	
	static Font font = new Font("Calibri", Font.PLAIN, 17);
	
	public ExchangePanel() {
		setBackground(Color.WHITE);
		lbl1.setFont(font);
		lbl2.setFont(font);
		btnExchange.setFont(font);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		
		JPanel pnlLabels = new JPanel();
		pnlLabels.setBackground(Color.WHITE);
		pnlLabels.setLayout(new BoxLayout(pnlLabels, BoxLayout.Y_AXIS));
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.add(lbl1);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		p2.add(lbl2);
		pnlLabels.add(p1);
		pnlLabels.add(p2);
		
		JPanel pnlComboBoxes = new JPanel();
		pnlComboBoxes.setBackground(Color.WHITE);
		pnlComboBoxes.setLayout(new BoxLayout(pnlComboBoxes, BoxLayout.Y_AXIS));
		JPanel pnlCombo1 = new JPanel();
		pnlCombo1.setBackground(Color.WHITE);
		pnlCombo1.add(givenResources);
		
		JPanel pnlCombo2 = new JPanel();
		pnlCombo2.setBackground(Color.WHITE);
		pnlCombo2.add(receivedResources);
		pnlComboBoxes.add(pnlCombo1);
		pnlComboBoxes.add(pnlCombo2);
		
		JPanel pnlButton = new JPanel();
		pnlButton.setBackground(Color.WHITE);
		pnlButton.add(btnExchange);
		
		mainPanel.add(pnlLabels);
		mainPanel.add(pnlComboBoxes);
		add(mainPanel);
		add(pnlButton);
	}
	
	public void exchange3for1(Player player) throws InvalidExchangeException{
		String givenResource =(String) givenResources.getSelectedItem();
		String receivedResource =(String) receivedResources.getSelectedItem();
		if(!givenResource.equals(receivedResource)) {
			if(player.resources.containsKey(givenResource) && player.resources.containsKey(receivedResource)) {
				
				if(player.resources.get(givenResource) >= 3) {
					player.resources.put(givenResource, player.resources.get(givenResource) - 3);
					player.resources.put(receivedResource, player.resources.get(receivedResource) + 1);
					player.updateResourcesLabels();
				}
			}
		} else {
			throw  new InvalidExchangeException();
		}
	}
}
