var count = 2;
var editors = [];

function createAceEditor(containerid, editortype, save) {
	var editor = ace.edit(containerid);
	editor.setTheme('ace/theme/monokai');
	editor.getSession().setMode(editortype);
	if (save)
		editors.push(editor);
}

function addConsoleEntry(entry) {
	$('.yaml-console-table-body').append(
			'<tr><td>Tab 1' +
			'</td><td>' + entry.severity +
			'</td><td>' + entry.line + 
			'</td><td>' + entry.type +
			'</td><td>' + entry.reason +
			'</td></tr>');
}

function loadExport(code) {
	$('.yaml-export').show();
	ace.edit('touchui-editor').setValue(code);
}

function loadConsole(console) {
	$('.yaml-console-table-body').empty();
	if(console.conflicts.length == 0) {
		$('.yaml-console-container').hide();
	} else {
		for (i = 0; i < console.conflicts.length; i++) {
			addConsoleEntry(console.conflicts[i])
		}
		$('.yaml-console-container').show();
	}
}

function exportAsyncRequest(yamlcode) {

	$.post("/export", {
		yamlcode : yamlcode,
		title : 'sorete'
	}).done(function(data) {
		var result = JSON.parse(data);
		loadExport(result.code.code);
		loadConsole(result.console);
	}).fail(function() {
		alert('mal');
	});
};

$('.add-yaml-editor').click(
		function() {
			$(this).before(
					"<li><a data-toggle='tab' href='#yaml-tab-" + count
							+ "'>Tab " + count + "</a></li>");
			$('#yaml-editors').append(
					"<div id='yaml-tab-" + count
							+ "' class='tab-pane fade'><div id='yeditor"
							+ count + "' class='yaml-editor'></div></div>");
			createAceEditor('yeditor' + count, 'ace/mode/yaml', true);
			count++;
		});

$('.btn-compile').click(function() {
	var yamlcode = '';
	for (i = 0; i < editors.length; i++) {
		var code = editors[i].getValue();
		if (i > 0)
			yamlcode += "\n---\n";
		yamlcode += code;
	}
	exportAsyncRequest(yamlcode);
});

createAceEditor('yeditor', 'ace/mode/yaml', true);
createAceEditor('touchui-editor', 'ace/mode/xml', false);