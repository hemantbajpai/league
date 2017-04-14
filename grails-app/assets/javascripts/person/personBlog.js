$(function() {

    $('#btn-approved').on('click', function(event){
        var button = $(event.relatedTarget),
            commentId = $(this).data('commentid');

        var request = $.ajax({
            url: '/blogEntry/approveComment/'+commentId+ '?format=json',
            method: 'POST'
        });
        request.done(function(data){
            $('#btn-'+data.id)[0].parentNode.removeChild($('#btn-'+data.id)[0])
            console.log("success")
        });
        request.fail(function(data){
            console.log("failed")
        });
    });

    $('#btn-reject').on('click', function(event){
        var button = $(event.relatedTarget),
            commentId = $(this).data('commentid');

        var request = $.ajax({
            url: '/blogEntry/rejectComment/'+commentId+ '?format=json',
            method: 'POST'
        });
        request.done(function(data){
            $('#'+data.id)[0].parentNode.removeChild($('#'+data.id)[0])
            $('#btn-'+data.id)[0].parentNode.removeChild($('#btn-'+data.id)[0])
            console.log("success")
        });
        request.fail(function(data){
            console.log("failed")
        });
    });

    $('#btn-reply-approved').on('click', function(event){
        var button = $(event.relatedTarget),
            replyId = $(this).data('replyid');

        var request = $.ajax({
            url: '/blogEntry/approveReply/'+replyId+ '?format=json',
            method: 'POST'
        });
        request.done(function(data){
            $('#btn-reply-'+data.id)[0].parentNode.removeChild($('#btn-reply-'+data.id)[0])
            console.log("success")
        });
        request.fail(function(data){
            console.log("failed")
        });
    });

    $('#btn-reply-reject').on('click', function(event){
        var button = $(event.relatedTarget),
            replyId = $(this).data('replyid');

        var request = $.ajax({
            url: '/blogEntry/rejectReply/'+replyId+ '?format=json',
            method: 'POST'
        });
        request.done(function(data){
            $('#reply'+data.id)[0].parentNode.removeChild($('#reply'+data.id)[0])
            $('#btn-reply-'+data.id)[0].parentNode.removeChild($('#btn-reply-'+data.id)[0])
            console.log("success")
        });
        request.fail(function(data){
            console.log("failed")
        });
    });
});
