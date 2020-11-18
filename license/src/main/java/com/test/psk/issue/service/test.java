package com.test.psk.issue.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class test {

	@Test
	public void tests() {
		String cmdExe = "[ERROR] > Generating RSA private key, 1024 bit long modulus"
				+ "[ERROR] > ................++++++" + "[ERROR] > .......................++++++"
				+ "[ERROR] > e is 65537 (0x10001)" + "[ERROR] > writing RSA key"
				+ "[ERROR] > Semicolon seems to be missing at -e line 1."
				+ "[ERROR] > syntax error at -e line 1, near \"01~\""
				+ "[ERROR] > Execution of -e aborted due to compilation errors." + "[ERROR] >" + "[ERROR] > [FUNC_main]"
				+ "[ERROR] > [DEBUG] CMD[sed -i '/SIGNATURE/,+5d' license.conf] ----03" + "[ERROR] >"
				+ "[ERROR] > [DEBUG] Signature[X6c/w499GxLZAkb4AzCB7LfN+ljZAFYIStdEGqiHA38I4Zw0DR/s6yG4HdvhhReN"
				+ "[ERROR] > zuJ7HGnP8q/r4Wmy5Tybw0lyv9oRro3kqwjDquZyiC/re4ZRo+N/WLTk1oNNFk84"
				+ "[ERROR] > O3rKPRnjD9ef0Q1/7nteK6P/o2mqL86NFPlyzGBmhTA=" + "[ERROR] > ] => Write(175) Sucess !!!";
		System.out.println(cmdExe.substring(cmdExe.indexOf("/script/") + 8, cmdExe.lastIndexOf("/")));
	}

	@Test
	public void dk(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String dFile = "Å×½ºÆ®.txt";
		String upDir = "D:/upload/";
		String path = upDir + File.separator + dFile;

		File file = new File(path);

		String userAgent = request.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("rv:11") > -1;
		String fileName = null;

		if (ie) {
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		} else {
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\";");

		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ServletOutputStream so = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(so);

		byte[] data = new byte[2048];
		int input = 0;
		while ((input = bis.read(data)) != -1) {
			bos.write(data, 0, input);
			bos.flush();
		}

		if (bos != null)
			bos.close();
		if (bis != null)
			bis.close();
		if (so != null)
			so.close();
		if (fis != null)
			fis.close();
	}
}
