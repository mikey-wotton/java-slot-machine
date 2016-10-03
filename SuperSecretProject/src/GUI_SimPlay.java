import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class GUI_SimPlay extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUI_SimPlay(Main main) {
		JLabel[][] labels = new JLabel[5][5];
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

		JLabel balance = new JLabel(String.valueOf(main.userDetails
				.getBalance()));
		balance.setBounds(10, 41, 100, 20);
		contentPane.add(balance);

		// All labels for the images of the wheels
		JLabel label = new JLabel("0 - 0");
		label.setIcon(new ImageIcon("facedown_small.jpg"));
		label.setBounds(215, 14, 70, 90);
		contentPane.add(label);
		labels[0][0] = label;	
		
		JLabel label_0 = new JLabel("0 - 1");
		label_0.setIcon(new ImageIcon("facedown_small.jpg"));
		label_0.setBounds(215, 105, 70, 90);
		contentPane.add(label_0);
		labels[0][1] = label_0;
		
		JLabel label_1 = new JLabel("0 - 2");
		label_1.setIcon(new ImageIcon("facedown_small.jpg"));
		label_1.setBounds(215, 195, 70, 90);
		contentPane.add(label_1);
		labels[0][2] = label_1;		

		JLabel label_2 = new JLabel("0 - 3");
		label_2.setIcon(new ImageIcon("facedown_small.jpg"));
		label_2.setBounds(215, 286, 70, 90);
		contentPane.add(label_2);
		labels[0][3] = label_2;		

		JLabel label_3 = new JLabel("0 - 4");
		label_3.setIcon(new ImageIcon("facedown_small.jpg"));
		label_3.setBounds(215, 377, 70, 90);
		contentPane.add(label_3);
		labels[0][4] = label_3;		


		JLabel label_5 = new JLabel("1 - 0");
		label_5.setIcon(new ImageIcon("facedown_small.jpg"));
		label_5.setBounds(310, 14, 70, 90);
		contentPane.add(label_5);		
		labels[1][0] = label_5;
		
		JLabel label_6 = new JLabel("1 - 1");
		label_6.setIcon(new ImageIcon("facedown_small.jpg"));
		label_6.setBounds(310, 105, 70, 90);
		contentPane.add(label_6);
		labels[1][1] = label_6;
		
		JLabel label_7 = new JLabel("1 - 2");
		label_7.setIcon(new ImageIcon("facedown_small.jpg"));
		label_7.setBounds(310, 195, 70, 90);
		contentPane.add(label_7);	
		labels[1][2] = label_7;
		
		JLabel label_8 = new JLabel("1 - 3");
		label_8.setIcon(new ImageIcon("facedown_small.jpg"));
		label_8.setBounds(310, 286, 70, 90);
		contentPane.add(label_8);
		labels[1][3] = label_8;
		
		JLabel label_9 = new JLabel("1 - 4");
		label_9.setIcon(new ImageIcon("facedown_small.jpg"));
		label_9.setBounds(310, 377, 70, 90);
		contentPane.add(label_9);
		labels[1][4] = label_9;
		

		
		
		

		JLabel label_10 = new JLabel("2 - 0");
		label_10.setIcon(new ImageIcon("facedown_small.jpg"));
		label_10.setBounds(404, 14, 70, 90);
		contentPane.add(label_10);
		labels[2][0] = label_10;

		JLabel label_11 = new JLabel("2 - 2");
		label_11.setIcon(new ImageIcon("facedown_small.jpg"));
		label_11.setBounds(404, 195, 70, 90);
		contentPane.add(label_11);
		labels[2][1] = label_11;

		JLabel label_12 = new JLabel("2 - 1");
		label_12.setIcon(new ImageIcon("facedown_small.jpg"));
		label_12.setBounds(404, 105, 70, 90);
		contentPane.add(label_12);
		labels[2][2] = label_12;

		JLabel label_13 = new JLabel("2 - 3");
		label_13.setIcon(new ImageIcon("facedown_small.jpg"));
		label_13.setBounds(404, 286, 70, 90);
		contentPane.add(label_13);
		labels[2][3] = label_13;

		JLabel label_14 = new JLabel("2 -4");
		label_14.setIcon(new ImageIcon("facedown_small.jpg"));
		label_14.setBounds(404, 377, 70, 90);
		contentPane.add(label_14);
		labels[2][4] = label_14;

		
		
		
		
		JLabel label_15 = new JLabel("3 - 0");
		label_15.setIcon(new ImageIcon("facedown_small.jpg"));
		label_15.setBounds(498, 14, 70, 90);
		contentPane.add(label_15);
		labels[3][0] = label_15;

		JLabel label_16 = new JLabel("3 - 1");
		label_16.setIcon(new ImageIcon("facedown_small.jpg"));
		label_16.setBounds(498, 105, 70, 90);
		contentPane.add(label_16);
		labels[3][1] = label_16;

		JLabel label_17 = new JLabel("3 - 2");
		label_17.setIcon(new ImageIcon("facedown_small.jpg"));
		label_17.setBounds(498, 195, 70, 90);
		contentPane.add(label_17);		
		labels[3][2] = label_17;

		JLabel label_18 = new JLabel("3 - 3");
		label_18.setIcon(new ImageIcon("facedown_small.jpg"));
		label_18.setBounds(498, 286, 70, 90);
		contentPane.add(label_18);		
		labels[3][3] = label_18;

		JLabel label_19 = new JLabel("3 - 4");
		label_19.setIcon(new ImageIcon("facedown_small.jpg"));
		label_19.setBounds(498, 377, 70, 90);
		contentPane.add(label_19);		
		labels[3][4] = label_19;


		JLabel label_20 = new JLabel("4 - 0");
		label_20.setIcon(new ImageIcon("facedown_small.jpg"));
		label_20.setBounds(592, 14, 70, 90);
		contentPane.add(label_20);
		labels[4][0] = label_20;

		JLabel label_21 = new JLabel("4 - 1");
		label_21.setIcon(new ImageIcon("facedown_small.jpg"));
		label_21.setBounds(592, 105, 70, 90);
		contentPane.add(label_21);
		labels[4][1] = label_21;

		JLabel label_22 = new JLabel("4 - 2");
		label_22.setIcon(new ImageIcon("facedown_small.jpg"));
		label_22.setBounds(592, 195, 70, 90);
		contentPane.add(label_22);
		labels[4][2] = label_22;

		JLabel label_23 = new JLabel("4 - 3");
		label_23.setIcon(new ImageIcon("facedown_small.jpg"));
		label_23.setBounds(592, 286, 70, 90);
		contentPane.add(label_23);
		labels[4][3] = label_23;

		JLabel label_24 = new JLabel("4 - 4");
		label_24.setIcon(new ImageIcon("facedown_small.jpg"));
		label_24.setBounds(592, 377, 70, 90);
		contentPane.add(label_24);
		labels[4][4] = label_24;

		
		JButton spinOnce = new JButton("Spin Once");
		spinOnce.setBounds(674, 471, 200, 80);
		spinOnce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSpin(main, labels, balance, 1);
			}
		});
		contentPane.add(spinOnce);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(215, 531, 50, 20);
		contentPane.add(spinner);
		
		JButton autoSpin = new JButton("Auto-Play");
		autoSpin.setBounds(10, 475, 200, 80);
		autoSpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gets number of auto spins from spinner
				int spins = (Integer) spinner.getValue();
				//for x amount of auto spins loop
					showSpin(main, labels, balance, spins);
					try {
					    Thread.sleep(2000);
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
			}
		});
		contentPane.add(autoSpin);	
	}
	public void showSpin(Main main, JLabel[][] labels, JLabel balance, int spins){
		while(spins > 0){
			main.spinOnce();
			for(int i = 0;i < main.arrayOfWheels.length; i++){
				for(int j = 0;j < main.arrayOfWheels.length; j++){
				labels[i][j].setIcon(new ImageIcon(main.arrayOfWheels[i][j].imageString()));
				}
			}
			balance.setText(String.valueOf(main.userDetails.getBalance()));
			spins--;
		}
	}
}
