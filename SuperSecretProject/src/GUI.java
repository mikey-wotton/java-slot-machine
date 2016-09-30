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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMikeysNotSo = new JFrame();
		frmMikeysNotSo.setBackground(Color.LIGHT_GRAY);
		frmMikeysNotSo.getContentPane().setBackground(Color.WHITE);
		frmMikeysNotSo.setTitle("Mikey's Not So Wild Slots");
        frmMikeysNotSo.setMinimumSize(new Dimension(900, 600));
		frmMikeysNotSo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmMikeysNotSo.getContentPane().setLayout(null);
		
		JButton simPlay = new JButton("Simulated Play");
		simPlay.setBounds(10, 450, 300, 100);
		simPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				createSimPlay();
				frmMikeysNotSo.setVisible(false);
			}
		});
		frmMikeysNotSo.getContentPane().add(simPlay);
		
		JButton realPlay = new JButton("Real Play");
		realPlay.setBounds(574, 450, 300, 100);
		realPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("Real Play");
			}
		});
		frmMikeysNotSo.getContentPane().add(realPlay);
		
		//Adding images
		JLabel lblAceimage = new JLabel("aceImage");
		lblAceimage.setVerticalAlignment(SwingConstants.TOP);
		lblAceimage.setIcon(new ImageIcon("ace_medium.jpg"));
		lblAceimage.setBounds(190, 100, 100, 135);
		frmMikeysNotSo.getContentPane().add(lblAceimage);
		
		JLabel lblKingimage = new JLabel("kingImage");
		lblKingimage.setVerticalAlignment(SwingConstants.TOP);
		lblKingimage.setIcon(new ImageIcon("king_medium.jpg"));
		lblKingimage.setBounds(290, 130, 100, 135);
		frmMikeysNotSo.getContentPane().add(lblKingimage);
		
		JLabel lblQueenimage = new JLabel("queenImage");
		lblQueenimage.setVerticalAlignment(SwingConstants.TOP);
		lblQueenimage.setIcon(new ImageIcon("queen_medium.jpg"));
		lblQueenimage.setBounds(390, 100, 100, 135);
		frmMikeysNotSo.getContentPane().add(lblQueenimage);
		
		JLabel lblJackimage = new JLabel("jackImage");
		lblJackimage.setVerticalAlignment(SwingConstants.TOP);
		lblJackimage.setIcon(new ImageIcon("jack_medium.jpg"));
		lblJackimage.setBounds(490, 130, 100, 135);
		frmMikeysNotSo.getContentPane().add(lblJackimage);
		
		JLabel lblTenimage = new JLabel("tenImage");
		lblTenimage.setVerticalAlignment(SwingConstants.TOP);
		lblTenimage.setIcon(new ImageIcon("ten_medium.jpg"));
		lblTenimage.setBounds(590, 100, 100, 135);
		frmMikeysNotSo.getContentPane().add(lblTenimage);
		
		
		frmMikeysNotSo.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{simPlay, realPlay, frmMikeysNotSo.getContentPane()}));
		frmMikeysNotSo.pack();
		
	}
	public void createSimPlay(){
		GUI_SimPlay simPlay = new GUI_SimPlay();
		simPlay.initialize(main);
	}
}
