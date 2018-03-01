<!DOCTYPE html>
<html lang="en">

<head>

<title>AEM YAML Dialog</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link type="text/css" rel="stylesheet" href="/css/bootstrap.min.css"
	media="screen,projection" />

<link type="text/css" rel="stylesheet" href="/css/yamldialog.css"
	media="screen,projection" />
	
</head>

<body>

	<div class="container">

		<div class="row">
			<h1>AEM YAML dialog builder</h1>
			<p>In touch UI you need to define different kind of containers
				and layouts just to add a simple text field. This can introduce a
				lot of errors (more if the dialog is complex) while creating the
				dialog that causes the development of the component to be harder.</p>
		</div>

		<div class="row yaml-configuration">
			<div class="btn-group right" role="group">
				<button type="button" class="btn btn-default">Open YAML</button>
				<button type="button" class="btn btn-default">Configuration</button>
			</div>
		</div>

		<div class="row">

			<div class="form-inline">
				<div class="form-group">
					<label for="dialog-title">Dialog title</label> <input type="text"
						class="form-control" id="dialog-title" placeholder="Title">
				</div>
				<div class="form-group right">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" type="button"
							id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="true">
							Import <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">productsection</a></li>
							<li><a href="#">skyseason</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="row yaml-editors-container">
			<div class="yaml-tab-container">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#yaml-tab-1">Tab
							1</a></li>
					<li class="add-yaml-editor"><a href="#">+</a></li>
				</ul>
				<div id="yaml-editors" class="tab-content">
					<div id="yaml-tab-1" class="tab-pane fade in active">
						<div id="yeditor" class="yaml-editor"></div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row yaml-console-container">
			<div class="yaml-console-header">
				console
			</div>
			<div class="yaml-console-table">
				<table>
					<thead>
						<tr>
							<th>tab</th>
							<th>severity</th>								
							<th>line</th>
							<th>where</th>
							<th>reason</th>
						</tr>
					</thead>
					<tbody class="yaml-console-table-body">
						<tr>
							<td>Tab</td>
							<td>E</td>
							<td>Alvin</td>
							<td>Eclair</td>
							<td>$0.87</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="btn-group" role="group">
				<button type="button" class="btn btn-default btn-compile">Compile</button>
				<button type="button" class="btn btn-default btn-save">Save
					All</button>
				<button type="button" class="btn btn-default btn-save">Save
					Yaml</button>
				<button type="button" class="btn btn-default btn-save">Save
					Classic</button>
				<button type="button" class="btn btn-default btn-save">Save
					Touch</button>
			</div>
		</div>

		<div class="row yaml-export">
			<div id="touchui-editor" class="yaml-editor"></div>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/ace/1.2.6/min/ace.js"
	type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/yamldialog.js"></script>


</body>

</html>