package com.test.psk.issue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.psk.common.service.CommandTTest;
import com.test.psk.history.service.IssueHistoryServiceImpl;
import com.test.psk.history.vo.IssueHistoryVO;
import com.test.psk.issue.mapper.LicenseMapper;
import com.test.psk.issue.vo.LicenseVO;

@Service
public class LicenseServiceImpl {

	@Autowired
	private IssueHistoryServiceImpl issueHistoryService;
	@Autowired
	private LicenseMapper mapper;

	public String issueLicense(LicenseVO licenseVo, IssueHistoryVO issueHistoryVo) throws Exception {
		this.licenseCommandExe(licenseVo);
		this.saveLicense(licenseVo);
		this.saveHistory(issueHistoryVo);
		return "";
	}

	private void licenseCommandExe(LicenseVO licenseVo) throws Exception {

		String binSh = "/bin/sh";
		String cdScript = "cd ./LicenseModule/script/";

		String[] getProducts = { binSh, "-c", cdScript + "; ./1_GetProducts.sh" };
		CommandTTest.commandExe(getProducts);

		String[] makeLicense = { binSh, "-c", cdScript + "; ./2_MakeLicense.sh" };
		String cmdExe = CommandTTest.commandPrint(makeLicense, "LICENSE_FILE");
		String licenseFolderName = cmdExe.substring(cmdExe.indexOf("/script/") + 8, cmdExe.lastIndexOf("/"));

		// 권한 작성
		String grant = this.makeGrantStr(licenseVo);
		String[] grantCmd = { binSh, "-c", cdScript + "; perl -pe '$.==26 and print " + grant + "' license.conf" };
		CommandTTest.commandExe(grantCmd);

		String[] issueExe = { binSh, "-c", cdScript + licenseFolderName + "; ./IssueExe" };
		CommandTTest.commandExe(issueExe);

		String[] makeTarFile = { binSh, "-c", cdScript + licenseFolderName + "; ./4_MakeTarFile.sh " };
		CommandTTest.commandExe(makeTarFile);

	}

	private String makeGrantStr(LicenseVO licenseVo) {
		return licenseVo.getLisencePolicyForCommandInput();
	}

	// TODO db에 insert 해야함
	private int saveLicense(LicenseVO licenseVo) {
		return mapper.insert(licenseVo);
	}

	// TODO db에 insert 해야함
	private void saveHistory(IssueHistoryVO issueHistoryVo) {
		issueHistoryService.insert(issueHistoryVo);
	}

}
