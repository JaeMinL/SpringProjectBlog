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
            <div>
              <h3>About</h3>
              <p><em>${host.name} : <br>
               ${host.introduct}<br>
               </em></p>
            </div>
          </div>
        </div>
        <div class="col-md-5 d-none d-md-block">
          <h3>Contract</h3>
          <p>
          instagram : ${host.instaID} <br>
          phone : ${host.phoneNo} <br>
          e-mail : ${host.email } <br>
          </p>
        </div>
      </div>
    </div>
  </div>

  <nav class="navbar navbar-light custom-navbar">
    <div class="container">
      <a class="navbar-brand" href="/">ALog <small class="text-muted" style="font-size: 13pt;">: The Log based on Albums</small></a>

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
              <a href="#" data-filter=".web">Album</a>
              <a href="#" data-filter=".design">AMap</a>
            </div>
          </div>
        </div>
    </div>

</header>
  <main id="main">

    <!-- ======= Works Section ======= -->
      <!-- <div class="container">
        <div class="row mb-5 align-items-center">
          <div class="col-md-12 col-lg-6 mb-4 mb-lg-0" data-aos="fade-up">
            <h2>Hey, It is Jammm's Life Log</h2>
            <p class="mb-0">Unconstrained Traveller &amp; Professional Developer</p>
          </div>
          <div class="col-md-12 col-lg-6 text-left text-lg-right" data-aos="fade-up" data-aos-delay="100">
            <div id="filters" class="filters" style="font-size:20pt">
              <a href="#" data-filter="*" class="active">(All)</a>
              <a href="#" data-filter=".web">Album</a>
              <a href="#" data-filter=".design">AMap</a>
            </div>
          </div>
        </div>
        </div> -->
        
     <section class="section site-portfolio" style="padding:0 0 0 0;">
      <div class="container">
        
        <div class="row mb-3 align-items-center">
          <div class="col-md-12 col-lg-6 mb-5 mb-lg-0" data-aos="fade-up">
            <h3>2020 August <%--  <fmt:formatDate pattern="yyyy MMM" value="${pic.taken_dt}"/> --%> </h3>
            <!-- <p class="mb-0">Unconstrained Traveller &amp; Professional Developer</p> -->
          </div>
          <!-- <div class="col-md-12 col-lg-6 text-left text-lg-right" data-aos="fade-up" data-aos-delay="100">
          </div> -->
        </div>
           
        <div id="portfolio-grid" class="row no-gutter" data-aos="fade-up" data-aos-delay="200">
        
        <!-- <div class="row justify-content-center mb-4">
          <div class="col-5">
            <h3 class="h3 heading">My Clients</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>
          </div>
        </div>
        
        <div class="item web col-sm-6 col-md-4 col-lg-2 mb-4 shadow-sm">
          <div class="month-year">
                <h3>Boxed Water</h3>
                <span>Web</span>
              </div>
          </div> -->
   		<c:forEach var="pic" items="${list}">
	      	<div class="item web col-sm-6 col-md-4 col-lg-3 mb-4 shadow-sm">
            <a href="work-single.html" class="item-wrap fancybox">     
              <div class="work-info">
                <h3>///</h3>
                <span>///</span>
              </div>
              <div class="d-flex justify-content-start align-items-center" style="border-bottom: 0.6px solid #cbd3da">
	                <div class="btn-group">
	                  <!-- <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
	                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button> -->
	                </div>
	                <div class="text-muted" style="font-size:20px">
						<fmt:setLocale value="en_UK" scope="session"/>
						<fmt:formatDate pattern="dd E" value="${pic.taken_dt}"/>
					</div>
	          </div>
              <img class="img-fluid" src='${pageContext.request.contextPath}/resources/img/${pic.thumb_fl_nm}'/>
	          <div class="card-body" style="border-top: 0.6px solid #cbd3da">
	            <p class="card-title"><cite>${pic.title }</cite></p>
	            <p class="card-text">${pic.text }</p>
	          </div>
            </a>
          	</div>
	    </c:forEach>
	    
          <div class="item web col-sm-6 col-md-4 col-lg-3 mb-4 shadow-sm">
            <a href="work-single.html" class="item-wrap fancybox">     
              <div class="work-info">
                <h3>Boxed Water</h3>
                <span>Web</span>
              </div>
              <div class="d-flex justify-content-start align-items-center">
	               <div class="btn-group">
	                  <!-- <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
	                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button> -->
	               </div>
	               <big class="text-muted">11 WED </big>
	          </div>
              <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/img_1.jpg">
	          <div class="card-body">
	            <p class="card-title"><cite>title</cite></p>
	            <p class="card-text">This is a wider card with supporting text below the image. It is a document of the day.</p>
	              <!-- <div class="d-flex justify-content-between align-items-center">
	                <div class="btn-group">
	                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
	                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
	                </div>
	                <small class="text-muted">20.08.11 WED </small>
	              </div> -->
	            </div>
            </a>
          </div>
          
          <div class="item photography col-sm-6 col-md-4 col-lg-3 mb-4 shadow-sm">
            <a href="work-single.html" class="item-wrap fancybox">
              <div class="work-info">
                <h3>Build Indoo</h3>
                <span>Photography</span>
              </div>
              <div class="d-flex justify-content-start align-items-center">
	                <div class="btn-group">
	                  <!-- <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
	                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button> -->
	                </div>
	                <big class="text-muted">10 TUE </big>
	          </div>
              <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/img_2.jpg">
              <div class="card-body">
              		<p class="card-title"><cite>title</cite></p>
	              <p class="card-text">This is a wider card with supporting text below the image. It is a document of the day.</p>
	          
	            </div>
            </a>
          </div>
          <div class="item branding col-sm-6 col-md-4 col-lg-3 mb-4 shadow-sm">
            <a href="work-single.html" class="item-wrap fancybox">
              <div class="work-info">
                <h3>Cocooil</h3>
                <span>Branding</span>
              </div>
              
              <div class="d-flex justify-content-start align-items-center">
	                <div class="btn-group">
	                  <!-- <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
	                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button> -->
	                </div>
	                <big class="text-muted">9 MON </big>
	          </div>
              <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/img_3.jpg">
              <div class="card-body">
	              <p class="card-title"><cite>title</cite></p>
	              <p class="card-text">This is a wider card with supporting text below the image. It is a document of the day.</p>
	            </div>
            </a>
          </div>
          <div class="item design col-sm-6 col-md-4 col-lg-3 mb-4 shadow-sm">
            <a href="work-single.html" class="item-wrap fancybox">
              <div class="work-info">
                <h3>Nike Shoe</h3>
                <span>Design</span>
              </div>
              <div class="d-flex justify-content-start align-items-center">
	                <div class="btn-group">
	                  <!-- <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
	                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button> -->
	                </div>
	                <big class="text-muted">8 SUN </big>
	          </div>
              <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/img_4.jpg">
              <div class="card-body">
	              <p class="card-title"><cite>title</cite></p>
	              <p class="card-text">This is a wider card with supporting text below the image. It is a document of the day.</p>
	            </div>
            </a>
          </div>
          <div class="item photography col-sm-6 col-md-4 col-lg-3 mb-4 shadow-sm">
            <a href="work-single.html" class="item-wrap fancybox">
              <div class="work-info">
                <h3>Kitchen Sink</h3>
                <span>Photography</span>
              </div>
              <div class="d-flex justify-content-start align-items-center">
	                <div class="btn-group">
	                  <!-- <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
	                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button> -->
	                </div>
	                <big class="text-muted">7 SAT </big>
	          </div>
              <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/img_5.jpg">
              <div class="card-body">
	              <p class="card-title"><cite>title</cite></p>
	              <p class="card-text">This is a wider card with supporting text below the image. It is a document of the day.</p>
	            </div>
            </a>
          </div>
          <div class="item branding col-sm-6 col-md-4 col-lg-3 mb-4 shadow-sm">
            <a href="work-single.html" class="item-wrap fancybox">
              <div class="work-info">
                <h3>Amazon</h3>
                <span>brandingn</span>
              </div>
              <div class="d-flex justify-content-start align-items-center">
	                <div class="btn-group">
	                  <!-- <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
	                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button> -->
	                </div>
	                <big class="text-muted">6 FRI </big>
	          </div>
              <img class="img-fluid" src="${pageContext.request.contextPath}/resources/img/img_6.jpg">
              <div class="card-body">
	              <p class="card-title"><cite>title</cite></p>
	              <p class="card-text">This is a wider card with supporting text below the image. It is a document of the day.</p>
	            </div>
            </a>
          </div>
        </div>
      </div>
    </section><!-- End  Works Section -->

    <!-- ======= Clients Section ======= -->
