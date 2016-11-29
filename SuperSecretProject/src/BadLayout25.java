import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BadLayout25 {

    public static void main(String[] args) {
        new BadLayout25();
    }

    public BadLayout25() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new BasePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class BasePane extends JPanel {

        public BasePane() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1.0;
            add(getTopPane(), gbc);

            gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gbc.weightx = 0.5;
            add(getOptionsPane(), gbc);

            gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            gbc.weightx = 0.5;
            gbc.weighty = 1.0;
            add(getButtonPane(), gbc);

            JTextArea textArea = new JTextArea(5, 20);

            gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridheight = 2;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            gbc.weightx = 0.5;
            gbc.weighty = 1.0;
            add(new JScrollPane(textArea), gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 400);
        }

        protected JPanel getTopPane() {
            JPanel topPane = new JPanel(new GridBagLayout());
            topPane.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
            topPane.add(new JLabel("Lotereya:"));
            topPane.add(new JLabel("Yuklenilir"));
            return topPane;
        }

        protected JPanel getOptionsPane() {
            JPanel optionsPane = new JPanel(new GridBagLayout());
            optionsPane.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
            GridBagConstraints gbc = new GridBagConstraints();

            gbc = new GridBagConstraints();
            gbc.anchor = java.awt.GridBagConstraints.LINE_START;
            optionsPane.add(new JLabel("Tiraj nomre:"), gbc);

            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.anchor = java.awt.GridBagConstraints.LINE_START;
            optionsPane.add(new JLabel("Sablon nomresi:"), gbc);

            JTextField field = new JTextField(10);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.anchor = java.awt.GridBagConstraints.LINE_START;
            gbc.weightx = 1.0;
            optionsPane.add(field, gbc);

            JComboBox comboBox = new JComboBox();
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.anchor = java.awt.GridBagConstraints.LINE_START;
            gbc.weightx = 1.0;
            optionsPane.add(comboBox, gbc);

            return optionsPane;
        }

        protected JPanel getButtonPane() {
            JPanel buttonsPane = new JPanel(new GridBagLayout());
            buttonsPane.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc = new java.awt.GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = -1;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            gbc.weightx = 0.25;
            gbc.weighty = 0.25;
            for (int index = 0; index < 9; index++) {
                if (index % 3 == 0) {
                    gbc.gridy++;
                    gbc.gridx = 0;
                } else {
                    gbc.gridx++;
                }
                buttonsPane.add(new JButton(String.valueOf(index + 1)), gbc);
            }
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            gbc.weightx = 0.25;
            gbc.weighty = 0.25;
            buttonsPane.add(new JButton("0"), gbc);

            gbc = new GridBagConstraints();
            gbc.gridx = 3;
            gbc.gridy = 0;
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            gbc.weightx = 0.25;
            gbc.weighty = 0.25;
            buttonsPane.add(new JButton("Tesdiq"), gbc);
            gbc.gridy++;
            buttonsPane.add(new JButton("<ticket.apply>"), gbc);
            gbc.gridy++;
            buttonsPane.add(new JButton("<ticket.cancel>"), gbc);
            gbc.gridy++;
            buttonsPane.add(new JButton("<main menu>"), gbc);

            return buttonsPane;
        }
    }
}