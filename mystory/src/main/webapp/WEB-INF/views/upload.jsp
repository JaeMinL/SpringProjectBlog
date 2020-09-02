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
				   	<div class="uploadDiv">
				   		<input type="file" name="uploadImage" accept="image/*" multiple>
				   	</div>
				   	
				   	<button id="uploadBtn">Upload</button>
				   	
				   	<script
				   		src="http://code.jquery.com/jquery-3.3.1.min.js"
				   		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
				   		crossorigin="anonymous">
				   	</script>
				   	
				   	<script>
				   	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz$)");
				   	var maxSize = 5242880;
				   	
				   	function checkExtension(fileName, fileSize){
				   		
				   		if(fileSize >= maxSize){
				   			alert("파일 사이즈 초과 ");
				   			return false;
				   		}
				   		if(regex.test(fileName)){
				   			alert("해당 종류의 파일은 업로드할 수 없습니다.");
				   			return false;
				   		}
				   		return true;
				   	};
				   	
			   		$("#uploadBtn").on("click", function(e){
			   			var formData = new FormData();
			   			var inputImage = $("input[name = 'uploadImage' ]");
			   			var images = inputImage[0].files;
			   			
			   			console.log(images);
			   			
			   			for (var i=0; i< images.length; i++){
			   				if(!checkExtension(images[i].name, images[i].size) ){
			   					return false;
			   				}
			   				
			   				formData.append("uploadImage", images[i]);
			   			}
			   			
			   			$.ajax({
			   				url: '/uploadAction',
			   					processData: false,
			   					contentType: false,
			   					data: formData,
			   					type: 'POST',
			   					success: function(result){
			   						alert("Uploaded");
			   					}
			   			}); //$.ajax
			   		});
				   	</script>
				</div>	
			</div>
		</section>
		
		<section class="section pt-0">
			<div class="container">
				<div class="uploadresult-wrap">
					<ul class="uploadresult-list">
							<li>Test</li>
							
					</ul>
				</div>
			</div>
		</section> <!-- .uploadresult end-->
	</main><!-- End #main -->
  
<%@ include file="/WEB-INF/includes/footer.jsp"%>