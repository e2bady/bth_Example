function deleteEntry(link) {
	var confirmResult = confirm("Wollen sie diesen Eintrag wirklich l�schen?");
	if(confirmResult == true) {
		self.location=link;
	}
}

function confirmRollback(link) {
	var confirmResult = confirm("Wollen sie diesen Rollback wirklich ausf�hren?");
	if(confirmResult == true) {
		self.location=link;
	}
}

function changeTo(link) {
	self.location=link;
}
