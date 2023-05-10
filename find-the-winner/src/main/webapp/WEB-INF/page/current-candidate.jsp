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
    <title>DEP10 - Find the Winner - Current Candidate</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/current-candidate.css">
</head>
<body>
    <header>
        <h1>Current Candidate</h1>
    </header>
    <main>
        <c:if test="${!empty candidate}">
            <section>
                <img src="${candidate.pictureUrl}" alt="profile">
                <h2>${candidate.name}</h2>
                <h3>${candidate.nickName}</h3>
                <h3>Selected Date: ${candidate.selectedDate}</h3>
                <form action="/winners" method="POST">
                    <input name="id" type="hidden" value="${candidate.id}">
                    <input name="selected-date" type="hidden" value="${candidate.selectedDate}">
                    <input name="password" type="password" placeholder="Enter master password">
                    <button class="button">Won!</button>
                </form>
            </section>
        </c:if>
        <c:if test="${empty candidate}">
            <section>
                <h3>Currently no candidate has been selected to perform!</h3>
                <form action="/candidates/current" method="POST">
                    <input name="password" type="password" placeholder="Enter master password">
                    <button class="button">Pick a Candidate</button>
                </form>
            </section>
        </c:if>
        <p>Go to <a href="index.html">Home</a></p>
    </main>
    <footer>
        Copyright &copy; 2023 DEP10. All Rights Reserved.
    </footer>
</body>
</html>