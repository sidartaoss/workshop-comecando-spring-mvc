$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoTitulo = button.data('codigo');
	var descricaoTitulo = button.data('descricao');
	
	/** alert(codigoTitulo); **/
	
	var modal = $(this);
	
	var form = modal.find('form');
	
	/** var action = form.attr('action'); **/
	var action = form.data('url-base');
	
	if (!action.endsWith('/')) {
		action += '/';
	}
	
	form.attr('action', action + codigoTitulo);
	
	modal.find('.modal-body span').html('Tem certeza de que deseja excluir o titulo <strong>' + descricaoTitulo + '</strong>?');
});

$(function() {
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});
	
	$('.js-atualizar-status').on('click', function(event) {
		
			event.preventDefault();
		
			/** console.log('clicou'); **/
			
			var botaoReceber = $(event.currentTarget);
			
			var urlReceber = botaoReceber.attr('href');
			
			/** console.log('urlReceber', urlReceber); **/
			
			var response = $.ajax({
				url: urlReceber,
				type: 'PUT'
			});
			
			response.done(function (e) {
				var codigoTitulo = botaoReceber.data('codigo');
				/** $('[data-role=' + codigoTitulo + ']').html('<span class="label label-success">Recebido</span>'); **/
				$('[data-role=' + codigoTitulo + ']').html('<span class="label label-success">' + e + '</span>');
				botaoReceber.hide();
			});
			
			response.fail(function(e) {
				console.log(e);
				alert('Erro recebendo cobranca');
			})
	});
	
	
});

