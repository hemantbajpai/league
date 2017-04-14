<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<head xmlns:padding-left="http://www.w3.org/1999/xhtml">
<asset:javascript src="application.js"></asset:javascript>
<asset:javascript src="person/personBlog.js"></asset:javascript>
<style>
body,h1,h2,h3,h4,h5 {color: black}
tab1 { padding-left: 4em; }
tab2 { padding-left: 8em; }
</style>
</head>
<body>

    <g:set var="blog" value="${bean}"/>

    <h3><b>BLOG:</b></h3>
    <h5>Date Published: ${blog.datePublished}</h5>

    <p>
        ${blog.text}
        <br>
    </p>

    <g:each var="comment" in="${blog.comments}">
        <g:if test="${comment.approved == true}">
            <p><tab1><b>Comment: by ${comment.user.username}</b></tab1></p>
            <p><tab1>Date Created: ${comment.dateCreated}</tab1></p>
            <p><tab1>${comment.text} </tab1></p>

            <g:each var="reply" in="${comment.replies}">
                <g:if test="${reply.approved == true}">
                    <p><tab2><b>Reply: by ${reply.user.username}</b></tab2></p>
                    <p><tab2>Date Created: ${reply.dateCreated}</tab2></p>
                    <p><tab2>${reply.text} </tab2></p><br>
                </g:if>
                <g:elseif test="${reply.pending == true}">
                    <g:if test="${sec.username() == blog.user.username}">
                        <div id="reply${reply.id}">
                            <p><tab2><b>Reply: by ${reply.user.username}</b></tab2></p>
                            <p><tab2>Date Created: ${reply.dateCreated}</tab2></p>
                            <p><tab2>${reply.text} </tab2></p>
                        </div>
                        <g:if test="${reply.user.username != blog.user.username}">
                            <div id="btn-reply-${reply.id}">
                                <p><tab2>AWAITING APPROVAL</tab2></p>
                                <tab2><button type="button" id="btn-reply-approved" data-replyid="${reply.id}" class="btn-primary btn-xs">Approve</button>
                                    <button type="button" id="btn-reply-reject" data-replyid="${reply.id}" class="btn-primary btn-xs">Reject</button></tab2><br>
                            </div>
                        </g:if>
                    </g:if>
                    <g:elseif test="${sec.username() == reply.user.username}">
                        <p><tab2><b>Reply: by ${reply.user.username}</b></tab2></p>
                        <p><tab2>Date Created: ${reply.dateCreated}</tab2></p>
                        <p><tab2>${reply.text} </tab2></p>
                        <p><tab2>AWAITING APPROVAL</tab2></p><br>
                    </g:elseif>
                </g:elseif>
                <g:elseif test="${reply.pending == false}">
                    <g:if test="${sec.username() == reply.user.username}">
                        <p><tab2><span style="opacity:0.5;"><del><b>Reply: by ${reply.user.username}</b></del> </span></tab2></p>
                        <p><tab2><span style="opacity:0.5;"><del>Date Created: ${reply.dateCreated}</del> </span></tab2></p>
                        <p><tab2><span style="opacity:0.5;"><del>${reply.text}</del> </span><br></tab2></p><br>
                    </g:if>
                </g:elseif>
            </g:each>

            <sec:ifAnyGranted roles="ROLE_USER">
                <g:form controller="BlogEntry" params="[commentId:comment.id]">
                    <label><tab2>Reply to Comment</tab2></label>
                    <g:textField name="text"/><br/>
                    <tab2><g:actionSubmit value="Post Reply" action="addReply"/></tab2>
                </g:form>
                <br>
            </sec:ifAnyGranted>

        </g:if>
        <g:elseif test="${comment.pending == true}">
            <g:if test="${sec.username() == blog.user.username}">
                <div id="${comment.id}">
                    <p><tab1><b>Comment: by ${comment.user.username}</b></tab1></p>
                    <p><tab1>Date Created: ${comment.dateCreated}</tab1></p>
                    <p><tab1>${comment.text} </tab1></p>
                </div>
                <g:if test="${comment.user.username != blog.user.username}">
                    <div id="btn-${comment.id}">
                        <p><tab1>AWAITING APPROVAL</tab1></p>
                        <tab1><button type="button" id="btn-approved" data-commentid="${comment.id}" class="btn-primary btn-xs">Approve</button>
                        <button type="button" id="btn-reject" data-commentid="${comment.id}" class="btn-primary btn-xs">Reject</button></tab1><br>
                    </div>
                </g:if>
            </g:if>
            <g:elseif test="${sec.username() == comment.user.username}">
                <p><tab1><b>Comment: by ${comment.user.username}</b></tab1></p>
                <p><tab1>Date Created: ${comment.dateCreated}</tab1></p>
                <p><tab1>${comment.text} </tab1></p>
                <p><tab1>AWAITING APPROVAL</tab1></p><br>
            </g:elseif>
        </g:elseif>
        <g:elseif test="${comment.pending == false}">
            <g:if test="${sec.username() == comment.user.username}">
                <p><tab1><span style="opacity:0.5;"><del><b>Comment: by ${comment.user.username}</b></del> </span></tab1></p>
                <p><tab1><span style="opacity:0.5;"><del>Date Created: ${comment.dateCreated}</del> </span></tab1></p>
                <p><tab1><span style="opacity:0.5;"><del>${comment.text}</del> </span><br></tab1></p><br>
            </g:if>
        </g:elseif>


    </g:each>


</body>

