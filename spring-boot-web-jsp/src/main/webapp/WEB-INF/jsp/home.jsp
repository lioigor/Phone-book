<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Main page</title>

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
<%-- 	<jsp:include page="introduction.jsp" />	 --%>

<body id="page1">
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
						<a href="${pageContext.request.contextPath}/home" id="logo">Phone
							book</a>
					</h1>
					<nav>
						<ul id="menu">
							<li id="menu_active"><a
								href="${pageContext.request.contextPath}/home"><span><span>Home</span></span></a></li>

							<li><a href="${pageContext.request.contextPath}/phonebook"><span><span>My
											phone book</span></span></a></li>
							<li class="nav4"><a
								href="${pageContext.request.contextPath}/login"><span><span>Log
											In</span></span></a></li>
							<li class="nav5"><a
								href="${pageContext.request.contextPath}/registration"><span><span>Sign
											Up</span></span></a></li>
						</ul>
					</nav>
				</div>
				<!-- CONTENT -->
				<div class="wrapper">
					<div class="text">
						<span class="tittle">Best<span>Phone book system</span></span>
						<p>
							Personal phone book for storing and</span><span>managing
								contacts.</span>
						</p>
						<a href="#" class="button1">More Info</a>
					</div>
					<div id="gallery">
						<ul id="myRoundabout">

							<li><img src="<c:url value="/images/img1.png"/>" alt=""></li>
						</ul>
					</div>
				</div>
			</header>

			<article id="content">
				<section class="col1"></section>
				<section class="col2">

					<h1>Задание “Телефонная книга”</h1>
					<br>
					<br> <br>Требования<br> Язык программирования: Java<br>
					Инструменты:<br> JDK (http://java.sun.com)<br> Spring
					(http://spring.io/)<br> Maven (https://maven.apache.org/)<br>
					Хранимые данные<br> Информация о пользователе в системе<br>
					Логин (только английские символы, не меньше 3х, без спецсимволов)<br>
					Пароль (минимум 5 символов)<br> ФИО (минимум 5 символов)<br>
					Хранимая информация (одна запись)<br> Фамилия (обязательный,
					минимум 4 символа)<br> Имя (обязательный, минимум 4 символа)<br>
					Отчество (обязательный, минимум 4 символа)<br> Телефон
					мобильный (обязательный)<br> Телефон домашний (не
					обязательный)<br> Адрес (не обязательный)<br> e-mail (не
					обязательный, общепринятая валидация)<br> Задание:<br>
					Реализовать Web проект “Телефонная книга”. Содержащий страницы:<br>
					авторизацию<br> Вход в систему (логин/пароль)<br>
					Регистрация<br> Выход из системы<br> Работа с хранимыми
					данными<br> Просмотр всех данных с возможностью фильтрации по
					имени/фамилии и номеру телефона (не полное соответствие).<br>
					Добавление/Редактирование/Удаление хранимых записей<br>
					Система доступна только авторизованным пользователям. Если
					пользователь не авторизован, при попытке открытия любой страницы
					его должно редиректить на страницу авторизации. На странице
					авторизации он может ввести логин и пароль для входа в систему или
					зарегистрироваться. При регистрации указываются поля: ФИО, логин и
					пароль.<br> У каждого авторизованного пользователя имеется
					своя телефонная книга, т.е. каждый пользователь видит только те
					записи, которые он создал. <br> Обратить внимание (обязательно
					к выполнению)<br> Админка для управления пользователями - не
					требуется.<br> Формат телефонов должен проверяется и быть
					валидным для Украины, пример: +380(66)1234567<br> Приложение
					обязательно должно содержать JUnit тесты, максимально плотно
					покрывающие код. Приветствуется использование Mockito.<br>
					Проект должен собираться средствами Maven<br> Для запуска
					использоваться SpringBoot<br> Исходный код должен быть выложен
					на GitHub/BitBucket<br> Все настройки приложения должны
					находится в properties файле, путь к которому должен передаваться в
					качестве аргументов JVM машине
					(-Dlardi.conf=/path/to/file.properties).<br> В
					конфигурационном файле указывается тип хранилища. Тип хранилища
					используется один раз при старте JVM (изменения в конфигурационном
					файле вступают в силу только при перезапуске JVM). Реализовать
					минимум два варианта хранилища: СУБД (MySQL) и файл-хранилище
					(XML/JSON/CSV на выбор). Настройки хранилища должны указываться в
					файле-конфигурации (хост и пользователь для СУБД или путь к файлу
					для файлового хранилища).<br> Для файлового хранилища - в
					случае отсутствия файла(ов) - его(их) необходимо создать. Для
					СУБД-хранилища в файле README.md должен находится SQL запрос для
					создания всех необходимых таблиц.<br> Проверка данных должна
					осуществляться на стороне сервера.<br> Приложение должно
					содержать четкое логическое разделение между представление, логикой
					и источником данных.<br>

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
									onfocus="if(this.value =='Type Your Email Here' ) this.value=''">
							</div>
							<a href="#" class="button"
								onclick="document.getElementById('ContactForm').submit()">Subscribe</a>
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
						<li><a
							href="https://www.linkedin.com/in/igor-likarenko-4b7ab1123/"><img
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
