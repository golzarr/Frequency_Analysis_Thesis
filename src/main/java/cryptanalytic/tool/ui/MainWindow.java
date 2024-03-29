package cryptanalytic.tool.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.PlainDocument;

import cryptanalytic.tool.python.PythonHandler;
import cryptanalytic.tool.ui.util.FileHandlerThesis;
import cryptanalytic.tool.ui.util.JFileChooserHandler;
import cryptanalytic.tool.ui.util.StockPublicNotesDocumentFilter;

public class MainWindow {

	private JFrame frmFrequencyAnalysisV;
	private JTextField txtAlphabet;
	private JTextArea txtr;
	private JTextArea txtrOut;
	private JTextArea txtrFA;
	private JTextArea outputTextAreaSubstitutionA;
	private JTextArea txtrPlotFA;
	private JTextArea txtrLetter;
	private JTextArea txtrLetterOutPut;
	private JTextArea outputTextAreasCipherKeywordFA;
	private JTextArea outputTextAreaSubstitution;
	private JTextArea txtCipherKeyword;
	private PythonHandler pythonHandler = new PythonHandler();
	private String[] defaultKeys = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
	private JComboBox comboBox;
	private JComboBox comboBoxFA;
	private JComboBox comboBox_Cipher_Keyword;
	private JTextField textFieldPlotFAFile;
	private JTextField textFieldLetterFAFile;
	private JTextField keywordTextFieldSubstitution;
	private JTextArea textAreaCipherKeyword;

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
//		frmFrequencyAnalysisV.setTitle("Nástroj na analýzu frekvencie");
		frmFrequencyAnalysisV.setBounds(100, 100, 886, 581);
		frmFrequencyAnalysisV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFrequencyAnalysisV.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmFrequencyAnalysisV.getContentPane().add(tabbedPane);
		
		

		JPanel panel = new JPanel();
		tabbedPane.addTab("Cézarova Šifra", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nešifrovaný Text");
		lblNewLabel_1.setBounds(44, 31, 156, 16);
		panel.add(lblNewLabel_1);

		JButton btnNewButtonEncrypt = new JButton("Zašifrovať");
		btnNewButtonEncrypt.setBounds(300, 216, 128, 25);
		panel.add(btnNewButtonEncrypt);
		// txtr.setBounds(43, 104, 98, 98);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 62, 612, 124);
		panel.add(scrollPane);

		txtr = new JTextArea();
		txtr.setRows(25);
		txtr.setColumns(25);

		scrollPane.setViewportView(txtr);
		txtr.setLineWrap(true);
		txtr.setRows(25);
		txtr.setColumns(25);
		
		JLabel label = new JLabel("Zašifrovaný Text");
		label.setBounds(44, 271, 156, 16);
		panel.add(label);
		
		comboBox = new JComboBox(defaultKeys);
		comboBox.setBounds(75, 216, 72, 22);
		comboBox.setSelectedItem("3");
		panel.add(comboBox);
		
		
		
		
		
		
		

		JButton btnCaesarDecrypt = new JButton("caesar_decrypt");
		btnCaesarDecrypt.setBounds(373, 216, 128, 25);
	//	panel.add(btnCaesarDecrypt);



		
		JPanel panelFA = new JPanel();
		tabbedPane.addTab("Prelamovanie Cézarovej Šifry Pomocou Frekvenčnej Analýzy", null, panelFA, null);
		panelFA.setLayout(null);
		
		
		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
				int index = sourceTabbedPane.getSelectedIndex();
				System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
				System.out.println("Tab changed to index " + index);
				if (index == 5) {
					if (outputTextAreaSubstitution.getText().trim().length() > 0) {
						textAreaCipherKeyword.setText(outputTextAreaSubstitution.getText().trim());
					}
				}
			}
		};
		
		
		ChangeListener changeListenerCrackingCaesarCipherWithFrequencyAnalysis = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
				int index = sourceTabbedPane.getSelectedIndex();
				System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
				System.out.println("Tab changed to index " + index);
				if (index == 1) {
					if (txtrOut.getText().trim().length() > 0) {
						txtrFA.setText(txtrOut.getText().trim());
					}
				}
			}
		};
		
		
		
		
		
		tabbedPane.addChangeListener(changeListener);
		tabbedPane.addChangeListener(changeListenerCrackingCaesarCipherWithFrequencyAnalysis);

		JLabel lblNewLabel_2 = new JLabel("Zašifrovaný Text");
		lblNewLabel_2.setBounds(42, 24, 110, 16);
		panelFA.add(lblNewLabel_2);
		
		JLabel lblNewLabel_Cracked_Text = new JLabel("Prelomený Text");
		lblNewLabel_Cracked_Text.setBounds(42, 300, 110, 16);
		panelFA.add(lblNewLabel_Cracked_Text);


		
		JButton btnNewButtonCrackTest = new JButton("Prelomiť");
		btnNewButtonCrackTest.setBounds(301, 225, 97, 25);
		panelFA.add(btnNewButtonCrackTest);
		
    //	txtr.setBounds(43, 104, 98, 98);
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(42, 53, 612, 98);
		panelFA.add(scrollPane2);

		txtrFA = new JTextArea();
		txtrFA.setRows(25);
		txtrFA.setColumns(25);
	//	txtrFA.setText("Some text to display in the JTextArea");
		scrollPane2.setViewportView(txtrFA);
		// panel.add(txtr);
		txtrFA.setLineWrap(true);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(43, 324, 607, 100);
		panelFA.add(scrollPane3);

		// Create the JTextArea outputTextAreaSubstitutionA and add it to the JScrollPane
		outputTextAreaSubstitutionA = new JTextArea();
		outputTextAreaSubstitutionA.setLineWrap(true);
		scrollPane3.setViewportView(outputTextAreaSubstitutionA);
		
		
		


	/*	JLabel lblNewLabel = new JLabel("Alphabet");
		lblNewLabel.setBounds(42, 171, 63, 16);
		panelFA.add(lblNewLabel);
*/
		
		
		txtAlphabet = new JTextField();
		txtAlphabet.setVisible(false);
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
//		txtrOut.setText("Some text to display in the JTextArea");

		scrollPane_1.setViewportView(txtrOut);
		// panel.add(txtr);
		txtrOut.setLineWrap(true);
		txtrOut.setRows(25);
		txtrOut.setColumns(25);

		comboBox = new JComboBox(defaultKeys);
		comboBox.setBounds(75, 216, 72, 22);
		comboBox.setSelectedItem("3");
		panel.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("Kľúč");
		lblNewLabel_3.setBounds(43, 219, 56, 16);
		panel.add(lblNewLabel_3);

		comboBoxFA = new JComboBox(defaultKeys);
		comboBoxFA.setVisible(false);
		comboBoxFA.setBounds(157, 225, 72, 22);
