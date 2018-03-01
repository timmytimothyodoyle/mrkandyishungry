
$('.basic-config-save').click(function() {
	if($('#ydb-editor-switch').prop('checked')) {
		$('.single-tab-editor-container').hide();
		$('.multi-tab-editor-container').show();
	} else {
		$('.multi-tab-editor-container').hide();		
		$('.single-tab-editor-container').show();
	}
	$('#basic-config-modal').modal('close');
});