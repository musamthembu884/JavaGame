import javax.swing.JFrame;

import za.ac.uj.acsse.csc2a.pta.ui.CrimeFrame;


public class Main {

	
	public static void main(String[] args) {

		/*
		 * Frame to display the panel
		 * Entire Game will be displayed here
		 */
		CrimeFrame frame=new CrimeFrame();
		frame.setSize(680,680);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
