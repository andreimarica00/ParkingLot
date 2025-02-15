<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cars">
    <div class="container-fluid">
        <div class="col-md-16 order-md-1">
            <h1 class="mb-3">Add Car</h1>
            <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Cars/Create">

                <div class="col-md-6 mb-3">
                    <label for="firstName">License Plate</label>
                    <input type="text" class="form-control" id="license_plate" name="license_plate" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Valid License Plate is required.
                    </div>
                </div>

                <div class="col-md-6 mb-3">
                    <label for="firstName">Parking Spot</label>
                    <input type="text" class="form-control" id="parking_spot" name="parking_spot" placeholder="" value="" required>
                    <div class="invalid-feedback">
                        Your Parking Spot is required.
                    </div>
                </div>

                <div class="col-md-6 mb-3">
                    <label for="country">Owner</label>
                    <select class="custom-select d-block w-100" id="owner_id" name="owner_id" required>
                        <option value="">Choose...</option>
                        <c:forEach var="user" items="${users}" varStatus="status">
                            <option value="${user.id}">${user.username}</option>
                        </c:forEach>

                    </select>
                    <div class="invalid-feedback">
                        Please select a valid Owner.
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
