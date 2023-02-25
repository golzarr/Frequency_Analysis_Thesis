package cryptanalytic.tool.python;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.exec.util.StringUtils;

public class PythonHandler {

	public String givenPythonScript_whenPythonProcessExecuted_thenSuccess(String param, String text, String key)
			throws ExecuteException, IOException {
		// Parameter 0 Encrytion
		// Parameter 1 Dencrytion
		String line = "py "
				+ resolvePythonScriptPath("caesarCipherThesis.py " + param + " " + key + " \"" + text + "\"");
		System.out.println("PythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess()");
		System.out.println(line);
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
//		System.out
//				.println("PythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess(exitCode)" + exitCode);
//		System.out.println("outputStream.toString().trim():" + outputStream.toString().trim());

		String separator = System.getProperty("line.separator");
		String output = "";
		try {
//			StringUtils.split(outputStream.toString().trim(), separator)[0];
			output = StringUtils.split(outputStream.toString().trim(), separator)[1];

		} catch (Exception e) {
			// TODO: handle exception
		}

//		return output;
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
//		System.out.println("PythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess()");
//		System.out.println(line);
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
//		System.out
//				.println("PythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess(exitCode)" + exitCode);

		return outputStream.toString().trim();
	}

	private String resolvePythonScriptPath(String filename) {
		File file = new File("src/main/resources/" + filename);
		return file.getAbsolutePath();
	}
}