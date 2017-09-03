<%@ page language="java" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.appName}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/css1.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/pub.css">
<style>
	.error{color:red;}
</style>
<script type="text/javascript"  
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript"  
	src="${pageContext.request.contextPath }/js/jquery.validate.min.js" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		$('#registerForm').validate({
			rules:{
				username:{required:true,rangelength:[6,20],remote:'${pageContext.request.contextPath}/user.do?action=check'}
			},
			messages:{
				username:{required:'必须填写',rangelength:'长度应该为6到20个字符',remote:'名称已经被占用'}
			}
		});
	});
</script>
</head>
<body>
	<div id="container">
		<!-- 页头 -->
		<%@include file="/commons/head.jsp"%>
		<!-- 主体 -->
		<div id="pagebody">
			<!-- 左侧 -->
			<%@include file="/commons/left.jsp"%>
			<!-- 右侧 -->
			<div id="mainbody">
				<TABLE cellSpacing=0 cellPadding=0 border=0>
					<TBODY>
						<TR>
							<TD vAlign=top><IMG src="${pageContext.request.contextPath }/images/login.gif" border=0></TD>
						</TR>
						<TR>
							<TD vAlign=top align=middle>
								<FORM id="registerForm"
									action="${pageContext.request.contextPath }/user.do?action=add"
									method=post>
									<TABLE cellSpacing=1 cellPadding=5 border=0>
										<TBODY>
											<TR>
												<td colspan="2">
													<span class="error">${requestScope.errors.username }</span>
												</td>
											</TR>
											<TR>
												<TD class=txt align=right>用户名:</TD>
												<TD><INPUT size=30 type="text" name="username"></TD>
											</TR>
											<td colspan="2">
													<span class="error">${requestScope.errors.password}</span>
												</td>
											<TR>
												<TD class=txt align=right>用户密码:</TD>
												<TD><INPUT type=password size=30 name="password"></TD>
											</TR>
											<td colspan="2">
													<span class="error">${requestScope.errors.repassword }</span>
												</td>
											<TR>
												<TD class=txt align=right>用户密码确认:</TD>
												<TD><INPUT type=password size=30 name="repassword"></TD>
											</TR>
											<td colspan="2">
													<span class="error">${requestScope.errors.realname }</span>
												</td>
											<TR>
												<TD class=txt align=right>真实姓名:</TD>
												<TD><INPUT size=30 name="realname"></TD>
											</TR>
											<TR>
												<TD class=txt vAlign=top align=right>性别:</TD>
												<TD><INPUT type=radio value="true" name="sex">男
													<INPUT type=radio value="false" name="sex">女</TD>
											</TR>
											<td colspan="2">
													<span class="error">${requestScope.errors.addr }</span>
												</td>
											<TR>
												<TD class=txt vAlign=top align=right>地址:</TD>
												<TD><INPUT size=30 name="addr"></TD>
											</TR>
											<TR>
												<TD class=txt align=right>邮编:</TD>
												<TD><INPUT size=30 name="postcode"></TD>
											</TR>
											<td colspan="2">
													<span class="error">${requestScope.errors.tel }</span>
												</td>
											<TR>
												<TD class=txt align=right>电话号码:</TD>
												<TD><INPUT size=30 name="tel"></TD>
											</TR>
											<td colspan="2">
													<span class="error">${requestScope.errors.email }</span>
												</td>
											<TR>
												<TD class=txt align=right>Email:</TD>
												<TD><INPUT size=30 name="email"></TD>
											</TR>
											<TR align=middle>
												<TD class=txt colSpan=2><BR> <INPUT type=submit
													value="提 交"> <INPUT type=reset value="重 写">
												</TD>
											</TR>
										</TBODY>
									</TABLE>
								</FORM> 
							</TD>
						</TR>
					</TBODY>
				</TABLE>
				<BR>
			</div>
		</div>

		<!-- 页脚 -->
		<%@include file="/commons/foot.jsp"%>
	</div>

</body>
</html>