//		comboBoxFA.setSelectedItem("3");
		comboBoxFA.setSelectedIndex(-1);
		panelFA.add(comboBoxFA);
		
		

	/*	JLabel lblNewLabel_4 = new JLabel("The Key Value is");
		lblNewLabel_4.setBounds(42, 228, 110, 16);
		panelFA.add(lblNewLabel_4);
		
		*/

		JPanel panelPlot = new JPanel();
		tabbedPane.addTab("Graf Frekvenčnej Analýzy", null, panelPlot, null);
		panelPlot.setLayout(null);

		JLabel lblNewLabelFA = new JLabel("Frekvenčná Analýza");
		lblNewLabelFA.setVisible(false);
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

		JLabel lblNewLabelPlot = new JLabel("Písmená");
		lblNewLabelPlot.setBounds(44, 333, 63, 16);
		panelPlot.add(lblNewLabelPlot);

		JTextField txtAlphabetPlot = new JTextField();
		txtAlphabetPlot.setText("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		txtAlphabetPlot.setEditable(false);
		txtAlphabetPlot.setBounds(119, 326, 537, 31);
		panelPlot.add(txtAlphabetPlot);
		txtAlphabet.setColumns(10);

		JButton btnFrequencyAnalysisPlot = new JButton("Vytvoriť Graf");
		btnFrequencyAnalysisPlot.setBounds(230, 396, 121, 25);
		panelPlot.add(btnFrequencyAnalysisPlot);

		JLabel lblNewLabel_Panel_Plot = new JLabel("Abeceda");
		lblNewLabel_Panel_Plot.setBounds(44, 288, 56, 16);
		panelPlot.add(lblNewLabel_Panel_Plot);

		String[] Alphabet = { "Angličtina", "Slovenčina", "Španielčina" };
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

		JRadioButton rdbtnNewRadioButtonPlotFADirect = new JRadioButton("Priame Zadávanie Textu (Max 100 znakov)");
		rdbtnNewRadioButtonPlotFADirect.setBounds(39, 55, 280, 25);
		panelPlot.add(rdbtnNewRadioButtonPlotFADirect);

		JRadioButton rdbtnNewRadioButtonPlotFAFile = new JRadioButton("Čítanie Textového Súboru");
		rdbtnNewRadioButtonPlotFAFile.setBounds(39, 196, 184, 25);
		panelPlot.add(rdbtnNewRadioButtonPlotFAFile);

		ButtonGroup groupPlotFA = new ButtonGroup();
		groupPlotFA.add(rdbtnNewRadioButtonPlotFADirect);
		groupPlotFA.add(rdbtnNewRadioButtonPlotFAFile);
		rdbtnNewRadioButtonPlotFADirect.setSelected(true);

		JButton btnNewButtonPlotFAFile = new JButton("Súbor");
		btnNewButtonPlotFAFile.setBounds(44, 230, 97, 25);
		panelPlot.add(btnNewButtonPlotFAFile);

		btnNewButtonPlotFAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rdbtnNewRadioButtonPlotFAFile.setSelected(true);
					String files = JFileChooserHandler.maximunFiles(frmFrequencyAnalysisV);
					textFieldPlotFAFile.setText(files);
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

		JButton btnNewButtonPlotFA = new JButton("Vymazať Polia");
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
		
		JPanel panelVigenere = new JPanel();
		JTextArea textAreaVigenere = new JTextArea(5, 20); // Adjust rows and columns as needed
		JTextArea textAreaSecondVigenere = new JTextArea(5, 20); // Adjust rows and columns as needed
		JTextField keywordTextFieldVigenere = new JTextField();     
		JComboBox comboBox_Vigenere_Cipher = new JComboBox(Alphabet);
        panelVigenere.add(comboBox_Vigenere_Cipher);
		
		JButton btnNewButtonVigenereCipher = new JButton("Vymazať Polia");
		btnNewButtonVigenereCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaVigenere.setText("");
				keywordTextFieldVigenere.setText("");
				textAreaSecondVigenere.setText("");
				comboBox_Vigenere_Cipher.setSelectedIndex(0);

			}
		});
		btnNewButtonVigenereCipher.setBounds(458, 300, 132, 25);
		panelVigenere.add(btnNewButtonVigenereCipher);
		
		

		JPanel panelFALetters = new JPanel();
		tabbedPane.addTab("Frekvenčná Analýza", null, panelFALetters, null);
		panelFALetters.setLayout(null);

		JLabel lblNewLabelFALetters = new JLabel("Frequency Analysis Letters");
		lblNewLabelFALetters.setVisible(false);
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

		JRadioButton rdbtnNewRadioButtonLetterFADirect = new JRadioButton("Priame Zadávanie Textu (Max 100 znakov)");
		rdbtnNewRadioButtonLetterFADirect.setBounds(39, 55, 280, 25);
		panelFALetters.add(rdbtnNewRadioButtonLetterFADirect);

		JRadioButton rdbtnNewRadioButtonLetterFAFile = new JRadioButton("Čítanie Textového Súboru");
		rdbtnNewRadioButtonLetterFAFile.setBounds(39, 196, 184, 25);
		panelFALetters.add(rdbtnNewRadioButtonLetterFAFile);

		ButtonGroup groupPlotLetterFA = new ButtonGroup();
		groupPlotLetterFA.add(rdbtnNewRadioButtonLetterFADirect);
		groupPlotLetterFA.add(rdbtnNewRadioButtonLetterFAFile);
		rdbtnNewRadioButtonLetterFADirect.setSelected(true);

		JButton btnNewButtonLetterFAFile = new JButton("Súbor");
		btnNewButtonLetterFAFile.setBounds(44, 230, 97, 25);
		panelFALetters.add(btnNewButtonLetterFAFile);


		JPanel panelSubstitutionCipherWithaKeyword = new JPanel();
	//	tabbedPane.addTab("Substitution Cipher With a Keyword", null, panelSubstitutionCipherWithaKeyword, null);
		panelSubstitutionCipherWithaKeyword.setLayout(null);

		JLabel lblNewLabel_1s = new JLabel("Nešifrovaný Text");
		lblNewLabel_1s.setBounds(44, 31, 156, 16);
		panelSubstitutionCipherWithaKeyword.add(lblNewLabel_1s);

		JButton btnNewButtonEncryptSubstitutionCipher = new JButton("Encrypt");
		btnNewButtonEncryptSubstitutionCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String outPut = pythonHandler
							.givenPythonScript_whenPythonProcessExecuted_thenSuccessCaesarCipherWithKeywordDirectInput(
									txtCipherKeyword.getText(), keywordTextFieldSubstitution.getText(), "1",
									comboBox_Cipher_Keyword.getSelectedIndex() + "");
					outputTextAreaSubstitution.setText(outPut);
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		                                             
		JButton btnNewButtonEncryptVigenereCipher = new JButton("Zašifrovať");
		btnNewButtonEncryptVigenereCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String outPut = pythonHandler
							.givenPythonScript_whenPythonProcessExecuted_thenSuccessVigenereCipher(
									textAreaVigenere.getText(), keywordTextFieldVigenere.getText(), "1",
									comboBox_Vigenere_Cipher.getSelectedIndex() + "");
					textAreaSecondVigenere.setText(outPut);
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		
		
		
		
		btnNewButtonEncryptSubstitutionCipher.setBounds(174, 293, 128, 25);
		panelSubstitutionCipherWithaKeyword.add(btnNewButtonEncryptSubstitutionCipher);
		JScrollPane scrollPanes = new JScrollPane();
		scrollPanes.setBounds(44, 62, 612, 124);
		panelSubstitutionCipherWithaKeyword.add(scrollPanes);

		txtCipherKeyword = new JTextArea();
		txtCipherKeyword.setRows(25);
		txtCipherKeyword.setColumns(25);

		scrollPanes.setViewportView(txtCipherKeyword);
		txtCipherKeyword.setLineWrap(true);
		txtCipherKeyword.setRows(25);
		txtCipherKeyword.setColumns(25);

		JButton btnCaesarDecrypts = new JButton("Decrypt");
		btnCaesarDecrypts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String outPut = pythonHandler
							.givenPythonScript_whenPythonProcessExecuted_thenSuccessCaesarCipherWithKeywordDirectInput(
									txtCipherKeyword.getText(), keywordTextFieldSubstitution.getText(), "2",
									comboBox_Cipher_Keyword.getSelectedIndex() + "");
					outputTextAreaSubstitution.setText(outPut);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnCaesarDecrypts.setBounds(328, 293, 128, 25);
		panelSubstitutionCipherWithaKeyword.add(btnCaesarDecrypts);

		JLabel labels = new JLabel("Zašifrovaný Text");
		labels.setBounds(44, 328, 156, 16);
		panelSubstitutionCipherWithaKeyword.add(labels);

		JLabel lblNewLabel_2sss = new JLabel("Kľúč:");
		lblNewLabel_2sss.setBounds(44, 261, 56, 16);
		panelSubstitutionCipherWithaKeyword.add(lblNewLabel_2sss);

		keywordTextFieldSubstitution = new JTextField();
		keywordTextFieldSubstitution.setBounds(101, 258, 209, 22);
		panelSubstitutionCipherWithaKeyword.add(keywordTextFieldSubstitution);

		JScrollPane scrollPane_1ss = new JScrollPane();
		scrollPane_1ss.setBounds(44, 349, 612, 124);
		panelSubstitutionCipherWithaKeyword.add(scrollPane_1ss);

		outputTextAreaSubstitution = new JTextArea();
	//	outputTextAreaSubstitution.setText("Some text to display in the JTextArea");
		scrollPane_1ss.setViewportView(outputTextAreaSubstitution);

		JButton btnNewButtonCipherKeywordClear = new JButton("Vymazať Polia");
		btnNewButtonCipherKeywordClear.setBounds(478, 293, 109, 25);
		panelSubstitutionCipherWithaKeyword.add(btnNewButtonCipherKeywordClear);

		JLabel label_1 = new JLabel("Abeceda");
		label_1.setBounds(334, 261, 56, 16);
		panelSubstitutionCipherWithaKeyword.add(label_1);

		comboBox_Cipher_Keyword = new JComboBox(Alphabet);
		
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
		

		
		
		comboBox_Vigenere_Cipher.setBounds(409, 211, 109, 22);
		comboBox_Vigenere_Cipher.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String key = comboBox_Vigenere_Cipher.getItemAt(comboBox_Vigenere_Cipher.getSelectedIndex()) + "";
