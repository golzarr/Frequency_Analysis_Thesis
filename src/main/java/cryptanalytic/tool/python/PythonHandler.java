package cryptanalytic.tool.python;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;

public class PythonHandler {

	public String givenPythonScript_whenPythonProcessExecuted_thenSuccess(String param, String text, String key)
			throws ExecuteException, IOException {
		// Parameter 0 Encrytion
		// Parameter 1 Dencrytion
		String line = "py "
				+ resolvePythonScriptPath("caesarCipherThesis.py " + param + " " + key + " \"" + text + "\"");
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		int exitCode = executor.execute(cmdLine);
		return outputStream.toString().trim();
	}

	/**
	 * @param text
	 * @return
	 * @throws ExecuteException
	 * @throws IOException
	 */
	public String givenPythonScript_whenPythonProcessExecuted_thenSuccess(String text)
			throws ExecuteException, IOException {

		String line = "py " + resolvePythonScriptPath("frequencyAnalysisCaesar.py" + " \"" + text + "\"");
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		int exitCode = executor.execute(cmdLine);
		return outputStream.toString().trim();
	}

	/**
	 * 
	 * @param text
	 * @param model
	 * @return
	 * @throws ExecuteException
	 * @throws IOException
	 */
	public String givenPythonScript_whenPythonProcessExecuted_thenSuccessPlotFADirectInput(String text, String alphabet)
			throws ExecuteException, IOException {

		String line = "py "
				+ resolvePythonScriptPath("frequencyAnalysisPlot.py" + " \"" + text + " \"" + " " + alphabet);
//		System.out.println("PythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess()");
//		System.out.println(line);
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
		return outputStream.toString().trim();
	}

	public String givenPythonScript_whenPythonProcessExecuted_thenSuccessPlotFAFile(String text, String alphabet)
			throws ExecuteException, IOException {

		String line = "py "
				+ resolvePythonScriptPath("frequencyAnalysisPlotFile.py" + " \"" + text + " \"" + " " + alphabet);
//		System.out.println("PythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess()");
		System.out.println(line);
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
		return outputStream.toString().trim();
	}

	/**
	 * 
	 * @param text
	 * @param model
	 * @return
	 * @throws ExecuteException
	 * @throws IOException
	 */
	public String givenPythonScript_whenPythonProcessExecuted_thenSuccessLetterFADirectInput(String text, int i)
			throws ExecuteException, IOException {

		String line = "py " + resolvePythonScriptPath("frequencyAnalysisLetterReport.py" + " \"" + text + "\"");
//		System.out.println("PythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess()");
		System.out.println(line);
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
//		return outputStream.toString().trim();
		String out = new String(outputStream.toByteArray(), "UTF-8");
		System.out.println(":P:P-->" + out);
		return out;
	}

	public String givenPythonScript_whenPythonProcessExecuted_thenSuccessLetterFAFile(String text, int i)
			throws ExecuteException, IOException {

		String line = "py " + resolvePythonScriptPath("frequencyAnalysisLetterReportFile.py" + " \"" + text + "\"");
//		System.out.println("PythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess()");
		System.out.println(line);
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
		String out = new String(outputStream.toByteArray(), "UTF-8");
		System.out.println("PythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccessLetterFAFile()" + out);
		return out;
//		return outputStream.toString().trim();
	}

	/**
	 * @param text
	 * @param key
	 * @param mode
	 * @return
	 * @throws ExecuteException
	 * @throws IOException
	 */
	public String givenPythonScript_whenPythonProcessExecuted_thenSuccessCaesarCipherWithKeywordDirectInput(String text,
			String key, String mode, String alphabet) throws ExecuteException, IOException {

		String line = "py " + resolvePythonScriptPath("caesarCipherWithKeyword.py " + " \"" + text + "\"" + " \"" + key
				+ "\"" + " \"" + mode + "\"" + " \"" + alphabet + "\"");

		System.out.println(line);
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
		String out = new String(outputStream.toByteArray(), "UTF-8");
		return out;
//		return outputStream.toString().trim();
	}
	
	
	public String givenPythonScript_whenPythonProcessExecuted_thenSuccessVigenereCipher(String text,
			String key, String mode, String alphabet) throws ExecuteException, IOException {

		String line = "py " + resolvePythonScriptPath("VigenereCipher.py " + " \"" + text + "\"" + " \"" + key
				+ "\"" + " \"" + mode + "\"" + " \"" + alphabet + "\"");

		System.out.println(line);
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
		String out = new String(outputStream.toByteArray(), "UTF-8");
		return out;
//		return outputStream.toString().trim();
	}
	
	
	
	
	
	

	private String resolvePythonScriptPath(String filename) {
		File file = new File("src/main/resources/" + filename);
		return file.getAbsolutePath();
	}

	public String givenPythonScript_whenPythonProcessExecuted_thenSuccessCipherKeywordFADirectInput(String text,
			String key, String mode, String alphabet) throws ExecuteException, IOException {

		//for now 
		mode = "1";
		alphabet = "0";
		String line = "py " + resolvePythonScriptPath("frequencyAnalysisSubstitutionCipherFA.py " + " \"" + text + "\""
				+ " \"" + mode + "\"" + " \"" + alphabet + "\"");

		System.out.println(line);
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
		String out = new String(outputStream.toByteArray(), "UTF-8");
		return out;
	}
}