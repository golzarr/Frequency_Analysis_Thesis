package cryptanalytic.tool.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.PlainDocument;

import cryptanalytic.tool.python.PythonHandler;
import cryptanalytic.tool.ui.util.FileHandlerThesis;
import cryptanalytic.tool.ui.util.StockPublicNotesDocumentFilter;

public class MainWindow {

	private JFrame frmFrequencyAnalysisV;
	private JTextField txtAlphabet;
	private JTextArea txtr;
	private JTextArea txtrOut;
	private JTextArea txtrFA;
	private JTextArea txtrPlotFA;
	private JTextArea txtrLetter;
	private JTextArea txtrLetterOutPut;
	private JTextArea outputTextAreass;
	private JTextArea outputTextAreasSubstitution;
	private JTextArea txtCipherKeyword;
	private PythonHandler pythonHandler = new PythonHandler();
	private String[] defaultKeys = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
	private JComboBox comboBox;
	private JComboBox comboBoxFA;
	private JTextField textFieldPlotFAFile;
	private JTextField textFieldLetterFAFile;
	private JTextField keywordTextFieldSubstitution;

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
		txtr.append("WELCOME TO THE CAESAR CIPHER");
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

		txtrPlotFA = new JTextArea();
		txtrPlotFA.setRows(25);
		txtrPlotFA.setColumns(25);
		scrollPanePlotDistribution.setViewportView(txtrPlotFA);
		txtrPlotFA.setLineWrap(true);
		StockPublicNotesDocumentFilter publicNotesfilter = new StockPublicNotesDocumentFilter(100);
		((PlainDocument) txtrPlotFA.getDocument()).setDocumentFilter(publicNotesfilter);

		JLabel lblNewLabelPlot = new JLabel("Letters");
		lblNewLabelPlot.setBounds(44, 333, 63, 16);
		panelPlot.add(lblNewLabelPlot);

		JTextField txtAlphabetPlot = new JTextField();
		txtAlphabetPlot.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		txtAlphabetPlot.setEditable(false);
		txtAlphabetPlot.setBounds(119, 326, 537, 31);
		panelPlot.add(txtAlphabetPlot);
		txtAlphabet.setColumns(10);

		JButton btnFrequencyAnalysisPlot = new JButton("Generate Plot");
		btnFrequencyAnalysisPlot.setBounds(230, 396, 121, 25);
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

		ButtonGroup groupPlotFA = new ButtonGroup();
		groupPlotFA.add(rdbtnNewRadioButtonPlotFADirect);
		groupPlotFA.add(rdbtnNewRadioButtonPlotFAFile);
		rdbtnNewRadioButtonPlotFADirect.setSelected(true);

		JButton btnNewButtonPlotFAFile = new JButton("File");
		btnNewButtonPlotFAFile.setBounds(44, 230, 97, 25);
		panelPlot.add(btnNewButtonPlotFAFile);

		btnNewButtonPlotFAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rdbtnNewRadioButtonPlotFAFile.setSelected(true);
					JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					jfc.setDialogTitle("Select an text file");
					jfc.setAcceptAllFileFilterUsed(false);
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
					jfc.addChoosableFileFilter(filter);
					int returnValue = jfc.showOpenDialog(frmFrequencyAnalysisV);
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						textFieldPlotFAFile.setText(jfc.getSelectedFile().getPath());
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		textFieldPlotFAFile = new JTextField();
		textFieldPlotFAFile.setEditable(false);
		textFieldPlotFAFile.setBounds(149, 231, 507, 22);
		panelPlot.add(textFieldPlotFAFile);
		textFieldPlotFAFile.setColumns(10);

		JButton btnNewButtonPlotFA = new JButton("Clear Fields");
		btnNewButtonPlotFA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButtonPlotFADirect.setSelected(true);
				txtrPlotFA.setText("");
				textFieldPlotFAFile.setText("");
				comboBox_Plot_FA.setSelectedIndex(0);
				selectAlphabetPlot(comboBox_Plot_FA.getSelectedIndex(), txtAlphabetPlot);

			}
		});
		btnNewButtonPlotFA.setBounds(368, 396, 132, 25);
		panelPlot.add(btnNewButtonPlotFA);

		JPanel panelFALetters = new JPanel();
		tabbedPane.addTab("Frequency Analysis", null, panelFALetters, null);
		panelFALetters.setLayout(null);

		JLabel lblNewLabelFALetters = new JLabel("Frequency Analysis Letters");
		lblNewLabelFALetters.setBounds(44, 31, 156, 16);
		panelFALetters.add(lblNewLabelFALetters);

		JScrollPane scrollPaneFALetters = new JScrollPane();