//				selectAlphabetPlot(comboBox_Plot_FA.getSelectedIndex(), txtAlphabetPlot);
				System.out.println("MainWindow.initialize().new ItemListener() {...}.itemStateChanged(key)" + key);
				System.out.println(
						"MainWindow.initialize().new ItemListener() {...}.itemStateChanged(comboBox_Vigenere_Cipher.getSelectedIndex())"
								+ comboBox_Vigenere_Cipher.getSelectedIndex());
			}
		});

		/////////////////////////////////////////////////////////////////////////////////////////

		JPanel panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis = new JPanel();
	//	tabbedPane.addTab("Cracking Substitution Cipher With a Keyword Using Frequency Analysis", null,
	//			panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis, null);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.setLayout(null);

		JLabel lblNewLabel_1ss = new JLabel("Zašifrovaný Text");
		lblNewLabel_1ss.setBounds(44, 31, 156, 16);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(lblNewLabel_1ss);

//		JButton btnEncrypts = new JButton("Encrypt");
//		btnEncrypts.setBounds(219, 216, 128, 25);
//		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(btnEncrypts);

		JScrollPane scrollPaness = new JScrollPane();
		scrollPaness.setBounds(44, 62, 612, 124);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(scrollPaness);

		textAreaCipherKeyword = new JTextArea();    //Cracking Substitution Cipher With a Keyword Using Frequency Analysis first TextArea
		scrollPaness.setViewportView(textAreaCipherKeyword);

		JButton btnDecrypts = new JButton("Prelomiť");
		btnDecrypts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String outPut = pythonHandler
							.givenPythonScript_whenPythonProcessExecuted_thenSuccessCipherKeywordFADirectInput(
									textAreaCipherKeyword.getText(), keywordTextFieldSubstitution.getText(), "2",
									comboBox_Cipher_Keyword.getSelectedIndex() + "");
					outputTextAreasCipherKeywordFA.setText(outPut);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnDecrypts.setBounds(280, 216, 128, 25);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(btnDecrypts);
		

		JLabel labelss = new JLabel("Nezašifrovaný Text");
		labelss.setBounds(44, 251, 156, 16);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(labelss);

		JScrollPane scrollPane_1sss = new JScrollPane();
		scrollPane_1sss.setBounds(44, 272, 612, 124);
		panelCrackingSubstitutionCipherWithaKeywordUsingFrequencyAnalysis.add(scrollPane_1sss);

		outputTextAreasCipherKeywordFA = new JTextArea();
		scrollPane_1sss.setViewportView(outputTextAreasCipherKeywordFA);

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
		
	

		
		JButton btnNewButtonVigenereCipher2 = new JButton("Vybrať Súbor");
		btnNewButtonVigenereCipher2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Select text files");
		jfc.setMultiSelectionEnabled(true);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		jfc.addChoosableFileFilter(filter);
		int returnValue = jfc.showOpenDialog(frmFrequencyAnalysisV);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
		    File[] selectedFiles = jfc.getSelectedFiles();
		    StringBuilder fileContent = new StringBuilder();
		    for (File file : selectedFiles) {
		        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
		            String line;
		            while ((line = br.readLine()) != null) {
		                fileContent.append(line);
		            }
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		    }
		    textAreaVigenere.setText(fileContent.toString());
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

		JButton btnLetter = new JButton("Vygenerovať Správu");
		btnLetter.setBounds(172, 279, 200, 25);
		panelFALetters.add(btnLetter);

		JLabel labelLetter = new JLabel("Výstup");
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

		JButton btnNewButtonLetterFA = new JButton("Vymazať Polia");
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
		

		tabbedPane.addTab("Vigenerova Šifra", null, panelVigenere, null);
		panelVigenere.setLayout(null);
		
		JLabel lblNewLabelVigenereAlphabet = new JLabel("Abeceda");
		lblNewLabelVigenereAlphabet.setBounds(352, 211, 63, 16);
		panelVigenere.add(lblNewLabelVigenereAlphabet);

	
		
		
		JLabel lblNewLabel_Vigenere = new JLabel("Kľúč:");
		lblNewLabel_Vigenere.setBounds(44, 211, 56, 16);
		panelVigenere.add(lblNewLabel_Vigenere);
		
		
		keywordTextFieldVigenere.setBounds(101, 211, 209, 22);
		panelVigenere.add(keywordTextFieldVigenere);

		btnNewButtonVigenereCipher2.setBounds(44, 260, 125, 25);
		panelVigenere.add(btnNewButtonVigenereCipher2);
		
		
		btnNewButtonEncryptVigenereCipher.setBounds(294, 300, 117, 25);
		panelVigenere.add(btnNewButtonEncryptVigenereCipher);
		
		

		textAreaVigenere.setLineWrap(true);
		textAreaVigenere.setWrapStyleWord(true);
	//	textAreaVigenere.append("TRESKÁREŇNAHERLIANSKEJNÁJDEMENAROHUBUDOVYOBCHODNÉHODOMUHELIOSKTORÝSTATOČNEODOLÁVAZUBUČASUIKEĎPÔSOBÍAKOSOCIALISTICKÝSKANZENNAVŠTEVUJEJUVERNÁAŠPECIFICKÁKLIENTELAVĎAKAKTOREJPRIAZNIPREŽÍVAVBEZPROSTREDNOMSUSEDSTVEVYCHYTENEJŠÍCHPODNIKOVAKOMINTČIRUŽINOVSKÁKLUBOVŇAJETORARITAOBCHODOVAKOTENNÁŠJEČORAZMENEJANIČTAKÉTONENÁJDETEANIVČESKUHOVORÍPREDAVAČKAMIROSLAVANAJNOSTALGICKEJŠÍNÁVŠTEVNÍCISIDOPREVÁDZKYPRICHÁDZAJÚPOSTÁŤUŽODROKOVOTVORILIKEĎSTEVYEŠTENEBOLINASVETEVEĽKÝMROZDIELOMOPROTIKONKURENCIIJETOŽESITUVÁŽIAROBOTUASTARAJÚSAOTOVARKEBYTONEBOLODOBRÉĽUDIABYSANEVRÁTILIVRAVÍNÁMSPOKOJNÝŠESŤDESIATNIK");
		

		int x = 60; // X position
		int y = 80; // Y position
		int width = 700; // Width
		int height = 100; // Height

		JScrollPane scrollPaneVigenere = new JScrollPane(textAreaVigenere);
		scrollPaneVigenere.setBounds(x, y, width, height);

		// Add the JScrollPane to your container (e.g., a JPanel)
		panelVigenere.add(scrollPaneVigenere);

	/*	
		JTextField keywordTextFieldVigenere = new JTextField();
		keywordTextFieldVigenere.setBounds(51, 88, 709, 120);
		panelVigenere.add(keywordTextFieldVigenere);
		
		*/
		
		/*	
		
		JTextField keywordTextFieldSecondVigenere = new JTextField();
		keywordTextFieldSecondVigenere.setBounds(51, 288, 709, 120);
		panelVigenere.add(keywordTextFieldSecondVigenere);

		*/
		
		
		textAreaSecondVigenere.setLineWrap(true);
		textAreaSecondVigenere.setWrapStyleWord(true);
