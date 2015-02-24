//Login FORM
$(document).ready(function() {
    $(window).on('load', function () {
        var $preloader = $('#page-preloader'),
        $spinner = $preloader.find('.spinner');
        $spinner.fadeOut();
        $preloader.delay(400).fadeOut('slow');
    });    
    
    var Token = localStorage.getItem('Token');
    
    if (Token != null) {
        $('#loginForm').css('display', 'none');
        $('.orders').css('display', 'none');
        $.ajax({ 
            type: 'GET', 
            url: 'api/Contacts/index/' + Token, 
            data: {}, 
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                $.get('template/contacts.html', function(template){
                    var mass = [];
                    $.each(data, function(index, e) {
                        var content = template.supplant(e);
                        //console.log(content);
                        mass[mass.length] = content;
                    });
                    console.log();
                    $('.contacts div')[0].innerHTML = mass.join('');
                });

                console.log(data);
            }
        });
        
        String.prototype.supplant = function(o) {
           return this.replace(/\{([^{}]*)\}/g, function(a, b) {
              var r = o[b];
              return typeof r === 'string' || typeof r === 'number' ? r : a;
           });
        };
        
        $('body').delegate('.contacts div a', 'click', function() {
            $('.contacts').css('display', 'none');
            $('.orders').css('display', 'block');
            console.log('aeae');
            var ID = $(this).attr('data-id');
            $.ajax({ 
                type: 'GET', 
                url: 'api/Orders/client/' + Token + ':' + ID, 
                data: {}, 
                dataType: 'json',
                contentType: 'application/json',
                success: function (data) {
                    $.each(data, function(index, element) {
                        $('.orders div').append('<a class="list-group-item" data-id="'+data[index].ID+'">'+data[index].Company+' - '+data[index].Service+' <span class="pull-right">'+data[index].Date+'</span></a>');
                    });
                    console.log(data);
                }
            });            
            
        });
        
    } else {
        $(function(){
            $('.contacts').css('display', 'none');
            $('.orders').css('display', 'none');
            var form = $('#loginForm');
            $('#loginForm').submit(function () {
                var email = $("input[name=email]").val();
                var password = $("input[name=password]").val();
                if ($('#login').hasClass('disabled')) return false;
                $('#login').addClass('disabled');
                $.ajax({ 
                    type: 'GET', 
                    url: 'api/User/login/' + email +':'+ password, 
                    data: {}, 
                    dataType: 'json',
                    contentType: 'application/json',
                    success: function (data) {
                        $.each(data, function(index, element) {
                            if (data.Request == true) {
                                $('#login').removeClass('disabled');
                                localStorage.setItem("Token", data.Token);
                                location.reload();
                            }   
                        });
                        
                    }
                });
                return false;
            })
        });        
    }
});