import java.util.ArrayList;

public class GuestsList {

	private  ArrayList<Guest> guestList = new ArrayList<Guest>();
	private  ArrayList<Guest> waitList = new ArrayList<Guest>();
	private  int noSeats;
	
	public GuestsList(String n) {
		this.noSeats = Main.inputNoSeats(n);
	}
	
	public int getNoSeats() {
		return noSeats;
	}

	// adauga un element in lista
	// verifica daca elementul este deja in lista
	// verific daca mai sunt locuri disponibile la eveniment si-l adauga si-l notifica
	// daca nu, tot il adauga dar cu specificatia ca se afla in lista de asteptare
	public int add(String lastName, String firstName, String email, String phoneNumber) {

		Guest guest = new Guest(lastName, firstName, email, phoneNumber);

		for (int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).equalsIgnoreCase("nume", lastName + firstName) == -1) {
				System.out.println("Persoana cu numele \"" + lastName + "\" si prenumele \"" + firstName + "\" se afla deja in lista de participanti.");
				return -1;
			}
			if(guestList.get(i).equalsIgnoreCase("email", email) == -1) {
				System.out.println("Persoana cu email-ul \"" + email + "\" se afla deja in lista de participanti.");
				return -1;
			}
			if(guestList.get(i).equalsIgnoreCase("phoneNumber", phoneNumber) == -1) {
				System.out.println("Persoana cu numarul de telefon \"" + phoneNumber + "\" se afla deja in lista de participanti.");
				return -1;
			}
		}
		
		for (int i = 0; i < waitList.size(); i++) {
			if(waitList.get(i).equalsIgnoreCase("nume", lastName + firstName) == -1) {
				System.out.println("Persoana cu numele \"" + lastName + "\" si prenumele \"" + firstName + "\" se afla deja in lista de asteptare.");
				return -1;
			}
			if(waitList.get(i).equalsIgnoreCase("email", email) == -1) {
				System.out.println("Persoana cu email-ul \"" + email + "\" se afla deja in lista de asteptare.");
				return -1;
			}
			if(waitList.get(i).equalsIgnoreCase("phoneNumber", phoneNumber) == -1) {
				System.out.println("Persoana cu numarul de telefon \"" + phoneNumber + "\" se afla deja in lista de asteptare.");
				return -1;
			}
		}

		if(guestList.size() < noSeats) {
			guestList.add(guest);
			System.out.println("[" + guest.getLastName() + " " + guest.getFirstName() + "] " + "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			return 0;
		} else {
			waitList.add(guest);
			System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine "
					+ (waitList.indexOf(guest) + 1) + ". \nTe vom notifica daca un loc devine disponibil.");
			return waitList.indexOf(guest) + 1;
		}
	}

	//verifica dupa numele complet
	public boolean checkByName(String lastName, String firstName) {
		for(int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).equalsIgnoreCase("nume", lastName + firstName) == -1) {
				System.out.println("Persoana cu numele \"" + lastName + "\" si prenumele \"" + firstName + "\" se afla deja in lista de participanti.");
				return true;
			}
		}
		for(int i = 0; i < waitList.size(); i++) {
			if(waitList.get(i).equalsIgnoreCase("nume", lastName + firstName) == -1) {
				System.out.println("Persoana cu numele \"" + lastName + "\" si prenumele \"" + firstName + "\" se afla deja in lista de asteptare.");
				return true;
			}
		}
		return false;
	}

	//verifica dupa email
	public boolean checkByEmail(String email) {
		for(int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).equalsIgnoreCase("email", email) == -1) {
				System.out.println("Persoana cu email-ul \"" + email + "\" se afla deja in lista de participanti.");
				return true;
			}
			
		}
		for(int i = 0; i < waitList.size(); i++) {
			if(waitList.get(i).equalsIgnoreCase("email", email) == -1) {
				System.out.println("Persoana cu email-ul \"" + email + "\" se afla deja in lista de asteptare.");
				return true;
			}
			
		}
		return false;
	}

	//verifica dupa numarul de telefon
	public boolean checkByPhoneNumber(String phoneNumber) {
		for(int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).equalsIgnoreCase("phoneNumber", phoneNumber) == -1) {
				System.out.println("Persoana cu numarul de telefon \"" + phoneNumber + "\" se afla deja in lista de participanti.");
				return true;
			}
		}
		for(int i = 0; i < waitList.size(); i++) {
			if(waitList.get(i).equalsIgnoreCase("phoneNumber", phoneNumber) == -1) {
				System.out.println("Persoana cu numarul de telefon \"" + phoneNumber + "\" se afla deja in lista de asteptare.");
				return true;
			}
		}
		return false;
	}

	//metoda sterge un participant dupa nume si muta prima pozitie din lista de asteptare in lista de participanti
	public boolean removeByName(String lastName, String firstName) {
		for(int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).equalsIgnoreCase("nume", lastName + firstName) == -1) {
				guestList.remove(i);
				System.out.println("Persoana a fost stearsa cu succes!");
				if(waitList.size() != 0) {
					System.out.println("Persoana cu numele \"" + waitList.get(0).getLastName() + "\" si prenumele \"" + waitList.get(0).getFirstName()
							+ "\" cu numarul de ordine \"" + 1 + "\" a fost mutata din lista de asteptare in lista de participanti.");
					guestList.add(waitList.get(0));
					waitList.remove(0);
				}
				return true;
			}
		}
		for (int i = 0; i < waitList.size(); i++) {
			if(waitList.get(i).equalsIgnoreCase("nume", lastName + firstName) == -1) {
				waitList.remove(i);
				System.out.println("Persoana a fost stearsa cu succes!");
				return true;
			}
		}
		System.out.println("Eroare: persoana nu era inscrisa");
		return false;
	}

	//metoda sterge un participant dupa email si muta prima pozitie din lista de asteptare in lista de participanti
	public boolean removeByEmail(String email) {
		for(int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).equalsIgnoreCase("email", email) == -1) {
				guestList.remove(i);
				System.out.println("Persoana a fost stearsa cu succes!");
				if(waitList.size() != 0) {
					System.out.println("Persoana cu numele \"" + waitList.get(0).getLastName() + "\" si prenumele \"" + waitList.get(0).getFirstName()
							+ "\" cu numarul de ordine \"" + 1 + "\" a fost mutata din lista de asteptare in lista de participanti.");
					guestList.add(waitList.get(0));
					waitList.remove(0);
				}
				return true;
			}
		}
		for (int i = 0; i < waitList.size(); i++) {
			if(waitList.get(i).equalsIgnoreCase("email", email) == -1) {
				waitList.remove(i);
				System.out.println("Persoana a fost stearsa cu succes!");
				return true;
			}
		}
		System.out.println("Eroare: persoana nu era inscrisa");
		return false;
	}

	//metoda sterge un participant dupa numarul de telefon si muta prima pozitie din lista de asteptare in lista de participanti
	public boolean removeByPhoneNumber(String phoneNumber) {
		for(int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).equalsIgnoreCase("phoneNumber", phoneNumber) == -1) {
				guestList.remove(i);
				System.out.println("Persoana a fost stearsa cu succes!");
				if(waitList.size() != 0) {
					System.out.println("Persoana cu numele \"" + waitList.get(0).getLastName() + "\" si prenumele \"" + waitList.get(0).getFirstName()
							+ "\" cu numarul de ordine \"" + 1 + "\" a fost mutata din lista de asteptare in lista de participanti.");
					guestList.add(waitList.get(0));
					waitList.remove(0);
				}
				return true;
			}
		}
		for (int i = 0; i < waitList.size(); i++) {
			if(waitList.get(i).equalsIgnoreCase("phoneNumber", phoneNumber) == -1) {
				waitList.remove(i);
				System.out.println("Persoana a fost stearsa cu succes!");
				return true;
			}
		}
		System.out.println("Eroare: persoana nu era inscrisa");
		return false;
	}

	//afiseaza numarul de participanti
	public void sizeOfTheGuestList() {
		System.out.println("Numarul de participanti: " + guestList.size());
	}
	//afiseaza numarul de persoane in lista de asteptare
	public void sizeOfTheWaitList() {
		if(waitList.size() == 0) {
			System.out.println("Dimensiunea listei este goala.");
		} else {
			System.out.println(waitList.size());
		}
	}

	//metoda cauta dupa numele de familie si returneaza un obiect de tip Guest
	public Guest searchByLastNameAfterGuest(String lastName) {
		for (int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).equalsIgnoreCase("lastName", lastName) == -1) {
				return guestList.get(i);
			}
		}
		for (int i = 0; i < waitList.size(); i++) {
			if(waitList.get(i).equalsIgnoreCase("lastName", lastName) == -1) {
				return waitList.get(i);
			}
		}
		System.out.println("Eroare: persoana nu era inscrisa");
		return null;
	}

	//metoda cauta dupa prenume si returneaza un obiect de tip Guest
	public Guest searchByFirstNameAfterGuest(String firstName) {
		for (int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).equalsIgnoreCase("firstName", firstName) == -1) {
				return guestList.get(i);
			}
		}
		for (int i = 0; i < waitList.size(); i++) {
			if(waitList.get(i).equalsIgnoreCase("firstName", firstName) == -1) {
				return waitList.get(i);
			}
		}
		System.out.println("Eroare: persoana nu era inscrisa");
		return null;
	}

	//metoda cauta dupa email si returneaza un obiect de tip Guest
	public Guest searchByEmailAfterGuest(String email) {
		for(int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).equalsIgnoreCase("email", email) == -1) {
				return guestList.get(i);
			}
		}
		for (int i = 0; i < waitList.size(); i++) {
			if(waitList.get(i).equalsIgnoreCase("email", email) == -1) {
				return waitList.get(i);
			}
		}
		System.out.println("Eroare: persoana nu era inscrisa");
		return null;
	}

	//metoda cauta dupa numarul de telefon si returneaza un obiect de tip Guest
	public Guest searchByPhoneNumberAfterGuest(String phoneNumber) {
		for(int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).equalsIgnoreCase("phoneNumber", phoneNumber) == -1) {
				return guestList.get(i);
			}
		}
		for (int i = 0; i < waitList.size(); i++) {
			if(waitList.get(i).equalsIgnoreCase("phoneNumber", phoneNumber) == -1) {
				return waitList.get(i);
			}
		}
		System.out.println("Eroare: persoana nu era inscrisa");
		return null;
	}

	//metoda seteaza numele de familie
	public void settingLastName(String lastName, String desiredLastName) {
		searchByLastNameAfterGuest(lastName).setLastName(desiredLastName);
	}
	//metoda seteaza prenumele
	public void settingFirstName(String firstName, String desiredFirstName) {
		searchByFirstNameAfterGuest(firstName).setFirstName(desiredFirstName);
	}

	//metoda seteaza emailul
	public void settingEmail(String email, String desiredEmail) {
		searchByEmailAfterGuest(email).setEmail(desiredEmail);
	}

	//metoda seteaza numarul de telefon
	public void settingPhoneNumber(String phoneNumber, String desiredPhoneNumber) {
		searchByPhoneNumberAfterGuest(phoneNumber).setEmail(desiredPhoneNumber);
	}

	//printeaza participantii la eveniment
	public void guests() {
		int n = 1;
		if(guestList.size() == 0) {
			System.out.println("Niciun participant inscris...");
		} else {
			for(int i = 0; i < guestList.size(); i++) {
				System.out.println("Participantul de pe pozitia " + n++);
				System.out.println(guestList.get(i).getLastName());
				System.out.println(guestList.get(i).getFirstName());
				System.out.println(guestList.get(i).getEmail());
				System.out.println(guestList.get(i).getPhoneNumber());
				System.out.println();
			}
		}
	}
	
	//printeaza persoanele din lista de asteptare
	public void waitlist() {
		int n = 1;
		if(waitList.size() == 0) {
			System.out.println("Lista de asteptare este goala.");
		} else {
			for(int i = 0; i < waitList.size(); i++) {
				System.out.println("Participantul de pe pozitia " + n++);
				System.out.println(waitList.get(i).getLastName());
				System.out.println(waitList.get(i).getFirstName());
				System.out.println(waitList.get(i).getEmail());
				System.out.println(waitList.get(i).getPhoneNumber());
				System.out.println();
			}
		}
	}
	
	//metoda returneaza numarul de locuri disponibile la eveniment
	public int seatsAvailable() {
		return noSeats - guestList.size();
	}
	
	//metoda returneaza numarul de persoane inscrise la eveniment
	public int persons() {
		return guestList.size() + waitList.size();
	}
	
	//metoda cauta in functie de sirul de caractere introdus prin ambele liste
	//si returneaza toate datele persoanelor care au cel putin un camp care respecta sirul introdus
	public void search(String str) {
		str = str.toLowerCase();
		boolean isInGuestList = false;
		boolean isInWaitlist = false;
		for(int i = 0; i < guestList.size(); i++) {
			if(guestList.get(i).getLastName().toLowerCase().contains(str)) {
				System.out.println("Din lista de participanti:");
				System.out.println(guestList.get(i).getLastName());
				System.out.println(guestList.get(i).getFirstName());
				System.out.println(guestList.get(i).getEmail());
				System.out.println(guestList.get(i).getPhoneNumber());
				System.out.println();
				isInGuestList = true;
				
			} else if(guestList.get(i).getFirstName().toLowerCase().contains(str)) {
				System.out.println("Din lista de participanti:");
				System.out.println(guestList.get(i).getLastName());
				System.out.println(guestList.get(i).getFirstName());
				System.out.println(guestList.get(i).getEmail());
				System.out.println(guestList.get(i).getPhoneNumber());
				System.out.println();
				isInGuestList = true;
				
			} else if(guestList.get(i).getEmail().toLowerCase().contains(str)) {
				System.out.println("Din lista de participanti:");
				System.out.println(guestList.get(i).getLastName());
				System.out.println(guestList.get(i).getFirstName());
				System.out.println(guestList.get(i).getEmail());
				System.out.println(guestList.get(i).getPhoneNumber());
				System.out.println();
				isInGuestList = true;
				
			} else if(guestList.get(i).getPhoneNumber().toLowerCase().contains(str)) {
				System.out.println("Din lista de participanti:");
				System.out.println(guestList.get(i).getLastName());
				System.out.println(guestList.get(i).getFirstName());
				System.out.println(guestList.get(i).getEmail());
				System.out.println(guestList.get(i).getPhoneNumber());
				System.out.println();
				isInGuestList = true;
			}
		}
			
		for(int j = 0; j < waitList.size(); j++) {
			if(waitList.get(j).getLastName().toLowerCase().contains(str)) {
				System.out.println("Din lista de asteptare:");
				System.out.println(waitList.get(j).getLastName());
				System.out.println(waitList.get(j).getFirstName());
				System.out.println(waitList.get(j).getEmail());
				System.out.println(waitList.get(j).getPhoneNumber());
				System.out.println();
				isInWaitlist = true;
						
			} else if(waitList.get(j).getFirstName().toLowerCase().contains(str)) {
				System.out.println("Din lista de asteptare:");
				System.out.println(waitList.get(j).getLastName());
				System.out.println(waitList.get(j).getFirstName());
				System.out.println(waitList.get(j).getEmail());
				System.out.println(waitList.get(j).getPhoneNumber());
				System.out.println();
				isInWaitlist = true;
					
			} else if(waitList.get(j).getEmail().toLowerCase().contains(str)) {
				System.out.println("Din lista de asteptare:");
				System.out.println(waitList.get(j).getLastName());
				System.out.println(waitList.get(j).getFirstName());
				System.out.println(waitList.get(j).getEmail());
				System.out.println(waitList.get(j).getPhoneNumber());
				System.out.println();
				isInWaitlist = true;
						
			} else if(waitList.get(j).getPhoneNumber().toLowerCase().contains(str)) {
				System.out.println("Din lista de asteptare:");
				System.out.println(waitList.get(j).getLastName());
				System.out.println(waitList.get(j).getFirstName());
				System.out.println(waitList.get(j).getEmail());
				System.out.println(waitList.get(j).getPhoneNumber());
				System.out.println();
				isInWaitlist = true;
			}
		}
		if(isInGuestList == false && isInWaitlist == false) {
			System.out.println("Nu s-a gasit niciun rezultat.");
		}
	}
}
