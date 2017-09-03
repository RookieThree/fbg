<%@ page language="java" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.appName}</title>
<script language="Javascript">
	function closeinfo() {
		window.close();
	}
	
	function showcart(){
		window.opener.cartshow();
		window.close();
	}
</script>
<style>
td {
	font-size: 12px;
	color: #000000;
}
</style>
</head>
<body topmargin=0 leftmargin=0 marginwidth=0 marginheight=0
	bgcolor="#FFFFFF">
	<table cellpadding=10>
		<tr>
			<td><table cellspacing=0 cellpadding=0 border=0>
					<tr>
						<td colspan=3><img src="images/add_car.gif" border=0></td>
					</tr>
					<tr>
						<td width=1 bgcolor="#0033CC"><img src="images/dot.gif"
							border=0></td>
						<td width=158 align=center>
							<table cellpadding=3>
								<tr>
									<td>您订购的物品已经放入到购物车中，您可以点击<a
										href="javascript:void(0);" onclick="showcart();" >购物车</a>查看购物状态
									</td>
								</tr>
								<tr>
									<td align=center><a href="javascript:window.close();"><img
											src="images/continue_buy.gif" border=0></a></td>
								</tr>
							</table>
						</td>
						<td width=1 bgcolor="#0033CC"><img src="images/dot.gif"
							border=0></td>
					</tr>
					<tr>
						<td colspan=3 bgcolor="#0033CC"><img src="images/dot.gif"
							border=0></td>
					</tr>
				</table></td>
		</tr>
	</table>

	<SCRIPT LANGUAGE="JavaScript">
	<!--
		setTimeout("closeinfo()", 6000);
	//-->
	</SCRIPT>
</body>
</html>