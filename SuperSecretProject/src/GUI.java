import java.awt.EventQueue;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.OverlayLayout;
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
		main = new Main("Mr. Lister", 500.00);
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
		lblUserName.setBounds(10, 10, 200, 20);
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

		//JPanel overLayPanel = new JPanel(new OverlayLayout())
		
		JPanel holdingPanel = new JPanel();
		holdingPanel.setLayout(new OverlayLayout(holdingPanel));
		holdingPanel.setBackground(new Color(250, 78, 91));
		holdingPanel.setBounds(215, 10, 450, 460);	
//
		
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(null);
		cardPanel.setOpaque(false);
		
		// All labels for the images of the wheels
		for(int i = 0; i < 5; i++){
			int setX = i * 95;			
			for(int j =0; j < 5; j++){ 
				int setY = j * 92;
				labels[i][j] = new JLabel(i+ " "+j);
				labels[i][j].setIcon(new ImageIcon("facedown_small.jpg"));
				labels[i][j].setBounds(setX,setY,70,90);
				labels[i][j].setOpaque(false);
				cardPanel.add(labels[i][j]);
			}
		}
		
		
		//Panels used to show win lines with an OverlayLayout manager
		JPanel winLinePanel = new JPanel();
		winLinePanel.setLayout(null);
		winLinePanel.setBounds(215, 10, 450, 460);
		winLinePanel.setOpaque(false);
		
		
		
		JLabel winLine1 = new JLabel();
		winLine1.setIcon(new ImageIcon("line_1.png"));
		winLine1.setBounds(34, 133, 390, 5);
		winLine1.setVisible(false);

		JLabel winLine2 = new JLabel();
		winLine2.setIcon(new ImageIcon("line_1.png"));
		winLine2.setBounds(34, 228, 390, 5);
		winLine2.setVisible(false);

		JLabel winLine3 = new JLabel();
		winLine3.setIcon(new ImageIcon("line_1.png"));
		winLine3.setBounds(34, 323, 390, 5);
		winLine3.setVisible(false);
		
		JLabel winLine4 = new JLabel();
		winLine4.setIcon(new ImageIcon("line_4.png"));
		winLine4.setBounds(34, 133, 390, 200);
		winLine4.setVisible(false);
		
		JLabel winLine5 = new JLabel();
		winLine5.setIcon(new ImageIcon("line_5.png"));
		winLine5.setBounds(32, 127, 390, 200);
		winLine5.setVisible(false);
		
		JLabel winLine6 = new JLabel();
		winLine6.setIcon(new ImageIcon("line_6.png"));
		winLine6.setBounds(34, 127, 390, 200);
		winLine6.setVisible(false);
		
		JLabel winLine7 = new JLabel();
		winLine7.setIcon(new ImageIcon("line_7.png"));
		winLine7.setBounds(34, 127, 390, 200);
		winLine7.setVisible(false);
		
		JLabel winLine8 = new JLabel();
		winLine8.setIcon(new ImageIcon("line_8.png"));
		winLine8.setBounds(34, 127, 390, 200);
		winLine8.setVisible(false);
		
		JLabel winLine9 = new JLabel();
		winLine9.setIcon(new ImageIcon("line_9.png"));
		winLine9.setBounds(34, 127, 390, 200);
		winLine9.setVisible(false);
		
		JLabel winLine10 = new JLabel();
		winLine10.setIcon(new ImageIcon("line_10.png"));
		winLine10.setBounds(34, 127, 390, 200);
		winLine10.setVisible(false);
		
		winLinePanel.add(winLine1);
		winLinePanel.add(winLine2);
		winLinePanel.add(winLine3);
		winLinePanel.add(winLine4);
		winLinePanel.add(winLine5);
		winLinePanel.add(winLine6);
		winLinePanel.add(winLine7);
		winLinePanel.add(winLine8);	
		winLinePanel.add(winLine9);
		winLinePanel.add(winLine10);






		
		holdingPanel.add(winLinePanel);
		holdingPanel.add(cardPanel);
		
		JLabel[] winlineArray = new JLabel[10];
		winlineArray[0] = winLine1;
		winlineArray[1] = winLine2;
		winlineArray[2] = winLine3;
		winlineArray[3] = winLine4;
		winlineArray[4] = winLine5;
		winlineArray[5] = winLine6;
		winlineArray[6] = winLine7;
		winlineArray[7] = winLine8;
		winlineArray[8] = winLine9;
		winlineArray[9] = winLine10;







		
		
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
				autoSpinner.setValue(1);
				worker = new Worker(labels, lblWinOrLoseAmount, lblBalance,	autoSpinner, (Integer) winLinesSpinner.getValue(), (double) winStakeSpinner.getValue(), winlineArray);
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
				worker = new Worker(labels, lblWinOrLoseAmount, lblBalance,	autoSpinner, (Integer) winLinesSpinner.getValue(), (double) winStakeSpinner.getValue(), winlineArray);
				worker.execute();
			}
		});
		contentPane.add(autoSpin);
		contentPane.add(holdingPanel);
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

		public Worker(JLabel[][] labels, JLabel lblWinorloseamount, JLabel balance, JSpinner autoSpinner, int numOfWinLines, double lineStake, JLabel[] winLineLabelArray) {
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
						labels[i][j].setIcon(new ImageIcon("facedown_small.jpg"));
						try {
							Thread.sleep(20);
						} catch (InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
					}
				}				

				main.spinOnce(numOfWinLines, lineStake);
				int [] winLineArray = main.getWinLineArray();
				for (int i = 0; i < main.arrayOfWheels.length; i++) {
					for (int j = 0; j < main.arrayOfWheels.length; j++) {
						labels[i][j].setIcon(new ImageIcon(main.arrayOfWheels[i][j].imageString()));
						try {
							Thread.sleep(50); 
						} catch (InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
					}	
				}
				for(int k = 0; k < winLineLabelArray.length; k++){
					if(winLineArray[k] == 1){
						winLineLabelArray[k].setVisible(true);
					}
				}
				balance.setText(String.valueOf("Balance: £"+ main.userDetails.getBalance()));
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
				for(int k = 0; k < winLineLabelArray.length; k++){
						winLineLabelArray[k].setVisible(false);
				}
			}

			return null;
		}

	}
}
