<%
		//当前项目的内容路径
		String path=request.getContextPath();
		//当前项目在服务端的基准路径
		String basePath=request.getScheme()+"://"
						+request.getServerName()+
					":"+request.getServerPort()+path+"/";
%>
<!-- 定义所有html标签的基准访问路径  -->
<base href="<%=basePath %>"/>
<script src="js/jquery-3.2.1.js"></script>










