<div class="row">
	<h4>Yaml Dialog Builder (YDB)</h4>
   	<p class="flow-text">I am a very simple card. I am good at containing small bits of information.
       	I am convenient because I require little markup to use effectively. I am similar to what is called a panel in other frameworks.
	</p>
	<a class="waves-effect waves-light btn" href="#basic-config-modal">Basics</a>

	<!-- Modal Structure -->
	<div id="basic-config-modal" class="modal">
		<div class="modal-content">
			<h4>Dialog basic configuration</h4>
			<p>A bunch of text</p>

			<div class="row">
				
				<div class="switch col s12 ydb-editor-switch-container">
					<label>Single<input type="checkbox" id="ydb-editor-switch"><span class="lever"></span>Multitab</label>
		  		</div>
		  		<br>
				<div class="input-field col s12">
					<select multiple>
						<option value="0">None</option>
					    <option value="1">Option 1</option>
					    <option value="2">Option 2</option>
					    <option value="3">Option 3</option>
					</select>
					<label>Import YAML dialogs</label>
				</div>

				<div class="input-field col s12 m6">
			    	<input id="component-title" type="text" class="validate">
			        <label for="component-title">Title</label>
				</div>
				
				<div class="input-field col s12 m6">
					<input id="component-group" type="text" class="validate">
					<label for="component-group">Group</label>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#!" class="modal-action waves-effect waves-green btn-flat basic-config-save">Save</a>
		</div>
	</div>
</div>