//		scrollPaneFALetters.setBounds(44, 62, 612, 124);
		scrollPaneFALetters.setBounds(44, 89, 612, 98);
		panelFALetters.add(scrollPaneFALetters);

		txtrLetter = new JTextArea();
		txtrLetter.setRows(25);
		txtrLetter.setColumns(25);
		scrollPaneFALetters.setViewportView(txtrLetter);
		txtrLetter.setLineWrap(true);
		StockPublicNotesDocumentFilter publicNotesfilterLetter = new StockPublicNotesDocumentFilter(100);
		((PlainDocument) txtrLetter.getDocument()).setDocumentFilter(publicNotesfilterLetter);

		JRadioButton rdbtnNewRadioButtonLetterFADirect = new JRadioButton("Direct Input Text (Max 100 characters)");
		rdbtnNewRadioButtonLetterFADirect.setBounds(39, 55, 280, 25);
		panelFALetters.add(rdbtnNewRadioButtonLetterFADirect);

		JRadioButton rdbtnNewRadioButtonLetterFAFile = new JRadioButton("Reading a Text File");
		rdbtnNewRadioButtonLetterFAFile.setBounds(39, 196, 184, 25);
		panelFALetters.add(rdbtnNewRadioButtonLetterFAFile);

		ButtonGroup groupPlotLetterFA = new ButtonGroup();
		groupPlotLetterFA.add(rdbtnNewRadioButtonLetterFADirect);
		groupPlotLetterFA.add(rdbtnNewRadioButtonLetterFAFile);
		rdbtnNewRadioButtonLetterFADirect.setSelected(true);

		JButton btnNewButtonLetterFAFile = new JButton("File");
		btnNewButtonLetterFAFile.setBounds(44, 230, 97, 25);
		panelFALetters.add(btnNewButtonLetterFAFile);

		// panelSubstitutionCipherWithaKeyword

		JPanel panelSubstitutionCipherWithaKeyword = new JPanel();
		tabbedPane.addTab("Substitution Cipher With a Keyword", null, panelSubstitutionCipherWithaKeyword, null);
		panelSubstitutionCipherWithaKeyword.setLayout(null);

		JLabel lblNewLabel_1s = new JLabel("plain_text / cipher_text");
		lblNewLabel_1s.setBounds(44, 31, 156, 16);
		panelSubstitutionCipherWithaKeyword.add(lblNewLabel_1s);

		JButton btnNewButtonEncryptSubstitutionCipher = new JButton("encrypt");
		btnNewButtonEncryptSubstitutionCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String outPut = pythonHandler
							.givenPythonScript_whenPythonProcessExecuted_thenSuccessCaesarCipherWithKeywordDirectInput(
									txtCipherKeyword.getText(), keywordTextFieldSubstitution.getText(), "1");
					outputTextAreasSubstitution.setText(outPut);
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		btnNewButtonEncryptSubstitutionCipher.setBounds(174, 293, 128, 25);
		panelSubstitutionCipherWithaKeyword.add(btnNewButtonEncryptSubstitutionCipher);
		// txtr.setBounds(43, 104, 98, 98);
		JScrollPane scrollPanes = new JScrollPane();
		scrollPanes.setBounds(44, 62, 612, 124);
		panelSubstitutionCipherWithaKeyword.add(scrollPanes);

		txtCipherKeyword = new JTextArea();
		txtCipherKeyword.setRows(25);
		txtCipherKeyword.setColumns(25);

		scrollPanes.setViewportView(txtCipherKeyword);
		// panelSubstitutionCipherWithaKeyword.add(txtrs);
		txtCipherKeyword.setLineWrap(true);
		// txtrs.append("WELCOME TO THE CAESAR CIPHER");
		txtCipherKeyword.setRows(25);
		txtCipherKeyword.setColumns(25);

		JButton btnCaesarDecrypts = new JButton("decrypt");
		btnCaesarDecrypts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String outPut = pythonHandler
							.givenPythonScript_whenPythonProcessExecuted_thenSuccessCaesarCipherWithKeywordDirectInput(
									txtCipherKeyword.getText(), keywordTextFieldSubstitution.getText(), "2");
					outputTextAreasSubstitution.setText(outPut);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnCaesarDecrypts.setBounds(328, 293, 128, 25);
		panelSubstitutionCipherWithaKeyword.add(btnCaesarDecrypts);

		JLabel labels = new JLabel("plain_text / cipher_text");
		labels.setBounds(44, 328, 156, 16);
		panelSubstitutionCipherWithaKeyword.add(labels);

		JLabel lblNewLabel_2sss = new JLabel("Keyword:");
		lblNewLabel_2sss.setBounds(44, 261, 56, 16);
		panelSubstitutionCipherWithaKeyword.add(lblNewLabel_2sss);

		keywordTextFieldSubstitution = new JTextField();
		keywordTextFieldSubstitution.setBounds(101, 258, 209, 22);
		panelSubstitutionCipherWithaKeyword.add(keywordTextFieldSubstitution);

		JScrollPane scrollPane_1ss = new JScrollPane();
		scrollPane_1ss.setBounds(44, 349, 612, 124);
		panelSubstitutionCipherWithaKeyword.add(scrollPane_1ss);

		outputTextAreasSubstitution = new JTextArea();
		scrollPane_1ss.setViewportView(outputTextAreasSubstitution);

		JButton btnNewButtonCipherKeywordClear = new JButton("Clear fields");
		btnNewButtonCipherKeywordClear.setBounds(478, 293, 109, 25);
		panelSubstitutionCipherWithaKeyword.add(btnNewButtonCipherKeywordClear);

		JLabel label_1 = new JLabel("Alphabet");
		label_1.setBounds(334, 261, 56, 16);
		panelSubstitutionCipherWithaKeyword.add(label_1);

		JComboBox comboBox_Cipher_Keyword = new JComboBox(Alphabet);
		comboBox_Cipher_Keyword.setBounds(409, 258, 109, 22);
		panelSubstitutionCipherWithaKeyword.add(comboBox_Cipher_Keyword);
		comboBox_Cipher_Keyword.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String key = comboBox_Cipher_Keyword.getItemAt(comboBox_Cipher_Keyword.getSelectedIndex()) + "";
