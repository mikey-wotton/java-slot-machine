import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class GUI_SimPlay {
	private JFrame frmsimPlayScreen;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public GUI_SimPlay() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(Main main) {
		frmsimPlayScreen = new JFrame();
		frmsimPlayScreen.setBackground(Color.LIGHT_GRAY);
		frmsimPlayScreen.getContentPane().setBackground(Color.WHITE);
		frmsimPlayScreen.setTitle("Mikey's Not So Wild Slots: Simulated Play");
		frmsimPlayScreen.setMinimumSize(new Dimension(900, 600));
		frmsimPlayScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmsimPlayScreen.getContentPane().setLayout(null);
		frmsimPlayScreen.setVisible(true);
		
		JButton simPlay = new JButton("Spin Once");
		simPlay.setBounds(574, 450, 300, 100);
		simPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				main.spinOnce();
				frmsimPlayScreen.pack();
			}
		});
		frmsimPlayScreen.getContentPane().add(simPlay);
		
		frmsimPlayScreen.pack();
	}

}
