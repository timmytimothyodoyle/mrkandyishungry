function val(element, defaultvalue) {
	return element.val() ? element.val() : defaultvalue;
}

function getYamlCode() {
	let title = val($('#component-title'), 'notitle');
	let group = val($('#component-group'), 'nogroup');	

	let yamlcode = "!dialog\n  title: '" + title + "'\n  group: '" + group + "'\n  items:\n";
	let multitab = $('#ydb-editor-switch').prop('checked');
	
	if(multitab) {
		for (i = 1; i < editors.length; i++) {
			let editor = editors[i];
			let code = editor.editor.getValue();

			yamlcode += "    - !panel\n      name: '" + editor.name + "'\n      title: '" + editor.title + "'\n      items:\n";
			
			let lines = code.split('\n');
			let goodindent = '      ';	
			for (var j = 0; j < lines.length; j++) {
				yamlcode += goodindent + lines[j] + '\n';
			}
		}
	} else {
		yamlcode += "    - !panel\n      name: 'simple-panel'\n      title: '" + title + "'\n      items:\n";
		let code = editors[0].editor.getValue();
		
		let lines = code.split('\n');
		let goodindent = '      ';	
		for (var j = 0; j < lines.length; j++) {
			yamlcode += goodindent + lines[j] + '\n';
		}
	}
	return yamlcode;
}
