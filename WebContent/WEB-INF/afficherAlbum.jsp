<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <c:import url="include/header.jsp"/>
	<c:set var="images" value="${ requestScope.images }" scope="page"/>
    <c:set var="album" value="${ requestScope.album }" scope="page"/>
    
			<div id="colorlib-main">
				<section class="ftco-section ftco-no-pt ftco-no-pb">
					<div class="container px-md-0">
						<div class="row d-flex no-gutters">
						<div class="px-5 mt-4">
						<c:choose>
						 <c:when test="${ empty images }"><p>Pas de photos</p></c:when>
					     <c:otherwise>
						<h3 class="mb-3">theme <c:out value="${ album.theme }" /></h3>
						<div class="row text-center text-lg-start">
					
						    <c:forEach items="${ images }" var="image">
						    <div class="col-lg-3 col-md-4 col-6">
						      <a  href="<c:url value="/Albums/album${album.id }/${ image.nomFichier }" />" class="d-block mb-4 h-100 img image-popup js-fullheight d-flex align-items-center justify-content-center">
						        <img  id="image-popup" alt="${image.id}" class="img-fluid img-thumbnail" src="<c:url value="/Albums/album${album.id }/${image.nomFichier }" />" alt="">
						      </a>
						      
						    </div>
						    </c:forEach>
						   </div>
					      </c:otherwise>
					    </c:choose>
					    </div>
						</div>	
					</div>
				</section>
			</div><!-- END COLORLIB-MAIN -->
		</div><!-- END COLORLIB-PAGE -->
     <c:import url="include/footer.jsp"/>