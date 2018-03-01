var count = 0;
var editors = [];

function createAceEditor(containerid, editortype, name = 'default', title = 'default', save = false) {
	var editor = ace.edit(containerid);
	editor.setTheme('ace/theme/monokai');
	editor.getSession().setMode(editortype);
	if(save)
		editors.push({ 'editor': editor, 'name' : name, 'title' : title});
	count++;
}

function validateTitle(title) {
	var message = 'Something is wrong, your welcome for the explanation';
	if(title) {
		var vtitle = title.val();
		if(vtitle) {
			title.removeClass('invalid');
			title.addClass('valid');
			return true;		
		} else {
			message = 'Name is empty, complete the field';
		}
	}
	title.removeClass('valid');
	title.addClass('invalid');
	title.siblings('label').attr('data-error', message);	
}

function validateName(name) {
	var message = 'Something is wrong, your welcome for the explanation';
	if(name) {
		var vname = name.val();
		if(vname) {
			if(vname.indexOf(' ') >= 0) {
				message = 'No white space please';
			} else {
				name.removeClass('invalid');
				name.addClass('valid');
				return true;
			}			
		} else {
			message = 'Name is empty, complete the field';
		}
	}
	name.removeClass('valid');
	name.addClass('invalid');
	name.siblings('label').attr('data-error', message);	
}

function cleanValidableInput(item) {
	item.val('');
	item.removeClass('valid');
	item.removeClass('invalid');
}

$('#add-ace-editor #dialog-name').change(function() {
	validateName($(this));
});

$('#add-ace-editor #dialog-title').change(function() {
	validateTitle($(this));
});

$('.ace-editor-add-more').click(function() {
	// clean previous values from model
	cleanValidableInput($('#add-ace-editor #dialog-name'));
	cleanValidableInput($('#add-ace-editor #dialog-title'));
	// display modal
	$('#add-ace-editor').modal('open');
});

$('#add-ace-editor .modal-action').click(function() {
	// check if they are valid
	var eName = $('#add-ace-editor #dialog-name');
	var eTitle = $('#add-ace-editor #dialog-title');
	if(eName.hasClass('valid') && eTitle.hasClass('valid')) {
		var id = 'yeditor' + count;
		var name = eName.val();
		var title = eTitle.val();
		
		$('.ace-editor-add-more').before("<li class='tab'><a href='#" + name + "'>" + title + "</a></li>");
		$('.multi-tab-editor-container').append("<div id='" + name + "' class='ydb-editor-container col s12'><div id='" + id + "' class='ydb-editor'></div></div>");
		
		$('.multi-tab-editor-container ul.tabs').tabs('select_tab', name);
		createAceEditor(id, 'ace/mode/yaml', name, title, true);
		count++;
		$('#add-ace-editor').modal('close');
	}
});

// initialize the single tab ACE editor
createAceEditor('single-tab-editor', 'ace/mode/yaml', 'simple-panel', 'Configuration', true);