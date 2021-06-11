package catan;

import javax.swing.JFrame;;

public class CatanApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(400, 300);
		frame.add(new DiceControl());
		frame.setTitle("Catan");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
