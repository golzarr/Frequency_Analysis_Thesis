package cryptanalytic.tool.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainWindow {

	private JFrame frmFrequencyAnalysisV;
	private JTextField txtAlphabet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmFrequencyAnalysisV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFrequencyAnalysisV = new JFrame();
		frmFrequencyAnalysisV.setTitle("Frequency Analysis v1.0");
		frmFrequencyAnalysisV.setBounds(100, 100, 736, 581);
		frmFrequencyAnalysisV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFrequencyAnalysisV.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmFrequencyAnalysisV.getContentPane().add(tabbedPane);

	

		JPanel panel = new JPanel();
		tabbedPane.addTab("Caesar-Cipher", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("plain_text / cipher_text");
		lblNewLabel_1.setBounds(44, 31, 156, 16);
		panel.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("caesar_encrypt");
		btnNewButton.setBounds(187, 215, 128, 25);
		panel.add(btnNewButton);
		// txtr.setBounds(43, 104, 98, 98);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 62, 612, 124);
		panel.add(scrollPane);

		JTextArea txtr = new JTextArea();
		txtr.setRows(25);
		txtr.setColumns(25);

		scrollPane.setViewportView(txtr);
		// panel.add(txtr);
		txtr.setLineWrap(true);
		txtr.append("WELCOME TO THE ANDREJ FREQUENCY ANALYSIS PROJECT");
		txtr.setRows(25);
		txtr.setColumns(25);

		JButton btnCaesardecrypt = new JButton("caesar_decrypt");
		btnCaesardecrypt.setBounds(342, 215, 128, 25);
		panel.add(btnCaesardecrypt);

		JLabel label = new JLabel("plain_text / cipher_text");
		label.setBounds(44, 271, 156, 16);
		panel.add(label);
		JPanel panelFA = new JPanel();
		tabbedPane.addTab("Cracking Caesar-cipher with Frequency Analysis", null, panelFA, null);
		panelFA.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Cipher Text");
		lblNewLabel_2.setBounds(42, 24, 110, 16);
		panelFA.add(lblNewLabel_2);

		JButton btnNewButton1 = new JButton("Crack");
		btnNewButton1.setBounds(301, 225, 97, 25);
		panelFA.add(btnNewButton1);
//		txtr.setBounds(43, 104, 98, 98);
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(42, 53, 612, 98);
		panelFA.add(scrollPane2);

		JTextArea txtrFA = new JTextArea();

		scrollPane2.setViewportView(txtrFA);
		// panel.add(txtr);
		txtrFA.setLineWrap(true);

		JLabel lblNewLabel = new JLabel("Alphabet");
		lblNewLabel.setBounds(42, 171, 63, 16);
		panelFA.add(lblNewLabel);

		txtAlphabet = new JTextField();
		txtAlphabet.setText(" ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		txtAlphabet.setEditable(false);
		txtAlphabet.setBounds(117, 164, 537, 31);
		panelFA.add(txtAlphabet);
		txtAlphabet.setColumns(10);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 303, 612, 124);
		panel.add(scrollPane_1);
		txtrFA.append("ZHOFRPHCWRCWKHCDQGUHMCIUHTXHQFACDQDOAVLVCSURMHFW");

	}
}
