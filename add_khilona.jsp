<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Add New Khilona</h1>

    <%@ include file="menu.jsp" %>

    <%@ include file="menu2.jsp" %>

    <form action="add.do" method="post">
        <table>
            <tr>
                <th>Khilona Name</th>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <th>Khilona Price</th>
                <td><input type="number" name="price"></td>
            </tr>
            <tr>
                <th>Khilona Age-Group</th>
                <td><input type="text" name="age_group"></td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td><input type="number" name="quantity"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Add Khilona">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>