//				selectAlphabetPlot(comboBox_Plot_FA.getSelectedIndex(), txtAlphabetPlot);
				System.out.println("MainWindow.initialize().new ItemListener() {...}.itemStateChanged(key)" + key);
				System.out.println(
						"MainWindow.initialize().new ItemListener() {...}.itemStateChanged(comboBox_Cipher_Keyword.getSelectedIndex())"
								+ comboBox_Cipher_Keyword.getSelectedIndex());
			}
		});

		/////////////////////////////////////////////////////////////////////////////////////////

		JPanel panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis = new JPanel();
		tabbedPane.addTab("Cracking Substitution Cipher With a Keyword Using Frequency Analysis", null,
				panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis, null);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.setLayout(null);

		JLabel lblNewLabel_1ss = new JLabel("ciphertext");
		lblNewLabel_1ss.setBounds(44, 31, 156, 16);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(lblNewLabel_1ss);

//		JButton btnEncrypts = new JButton("Encrypt");
//		btnEncrypts.setBounds(219, 216, 128, 25);
//		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(btnEncrypts);

		JScrollPane scrollPaness = new JScrollPane();
		scrollPaness.setBounds(44, 62, 612, 124);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(scrollPaness);

		JTextArea textAreas = new JTextArea();
		scrollPaness.setViewportView(textAreas);

		JButton btnDecrypts = new JButton("decrypt");
		btnDecrypts.setBounds(280, 216, 128, 25);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(btnDecrypts);

		// JLabel lblNewLabel_2ss = new JLabel("Keyword:");
		// lblNewLabel_2ss.setBounds(44, 206, 56, 16);
		// panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(lblNewLabel_2ss);

		// JTextField keywordTextFieldss = new JTextField();
		// keywordTextFieldss.setBounds(101, 203, 209, 22);
		// panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(keywordTextFieldss);

		JLabel labelss = new JLabel("plain_text");
		labelss.setBounds(44, 251, 156, 16);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(labelss);

		JScrollPane scrollPane_1sss = new JScrollPane();
		scrollPane_1sss.setBounds(44, 272, 612, 124);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(scrollPane_1sss);

		outputTextAreass = new JTextArea();
		scrollPane_1sss.setViewportView(outputTextAreass);

		btnNewButtonLetterFAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rdbtnNewRadioButtonLetterFAFile.setSelected(true);
					JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
					jfc.setDialogTitle("Select an text file");
					jfc.setAcceptAllFileFilterUsed(false);
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
					jfc.addChoosableFileFilter(filter);
					int returnValue = jfc.showOpenDialog(frmFrequencyAnalysisV);
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						textFieldLetterFAFile.setText(jfc.getSelectedFile().getPath());
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		textFieldLetterFAFile = new JTextField();
		textFieldLetterFAFile.setEditable(false);
		textFieldLetterFAFile.setBounds(149, 231, 507, 22);
		panelFALetters.add(textFieldLetterFAFile);
		textFieldLetterFAFile.setColumns(10);

		JButton btnLetter = new JButton("Generated Report");
		btnLetter.setBounds(222, 279, 149, 25);
		panelFALetters.add(btnLetter);

		JLabel labelLetter = new JLabel("Output");
		labelLetter.setBounds(44, 319, 156, 16);
		panelFALetters.add(labelLetter);

		JScrollPane scrollPaneLetterOutPut = new JScrollPane();
		scrollPaneLetterOutPut.setBounds(44, 351, 612, 124);
		panelFALetters.add(scrollPaneLetterOutPut);

		txtrLetterOutPut = new JTextArea();
		txtrLetterOutPut.setRows(25);
		txtrLetterOutPut.setColumns(25);
		scrollPaneLetterOutPut.setViewportView(txtrLetterOutPut);
		txtrLetterOutPut.setLineWrap(true);

		JButton btnNewButtonLetterFA = new JButton("Clear Fields");
		btnNewButtonLetterFA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButtonLetterFADirect.setSelected(true);
				txtrLetter.setText("");
				textFieldLetterFAFile.setText("");
				txtrLetterOutPut.setText("");
			}
		});
		btnNewButtonLetterFA.setBounds(387, 279, 123, 25);
		panelFALetters.add(btnNewButtonLetterFA);

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

