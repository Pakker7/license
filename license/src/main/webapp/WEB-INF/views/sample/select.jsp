<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="wrap">
	<div class="contents">
		<div class="col col-xs-12" style="display:block;">
			<div class="box">
				<form id="form_create" action="<%=request.getContextPath()%>/get/createSubmit" enctype="multipart/form-data" method="post" accept-charset="UTF-8">
				<input class="form-control" type="hidden" name="IDX" value="${board.IDX }">
				
				<div class="search-advance">
					<div class="form-group-inline">
                       	<h5 class="title-min">제목</h5>
                       	<span class="custom-txt4">${board.TITLE }</span>
					</div>
					
					<div class="form-group-inline">
                       	<h5 class="title-min">본문 1</h5>
                    </div>
                    <div class="form-group-inline context">
                       <span class="custom-txt4">${board.CONTENTS }</span>
					</div>
					<div class="form-group-inline">
                       	<h5 class="title-min">본문 2</h5>
                    </div>
                    <div class="form-group-inline context" >
                       <span class="custom-txt4">${board.CONTENTS_BASIC }</span>
					</div>

					<div class="form-group-inline">
                       	<h5 class="title-min">작성자</h5>
                       <span class="custom-txt4">${board.WRITER }</span>
					</div>

					<div class="form-group-inline">
                       	<h5 class="title-min">등록일자</h5>
                       <span class="custom-txt4"><fmt:formatDate value="${board.CREATE_DATE}" pattern="yyyy-MM-dd HH:mm"/></span>
					</div>
					
					<div class="form-group-inline">
                       	<h5 class="title-min">수정일자</h5>
                       <span class="custom-txt4"><fmt:formatDate value="${board.UPDATE_DATE}" pattern="yyyy-MM-dd HH:mm"/></span>
					</div>
										
					<div class="form-group-inline">
                       	<h5 class="title-min">첨부파일</h5>
						<c:forEach var="filename" items="${files }">
							<a class="file_download" onclick="javascript:file.download('${board.IDX }','${filename}')">
							<span class="glyphicon glyphicon-file"></span>${filename }&nbsp;&nbsp;</a>
						</c:forEach>
					</div>

					<div class="top_btn">
					
						<c:if test="${'root' eq id || board.WRITER eq id}">	
							<button type="button" class="btn btn-blue" onclick="location.href='<%=request.getContextPath()%>/get/update?idx=${board.IDX }'">수정</button>
							<button type="button" class="btn btn-red" data-target="#modal_delete" data-toggle="modal">삭제</button>
						</c:if>		
						<button type="button" class="btn btn-gray" onclick="location.href='<%=request.getContextPath()%>/get'">목록</button>
					</div>   

				</div>
				</form>
			</div>
    	</div>
	</div>
</div>


<!-- alert modal -->
<div class="modal fade" id="modal_delete" role="dialog">
	<form action="<%=request.getContextPath()%>/get/delete" method="get" accept-charset="UTF-8">
	<input type="hidden" name="idx" value="${board.IDX }">	

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
				<button type="submit" class="btn btn-red">삭제</button>
				<button type="button" class="btn btn-gray" data-dismiss="modal">취소</button> 
			</div>
		</div>
	</div>
	</form>
</div>
<!-- //alert modal -->

<script src="/resources/js/board/get/select.js"></script>

