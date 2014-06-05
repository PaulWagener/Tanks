package tanks.gui;

import javax.swing.JFrame;

import tanks.controller.Controller;

@SuppressWarnings("serial")
public class TankFrame extends JFrame {

	public TankFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(new FieldPanel(new Controller()));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
