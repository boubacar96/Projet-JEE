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
                    <c:if test="${ !empty param.error }">
				        <p style="color: red;">
				        Echec de l'authentification : Login et/ou Password incorrect !!!
				        </p>	
				    </c:if>
                        <div class="comment-form-wrap col-md-12 pt-5">
                            <h3 class="mb-5">connecter vous</h3>
                            <form action="" class="p-3 p-md-5" method="post">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="name">Login</label>
                                            <input type="text" class="form-control" name="login" id="name" value="<c:out value="${ param.user }" />" >
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="email">Password</label>
                                            <input type="password" class="form-control" name="password" id="email">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="email">Profil</label>
                                            <select class="" name="profil" id="email">
                                            	<option value="simple">simple</option>
                                            	<option value="admin">admin</option>
                                            </select>         
                                        </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div class="form-group">
                                            <input type="submit" value="Se connecter" class="btn py-3 px-4 btn-primary">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                            <a href='<c:url value="/register"/>' class="btn py-3 px-4 btn-primary">S'inscrire</a>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<c:import url="include/footer.jsp"/>       