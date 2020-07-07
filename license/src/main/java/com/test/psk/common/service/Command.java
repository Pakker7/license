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

		logger.warning("����");
		this.shell("./LicenseModule/script/1_GetProducts.sh");
		this.shell("./LicenseModule/script/2_MakeLicense.sh");
		this.shell("/bin/sh -c cd ./LicenseModule; ls -al");
		logger.warning("��");
	}

	/*
	 * ���� �� üũ �ؾ� �� �� tomcat���� ������ ����ų� �ϱ� ������, LicenseModule�� �������� tomcat���� �� �ٲ� ��
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
//		// ���� �߰�
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

	// ��ɾ� ���� �Լ�
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

	// ��ɾ �Է� ���� �� ��µǴ� ���� �� ���ϴ� ������ �̾���
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

		// ���� ��� ��
		while ((s = stdInput.readLine()) != null) {
			result += s;
			logger.warning("	1> " + s);
		}

		// ���� ���� �о���� �κ�������, �� ���� ��� ��� �뵵
		while ((s = stdError.readLine()) != null) {
			result += s;
			logger.warning("	2> " + s);
		}

		return result;
	}

}
