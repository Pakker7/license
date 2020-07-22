// 발급 시 사용
var productIdx;
var licensePolicy;
var issueStart;
var issueEnd;

// 발급 이력 저장 시 사용
var licenseIdx;
var issuerIdx;
var customerIdx;
var issueReason;

var productName;

$(function() {

});

function isEmpty(str) {
	if (typeof str == "undefined" || str == null || str == "")
		return true;
	else
		return false;
}

var issue = {
	exe : function() {

		//ajax로 전송할 데이터 업데이트
		if (issue.dataValidationAndUpdate() === false) {
			return false;
		}

		$.ajax({
			url : '/issue/license.do',
			type : 'POST',
			data : {
				"product_idx" : productIdx,
				"license_policy" : licensePolicy,
				"issue_start" : issueStart,
				"issue_end" : issueEnd,
				"license_idx" : licenseIdx,
				"issuer_idx" : issuerIdx,
				"customer_idx" : customerIdx,
				"issue_reason" : issueReason,
				"productName" : productName
			},
			success : function(data) {
				console.log(data);
				console.log('success'); 
				location.href = "/issue/licenseFileDownload.do";
			},
			error : function() {
				alert("관리자에게 문의 하세요.");
			}
		});
	},
	dataValidationAndUpdate : function() {
		productIdx = $(":input:radio[name=product]:checked").val();
		productName = $(':input:radio[name=product]').data('name');
		// licensePolicy = $('#') ; //TODO 추후 적용
		issueStart = $('#issueStart').val();
		issueEnd = $('#issueEnd').val();

		issuerIdx = $('#issueIdx').val();
		customerIdx = $(":input:radio[name=customer]:checked").val();
		issueReason = $('#issueReason').val();

		if (isEmpty(productIdx)) {
			alert("제품 정보를 선택해 주세요");
			return false;
		}
		if (isEmpty(issueStart)) {
			alert("시작 날짜를 선택해 주세요");
			return false;
		}
		if (isEmpty(issueEnd)) {
			alert("끝나는 날짜를 선택해 주세요");
			return false;
		}
		if (isEmpty(issuerIdx)) {
			alert("발급자 정보가 없습니다");
			return false;
		}
		if (isEmpty(customerIdx)) {
			alert("고객 정보를 선택해 주세요");
			return false;
		}
		if (isEmpty(issueReason)) {
			alert("발급 사유를 작성해 주세요");
			return false;
		}

		return true;

	},
	licenseFileDownload : function() {
		location.href = '<%=request.getContextPath()%>/issue/licenseFileDownload.do';
	}

}
