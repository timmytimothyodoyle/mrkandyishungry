$(document).ready(function(){
	$('.modal').modal();
	$('ul.tabs').tabs();
	$('select').material_select();
});

//CONFIGURATION

$('.basic-config-save').click(function() {
	var checked = $('#ydb-editor-switch').prop('checked');
	if(checked) {
		$('.single-tab-editor-container').addClass('hide');
		$('.multi-tab-editor-container').removeClass('hide');
	} else {
		$('.multi-tab-editor-container').addClass('hide');
		$('.single-tab-editor-container').removeClass('hide');
	}
	$('#basic-config-modal').modal('close');
});

//CONFIGURATION

//OUTPUT

function addConsoleEntry(entry) {
	var severity = entry.severity == 'SEVERE' ? '<i class="material-icons">error</i>' : '<i class="material-icons">warning</i>';
	$('.ydb-console-table tbody').append(
			'<tr><td>Tab 1' +
			'</td><td>' + severity +
			'</td><td>' + entry.line + 
			'</td><td>' + entry.type +
			'</td><td>' + entry.reason +
			'</td></tr>');
}

function loadConsole(console) {	
	$('.ydb-console-table tbody').empty();
	if(console.conflicts.length == 0) {
		$('.ydb-console-table').addClass('hide');
	} else {
		for (i = 0; i < console.conflicts.length; i++) {
			addConsoleEntry(console.conflicts[i])
		}
		$('.ydb-console-table').removeClass('hide');
	}
}

function shitCounter(shit) {
	var count = '';
	for(var j = 0; j < shit.length; j++) {
		if(shit[j] == ' ')
			count += shit[j];
		else
			break;
	}
	return count;
}

function ultrasupercode(code) {
	var cool = '';
	var lines = code.split('\n');
	var goodindent = '';	
	for (var i = 0; i < lines.length; i++) {
		var line = lines[i];
		if(line.replace(/\s/g,'').startsWith('<')) {
			goodindent = shitCounter(line);
	    } else {
	    	var indent = shitCounter(line);
	    	if(goodindent.length > indent.length) {
	    		line = goodindent + '    ' + line.slice(indent.length);
	    	}
	    }
		cool += line + '\n';
	}
	return cool;
}

function loadEditConfig(code) {
	var supercode = vkbeautify.xml(code);
	var yeeeecode = ultrasupercode(supercode);
	ace.edit('touchui-editconfig-editor').setValue(yeeeecode);
}

function loadOutput(code) {
	var supercode = vkbeautify.xml(code);
	var yeeeecode = ultrasupercode(supercode);
	$('.ydb-output-container').removeClass('hide');
	ace.edit('touchui-dialog-editor').setValue(yeeeecode);
}

function loadEditor(code) {
	var supercode = vkbeautify.yaml(code);
}

$(document).ready(function(){
	createAceEditor('touchui-dialog-editor', 'ace/mode/xml');
	createAceEditor('touchui-content-editor', 'ace/mode/xml');
	createAceEditor('touchui-editconfig-editor', 'ace/mode/xml');
});

//OUTPUT