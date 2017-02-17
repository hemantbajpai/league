<%@ page import="cscie56.ps2.Season" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'season.label', default: 'Season')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<h2> NBA Standings </h2>

<div class="standings">
    <ul class="nav nav-tabs">
        <li><a data-toggle="tab" href="#eastern">Eastern Conference</a></li>
        <li class="active"><a data-toggle="tab" href="#western">Western Conference</a></li>
    </ul>

    <div class="tab-content">

        <div id="eastern" class="tab-pane fade">
            <table>
                <tr>
                    <th>#</th>
                    <th>Team</th>
                    <th>W</th>
                    <th>L</th>
                    <th>PCT</th>
                    <th>GB</th>
                    <th>HOME</th>
                    <th>ROAD</th>
                    <th>L10</th>
                    <th>STRK</th>
                </tr>
                <g:each var="result" in="${eastResults}">
                    <tr>
                        <td>${result.value[0]}</td>
                        <td>${result.key.name}</td>
                        <td>${result.value[1]}</td>
                        <td>${result.value[2]}</td>
                        <td>${result.value[3]}</td>
                        <td>${result.value[4]}</td>
                        <td>${result.value[5]}</td>
                        <td>${result.value[6]}</td>
                        <td>${result.value[7]}</td>
                        <td>${result.value[8]}</td>
                    </tr>
                </g:each>
            </table>
        </div>
        <div id="western" class="tab-pane active">
            <table>
                <tr>
                    <th>#</th>
                    <th>Team</th>
                    <th>W</th>
                    <th>L</th>
                    <th>PCT</th>
                    <th>GB</th>
                    <th>HOME</th>
                    <th>ROAD</th>
                    <th>L10</th>
                    <th>STRK</th>
                </tr>
                <g:each var="result" in="${westResults}">
                    <tr>
                        <td>${result.value[0]}</td>
                        <td>${result.key.name}</td>
                        <td>${result.value[1]}</td>
                        <td>${result.value[2]}</td>
                        <td>${result.value[3]}</td>
                        <td>${result.value[4]}</td>
                        <td>${result.value[5]}</td>
                        <td>${result.value[6]}</td>
                        <td>${result.value[7]}</td>
                        <td>${result.value[8]}</td>
                    </tr>
                </g:each>
            </table>
        </div>
    </div>
</div>

</body>

</html>