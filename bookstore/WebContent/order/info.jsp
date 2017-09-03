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
				<BR>���¼���Ķ�����
				<h3>${param.id }</h3>			
			</div>
			</div>
			<!-- ҳ�� -->
			<%@include file="/commons/foot.jsp"%>
		</div>
</body>
</html>
