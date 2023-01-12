<%@ page import="alex.lu.Cars26H" %>
<%@ page import="static alex.lu.CarStorage26H.getCars" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container p-3 border">
    <div class="row align-items-center p-3 ">
        <div class="col-4 ">
            <form action="car" method="get">
                <h5 class="mb-3 fw-normal">Search Car</h5>
                <div class="form-floating">
                    <input type="text" class="form-control shadow" name="id">
                    <label>Car ID</label>
                </div>
                <button class="w-100 btn btn-md btn-primary shadow" type="submit">Submit</button>
            </form>
        </div>
        <div class="col-4 ">
            <form action="car" method="post">
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
<%
    if (request.getAttribute("cars")!=null) {
        for (Map.Entry<String, Cars26H> entry : getCars().entrySet()) {
            out.println("Id: " + entry + "<br>");
        }
    }
%>
</body>
</html>