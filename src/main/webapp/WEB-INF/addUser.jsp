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
                    <c:if test="${ !empty form }">
				        <p style="color: red;"> ${ form.statusMessage } </p>		
				    </c:if>
                        <div class="comment-form-wrap col-md-12 pt-5">
                            <h3 class="mb-5">S'enregistrer</h3>
                            <form action="#" class="p-3 p-md-5" method="post">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="prenom">Prénom</label>
                                            <input type="text" class="form-control" value="${ form.utilisateur.prenom }" name="prenom" id="prenom">
                                        	<span style="color: red;">${ form.erreurs.prenom }</span>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="index">Nom</label>
                                            <input type="text" class="form-control" value="${ form.utilisateur.nom }" name="nom" id="index">
                                        	<span style="color: red;">${ form.erreurs.nom }</span>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="index">Login</label>
                                            <input type="text" class="form-control" value="${ form.utilisateur.login }" name="login" id="index">
                                        	<span style="color: red;">${ form.erreurs.login }</span>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="index">Password</label>
                                            <input type="password" class="form-control" name="password" id="index">
                                        	<span style="color: red;">${ form.erreurs.password }</span>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="index">PasswordBis</label>
                                            <input type="password" class="form-control" name="passwordBis" id="index">
                                        	<span style="color: red;">${ form.erreurs.passwordBis }</span>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="email">Profil</label>
                                            <select class="" name="profil" id="email">
                                            	<option value="simple">simple</option>
                                            	<option value="admin">admin</option>
                                            </select>         
                                        	<span style="color: red;">${ form.erreurs.profil }</span>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="submit" value="Enregistrer" class="btn py-3 px-4 btn-primary">
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