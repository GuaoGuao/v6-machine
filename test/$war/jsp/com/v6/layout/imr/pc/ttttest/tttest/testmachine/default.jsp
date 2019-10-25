<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" buffer="none"%>
<%@ taglib uri="/tags/web" prefix="website"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>

<website:html>
	<website:head>
		<website:title>v6默认layout</website:title>
		<website:meta httpEquiv="Content-Type" content="text/html; charset=utf-8" />
		<!--[if lte IE 9]>
		<script type="text/javascript" src="/isrs/dist/vendor/datatables/respond.min.js" charset="utf-8"></script>
		<![endif]-->
		<!--[if lte IE 9]>
		<script type="text/javascript" src="/isrs/dist/vendor/datatables/html5shiv.min.js" charset="utf-8"></script>
		<![endif]-->
		<script type="text/javascript" src="/skin/js/jquery.js"></script>
		<script type="text/javascript" src="/skin/js/jquery.ui.core.js"></script>
		<script type="text/javascript" src="/skin/js/form.js"></script>
		<script type="text/javascript"src="/skin/js/tab/jquery.ui.tabs.js"></script>
		<script type="text/javascript" src="/isrs/dist/vendor/lodash_backbone.js"></script>
		<script type="text/javascript" src="/isrs/dist/common/main/main.js"></script>
		<link rel="stylesheet" type="text/css"
			  href="/skin/${cookie['skin'].value}/form.css" />
		<link rel="stylesheet" type="text/css"
			  href="/skin/${cookie['skin'].value}/jquery-ui.css" />

		<link rel="stylesheet" type="text/css"
			  href="/skin/${cookie['skin'].value}/jquery.editgrid.css" />
		<link rel="stylesheet" type="text/css"
			  href="/skin/${cookie['skin'].value}/jquery.flexigrid.css" />

		<script type="text/javascript" src="/skin/js/Tree/jquery.ztree.all-3.5.js"></script>
		<link href="/skin/skin2/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="/isrs/dist/pub/com-tree-utils/main.js"></script>
		<script type="text/javascript" src="/isrs/dist/pub/brand-tree-utils/main.js"></script>
		<script type="text/javascript" src="/isrs/dist/pub/emp-tree-utils/main.js"></script>
		<link href="/isrs/dist/pub/brand-tree-utils/main.css" rel="stylesheet" type="text/css">
		<script src="/isrs/dist/vendor/echarts/echarts.common.min.js"></script>

		<script type="text/javascript" src="/skin/js/slickgrid/slickgrid.js"></script>
		<link href="/skin/wuko/slickgrid/slickgrid.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/isrs/dist/common/ind_slickgrid/main-6aa3faa5c0aceac2.js"></script>
		<link href="/isrs/dist/common/ind_slickgrid/main-e9bad9163fec3fae.css" rel="stylesheet" type="text/css" />

	</website:head>
	<body sytle="margin:0 auto">
	<script type="text/javascript">


	</script>
	<div id="wrap">
		<div id="content">
			<website:screenHolder/>
		</div>
	</div>
	</body>
</website:html>
