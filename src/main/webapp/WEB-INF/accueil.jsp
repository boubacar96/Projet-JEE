<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <c:import url="include/header.jsp"/>
	<c:set var="albums" value="${ requestScope.albums }" scope="page"/>
			<div id="colorlib-main">
				<section class="ftco-section ftco-no-pt ftco-no-pb">
					<div class="container px-md-0">
						<div class="row d-flex no-gutters">
							<div class="col-md-12 portfolio-wrap-2" >
							<div class="px-5 mt-4">
							<c:choose>
						 	<c:when test="${ empty albums }"><p>Pas d'Album</p></c:when>
						 	<c:otherwise>
						 	<c:forEach items="${ albums }" var="album">
						 	
						 	<c:if test="${ !empty album[4] }" >
						 	
						 	<c:set var="i" value="true" scope="page"/>
							<a href="<c:url value="/viewAlbum?id=${ album[0] }" />"><h3 class="mb-3">${ album[1] }</h3></a>
								<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
								  <div class="carousel-inner">
								  	
								  	<c:forEach items="${ album[4] }" var="image">
								    <div class="carousel-item ${ i ? 'active': '' }">
								      <img class="d-block w-100" src="<c:url value="/Albums/album${image.id }/${ image.nomFichier }" />" alt="${ album[0] } slide" height="500px">
								    </div>
								    <c:set var="i" value="false" scope="page"/>
								    </c:forEach>
								    
								  </div>
								  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
								    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
								    <span class="sr-only">Previous</span>
								  </a>
								  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
								    <span class="carousel-control-next-icon" aria-hidden="true"></span>
								    <span class="sr-only">Next</span>
								  </a>
								</div>
								
							  </c:if>
							   </c:forEach>
								</c:otherwise>
							</c:choose>
							</div>	
						</div>
					</div>
					<div class="row d-flex">
						<div class="col-md-12">
							<a href="#" class="btn-custom-load d-block w-100 text-center py-4">UP <span class="fa fa-refresh"></span></a>
						</div>
					</div>
					</div>
				</section>
			</div><!-- END COLORLIB-MAIN -->
		</div><!-- END COLORLIB-PAGE -->
     <c:import url="include/footer.jsp"/>