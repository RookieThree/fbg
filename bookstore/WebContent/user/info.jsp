<%@ page language="java" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.appName}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/css1.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/pub.css">
</head>
<body>
	<div id="container">
		<!-- ҳͷ -->
		<%@include file="/commons/head.jsp"%>
		<!-- ���� -->
		<div id="pagebody">
			<!-- ��� -->
			<%@include file="/commons/left.jsp"%>
			<!-- �Ҳ� -->
			<div id="mainbody">
				<TABLE cellSpacing=0 cellPadding=0 border=0>
					<TBODY>
						<TR>
							<TD vAlign=top><IMG src="${pageContext.request.contextPath }/images/login.gif" border=0></TD>
						</TR>
						<TR>
							<TD vAlign=top align=middle>
								<h3 style="color: red">ע�����û��ɹ�</h3>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
				<BR>
			</div>
		</div>

		<!-- ҳ�� -->
		<%@include file="/commons/foot.jsp"%>
	</div>

</body>
</html>