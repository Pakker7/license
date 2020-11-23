<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="wrap">
	<div class="contents">
		<div class="col col-xs-12" style="display:block;">
			<div class="box">
			
				<form id="form_create" name="form_create" action="<%=request.getContextPath()%>/get/updateSubmit" enctype="multipart/form-data" method="post" accept-charset="UTF-8">
				<input type="hidden" id="input_deleteFilename" class="form-control" name="deleteFileNames" value="">
				<input type="hidden" class="form-control" name="IDX" value="${board.IDX}">
				
				<div class="search-advance">
					<div class="form-group-inline">
                       	<h5 class="title-min">제목</h5>
					</div>
					<div class="form-group-inline">					
                       	<input class="form-control" name="TITLE" value="${board.TITLE }">
					</div>
					
					<div class="form-group-inline">
                       	<h5 class="title-min">본문1</h5>
                    </div>
					
                    <div class="form-group-inline">
                    	<textarea rows="5" cols="" name="CONTENTS" class="form-control">${board.CONTENTS }</textarea>
					</div>
					
					<div class="form-group-inline">
                       	<h5 class="title-min">본문2</h5>
                    </div>
					
                    <div class="form-group-inline">
                    	<textarea rows="5" cols="" name="CONTENTS_BASIC" class="form-control">${board.CONTENTS_BASIC }</textarea>
					</div>
					
					<div class="form-group-inline">
                       	<h5 class="title-min">첨부파일</h5>
					</div>
					<div class="form-group-inline">
                       	<button id="btn_fileAdd" type="button" class="btn btn-green">첨부파일 추가</button>
                       	<button id="btn_fileDel" type="button" class="btn btn-green">첨부파일 삭제</button>
					</div>
					<div class="form-group-inline">					
						<div class="bs3-success" id="div_file">
							<input id="file_1" type="file" name="file">
						</div>
					</div>
					<div class="form-group-inline">					
						<c:forEach var="filename" items="${files }" varStatus="status">
							<div id="div_${status.index }" onclick="file.deleteToPrepare('${filename }','${status.index }')" class="file">
								<span class="glyphicon glyphicon-file"></span>${filename }&nbsp;&nbsp;
								<span class="glyphicon glyphicon-remove" style="cursor:pointer;"></span>
							</div>
						</c:forEach>
					</div>
					<div class="form-group-inline">
						<input type="checkbox" id="isSecret" class="css-check pi-chk" name="SECRET"<c:if test="${board.SECRET eq true}">checked="checked"</c:if>>
						<label for="isSecret" class="check-label">비밀글로 지정</label>
					</div>
					
					<div class="top_btn">
						<button type="submit" class="btn btn-blue">일반 수정</button>
						<button type="button" onclick="transfer.javascript()" class="btn btn-blue">js수정</button>
						<button type="button" onclick="transfer.jquery()" class="btn btn-blue">jquery수정</button>
						<button type="button" class="btn btn-gray" onclick="location.href='<%=request.getContextPath()%>/get'">취소</button>
					</div>   

				</div>
				</form>
			</div>
    	</div>
	</div>
</div>

<!-- alert modal -->
<div class="modal fade" id="modal_delete" role="dialog">
	<div class="modal-dialog modal-lg" style="width:500px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">알림</h4>
			</div>
			<div class="modal-body">
				<div class="modal-box">
					<span id="label_alert">삭제 하시겠습니까?
					</span>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-red" onclick="file.delete();">삭제</button>
				<button type="button" class="btn btn-gray" data-dismiss="modal">취소</button> 
			</div>
		</div>
	</div>
</div>
<!-- //alert modal -->

<!-- 로딩바 -->
<div class="loader">
   <div class="imgframe"></div>
    <div class="loading-bg"><h5>로딩중...</h5></div>
</div>
<!-- //로딩바 -->
<script src="/resources/js/board/get/update.js"></script>
