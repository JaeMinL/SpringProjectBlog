<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/includes/header.jsp"%>
<%@ include file="/WEB-INF/includes/nav.jsp"%>

				<div class="col-md-12 col-lg-6 text-left text-lg-right" data-aos="fade-up" data-aos-delay="100">
					<div class="menus" class="menus" style="font-size:20pt">
						<a href="#" >(All)</a>
						<a href="/" >Album</a>
						<a href="#" >AMap</a>
						<a href="/upload" class="active">+</a>
	            	</div>
				</div>
			</div>
		</div>
	</header>
	
	<main id="main">     
		<section class="section site-portfolio" style="padding:0 0 0 0;">
			<div class="container">
				<div class="row align-items-center">
					<!-- <form class="fileform" name="fileForm" action="requestupload2" method="post" enctype="multipart/form-data" data-aos="fade-up">
				       <input multiple="multiple" type="file" name="file" /> </br>
				       <input type="text" name="src" /> </br>
				       <input type="submit" value="전송" /> 
				   	</form> -->
				   	<div class="upload">
				   		<input type='file' name='uploadImage' accept="image/*" multiple>
				   	</div>
				   	<button id='uploadBtn'>Upload</button>
				   	
				   	<script
				   		src="http://code.jquery.com/jquery-3.3.1.min.js"
				   		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
				   		crossorigin="anonymous">
				   	</script>
				   	
				   	<script>
				   	$(document).ready(function(){
				   		
				   		$("#uploadBtn").on("click", function(e){
				   			var formData = new FormData();
				   			var inputImage = $("input[name='uploadImage']");
				   			var images = inputImage[0].files;
				   			
				   			console.log(images);
				   			
				   			for (var i=0; i< images.length; i++){
				   				formData.append("uploadImage", images[i]);
				   				
				   			}
				   			
				   			
				   			$.ajax({
				   				url: '/uploadAction',
				   					processData: false,
				   					contentType: false,
				   					data: formData,
				   					type: 'POST',
				   					enctype: 'multipart/form-data',
				   					success: function(result){
				   						alert("Uploaded");
				   					}
				   			}); //$.ajax
				   		});
				   	});
				   	</script>
				</div>	
			</div>
		</section>
	</main><!-- End #main -->
  
<%@ include file="/WEB-INF/includes/footer.jsp"%>