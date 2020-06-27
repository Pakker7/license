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

var jsonData;

$(function() {	

});

function isEmpty(str){
    if(typeof str == "undefined" || str == null || str == "")
        return true;
    else
        return false;
}

var issue = {
	exe : function(){
		
		//ajax로 전송할 데이터 업데이트
		if(issue.dataValidationAndUpdate() === false){
			return false;
		}
		
		 $.ajax({
	            url:'/issue/license.do',
	            type:'POST',
	            data :  {
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
	            success: function(data){
	            	
	            	
	            	console.log('ajax success');
	            	
	            	//issue.licenseFileDownload();
	            },
	            error : function(){
	            	alert("관리자에게 문의 하세요.");
	            }
		 });
	},
	dataValidationAndUpdate : function(){
		 productIdx = $(":input:radio[name=product]:checked").val();
		 // licensePolicy = $('#') ; //TODO 추후 적용
		 issueStart = document.getElementById("issueStart").value; 
		 issueEnd = document.getElementById("issueEnd").value;
		 
		 issuerIdx = $('#issueIdx').val();
		 customerIdx = $(":input:radio[name=customer]:checked").val();
		 issueReason = $('#issueReason').val();
	
		 if(isEmpty(productIdx)){
			console.log("productIdx");
			return false;
		}
		if(isEmpty(issueStart)){
			console.log("issueStart");
			return false;
		}
		if(isEmpty(issueEnd)){
			console.log("issueEnd");
			return false;
		}
		if(isEmpty(issuerIdx)){
			console.log("issuerIdx");
			return false;
		}
		if(isEmpty(customerIdx)){
			console.log("customerIdx");
			return false;
		}
		if(isEmpty(issueReason)){
			console.log("issueReason");
			return false;
		}

		return true;
			
	},
	licenseFileDownload : function(){
		location.href='<%=request.getContextPath()%>/issue/licenseFileDownload.do';
	}

}
