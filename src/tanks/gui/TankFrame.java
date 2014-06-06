package tanks.gui;

import javax.swing.JFrame;

import tanks.controller.Controller;

@SuppressWarnings("serial")
public class TankFrame extends JFrame {

	public TankFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Controller controller = new Controller();
		FieldPanel panel = new FieldPanel(controller);
		controller.setPanel(panel);
		setContentPane(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
