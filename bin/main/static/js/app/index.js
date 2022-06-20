let main = {
    init : function(){
        let _this = this;
        $('#btn-save').on("click", function(){
            _this.save();
        })
        $('#btn-update').on("click", function(){
            _this.update();
        })
    },
    save : function(){
        let data = {
            title: $('#title').val(),
            content: $("#content").val(),
            author: $("#author").val()
        };

        $.ajax({
            data : JSON.stringify(data),
            type : "POST",
            url : "/api/v1/posts",
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
        }).done(function(){
            alert("글이 등록 되었습니다");
            window.location.href = "/";
        }).fail(function(error){
            alert(JSON.springity(error));
        })
    },
    update : function(){
        let id = $("#id").val();
        let data = {
            title: $('#title').val(),
            content: $("#content").val()
        };

        $.ajax({
            data : JSON.stringify(data),
            type : "PUT",
            url : "/api/v1/posts/"+id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
        }).done(function(){
            alert("글이 수정 되었습니다");
            window.location.href = "/";
        }).fail(function(error){
            alert(JSON.springity(error));
        })
    }
    
};
main.init();