//		textAreaSecondVigenere.append("TŽHÍŔKRŤRŽETEŽÓCEŽSAHDŤKJQHDĹŽAŽŔÁBĹUQŔNDÁBÔKÉHŽÉWŔUÚZUWHDPÁSAXÉÝHSGDKÚNNŤŔUÚYÁIDWBĹUPDÍBÚKŤÉHWDOÓNRŔÁSDDCEYIÉXCHXÝÉORŤÔECQRČZTŤŽĹRRJCŽÝÝŽÁNWHĹMIÚMTŔKKÁMÝŤDEÁDNIJKNOKÚDEŽTHPJZCMHÝRŽZŽRČĹESTHÚDTŽHUŤÁMÉÝÍĹŇSGŽÝČCCWÄKĹŽEŽWČHTPDEŽPXOIDĎÚZICXŤPDUTMŽÚFSAĎĎSEBDŽEEWEGŔHEDIGDÉGMHDEÉČJKDXÝŤŽÁFŇÝCÁRNGDĹŽEŽDŽPNTNOZÁÁNŤQŔRŇEGHRŤÚVPHÍŔEHDŽÉÝVPŽHUEFAPORTÚRDVDEFACDDŤÁSGDDŇÚCAHDAVNŇŽJÁRVCNTPDIQŔHÝRVŇEWŔCPŽMTOKDSDDCCOÉXŔÄEŽDEHÚXOIŔKČÁRÝÓCŔRĎÉXÝČCEFXÝŤRBDÓCŤJSIHKĹFEĽABDÝÁZQMÝSÁMDTHÚDIAŔŽŔERŤQTPÚJŤXÉLRSÝXĹČKŽÝDHÚĹOGÝRŽDAŽDDCDADXÉČJRAHŠDDOCHŠÚYOQŔŠÝŔĽUQMRGCSNQÝČDÁGMDPFRNŽČŤKMÉTÉŔÁJCBJĹDŤQHÍPJTCMĎ");

		int textAreaSecondVigenereX = 60; // X position
		int textAreaSecondVigenereY = 350; // Y position
		int textAreaSecondVigenereWidth = 700; // Width
		int textAreaSecondVigenereHeight = 100; // Height

		JScrollPane scrollPaneSecondVigenere = new JScrollPane(textAreaSecondVigenere);
		scrollPaneSecondVigenere.setBounds(textAreaSecondVigenereX, textAreaSecondVigenereY, textAreaSecondVigenereWidth, textAreaSecondVigenereHeight);


		panelVigenere.add(scrollPaneSecondVigenere);

		

		
		JLabel lblNewLabelVigenere = new JLabel("Nešifrovaný Text (Zadajte Veľké Písmená Bez Medzier a Bez Diakritiky)");
		lblNewLabelVigenere.setBounds(44, 31, 456, 16);
		panelVigenere.add(lblNewLabelVigenere);
		
		JLabel lblNewLabelSecondVigenere = new JLabel("Zašifrovaný Text");
		lblNewLabelSecondVigenere.setBounds(44, 321, 156, 16);
		panelVigenere.add(lblNewLabelSecondVigenere);

		
		JPanel panelCrackingVigenere = new JPanel();
		tabbedPane.addTab("Prelamovanie Vigenerovej Šifry Pomocou Frekvenčnej Analýzy", null, panelCrackingVigenere, null);
		panelCrackingVigenere.setLayout(null);
		
		

		JTextArea textAreaCrackingVigenere = new JTextArea();


		textAreaCrackingVigenere.setLineWrap(true);
		textAreaCrackingVigenere.setWrapStyleWord(true);
	//	textAreaCrackingVigenere.append("test");

		JScrollPane scrollPaneCrackingVigenere = new JScrollPane(textAreaCrackingVigenere);


		int textAreaCrackingVigenereX = 60; 
		int textAreaCrackingVigenereY = 80; 
		int textAreaCrackingVigenereWidth = 700; 
		int textAreaCrackingVigenereHeight = 100; 
		scrollPaneCrackingVigenere.setBounds(textAreaCrackingVigenereX, textAreaCrackingVigenereY, textAreaCrackingVigenereWidth, textAreaCrackingVigenereHeight);


		panelCrackingVigenere.add(scrollPaneCrackingVigenere);
		
		JLabel lblNewLabelCrackingVigenere = new JLabel("Percento Úspešnosti Prelomenia: ");
	    lblNewLabelCrackingVigenere.setBounds(220, 430, 250, 25);
		panelCrackingVigenere.add(lblNewLabelCrackingVigenere);
		
		
		JTextArea SecondtextAreaCrackingVigenere = new JTextArea();

		
		SecondtextAreaCrackingVigenere.setLineWrap(true);
		SecondtextAreaCrackingVigenere.setWrapStyleWord(true);

	//	SecondtextAreaCrackingVigenere.append("test");
		
		JScrollPane scrollSecondtextAreaCrackingVigenere = new JScrollPane(SecondtextAreaCrackingVigenere);

		
		int SecondtextAreaCrackingVigenereX = 60; 
		int SecondtextAreaCrackingVigenereY = 320; 
		int SecondtextAreaCrackingVigenereWidth = 700; 
		int SecondtextAreaCrackingVigenereHeight = 100; 
		scrollSecondtextAreaCrackingVigenere.setBounds(SecondtextAreaCrackingVigenereX, SecondtextAreaCrackingVigenereY, SecondtextAreaCrackingVigenereWidth, SecondtextAreaCrackingVigenereHeight);

		
		panelCrackingVigenere.add(scrollSecondtextAreaCrackingVigenere);
		
		
		
		
		
		
		JTextArea ThirdTextAreaCrackingVigenere = new JTextArea();

		
		ThirdTextAreaCrackingVigenere.setLineWrap(true);
		ThirdTextAreaCrackingVigenere.setWrapStyleWord(true);
		ThirdTextAreaCrackingVigenere.setEditable(false);
		
			JScrollPane scrollThirdTextAreaCrackingVigenere = new JScrollPane(ThirdTextAreaCrackingVigenere);

		
		int ThirdTextAreaCrackingVigenereX = 410; 
		int ThirdTextAreaCrackingVigenereY = 435; 
		int ThirdTextAreaCrackingVigenereWidth = 70; 
		int ThirdTextAreaCrackingVigenereHeight = 20; 
		scrollThirdTextAreaCrackingVigenere.setBounds(ThirdTextAreaCrackingVigenereX, ThirdTextAreaCrackingVigenereY, ThirdTextAreaCrackingVigenereWidth, ThirdTextAreaCrackingVigenereHeight);
		
		panelCrackingVigenere.add(scrollThirdTextAreaCrackingVigenere);
		
		
		
		
		
		

		
		btnNewButtonCipherKeywordClear.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		outputTextAreaSubstitution.setText("");
		txtCipherKeyword.setText("");
		keywordTextFieldSubstitution.setText("");
	}
});
		
