<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="cscie56.ps2.Person" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'season.label', default: 'Season')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>

    <body>

        <div class="playerstatpage">

            <table>
                <tr>
                    <th><img src="${resource(dir:"images", file: "${player.firstName + ".png"}") }"/></th>
                    <th><h2> ${player.firstName} ${player.lastName} </h2><br> University: ${player.universityAttended} <br> Team: ${player.team.name} <br> Role: ${player.role}</th>
                    <th><h2>Bio: ${player.bio}</h2> <br> Height: ${player.height} <br> Weight: ${player.weight} <br> Birthplace: ${player.birthPlace}</th>
                </tr>
            </table>
            <br>

            <h4> Season Averages </h4>
                <stats:average player="${player}"/>
            <br>
            <h4> Season Totals </h4>
                <stats:total player="${player}"/>
            <br>
            <h4> Games </h4>
            <table>
                <thead>
                    <tr>
                        <th>Game</th>
                        <th>MIN</th>
                        <th>PTS</th>
                        <th>FGM</th>
                        <th>FGA</th>
                        <th>FG%</th>
                        <th>3PM</th>
                        <th>3PA</th>
                        <th>3P%</th>
                        <th>REB</th>
                        <th>AST</th>
                        <th>STL</th>
                        <th>PF</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each var="gameStat" in="${gameStats}">
                        <g:render template="gameStatsRow" model="[bean:gameStat]" />
                    </g:each>
                </tbody>
            </table>
        </div>

    </body>

</html>