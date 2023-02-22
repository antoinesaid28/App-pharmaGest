package GestionPharmacie;

public enum CRUDMode {
	// ADD,
	// UPDATE,
	// DELETE,
	// QUIT,
	// LISTALLSTUDENTS,
	// INVALID,

	ADD("Add User"),
	UPDATE("Update User"),
	DELETE("Delete User"),
	QUIT("Exit Program"),
	LISTALLSTUDENTS("List Users"),
	INVALID("Option Invalid");

	String CRUDModeNme;

	private CRUDMode(String CRUDModeName) {
		this.CRUDModeNme = CRUDModeName;

	}

}
