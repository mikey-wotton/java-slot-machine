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
import javax.swing.SpringLayout;
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
	private Color bgColour;

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
		bgColour = new Color(0, 153, 102);
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
		frame.setBackground(bgColour);

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
		mainScreen.setBackground(bgColour);
		mainScreen.setLayout(new BorderLayout());

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(bgColour);
		centerPanel.setLayout(new FlowLayout());

		JPanel bannerPanel = new JPanel();
		bannerPanel.setLayout(new FlowLayout());
		bannerPanel.setBackground(bgColour);

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
		buttonsPanel.setBackground(bgColour);
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
		contentPane.setBackground(bgColour);
		contentPane.setLayout(new BorderLayout());

		JPanel holdingPanel = new JPanel();
		holdingPanel.setLayout(new OverlayLayout(holdingPanel));
		holdingPanel.setBackground(bgColour);

		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(new GridLayout(5,5));
		cardPanel.setBackground(bgColour);
		//cardPanel.setOpaque(false);
		
		JPanel bannerPanel = new JPanel();
		bannerPanel.setLayout(new FlowLayout());
		bannerPanel.setBackground(bgColour);

		JLabel banner = new JLabel();
		banner.setIcon(new ImageIcon("banner.png"));
		banner.setOpaque(false);
		bannerPanel.add(banner);
		contentPane.add(bannerPanel, BorderLayout.PAGE_START);
		

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
		winLinePanel.setOpaque(false);
		JLabel[] winLineArray = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			winLineArray[i] = new JLabel();
			winLineArray[i].setIcon(new StretchIcon("line_" + String.valueOf(i)+ ".png"));
			winLineArray[i].setVisible(false);
			winLinePanel.add(winLineArray[i]);
		}
		
		holdingPanel.add(winLinePanel);
		holdingPanel.add(cardPanel);

		
		
		
		//LINE_END COMPONENTS
		JPanel lineEnd_springLayout = new JPanel();
		SpringLayout endSpringLayout = new SpringLayout();
		lineEnd_springLayout.setLayout(endSpringLayout);
		lineEnd_springLayout.setBackground(bgColour);
		lineEnd_springLayout.setPreferredSize(new Dimension(180,300));
		
		JLabel lblwinLines = new JLabel("No. of Win Lines: ");	
		SpinnerNumberModel modelWinLinesSpinner = new SpinnerNumberModel(1, 1, 10, 1);
		JSpinner winLinesSpinner = new JSpinner(modelWinLinesSpinner);
		winLinesSpinner.setEditor(new JSpinner.DefaultEditor(winLinesSpinner));		
		endSpringLayout.putConstraint(SpringLayout.WEST, lblwinLines, 10, SpringLayout.WEST, lineEnd_springLayout);
		endSpringLayout.putConstraint(SpringLayout.NORTH, lblwinLines, 10, SpringLayout.NORTH, lineEnd_springLayout);
		endSpringLayout.putConstraint(SpringLayout.NORTH, winLinesSpinner, 10, SpringLayout.NORTH, lineEnd_springLayout);
		endSpringLayout.putConstraint(SpringLayout.EAST, winLinesSpinner, 0, SpringLayout.EAST, lineEnd_springLayout);
		endSpringLayout.putConstraint(SpringLayout.WEST, winLinesSpinner, 5, SpringLayout.EAST, lblwinLines);
		
		JLabel lblstakeValue = new JLabel("Stake per line:  ");
		SpinnerNumberModel modelStakeSpinner = new SpinnerNumberModel(1, 1, 10,	0.5);
		JSpinner winStakeSpinner = new JSpinner(modelStakeSpinner);
		winStakeSpinner.setEditor(new JSpinner.DefaultEditor(winStakeSpinner));		
		endSpringLayout.putConstraint(SpringLayout.WEST, lblstakeValue, 20, SpringLayout.WEST, lineEnd_springLayout);
		endSpringLayout.putConstraint(SpringLayout.NORTH, lblstakeValue, 7, SpringLayout.SOUTH, lblwinLines);
		endSpringLayout.putConstraint(SpringLayout.NORTH, winStakeSpinner, 5, SpringLayout.SOUTH, winLinesSpinner);
		endSpringLayout.putConstraint(SpringLayout.EAST, winStakeSpinner, 0, SpringLayout.EAST, lineEnd_springLayout);
		endSpringLayout.putConstraint(SpringLayout.WEST, winStakeSpinner, 5, SpringLayout.EAST, lblstakeValue);
		
		lineEnd_springLayout.add(winLinesSpinner);
		lineEnd_springLayout.add(lblwinLines);
		lineEnd_springLayout.add(winStakeSpinner);
		lineEnd_springLayout.add(lblstakeValue);

		//LINE_START COMPONENTS
		JPanel lineStart_springLayout = new JPanel();
		SpringLayout startSpringLayout = new SpringLayout();
		lineStart_springLayout.setBackground(bgColour);
		lineStart_springLayout.setLayout(startSpringLayout);
		lineStart_springLayout.setPreferredSize(new Dimension(180,300));

		JLabel lblUserName = new JLabel("Username: "+ main.userDetails.getUsername());
		startSpringLayout.putConstraint(SpringLayout.WEST, lblUserName, 10, SpringLayout.WEST, lineStart_springLayout);
		startSpringLayout.putConstraint(SpringLayout.NORTH, lblUserName, 10, SpringLayout.NORTH, lineStart_springLayout);
		
		JLabel lblBalance = new JLabel("Balance: "+ String.valueOf(main.userDetails.getBalance()));
		startSpringLayout.putConstraint(SpringLayout.WEST, lblBalance, 10, SpringLayout.WEST, lineStart_springLayout);
		startSpringLayout.putConstraint(SpringLayout.NORTH, lblBalance, 5, SpringLayout.SOUTH, lblUserName);
		
		lineStart_springLayout.add(lblUserName);
		lineStart_springLayout.add(lblBalance);

		
		//the Page_End of the boxLayout grid
		JPanel bottomBorderLayoutPanel = new JPanel();
		bottomBorderLayoutPanel.setLayout(new BorderLayout());
		bottomBorderLayoutPanel.setBackground(bgColour);
		
		//bottom_CENTER components
		JLabel lblWinOrLoseAmount = new JLabel("winOrLoseAmount",SwingConstants.CENTER);
		lblWinOrLoseAmount.setText("Welcome, good luck!");
			
		//bottom_LINESTART components
		JPanel bottomBorder_LineStart = new JPanel();
		SpringLayout bottom_LineStartSwing = new SpringLayout();
		bottomBorder_LineStart.setLayout(bottom_LineStartSwing);
		bottomBorder_LineStart.setBackground(bgColour);
		bottomBorder_LineStart.setPreferredSize(new Dimension(180,100));
		
		JLabel lblNumberOfAutoSpins = new JLabel("autoPlaySpins");
		lblNumberOfAutoSpins.setText("No. of Auto-spins: ");
	
		SpinnerNumberModel model1 = new SpinnerNumberModel(1, 1, 100, 1);
		JSpinner autoSpinner = new JSpinner(model1);
		autoSpinner.setEditor(new JSpinner.DefaultEditor(autoSpinner));
		autoSpinner.setPreferredSize(new Dimension(40,20));
		
		JButton autoSpin = new JButton("Auto-Play");
		autoSpin.setPreferredSize(new Dimension(145,55));
		autoSpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (worker != null) {
					worker.cancel(true);
				}
				worker = new Worker(labels, lblWinOrLoseAmount, lblBalance,	autoSpinner, (Integer) winLinesSpinner.getValue(), (double) winStakeSpinner.getValue(), winLineArray);
				worker.execute();
			}
		});
		
		bottom_LineStartSwing.putConstraint(SpringLayout.WEST, lblNumberOfAutoSpins, 10, SpringLayout.WEST, bottomBorder_LineStart);
		bottom_LineStartSwing.putConstraint(SpringLayout.NORTH, lblNumberOfAutoSpins, 10, SpringLayout.NORTH, bottomBorder_LineStart);
		
		bottom_LineStartSwing.putConstraint(SpringLayout.WEST, autoSpinner, 0, SpringLayout.EAST, lblNumberOfAutoSpins);
		bottom_LineStartSwing.putConstraint(SpringLayout.NORTH, autoSpinner, 10, SpringLayout.NORTH, bottomBorder_LineStart);
		
		bottom_LineStartSwing.putConstraint(SpringLayout.WEST, autoSpin, 10, SpringLayout.WEST, bottomBorder_LineStart);
		bottom_LineStartSwing.putConstraint(SpringLayout.NORTH, autoSpin, 10, SpringLayout.SOUTH, lblNumberOfAutoSpins);

		
		bottomBorder_LineStart.add(autoSpin);
		bottomBorder_LineStart.add(lblNumberOfAutoSpins);
		bottomBorder_LineStart.add(autoSpinner);
		
		

		
		//bottom_LINEEND components
		JPanel bottomBorder_LineEnd = new JPanel();
		SpringLayout bottom_LineEndSwing = new SpringLayout();
		bottomBorder_LineEnd.setLayout(bottom_LineEndSwing);
		bottomBorder_LineEnd.setBackground(bgColour);
		bottomBorder_LineEnd.setPreferredSize(new Dimension(180,100));
		JButton spinOnce = new JButton("Spin Once");
		spinOnce.setPreferredSize(new Dimension(145,55));
		spinOnce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (worker != null) {
					worker.cancel(true);
				}
				autoSpinner.setValue(1);
				worker = new Worker(labels, lblWinOrLoseAmount, lblBalance,	autoSpinner, (Integer) winLinesSpinner.getValue(), (double) winStakeSpinner.getValue(), winLineArray);
				worker.execute();
			}
		});
		bottom_LineEndSwing.putConstraint(SpringLayout.EAST, spinOnce, -10, SpringLayout.EAST, bottomBorder_LineEnd);
		bottom_LineEndSwing.putConstraint(SpringLayout.SOUTH, spinOnce,  -10, SpringLayout.SOUTH, bottomBorder_LineEnd);
		bottomBorder_LineEnd.add(spinOnce);
		
		
		//bottomBorder adding components
		bottomBorderLayoutPanel.add(bottomBorder_LineStart,BorderLayout.LINE_START);
		bottomBorderLayoutPanel.add(lblWinOrLoseAmount, BorderLayout.CENTER);
		bottomBorderLayoutPanel.add(bottomBorder_LineEnd,BorderLayout.LINE_END);

		
		//contentPane add components
		contentPane.add(lineEnd_springLayout, BorderLayout.LINE_END);
		contentPane.add(lineStart_springLayout, BorderLayout.LINE_START);
		contentPane.add(holdingPanel, BorderLayout.CENTER);
		contentPane.add(bottomBorderLayoutPanel, BorderLayout.PAGE_END);

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
						System.out.println(labels[i][j].getBounds());
						labels[i][j].setIcon(new StretchIcon("facedown_small.jpg"));
						
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
						labels[i][j].setIcon(new StretchIcon(main.arrayOfWheels[i][j].imageString()));
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
				balance.setText(String.valueOf("Balance: £"	+ main.userDetails.getBalance()));
				lblWinorloseamount.setText(main.getWinOrLoseString(main.getWinOrLoseAmount()));
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
