<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Sign Up</title>

<style type="text/css">
.block1 {
	width: 500px;
	background: #f2f2f2;
	padding: 5px;
	padding-right: 20px;
	border: solid 1px #c2c2c2;
	top: 40px;
	left: -70px; . letter { color : red;
	font-size: 150%;
}
}
</style>

<c:url value="/css/style3.css" var="css" />
<link href="${css}" rel="stylesheet" />
<c:url value="/css/reset.css" var="jstlCss1" />
<link href="${jstlCss1}" rel="stylesheet" />
<c:url value="/css/style2.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<c:url value="/css/layout.css" var="jstlCss2" />
<link href="${jstlCss2}" rel="stylesheet" />

<script type="text/javascript" src="<c:url value="/js/jquery-1.6.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/cufon-yui.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/cufon-replace.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/Didact_Gothic_400.font.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/Shanti_400.font.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/roundabout.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/roundabout_shapes.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/js/jquery.easing.1.2.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/script.js"/>"></script>

<link rel="icon" href="http://vladmaxi.net/favicon.ico"
	type="image/x-icon">
<link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico"
	type="image/x-icon">

</head>

<body>
<body id="page5">
	<div class="body1">
		<div class="main">

			<header>
				<div class="wrapper">
					<nav>
						<ul id="top_nav">
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<form id="logoutForm" method="POST"
									action="${pageContext.request.contextPath}/logout">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form>
								<font color="green">${pageContext.request.userPrincipal.name}</font> | <a
									onclick="document.forms['logoutForm'].submit()"><font
									color="red">Sign out</font></a>
							</c:if>
							<li><a href="${pageContext.request.contextPath}/login">Log
									In</a></li>
							<li><a
								href="${pageContext.request.contextPath}/registration">Sign
									Up</a></li>

						</ul>
					</nav>
					<span class="date">Monday, June 6, 2011 &nbsp; &nbsp; 17:19</span>
				</div>
				<div class="wrapper">
					<h1>
						<a href="${pageContext.request.contextPath}/home" id="logo">Air
							Foil</a>
					</h1>
					<nav>
						<ul id="menu">
						<li><a href="${pageContext.request.contextPath}/home"><span><span>Home</span></span></a></li>
						
						<li><a href="${pageContext.request.contextPath}/phonebook"><span><span>My phone book</span></span></a></li>
						<li class="nav4"><a href="${pageContext.request.contextPath}/login"><span><span>Log In</span></span></a></li>
						<li id="menu_active"class="nav5"><a href="${pageContext.request.contextPath}/registration"><span><span>Sign Up</span></span></a></li>
					</ul>
					</nav>
				</div>

			</header>
<!-- CONTENT -->
			<div align="center">

				<article id="content">

					<section class="col2">

						<form:form method="POST" modelAttribute="userForm"
							class="form-signin">

							<div class="block1">

								<h2>Create your phonebook account</h2>

								<fieldset id="inputs">
									<spring:bind path="username">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="username" class="form-control"
												placeholder="Username*" autofocus="true"></form:input>
											<br> <font color="red"><form:errors
													path="username"></form:errors><br></font>
										</div>
									</spring:bind>
									
									<spring:bind path="fullName">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="fullName" class="form-control"
												placeholder="FullName* (Ivanov Ivan Ivanovich)" autofocus="true"></form:input>
											<br> <font color="red"><form:errors
													path="fullName"></form:errors><br></font>
										</div>
									</spring:bind>

									<spring:bind path="password">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<form:input type="password" path="password"
												class="form-control" placeholder="Password*"></form:input>
											<br> <font color="red"><form:errors
													path="password"></form:errors><br></font>
										</div>
									</spring:bind>

									<spring:bind path="confirmPassword">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<form:input type="password" path="confirmPassword"
												class="form-control" placeholder="Confirm your password*"></form:input>
											<br> <font color="red"><form:errors
													path="confirmPassword"></form:errors><br></font>
										</div>
									</spring:bind>
													
								</fieldset>

								<fieldset id="actions">
									<input type="submit" id="submit" value="Submit"> <a
										href="${pageContext.request.contextPath}/login">Log In</a>
								</fieldset>
							</div>

						</form:form>
					</section>
				</article>

			</div>

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
								<input class="input" type="text" value="Type Your Email Here"
									onblur="if(this.value=='') this.value='Type Your Email Here'"
									onFocus="if(this.value =='Type Your Email Here' ) this.value=''">
							</div>
							<a href="#" class="button"
								onClick="document.getElementById('ContactForm').submit()">Subscribe</a>
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
						<span> Country:<br> City:<br> Email:
						</span> Ukraine<br> Kyiv<br> <a href="mailto:">lioigor22@gmail.com</a>
					</p>
				</section>
			</article>
		</div>
	</div>
	<div class="main">
		<!-- footer -->
		<footer>
			<colspan ="3" align="center" valign="middle" bgcolor="#000000">
			<span class="text2">Copyright &copy; Igor Likarenko<br> <!-- {%FOOTER_LINK} -->
		</footer>
		<!-- / footer -->
	</div>
	<script type="text/javascript">
		Cufon.now();
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#myRoundabout').roundabout({
				shape : 'square',
				minScale : 0.89, // tiny!
				maxScale : 1, // tiny!
				easing : 'easeOutExpo',
				clickToFocus : 'true',
				focusBearing : '0',
				duration : 800,
				reflect : true
			});
		});
	</script>
</body>
</html>
