package catan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel{
	ResourcesCard wool = new ResourcesCard("wool");
	ResourcesCard tree = new ResourcesCard("tree");
	ResourcesCard bricks = new ResourcesCard("bricks");
	ResourcesCard wheat = new ResourcesCard("wheat");
	ResourcesCard rock = new ResourcesCard("rock");
	
	HashMap<String, ResourcesCard> resourcesCards = new HashMap<String, ResourcesCard>(){{
		put("wool",wool);
		put("tree",tree);
		put("bricks", bricks);
		put("rock", rock);
		put("wheat", wheat);
	}};
	
	JLabel currentScore = new JLabel();
	protected int score = 0;

	JButton buildVillage = new JButton("Build village");
	JButton buildTown = new JButton("Build town");
	JButton buildRoad = new JButton("Build road");
	JButton readyWithMove = new JButton("Ready");
	
	Font font = new Font("Calibri", Font.PLAIN, 17);
	
	public PlayerPanel(char allignment) {
		currentScore.setText("Current score: " + score);
		
		if(allignment == '-') {
			createHorizontalPanel();
		}
		else if(allignment == '|') {
			createVerticalPanel();
		}
		
	}
	
	protected void createHorizontalPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel pnlCurrentScore = new JPanel();
		pnlCurrentScore.setBackground(Color.WHITE);
		pnlCurrentScore.add(currentScore);
		currentScore.setFont(font);
		JPanel pnlMain = new JPanel();
		add(pnlCurrentScore);
		add(pnlMain);
		
		pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.X_AXIS));
		pnlMain.setBackground(Color.WHITE);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		p1.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
		p4.setBackground(Color.WHITE);
		p5.setBackground(Color.WHITE);
		p6.setBackground(Color.WHITE);
		p7.setBackground(Color.WHITE);
	
		pnlMain.add(p1);;
		pnlMain.add(p2);
		pnlMain.add(p3);
		pnlMain.add(p4);
		pnlMain.add(p5);
		pnlMain.add(p6);
		pnlMain.add(p7);
		
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
		p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
		p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
		p6.setLayout(new BoxLayout(p6, BoxLayout.Y_AXIS));
		p7.setLayout(new BoxLayout(p7, BoxLayout.Y_AXIS));
		
		p1.add(wool);
		p2.add(tree);
		p3.add(wheat);
		p4.add(bricks);
		p5.add(rock);
		
		buildRoad.setFont(font);
		JPanel pnlBuildRoad = new JPanel();
		pnlBuildRoad.setBackground(Color.WHITE);
		pnlBuildRoad.add(buildRoad);
		
		buildVillage.setFont(font);
		JPanel pnlBuildVillage= new JPanel();
		pnlBuildVillage.setBackground(Color.WHITE);
		pnlBuildVillage.add(buildVillage);
		
		p6.add(pnlBuildRoad);
		p6.add(pnlBuildVillage);
		
		buildTown.setFont(font);
		JPanel pnlBuildTown = new JPanel();
		pnlBuildTown.setBackground(Color.WHITE);
		pnlBuildTown.add(buildTown);
		
		readyWithMove.setFont(font);
		JPanel pnlReady = new JPanel();
		pnlReady.setBackground(Color.WHITE);
		
		pnlReady.add(readyWithMove);
		p7.add(pnlReady);
		p7.add(pnlBuildTown);
	}
	
	protected void createVerticalPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel pnlCurrentScore = new JPanel();
		pnlCurrentScore.setBackground(Color.WHITE);
		pnlCurrentScore.add(currentScore);
		currentScore.setFont(font);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		p1.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
		p4.setBackground(Color.WHITE);
		p5.setBackground(Color.WHITE);
		p6.setBackground(Color.WHITE);
		p7.setBackground(Color.WHITE);
		add(pnlCurrentScore);
		add(p1);;
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(p6);
		add(p7);
		
		p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
		p4.setLayout(new BoxLayout(p4, BoxLayout.X_AXIS));
		p5.setLayout(new BoxLayout(p5, BoxLayout.X_AXIS));
		p6.setLayout(new BoxLayout(p6, BoxLayout.X_AXIS));
		p7.setLayout(new BoxLayout(p7, BoxLayout.X_AXIS));
		
		p1.add(wool);
		p1.add(tree);
		p2.add(wheat);
		p2.add(bricks);
		p3.add(rock);
		
		buildRoad.setFont(font);
		JPanel pnlBuildRoad = new JPanel();
		pnlBuildRoad.setBackground(Color.WHITE);
		pnlBuildRoad.add(buildRoad);
		
		buildVillage.setFont(font);
		JPanel pnlBuildVillage= new JPanel();
		pnlBuildVillage.setBackground(Color.WHITE);
		pnlBuildVillage.add(buildVillage);
		
		p4.add(pnlBuildRoad);
		p5.add(pnlBuildVillage);
		
		buildTown.setFont(font);
		JPanel pnlBuildTown = new JPanel();
		pnlBuildTown.setBackground(Color.WHITE);
		pnlBuildTown.add(buildTown);
		
		readyWithMove.setFont(font);
		JPanel pnlReady = new JPanel();
		pnlReady.setBackground(Color.WHITE);
		pnlReady.add(readyWithMove);

		p6.add(pnlBuildTown);
		p7.add(pnlReady);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
    }
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
