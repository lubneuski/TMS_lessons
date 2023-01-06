<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>


<form action="search" method="get">
    <h3>Search</h3>

    <div>
        <input type="text" class="form-control" name="id">
        <label>Car ID</label>
    </div>

    <button type="submit">Submit</button>
</form>

<br>


<form method="post">
    <h3>Add Car</h3>

    <div>
        <input type="text" name="id">
        <label>Car ID</label>
    </div>

    <div>
        <input type="text" name="brand">
        <label>Brand</label>
    </div>

    <div>
        <input type="text" name="model">
        <label>Model</label>
    </div>

    <button type="submit">Submit</button>
</form>

<br>


<form action="delete" method="get">
    <h3>Delete Car</h3>

    <div>
        <input type="text" name="id">
        <label>Car ID</label>
    </div>

    <button type="submit">Submit</button>
</form>


</body>
</html>