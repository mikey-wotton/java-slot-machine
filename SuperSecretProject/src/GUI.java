import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSpinner;
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
	private JLabel getTop(){
		JLabel banner = new JLabel();
		banner.setIcon(new StretchIcon("banner.png"));		
		banner.setOpaque(false);;
		return banner;
	}
	
	private JPanel getMiddle(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,5));
		panel.setOpaque(true);
		JLabel[] array = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			array[i] = new JLabel();
			array[i].setIcon(new StretchIcon(String.valueOf(i) + "_front.jpg"));
			panel.add(array[i]);
		}
		return panel;
	}
	private JPanel generateBlankPanel(){
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		return panel;
	}
	private void getBottom(JPanel mainScreen){
		GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.2;
        c.weighty = 0.05;
        c.insets = new Insets(5,5,5,5);
		JButton simPlay = new JButton("Simulated Play");
		simPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen.setVisible(false);
				JPanel simScreen = simPlay();
				frame.getContentPane().add(simScreen);
				simScreen.setVisible(true);
			}
		});
		mainScreen.add(simPlay, c);
		c.gridx = 4;
		JButton realPlay = new JButton("   Real Play  ");
		realPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Real Play");
			}
		});
		mainScreen.add(realPlay, c);
		//Blank filler panels to space the grid, possibly use in future
        c.weightx = 0.2;
		c.gridx = 1;
		mainScreen.add(generateBlankPanel(), c);
		c.gridx = 2;
		mainScreen.add(generateBlankPanel(), c);
		c.gridx = 3;
		mainScreen.add(generateBlankPanel(), c);

	}
	private JPanel getMainScreen(){
		JPanel mainScreen = new JPanel();
		mainScreen.setBackground(bgColour);
		mainScreen.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.gridwidth = 5;
        c.insets = new Insets(5,5,5,5);
		mainScreen.add(getTop(), c);	
		c.gridy = 1;
		c.gridx = 1;
        c.weighty = 0.7;
        c.gridwidth = 3;
        mainScreen.add(getMiddle(), c);
        getBottom(mainScreen);
		return mainScreen;
	}
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Mikey's Not So Wild Slots");
		frame.setBackground(bgColour);
		frame.getContentPane().add(getMainScreen());
	}
	
	private JLabel[][] getLblWheelsArray(JPanel cardPanel){
		JLabel[][] lblWheelsArray = new JLabel[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				lblWheelsArray[j][i] = new JLabel();
				lblWheelsArray[j][i].setIcon(new StretchIcon("facedown_small.jpg"));
				lblWheelsArray[j][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				lblWheelsArray[j][i].setOpaque(false);
				cardPanel.add(lblWheelsArray[j][i]);
			}
		}
		return lblWheelsArray;
	}
	
	private JLabel[] getLblWinLinesArray(JPanel holdingPane){
		JLabel[] lblWinLinesArray = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			lblWinLinesArray[i] = new JLabel();
			lblWinLinesArray[i].setIcon(new StretchIcon("winLines\\line_" + String.valueOf(i)+ ".png", false));
			lblWinLinesArray[i].setOpaque(false);
			holdingPane.add(lblWinLinesArray[i], String.valueOf(i));
		}
		return lblWinLinesArray;
	}
	

	public JPanel simPlay() {
		JPanel contentPane = new JPanel();
		contentPane.setBackground(bgColour);
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.2;
        c.gridwidth = 5;
        c.insets = new Insets(5,5,5,5);
		//Sets up the text banner
		contentPane.add(getTop(), c);		
		//Used to hold the cardPanel and then the winLine Panel above it with a CardLayout
		JPanel holdingPane = new JPanel();
		CardLayout card = new CardLayout();
		holdingPane.setLayout(card);
		holdingPane.setOpaque(false);
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(new GridLayout(5,5));
		cardPanel.setOpaque(false);		
		
		JLabel[][] lblWheelsArray = getLblWheelsArray(cardPanel);
		JLabel[] lblWinLinesArray = getLblWinLinesArray(holdingPane);
		holdingPane.add(cardPanel, "11");		
		card.show(holdingPane, "11");
		
		//LINE_END COMPONENTS
		JPanel lineEnd_springLayout = new JPanel();
		SpringLayout endSpringLayout = new SpringLayout();
		lineEnd_springLayout.setLayout(endSpringLayout);
		lineEnd_springLayout.setBackground(bgColour);
		
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
		JLabel lblUserName = new JLabel("Username: "+ main.userDetails.getUsername());
		startSpringLayout.putConstraint(SpringLayout.WEST, lblUserName, 10, SpringLayout.WEST, lineStart_springLayout);
		startSpringLayout.putConstraint(SpringLayout.NORTH, lblUserName, 10, SpringLayout.NORTH, lineStart_springLayout);
		
		JLabel lblBalance = new JLabel("Balance: "+ String.valueOf(main.userDetails.getBalance()));
		startSpringLayout.putConstraint(SpringLayout.WEST, lblBalance, 10, SpringLayout.WEST, lineStart_springLayout);
		startSpringLayout.putConstraint(SpringLayout.NORTH, lblBalance, 5, SpringLayout.SOUTH, lblUserName);
		
		lineStart_springLayout.add(lblUserName);
		lineStart_springLayout.add(lblBalance);

		
		//the Page_End of the boxLayout grid
		//bottom_CENTER components
		JLabel lblWinOrLoseAmount = new JLabel("winOrLoseAmount",SwingConstants.CENTER);
		lblWinOrLoseAmount.setText("Welcome, good luck!");
		lblWinOrLoseAmount.setFont(new Font("Serif", Font.BOLD, 30));

		//bottom_LINESTART components
		JPanel bottomBorder_LineStart = new JPanel();
		SpringLayout bottom_LineStartSwing = new SpringLayout();
		bottomBorder_LineStart.setLayout(bottom_LineStartSwing);
		bottomBorder_LineStart.setBackground(bgColour);
		
		JLabel lblNumberOfAutoSpins = new JLabel("autoPlaySpins");
		lblNumberOfAutoSpins.setText("No. of Auto-spins: ");
	
		SpinnerNumberModel model1 = new SpinnerNumberModel(1, 1, 100, 1);
		JSpinner autoSpinner = new JSpinner(model1);
		autoSpinner.setEditor(new JSpinner.DefaultEditor(autoSpinner));
		
		JButton autoSpin = new JButton("Auto-Play");
		autoSpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (worker != null) {
					worker.cancel(true);
				}
				worker = new Worker(lblWheelsArray, lblWinOrLoseAmount, lblBalance,	autoSpinner, (Integer) winLinesSpinner.getValue(), (double) winStakeSpinner.getValue(), lblWinLinesArray);
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
		JButton spinOnce = new JButton("Spin Once");
		spinOnce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (worker != null) {
					worker.cancel(true);
				}
				autoSpinner.setValue(1);
				worker = new Worker(lblWheelsArray, lblWinOrLoseAmount, lblBalance,	autoSpinner, (Integer) winLinesSpinner.getValue(), (double) winStakeSpinner.getValue(), lblWinLinesArray);
				worker.execute();
			}
		});
		bottomBorder_LineEnd.add(spinOnce);
		
		
		//bottomBorder adding components


		
		//contentPane add components
		c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.1;
        c.weighty = 0.6;
        c.gridwidth = 1;
        c.insets = new Insets(5,5,5,5);
		contentPane.add(lineStart_springLayout, c);
		c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.8;
        c.weighty = 0.6;
        c.gridwidth = 3;
        c.insets = new Insets(5,5,5,5);
		contentPane.add(holdingPane, c);
		c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 1;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.1;
        c.weighty = 0.6;
        c.gridwidth = 1;
        c.insets = new Insets(5,5,5,5);
		contentPane.add(lineEnd_springLayout, c);


		c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.2;
        c.weighty = 0.2;
		contentPane.add(bottomBorder_LineStart, c);
		c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.2;
        c.weighty = 0.2;
        contentPane.add(generateBlankPanel(), c);
		c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.2;
        c.weighty = 0.2;
        contentPane.add(lblWinOrLoseAmount, c);
		c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.2;
        c.weighty = 0.2;
        contentPane.add(generateBlankPanel(), c);
		c = new GridBagConstraints();
        c.gridx = 4;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.2;
        c.weighty = 0.2;
        contentPane.add(bottomBorder_LineEnd, c);
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

		public Worker(JLabel[][] labels, JLabel lblWinorloseamount,	JLabel balance, JSpinner autoSpinner, int numOfWinLines, double lineStake, JLabel[] winLineLabelArray) {
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
				lblWinorloseamount.setText(main.getWinOrLoseString(main.getTotalWon()));
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
