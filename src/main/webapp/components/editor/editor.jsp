<div class="row ydb-editors-container">

	<div class='ydb-editor-container single-tab-editor-container col s12'>
		<div id="single-tab-editor" class='ydb-editor'></div>
	</div>
	
	<div class="multi-tab-editor-container hide">
		<ul class="tabs">
	        <li class="tab right ace-editor-add-more">Add Tab</li>
		</ul>
	</div>
</div>

<div id="add-ace-editor" class="modal">
	<div class="modal-content">
		<p>Specify the name and the title of the tab, otherwise a new tab will not be created</p>
		<div class="row">
			<div class="input-field col s12 m6">
				<input id="dialog-name" type="text">
				<label for="dialog-name" class="form-label-validation" data-error="Name is empty, complete the field" data-success="Well done Timmy!">Name</label>
			</div>
			<div class="input-field col s12 m6">
				<input id="dialog-title" type="text">
				<label for="dialog-title" class="form-label-validation" data-error="Title is empty, complete the field" data-success="Well done Timmy!">Title</label>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<a href="#" class="modal-action waves-effect waves-green btn-flat submit">Add</a>
	</div>
</div>