<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container p-3 border">
    <div class="row align-items-center p-3 ">
        <div class="col-4 ">
            <form action="all" method="post">
                <h5 class="mb-3 fw-normal">Search Car</h5>
                <div class="form-floating">
                    <input type="text" class="form-control shadow" name="id">
                    <label>Car ID</label>
                </div>
                <button class="w-100 btn btn-md btn-primary shadow" type="submit">Submit</button>
            </form>
        </div>
        <div class="col-4 ">
            <form action="add" method="post">
                <h5 class=" mb-3 fw-normal">Add Car</h5>
                <div class="form-floating">
                    <input type="text" class="form-control shadow" name="id">
                    <label>Car ID</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control shadow" name="brand">
                    <label>Brand</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control shadow" name="model">
                    <label>Model</label>
                </div>
                <button class="w-100 btn btn-md btn-primary shadow" type="submit">Add Car</button>
            </form>
        </div>
        <div class="col-4 ">
            <form action="delete" method="post">
                <h5 class="mb-3 fw-normal">Delete Car</h5>
                <div class="form-floating">
                    <input type="text" class="form-control shadow" name="id">
                    <label>Car ID</label>
                </div>
                <button class="w-100 btn btn-md btn-primary shadow" type="submit">Submit</button>
            </form>
        </div>
    </div>
</div>
<br>
<hr>

<table class="table table-bordered border-primary w-50 text-center" style="margin: auto;">
    <thead>
        <tr class="table table-primary">
            <th scope="col">ID</th>
            <th scope="col">Brand</th>
            <th scope="col">Model</th>
            <th scope="col"></th>
<%--            <th scope="col"></th>--%>
        </tr>
    </thead>
    <tbody>
            <c:forEach items="${car27}" var="car27">
                <form action="delete" method="post">
                    <tr>
                        <input type="hidden" name="id" value="${car27.id}">
                        <th scope="row">${car27.id}</th>
                        <td>${car27.brand}</td>
                        <td>${car27.model}</td>
                        <td><input type="submit" value="delete"></td>
<%--                <form action="update" method="post">--%>
<%--                    <input type="hidden" name="id" value="${car27.id}">--%>
<%--                    <td><input type="submit" value="Update"></td>--%>
<%--                </form>--%>
                    </tr>
                </form>
            </c:forEach>
    </tbody>
</table>

</body>
</html>
