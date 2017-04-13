<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<head>
<asset:javascript src="application.js"></asset:javascript>
<asset:javascript src="person/personBlog.js"></asset:javascript>
<style>
body,h1,h2,h3,h4,h5 {color: black}
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
            <p><b>Comment:</b></p>
            <p>Date Created: ${comment.dateCreated}</p>
            <p>${comment.text} <br></p>
        </g:if>
        <g:elseif test="${comment.pending == true}">
            <g:if test="${sec.username() == blog.user.username}">
                <div id="${comment.id}">
                    <p><b>Comment:</b></p>
                    <p>Date Created: ${comment.dateCreated}</p>
                    <p>${comment.text} <br></p>
                </div>
                <div id="btn-${comment.id}">
                    <p>AWAITING APPROVAL</p>
                    <button type="button" id="btn-approved" data-commentid="${comment.id}" class="btn-primary btn-xs">Approve</button>
                    <button type="button" id="btn-reject" data-commentid="${comment.id}" class="btn-primary btn-xs">Reject</button>
                </div>
            </g:if>
            <g:elseif test="${sec.username() == comment.user.username}">
                <p><b>Comment:</b></p>
                <p>Date Created: ${comment.dateCreated}</p>
                <p>${comment.text} <br></p>
                <p>AWAITING APPROVAL</p>
            </g:elseif>
        </g:elseif>
        <g:elseif test="${comment.pending == false}">
            <g:if test="${sec.username() == comment.user.username}">
                <p><span style="opacity:0.5;"><del><b>Comment:</b></del> </span></p>
                <p><span style="opacity:0.5;"><del>Date Created: ${comment.dateCreated}</del> </span></p>
                <p><span style="opacity:0.5;"><del>${comment.text}</del> </span><br></p>
            </g:if>
        </g:elseif>

%{--        <g:each var="reply" in="${comment.replies}">
            ${reply.text}
            ${reply.dateCreated}
        </g:each>

        <g:form controller="BlogEntry" params="[commentId:comment.id]">
            <label>Reply to Comment</label>
            <g:textField name="text"/><br/>
            <g:actionSubmit value="Post Reply" action="addReplyToComment"/>
        </g:form>--}%

    </g:each>


</body>