panelSubstitutionCipherWithaKeyword.add(btnNewButtonCipherKeywordClear);
		


JLabel cipherTextLabel = new JLabel("Zašifrovaný Text");


int cipherTextLabelX = 60; 
int cipherTextLabelY = 60; 
int cipherTextLabelWidth = 100; 
int cipherTextLabelHeight = 20; 
cipherTextLabel.setBounds(cipherTextLabelX, cipherTextLabelY, cipherTextLabelWidth, cipherTextLabelHeight);


panelCrackingVigenere.add(cipherTextLabel);



JLabel decodedTextLabel = new JLabel("Prelomený Text");


int decodedTextLabelX = 60; 
int decodedTextLabelY = 300; 
int decodedTextLabelWidth = 100;
int decodedTextLabelHeight = 20; 
decodedTextLabel.setBounds(decodedTextLabelX, decodedTextLabelY, decodedTextLabelWidth, decodedTextLabelHeight);

panelCrackingVigenere.add(decodedTextLabel);





JButton btnCrackVigenereCipherFrequencyAnalysis = new JButton("Prelomiť Anglický Text");
btnCrackVigenereCipherFrequencyAnalysis.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            String outPut = pythonHandler
                    .givenPythonScript_whenPythonProcessExecuted_thenSuccessCrackVigenerCipher(
                            textAreaCrackingVigenere.getText());
            SecondtextAreaCrackingVigenere.setText(outPut);

            // Get the text from both JTextAreas
            String textAreaSecondVigenereContent = textAreaVigenere.getText();
            String SecondtextAreaCrackingVigenereContent = SecondtextAreaCrackingVigenere.getText();

            // Calculate the percentage of matching alphanumeric characters
            int minLength = Math.min(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());
            int maxLength = Math.max(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());
            int matchingChars = 0;
            int totalChars = Math.min(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());

            for (int i = 0; i < totalChars; i++) {
                char c1 = textAreaSecondVigenereContent.charAt(i);
                char c2 = SecondtextAreaCrackingVigenereContent.charAt(i);
                if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2) && c1 == c2) {
                    matchingChars++;
                }
            }

            // Include the remaining alphanumeric characters from the longer text area
            for (int i = totalChars; i < maxLength; i++) {
                char c = SecondtextAreaCrackingVigenereContent.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    totalChars++;
                }
            }

            // Calculate the percentage of match
            double matchPercentage = (double) matchingChars / totalChars * 100;

            // Set the result in the ThirdTextAreaCrackingVigenere
            ThirdTextAreaCrackingVigenere.setText(String.format("%.2f%%", matchPercentage));

        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
});



