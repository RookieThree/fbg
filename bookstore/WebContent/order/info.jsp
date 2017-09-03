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
		<!-- Ò³Í· -->
		<%@include file="/commons/head.jsp"%>
		<!-- Ö÷Ìå -->
		<div id="pagebody">
			<!-- ×ó²à -->
			<%@include file="/commons/left.jsp"%>
			<!-- ÓÒ²à -->
			<div id="mainbody">
				<BR>Çë¼ÇÂ¼ÄúµÄ¶©µ¥ºÅ
				<h3>${param.id }</h3>			
			</div>
			</div>
			<!-- Ò³½Å -->
			<%@include file="/commons/foot.jsp"%>
		</div>
</body>
</html>
