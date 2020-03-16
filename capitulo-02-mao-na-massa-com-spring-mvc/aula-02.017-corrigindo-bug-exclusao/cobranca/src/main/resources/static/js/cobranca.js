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