<%--     <section class="section">
      <div class="container">
        <div class="row justify-content-center text-center mb-4">
          <div class="col-5">
            <h3 class="h3 heading">My Clients</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>
          </div>
        </div>
        <div class="row">
          <div class="col-4 col-sm-4 col-md-2">
            <a href="#" class="client-logo"><img src="${pageContext.request.contextPath}/resources/img/logo-adobe.png" alt="Image" class="img-fluid"></a>
          </div>
          <div class="col-4 col-sm-4 col-md-2">
            <a href="#" class="client-logo"><img src="${pageContext.request.contextPath}/resources/img/logo-uber.png" alt="Image" class="img-fluid"></a>
          </div>
          <div class="col-4 col-sm-4 col-md-2">
            <a href="#" class="client-logo"><img src="${pageContext.request.contextPath}/resources/img/logo-apple.png" alt="Image" class="img-fluid"></a>
          </div>
          <div class="col-4 col-sm-4 col-md-2">
            <a href="#" class="client-logo"><img src="${pageContext.request.contextPath}/resources/img/logo-netflix.png" alt="Image" class="img-fluid"></a>
          </div>
          <div class="col-4 col-sm-4 col-md-2">
            <a href="#" class="client-logo"><img src="${pageContext.request.contextPath}/resources/img/logo-nike.png" alt="Image" class="img-fluid"></a>
          </div>
          <div class="col-4 col-sm-4 col-md-2">
            <a href="#" class="client-logo"><img src="${pageContext.request.contextPath}/resources/img/logo-google.png" alt="Image" class="img-fluid"></a>
          </div>

        </div>
      </div>
    </section> --%><!-- End Clients Section -->

