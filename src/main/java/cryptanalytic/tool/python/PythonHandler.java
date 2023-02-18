package cryptanalytic.tool.python;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;

public class PythonHandler {

	public String givenPythonScript_whenPythonProcessExecuted_thenSuccess() throws ExecuteException, IOException {
		String line = "py " + resolvePythonScriptPath("caesarCipher.py");
		CommandLine cmdLine = CommandLine.parse(line);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
		System.out
				.println("PythonHandler.givenPythonScript_whenPythonProcessExecuted_thenSuccess(exitCode)" + exitCode);
//		assertEquals("No errors should be detected", 0, exitCode);
		System.out.println("outputStream.toString().trim():" + outputStream.toString().trim());
		return outputStream.toString().trim();
	}

	private String resolvePythonScriptPath(String filename) {
		File file = new File("src/main/resources/" + filename);
		return file.getAbsolutePath();
	}

}
