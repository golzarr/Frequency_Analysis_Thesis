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
	public String givenPythonScript_whenPythonProcessExecuted_thenSuccess(String text, String model)
			throws ExecuteException, IOException {
		
		String line = "py " + resolvePythonScriptPath("frequencyAnalysisPlot.py" + " \"" + text + "\"");
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
	/**
	 * 
	 * @param text
	 * @param model
	 * @return
	 * @throws ExecuteException
	 * @throws IOException
	 */
	public String givenPythonScript_whenPythonProcessExecuted_thenSuccess(String text, int i)
			throws ExecuteException, IOException {

		String line = "py " + resolvePythonScriptPath("frequencyAnalysisLetterReport.py" + " \"" + text + "\"");
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

	private String resolvePythonScriptPath(String filename) {
		File file = new File("src/main/resources/" + filename);
		return file.getAbsolutePath();
	}
}