int btnCrackVigenereCipherFrequencyAnalysisX = 210; 
int btnCrackVigenereCipherFrequencyAnalysisY = 210; 
int btnCrackVigenereCipherFrequencyAnalysisWidth = 200; 
int btnCrackVigenereCipherFrequencyAnalysisHeight = 30; 
btnCrackVigenereCipherFrequencyAnalysis.setBounds(btnCrackVigenereCipherFrequencyAnalysisX, btnCrackVigenereCipherFrequencyAnalysisY, btnCrackVigenereCipherFrequencyAnalysisWidth, btnCrackVigenereCipherFrequencyAnalysisHeight);


panelCrackingVigenere.add(btnCrackVigenereCipherFrequencyAnalysis);




///////////////////////////////////////////////////////////////////////////////////////////////////////






JButton btnCrackVigenereCipherFrequencyAnalysisNewsArticle = new JButton("Prelomiť Slovenský Novinový Článok");
btnCrackVigenereCipherFrequencyAnalysisNewsArticle.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            String outPut = pythonHandler
                    .givenPythonScript_whenPythonProcessExecuted_thenSuccessCrackVigenerCipherNewsArticle(
                            textAreaCrackingVigenere.getText());
            SecondtextAreaCrackingVigenere.setText(outPut);

            // Get the text from both JTextAreas
            String textAreaSecondVigenereContent = textAreaVigenere.getText();
            String SecondtextAreaCrackingVigenereContent = SecondtextAreaCrackingVigenere.getText();

            // Calculate the percentage of matching alphanumeric characters
            int minLength = Math.min(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());
            int maxLength = Math.max(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());
            int matchingChars = 0;
            int totalChars = Math.min(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());

            for (int i = 0; i < totalChars; i++) {
                char c1 = textAreaSecondVigenereContent.charAt(i);
                char c2 = SecondtextAreaCrackingVigenereContent.charAt(i);
                if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2) && c1 == c2) {
                    matchingChars++;
                }
            }

            // Include the remaining alphanumeric characters from the longer text area
            for (int i = totalChars; i < maxLength; i++) {
                char c = SecondtextAreaCrackingVigenereContent.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    totalChars++;
                }
            }

            // Calculate the percentage of match
            double matchPercentage = (double) matchingChars / totalChars * 100;

            // Set the result in the ThirdTextAreaCrackingVigenere
            ThirdTextAreaCrackingVigenere.setText(String.format("%.2f%%", matchPercentage));

        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
});



