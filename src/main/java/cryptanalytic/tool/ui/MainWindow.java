package cryptanalytic.tool.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cryptanalytic.tool.python.PythonHandler;
import javax.swing.JRadioButton;

public class MainWindow {

	private JFrame frmFrequencyAnalysisV;
	private JTextField txtAlphabet;
	private JTextArea txtr;
	private JTextArea txtrOut;
	private JTextArea txtrFA;
	private JTextArea txtrPlot;
	private JTextArea txtrLetter;
	private JTextArea txtrLetterOutPut;
	private PythonHandler pythonHandler = new PythonHandler();
	private String[] defaultKeys = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
	private JComboBox comboBox;
	private JComboBox comboBoxFA;
	private JTextField textFieldPlotFAFile;

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

		JButton btnNewButtonEncrypt = new JButton("caesar_encrypt");
		btnNewButtonEncrypt.setBounds(219, 216, 128, 25);
		panel.add(btnNewButtonEncrypt);
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

		JButton btnCaesarDecrypt = new JButton("caesar_decrypt");
		btnCaesarDecrypt.setBounds(373, 216, 128, 25);
		panel.add(btnCaesarDecrypt);

		JLabel label = new JLabel("plain_text / cipher_text");
		label.setBounds(44, 271, 156, 16);
		panel.add(label);
		JPanel panelFA = new JPanel();
		tabbedPane.addTab("Cracking Caesar-Cipher with Frequency Analysis", null, panelFA, null);
		panelFA.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Cipher Text");
		lblNewLabel_2.setBounds(42, 24, 110, 16);
		panelFA.add(lblNewLabel_2);

		JButton btnNewButtonCrack = new JButton("Crack");
		btnNewButtonCrack.setBounds(301, 225, 97, 25);
		panelFA.add(btnNewButtonCrack);
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
		txtAlphabet.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		txtAlphabet.setEditable(false);
		txtAlphabet.setBounds(117, 164, 537, 31);
		panelFA.add(txtAlphabet);
		txtAlphabet.setColumns(10);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 303, 612, 124);
		panel.add(scrollPane_1);
