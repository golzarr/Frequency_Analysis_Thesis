package cryptanalytic.tool.ui.util;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
public class JFileChooserHandler {

	private final static int MAX_FILES = 20;

	public static String maximunFiles(Component parent) {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		jfc.addChoosableFileFilter(filter);
		jfc.setMultiSelectionEnabled(true); // makes it so you can select multiple files!
		jfc.addPropertyChangeListener(e -> {
			File[] selectedFiles = jfc.getSelectedFiles();
			if (selectedFiles.length > MAX_FILES) {
				File[] selectedFilesNew = new File[MAX_FILES];
				for (int i = 0; i < selectedFilesNew.length; i++) {
					selectedFilesNew[i] = selectedFiles[i];
				}
				jfc.setSelectedFiles(selectedFilesNew);
				JOptionPane.showMessageDialog(jfc, "Only " + MAX_FILES + " selected files allowed.", "File chooser",
						JOptionPane.ERROR_MESSAGE);
			}
		});
		int returnValue = jfc.showOpenDialog(parent);
		String OutPutFiles = "";
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File[] files = jfc.getSelectedFiles();

			for (int i = 0; i < files.length; i++) {
				String strPath = files[i].getPath();
				if (i == 0) {
					OutPutFiles = strPath;
				} else {
					OutPutFiles = OutPutFiles + ";" + strPath;
				}
				System.out.println("FileChooser5.main(strPath):" + strPath);
			}
		}
		return OutPutFiles;
	}
}
