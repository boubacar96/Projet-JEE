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
				    <h3 class="mb-5">liste des utilisateurs</h3> 
				    <c:set var="utilisateurs" value="${ requestScope.utilisateurs }" scope="page"/>
				    <c:choose>
				      <c:when test="${ empty utilisateurs }"><p>la liste est vide pour le moment</p></c:when>
				      <c:otherwise>
				        <table class="table bg-light">
				          <tr>
				            <th class="bg-dark text-light">Id</th>
				            <th>Nom</th>
				            <th>Prenom</th>
				            <th>Login</th>
				            <th>password</th>
				            <th colspan="2">Actions</th>
				          </tr>
				        <c:forEach items="${ utilisateurs }" var="utilisateur">
				          <tr>
				            <td><c:out value="${ utilisateur.id }" /></td> 
				            <td><c:out value="${ utilisateur.nom }" /></td>
				            <td><c:out value="${ utilisateur.prenom }" /></td>
				            <td><c:out value="${ utilisateur.login }" /></td> 
				            <td><c:out value="${ utilisateur.password }" /></td>
				            <td><a href='<c:url value="/update?id=${ utilisateur.id }" />' class="btn btn-success">modifier</a></td> 
				            <td><a href='<c:url value="/delete?id=${ utilisateur.id }" />' class="btn btn-danger">supprimer</a></td>
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