//		txtrFA.append("ZHOFRPHCWRCWKHCDQGUHMCIUHTXHQFACDQDOAVLVCSURMHFW");

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

		JLabel lblNewLabelFA = new JLabel("Frequency Analysis");
		lblNewLabelFA.setBounds(44, 31, 156, 16);
		panelPlot.add(lblNewLabelFA);

		JScrollPane scrollPanePlotDistribution = new JScrollPane();
		scrollPanePlotDistribution.setBounds(44, 89, 612, 98);
		panelPlot.add(scrollPanePlotDistribution);

		txtrPlot = new JTextArea();
		txtrPlot.setRows(25);
		txtrPlot.setColumns(25);
		scrollPanePlotDistribution.setViewportView(txtrPlot);
		txtrPlot.setLineWrap(true);

		JLabel lblNewLabelPlot = new JLabel("Letters");
		lblNewLabelPlot.setBounds(44, 333, 63, 16);
		panelPlot.add(lblNewLabelPlot);

		JTextField txtAlphabetPlot = new JTextField();
		txtAlphabetPlot.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		txtAlphabetPlot.setEditable(false);
		txtAlphabetPlot.setBounds(119, 326, 537, 31);
		panelPlot.add(txtAlphabetPlot);
		txtAlphabet.setColumns(10);

		JButton btnFrequencyAnalysisPlot = new JButton("Generate");
		btnFrequencyAnalysisPlot.setBounds(301, 389, 97, 25);
		panelPlot.add(btnFrequencyAnalysisPlot);

		JLabel lblNewLabel_Panel_Plot = new JLabel("Alphabet");
		lblNewLabel_Panel_Plot.setBounds(44, 288, 56, 16);
		panelPlot.add(lblNewLabel_Panel_Plot);

		String[] Alphabet = { "English", "Slovak", "Spanish" };
		JComboBox comboBox_Plot_FA = new JComboBox(Alphabet);
		comboBox_Plot_FA.setBounds(119, 285, 109, 22);
		comboBox_Plot_FA.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String key = comboBox_Plot_FA.getItemAt(comboBox_Plot_FA.getSelectedIndex()) + "";
				selectAlphabetPlot(comboBox_Plot_FA.getSelectedIndex(), txtAlphabetPlot);
			}
		});

		panelPlot.add(comboBox_Plot_FA);
		// String key = comboBox_Plot_FA.getItemAt(comboBox_Plot_FA.getSelectedIndex())
		// + "";
		selectAlphabetPlot(comboBox_Plot_FA.getSelectedIndex(), txtAlphabetPlot);
		
		JRadioButton rdbtnNewRadioButtonPlotFADirect = new JRadioButton("Direct Input Text (Max 100 characters)");
		rdbtnNewRadioButtonPlotFADirect.setBounds(39, 55, 280, 25);
		panelPlot.add(rdbtnNewRadioButtonPlotFADirect);
		
		JRadioButton rdbtnNewRadioButtonPlotFAFile = new JRadioButton("Reading a Text File");
		rdbtnNewRadioButtonPlotFAFile.setBounds(39, 196, 184, 25);
		panelPlot.add(rdbtnNewRadioButtonPlotFAFile);
		
		JButton btnNewButtonPlotFAFile = new JButton("File");
		btnNewButtonPlotFAFile.setBounds(44, 230, 97, 25);
		panelPlot.add(btnNewButtonPlotFAFile);
		
		textFieldPlotFAFile = new JTextField();
		textFieldPlotFAFile.setBounds(149, 231, 507, 22);
		panelPlot.add(textFieldPlotFAFile);
		textFieldPlotFAFile.setColumns(10);

		JPanel panelFALetters = new JPanel();
		tabbedPane.addTab("Frequency Analysis", null, panelFALetters, null);
		panelFALetters.setLayout(null);

		JLabel lblNewLabelFALetters = new JLabel("Frequency Analysis Letters");
		lblNewLabelFALetters.setBounds(44, 31, 156, 16);
		panelFALetters.add(lblNewLabelFALetters);

		JScrollPane scrollPaneFALetters = new JScrollPane();
		scrollPaneFALetters.setBounds(44, 62, 612, 124);
		panelFALetters.add(scrollPaneFALetters);

		txtrLetter = new JTextArea();
		txtrLetter.setRows(25);
		txtrLetter.setColumns(25);
		scrollPaneFALetters.setViewportView(txtrLetter);
		txtrLetter.setLineWrap(true);

		JButton btnLetter = new JButton("Generated Report");
		btnLetter.setBounds(276, 225, 149, 25);
		panelFALetters.add(btnLetter);

		JLabel labelLetter = new JLabel("Output");
		labelLetter.setBounds(44, 271, 156, 16);
		panelFALetters.add(labelLetter);

		JScrollPane scrollPaneLetterOutPut = new JScrollPane();
		scrollPaneLetterOutPut.setBounds(44, 303, 612, 124);
		panelFALetters.add(scrollPaneLetterOutPut);

		txtrLetterOutPut = new JTextArea();
		txtrLetterOutPut.setRows(25);
		txtrLetterOutPut.setColumns(25);
		scrollPaneLetterOutPut.setViewportView(txtrLetterOutPut);
		txtrLetterOutPut.setLineWrap(true);

		btnNewButtonEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = comboBox.getItemAt(comboBox.getSelectedIndex()) + "";
//				JOptionPane.showMessageDialog(frmFrequencyAnalysisV, txtr.getText());
//				JOptionPane.showMessageDialog(frmFrequencyAnalysisV, key);
				try {
					String outPut = pythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess("0",
							txtr.getText(), key);
					txtrOut.setText(outPut);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnCaesarDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = comboBox.getItemAt(comboBox.getSelectedIndex()) + "";
				try {
					String outPut = pythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess("1",
							txtr.getText(), key);
					txtrOut.setText(outPut);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnNewButtonCrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = comboBoxFA.getItemAt(comboBoxFA.getSelectedIndex()) + "";
				try {
					String outPut = pythonHandler
							.givenPythonScript_whenPythonProcessExecuted_thenSuccess(txtrFA.getText());
					comboBoxFA.setSelectedItem(outPut);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnFrequencyAnalysisPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String outPut = pythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess(
							txtrPlot.getText(), comboBox_Plot_FA.getSelectedIndex() + "");
//					System.out.println("MainWindow.initialize().new ItemListener() {...}.itemStateChanged()"
//							+ comboBox_Plot_FA.getSelectedIndex());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String outPut = pythonHandler
							.givenPythonScript_whenPythonProcessExecuted_thenSuccess(txtrLetter.getText(), 1);
					txtrLetterOutPut.setText(outPut);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	/**
	 * @param index
	 * @param txtAlphabetPlot
	 */
	protected void selectAlphabetPlot(int index, JTextField txtAlphabetPlot) {
		// TODO Auto-generated method stub
		if (index == 0) {// English
			txtAlphabetPlot.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		} else if (index == 1) {// Slovak
			txtAlphabetPlot.setText("AÁÄBCČDĎDZDŽEÉFGHCHIÍJKLĹMNŇOÓÔPQRŔSŠTŤUÚVWXYÝZŽ");
		} else if (index == 2) {// Spanish
			txtAlphabetPlot.setText("ABCDEFGHIJKLMNÑOPQRSTUVWXYZ");
		}

	}
}
