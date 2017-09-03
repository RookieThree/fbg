<%@ page language="java" pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.appName}</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css1.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/pub.css">
<script type="text/javascript">
	function openwin(id){
		window.open('${pageContext.request.contextPath}/cart.do?action=buy&id='+id, 'win1','top=250px,left=400px,width=200px,height=150px');
	}
	
	function cartshow(){
		location.href='${pageContext.request.contextPath}/cart.do';
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
				��Ʒ���:
				<c:if test="${empty catalog }">����</c:if>
				<c:if test="${not empty catalog }">${catalog.title }</c:if>				
				<TABLE cellSpacing=1 cellPadding=1 width="100%" border=1
					bordercolor="black">
					<TBODY>
						<TR bgColor=#e1e1e1>
							<TD class=txt align=middle width="8%" height=25><FONT
								color=#000000>��ƷID</FONT></TD>
							<TD class=txt align=middle width="20%" height=25><FONT
								color=#000000>��Ʒ����</FONT></TD>
							<TD class=txt align=middle width="14%" height=25><FONT
								color=#000000>��Ʒ���</FONT></TD>
							<TD class=txt align=middle width="13%" height=25><FONT
								color=#000000>��λ����</FONT></TD>
							<TD class=txt align=middle width="15%" height=25><FONT
								color=#000000>����</FONT></TD>
							<TD class=txt align=middle width="10%" height=25><FONT
								color=#000000>����</FONT></TD>
						</TR>

						<c:if test="${not empty bookList}">
							<c:forEach var="book" items="${bookList}" varStatus="ss">
								<TR bgColor=#ffffff>
									<TD class=txt align=middle width="8%">${ss.count}</TD>
									<TD class=txt align=middle width="20%">${book.title}</TD>
									<TD class=txt align=middle width="20%">${book.catalog.title}</TD>
									<TD class=txt align=middle width="14%">${book.unit}</TD>
									<TD class=txt align=middle>${book.price}</TD>
									<TD align=middle><a href="javascript:void(0);" onclick="openwin(${book.id})"><image 
											src="${pageContext.request.contextPath}/images/cart.gif"
											style="border:0px"></image>
											</a></TD>
								</TR>

							</c:forEach>
							<c:if test="${(not empty pages) and (pages.maxPage gt 1) }">
								<tr>
									<td colspan=3 align=center><c:forEach var="kk"
											begin="${pages.beginPage }" end="${pages.endPage }">
											<c:if test="${pages.pageNum eq kk}">									
									[<font color="red">${kk }</font>]&nbsp;&nbsp;
								</c:if>
											<c:if test="${kk ne pages.pageNum }">
												<c:url var="u1" value="books.do">
													<c:param name="page" value="${kk }"></c:param>
													<c:param name="cid" value="${param.cid }"></c:param>
													<c:param name="keyword" value="${requestScope.keyword }"></c:param>
												</c:url>
								[<a href="${u1 }">${kk }</a>]&nbsp;&nbsp;
								</c:if>
										</c:forEach></td>
									<td colspan=3 align=center>ÿҳ:${pages.rowsPerpage}��
										ҳ��:${pages.pageNum }/${pages.maxPage }ҳ ����:${pages.rowsNum}��</td>
								</tr>
							</c:if>
						</c:if>
						<c:if test="${empty bookList}">
							<TR bgColor=#ffffff>
								<TD colspan="6"><h3 style="color:red;">û�ж�Ӧ����ʾ��Ϣ</h3></TD>
							</TR>
						</c:if>
				</table>

			</div>
		</div>

		<!-- ҳ�� -->
		<%@include file="/commons/foot.jsp"%>


	</div>
</body>
</html>

</body>
</html>