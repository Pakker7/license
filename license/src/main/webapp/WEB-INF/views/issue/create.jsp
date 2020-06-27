<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">

	<div class="wrap">
		<div class="col col-xs-12">
			<div class="box">
				<div class="col-xs-5 group-box">
					<label class="section">제품 정보 선택</label>
					<ul class="scroll-y2 group-list custom_scroll mCustomScrollbar _mCS_2">
						<li>
							<div class="mar-th box-outline">
		                        <div class="table-bd custom_scroll mar-n mCustomScrollbar _mCS_1 mCS_no_scrollbar">
		                        	<div id="mCSB_1" class="mCustomScrollBox mCS-dark-3 mCSB_vertical mCSB_inside" style="max-height: none;" tabindex="0"><div id="mCSB_1_container" class="mCSB_container mCS_y_hidden mCS_no_scrollbar_y" style="position:relative; top:0; left:0;" dir="ltr">
		                           <table class="table table-striped">
		                              <colgroup>
		                                 <col width="50%">
		                                 <col width="30%">
		                                 <col width="20%">
		                              </colgroup>
		                              <thead>
		                                 <tr>
		                                    <th class="table-bd-r">제품명</th>
		                                    <th class="table-bd-r">버전</th>
		                                    <th>출시일</th>
		                                 </tr>
		                              </thead>
		                              <tbody>
		                                 <c:choose>
											<c:when test="${fn:length(products) == 0}">
												<tr>
													<td colspan="3">데이터가 없습니다.</td>
												</tr>
											</c:when>
											<c:otherwise> 
											<c:forEach var="product" items="${products}">
												<tr>
			                                       <td class="text-left table-bd-r">
			                                          <input type="radio" id="product_${product.idx }" name="product" class="css-radio check-group1" value="${product.idx }">
			                                          <label for="product_${product.idx }" class="radio-label mar-rm group-name">${product.name }</label>
			                                       </td>
			                                       <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt">${product.version }</span>
			                                          </span>
			                                       </td>
			                                       <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt"><fmt:formatDate value="${product.launch_date }" pattern="yyyy-MM-dd"/></span>
			                                          </span>
			                                       </td>
			                                    </tr>
											</c:forEach>
											</c:otherwise> 
										</c:choose>
		                                    
		                                 
		                              </tbody>
		                           </table>
		                        </div><div id="mCSB_1_scrollbar_vertical" class="mCSB_scrollTools mCSB_1_scrollbar mCS-dark-3 mCSB_scrollTools_vertical" style="display: none;"><div class="mCSB_draggerContainer"><div id="mCSB_1_dragger_vertical" class="mCSB_dragger" style="position: absolute; min-height: 30px; height: 0px; top: 0px;"><div class="mCSB_dragger_bar" style="line-height: 30px;"></div></div><div class="mCSB_draggerRail"></div></div></div></div></div>
		                     </div>							
						</li>
						<!-- <li>
							<input type="radio" id="chkgroup2-1"	class="css-radio"> 
							<label for="chkgroup2-1" class="radio-label mar-tm">ipms.. </label>
						</li> -->
					</ul>
				</div>
				
				
				
				<div class="col-xs-4 group-box">
					<label class="section">라이선스 정보 입력</label>
					<ul class="scroll-y2 group-list custom_scroll mCustomScrollbar _mCS_2" style="height:300px;">
						<li>
							<div class="search-advance">
								<div class="form-group-inline">
			                       	<h5 class="title-min">기한</h5>
								</div>
								<div class="form-group-inline">					
			                       	<span class="inline-group date">
								         <input type="text" class="form-control date" id="issueStart" name="issueStart" maxlength="11"> ~
								         <input type="text" class="form-control date" id="issueEnd" name="issueEnd" maxlength="11">
								      </span>
								</div>
							</div>
						</li>
						<li>
							<div class="search-advance">
								<div class="form-group-inline">
			                       	<h5 class="title-min">발급사유</h5>
								</div>
								<div class="form-group-inline">					
			                       	<input id="issueReason" class="form-control">
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="col-xs-3 group-box">
					<label class="section">발급자 정보</label>
					<input type="hidden" id="issueIdx" value="1">
					<ul class="scroll-y2 group-list custom_scroll mCustomScrollbar _mCS_2" style="height:300px;">
						<li>
							<div class="search-advance">
								<div class="form-group-inline">
			                       	<h5 class="title-min">아이디</h5>
								</div>
								<div class="form-group-inline m">			
									<label class="m">kimjildong</label>		
								</div>
							</div>
						</li>
						<li>
							<div class="search-advance">
								<div class="form-group-inline">
			                       	<h5 class="title-min">이름</h5>
								</div>
								<div class="form-group-inline m">			
									<label class="m">김길동</label>		
								</div>
							</div>
						</li>
						<li>
							<div class="search-advance">
								<div class="form-group-inline">
			                       	<h5 class="title-min">부서</h5>
								</div>
								<div class="form-group-inline m">			
									<label class="m">기업부설연구소</label>		
								</div>
							</div>
						</li>
					</ul>
				</div>
				
				
				
				<div class="col-xs-4 group-box">
					<label class="section">고객 정보</label>
					<ul class="scroll-y2 group-list custom_scroll mCustomScrollbar _mCS_2" style="height:300px;">
						<li>
							<div class="mar-th box-outline">
		                        <div class="table-bd custom_scroll mar-n mCustomScrollbar _mCS_1 mCS_no_scrollbar"><div id="mCSB_1" class="mCustomScrollBox mCS-dark-3 mCSB_vertical mCSB_inside" style="max-height: none;" tabindex="0"><div id="mCSB_1_container" class="mCSB_container mCS_y_hidden mCS_no_scrollbar_y" style="position:relative; top:0; left:0;" dir="ltr">
		                           <table class="table table-striped">
		                              <colgroup>
		                                 <col width="50%">
		                                 <col width="30%">
		                                 <col width="20%">
		                              </colgroup>
		                              <thead>
		                                 <tr>
		                                    <th class="table-bd-r">회사 명</th>
		                                    <th >고객 명</th>
		                                 </tr>
		                              </thead>
		                              <tbody>
		                                 <c:choose>
											<c:when test="${fn:length(customers) == 0}">
												<tr>
													<td colspan="3">데이터가 없습니다.</td>
												</tr>
											</c:when>
											<c:otherwise> 
											<c:forEach var="customer" items="${customers}">
												<tr>
			                                       <td class="text-left table-bd-r">
			                                          <input type="radio" id="company_${customer.idx }" name="customer" class="css-radio check-group1" value="">
			                                          <label for="company_${customer.idx}" class="radio-label mar-rm group-name">${customer.company_name }</label>
			                                       </td>
			                                       <td class="text-left table-bd-r">
			                                       		<span class="td-user-cnt" style="cursor:pointer;">
			                                            	<span class="group-user-cnt">${customer.customer_name }</span>
			                                          	</span>
			                                       </td>
			                                    </tr>
			                                </c:forEach>
											</c:otherwise>
										</c:choose>
		                                 
		                              </tbody>
		                           </table>
		                        </div><div id="mCSB_1_scrollbar_vertical" class="mCSB_scrollTools mCSB_1_scrollbar mCS-dark-3 mCSB_scrollTools_vertical" style="display: none;"><div class="mCSB_draggerContainer"><div id="mCSB_1_dragger_vertical" class="mCSB_dragger" style="position: absolute; min-height: 30px; height: 0px; top: 0px;"><div class="mCSB_dragger_bar" style="line-height: 30px;"></div></div><div class="mCSB_draggerRail"></div></div></div></div></div>
		                     </div>
						</li>
						
					</ul>
				</div>
				<div class="bottom_btn">
					<button type="button" class="btn btn-blue" onclick="issue.exe();">발급</button>
					<button type="button" class="btn btn-gray" onclick="location.href='<%=request.getContextPath()%>/'">취소</button>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
</script>

<script type="text/javascript" src="/resources/js/issue/create.js"></script>

