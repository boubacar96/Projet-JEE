<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.jsp" />
<div id="colorlib-main">
    <section class="ftco-section ftco-no-pt ftco-no-pb">
        <div class="container px-md-0">
            <div class="row d-flex no-gutters">
                <div class="col-lg-12 pb-5 single">
                    <div class="row">
                    <div class="px-5 mt-4">
                        <div class="comment-form-wrap col-md-12 pt-5">
                            <h3 class="mb-5">Ajouter Album</h3>
                            <form action="" class="p-3 p-md-5" method="post">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="login">Theme</label>
        									<input type="text" class="form-control" name="theme" id="login" value="<c:out value="" />" />
											<%--         <span class="erreur">${ form.erreurs.theme }</span> --%>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="login">Mode</label>
        									<select class="form-control" name="mode">
        									<option value="public">Public</option>
        									<option value="prive">Privé</option>
        									</select>
											<%--         <span class="erreur">${ form.erreurs.mode }</span> --%>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="submit" value="Ajouter" class="btn py-3 px-4 btn-primary">
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