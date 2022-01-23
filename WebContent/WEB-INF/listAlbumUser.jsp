<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.jsp"/>
<div id="colorlib-main">
    <section class="ftco-section ftco-no-pt ftco-no-pb">
        <div class="container px-md-0">
            <div class="row d-flex no-gutters">
                <div class="col-lg-12 pb-5 single">
                    <div class="row">
                    <div class="px-5 mt-4">
                        <div class="">
                            <h3 class="mb-5">Listes de tous mes albums</h3>
                            <c:set var="albums" value="${ requestScope.albums }" scope="page"/>
						    <c:choose>
						      <c:when test="${ empty albums }"><p>la liste est vide pour le moment</p></c:when>
						      <c:otherwise>
						        <table class="table bg-light">
						          
						          <tr>
						            <th class="bg-dark text-light">Id</th>
						            <th>Theme</th>
						            <th>mode</th>
						            <th colspan="3">Actions</th>
						          </tr>
						          
						          
						        <c:forEach items="${ albums }" var="album">
						          <tr>
						            <td><c:out value="${ album.id }" /></td> 
						            <td><c:out value="${ album.theme }" /></td>
						            <td><c:out value="${ album.mode }" /></td>
						            <td><a href='<c:url value="/viewAlbum?id=${ album.id }" />' class="btn btn-primary">afficher</a></td>
						            <td><a href='<c:url value="/update?id=${ album.id }" />' class="btn btn-success">modifier</a></td> 
						            <td><a href='<c:url value="/delete?id=${ album.id }" />' class="btn btn-danger">supprimer</a></td>
						          </tr>
						        </c:forEach>
						        </table>
						      </c:otherwise>
						    </c:choose>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<c:import url="include/footer.jsp"/> 