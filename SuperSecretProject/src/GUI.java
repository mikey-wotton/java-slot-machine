import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import java.awt.Color;
import java.io.File;
import java.net.URL;

import javax.swing.SwingConstants;

public class GUI {
	public Main main;
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menu, submenu;
	private JMenuItem menuItem;
	private CardLayout cl1;
	
	private SwingWorker<Void, String> worker;
	private Color bgColour;
	private URL facedown;

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
		menuBar = new JMenuBar();
		main = new Main("Mr. Lister", 500.00);
		bgColour = new Color(0, 153, 102);
		initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */	
	private JPanel getMiddle(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,5));
		panel.setOpaque(false);
		JLabel[] array = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			array[i] = new JLabel();
			array[i].setIcon(new StretchIcon(GUI.class.getResource(String.valueOf(i) + "_front.jpg")));
			panel.add(array[i]);
		}
		return panel;
	}
	private JPanel generateBlankPanel(){
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		return panel;
	}
	private JLabel generateBlankJLabel(){
		JLabel label = new JLabel();
		label.setOpaque(false);
		return label;
	}
	private JToggleButton generateBlankJToggleButton(){
		JToggleButton button = new JToggleButton();
		button.setOpaque(false);
		return button;
	}
	private void getBottom(JPanel mainScreen){
		GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weighty = 0.04;
        c.weightx = 0.3;
        c.insets = new Insets(5,5,5,5);
		JButton simPlay = new JButton("Simulated Play");
		simPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel simScreen = simPlay();
				frame.add(simScreen, "1");
				cl1.show(frame.getContentPane(),"1");
			}
		});
		mainScreen.add(simPlay, c);
		c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.3;
        c.insets = new Insets(5,5,5,5);
		JButton realPlay = new JButton("   Real Play  ");
		realPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Real Play");
			}
		});
		mainScreen.add(realPlay, c);
		//Blank filler panels to space the grid, possibly use in future
		c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.4;
        c.insets = new Insets(5,5,5,5);
		mainScreen.add(generateBlankPanel(), c);

	}
	private JPanel getMainScreen(){
		menu = new JMenu("A Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		//a group of JMenuItems
		menuItem = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		menu.add(menuItem);

		//a submenu
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
		GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.6;
        c.gridwidth = 3;
        c.insets = new Insets(5,5,5,5);
        mainScreen.add(getMiddle(), c);
        getBottom(mainScreen);
		return mainScreen;
	}
	private void initialize() {
		frame = new JFrame();
		facedown = GUI.class.getResource("facedown_small.jpg");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Mikey's Not So Wild Slots");
		frame.setBackground(bgColour);
		frame.setMinimumSize(new Dimension(800,825));
		cl1 = new CardLayout();
		frame.getContentPane().setLayout(cl1);
		frame.getContentPane().add(getMainScreen(), "0");
	}
	
	private JLabel[][] getLblWheelsArray(JPanel cardPanel){
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
	
	private JLabel[] getLblWinLinesArray(JPanel holdingPane){
		JLabel[] lblWinLinesArray = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			lblWinLinesArray[i] = new JLabel();
			lblWinLinesArray[i].setIcon(new StretchIcon(GUI.class.getResource("/winLines/line_" + String.valueOf(i)+ ".png"), false));
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
		JPanel upperRightPanel = new JPanel();
		SpringLayout urSpring = new SpringLayout();
		upperRightPanel.setLayout(urSpring);
		upperRightPanel.setBackground(bgColour);
		
		JLabel lblwinLines = new JLabel("No. of Win Lines: ");	
		SpinnerNumberModel modelWinLinesSpinner = new SpinnerNumberModel(1, 1, 10, 1);
		JSpinner winLinesSpinner = new JSpinner(modelWinLinesSpinner);
		winLinesSpinner.setEditor(new JSpinner.DefaultEditor(winLinesSpinner));		
		urSpring.putConstraint(SpringLayout.EAST, lblwinLines, -50, SpringLayout.EAST, upperRightPanel);
		urSpring.putConstraint(SpringLayout.NORTH, lblwinLines, 10, SpringLayout.NORTH, upperRightPanel);
		urSpring.putConstraint(SpringLayout.NORTH, winLinesSpinner, 10, SpringLayout.NORTH, upperRightPanel);
		urSpring.putConstraint(SpringLayout.EAST, winLinesSpinner, -10, SpringLayout.EAST, upperRightPanel);
		urSpring.putConstraint(SpringLayout.WEST, winLinesSpinner, 5, SpringLayout.EAST, lblwinLines);
		
		JLabel lblstakeValue = new JLabel("Stake per line:  ");
		SpinnerNumberModel modelStakeSpinner = new SpinnerNumberModel(1, 1, 10,	0.5);
		JSpinner winStakeSpinner = new JSpinner(modelStakeSpinner);
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

		//LINE_START COMPONENTS
		JPanel upperLeftPanel = new JPanel();
		SpringLayout ulSpring = new SpringLayout();
		upperLeftPanel.setBackground(bgColour);
		upperLeftPanel.setLayout(ulSpring);
		JLabel lblUserName = new JLabel("Username: "+ main.userDetails.getUsername());
		ulSpring.putConstraint(SpringLayout.WEST, lblUserName, 10, SpringLayout.WEST, upperLeftPanel);
		ulSpring.putConstraint(SpringLayout.NORTH, lblUserName, 10, SpringLayout.NORTH, upperLeftPanel);
		
		JLabel lblBalance = new JLabel("Balance: "+ String.valueOf(main.userDetails.getBalance()));
		ulSpring.putConstraint(SpringLayout.WEST, lblBalance, 10, SpringLayout.WEST, upperLeftPanel);
		ulSpring.putConstraint(SpringLayout.NORTH, lblBalance, 5, SpringLayout.SOUTH, lblUserName);
		
		upperLeftPanel.add(lblUserName);
		upperLeftPanel.add(lblBalance);

		
		//the Page_End of the boxLayout grid
		//bottom_CENTER components
		JLabel lblWinOrLoseAmount = new JLabel("winOrLoseAmount",SwingConstants.CENTER);
		lblWinOrLoseAmount.setText("Welcome, good luck!");
		lblWinOrLoseAmount.setFont(new Font("Serif", Font.BOLD, 25));
		lblWinOrLoseAmount.setPreferredSize(new Dimension(350,50));

		//bottom_LINESTART components
		JPanel bottomLeftPanel = new JPanel();
		SpringLayout blSwing = new SpringLayout();
		bottomLeftPanel.setLayout(blSwing);
		bottomLeftPanel.setBackground(bgColour);
		
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
		
		

		
		//bottom_LINEEND components
		JPanel bottomRightPanel = new JPanel();
		SpringLayout brSwing = new SpringLayout();
		bottomRightPanel.setLayout(brSwing);
		bottomRightPanel.setBackground(bgColour);
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
		brSwing.putConstraint(SpringLayout.NORTH, spinOnce, -60, SpringLayout.SOUTH, bottomRightPanel);
		brSwing.putConstraint(SpringLayout.SOUTH, spinOnce, -10, SpringLayout.SOUTH, bottomRightPanel);
		brSwing.putConstraint(SpringLayout.WEST, spinOnce, 10, SpringLayout.WEST, bottomRightPanel);
		brSwing.putConstraint(SpringLayout.EAST, spinOnce, -10, SpringLayout.EAST, bottomRightPanel);

		
		bottomRightPanel.add(spinOnce);
		
		
		//Sets up the text banner
		
		//contentPane add components
		c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 0.2;
        c.gridwidth = 1;
        c.insets = new Insets(5,5,5,5);
		contentPane.add(upperLeftPanel, c);
		c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 1;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 0.2;
        c.gridwidth = 1;
        c.insets = new Insets(5,5,5,5);
		contentPane.add(upperRightPanel, c);
		c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.05;
        c.gridwidth = 3;
        c.insets = new Insets(5,5,5,5);
		contentPane.add(holdingPane, c);
		c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.3;
        c.weighty = 0.2;
		contentPane.add(bottomLeftPanel, c);
		c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.3;
        c.weighty = 0.2;
        contentPane.add(lblWinOrLoseAmount, c);
		c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 3;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 0.3;
        c.weighty = 0.2;
        contentPane.add(bottomRightPanel, c);
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
		File soundFile;
		

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
			soundFile = new File("sounds\\Flipped.wav");
		}

		@Override
		protected Void doInBackground() throws Exception {
			while (!isCancelled() && spins > 0) {
				for (int i = 0; i < main.arrayOfWheels.length; i++) {
					for (int j = 0; j < main.arrayOfWheels.length; j++) {
						labels[i][j].setIcon(new StretchIcon(facedown));
						
						try {
							Thread.sleep(20);
						} catch (InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
					}
				}
				//boop();

				main.spinOnce(numOfWinLines, lineStake);
				if(main.bonusFlagArray[0] == 1){
					boop(lineStake);
				};
				int[] winLineArray = main.getWinLineArray();
				for (int i = 0; i < main.arrayOfWheels.length; i++) {
					for (int j = 0; j < main.arrayOfWheels.length; j++) {
						if( (j == 0) || (j == 4) ){
							labels[i][j].setIcon(new AlphaIcon(new StretchIcon(main.arrayOfWheels[i][j].imageString()), 0.3F));
						}else {
							labels[i][j].setIcon(new StretchIcon(main.arrayOfWheels[i][j].imageString()));
						}
						try {
							Clip clip = AudioSystem.getClip();
							clip.open(AudioSystem.getAudioInputStream(soundFile));
							clip.start();
							Thread.sleep(clip.getMicrosecondLength()/1000);
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
		public void boop(double stakeValue){
			JPanel bonusFrame = new JPanel();
			bonusFrame.setBackground(Color.YELLOW);
			bonusFrame.setLayout(new GridLayout(4,4));
			JToggleButton[][] panelArray = new JToggleButton[4][4];
			for(int i = 0; i < 4; i++){
				for(int j = 0; j < 4; j++){
					panelArray[i][j] = createButton();
					bonusFrame.add(panelArray[i][j]);
				}				
			}
			frame.getContentPane().add(bonusFrame, "2");
			cl1.show(frame.getContentPane(),"2");
		}			
		private JToggleButton createButton(){
			JToggleButton button = new JToggleButton();
			button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 button.setEnabled(false);
				}
			});
			return button;
		}
	}
}
