<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>No access!</title>

<meta charset="utf-8">

<link href="<c:url value="/css/style3.css" />" rel="stylesheet" type="text/css" />

<link href="<c:url value="/css/reset.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/style2.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/layout.css" />" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<c:url value="/js/jquery-1.6.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/cufon-yui.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/cufon-replace.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/Didact_Gothic_400.font.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/Shanti_400.font.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/roundabout.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/roundabout_shapes.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/jquery.easing.1.2.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/script.js"/>" ></script>

<!--[if lt IE 9]>
	<script type="text/javascript" src="<c:url value="/js/html5.js"/>"></script>
	<style type="text/css">
		.bg {behavior:url(../../resources/js/PIE.htc)}
	</style>
<![endif]-->
<!--[if lt IE 7]>
	<div style=' clear: both; text-align:center; position: relative;'>
		<a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://www.theie6countdown.com/images/upgrade.jpg" border="0"  alt="" /></a>
	</div>
<![endif]-->
</head>
<body id="page2">
<div class="body1">
	<div class="main">
<!-- header -->
		<header>
			<div class="wrapper">
				<nav>
					<ul id="top_nav">					
		<c:if test="${pageContext.request.userPrincipal.name != null}">
        	<form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        	</form>
			<font color="green">${pageContext.request.userPrincipal.name}</font> | <a onclick="document.forms['logoutForm'].submit()"><font color="red">Sign out</font></a>
        	</c:if>
						<li><a href="${pageContext.request.contextPath}/login">Log In</a></li>
						<li><a href="${pageContext.request.contextPath}/registration">Sign Up</a></li>

					</ul>
				</nav>
				<span class="date">Monday, June 6, 2011  &nbsp; &nbsp; 17:19</span>
			</div>
			<div class="wrapper">
				<h1><a href="${pageContext.request.contextPath}/home" id="logo">Pro Soft</a></h1>
				<nav>
					<ul id="menu">
						<li><a href="${pageContext.request.contextPath}/home"><span><span>Home</span></span></a></li>
						<li id="menu_active"><a href="${pageContext.request.contextPath}/accessDenied?error"><span><span>Access denied</span></span></a></li>
						<li class="nav3"><a href="${pageContext.request.contextPath}/support"><span><span>Support</span></span></a></li>
						<li class="nav4"><a href="${pageContext.request.contextPath}/downloads"><span><span>Downloads</span></span></a></li>
						<li class="nav5"><a href="${pageContext.request.contextPath}/contacts"><span><span>Contacts</span></span></a></li>
					</ul>
				</nav>
			</div>
		</header>
<!-- content -->
		<article id="content">
		
		 <h3><font color="red">${username}</font> ${errorMsg}</h3>
		 
		</article>
	</div>
</div>
<div class="body2">
		<div class="main">
			<article id="content2">
				<section class="col1">
					<h3>Newsletter</h3>
					<form id="newsletter">
						<div>
						<div class="bg">
							<input class="input" type="text" value="Type Your Email Here"  onblur="if(this.value=='') this.value='Type Your Email Here'" onFocus="if(this.value =='Type Your Email Here' ) this.value=''">
						</div>
						<a href="#" class="button" onClick="document.getElementById('ContactForm').submit()">Subscribe</a>
					</div>
				</form>
        	</section>
			<section class="col_1">
				<h3>Why Us?</h3>
				<ul class="list1">
					<li><a href="#">It's simple - watch Guide</a></li>
					<li><a href="#">Many graphs, pictures</a></li>
					<li><a href="#">Quickly and easily</a></li>
				</ul>
        	</section>
			<section class="col_2">
				<h3>Follow Us</h3>
				<ul id="icons">

						<li><a href="https://www.facebook.com/igor.likarenko"><img
								src="<c:url value="/images/icon1.jpg"/>" alt="">Facebook</a></li>
						<li><a href="https://twitter.com/Igor_Likarenko"><img
								src="<c:url value="/images/icon2.jpg"/>" alt="">Twitter</a></li>
						<li><a href="https://www.linkedin.com/in/igor-likarenko-4b7ab1123/"><img
								src="<c:url value="/images/icon3.jpg"/>" alt="">LinkedIn</a></li>
					</ul>
        	</section>
			<section class="col_1">
				<h3>Address</h3>
				<p class="address">
					<span>
						Country:<br>
						City:<br>
						Email:
					</span>
					Ukraine<br>
					Kyiv<br>
					<a href="mailto:">lioigor22@gmail.com</a>
				</p>
       		</section>
		</article>
<!-- / content -->
	</div>
</div>
<div class="main">
<!-- footer -->
	<footer>
		<colspan="3" align="center" valign="middle" bgcolor="#000000"><span class="text2">Copyright &copy; Igor Likarenko<br>
		
		
		<!-- {%FOOTER_LINK} -->
	</footer>
<!-- / footer -->
</div>
<script type="text/javascript"> Cufon.now();</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#myRoundabout').roundabout({
			 shape: 'square',
        	 minScale: 0.89, // tiny!
        	 maxScale: 1, // tiny!
			 easing:'easeOutExpo',
			 clickToFocus:'true',
			 focusBearing:'0',
			 duration:800,
			 reflect:true
		});
	});
</script>
</body>
</html>