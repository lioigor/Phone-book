<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>My phone book</title>

<style type="text/css">
.list2 {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.list2 td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.list2 th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.list .tg-4eph {
	background-color: #f9f9f9
}

.block1 {
	width: 200px;
	background: #f2f2f2;
	padding: 5px;
	padding-right: 20px;
	border: solid 1px #c2c2c2;
	top: 40px;
	left: -70px;
}
</style>

<meta charset="utf-8">

<link href="<c:url value="/css/style3.css" />" rel="stylesheet"
	type="text/css" />

<link href="<c:url value="/css/reset.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/style2.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/layout.css" />" rel="stylesheet"
	type="text/css" />

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
						<a href="${pageContext.request.contextPath}/home" id="logo">Phone book</a>
					</h1>
					<nav>
						<ul id="menu">
						<li><a href="${pageContext.request.contextPath}/home"><span><span>Home</span></span></a></li>
						
						<li id="menu_active" class="nav4"><a href="${pageContext.request.contextPath}/phonebook"><span><span>My phone book</span></span></a></li>
						<li class="nav4"><a href="${pageContext.request.contextPath}/login"><span><span>Log In</span></span></a></li>
						<li class="nav5"><a href="${pageContext.request.contextPath}/registration"><span><span>Sign Up</span></span></a></li>
					</ul>
					</nav>
				</div>
			</header>
			<!-- content -->
			<article id="content">
				<section class="col1">
					<div class="singlecol" align="center">
						<h2>Add new record into your phone book:</h2>

						<ul class="list2">


							<c:url var="addAction" value="/phonebook/add"></c:url>
							<c:url var="viewAction" value="/phonebooks"></c:url>

							<form:form action="${addAction}" commandName="phonebook">

								<table>
									<c:if test="${phonebook.id != 0}">
										<tr>
											<td><form:label path="id">
													<spring:message text="ID" />
												</form:label></td>
											<td><form:input path="id" readonly="true" size="8"
													disabled="true" /> <form:hidden path="id" /></td>
										</tr>
									</c:if>
									<tr>
										<td><form:label path="name">
												<spring:message text="Name*" />
											</form:label></td>
										<td><spring:bind path="name">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="name" class="form-control"
												autofocus="true"></form:input>											 
										</div>
									</spring:bind></td>
									<td style="background-color:#f2f2f2"><font color="red"><form:errors path="name"></form:errors></font></td>
									</tr>																		
									<tr>
										<td><form:label path="surName">
												<spring:message text="Surname*" />
											</form:label></td>
										<td><spring:bind path="surName">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="surName" class="form-control"
												autofocus="true"></form:input>											 
										</div>
									</spring:bind></td>
									<td style="background-color:#f2f2f2"><font color="red"><form:errors path="surName"></form:errors></font></td>
									</tr>	
										<tr>
										<td><form:label path="patronymic">
												<spring:message text="Patronymic*" />
											</form:label></td>
										<td><spring:bind path="patronymic">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="patronymic" class="form-control"
												autofocus="true"></form:input>											 
										</div>
									</spring:bind></td>
									<td style="background-color:#f2f2f2"><font color="red"><form:errors path="patronymic"></form:errors></font></td>
									</tr>	
									<tr>
										<td><form:label path="mobilePhone">
												<spring:message text="Mobile phone*" />
											</form:label></td>
										<td><spring:bind path="mobilePhone">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="mobilePhone" class="form-control"
												autofocus="true"></form:input>											 
										</div>
									</spring:bind></td>
									<td style="background-color:#f2f2f2"><font color="red"><form:errors path="mobilePhone"></form:errors></font></td>
									</tr>	
								<tr>
										<td><form:label path="homePhone">
												<spring:message text="Home phone" />
											</form:label></td>
										<td><spring:bind path="homePhone">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="homePhone" class="form-control"
												autofocus="true"></form:input>											 
										</div>
									</spring:bind></td>
									<td style="background-color:#f2f2f2"><font color="red"><form:errors path="homePhone"></form:errors></font></td>
									</tr>	
										<tr>
										<td><form:label path="address">
												<spring:message text="Address" />
											</form:label></td>
										<td><spring:bind path="address">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="address" class="form-control"
												autofocus="true"></form:input>											 
										</div>
									</spring:bind></td>
									<td style="background-color:#f2f2f2"><font color="red"><form:errors path="address"></form:errors></font></td>
									</tr>	
										<tr>
										<td><form:label path="email">
												<spring:message text="Email" />
											</form:label></td>
										<td><spring:bind path="email">
										<div class="form-group ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="email" class="form-control"
												autofocus="true"></form:input>											 
										</div>
									</spring:bind></td>
									<td style="background-color:#f2f2f2"><font color="red"><form:errors path="email"></form:errors></font></td>
									</tr>	
									<tr>
										<td colspan="2"><c:if test="${phonebook.id != 0}">
												<input type="submit"
													value="<spring:message text="Edit Record"/>" />
											</c:if> <c:if test="${phonebook.id == 0}">
												<input type="submit"
													value="<spring:message text="Add Record"/>" />
											</c:if></td>
									</tr>
								</table>
							</form:form>

							<div class="block1">
								<form:form action="${viewAction}" commandName="phonebook">
									<input type="submit"
										value="<spring:message text="View existing records"/>" />
								</form:form>
							</div>
							<br>

							<c:if test="${!empty listPhoneBooks}">
								<h2>Your phone book:</h2>
								<table class="tg">
									<tr>
										<th width="80">ID</th>
										<th width="120">Name</th>
										<th width="120">SurName</th>
										<th width="80">Patronymic</th>
										<th width="80">Mobile phone</th>
										<th width="80">Home phone</th>
										<th width="80">Address</th>
										<th width="80">Email</th>			
										<th width="60">[Edit]</th>
										<th width="60">[Delete]</th>
									</tr>
									<c:forEach items="${listPhoneBooks}" var="phonebook">
										<tr>
											<td>${phonebook.id}</td>
											<td>${phonebook.name}</td>
											<td>${phonebook.surName}</td>
											<td>${phonebook.patronymic}</td>
											<td>${phonebook.mobilePhone}</td>
											<td>${phonebook.homePhone}</td>
											<td>${phonebook.address}</td>
											<td>${phonebook.email}</td>										
											<td><a href="<c:url value='/edit/${phonebook.id}' />">Edit</a></td>
											<td><a href="<c:url value='/remove/${phonebook.id}' />">Delete</a></td>
										</tr>
									</c:forEach>
								</table>
							</c:if>
						</ul>
					</div>

				</section>
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
			<!-- / content -->
		</div>
	</div>
	<div class="main">
		<!-- footer -->
		<footer>
			<colspan ="3" align="center" valign="middle" bgcolor="#000000">
			<span class="text2">Copyright &copy; Igor Likarenko<br>
				</article> <!-- / content -->
	</div>
	</div>
	<script type="text/javascript">
		Cufon.now();
	</script>
</body>
</html>