//					System.out.println("MainWindow.initialize().new ItemListener() {...}.itemStateChanged()"
//							+ comboBox_Plot_FA.getSelectedIndex());

					if (rdbtnNewRadioButtonPlotFADirect.isSelected()) {
						String directInput = txtrPlotFA.getText();
						if ((directInput == null) || (directInput.trim().length() == 0)) {
							JOptionPane.showMessageDialog(frmFrequencyAnalysisV, "Direct Input text is required");
							return;
						}
						String outPut = pythonHandler
								.givenPythonScript_whenPythonProcessExecuted_thenSuccessPlotFADirectInput(
										txtrPlotFA.getText(), comboBox_Plot_FA.getSelectedIndex() + "");
					} else if (rdbtnNewRadioButtonPlotFAFile.isSelected()) {
						// Validate Choose a File
						String fileName = textFieldPlotFAFile.getText();
						if ((fileName == null) || (fileName.trim().length() == 0)) {
							JOptionPane.showMessageDialog(frmFrequencyAnalysisV, "File must be selected");
							return;
						}
						boolean isEmpty = FileHandlerThesis.isFileEmpty(textFieldPlotFAFile.getText());
						if (!isEmpty) {
							JOptionPane.showMessageDialog(frmFrequencyAnalysisV, "The File is empty");
							return;
						}
						int i = FileHandlerThesis.validateCharacters(textFieldPlotFAFile.getText());
						if (i == 0) {
							JOptionPane.showMessageDialog(frmFrequencyAnalysisV, "The File is not having content");
							return;
						} else if (i == 1) {
							JOptionPane.showMessageDialog(frmFrequencyAnalysisV,
									"File is having more than 10000 Characters");
							return;
						} else if (i == 2) {
							String outPut = pythonHandler
									.givenPythonScript_whenPythonProcessExecuted_thenSuccessPlotFAFile(
											textFieldPlotFAFile.getText(), comboBox_Plot_FA.getSelectedIndex() + "");
						}

					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (rdbtnNewRadioButtonLetterFADirect.isSelected()) {
//						String directInput = txtrLetter.getText();
						String directInput = new String(txtrLetter.getText().getBytes(), "UTF-8");
						System.out.println(
								"MainWindow.initialize().new ActionListener() {...}.actionPerformed()" + directInput);
						if ((directInput == null) || (directInput.trim().length() == 0)) {
							JOptionPane.showMessageDialog(frmFrequencyAnalysisV, "Direct Input text is required");
							return;
						}
						String outPut = pythonHandler
								.givenPythonScript_whenPythonProcessExecuted_thenSuccessLetterFADirectInput(
										txtrLetter.getText(), 1);
						txtrLetterOutPut.setText(outPut);

					} else if (rdbtnNewRadioButtonLetterFAFile.isSelected()) {
						// Validate Choose a File
						String fileName = textFieldLetterFAFile.getText();
						if ((fileName == null) || (fileName.trim().length() == 0)) {
							JOptionPane.showMessageDialog(frmFrequencyAnalysisV, "File must be selected");
							return;
						}
						boolean isEmpty = FileHandlerThesis.isFileEmpty(textFieldLetterFAFile.getText());
						if (!isEmpty) {
							JOptionPane.showMessageDialog(frmFrequencyAnalysisV, "The File is empty");
							return;
						}
						int i = FileHandlerThesis.validateCharacters(textFieldLetterFAFile.getText());
						if (i == 0) {
							JOptionPane.showMessageDialog(frmFrequencyAnalysisV, "The File is not having content");
							return;
						} else if (i == 1) {
							JOptionPane.showMessageDialog(frmFrequencyAnalysisV,
									"File is having more than 10000 Characters");
							return;
						} else if (i == 2) {

							String outPut = pythonHandler
									.givenPythonScript_whenPythonProcessExecuted_thenSuccessLetterFAFile(
											textFieldLetterFAFile.getText(), 1);
							txtrLetterOutPut.setText(outPut);
						}
					}
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
