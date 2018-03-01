function soruyopopuyo(content) {
	if(content) {
		let cool = '';
		let lines = content.split('\n');
		if(lines.length > 0) {
			let space = shitCounter(lines[0]);
			for(i = 0; i < lines.length; i++) {
				let indent = shitCounter(lines[i]);
				let remove = indent.length > space.length ? space.length : indent.length;
				cool += lines[i].slice(remove) + '\n';
			}
		}
		return cool;
	}
	return "";
}