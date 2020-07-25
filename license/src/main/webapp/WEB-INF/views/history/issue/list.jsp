<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">

	<div class="wrap">
		<div class="col col-xs-12">
			<div class="box">
				<div class="col-xs-12 group-box">
					<label class="section3">라이선스 발급 이력</label>
					<ul class="scroll-y2 group-list custom_scroll mCustomScrollbar _mCS_2">
						<li>
							<div class="mar-th box-outline">
		                        <div class="table-bd custom_scroll mar-n mCustomScrollbar _mCS_1 mCS_no_scrollbar">
		                        	<div id="mCSB_1" class="mCustomScrollBox mCS-dark-3 mCSB_vertical mCSB_inside" style="max-height: none;" tabindex="0"><div id="mCSB_1_container" class="mCSB_container mCS_y_hidden mCS_no_scrollbar_y" style="position:relative; top:0; left:0;" dir="ltr">
		                           <table class="table table-striped">
		                              <colgroup>
		                                 <col width="3%">
		                                 <col width="15%">
		                                 <col width="5%">
		                                 <col width="10%">
		                                 <col width="10%">
		                                 <col width="5%">
		                                 <col width="10%">
		                                 <col width="10%">
		                                 <col width="20%">
		                                 <col width="5%">
		                                 <col width="3%">
		                              </colgroup>
		                              <thead>
		                                 <tr>
		                                    <th class="table-bd-r">no</th>
		                                    <th class="table-bd-r">제품명</th>
		                                    <th class="table-bd-r">버전</th>
		                                    <th class="table-bd-r">기한</th>
		                                    <th class="table-bd-r">발급ID</th>
		                                    <th class="table-bd-r">발급자</th>
		                                    <th class="table-bd-r">고객사</th>
		                                    <th class="table-bd-r">고객사 대표자명</th>
		                                    <th class="table-bd-r">발급 사유</th>
		                                    <th class="table-bd-r">발급 날짜</th>
		                                    <th class="table-bd-r">상세보기</th>
		                                 </tr>
		                              </thead>
		                              <tbody>
		                                 <c:choose>
											<c:when test="${fn:length(history) == 0}">
												<tr>
													<td colspan="3">데이터가 없습니다.</td>
												</tr>
											</c:when>
											<c:otherwise> 
											<c:forEach var="history" items="${history}" varStatus="status">
												<tr>
												   <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt"><c:out value="${status.count}" /></span>
			                                          </span>
			                                       </td>
			                                       <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt">${history.product_name }</span>
			                                          </span>
			                                       </td>
			                                       <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt">${history.version }</span>
			                                          </span>
			                                       </td>
													<td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt">${history.issue_start } ~ ${history.issue_end }</span>
			                                          </span>
			                                       </td>
			                                       <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt">${history.id }</span>
			                                          </span>
			                                       </td>
			                                       <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt">${history.issuer_name }</span>
			                                          </span>
			                                       </td>
			                                       <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt">${history.company_name }</span>
			                                          </span>
			                                       </td>
			                                       <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt">${history.customer_name }</span>
			                                          </span>
			                                       </td>
			                                       <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt">${history.issue_reason }</span>
			                                          </span>
			                                       </td>
			                                       <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             <span class="group-user-cnt"><fmt:formatDate value="${history.issue_date }" pattern="yyyy-MM-dd"/></span>
			                                          </span>
			                                       </td>
			                                       <td class="text-center table-bd-r">
			                                          <span class="td-user-cnt" style="cursor:pointer;">
			                                             	<i class="fas fa-external-link-alt"></i>
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



			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
</script>

<script type="text/javascript" src="/resources/js/history/list.js"></script>

