package com.test.psk.common.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommandTest {

	protected static Logger logger = Logger.getLogger(CommandTest.class.getName());

	@RequestMapping(value = "/command", method = RequestMethod.GET)
	public ModelAndView testss() {
		ModelAndView mav = new ModelAndView();

		logger.warning("!!!!!!!!!!!!!!!!!");

		try {
			logger.warning("start");
			testd("/license/VerifyExe");
			logger.warning("end");
		} catch (Exception e) {
			logger.warning(e.getMessage());
			e.printStackTrace();
		}

		mav.setViewName("history/distribute");

		return mav;
	}

	public String testd(String command) throws Exception {

		Runtime rt = Runtime.getRuntime();
		String[] commands = { "./VerifyExe" };
		Process proc = rt.exec(commands);

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

		// Read the output from the command
		logger.warning("Here is the standard output of the command:\n");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			logger.warning(s);
		}

		// Read any errors from the attempted command
		logger.warning("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
			logger.warning(s);
		}

		return "";
	}

//	public String testd() throws Exception {
//
//		String result = "";
//
//		logger.warning("go ls");
//
//		// String[] cmd = new String[] { "/bin/sh", "-c", "cd /root/LicenseModule/script/L_2_202006091591704279290/ ; ll" };
//		String[] cmd = new String[] { "/bin/sh", "-c",
//				"/root/LicenseModule/script/L_2_202006091591704279290/VerifyExe" };
//
//		logger.warning(cmd.toString());
//		logger.warning("");
//
//		Process process = Runtime.getRuntime().exec(cmd);
//		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
//		String line = "";
//
//		while ((line = br.readLine()) != null) {
//			result = line;
//			logger.warning(" ::: " + result);
//		}
//
//		br.close();
//
//		return result;
//
//	}

//	public String testd(String command) throws Exception {
//
//		Runtime runtime = Runtime.getRuntime();
//		Process process = runtime.exec(command);
//		InputStream is = process.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
//		String line;
//		logger.warning("===============================");
//		while ((line = br.readLine()) != null) {
//			logger.warning(line);
//			logger.warning(line);
//		}
//		logger.warning("===============================");
//
//		return line;
//
//	}

//	public void testd() throws Exception {
//
//		String line = "/root/LicenseModule/script/L_2_202006091591704279290/VerifyExe";
//		CommandLine command = CommandLine.parse(line);
//		try {
//			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//			DefaultExecutor executor = new DefaultExecutor();
//			PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
//
//			executor.setStreamHandler(streamHandler);
//			executor.execute(command);
//			logger.warning("result?");
//			logger.warning(outputStream.toString());
//		} catch (ExecuteException e) {
//			logger.warning(e.getMessage());
//			logger.warning(e.toString());
//		} catch (IOException e) {
//			logger.warning(e.getMessage());
//			logger.warning(e.toString());
//		}
//	}

}
