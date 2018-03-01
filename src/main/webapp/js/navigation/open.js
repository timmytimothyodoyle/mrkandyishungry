function openSimpleDialog(editor) {
	$('.multi-tab-editor-container').addClass('hide');
	$('.single-tab-editor-container').removeClass('hide');
	$('#ydb-editor-switch').prop('checked', false);

	editors[0].title = editor.title;
	editors[0].editor.setValue(soruyopopuyo(editor.items));
}

function openMultiDialog(parsed) {
	$('.multi-tab-editor-container').removeClass('hide');
	$('.single-tab-editor-container').addClass('hide');

	for (k = 0; k < parsed.editors.length; k++) {
		let editor = parsed.editors[k];
		let name = editor.name;
		let title = editor.title;

		$('.ace-editor-add-more').before(
				"<li class='tab'><a href='#" + name + "'>" + title
						+ "</a></li>");
		$('.multi-tab-editor-container')
				.append(
						"<div id='"
								+ name
								+ "' class='ydb-editor-container col s12' style='display:none'><div id='yeditor"
								+ k + "' class='ydb-editor'></div></div>");

		createAceEditor('yeditor' + k, 'ace/mode/yaml', name, title, true);
		ace.edit('yeditor' + k).setValue(soruyopopuyo(editor.items));
	}
	$('#ydb-editor-switch').prop('checked', true);
	$('.multi-tab-editor-container ul.tabs').tabs('select_tab',
			parsed.editors[0].name);
}

function openAsyncRequest(content) {
	if (!content) {
		Materialize.toast('There is nothing to save man! ', 4000);
	}
	$.post("/openyaml", {
		content : content,
	}).done(
			function(data) {
				let parsed = JSON.parse(data);

				$('#basic-config-modal #component-title').val(parsed.title);
				$('#basic-config-modal #component-group').val(parsed.group);

				if (!(parsed.editors && parsed.editors.length)) {
					Materialize.toast(
							'We fucked up!, no editors data retrived ', 4000);
				}
				if (parsed.editors.length == 1) {
					openSimpleDialog(parsed.editors[0]);
				} else {
					openMultiDialog(parsed);
				}
			}).fail(
			function(errors) {
				Materialize.toast(
						'We fucked up!, unable to open the project, reasons: '
								+ errors, 4000);
			});
}

$('#openProjectInput').change(function(event) {
	// open the selected project and
	$.get(URL.createObjectURL(event.target.files[0]), function(data) {
		openAsyncRequest(data);
	}, 'text');
});