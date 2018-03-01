
function exportAsyncRequest(yamlcode) {
	if(!yamlcode) {
		Materialize.toast('What a fuck man, there is no code to compile', 4000);
	}
	$.post("/export", {
		yamlcode : yamlcode
	}).done(function(data) {
		var result = JSON.parse(data);
		loadOutput(result.code.code);
		loadEditConfig(result.editConfig.code);
		loadConsole(result.console);
	}).fail(function(errors) {
		Materialize.toast('We fucked up!, errors while compiling the project: ' + errors, 4000);
	});
}

$('.ydb-compile').click(function() {
	// run the compiler
	exportAsyncRequest(getYamlCode());
});