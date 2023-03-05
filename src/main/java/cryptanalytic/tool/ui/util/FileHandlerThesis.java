package cryptanalytic.tool.ui.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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

	public static int validateCharacters(String fileName) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			StringBuilder stringBuilder = new StringBuilder();
			String line = null;
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			// delete the last new line separator
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);

			String content = stringBuilder.toString() + "";
			if (content.trim().length() == 0) {
				return 0;// File not content
			} else if (content.length() > 10000) {
				return 1;// File more than 10 Characters
			} else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return 3;
	}

}