int btnCrackVigenereCipherFrequencyAnalysisNewsArticleX = 30; 
int btnCrackVigenereCipherFrequencyAnalysisNewsArticleY = 250; 
int btnCrackVigenereCipherFrequencyAnalysisNewsArticleWidth = 250; 
int btnCrackVigenereCipherFrequencyAnalysisNewsArticleHeight = 30; 
btnCrackVigenereCipherFrequencyAnalysisNewsArticle.setBounds(btnCrackVigenereCipherFrequencyAnalysisNewsArticleX, btnCrackVigenereCipherFrequencyAnalysisNewsArticleY, btnCrackVigenereCipherFrequencyAnalysisNewsArticleWidth, btnCrackVigenereCipherFrequencyAnalysisNewsArticleHeight);


panelCrackingVigenere.add(btnCrackVigenereCipherFrequencyAnalysisNewsArticle);







JButton btnCrackVigenereCipherFrequencyAnalysisEducationalArticle = new JButton("Prelomiť Slovenský Odborný Text");
btnCrackVigenereCipherFrequencyAnalysisEducationalArticle.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            String outPut = pythonHandler
                    .givenPythonScript_whenPythonProcessExecuted_thenSuccessCrackVigenerCipherEducationalArticle(
                            textAreaCrackingVigenere.getText());
            SecondtextAreaCrackingVigenere.setText(outPut);

            // Get the text from both JTextAreas
            String textAreaSecondVigenereContent = textAreaVigenere.getText();
            String SecondtextAreaCrackingVigenereContent = SecondtextAreaCrackingVigenere.getText();

            // Calculate the percentage of matching alphanumeric characters
            int minLength = Math.min(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());
            int maxLength = Math.max(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());
            int matchingChars = 0;
            int totalChars = Math.min(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());

            for (int i = 0; i < totalChars; i++) {
                char c1 = textAreaSecondVigenereContent.charAt(i);
                char c2 = SecondtextAreaCrackingVigenereContent.charAt(i);
                if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2) && c1 == c2) {
                    matchingChars++;
                }
            }

            // Include the remaining alphanumeric characters from the longer text area
            for (int i = totalChars; i < maxLength; i++) {
                char c = SecondtextAreaCrackingVigenereContent.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    totalChars++;
                }
            }

            // Calculate the percentage of match
            double matchPercentage = (double) matchingChars / totalChars * 100;

            // Set the result in the ThirdTextAreaCrackingVigenere
            ThirdTextAreaCrackingVigenere.setText(String.format("%.2f%%", matchPercentage));

        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
});



int btnCrackVigenereCipherFrequencyAnalysisEducationalArticleX = 290; 
int btnCrackVigenereCipherFrequencyAnalysisEducationalArticleY = 250; 
int btnCrackVigenereCipherFrequencyAnalysisEducationalArticleWidth = 250; 
int btnCrackVigenereCipherFrequencyAnalysisEducationalArticleHeight = 30; 
btnCrackVigenereCipherFrequencyAnalysisEducationalArticle.setBounds(btnCrackVigenereCipherFrequencyAnalysisEducationalArticleX, btnCrackVigenereCipherFrequencyAnalysisEducationalArticleY, btnCrackVigenereCipherFrequencyAnalysisEducationalArticleWidth, btnCrackVigenereCipherFrequencyAnalysisEducationalArticleHeight);


panelCrackingVigenere.add(btnCrackVigenereCipherFrequencyAnalysisEducationalArticle);



