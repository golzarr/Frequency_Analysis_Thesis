package cryptanalytic.tool.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cryptanalytic.tool.python.PythonHandler;

public class MainWindow {

	private JFrame frmFrequencyAnalysisV;
	private JTextField txtAlphabet;
	private JTextArea txtr;
	private JTextArea txtrOut;
	private JTextArea txtrFA;
	private PythonHandler pythonHandler = new PythonHandler();
	private String[] defaultKeys = { "1", "2", "3", "4", "5", "6", "7", "8" };
	private JComboBox comboBox;
	private JComboBox comboBoxFA;

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
		btnNewButton.setBounds(219, 216, 128, 25);
		panel.add(btnNewButton);
		// txtr.setBounds(43, 104, 98, 98);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 62, 612, 124);
		panel.add(scrollPane);

		txtr = new JTextArea();
		txtr.setRows(25);
		txtr.setColumns(25);

		scrollPane.setViewportView(txtr);
		// panel.add(txtr);
		txtr.setLineWrap(true);
		txtr.append("WELCOME TO THE ANDREJ FREQUENCY ANALYSIS PROJECT");
		txtr.setRows(25);
		txtr.setColumns(25);

		JButton btnCaesardecrypt = new JButton("caesar_decrypt");
		btnCaesardecrypt.setBounds(373, 216, 128, 25);
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

		txtrFA = new JTextArea();
		txtrFA.setRows(25);
		txtrFA.setColumns(25);
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

		txtrOut = new JTextArea();
		txtrOut.setRows(25);
		txtrOut.setColumns(25);

		scrollPane_1.setViewportView(txtrOut);
		// panel.add(txtr);
		txtrOut.setLineWrap(true);
		txtrOut.setRows(25);
		txtrOut.setColumns(25);

		comboBox = new JComboBox(defaultKeys);
		comboBox.setBounds(75, 216, 72, 22);
		comboBox.setSelectedItem("3");
		panel.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("Key");
		lblNewLabel_3.setBounds(43, 219, 56, 16);
		panel.add(lblNewLabel_3);

		comboBoxFA = new JComboBox(defaultKeys);
		comboBoxFA.setBounds(157, 325, 72, 22);
//		comboBoxFA.setSelectedItem("3");
		comboBoxFA.setSelectedIndex(-1);
		panelFA.add(comboBoxFA);

		JLabel lblNewLabel_4 = new JLabel("The Key Value is");
		lblNewLabel_4.setBounds(48, 328, 110, 16);
		panelFA.add(lblNewLabel_4);

		JPanel panelPlot = new JPanel();
		tabbedPane.addTab("Plot Distribution FA", null, panelPlot, null);
		panelPlot.setLayout(null);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "You selected " + comboBox.getItemAt(comboBox.getSelectedIndex());
				JOptionPane.showMessageDialog(frmFrequencyAnalysisV, txtr.getText());
				JOptionPane.showMessageDialog(frmFrequencyAnalysisV, key);
				try {
					String outPut = pythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess();
					txtrOut.setText(outPut);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

	}
}
