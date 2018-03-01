
function saveAsyncRequest(yamlcode, destination) {
	if(!(yamlcode && destination)) {
		Materialize.toast('Dumb ass select a destination and add some code', 4000);
	}
	$.post("/saveyaml", {
		yamlcode : yamlcode,
		destination : destination
	}).done(function() {
		Materialize.toast('Project saved!', 4000);
	}).fail(function(errors) {
		Materialize.toast('We fucked up!, project not saved, reasons ' + errors, 4000);
	});
}

$('.ydb-save').click(function() {
	let destination = '/Users/sebastianvenere/Documents/workspace/kawasaki/osudio-kawasaki/diarrea.yaml';
	// save the current project
	saveAsyncRequest(getYamlCode(), destination);
});