package tanks.gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TankFrame extends JFrame {

	public TankFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContentPane(new FieldPanel());
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
