function deleteEntry(link) {
	var confirmResult = confirm("Wollen sie diesen Eintrag wirklich löschen?");
	if(confirmResult == true) {
		self.location=link;
	}
}

function confirmRollback(link) {
	var confirmResult = confirm("Wollen sie diesen Rollback wirklich ausführen?");
	if(confirmResult == true) {
		self.location=link;
	}
}

function changeTo(link) {
	self.location=link;
}
