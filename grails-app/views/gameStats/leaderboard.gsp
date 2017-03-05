<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta name="layout" content="main">
    <title>Leaderboard</title>
</head>
    <body>
        <h2> Leaderboard </h2>
        <br>
        <h3> Points </h3>
        <g:render template="leaderboardTable" model="[list:points]" />
        <br>
        <h3> Assists </h3>
        <g:render template="leaderboardTable" model="[list:assists]" />
        <br>
        <h3> Rebounds </h3>
        <g:render template="leaderboardTable" model="[list:rebounds]" />
        <br>
        <h3> Steals </h3>
        <g:render template="leaderboardTable" model="[list:steals]" />
        <br>
        <h3> Three pointers made </h3>
        <g:render template="leaderboardTable" model="[list:threePointersMade]" />
    </body>
</html>