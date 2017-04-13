$(function() {

    $('#btn-approved').on('click', function(event){
        var button = $(event.relatedTarget),
            commentId = $(this).data('commentid');

        var request = $.ajax({
            url: '/blogEntry/approved/'+commentId+ '?format=json',
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
            url: '/blogEntry/reject/'+commentId+ '?format=json',
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
});
