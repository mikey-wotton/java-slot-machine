import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMikeysNotSo = new JFrame();
		frmMikeysNotSo.setTitle("Mikey's Not So Wild Slots");
        frmMikeysNotSo.setMinimumSize(new Dimension(900, 600));
		frmMikeysNotSo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMikeysNotSo.getContentPane().setLayout(null);
		
		JButton simPlay = new JButton("Simulated Play");
		simPlay.setBounds(10, 450, 300, 100);
		frmMikeysNotSo.getContentPane().add(simPlay);
		
		JButton realPlay = new JButton("Real Play");
		realPlay.setBounds(570, 450, 300, 100);
		frmMikeysNotSo.getContentPane().add(realPlay);
		
		JLabel lblAceimage = new JLabel("aceImage");
		lblAceimage.setIcon(new ImageIcon("ace_medium.jpg"));
		lblAceimage.setBounds(100, 100, 100, 135);
		frmMikeysNotSo.getContentPane().add(lblAceimage);
		frmMikeysNotSo.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{simPlay, realPlay, frmMikeysNotSo.getContentPane()}));
		
	}
}
