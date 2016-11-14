import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.OverlayLayout;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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
		main = new Main("Mr. Lister", 500.00);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Mikey's Not So Wild Slots");
		frame.setBackground(new Color(250, 78, 91));

		// sets and handles the minimum size of the frame, disallowing users
		// resizing application to tiny a small window.
		frame.setMinimumSize(new Dimension(900, 700));
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {
				Dimension size = frame.getSize();
				Dimension min = frame.getMinimumSize();
				if (size.getWidth() < min.getWidth()) {
					frame.setSize((int) min.getWidth(), (int) size.getHeight());
				}
				if (size.getHeight() < min.getHeight()) {
					frame.setSize((int) size.getWidth(), (int) min.getHeight());
				}
			}
		});
		// ----------------------------------------

		JPanel mainScreen = new JPanel();
		mainScreen.setBackground(new Color(0, 153, 102));
		mainScreen.setLayout(new BorderLayout());

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(0, 153, 102));
		centerPanel.setLayout(new FlowLayout());

		JPanel bannerPanel = new JPanel();
		bannerPanel.setLayout(new FlowLayout());
		bannerPanel.setBackground(new Color(0, 153, 102));

		JLabel banner = new JLabel();
		banner.setIcon(new ImageIcon("banner.png"));
		banner.setOpaque(false);
		bannerPanel.add(banner);
		mainScreen.add(bannerPanel, BorderLayout.PAGE_START);

		JLabel[] array = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			array[i] = new JLabel();
			// array[i].setVerticalAlignment(SwingConstants.Center);
			array[i].setIcon(new ImageIcon(String.valueOf(i) + "_front.jpg"));
			centerPanel.add(array[i], BorderLayout.CENTER);
		}

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(0, 153, 102));
		buttonsPanel.setLayout(new BorderLayout());

		JButton simPlay = new JButton("Simulated Play");
		simPlay.setPreferredSize(new Dimension(200, 80));
		simPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen.setVisible(false);
				JPanel simScreen = simPlay();
				frame.getContentPane().add(simScreen);
				simScreen.setVisible(true);

			}
		});
		buttonsPanel.add(simPlay, BorderLayout.LINE_START);

		JButton realPlay = new JButton("Real Play");
		realPlay.setPreferredSize(new Dimension(200, 80));
		realPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Real Play");
			}
		});
		buttonsPanel.add(realPlay, BorderLayout.LINE_END);
		mainScreen.add(centerPanel, BorderLayout.CENTER);
		mainScreen.add(buttonsPanel, BorderLayout.PAGE_END);
		frame.getContentPane().add(mainScreen);

	}

	public JPanel simPlay() {
		JPanel contentPane = new JPanel();
		JLabel[][] labels = new JLabel[5][5];
		contentPane.setMinimumSize(new Dimension(900, 700));
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setLayout(new BorderLayout());

		JPanel holdingPanel = new JPanel();
		holdingPanel.setLayout(new OverlayLayout(holdingPanel));
		holdingPanel.setBackground(new Color(46, 139, 87));
		holdingPanel.setBounds(215, 10, 450, 460);

		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(new GridLayout(5,5));
		cardPanel.setBackground(Color.WHITE);
		//cardPanel.setOpaque(false);

		// Create Labels for the wheels
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				labels[j][i] = new JLabel();
			}
		}
		// Set those labels to face down image and place them inside the gridlayout
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				labels[i][j].setIcon(new StretchIcon("facedown_small.jpg"));
				labels[i][j].setOpaque(false);
				cardPanel.add(labels[i][j]);
			}
		}
		
		// Panels used to show win lines with an OverlayLayout manager		
		JPanel winLinePanel = new JPanel();
		winLinePanel.setLayout(null);
		winLinePanel.setBounds(283, 264, 390, 200);
		winLinePanel.setOpaque(false);
		JLabel[] winLineArray = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			winLineArray[i] = new JLabel();
			winLineArray[i].setIcon(new ImageIcon("line_" + String.valueOf(i)
					+ ".png"));
			winLineArray[i].setBounds(34, 127, 390, 200);
			winLineArray[i].setVisible(false);
			winLinePanel.add(winLineArray[i]);
		}
		
		//the Page_End of the boxLayout grid
		JPanel bottomBorderLayoutPanel = new JPanel();
		bottomBorderLayoutPanel.setLayout(new BorderLayout());
		bottomBorderLayoutPanel.setBackground(new Color(200, 99, 30));
		
		JLabel lblWinOrLoseAmount = new JLabel("winOrLoseAmount",SwingConstants.CENTER);
		lblWinOrLoseAmount.setText("Welcome, good luck!");
		
		
		JLabel lblUserName = new JLabel("Username: "+ main.userDetails.getUsername()+ "     ");
		lblUserName.setBounds(10, 10, 200, 20);

		
		
		
		bottomBorderLayoutPanel.add(lblWinOrLoseAmount, BorderLayout.CENTER);
		
		
		

		holdingPanel.add(winLinePanel);
		holdingPanel.add(cardPanel);

		contentPane.add(bottomBorderLayoutPanel, BorderLayout.PAGE_END);

		contentPane.add(lblUserName, BorderLayout.LINE_START);

		contentPane.add(holdingPanel, BorderLayout.CENTER);

		return contentPane;
	}

	class Worker extends SwingWorker<Void, String> {
		JLabel[][] labels;
		int spins;
		JLabel balance;
		JSpinner autoSpinner;
		JLabel lblWinorloseamount;
		int numOfWinLines;
		JLabel[] winLineLabelArray;
		double lineStake;

		public Worker(JLabel[][] labels, JLabel lblWinorloseamount,
				JLabel balance, JSpinner autoSpinner, int numOfWinLines,
				double lineStake, JLabel[] winLineLabelArray) {
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
			this.winLineLabelArray = winLineLabelArray;
		}

		@Override
		protected Void doInBackground() throws Exception {
			while (!isCancelled() && spins > 0) {
				for (int i = 0; i < main.arrayOfWheels.length; i++) {
					for (int j = 0; j < main.arrayOfWheels.length; j++) {
						labels[i][j]
								.setIcon(new ImageIcon("facedown_small.jpg"));
						try {
							Thread.sleep(20);
						} catch (InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
					}
				}

				main.spinOnce(numOfWinLines, lineStake);
				int[] winLineArray = main.getWinLineArray();
				for (int i = 0; i < main.arrayOfWheels.length; i++) {
					for (int j = 0; j < main.arrayOfWheels.length; j++) {
						labels[i][j].setIcon(new ImageIcon(
								main.arrayOfWheels[i][j].imageString()));
						try {
							Thread.sleep(50);
						} catch (InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
					}
				}
				for (int k = 0; k < winLineLabelArray.length; k++) {
					if (winLineArray[k] == 1) {
						winLineLabelArray[k].setVisible(true);
					}
				}
				balance.setText(String.valueOf("Balance: £"
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
				for (int k = 0; k < winLineLabelArray.length; k++) {
					winLineLabelArray[k].setVisible(false);
				}
			}

			return null;
		}

	}
}
