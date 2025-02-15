<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add User">
    <div class="container-fluid">
        <div class="col-md-16 order-md-1">
            <h1 class="mb-3">Add User</h1>
            <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Users/Create">

                <div class="col-md-6 mb-3">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Username is required.
                    </div>
                </div>

                <div class="col-md-6 mb-3">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Email is required
                    </div>
                </div>
                
                <div class="col-md-6 mb-3">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Password is required.
                    </div>
                </div>

                <div class="col-md-6 mb-3">
                    <label for="position">Position</label>
                    <select class="custom-select d-block w-100" id="position" name="position" required>
                        <option value="">Choose...</option>
                        <option value="ADMINISTRATOR">Administrator</option>
                        <option value="CLIENT">Client</option>
                    </select>
                    <div class="invalid-feedback">
                        Please select a position.
                    </div>
                </div>
                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
            </form>
        </div>

        <footer class="my-5 pt-5 text-muted text-center text-small">
            <p class="mb-1">&copy; 2017-2020 The Best Parking Lot</p>
        </footer>
    </div>
</t:pageTemplate>