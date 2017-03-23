<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta name="layout" content="main">
    <title>Leaderboard</title>
    <style>
        h4 {
            text-align: center;
        }
        tr:nth-child(odd) {background-color: #f2f2f2}
    </style>
</head>
    <body>
        <h2> Leaderboard </h2>

        <div class="container">

            <div class="row">

                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                <h4> Points </h4>
                <g:render template="leaderboardTableShowAll" model="[list:points]" />
                <br>
                </div>

                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                <h4> Assists </h4>
                <g:render template="leaderboardTableShowAll" model="[list:assists]" />
                <br>
                </div>

                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                <h4> Rebounds </h4>
                <g:render template="leaderboardTableShowAll" model="[list:rebounds]" />
                <br>
                </div>

                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                <h4> Steals </h4>
                <g:render template="leaderboardTableShowAll" model="[list:steals]" />
                <br>
                </div>
            </div>

            <a href="/leaderboard">Show less</a>
        </div>
    </body>
</html>