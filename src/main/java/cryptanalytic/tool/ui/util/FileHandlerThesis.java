package cryptanalytic.tool.ui.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileHandlerThesis {

	public static boolean isFileEmpty(String fileName) {
		File file = new File(fileName);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));

			if (br.readLine() == null && file.length() == 0) {
//				System.out.println("No errors, and file empty");
				return false;
			} else {
//				System.out.println("File contains something");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}