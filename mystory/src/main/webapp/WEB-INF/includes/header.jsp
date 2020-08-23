<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>ALog HOME</title>
  <meta content="" name="descriptison">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${pageContext.request.contextPath}/resources/img/favicon.png" rel="icon">
  <link href="${pageContext.request.contextPath}/resources/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=https://fonts.googleapis.com/css?family=Inconsolata:400,500,600,700|Raleway:400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/aos/aos.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/line-awesome/css/line-awesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: MyPortfolio - v2.1.0
  * Template URL: https://bootstrapmade.com/myportfolio-bootstrap-portfolio-website-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  
</head>

<body>

 <!-- ======= Navbar ======= -->
<header>
	<div class="collapse navbar-collapse custom-navmenu" id="main-navbar">
		<div class="container py-2 py-md-5">
			<div class="row align-items-start">
				<div class="col-md-6 d-none d-md-block  mr-auto">
					<div class="tweet d-flex">
						<div><h3>About</h3>
							<p><em>${host.name} : <br>
							${host.introduct}<br>
							</em></p>
						</div>
					</div>
				</div>
				<div class="col-md-5 d-none d-md-block">
					<h3>Contract</h3>
					<p>instagram : ${host.instaID} <br>
						phone : ${host.phoneNo} <br>
						e-mail : ${host.email } <br>
					</p>
				</div>
			</div>
		</div>
	</div>

	<nav class="navbar navbar-light custom-navbar">
		<div class="container">
		 	<a class="navbar-brand" href="/">ALog 
		 	<small class="text-muted" style="font-size: 13pt;">: The Log based on Albums</small></a>
			<a href="#" class="burger" data-toggle="collapse" data-target="#main-navbar">
		    <span></span>
		  	</a>
		</div>
	</nav> 

<div class="container">
      <div class="row mb-5 align-items-center">
        <div class="col-md-12 col-lg-6 mb-4 mb-lg-0" data-aos="fade-up">
          <h3>Hey, It is Jammm's Life Log</h3>
          <p class="mb-0">Unconstrained Traveller &amp; Professional Developer</p>
        </div>
        <div class="col-md-12 col-lg-6 text-left text-lg-right" data-aos="fade-up" data-aos-delay="100">
          <div id="filters" class="filters" style="font-size:20pt">
              <a href="#" data-filter="*" class="active">(All)</a>
              <a href="#" data-filter="*">Album</a>
              <a href="#" >AMap</a>
            </div>
          </div>
        </div>
    </div>
</header>