<!--     ======= Services Section =======
    <section class="section">
      <div class="container">
        <div class="row justify-content-center text-center mb-4">
          <div class="col-5">
            <h3 class="h3 heading">My Services</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>
          </div>
        </div>
        <div class="row">

          <div class="col-12 col-sm-6 col-md-6 col-lg-3">
            <span class="la la-cube la-3x mb-4"></span>
            <h4 class="h4 mb-2">Web Design</h4>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>
            <ul class="list-unstyled list-line">
              <li>Lorem ipsum dolor sit amet consectetur adipisicing</li>
              <li>Non pariatur nisi</li>
              <li>Magnam soluta quod</li>
              <li>Lorem ipsum dolor</li>
              <li>Cumque quae aliquam</li>
            </ul>
          </div>
          <div class="col-12 col-sm-6 col-md-6 col-lg-3">
            <span class="la la-mobile la-3x mb-4"></span>
            <h4 class="h4 mb-2">Mobile Applications</h4>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>
            <ul class="list-unstyled list-line">
              <li>Lorem ipsum dolor sit amet consectetur adipisicing</li>
              <li>Non pariatur nisi</li>
              <li>Magnam soluta quod</li>
              <li>Lorem ipsum dolor</li>
              <li>Cumque quae aliquam</li>
            </ul>
          </div>
          <div class="col-12 col-sm-6 col-md-6 col-lg-3">
            <span class="la la-image la-3x mb-4"></span>
            <h4 class="h4 mb-2">Graphic Design</h4>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>
            <ul class="list-unstyled list-line">
              <li>Lorem ipsum dolor sit amet consectetur adipisicing</li>
              <li>Non pariatur nisi</li>
              <li>Magnam soluta quod</li>
              <li>Lorem ipsum dolor</li>
              <li>Cumque quae aliquam</li>
            </ul>
          </div>
          <div class="col-12 col-sm-6 col-md-6 col-lg-3">
            <span class="la la-search la-3x mb-4"></span>
            <h4 class="h4 mb-2">SEO</h4>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>
            <ul class="list-unstyled list-line">
              <li>Lorem ipsum dolor sit amet consectetur adipisicing</li>
              <li>Non pariatur nisi</li>
              <li>Magnam soluta quod</li>
              <li>Lorem ipsum dolor</li>
              <li>Cumque quae aliquam</li>
            </ul>
          </div>
        </div>
      </div>
    </section>End Services Section -->

    <!-- ======= Testimonials Section ======= -->
    <section class="section pt-0">
      <div class="container">

        <div class="owl-carousel testimonial-carousel">

          <div class="testimonial-wrap">
            <div class="testimonial">
              <img src="${pageContext.request.contextPath}/resources/img/person_1.jpg" alt="Image" class="img-fluid">
              <blockquote>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam necessitatibus incidunt ut officiis
                  explicabo inventore.</p>
              </blockquote>
              <p>&mdash; Jean Hicks</p>
            </div>
          </div>

          <div class="testimonial-wrap">
            <div class="testimonial">
              <img src="${pageContext.request.contextPath}/resources/img/person_2.jpg" alt="Image" class="img-fluid">
              <blockquote>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam necessitatibus incidunt ut officiis
                  explicabo inventore.</p>
              </blockquote>
              <p>&mdash; Chris Stanworth</p>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Testimonials Section -->

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer class="footer" role="contentinfo">
    <div class="container">
      <div class="row">
        <div class="col-sm-6">
          <p class="mb-1">&copy; Copyright MyPortfolio. All Rights Reserved</p>
          <div class="credits">
            <!--
            All the links in the footer should remain intact.
            You can delete the links only if you purchased the pro version.
            Licensing information: https://bootstrapmade.com/license/
            Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=MyPortfolio
          -->
            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
          </div>
        </div>
        <div class="col-sm-6 social text-md-right">
          <a href="#"><span class="icofont-twitter"></span></a>
          <a href="#"><span class="icofont-facebook"></span></a>
          <a href="#"><span class="icofont-dribbble"></span></a>
          <a href="#"><span class="icofont-behance"></span></a>
        </div>
      </div>
    </div>
  </footer>

  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/php-email-form/validate.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/aos/aos.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/owl.carousel/owl.carousel.min.js"></script>

  <!-- Template Main JS File -->
  <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

</body>

</html>
