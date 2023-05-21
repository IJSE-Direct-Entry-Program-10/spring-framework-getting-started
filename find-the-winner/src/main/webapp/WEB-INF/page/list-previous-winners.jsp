<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="/">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DEP10 - Find the Winner - List Previous Winners</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/list-previous-winners.css">
</head>
<body>
<header>
    <h1>List Previous Winners</h1>
</header>
<main>
    <table>
        <thead>
            <tr>
                <th>Picture</th>
                <th>Name</th>
                <th>Selected Date</th>
                <th>Performed Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="winner" items="${winners}">
                <tr>
                    <td><img src="${winner.pictureUrl}" referrerpolicy="no-referrer"></td>
                    <td>${winner.name}</td>
                    <td>${winner.selectedDate}</td>
                    <td>${winner.performedDate}</td>
                </tr>
            </c:forEach>
            <c:if test="${empty winners}">
                <tr>
                    <td colspan="4">No winners yet!</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</main>
<footer>
    Copyright &copy; 2023 DEP10. All Rights Reserved.
</footer>
</body>
</html>