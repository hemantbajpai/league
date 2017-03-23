<%@ page import="cscie56.ps2.Season" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'season.label', default: 'Season')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
    <style>
        tr:nth-child(odd) {background-color: #f2f2f2}
    </style>
</head>

<body>

<h1> Season standings for NBA - Winter 2016 </h1>

<div class="standings">
    <ul class="nav nav-tabs">
        <li><a data-toggle="tab" href="#eastern">Eastern Conference</a></li>
        <li class="active"><a data-toggle="tab" href="#western">Western Conference</a></li>
    </ul>

    <div class="tab-content">

        <div id="eastern" class="tab-pane fade">
            <g:render template="standingsTable" model="[maps:eastResults]" />
        </div>
        <div id="western" class="tab-pane active">
            <g:render template="standingsTable" model="[maps:westResults]" />
        </div>
    </div>
</div>

</body>

</html>