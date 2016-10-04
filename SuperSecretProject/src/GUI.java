import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Window.Type;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.ImageIcon;



public class GUI {
	public Main main;
	private JFrame frmMikeysNotSo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmMikeysNotSo.setVisible(true);
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
		Main main = new Main("John",500.00);
		initialize(main);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Main main) {
		frmMikeysNotSo = new JFrame();
		frmMikeysNotSo.setBackground(Color.LIGHT_GRAY);
		JPanel menuPane = new JPanel();
		menuPane.setBackground(Color.WHITE);
		frmMikeysNotSo.setTitle("Mikey's Not So Wild Slots");
        frmMikeysNotSo.setMinimumSize(new Dimension(920, 600));
		frmMikeysNotSo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		menuPane.setLayout(null);
		
		JButton simPlay = new JButton("Simulated Play");
		simPlay.setBounds(10, 450, 300, 100);
		simPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				GUI_SimPlay simPlayPane = new GUI_SimPlay(main);
				frmMikeysNotSo.setVisible(false);
				simPlayPane.setVisible(true);
			}
		});
		menuPane.add(simPlay);
		
		JButton realPlay = new JButton("Real Play");
		realPlay.setBounds(574, 450, 300, 100);
		realPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("Real Play");
			}
		});
		menuPane.add(realPlay);
		
		//Adding images
		JLabel lblAceimage = new JLabel("aceImage");
		lblAceimage.setVerticalAlignment(SwingConstants.TOP);
		lblAceimage.setIcon(new ImageIcon("ace_front.jpg"));
		lblAceimage.setBounds(10, 50, 176, 230);
		menuPane.add(lblAceimage);
		
		JLabel lblKingimage = new JLabel("kingImage");
		lblKingimage.setVerticalAlignment(SwingConstants.TOP);
		lblKingimage.setIcon(new ImageIcon("king_front.jpg"));
		lblKingimage.setBounds(187, 100, 176, 230);
		menuPane.add(lblKingimage);
		
		JLabel lblQueenimage = new JLabel("queenImage");
		lblQueenimage.setVerticalAlignment(SwingConstants.TOP);
		lblQueenimage.setIcon(new ImageIcon("queen_front.jpg"));
		lblQueenimage.setBounds(364, 50, 176, 230);
		menuPane.add(lblQueenimage);
		
		JLabel lblJackimage = new JLabel("jackImage");
		lblJackimage.setVerticalAlignment(SwingConstants.TOP);
		lblJackimage.setIcon(new ImageIcon("jack_front.jpg"));
		lblJackimage.setBounds(540, 100, 176, 230);
		menuPane.add(lblJackimage);
		
		JLabel lblTenimage = new JLabel("tenImage");
		lblTenimage.setVerticalAlignment(SwingConstants.TOP);
		lblTenimage.setIcon(new ImageIcon("ten_front.jpg"));
		lblTenimage.setBounds(716, 50, 176, 230);
		menuPane.add(lblTenimage);
		
		frmMikeysNotSo.add(menuPane);
		frmMikeysNotSo.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{simPlay, realPlay, frmMikeysNotSo.getContentPane()}));
		frmMikeysNotSo.pack();
		
	}
}
