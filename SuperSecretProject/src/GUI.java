import java.awt.EventQueue;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class GUI {
	public Main main;
	private JFrame frame;
	private SwingWorker<Void, String> worker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		main = new Main("John", 500.00);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Mikey's Not So Wild Slots");
		frame.setBackground(new Color(250, 78, 91));

		JPanel mainScreen = new JPanel();
		mainScreen.setBackground(UIManager
				.getColor("OptionPane.errorDialog.titlePane.shadow"));
		mainScreen.setLayout(null);

		// Adding images
		JLabel lblAceimage = new JLabel("aceImage");
		lblAceimage.setVerticalAlignment(SwingConstants.TOP);
		lblAceimage.setIcon(new ImageIcon("ace_front.jpg"));
		lblAceimage.setBounds(10, 50, 176, 230);
		mainScreen.add(lblAceimage);

		JLabel lblKingimage = new JLabel("kingImage");
		lblKingimage.setVerticalAlignment(SwingConstants.TOP);
		lblKingimage.setIcon(new ImageIcon("king_front.jpg"));
		lblKingimage.setBounds(187, 100, 176, 230);
		mainScreen.add(lblKingimage);

		JLabel lblQueenimage = new JLabel("queenImage");
		lblQueenimage.setVerticalAlignment(SwingConstants.TOP);
		lblQueenimage.setIcon(new ImageIcon("queen_front.jpg"));
		lblQueenimage.setBounds(352, 50, 176, 230);
		mainScreen.add(lblQueenimage);

		JLabel lblJackimage = new JLabel("jackImage");
		lblJackimage.setVerticalAlignment(SwingConstants.TOP);
		lblJackimage.setIcon(new ImageIcon("jack_front.jpg"));
		lblJackimage.setBounds(540, 100, 176, 230);
		mainScreen.add(lblJackimage);

		JLabel lblTenimage = new JLabel("tenImage");
		lblTenimage.setVerticalAlignment(SwingConstants.TOP);
		lblTenimage.setIcon(new ImageIcon("ten_front.jpg"));
		lblTenimage.setBounds(716, 50, 176, 230);
		mainScreen.add(lblTenimage);

		JButton simPlay = new JButton("Simulated Play");
		simPlay.setBounds(10, 475, 200, 80);
		simPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen.setVisible(false);
				JPanel simScreen = simPlay();
				frame.getContentPane().add(simScreen);
				simScreen.setVisible(true);

			}
		});
		mainScreen.add(simPlay);

		JButton realPlay = new JButton("Real Play");
		realPlay.setBounds(674, 475, 200, 80);
		realPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Real Play");
			}
		});
		mainScreen.add(realPlay);
		frame.getContentPane().add(mainScreen);

	}

	public JPanel simPlay() {
		JPanel contentPane = new JPanel();
		JLabel[][] labels = new JLabel[5][5];
		contentPane.setMinimumSize(new Dimension(900, 600));
		contentPane.setBackground(new Color(250, 78, 91));
		contentPane.setLayout(null);

		JLabel lblUserName = new JLabel("Username: "
				+ main.userDetails.getUsername());
		lblUserName.setBounds(10, 10, 100, 20);
		contentPane.add(lblUserName);

		JLabel lblBalance = new JLabel("Balance: "
				+ String.valueOf(main.userDetails.getBalance()));
		lblBalance.setBounds(10, 41, 200, 20);
		contentPane.add(lblBalance);

		JLabel lblwinLines = new JLabel("Number of Win Lines: ");
		lblwinLines.setBounds(700, 10, 140, 20);
		contentPane.add(lblwinLines);

		JLabel lblstakeValue = new JLabel("Stake per line: ");
		lblstakeValue.setBounds(700, 31, 140, 20);
		contentPane.add(lblstakeValue);

		SpinnerNumberModel modelWinLinesSpinner = new SpinnerNumberModel(1, 1, 10, 1);
		JSpinner winLinesSpinner = new JSpinner(modelWinLinesSpinner);
		winLinesSpinner.setEditor(new JSpinner.DefaultEditor(winLinesSpinner));
		winLinesSpinner.setBounds(828, 11, 50, 20);
		contentPane.add(winLinesSpinner);

		SpinnerNumberModel modelStakeSpinner = new SpinnerNumberModel(1, 1, 10,	0.5);
		JSpinner winStakeSpinner = new JSpinner(modelStakeSpinner);
		winStakeSpinner.setEditor(new JSpinner.DefaultEditor(winStakeSpinner));
		winStakeSpinner.setBounds(828, 31, 50, 20);
		contentPane.add(winStakeSpinner);

		// All labels for the images of the wheels
		JLabel label = new JLabel("0 - 0");
		label.setIcon(new ImageIcon("facedown_small.jpg"));
		label.setBounds(215, 10, 70, 90);
		contentPane.add(label);
		labels[0][0] = label;

		JLabel label_0 = new JLabel("0 - 1");
		label_0.setIcon(new ImageIcon("facedown_small.jpg"));
		label_0.setBounds(215, 101, 70, 90);
		contentPane.add(label_0);
		labels[0][1] = label_0;

		JLabel label_1 = new JLabel("0 - 2");
		label_1.setIcon(new ImageIcon("facedown_small.jpg"));
		label_1.setBounds(215, 192, 70, 90);
		contentPane.add(label_1);
		labels[0][2] = label_1;

		JLabel label_2 = new JLabel("0 - 3");
		label_2.setIcon(new ImageIcon("facedown_small.jpg"));
		label_2.setBounds(215, 283, 70, 90);
		contentPane.add(label_2);
		labels[0][3] = label_2;

		JLabel label_3 = new JLabel("0 - 4");
		label_3.setIcon(new ImageIcon("facedown_small.jpg"));
		label_3.setBounds(215, 374, 70, 90);
		contentPane.add(label_3);
		labels[0][4] = label_3;

		JLabel label_5 = new JLabel("1 - 0");
		label_5.setIcon(new ImageIcon("facedown_small.jpg"));
		label_5.setBounds(310, 10, 70, 90);
		contentPane.add(label_5);
		labels[1][0] = label_5;

		JLabel label_6 = new JLabel("1 - 1");
		label_6.setIcon(new ImageIcon("facedown_small.jpg"));
		label_6.setBounds(310, 101, 70, 90);
		contentPane.add(label_6);
		labels[1][1] = label_6;

		JLabel label_7 = new JLabel("1 - 2");
		label_7.setIcon(new ImageIcon("facedown_small.jpg"));
		label_7.setBounds(310, 192, 70, 90);
		contentPane.add(label_7);
		labels[1][2] = label_7;

		JLabel label_8 = new JLabel("1 - 3");
		label_8.setIcon(new ImageIcon("facedown_small.jpg"));
		label_8.setBounds(310, 283, 70, 90);
		contentPane.add(label_8);
		labels[1][3] = label_8;

		JLabel label_9 = new JLabel("1 - 4");
		label_9.setIcon(new ImageIcon("facedown_small.jpg"));
		label_9.setBounds(310, 374, 70, 90);
		contentPane.add(label_9);
		labels[1][4] = label_9;

		JLabel label_10 = new JLabel("2 - 0");
		label_10.setIcon(new ImageIcon("facedown_small.jpg"));
		label_10.setBounds(404, 10, 70, 90);
		contentPane.add(label_10);
		labels[2][0] = label_10;

		JLabel label_11 = new JLabel("2 - 1");
		label_11.setIcon(new ImageIcon("facedown_small.jpg"));
		label_11.setBounds(404, 101, 70, 90);
		contentPane.add(label_11);
		labels[2][1] = label_11;

		JLabel label_12 = new JLabel("2 - 2");
		label_12.setIcon(new ImageIcon("facedown_small.jpg"));
		label_12.setBounds(404, 192, 70, 90);
		contentPane.add(label_12);
		labels[2][2] = label_12;

		JLabel label_13 = new JLabel("2 - 3");
		label_13.setIcon(new ImageIcon("facedown_small.jpg"));
		label_13.setBounds(404, 283, 70, 90);
		contentPane.add(label_13);
		labels[2][3] = label_13;

		JLabel label_14 = new JLabel("2 -4");
		label_14.setIcon(new ImageIcon("facedown_small.jpg"));
		label_14.setBounds(404, 374, 70, 90);
		contentPane.add(label_14);
		labels[2][4] = label_14;

		JLabel label_15 = new JLabel("3 - 0");
		label_15.setIcon(new ImageIcon("facedown_small.jpg"));
		label_15.setBounds(498, 10, 70, 90);
		contentPane.add(label_15);
		labels[3][0] = label_15;

		JLabel label_16 = new JLabel("3 - 1");
		label_16.setIcon(new ImageIcon("facedown_small.jpg"));
		label_16.setBounds(498, 101, 70, 90);
		contentPane.add(label_16);
		labels[3][1] = label_16;

		JLabel label_17 = new JLabel("3 - 2");
		label_17.setIcon(new ImageIcon("facedown_small.jpg"));
		label_17.setBounds(498, 192, 70, 90);
		contentPane.add(label_17);
		labels[3][2] = label_17;

		JLabel label_18 = new JLabel("3 - 3");
		label_18.setIcon(new ImageIcon("facedown_small.jpg"));
		label_18.setBounds(498, 283, 70, 90);
		contentPane.add(label_18);
		labels[3][3] = label_18;

		JLabel label_19 = new JLabel("3 - 4");
		label_19.setIcon(new ImageIcon("facedown_small.jpg"));
		label_19.setBounds(498, 374, 70, 90);
		contentPane.add(label_19);
		labels[3][4] = label_19;

		JLabel label_20 = new JLabel("4 - 0");
		label_20.setIcon(new ImageIcon("facedown_small.jpg"));
		label_20.setBounds(592, 10, 70, 90);
		contentPane.add(label_20);
		labels[4][0] = label_20;

		JLabel label_21 = new JLabel("4 - 1");
		label_21.setIcon(new ImageIcon("facedown_small.jpg"));
		label_21.setBounds(592, 101, 70, 90);
		contentPane.add(label_21);
		labels[4][1] = label_21;

		JLabel label_22 = new JLabel("4 - 2");
		label_22.setIcon(new ImageIcon("facedown_small.jpg"));
		label_22.setBounds(592, 192, 70, 90);
		contentPane.add(label_22);
		labels[4][2] = label_22;

		JLabel label_23 = new JLabel("4 - 3");
		label_23.setIcon(new ImageIcon("facedown_small.jpg"));
		label_23.setBounds(592, 283, 70, 90);
		contentPane.add(label_23);
		labels[4][3] = label_23;

		JLabel label_24 = new JLabel("4 - 4");
		label_24.setIcon(new ImageIcon("facedown_small.jpg"));
		label_24.setBackground(new Color(0, 0, 150, 30));
		label_24.setBounds(592, 374, 70, 90);
		contentPane.add(label_24);
		labels[4][4] = label_24;

		JLabel lblWinOrLoseAmount = new JLabel("winOrLoseAmount");
		lblWinOrLoseAmount.setText("Welcome, good luck!");
		lblWinOrLoseAmount.setBounds(380, 500, 200, 20);
		contentPane.add(lblWinOrLoseAmount);

		JLabel lblNumberOfAutoSpins = new JLabel("autoPlaySpins");
		lblNumberOfAutoSpins.setText("Number of Autoplay spins:");
		lblNumberOfAutoSpins.setBounds(10, 448, 200, 20);
		contentPane.add(lblNumberOfAutoSpins);

		SpinnerNumberModel model1 = new SpinnerNumberModel(1, 1, 100, 1);
		JSpinner autoSpinner = new JSpinner(model1);
		autoSpinner.setEditor(new JSpinner.DefaultEditor(autoSpinner));
		autoSpinner.setBounds(160, 450, 50, 20);
		contentPane.add(autoSpinner);

		JButton spinOnce = new JButton("Spin Once");
		spinOnce.setBounds(674, 475, 200, 80);
		spinOnce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (worker != null) {
					worker.cancel(true);
				}
				worker = new Worker(labels, lblWinOrLoseAmount, lblBalance,	autoSpinner, (Integer) winLinesSpinner.getValue(), (double) winStakeSpinner.getValue());
				worker.execute();
			}
		});
		contentPane.add(spinOnce);

		JButton autoSpin = new JButton("Auto-Play");
		autoSpin.setBounds(10, 475, 200, 80);
		autoSpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (worker != null) {
					worker.cancel(true);
				}
				worker = new Worker(labels, lblWinOrLoseAmount, lblBalance,	autoSpinner, (Integer) winLinesSpinner.getValue(), (double) winStakeSpinner.getValue());
				worker.execute();
			}
		});
		contentPane.add(autoSpin);
		return contentPane;
	}

	class Worker extends SwingWorker<Void, String> {
		JLabel[][] labels;
		int spins;
		JLabel balance;
		JSpinner autoSpinner;
		JLabel lblWinorloseamount;
		int numOfWinLines;
		double lineStake;

		public Worker(JLabel[][] labels, JLabel lblWinorloseamount, JLabel balance, JSpinner autoSpinner, int numOfWinLines, double lineStake) {
			this.labels = labels;
			this.balance = balance;
			this.lblWinorloseamount = lblWinorloseamount;
			this.numOfWinLines = numOfWinLines;
			this.lineStake = lineStake;
			if ((Integer) autoSpinner.getValue() > 0) {
				this.spins = (Integer) autoSpinner.getValue();
			} else {
				this.spins = 1;
			}
			this.autoSpinner = autoSpinner;
		}

		@Override
		protected Void doInBackground() throws Exception {
			while (!isCancelled() && spins > 0) {
				for (int i = 0; i < main.arrayOfWheels.length; i++) {
					for (int j = 0; j < main.arrayOfWheels.length; j++) {
						labels[i][j]
								.setIcon(new ImageIcon("facedown_small.jpg"));
						try {
							Thread.sleep(50); // 1000 milliseconds is one
												// second.
						} catch (InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
					}
				}

				main.spinOnce(numOfWinLines, lineStake);
				for (int i = 0; i < main.arrayOfWheels.length; i++) {
					for (int j = 0; j < main.arrayOfWheels.length; j++) {
						labels[i][j].setIcon(new ImageIcon(
								main.arrayOfWheels[i][j].imageString()));
						try {
							Thread.sleep(50); // 1000 milliseconds is one
												// second.
						} catch (InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
					}
				}
				balance.setText(String.valueOf("Balance: �"
						+ main.userDetails.getBalance()));
				lblWinorloseamount.setText(main.getWinOrLoseString(main
						.getWinOrLoseAmount()));
				spins--;
				if (spins != 0) {
					autoSpinner.setValue(spins);
				}
				try {
					Thread.sleep(2000); // 1000 milliseconds is one second.
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}

			return null;
		}

	}
}
