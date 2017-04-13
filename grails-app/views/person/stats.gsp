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
            <img src="${resource(dir:"images", file: "${player.firstName + ".png"}") }"/>
            <h2> ${player.firstName} ${player.lastName} </h2>
            <br>

            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#info">Player Info</a></li>
                <li><a data-toggle="tab" href="#seasonstats">Season Stats</a> </li>
                <li><a data-toggle="tab" href="#games">Games</a> </li>
                <li><a data-toggle="tab" href="#blog">Blog</a> </li>
            </ul>

            <div class="tab-content">
                <div id="info" class="tab-pane active">
                    <h4>1. Bio ${player.user.bio}</h4>
                    <h4>2. Team ${player.team.name}</h4>
                    <h4>3. Height ${player.user.height}</h4>
                    <h4>4. Weight ${player.user.weight}</h4>
                    <h4>5. Birth Date <g:formatDate format="MM-dd-yyyy" date="${player.user.birthDate}" /></h4>
                    <h4>6. Role ${player.role}</h4>
                    <h4>7. Birth Place ${player.user.birthPlace}</h4>
                    <h4>8. University Attended ${player.user.universityAttended}</h4><br>
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

                <div id="blog" class="tab-pane fade">

                    <g:if test="${sec.username() == player.user.username}">
                        <br>
                        <br>
                        <button type="button" id="modalButton" class="btn-primary btn-sm" data-toggle="modal" data-target="#createModal">Create Blog Entry</button>
                        <div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <g:form controller="BlogEntry">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="bookModalLabel">Create Blog</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div id="bookModalContent">
                                                <g:textField size="80px" name="text"/><br/>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <g:actionSubmit name="save" value="Save" action="saveBlog"/>
                                        <g:actionSubmit id="publishButton" name="publish" value="Save and Publish" action="publishBlog"/>
                                    </div>
                                    </g:form>
                                </div>
                            </div>
                        </div>
                        <br>
                        <br>
                    </g:if>

                    <g:each var="blog" in="${blogs}">
                        <g:if test="${blog.published == true}">

                            <g:render template="blog" model="[bean:blog]" />
                            <sec:ifAnyGranted roles="ROLE_USER">
                                <g:form controller="BlogEntry" params="[blogId: blog.id]">
                                    <label>Write a Comment!</label>
                                    <g:textField name="text"/><br/>
                                    <g:actionSubmit value="Write Comment!" action="addComment"/>
                                </g:form>
                            </sec:ifAnyGranted>
                        </g:if>
                        <g:else>
                            <g:if test="${sec.username() == blog.user.username}">
                                <g:render template="blog" model="[bean:blog]" />
                                <g:form controller="BlogEntry" params="[blogId: blog.id]">
                                    <g:actionSubmit value="Publish" action="publishEntry"/>
                                </g:form>
                            </g:if>
                        </g:else>
                    </g:each>
                </div>
            </div>
        </div>

    </body>

</html>