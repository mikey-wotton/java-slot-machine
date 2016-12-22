import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingWorker;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class GUI {
	public Main main;
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menu, submenu;
	private JMenuItem menuItem;
	private CardLayout cl1;

	private SwingWorker<Void, String> worker;
	private SwingWorker<Void, String> helpWorker;
	private Color bgColour;
	private URL facedown;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		menuBar = new JMenuBar();
		main = new Main("Mr. Lister", 500.00);
		bgColour = new Color(0, 153, 102);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private JPanel getMiddle() {
		JPanel panel = new JPanel();
		// SpringLayout swing = new SpringLayout();
		panel.setLayout(new GridLayout(2, 4));
		panel.setBackground(bgColour);
		int i = 0;
		JLabel[] array = new JLabel[8];
		for (Symbols s : Symbols.values()) {
			array[i] = new JLabel();
			array[i].setIcon(new StretchIcon(s.getLargeImageString()));
			panel.add(array[i]);
			i++;
		}
		return panel;
	}

	private JPanel generateBlankPanel() {
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		return panel;
	}

	private void getBottom(JPanel mainScreen) {
		GridBagConstraints c = new GridBagConstraints();

		JButton simPlay = new JButton("Simulated Play");
		simPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel simScreen = simPlay();
				frame.add(simScreen, "1");
				cl1.show(frame.getContentPane(), "1");
			}
		});
		c = createGridBagConstraints(0, 1, java.awt.GridBagConstraints.BOTH, 0.3, 0.05, 1, 10, 10, 10, 10);
		mainScreen.add(simPlay, c);

		JButton realPlay = new JButton("   Real Play  ");
		realPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Real Play");
			}
		});
		c = createGridBagConstraints(2, 1, java.awt.GridBagConstraints.BOTH, 0.3, 0.05, 1, 10, 10, 10, 10);
		mainScreen.add(realPlay, c);

		// Blank filler panels to space the grid, possibly use in future
		c = createGridBagConstraints(1, 1, java.awt.GridBagConstraints.BOTH, 0.4, 0.05, 1, 10, 10, 10, 10);
		mainScreen.add(generateBlankPanel(), c);
	}

	private JPanel getMainScreen() {
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		// a group of JMenuItems
		menuItem = new JMenuItem("Screenshot (TBI)", KeyEvent.VK_T);
		menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		menu.add(menuItem);

		// a submenu
		menu.addSeparator();
		submenu = new JMenu("Volume Options");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("100% Volume");
		submenu.add(menuItem);
		menu.add(submenu);
		menuItem = new JMenuItem("80% Volume");
		submenu.add(menuItem);
		menu.add(submenu);
		menuItem = new JMenuItem("60% Volume");
		submenu.add(menuItem);
		menu.add(submenu);
		menuItem = new JMenuItem("40% Volume");
		submenu.add(menuItem);
		menu.add(submenu);
		menuItem = new JMenuItem("20% Volume");
		submenu.add(menuItem);
		menu.add(submenu);
		menuItem = new JMenuItem("Muted");
		submenu.add(menuItem);
		menu.add(submenu);

		menuBar.add(menu);
		frame.setJMenuBar(menuBar);

		JPanel mainScreen = new JPanel();
		mainScreen.setBackground(bgColour);
		mainScreen.setLayout(new GridBagLayout());
		GridBagConstraints c = createGridBagConstraints(0, 0, java.awt.GridBagConstraints.BOTH, 0, 0.8, 3, 5, 5, 5, 5);
		mainScreen.add(getMiddle(), c);
		getBottom(mainScreen);
		return mainScreen;
	}

	private void initialize() {
		frame = new JFrame();
		facedown = GUI.class.getResource("facedown_small.jpg");
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Mikey's Not So Wild Slots");
		frame.setBackground(bgColour);
		frame.setMinimumSize(new Dimension(800, 850));
		cl1 = new CardLayout();
		frame.getContentPane().setLayout(cl1);
		frame.getContentPane().add(getMainScreen(), "0");
	}

	private JLabel[][] getLblWheelsArray(JPanel cardPanel) {
		JLabel[][] lblWheelsArray = new JLabel[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				lblWheelsArray[j][i] = new JLabel();
				lblWheelsArray[j][i].setIcon(new StretchIcon(facedown));
				lblWheelsArray[j][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				lblWheelsArray[j][i].setOpaque(false);
				cardPanel.add(lblWheelsArray[j][i]);
			}
		}
		return lblWheelsArray;
	}

	private JLabel[] getLblWinLinesArray(JPanel holdingPane) {
		JLabel[] lblWinLinesArray = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			lblWinLinesArray[i] = new JLabel();
			lblWinLinesArray[i].setIcon(new StretchIcon(GUI.class.getResource("/winLines/line_" + String.valueOf(i) + ".png"), false));
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

		// holdingPane holds both returnedWheels (which symbols go into) and
		JPanel holdingPane = new JPanel();
		CardLayout card = new CardLayout();
		holdingPane.setLayout(card);
		holdingPane.setOpaque(false);
		JPanel returnedWheels = new JPanel();
		returnedWheels.setLayout(new GridLayout(5, 5));
		returnedWheels.setOpaque(false);

		JLabel[][] lblWheelsArray = getLblWheelsArray(returnedWheels);
		JLabel[] lblWinLinesArray = getLblWinLinesArray(holdingPane);
		holdingPane.add(returnedWheels, "11");
		card.show(holdingPane, "11");

		// Upper Right Panel creation
		SpinnerNumberModel modelWinLinesSpinner = new SpinnerNumberModel(1, 1, 10, 1);
		SpinnerNumberModel modelStakeSpinner = new SpinnerNumberModel(1, 1, 10, 0.5);
		JSpinner winLinesSpinner = new JSpinner(modelWinLinesSpinner);
		JSpinner winStakeSpinner = new JSpinner(modelStakeSpinner);
		JPanel upperRightPanel = createUpperRightPanel(winLinesSpinner, winStakeSpinner);

		// Upper Left Panel creation
		JLabel lblBalance = new JLabel("Balance: " + String.valueOf(main.userDetails.getBalance()));
		JPanel upperLeftPanel = createUpperLeftPanel(lblBalance);

		// Bottom Middle JLabel
		JLabel lblWinOrLoseAmount = new JLabel("winOrLoseAmount", SwingConstants.CENTER);
		lblWinOrLoseAmount.setText("Welcome, good luck!");
		lblWinOrLoseAmount.setFont(new Font("Serif", Font.BOLD, 25));
		lblWinOrLoseAmount.setPreferredSize(new Dimension(350, 50));

		// Bottom Left Panel creation
		SpinnerNumberModel model1 = new SpinnerNumberModel(1, 1, 100, 1);
		JSpinner autoSpinner = new JSpinner(model1);
		autoSpinner.setEditor(new JSpinner.DefaultEditor(autoSpinner));
		JButton autoSpin = new JButton("Auto-Play");
		JButton spinOnce = new JButton("Spin Once");
		JButton[] jbuttonArray = new JButton[2];
		jbuttonArray[0] = spinOnce;
		jbuttonArray[1] = autoSpin;
		autoSpin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (worker != null) {
					worker.cancel(true);
				}
				worker = new Worker(lblWheelsArray, lblWinOrLoseAmount, lblBalance, autoSpinner, (Integer) winLinesSpinner.getValue(),
						(double) winStakeSpinner.getValue(), lblWinLinesArray, jbuttonArray);
				worker.execute();
			}
		});
		JPanel bottomLeftPanel = createBottomLeftPanel(autoSpin, autoSpinner);

		spinOnce.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (worker != null) {
					worker.cancel(true);
				}
				autoSpinner.setValue(1);
				worker = new Worker(lblWheelsArray, lblWinOrLoseAmount, lblBalance, autoSpinner, (Integer) winLinesSpinner.getValue(),
						(double) winStakeSpinner.getValue(), lblWinLinesArray, jbuttonArray);
				worker.execute();
			}
		});
		JPanel bottomRightPanel = createBottomRightPanel(spinOnce);

		// contentPane add components
		// use GridBagConstraints to layout panels
		c = createGridBagConstraints(0, 1, java.awt.GridBagConstraints.BOTH, 0.5, 0.2, 1, 5, 5, 5, 5);
		contentPane.add(upperLeftPanel, c);
		c = createGridBagConstraints(2, 1, java.awt.GridBagConstraints.BOTH, 0.5, 0.2, 1, 5, 5, 5, 5);
		contentPane.add(upperRightPanel, c);
		c = createGridBagConstraints(0, 2, java.awt.GridBagConstraints.BOTH, 1.0, 0.1, 3, 5, 5, 5, 5);
		contentPane.add(holdingPane, c);
		c = createGridBagConstraints(0, 3, java.awt.GridBagConstraints.BOTH, 0.3, 0.2, 1, 5, 5, 5, 5);
		contentPane.add(bottomLeftPanel, c);
		c = createGridBagConstraints(1, 3, java.awt.GridBagConstraints.BOTH, 0.3, 0.2, 1, 5, 5, 5, 5);
		contentPane.add(lblWinOrLoseAmount, c);
		c = createGridBagConstraints(2, 3, java.awt.GridBagConstraints.BOTH, 0.3, 0.2, 1, 5, 5, 5, 5);
		contentPane.add(bottomRightPanel, c);

		menu = new JMenu("Show Win Lines");
		menu.getAccessibleContext().setAccessibleDescription("Displays currently playing win lines");
		menu.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				if (helpWorker != null) {
					helpWorker.cancel(true);
				}
				helpWorker = new helpWorker(lblWinLinesArray, (Integer) winLinesSpinner.getValue());
				helpWorker.execute();
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				if (helpWorker != null) {
					helpWorker.cancel(true);
				}
			}

			@Override
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		menuBar.add(menu);

		return contentPane;
	}

	public GridBagConstraints createGridBagConstraints(int gridx, int gridy, int fill, double weightx, double weighty, int gridwidth,
			int inseti, int insetj, int insetk, int insetl) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = gridx;
		c.gridy = gridy;
		c.fill = fill;
		c.weightx = weightx;
		c.weighty = weighty;
		c.gridwidth = gridwidth;
		c.insets = new Insets(inseti, insetj, insetk, insetl);
		return c;
	}

	public JPanel createBottomRightPanel(JButton spinOnce) {
		JPanel bottomRightPanel = new JPanel();
		SpringLayout brSwing = new SpringLayout();
		bottomRightPanel.setLayout(brSwing);
		bottomRightPanel.setBackground(bgColour);

		brSwing.putConstraint(SpringLayout.NORTH, spinOnce, -60, SpringLayout.SOUTH, bottomRightPanel);
		brSwing.putConstraint(SpringLayout.SOUTH, spinOnce, -10, SpringLayout.SOUTH, bottomRightPanel);
		brSwing.putConstraint(SpringLayout.WEST, spinOnce, 10, SpringLayout.WEST, bottomRightPanel);
		brSwing.putConstraint(SpringLayout.EAST, spinOnce, -10, SpringLayout.EAST, bottomRightPanel);

		bottomRightPanel.add(spinOnce);
		return bottomRightPanel;
	}

	public JPanel createUpperLeftPanel(JLabel lblBalance) {
		JPanel upperLeftPanel = new JPanel();
		SpringLayout ulSpring = new SpringLayout();
		upperLeftPanel.setBackground(bgColour);
		upperLeftPanel.setLayout(ulSpring);
		JLabel lblUserName = new JLabel("Username: " + main.userDetails.getUsername());
		ulSpring.putConstraint(SpringLayout.WEST, lblUserName, 10, SpringLayout.WEST, upperLeftPanel);
		ulSpring.putConstraint(SpringLayout.NORTH, lblUserName, 10, SpringLayout.NORTH, upperLeftPanel);

		ulSpring.putConstraint(SpringLayout.WEST, lblBalance, 10, SpringLayout.WEST, upperLeftPanel);
		ulSpring.putConstraint(SpringLayout.NORTH, lblBalance, 5, SpringLayout.SOUTH, lblUserName);

		upperLeftPanel.add(lblUserName);
		upperLeftPanel.add(lblBalance);

		return upperLeftPanel;
	}

	public JPanel createUpperRightPanel(JSpinner winLinesSpinner, JSpinner winStakeSpinner) {
		JPanel upperRightPanel = new JPanel();
		SpringLayout urSpring = new SpringLayout();
		upperRightPanel.setLayout(urSpring);
		upperRightPanel.setBackground(bgColour);

		JLabel lblwinLines = new JLabel("No. of Win Lines: ");
		winLinesSpinner.setEditor(new JSpinner.DefaultEditor(winLinesSpinner));
		urSpring.putConstraint(SpringLayout.EAST, lblwinLines, -50, SpringLayout.EAST, upperRightPanel);
		urSpring.putConstraint(SpringLayout.NORTH, lblwinLines, 10, SpringLayout.NORTH, upperRightPanel);
		urSpring.putConstraint(SpringLayout.NORTH, winLinesSpinner, 10, SpringLayout.NORTH, upperRightPanel);
		urSpring.putConstraint(SpringLayout.EAST, winLinesSpinner, -10, SpringLayout.EAST, upperRightPanel);
		urSpring.putConstraint(SpringLayout.WEST, winLinesSpinner, 5, SpringLayout.EAST, lblwinLines);

		JLabel lblstakeValue = new JLabel("Stake per line:  ");
		winStakeSpinner.setEditor(new JSpinner.DefaultEditor(winStakeSpinner));
		urSpring.putConstraint(SpringLayout.EAST, lblstakeValue, -50, SpringLayout.EAST, upperRightPanel);
		urSpring.putConstraint(SpringLayout.NORTH, lblstakeValue, 10, SpringLayout.SOUTH, lblwinLines);
		urSpring.putConstraint(SpringLayout.NORTH, winStakeSpinner, 5, SpringLayout.SOUTH, winLinesSpinner);
		urSpring.putConstraint(SpringLayout.EAST, winStakeSpinner, -10, SpringLayout.EAST, upperRightPanel);
		urSpring.putConstraint(SpringLayout.WEST, winStakeSpinner, 5, SpringLayout.EAST, lblstakeValue);

		upperRightPanel.add(winLinesSpinner);
		upperRightPanel.add(lblwinLines);
		upperRightPanel.add(winStakeSpinner);
		upperRightPanel.add(lblstakeValue);

		return upperRightPanel;
	}

	public JPanel createBottomLeftPanel(JButton autoSpin, JSpinner autoSpinner) {
		JPanel bottomLeftPanel = new JPanel();
		SpringLayout blSwing = new SpringLayout();
		bottomLeftPanel.setLayout(blSwing);
		bottomLeftPanel.setBackground(bgColour);

		JLabel lblNumberOfAutoSpins = new JLabel("autoPlaySpins");
		lblNumberOfAutoSpins.setText("No. of Auto-spins: ");

		blSwing.putConstraint(SpringLayout.NORTH, autoSpin, -60, SpringLayout.SOUTH, bottomLeftPanel);
		blSwing.putConstraint(SpringLayout.WEST, autoSpin, 10, SpringLayout.WEST, bottomLeftPanel);
		blSwing.putConstraint(SpringLayout.SOUTH, autoSpin, -10, SpringLayout.SOUTH, bottomLeftPanel);
		blSwing.putConstraint(SpringLayout.EAST, autoSpin, -10, SpringLayout.EAST, bottomLeftPanel);

		blSwing.putConstraint(SpringLayout.WEST, lblNumberOfAutoSpins, 10, SpringLayout.WEST, bottomLeftPanel);
		blSwing.putConstraint(SpringLayout.SOUTH, lblNumberOfAutoSpins, -10, SpringLayout.NORTH, autoSpin);

		blSwing.putConstraint(SpringLayout.WEST, autoSpinner, 5, SpringLayout.EAST, lblNumberOfAutoSpins);
		blSwing.putConstraint(SpringLayout.EAST, autoSpinner, 45, SpringLayout.EAST, lblNumberOfAutoSpins);
		blSwing.putConstraint(SpringLayout.SOUTH, autoSpinner, -6, SpringLayout.NORTH, autoSpin);

		bottomLeftPanel.add(autoSpin);
		bottomLeftPanel.add(lblNumberOfAutoSpins);
		bottomLeftPanel.add(autoSpinner);
		return bottomLeftPanel;
	}

	class helpWorker extends SwingWorker<Void, String> {
		private JLabel[] winLineLabelArray;
		private int numOfWinLines;

		public helpWorker(JLabel[] winLineLabelArray, int numOfWinLines) {
			this.winLineLabelArray = winLineLabelArray;
			this.numOfWinLines = numOfWinLines;
		}

		@Override
		public Void doInBackground() {
			helperShowWinLines(winLineLabelArray, numOfWinLines);
			while (!isCancelled()) {
				// does nothing
			}
			helperHideWinLines(winLineLabelArray);
			return null;
		}

		private void helperShowWinLines(JLabel[] winLineLabelArray, int numOfWinLines) {
			for (int k = 0; k < numOfWinLines; k++) {
				winLineLabelArray[k].setVisible(true);
			}
		}

		private void helperHideWinLines(JLabel[] winLineLabelArray) {
			for (int k = 0; k < winLineLabelArray.length; k++) {
				winLineLabelArray[k].setVisible(false);
			}
		}
	}

	class Worker extends SwingWorker<Void, String> {
		private JLabel[][] labels;
		private int spins;
		private JLabel balance;
		private JSpinner autoSpinner;
		private JLabel lblWinorloseamount;
		private int numOfWinLines;
		private JLabel[] winLineLabelArray;
		private double lineStake;
		private File soundFile;
		private JButton[] jbuttonArray;

		public Worker(JLabel[][] labels, JLabel lblWinorloseamount, JLabel balance, JSpinner autoSpinner, int numOfWinLines,
				double lineStake, JLabel[] winLineLabelArray, JButton[] jbuttonArray) {
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
			this.jbuttonArray = jbuttonArray;
			soundFile = new File("sounds\\Flipped.wav");
		}

		@Override
		protected Void doInBackground() throws Exception {
			while (!isCancelled() && spins > 0) {
				hideWheelsSymbols();
				main.spinOnce(numOfWinLines, lineStake);
				// setButtons(false);
				showWheelsSymbols();
				showWinLines();
				updateUILabels();
				stopFor(1000);
				hideWinLines();
				if (main.bonusFlagArray[0] == 1) {
					worker.cancel(true);
					createBonusPanel(lineStake * numOfWinLines);
					updateUILabels();
				}
				// setButtons(true);
			}

			return null;
		}

		private void hideWinLines() {
			for (int k = 0; k < winLineLabelArray.length; k++) {
				winLineLabelArray[k].setVisible(false);
			}
		}

		private void setButtons(Boolean toBeSet) {
			for (int i = 0; i < jbuttonArray.length; i++) {
				jbuttonArray[i].setEnabled(toBeSet);
			}
		}

		private void updateUILabels() {
			balance.setText(String.valueOf("Balance: £" + main.userDetails.getBalance()));
			lblWinorloseamount.setText(main.getWinOrLoseString(main.getTotalWon()));
			spins--;
			if (spins != 0) {
				autoSpinner.setValue(spins);
			}
		}

		private void hideWheelsSymbols() {
			for (int i = 0; i < main.arrayOfWheels.length; i++) {
				for (int j = 0; j < main.arrayOfWheels.length; j++) {
					labels[i][j].setIcon(new StretchIcon(facedown));
					stopFor(20);
				}
			}
		}

		private void showWheelsSymbols() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
			for (int i = 0; i < main.arrayOfWheels.length; i++) {
				for (int j = 0; j < main.arrayOfWheels.length; j++) {
					if ((j == 0) || (j == 4)) {
						labels[i][j].setIcon(new AlphaIcon(new StretchIcon(main.arrayOfWheels[i][j].getSmallImageString()), 0.3F));
					} else {
						labels[i][j].setIcon(new StretchIcon(main.arrayOfWheels[i][j].getSmallImageString()));
					}
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(soundFile));
					clip.start();
					stopFor((int) (clip.getMicrosecondLength() / 1000));
				}
			}
		}
		

		private void showWinLines() {
		
			int[] winLineArray = main.getWinLineArray();

			for (int k = 0; k < winLineLabelArray.length; k++) {
				if (winLineArray[k] == 1) {
					winLineLabelArray[k].setVisible(true);
				}
			}
		}

		public void createBonusPanel(double value) {
			double stakeValue = value;
			JPanel mainPanel = new JPanel();
			mainPanel.setBackground(bgColour);
			mainPanel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c = createGridBagConstraints(0, 0, java.awt.GridBagConstraints.BOTH, 0.5, 0.2, 1, 5, 5, 5, 5);
			JLabel prizeWonOnClick = new JLabel("Click to reveal prizes! Avoid black cats!");
			prizeWonOnClick.setFont(new Font("Serif", Font.BOLD, 25));
			prizeWonOnClick.setOpaque(false);
			mainPanel.add(prizeWonOnClick, c);
			c = createGridBagConstraints(1, 0, java.awt.GridBagConstraints.BOTH, 0.5, 0.2, 1, 5, 5, 5, 5);
			JLabel totalPrize = new JLabel("Total Winnings so Far £" + stakeValue * 10);
			totalPrize.setFont(new Font("Serif", Font.BOLD, 25));
			totalPrize.setOpaque(false);
			mainPanel.add(totalPrize, c);

			// Creates Bonus Buttons
			JPanel buttonsPanel = new JPanel();
			buttonsPanel.setOpaque(false);
			buttonsPanel.setLayout(new GridLayout(4, 4));
			JToggleButton[] panelArray = new JToggleButton[16];
			main.addBonusWin(stakeValue * 10);
			for (int i = 0; i < 16; i++) {
				panelArray[i] = createToggleButton(i, totalPrize, prizeWonOnClick, stakeValue);
				panelArray[i].setOpaque(false);
			}
			Random rnd = new Random();
			for (int i = panelArray.length - 1; i > 0; i--) {
				int index = rnd.nextInt(i + 1);
				// Simple swap
				JToggleButton a = panelArray[index];
				panelArray[index] = panelArray[i];
				panelArray[i] = a;
			}
			for (int i = 0; i < 16; i++) {
				buttonsPanel.add(panelArray[i]);
			}
			// end
			c = createGridBagConstraints(0, 1, java.awt.GridBagConstraints.BOTH, 1.0, 0.8, 3, 5, 5, 5, 5);
			mainPanel.add(buttonsPanel, c);

			frame.getContentPane().add(mainPanel, "2");
			cl1.show(frame.getContentPane(), "2");
		}
		
		private void stopFor(int time){
			try {
				Thread.sleep(time); // 1000 milliseconds is one second.
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

		private JToggleButton createToggleButton(int num, JLabel totalPrize, JLabel prizeWonOnClick, double stakeValue) {
			if (num < 4) {
				JToggleButton button = new JToggleButton();
				button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				button.setIcon(new AlphaIcon(new StretchIcon(facedown), 0.7F));
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						button.setEnabled(false);
						button.setIcon(new StretchIcon(Symbols.TEN.getSmallImageString()));
						cl1.show(frame.getContentPane(), "1");
						updateUILabels();
					}
				});
				return button;
			} else if (num < 8) {
				JToggleButton button = new JToggleButton();
				button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				button.setIcon(new AlphaIcon(new StretchIcon(facedown), 0.7F));
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						button.setEnabled(false);
						button.setIcon(new StretchIcon(Symbols.JACK.getSmallImageString()));
						main.addBonusWin(Symbols.JACK.getBonus());
						main.updateUserDetailsBalance(Symbols.JACK.getBonus());
						prizeWonOnClick.setText("Jack found! You win £" + Symbols.JACK.getBonus() * stakeValue);
						totalPrize.setText("Total win so far £" + main.getTotalWon() * stakeValue + "   ");
					}
				});
				return button;
			} else if (num < 12) {
				JToggleButton button = new JToggleButton();
				button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				button.setIcon(new AlphaIcon(new StretchIcon(facedown), 0.7F));
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						button.setEnabled(false);
						button.setIcon(new StretchIcon(Symbols.QUEEN.getSmallImageString()));
						main.addBonusWin(Symbols.QUEEN.getBonus());
						main.updateUserDetailsBalance(Symbols.QUEEN.getBonus());
						prizeWonOnClick.setText("Queen found! You win £" + Symbols.QUEEN.getBonus() * stakeValue);
						totalPrize.setText("Total win so far £" + main.getTotalWon() * stakeValue + "   ");
					}
				});
				return button;

			} else {
				JToggleButton button = new JToggleButton();
				button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				button.setIcon(new StretchIcon(facedown));
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						button.setEnabled(false);
						button.setIcon(new StretchIcon(Symbols.KING.getSmallImageString()));
						main.addBonusWin(Symbols.KING.getBonus());
						main.updateUserDetailsBalance(Symbols.KING.getBonus());
						prizeWonOnClick.setText("King found! You win £" + Symbols.KING.getBonus() * stakeValue);
						totalPrize.setText("Total win so far £" + main.getTotalWon() * stakeValue + "   ");
					}
				});
				return button;
			}
		}
	}
}
