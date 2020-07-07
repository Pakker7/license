package com.test.psk.issue.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.psk.common.service.Command;
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

	private static Logger logger = Logger.getLogger(LicenseServiceImpl.class.getName());
	private String licenseFolderName = null;
	private String binSh = "/bin/sh";
	private String cdScript = "cd ./LicenseModule/script/";

	public String issueLicense(LicenseVO licenseVo, IssueHistoryVO issueHistoryVo) throws Exception {
		this.licenseCommandExe(licenseVo);

		this.saveLicense(licenseVo);
		this.saveHistory(issueHistoryVo);

		return "";
	}

	private void licenseCommandExe(LicenseVO licenseVo) throws Exception {

		String[] getProducts = { binSh, "-c", cdScript + "; ./1_GetProducts.sh" };
		Command.commandExe(getProducts);

		String[] makeLicense = { binSh, "-c", cdScript + "; ./2_MakeLicense.sh" };
		String cmdExe = Command.commandPrint(makeLicense, "LICENSE_FILE");
		licenseFolderName = cmdExe.substring(cmdExe.indexOf("/script/") + 8, cmdExe.lastIndexOf("/"));

		// 권한 작성
		String grant = this.makeGrantStr(licenseVo);
		logger.warning(">>>>>>>>     " + grant);
		String[] grantCmd = { binSh, "-c",
				cdScript + "; perl -pe '$.==26 and print \"" + grant + "\"' ./license.conf" };
		Command.commandExe(grantCmd);

		String[] issueExe = { binSh, "-c", cdScript + licenseFolderName + "; ./IssueExe" };
		Command.commandExe(issueExe);

		String[] makeTarFile = { binSh, "-c", cdScript + licenseFolderName + "; ./4_MakeTarFile.sh " };
		Command.commandExe(makeTarFile);

	}

	private String makeGrantStr(LicenseVO licenseVo) {
		return licenseVo.getLisencePolicyForCommandInput();
	}

	// TODO db에 insert 해야함
	private int saveLicense(LicenseVO licenseVo) throws Exception {
		String[] getSignData = { binSh, "-c",
				cdScript + licenseFolderName + "; cat license.conf | grep -A 3 -B 1 -w \"[SIGNATURE]\"" };
		String signData = Command.commandExe(getSignData);
		licenseVo.setSign_data(signData);

		String[] getIssueKey = { binSh, "-c", cdScript + licenseFolderName + ";  sed -n '2,5p' public.key" };
		String issueKey = Command.commandExe(getIssueKey);
		licenseVo.setLicense_issue_key(issueKey);

		String[] getVerifyKey = { binSh, "-c", cdScript + licenseFolderName + ";  sed -n '2,5p' private.key" };
		String verifyKey = Command.commandExe(getVerifyKey);
		licenseVo.setLicense_verify_key(verifyKey);

		logger.warning(">>>>>>>>     " + licenseVo.toString());
		return mapper.insert(licenseVo);
	}

	// TODO db에 insert 해야함
	private void saveHistory(IssueHistoryVO issueHistoryVo) {
		issueHistoryService.insert(issueHistoryVo);
	}

}
