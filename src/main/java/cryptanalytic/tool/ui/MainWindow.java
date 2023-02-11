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

public class MainWindow {

	private JFrame frmFrequencyAnalysisV;

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
		frmFrequencyAnalysisV.setBounds(100, 100, 736, 562);
		frmFrequencyAnalysisV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFrequencyAnalysisV.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmFrequencyAnalysisV.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("main", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Input");
		lblNewLabel.setBounds(44, 35, 56, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cipher Text");
		lblNewLabel_1.setBounds(44, 75, 110, 16);
		panel.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Evaluate");
		btnNewButton.setBounds(44, 245, 97, 25);
		panel.add(btnNewButton);
//		txtr.setBounds(43, 104, 98, 98);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 104, 612, 124);
		panel.add(scrollPane);

		JTextArea txtr = new JTextArea();
		txtr.setRows(25);
		txtr.setColumns(25);
		
		scrollPane.setViewportView(txtr);
		// panel.add(txtr);
		txtr.setLineWrap(true);
		txtr.append("Pm ol ohk hufaopun jvumpkluaphs av zhf, ol dyval pa pu jpwoly, aoha pz, if zv johunpun aol vykly vm aol slaalyz vm aol hswohila, aoha uva h dvyk jvbsk il thkl vba.");

	}
}
