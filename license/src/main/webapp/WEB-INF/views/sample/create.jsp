<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">
	<div class="wrap">
	
		<div class="col col-xs-12" style="display:block;">
			<div class="box">
		        
				<form id="form_create" name="form_create" action="<%=request.getContextPath()%>/get/createSubmit" enctype="multipart/form-data" method="post" accept-charset="UTF-8">
				<input class="form-control" type="hidden" name="WRITER" value="">
				
				<div class="search-advance">
					<div class="form-group-inline">
                       	<h5 class="title-min">제목</h5>
					</div>
					<div class="form-group-inline">					
                       	<input class="form-control" name="TITLE">
					</div>
					
					<div class="form-group-inline">
                       	<h5 class="title-min">본문1</h5>
                    </div>
					
                    <div class="form-group-inline">
                    	<textarea rows="5" cols="" name="CONTENTS" class="form-control"></textarea>
					</div>
					
					<div class="form-group-inline">
                       	<h5 class="title-min">본문2</h5>
                    </div>
					
                    <div class="form-group-inline">
                    	<textarea rows="5" cols="" name="CONTENTS_BASIC" class="form-control"></textarea>
					</div>
					
					
					<div class="form-group-inline">
                       	<h5 class="title-min">첨부 파일</h5>
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
						<input type="checkbox" id="isSecret" class="css-check pi-chk" name="SECRET">
						<label for="isSecret" class="check-label">비밀글로 지정</label>
					</div>
					
					<div class="top_btn">
						<button type="submit" class="btn btn-blue">일반 등록</button>
						<button type="button" onclick="transfer.javascript()" class="btn btn-blue">js등록</button>
						<button type="button" onclick="transfer.jquery()" class="btn btn-blue">jquery등록</button>
						<button type="button" class="btn btn-gray" onclick="location.href='<%=request.getContextPath()%>/get'">취소</button>
					</div>   

				</div>
				</form>
			</div>
    	</div>
	</div>
</div>

