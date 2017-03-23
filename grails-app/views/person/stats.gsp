<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="cscie56.ps2.Person" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'season.label', default: 'Season')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <style>
            tr:nth-child(even) {background-color: #f2f2f2}
        </style>
    </head>

    <body>

        <div class="playerstatpage">

            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#info">Player Info</a></li>
                <li><a data-toggle="tab" href="#seasonstats">Season Stats</a> </li>
                <li><a data-toggle="tab" href="#games">Games</a> </li>
            </ul>

            <div class="tab-content">
                <div id="info" class="tab-pane active">
                    <img src="${resource(dir:"images", file: "${player.firstName + ".png"}") }"/>
                    <h2> ${player.firstName} ${player.lastName} </h2>
                    <br>
                    <h4>1. Bio ${player.bio}</h4>
                    <h4>2. Team ${player.team.name}</h4>
                    <h4>3. Height ${player.height}</h4>
                    <h4>4. Weight ${player.weight}</h4>
                    <h4>5. Birth Date <g:formatDate format="MM-dd-yyyy" date="${player.birthDate}" /></h4>
                    <h4>6. Role ${player.role}</h4>
                    <h4>7. Birth Place ${player.birthPlace}</h4>
                    <h4>8. University Attended ${player.universityAttended}</h4><br>
                </div>

                <div id="seasonstats" class="tab-pane fade">
                    <h4> Averages </h4>
                    <stats:average player="${player}"/>

                    <h4> Totals </h4>
                    <stats:total player="${player}"/>
                </div>

                <div id="games" class="tab-pane fade">
                    <table>
                        <thead>
                            <tr>
                                <th class="col-sm-1 col-xs-2">Game</th>
                                <th class="col-sm-1 col-xs-2">MP</th>
                                <th class="col-sm-1 col-xs-2">P</th>
                                <th class="col-sm-1 col-xs-2">A</th>
                                <th class="col-sm-1 col-xs-2">R</th>
                                <th class="col-sm-1 col-xs-2">ST</th>
                                <th class="col-sm-1 hidden-xs">SM</th>
                                <th class="col-sm-1 hidden-xs">SA</th>
                                <th class="col-sm-1 hidden-xs">S%</th>
                                <th class="col-sm-1 hidden-xs">3PM</th>
                                <th class="col-sm-1 hidden-xs">3PA</th>
                                <th class="col-sm-1 hidden-xs">3P%</th>
                                <th class="col-sm-1 hidden-xs">PF</th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each var="gameStat" in="${gameStats}">
                                <g:render template="gameStatsRow" model="[bean:gameStat]" />
                            </g:each>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </body>

</html>