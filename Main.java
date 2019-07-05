import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static int inputNoSeats(String n) {
		boolean quit = false;
		int number = 0;
		while(quit == false) {
			boolean isNumber = true;
			for(int i = 0; i < n.length(); i++) {
				if(Character.isDigit(n.charAt(i)) == false) {
					System.out.println("Introduceti un numar natural mai mare decat 0:");
					isNumber = false;
					break;
				}
			}
			if(isNumber) {
				number = Integer.parseInt(n);
				quit = true;
			} else {
				n = sc.next();
			}
		}
		return number;
	}

	public static void main(String[] args) {
		System.out.println("Hello, human!");
		System.out.println();
		System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
	
		GuestsList list = new GuestsList(sc.next());
		
		System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
		String respond = sc.next();
		
		if(respond.equalsIgnoreCase("quit")) {
			System.out.println("Aplicatia s-a oprit!");
		}
		
		while(respond.equalsIgnoreCase("quit") == false) {
			switch (respond) {
				case "help":
					System.out.println("help         - Afiseaza aceasta lista de comenzi\r\n" + 
							"add          - Adauga o noua persoana (inscriere)\r\n" + 
							"check        - Verifica daca o persoana este inscrisa la eveniment\r\n" + 
							"remove       - Sterge o persoana existenta din lista\r\n" + 
							"update       - Actualizeaza detaliile unei persoane\r\n" + 
							"guests       - Lista de persoane care participa la eveniment\r\n" + 
							"waitlist     - Persoanele din lista de asteptare\r\n" + 
							"available    - Numarul de locuri libere\r\n" + 
							"guests_no    - Numarul de persoane care participa la eveniment\r\n" + 
							"waitlist_no  - Numarul de persoane din lista de asteptare\r\n" + 
							"subscribe_no - Numarul total de persoane inscrise\r\n" + 
							"search       - Cauta toti invitatii conform sirului de caractere introdus\r\n" + 
							"quit         - Inchide aplicatia");
					break;
				
				case "add":
					System.out.println("Se adauga o noua persoana…");
					System.out.println("Introduceti numele de familie:");
					String lastName = sc.next();
					System.out.println("Introduceti prenumele:");
					String firstName = sc.next();
					System.out.println("Introduceti email-ul:");
					String email = sc.next();
					System.out.println("Introduceti numar de telefon (format „+40733386463“):");
					String phoneNumber = sc.next();
					list.add(lastName, firstName, email, phoneNumber);
					break;
					
				case "check":
					System.out.println("Introduceti metoda de cautare:\n\ttastati 1 pentru numele complet\n\t"
							+ "tastati 2 pentru adresa de email\n\ttastati 3 pentru numarul de telefon");
					String answer = sc.next();
					switch (answer) {
						case "1":
							System.out.println("Introduceti numele de familie:");
							String lastName1 = sc.next();
							System.out.println("Introduceti prenumele:");
							String firstName1 = sc.next();
							if(list.checkByName(lastName1, firstName1) == false) {
								System.out.println("Persoana NU este inscrisa la eveniment.");
							}
							break;
						
						case "2":
							System.out.println("Introduceti email-ul:");
							String email1 = sc.next();
							if(list.checkByEmail(email1) == false) {
								System.out.println("Persoana NU este inscrisa la eveniment.");
							}
							break;
						
						case "3":
							System.out.println("Introduceti numar de telefon (format „+40733386463“):");
							String phoneNumber1 = sc.next();
							if(list.checkByPhoneNumber(phoneNumber1) == false) {
								System.out.println("Persoana NU este inscrisa la eveniment.");
							}
							break;
							
						default:
							System.out.println("Ati introdus gresit!");
							break;
					}
					break;
				case "guests_no":
					list.sizeOfTheGuestList();
					break;
				
				case "waitlist_no":
					list.sizeOfTheWaitList();
					break;
					
				case "remove":
					System.out.println("Se sterge o persoana de lista...");
					System.out.println("Introduceti metoda de stergere:\n\ttastati 1 pentru numele complet\n\t"
							+ "tastati 2 pentru adresa de email\n\ttastati 3 pentru numarul de telefon");
					String answer1 = sc.next();
					switch (answer1) {
						case "1":
							System.out.println("Introduceti numele de familie:");
							String lastName1 = sc.next();
							System.out.println("Introduceti prenumele:");
							String firstName1 = sc.next();
							if(list.removeByName(lastName1, firstName1) == false) {
								System.out.println("Persoana NU este inscrisa la eveniment.");
							}
							break;
						
						case "2":
							System.out.println("Introduceti email-ul:");
							String email1 = sc.next();
							if(list.removeByEmail(email1) == false) {
								System.out.println("Persoana NU este inscrisa la eveniment.");
							}
							break;
						
						case "3":
							System.out.println("Introduceti numar de telefon (format „+40733386463“):");
							String phoneNumber1 = sc.next();
							if(list.removeByPhoneNumber(phoneNumber1) == false) {
								System.out.println("Persoana NU este inscrisa la eveniment.");
							}
							break;
							
						default:
							System.out.println("Ati introdus gresit!");
							break;	
					}
					break;
					
				case "update":
					System.out.println("Se actualizeaza detaliile unei persoane…");
					System.out.println("Introduceti metoda de cautare:\n\ttastati 1 pentru numele complet\n\t"
							+ "tastati 2 pentru adresa de email\n\ttastati 3 pentru numarul de telefon");
					String answer2 = sc.next();
					switch (answer2) {
						case "1":
							System.out.println("Introduceti numele de familie:");
							String lastName1 = sc.next();
							System.out.println("Introduceti prenumele:");
							String firstName1 = sc.next();
							if(list.checkByName(lastName1, firstName1) == false) {
								System.out.println("Persoana NU este inscrisa la eveniment.");
							}
							System.out.println("Alege campul de actualizat, tastand:\r\n" + 
									"\"1\" - Nume\r\n" + 
									"\"2\" - Prenume\r\n" + 
									"\"3\" - Email \r\n" + 
									"\"4\" - Numar de telefon (format \"+40733386463\")");
							String updateAnswer = sc.next();
							switch (updateAnswer) {
								case "1":
									System.out.println("Introduceti numele dorit:");
									String lastNameDesired = sc.next();
									list.settingLastName(lastName1, lastNameDesired);
									System.out.println("Numele a fost actualizat.");
									break;
								
								case "2":
									System.out.println("Introduceti prenumele dorit:");
									String firstNameDesired = sc.next();
									list.settingFirstName(lastName1, firstNameDesired);
									System.out.println("Prenumele a fost actualizat.");
									break;
								
								case "3":
									System.out.println("Introduceti emailul dorit:");
									String emailDesired = sc.next();
									list.settingEmail(lastName1, emailDesired);
									System.out.println("Emailul a fost actualizat.");
									break;
								
								case "4":
									System.out.println("Introduceti numarul de telefon dorit:");
									String phoneNumberDesired = sc.next();
									list.settingPhoneNumber(lastName1, phoneNumberDesired);
									System.out.println("Numarul de telefon a fost actualizat.");
									break;
									
								default:
									System.out.println("Ati introdus gresit!");
									break;	
								}
								break;
						
						case "2":
							System.out.println("Introduceti email-ul:");
							String email1 = sc.next();
							if(list.checkByEmail(email1) == false) {
								System.out.println("Persoana NU este inscrisa la eveniment.");
							}
							System.out.println("Alege campul de actualizat, tastand:\r\n" + 
									"\"1\" - Nume\r\n" + 
									"\"2\" - Prenume\r\n" + 
									"\"3\" - Email \r\n" + 
									"\"4\" - Numar de telefon (format \"+40733386463\")");
							String updateAnswer1 = sc.next();
							switch (updateAnswer1) {
							case "1":
								System.out.println("Introduceti numele dorit:");
								String lastNameDesired = sc.next();
								list.settingLastName(email1, lastNameDesired);
								System.out.println("Numele a fost actualizat.");
								break;
							
							case "2":
								System.out.println("Introduceti prenumele dorit:");
								String firstNameDesired = sc.next();
								list.settingFirstName(email1, firstNameDesired);
								System.out.println("Prenumele a fost actualizat.");
								break;
							
							case "3":
								System.out.println("Introduceti emailul dorit:");
								String emailDesired = sc.next();
								list.settingEmail(email1, emailDesired);
								System.out.println("Emailul a fost actualizat.");
								break;
							
							case "4":
								System.out.println("Introduceti numarul de telefon dorit:");
								String phoneNumberDesired = sc.next();
								list.settingPhoneNumber(email1, phoneNumberDesired);
								System.out.println("Numarul de telefon a fost actualizat.");
								break;
								
							default:
								System.out.println("Ati introdus gresit!");
								break;	
							}
							break;
						
						case "3":
							System.out.println("Introduceti numar de telefon (format „+40733386463“):");
							String phoneNumber1 = sc.next();
							if(list.checkByPhoneNumber(phoneNumber1) == false) {
								System.out.println("Persoana NU este inscrisa la eveniment.");
							}
							System.out.println("Alege campul de actualizat, tastand:\r\n" + 
									"\"1\" - Nume\r\n" + 
									"\"2\" - Prenume\r\n" + 
									"\"3\" - Email \r\n" + 
									"\"4\" - Numar de telefon (format \"+40733386463\")");
							String updateAnswer2 = sc.next();
							switch (updateAnswer2) {
							case "1":
								System.out.println("Introduceti numele dorit:");
								String lastNameDesired = sc.next();
								list.settingLastName(phoneNumber1, lastNameDesired);
								System.out.println("Numele a fost actualizat.");
								break;
							
							case "2":
								System.out.println("Introduceti prenumele dorit:");
								String firstNameDesired = sc.next();
								list.settingFirstName(phoneNumber1, firstNameDesired);
								System.out.println("Prenumele a fost actualizat.");
								break;
							
							case "3":
								System.out.println("Introduceti emailul dorit:");
								String emailDesired = sc.next();
								list.settingEmail(phoneNumber1, emailDesired);
								System.out.println("Emailul a fost actualizat.");
								break;
							
							case "4":
								System.out.println("Introduceti numarul de telefon dorit:");
								String phoneNumberDesired = sc.next();
								list.settingPhoneNumber(phoneNumber1, phoneNumberDesired);
								System.out.println("Numarul de telefon a fost actualizat.");
								break;
								
							default:
								System.out.println("Ati introdus gresit!");
								break;	
							}
							break;
							
						default:
							System.out.println("Ati introdus gresit!");
							break;	
					}
					break;
					
				case "guests":
					list.guests();
					break;
					
				case "waitlist":
					list.waitlist();
					break;
					
				case "available":
					System.out.println("Numarul de locuri ramase: " + list.seatsAvailable());
					break;
					
				case "subscribe_no":
					System.out.println("Numarul total de persoane: " + list.persons());
					break;
					
				case "search":
					System.out.println("Introduceti sirul de caractere dorit:");
					String str = sc.next();
					list.search(str);
					break;
			}
			System.out.println("\nAsteapta comanda: (help - Afiseaza lista de comenzi)");
			respond = sc.next();
			if(respond.equalsIgnoreCase("quit")) {
				System.out.println("Aplicatia s-a oprit!");
			}
		}
		
		sc.close();
	}
	
}