JButton btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticle = new JButton("Prelomiť Slovenský Beletrizovaný Text");
btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticle.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            String outPut = pythonHandler
                    .givenPythonScript_whenPythonProcessExecuted_thenSuccessCrackVigenerCipherFictionalizedArticle(
                            textAreaCrackingVigenere.getText());
            SecondtextAreaCrackingVigenere.setText(outPut);

            // Get the text from both JTextAreas
            String textAreaSecondVigenereContent = textAreaVigenere.getText();
            String SecondtextAreaCrackingVigenereContent = SecondtextAreaCrackingVigenere.getText();

            // Calculate the percentage of matching alphanumeric characters
            int minLength = Math.min(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());
            int maxLength = Math.max(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());
            int matchingChars = 0;
            int totalChars = Math.min(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());

            for (int i = 0; i < totalChars; i++) {
                char c1 = textAreaSecondVigenereContent.charAt(i);
                char c2 = SecondtextAreaCrackingVigenereContent.charAt(i);
                if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2) && c1 == c2) {
                    matchingChars++;
                }
            }

            // Include the remaining alphanumeric characters from the longer text area
            for (int i = totalChars; i < maxLength; i++) {
                char c = SecondtextAreaCrackingVigenereContent.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    totalChars++;
                }
            }

            // Calculate the percentage of match
            double matchPercentage = (double) matchingChars / totalChars * 100;

            // Set the result in the ThirdTextAreaCrackingVigenere
            ThirdTextAreaCrackingVigenere.setText(String.format("%.2f%%", matchPercentage));

        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
});



int btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticleX = 550; 
int btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticleY = 250; 
int btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticleWidth = 300; 
int btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticleHeight = 30; 
btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticle.setBounds(btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticleX, btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticleY, btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticleWidth, btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticleHeight);


panelCrackingVigenere.add(btnCrackVigenereCipherFrequencyAnalysisFictionalizedArticle);













//////////////////////////////////////////////////////////////////////////////////////////////////////////


JButton btnCrackVigenereCipherFrequencyAnalysisSlovak = new JButton("Prelomiť Slovenský Text ");
btnCrackVigenereCipherFrequencyAnalysisSlovak.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            String outPut = pythonHandler
                    .givenPythonScript_whenPythonProcessExecuted_thenSuccessCrackVigenerCipherSlovak(
                            textAreaCrackingVigenere.getText());
            SecondtextAreaCrackingVigenere.setText(outPut);

            // Get the text from both JTextAreas
            String textAreaSecondVigenereContent = textAreaVigenere.getText();
            String SecondtextAreaCrackingVigenereContent = SecondtextAreaCrackingVigenere.getText();

            // Calculate the percentage of matching alphanumeric characters
            int minLength = Math.min(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());
            int maxLength = Math.max(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());
            int matchingChars = 0;
            int totalChars = Math.min(textAreaSecondVigenereContent.length(), SecondtextAreaCrackingVigenereContent.length());

            for (int i = 0; i < totalChars; i++) {
                char c1 = textAreaSecondVigenereContent.charAt(i);
                char c2 = SecondtextAreaCrackingVigenereContent.charAt(i);
                if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2) && c1 == c2) {
                    matchingChars++;
                }
            }

            // Include the remaining alphanumeric characters from the longer text area
            for (int i = totalChars; i < maxLength; i++) {
                char c = SecondtextAreaCrackingVigenereContent.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    totalChars++;
                }
            }

            // Calculate the percentage of match
            double matchPercentage = (double) matchingChars / totalChars * 100;

            // Set the result in the ThirdTextAreaCrackingVigenere
            ThirdTextAreaCrackingVigenere.setText(String.format("%.2f%%", matchPercentage));

        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
});



int btnCrackVigenereCipherFrequencyAnalysisSlovakX = 460; 
int btnCrackVigenereCipherFrequencyAnalysisSlovakY = 210; 
int btnCrackVigenereCipherFrequencyAnalysisSlovakWidth = 200; 
int btnCrackVigenereCipherFrequencyAnalysisSlovakHeight = 30; 
btnCrackVigenereCipherFrequencyAnalysisSlovak.setBounds(btnCrackVigenereCipherFrequencyAnalysisSlovakX, btnCrackVigenereCipherFrequencyAnalysisSlovakY, btnCrackVigenereCipherFrequencyAnalysisSlovakWidth, btnCrackVigenereCipherFrequencyAnalysisSlovakHeight);


panelCrackingVigenere.add(btnCrackVigenereCipherFrequencyAnalysisSlovak);







ChangeListener changeListenerCrackingVigenereFrequencyAnalysis = new ChangeListener() {
	public void stateChanged(ChangeEvent changeEvent) {
		JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		int index = sourceTabbedPane.getSelectedIndex();
		System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
		System.out.println("Tab changed to index " + index);
		if (index == 7) {
			if (textAreaSecondVigenere.getText().trim().length() > 0) {
				textAreaCrackingVigenere.setText(textAreaSecondVigenere.getText().trim());
			}
		}
	}
};



tabbedPane.addChangeListener(changeListenerCrackingVigenereFrequencyAnalysis);
		

		btnNewButtonEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = comboBox.getItemAt(comboBox.getSelectedIndex()) + "";
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
		
		////////////////////////////////////////////////////////////////
		
		btnNewButtonCrackTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = comboBox.getItemAt(comboBoxFA.getSelectedIndex()) + "";
				try {
					String outPut = pythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccessfrequencyAnalysisCaesarCipher(txtrFA.getText());
			//		comboBoxFA.setSelectedItem(outPut);
					outputTextAreaSubstitutionA.setText(outPut);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
/////////////////////////////////////////////////////////////////////////
		
		
	/*	btnNewButtonCrackTest.addActionListener(new ActionListener() {
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
		
		*/

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
						String outPut = pythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccessPlotFAFile(
								textFieldPlotFAFile.getText(), comboBox_Plot_FA.getSelectedIndex() + "");
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
