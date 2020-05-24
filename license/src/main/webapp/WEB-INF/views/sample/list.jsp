<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="wrap">
	<div class="contents">
	<form action="<%=request.getContextPath()%>/get" method="get" accept-charset="UTF-8">
		<input type="hidden" name="pageNumber" id="PAGE_NUM_A" value="1"/>
		<div class="col col-xs-12" style="display:block;">
			<div class="box">
				<div class="in-all">
					<!-- table -->
					<div class="tab-pane fade in active">
					    <table class="table table-striped table-bordered mar-th report">
					        <colgroup>
					            <col width="55">
					            <col width="55">
					            <col width="*">
					            <col width="250">
					            <col width="250">
					            <col width="250">
					        </colgroup>
					        <thead>
					        <tr>
					            <th rowspan="1">
						            <input type="checkbox" id="all-chk" class="css-check pi-chk" >
									<label for="all-chk" class="check-label"></label>
								</th>
								<th colspan="1">no</th>
					          	<th colspan="1">제목</th>
					            <th rowspan="1">작성자</th>
					            <th rowspan="1">최초 등록일</th>
					            <th rowspan="1">최종 수정일</th>
					        </tr>
					        
					        </thead>
					        <tbody id="tbody_main">
					        
							<c:choose>
								<c:when test="${fn:length(boardList) == 0}">
									<tr>
										<td colspan="6">데이터가 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise> 
									<c:forEach var="board" items="${boardList}">
										<tr>
											<td class="text-center">
												<c:if test="${'root' eq id || board.WRITER eq id }">
													<input type="checkbox" id="${board.IDX }" class="css-check pi-chk" name="chkbox">
													<label for="${board.IDX }" class="check-label"></label>
												</c:if>
											</td>
										    <td class="text-center">${board.IDX }</td>
										    <td class="ellipsis">
										    	<c:if test="${board.SECRET eq true}">
										    		<span class="glyphicon glyphicon-lock"></span>
										    	</c:if>
										    	
										    	<c:if test="${'root' eq id}">
										    		<a href="<%=request.getContextPath()%>/get/select?idx=${board.IDX }" style="cursor:pointer;">
										    			${board.TITLE }
											    	</a>
										    	</c:if>
										    	
										    	<c:if test="${'root' ne id}">
											    	<c:if test="${board.SECRET eq false}">
												    	<a href="<%=request.getContextPath()%>/get/select?idx=${board.IDX }" style="cursor:pointer;">
												    		${board.TITLE }
												    	</a>
											    	</c:if>
											    	<c:if test="${board.SECRET eq true && board.WRITER ne id}">
												    	<a onclick="javascript:alert.secret()" style="cursor:pointer;">
												    		${board.TITLE }
												    	</a>
											    	</c:if>
										    	</c:if>
										    	
										    	<c:if test="${fn:length(board.files) != 0}">
										    	<c:forEach var="filename" items="${board.files }" varStatus="status">
													<c:if test="${'root' eq id}">
														<a class="file_download" onclick="javascript:file.download('${board.IDX }','${filename}')">
															<span class="glyphicon glyphicon-file" data-tooltip-text="${filename}"></span>&nbsp;&nbsp;
														</a>
													</c:if>
													<c:if test="${'root' ne id}">
														<c:if test="${board.SECRET eq false}">
															<a class="file_download" onclick="javascript:file.download('${board.IDX }','${filename}')">
																<span class="glyphicon glyphicon-file" data-tooltip-text="${filename}"></span>&nbsp;&nbsp;
															</a>
														</c:if>
														<c:if test="${board.SECRET eq true && board.WRITER ne id}">
															<span class="file_download" onclick="javascript:alert.secret()">
																<span class="glyphicon glyphicon-file" data-tooltip-text="${filename}"></span>&nbsp;&nbsp;
															</span>
												    	</c:if>
												    </c:if>
												</c:forEach>
										    	</c:if>
										    	
										    </td>
										    <td class="text-center">${board.WRITER }</td>
										    <td class="text-center"><fmt:formatDate value="${board.CREATE_DATE}" pattern="yyyy-MM-dd HH:mm"/></td>
										    <td class="text-center"><fmt:formatDate value="${board.UPDATE_DATE}" pattern="yyyy-MM-dd HH:mm"/></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
					        
					        </tbody>
					    </table>
					    <nav aria-label="Page navigation" class="text-center pagination-box">
					        <ul class="pagination" id="urlNavi">
					        </ul>
					    </nav>
					</div>
					<!-- // table -->

					
					<!-- search -->
					<div class="search">
						<div class="form-group-inline">
	                       	<input class="form-control" id="search" name="search" placeholder="제목 검색" value="<c:out value="${p.search}" escapeXml="true"/>" style="width:80%;">
							<span class="input-group-btn">
								<button class="btn btn-default" type="submit" style="height:30px;">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>
					</div>
					<!-- //search -->
					
					<!-- paging -->
					<div class="pagination">
						<c:import url="./pageNavigatorForGet.jsp" charEncoding="UTF-8">
							<c:param name="currentPage" value="${pageNavigator.currentPage }"/>
							<c:param name="startPage" value="${pageNavigator.startPage }"/>
							<c:param name="endPage" value="${pageNavigator.endPage }"/>
							<c:param name="totalPage" value="${pageNavigator.totalPage }"/> 
							<c:param name="pageNumId" value="#PAGE_NUM_A"/>
							<c:param name="searchs" value="word"/>
						</c:import>
					</div>
					<button type="submit" id="ask" style="display:none;"></button>
					<!-- //paging -->
										
					<c:if test="${id != null}">	
						<div class="bottom_btn">
							<button type="button" class="btn btn-blue" onclick="location.href='<%=request.getContextPath()%>/get/create'">등록</button>
							<button type="button" class="btn btn-red" data-target="#modal_delete" data-toggle="modal" onclick="init.delete();">삭제</button>
						</div>   
					</c:if>
				</div>
			</div>
    	</div>
    </form>
	</div>
</div>

<!-- alert modal -->
<div class="modal fade" id="modal_delete" role="dialog">
	<form action="<%=request.getContextPath()%>/get/delete" method="get" accept-charset="UTF-8">
	<input type="hidden" name="idx" value="">	

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
				<button type="submit" id="btn_delete" class="btn btn-red">삭제</button>
				<button type="button" class="btn btn-gray" data-dismiss="modal">취소</button> 
			</div>
		</div>
	</div>
	</form>
</div>
<!-- //alert modal -->

<script src="/resources/js/board/get/list.js"></script>
