
public class Guest {

	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	
	public Guest() {
		this.lastName = null;
		this.firstName = null;
		this.email = null;
		this.phoneNumber = null;
	}
	
	public Guest(String lastName, String firstName, String email, String phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	//metoda este "case insensitive" si returneaza: '-1' daca a gasit o egalitate;
	//											    '0' daca nu a gasit nicio asemanare.
	public int equalsIgnoreCase(String str, String str2) {
		switch (str) {
			case "nume":
				if ((this.lastName + this.firstName).equalsIgnoreCase(str2)) {
					return -1;
				}
				break;
			case "email":
				if (this.email.equalsIgnoreCase(str2)) {
					return -1;
				}
				break;
			case "phoneNumber":
				if (this.phoneNumber.equalsIgnoreCase(str2)) {
					return -1;
				}
				break;
			case "lastName":
				if(this.lastName.equalsIgnoreCase(str2)) {
					return -1;
				}
				break;
			case "firstName":
				if(this.firstName.equalsIgnoreCase(str2)) {
					return -1;
				}
				break;
			default:
				break;
		}
		return 0;
	}

}
