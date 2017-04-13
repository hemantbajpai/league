<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <style>
            tr:nth-child(even) {background-color: #f2f2f2}
        </style>
    </head>
    <body>
        <a href="#list-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-person" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>

            <table>
                <thead>
                <tr>
                    <th class="col-sm-2 col-xs-3">Player</th>
                    <th class="col-sm-2 col-xs-3">Team</th>
                    <th class="col-sm-1 col-xs-3">Height</th>
                    <th class="col-sm-1 col-xs-3">Weight</th>
                    <th class="col-sm-2 hidden-xs">Birthdate</th>
                    <th class="col-sm-2 hidden-xs">Birth Place</th>
                    <th class="col-sm-2 hidden-xs">University</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${personList}" status="i" var="person">
                <tr>
                    <td class="col-sm-2 col-xs-3"><g:link action="stats" id="${person.id}">${person.firstName} ${person.lastName}</g:link></td>
                    <td class="col-sm-2 col-xs-3">${person.team.name}</td>
                    <td class="col-sm-1 col-xs-3">${person.user.height}</td>
                    <td class="col-sm-1 col-xs-3">${person.user.weight}</td>
                    <td class="col-sm-2 hidden-xs"><g:formatDate format="MM/dd/yyyy" date="${person.user.birthDate}" /></td>
                    <td class="col-sm-2 hidden-xs">${person.user.birthPlace}</td>
                    <td class="col-sm-2 hidden-xs">${person.user.universityAttended}</td>
                </tr>
                </g:each>
                </tbody>
            </table>
            <div class="pagination">
                <g:paginate total="${personCount ?: 0}" />
            </div>
        </div>
    </body>
</html>