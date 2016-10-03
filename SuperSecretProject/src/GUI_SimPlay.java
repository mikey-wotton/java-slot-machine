import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;


public class GUI_SimPlay extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUI_SimPlay(Main main) {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 900, 600);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(900, 600));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblUserName = new JLabel(main.userDetails.getUsername());
		lblUserName.setBounds(10, 10, 100, 20);
		contentPane.add(lblUserName);
		
		JLabel balance = new JLabel(String.valueOf(main.userDetails.getBalance()));
		balance.setBounds(10, 41, 100, 20);
		contentPane.add(balance);
		
		JButton spinOnce = new JButton("Spin Once");
		spinOnce.setBounds(574, 450, 300, 100);
		spinOnce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				main.spinOnce();
				balance.setText(String.valueOf(main.userDetails.getBalance()));
			}
		});
		contentPane.add(spinOnce);
		
		JButton autoSpin = new JButton("Auto-Play");
		autoSpin.setBounds(10, 450, 300, 100);
		autoSpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//lots to do here
				main.spinOnce();				
				balance.setText(String.valueOf(main.userDetails.getBalance()));
			}
		});
		contentPane.add(autoSpin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(120, 13, 100, 135);
		contentPane.add(lblNewLabel);
		
		
	}
}
