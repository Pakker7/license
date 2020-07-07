package com.test.psk.common.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;

@Controller
public class Command {

	private static Logger logger = Logger.getLogger(Command.class.getName());

	// @RequestMapping(value = "/command/shell", method = RequestMethod.GET)
	public void command() throws Exception {

		logger.warning("시작");
		this.shell("./LicenseModule/script/1_GetProducts.sh");
		this.shell("./LicenseModule/script/2_MakeLicense.sh");
		this.shell("/bin/sh -c cd ./LicenseModule; ls -al");
		logger.warning("끝");
	}

	/*
	 * 실행 전 체크 해야 할 것 tomcat에서 폴더를 만들거나 하기 때문에, LicenseModule의 소유권을 tomcat으로 꼭 바꿀 것
	 * drwxr-xr-x 5 tomcat tomcat 42 Sep 16 2019 LicenseModule
	 */

	// @RequestMapping(value = "/command/command", method = RequestMethod.GET)
//	public void shell(LicenseVO licenseVo) throws Exception {
//
//		String binSh = "/bin/sh";
//		String cdScript = "cd ./LicenseModule/script/";
//
//		String[] getProducts = { binSh, "-c", cdScript + "; ./1_GetProducts.sh" };
//		CommandTTest.commandExe(getProducts);
//
//		String[] makeLicense = { binSh, "-c", cdScript + "; ./2_MakeLicense.sh" };
//		String cmdExe = CommandTTest.commandPrint(makeLicense, "LICENSE_FILE");
//		String licenseFolderName = cmdExe.substring(cmdExe.indexOf("/script/") + 8, cmdExe.lastIndexOf("/"));
//
//		// 권한 추가
//		String grant = this.makeGrantStr(licenseVo);
//		String[] grantCmd = { binSh, "-c", cdScript + "; perl -pe '$.==26 and print " + grant + "' license.conf" };
//		CommandTTest.commandExe(grantCmd);
//
//		String[] issueExe = { binSh, "-c", cdScript + licenseFolderName + "; ./IssueExe" };
//		CommandTTest.commandExe(issueExe);
//
//		String[] makeTarFile = { binSh, "-c", cdScript + licenseFolderName + "; ./4_MakeTarFile.sh " };
//		CommandTTest.commandExe(makeTarFile);
//
//	}
//	private String makeGrantStr(LicenseVO licenseVo) {
//		return licenseVo.getLisencePolicyForCommandInput();
//	}

	// 명령어 실행 함수
	public static String commandExe(String[] cmd) throws Exception {
		Process process = Runtime.getRuntime().exec(cmd);
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader brError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		String line = "";
		String result = "";

		while ((line = br.readLine()) != null) {
			logger.warning(line);
			result += line;
		}

		while ((line = brError.readLine()) != null) {
			logger.warning("		[ERROR] > " + line);
			result += line;
		}

		br.close();

		return result;

	}

	// 명령어를 입력 했을 때 출력되는 내용 중 원하는 라인을 뽑아줌
	public static String commandPrint(String[] cmd, String whatYouWantStr) throws Exception {

		String result = "";

		Process process = Runtime.getRuntime().exec(cmd);
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader brError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		String line = "";

		while ((line = br.readLine()) != null) {
			logger.warning(line);
			if (line.contains(whatYouWantStr)) {
				result += line;
			}
		}

		while ((line = brError.readLine()) != null) {
			logger.warning("		[ERROR] > " + line);
		}

		br.close();

		return result;

	}

	public String shell(String command) throws Exception {

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

		return result;
	}

}
