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

	@RequestMapping(value = "/commandTest", method = RequestMethod.GET)
	public ModelAndView testss() {
		ModelAndView mav = new ModelAndView();

		logger.warning("!!!!!!!!!!!!!!!!!");

		try {
			logger.warning("start");

			shellExe("/license/VerifyExe");
			commandExe(new String[] { "/bin/sh", "-c", "ls -al" });

			logger.warning("end");
		} catch (Exception e) {
			logger.warning(e.getMessage());
			e.printStackTrace();
		}

		mav.setViewName("history/distribute");

		return mav;
	}

	public String shellExe(String command) throws Exception {

		String result = "";
		Runtime rt = Runtime.getRuntime();
		String[] commands = { command };
		Process proc = rt.exec(commands);

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		String s = null;

		// 정상 출력 시
		while ((s = stdInput.readLine()) != null) {
			result += s;
			logger.warning("	1> " + s);
		}

		// 에러 문구 읽어오는 부분이지만, 쉘 실행 결과 출력 용도
		while ((s = stdError.readLine()) != null) {
			result += s;
			logger.warning("	2> " + s);
		}

		return "";
	}

	public String commandExe(String[] cmd) throws Exception {

		String result = "";

		Process process = Runtime.getRuntime().exec(cmd);
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = "";

		while ((line = br.readLine()) != null) {
			result += line;
			logger.warning(result);
		}

		br.close();

		return result;

	}

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
