<%@ page language="java" pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
<!--
$(function(){
	$('#img1').attr('src','${pageContext.request.contextPath}/pic.do?q='+Math.random());	
	document.getElementById("url").value=location.href;
});
//-->
</script>

<div id="sidebar">
	<TABLE cellSpacing=0 cellPadding=0 width=152 border=0>
		<TBODY>
			<TR>
				<TD>
					<TABLE cellSpacing=0 cellPadding=0 width=152 border=0>
						<TBODY>
							<TR>
								<TD colSpan=3><IMG
									src="${pageContext.request.contextPath}/images/user_info_top.gif"
									border=0></TD>
							</TR>
							<TR>
								<TD bgColor=#cccccc><IMG height=1 alt=""
									src="${pageContext.request.contextPath}/images/dot.gif" width=1
									border=0></TD>
								<TD class=ko align=middle width=150><SCRIPT
										language=JavaScript>
								<!--
									function winGetPWD(url) {
										window
												.open(
														url,
														"getpwd",
														"top=100,left=100,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no, status=no,width=240,height=150");
									}
								//-->
								</SCRIPT>
									<c:if test="${empty sessionScope.user}">
									<FORM id="f1" 
										action="${pageContext.request.contextPath }/user.do?action=login" method=post>
										<input type="hidden" name="url" id="url"/>
										<TABLE cellSpacing=3 cellPadding=0 border=0>
											<TBODY>
												<TR>
													<TD colspan="2">
														<span>${sessionScope.errors.username }</span>
													</TD>
												</TR>
												<TR>
													<TD>用户名:</TD>
													<TD><INPUT size=10 name="username" style="width: 80px"></TD>
												</TR>
												<TR>
													<TD colspan="2">
														<span>${sessionScope.errors.password }</span>
													</TD>
												</TR>
												<TR>
													<TD>密码:</TD>
													<TD><INPUT type=password size=10 name="password"
														style="width: 80px"></TD>
												</TR>
												<TR>
													<TD>验证码:</TD>
													<TD><INPUT size=10 name=checkcode style="width: 80px"></TD>
												</TR>
												<TR>
													<TD align=middle colSpan=2><IMG
														id="img1" /></TD>
												</TR>
												<TR></TR>
												<TR>
													<TD align=middle colSpan=2><INPUT type=submit value=登录>&nbsp;&nbsp;<INPUT
														onClick="javascript:window.location.href='${pageContext.request.contextPath}/user.do?action=toadd'"
														type=button value=注册><BR></TD>
												</TR>
												<TR>
													<TD class=ko align=middle colSpan=2></TD>
												</TR>
												<c:remove var="errors" scope="session"/>
											</TBODY>
										</TABLE>
									</FORM>
									</c:if>
									
		<c:if test="${not empty sessionScope.user}">							 
		  <table>
		    <tr>
		  	  <td align=center><font color="#000000">
			  ${sessionScope.user.realname }
			  <c:if test="${true==sessionScope.user.sex }">先生</c:if>
			  <c:if test="${true!=sessionScope.user.sex }">女士</c:if>
			  ,<br>欢迎访问电子商城 ！
			  </font></td>
		    </tr>
		    <tr>
		      <td align=center class="ko" ><!--<a href="userinfo.do?act=selectoneuser&num=1&uname=shopuser" style="text-decoration:underline; color:#0000FF">&gt;&gt;查看/修改个人信息</a>--></td>
		      
			</tr>
			<tr><td align=center class="ko" ><a href="javascript:logout('userinfo.do?act=logout')" style="text-decoration:underline; color:#0000FF">&gt;&gt;注销</a></td></tr>
		  </table>
		</c:if>				
									
									
									
									
									</TD>
								<TD bgColor=#cccccc><IMG height=1
									src="${pageContext.request.contextPath}/images/dot.gif" width=1
									border=0></TD>
							</TR>
							<TR>
								<TD colSpan=3><IMG
									src="${pageContext.request.contextPath}/images/user_info_bottom.gif"
									border=0></TD>
							</TR>
						</TBODY>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=152 border=0>
						<TBODY>
							<TR>
								<TD height=5><IMG height=5
									src="${pageContext.request.contextPath}/images/dot.gif" width=1
									border=0></TD>
							</TR>
						</TBODY>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=152 border=0>
						<TBODY>
							<TR>
								<TD colSpan=3><IMG
									src="${pageContext.request.contextPath}/images/left_search_top.gif"
									border=0></TD>
							</TR>
							<TR>
								<TD bgColor=#cccccc><IMG height=1
									src="${pageContext.request.contextPath}/images/dot.gif" width=1
									border=0></TD>
								<TD class=ko align=middle width=150>
									<FORM class=v9 action="${pageContext.request.contextPath }/books.do" method=post>
										<TABLE cellSpacing=0 cellPadding=0 border=0>
											<TBODY>
												<TR>
													<TD colSpan=2><INPUT style="WIDTH: 130px" name="keyword" value="${requestScope.keyword }"></TD>
												</TR>
												<TR>
													<TD><SELECT class=v9 style="WIDTH: 110px"
														name="cid">
															<OPTION value="">所有</OPTION>
															<c:if test="${not empty catalogList}">
																<c:forEach var="c" items="${catalogList}">
																	<OPTION
																	<c:if test="${(not empty catalog) and (catalog.id==c.id)}">
																	 selected="selected"
																	</c:if>
																	 value="${c.id }">${c.title }</OPTION>
																</c:forEach>
															</c:if>

													</SELECT></TD>
													<TD><input type="submit" value="GO" /></TD>
												</TR>
											</TBODY>
										</TABLE>
									</FORM>
								</TD>
								<TD bgColor=#cccccc><IMG height=1
									src="${pageContext.request.contextPath}/images/dot.gif" width=1
									border=0></TD>
							</TR>
							<TR>
								<TD colSpan=3><IMG
									src="${pageContext.request.contextPath}/images/user_info_bottom.gif"
									border=0></TD>
							</TR>
						</TBODY>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=152 border=0>
						<TBODY>
							<TR>
								<TD height=5><IMG height=5
									src="${pageContext.request.contextPath}/images/dot.gif" width=1
									border=0></TD>
							</TR>
						</TBODY>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=152 border=0>
						<TBODY>
							<TR>
								<TD colSpan=3><IMG
									src="${pageContext.request.contextPath}/images/left_product_top.gif"
									border=0></TD>
							</TR>
							<TR>
								<TD bgColor=#cccccc><IMG height=1
									src="${pageContext.request.contextPath}/images/dot.gif" width=1
									border=0></TD>
								<TD class=ko align=middle width=150>
									<TABLE width=140>
										<TBODY>
											<TR>
												<TD class=txt><A
													href="${pageContext.request.contextPath}/books.do"><IMG
														alt=""
														src="${pageContext.request.contextPath}/images/add.gif"
														align=left vspace=4 border=0>所有图书</A><BR> <c:if
														test="${not empty catalogList}">
														<c:forEach var="catalog" items="${catalogList}">
															<A href="${pageContext.request.contextPath}/books.do?cid=${catalog.id}"> <IMG
																alt=""
																src="${pageContext.request.contextPath}/images/add.gif"
																align=left vspace=4 border=0>${catalog.title}</A>
															<BR>
														</c:forEach>
													</c:if></TD>
											</TR>
										</TBODY>
									</TABLE>
								</TD>
								<TD bgColor=#cccccc><IMG height=1
									src="${pageContext.request.contextPath}/images/dot.gif" width=1
									border=0></TD>
							</TR>
							<TR>
								<TD colSpan=3><IMG
									src="${pageContext.request.contextPath}/images/user_info_bottom.gif"
									border=0></TD>
							</TR>
						</TBODY>
					</TABLE>
					<TABLE cellSpacing=0 cellPadding=0 width=152 border=0>
						<TBODY>
							<TR>
								<TD height=5><IMG height=5
									src="${pageContext.request.contextPath}/images/dot.gif" width=1
									border=0></TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	&nbsp;&nbsp; 当前在线认识：50 <br />
	<c:if test="${not empty cookie.lastTime.value }">
	上次访问时间为:<br />
	${cookie.lastTime.value}
	</c:if>
</div>