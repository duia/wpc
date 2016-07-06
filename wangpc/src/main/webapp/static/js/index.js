$(function() {
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		// Variables privadas
		var links = this.el.find('.link');
		// Evento
		links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
	}

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
			$this = $(this),
			$next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
		};
	}	

	var accordion = new Accordion($('#accordion'), false);
	$.ajax({
        type: 'GET',
        url: 'buttons',
        dataType: 'html',	
        success: function(data) {
            $('#ajax-content').html(data);
            $('html, body').animate({
                scrollTop: $("body").offset().top
            }, 250);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            $('#ajax-content').html(default_content);
        }
    });
});