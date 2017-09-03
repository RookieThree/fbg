<%@ page language="java" pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.appName}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/css1.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/pub.css">
<script type="text/javascript">

	function sub(){
		document.getElementById("frmCart").submit();
	}
</script>

</head>
<body>
	<div id="container">
		<!-- 页头 -->
		<%@include file="/commons/head.jsp" %>
		<!-- 主体 -->
		<div id="pagebody">
			<!-- 左侧 -->
			<%@include file="/commons/left.jsp" %>
			<!-- 右侧 -->
			<div id="mainbody">
				<BR>1、<FONT color=red>如果修改订购数量请务必点击“订购车更新”按钮，进行更新，若不点击“订购车更新”按钮，修改的数量视为无效。</FONT>
				<HR SIZE=1>

				<FORM id="frmCart" action="cart.do?action=modify" method=post>
					<TABLE cellSpacing=2 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR bgColor=#558bff>
								<TD class=txt align=middle width="8%" height=25><FONT
									color=#ffffff>序号</FONT></TD>
								<TD class=txt align=middle width="25%" height=25><FONT
									color=#ffffff>物品名称</FONT></TD>
								<TD class=txt align=middle width="23%" height=25><FONT
									color=#ffffff>订购数量</FONT></TD>
								<TD class=txt align=middle width="15%" height=25><FONT
									color=#ffffff>价格</FONT></TD>
								<TD class=txt align=middle width="14%" height=25><FONT
									color=#ffffff>总价</FONT></TD>
								<TD class=txt align=middle width="15%" height=25><FONT
									color=#ffffff>删除</FONT></TD>
							</TR>
							
							<c:if test="${(not empty sessionScope.mycart) and (not empty sessionScope.mycart.allItems) }">
								<c:forEach items="${mycart.allItems }" var="it" varStatus="ss">
							<TR bgColor=#e1e1e1>
								<TD class=txt align=middle width="8%" height=25>${ss.count }</TD>
								<TD class=txt align=middle width="25%" height=25>${it.book.title }</TD>
								<TD class=txt align=middle width="23%" height=25>
								<input type="hidden" value="${it.book.id }" name="ids"/>
								<INPUT size=12 value="${it.num }" name="nums"></TD>
								<TD class=txt align=middle width="15%" height=25>${it.book.price }</TD>
								<TD class=txt align=middle width="14%" height=25>${it.allPrice}</TD>
								<TD class=txt align=middle width="15%" height=25><A
									href="${pageContext.request.contextPath }/cart.do?action=remove&id=${it.book.id}">删除</A></TD>
							</TR>
								</c:forEach>
							
							
							
							<TR bgColor=#e1e1e1>
								<TD class=txt align=middle width="8%" height=25></TD>
								<TD class=txt align=middle width="25%" height=25></TD>
								<TD class=txt align=middle width="23%" height=25></TD>
								<TD class=txt align=middle width="15%" height=25>总计</TD>
								<TD class=txt align=middle width="14%" height=25>${mycart.allPrice }</TD>
								<TD class=txt align=middle width="15%" height=25></TD>
							</TR>
							</c:if>
							<TR bgColor=#e1e1e1>
								<TD class=txt align=middle colSpan=6 height=25>
									<a href="javascript:void(0);" onclick="sub();">订购车更新 </a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath }/cart.do?action=clear">清空购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath }/order.do?action=order">去服务台结算</a>
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</FORM>
				<HR SIZE=1>

				<CENTER></CENTER>
				<BR>

			</div>
		</div>

		<!-- 页脚 -->
		<%@include file="/commons/foot.jsp" %>
	</div>
</body>
</html>
