package com.test.psk.common.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;

@Controller
public class Command {

	private static Logger logger = Logger.getLogger(Command.class.getName());

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
}
