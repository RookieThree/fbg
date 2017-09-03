<%@ page language="java" pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.appName}</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/css1.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/pub.css">
<script type="text/javascript">
	function sub() {
		document.getElementById("frmCart").submit();
	}
</script>

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
				<BR>1�������Ҫ�޸��뵽�����������С�
				<HR SIZE=1>

				<FORM name=frmservice
					action="${pageContext.request.contextPath }/order.do?action=insert"
					method=post>
					<TABLE cellSpacing=1 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR bgColor=#558bff>
								<TD class=txt align=middle width="8%" height=25><FONT
									color=#ffffff>���</FONT></TD>
								<TD class=txt align=middle width="20%" height=25><FONT
									color=#ffffff>��Ʒ����</FONT></TD>
								<TD class=txt align=middle width="14%" height=25><FONT
									color=#ffffff>��������</FONT></TD>
								<TD class=txt align=middle width="13%" height=25><FONT
									color=#ffffff>�۸�</FONT></TD>
								<TD class=txt align=middle width="15%" height=25><FONT
									color=#ffffff>�ܼ�</FONT></TD>
							</TR>
							<c:if test="${not empty sessionScope.mycart }">
								<c:forEach items="${sessionScope.mycart.allItems }" var="b">
									<TR bgColor=#e1e1e1>
										<TD class=txt align=middle width="8%">${b.book.id }</TD>
										<TD class=txt align=middle width="20%">${b.book.title}</TD>
										<TD class=txt align=middle width="14%">${b.num}</TD>
										<TD class=txt align=middle>${b.book.price }</TD>
										<TD class=txt align=middle>${b.allPrice }</TD>
									</TR>
						
								</c:forEach>
								</c:if>
									<TR bgColor=#e1e1e1>
										<TD class=txt align=middle width="8%"></TD>
										<TD class=txt align=middle width="20%"></TD>
										<TD class=txt align=middle width="14%"></TD>
										<TD class=txt align=middle>�ܼ�</TD>
										<TD class=txt align=middle>${sessionScope.mycart.allPrice }</TD>
									</TR>
							</TBODY>
					</TABLE>
					<HR SIZE=1>

					<TABLE width="100%" border=0>
						<TBODY>
							<TR>
								<TD class=txt align=right width="22%">�µ���<FONT
									color=#666666>��ʵ������</FONT></TD>
								<TD width="78%" height=25><INPUT size=28
									value="${sessionScope.user.realname }" name="realname"></TD>
							</TR>
							<TR>
								<TD class=txt align=right width="22%" height=25><FONT
									color=#666666>�����˵�ַ��</FONT></TD>
								<TD width="78%" height=25><INPUT size=58
									value=${sessionScope.user.addr } name="addr"></TD>
							</TR>
							<TR>
								<TD class=txt align=right width="22%" height=25><FONT
									color=#666666>�������ʱࣺ</FONT></TD>
								<TD width="78%" height=25><INPUT size=15
									value=${sessionScope.user.postcode } name="postcode"></TD>
							</TR>
							<TR>
								<TD class=txt align=right width="22%" height=25><FONT
									color=#666666>�����˵绰��</FONT></TD>
								<TD width="78%" height=25><INPUT size=58
									value=${sessionScope.user.tel } name="tel"></TD>
							</TR>
							<TR>
								<TD class=txt align=right width="22%" height=25><FONT
									color=#666666>������Email��</FONT></TD>
								<TD width="78%" height=25><INPUT size=58
									value=${sessionScope.user.email } name="email"></TD>
							</TR>
							<TR align=middle>
								<TD class=txt colSpan=2 height=25><INPUT type="submit"
									height=15 width=84 value="�ύ����" border=0 name=imageField2></TD>
							</TR>
						</TBODY>
					</TABLE>
				</FORM>
				<HR SIZE=1>
				<BR>
			</div>
		</div>
		<!-- ҳ�� -->
		<%@include file="/commons/foot.jsp"%>
	</div>
</body>
</html>
