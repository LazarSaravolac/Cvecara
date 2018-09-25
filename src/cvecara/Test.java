package cvecara;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {
	public static DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	public static Scanner sc=new Scanner(System.in);
	public static boolean proveriID(String string) {
		try {int broj=Integer.parseInt(string);
		if(broj>=1) {
			return true;
		}else
			return false;
			
		}catch(Exception e) {
			return false;
		}
	}
	public static boolean daLiJeVeciDatum(LocalDate datumPocetni, String datum) {

		LocalDate datumKrajnji = null;
		try {
			datumKrajnji = LocalDate.parse(datum, dtf);
			if(datumKrajnji.compareTo(datumPocetni) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean proveriDatum(String datum) {

		try {
			LocalDate.parse(datum, dtf);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean proveriCenu(String string) {
		try {int broj=Integer.parseInt(string);
		if(broj>0) {
			return true;
		}else
			return false;
		}catch(Exception e) {
			return false;
		}
	}
	public static boolean proveriKolicinu(String string) {
		try {int broj=Integer.parseInt(string);
		if(broj>0) {
			return true;
		}else
			return false;
		}catch(Exception e) {
			return false;
		}
	}
	public static void unesiCvecaru(Cvecara cvecara) {
		System.out.println("Unesi naziv cvecare");
		String naziv=sc.nextLine();
		cvecara.setNaziv(naziv);
		System.out.println("Unesi web adresu cvecare");
		String adresa=sc.nextLine();
		cvecara.setWebAdresa(adresa);
		System.out.println("Unesi telefon");
		String telefon=sc.nextLine();
		cvecara.setTelefon(telefon);
		System.out.println("Uspesno uneti podaci o cvecari");
	}
	public static void unesiCvece(Cvecara cvecara) {
		int id=0;
		String idString=null;
		do{System.out.println("Unesite id ");
			idString=sc.nextLine();
		}while(!proveriID(idString));
		id=Integer.parseInt(idString);
		System.out.println("Unesite naziv vrste");
		String nazivVrste=sc.nextLine();
		String datumU=null;
		LocalDate datum=null;
		do {System.out.println("Unesite datum uvrstavanja vrste cveta u ponudu");
			datumU=sc.nextLine();
		}while(!proveriDatum(datumU));
		try {datum=LocalDate.parse(datumU,dtf);
		}catch(Exception e) {
			e.printStackTrace();
		}
		String datumS=null;
		LocalDate datum1=null;
		do {System.out.println("Unesite datum prestanka vazenja ponude za vrstu cveta");
			datumS=sc.nextLine();
		}while(!daLiJeVeciDatum(datum, datumS));
		try {datum1=LocalDate.parse(datumS,dtf);
		}catch(Exception e) {
			e.printStackTrace();
		}
		String cenaK=null;
		double cena=0;
		do {System.out.println("Unesite cenu po komadu");
			cenaK=sc.nextLine();
		}while(!proveriCenu(cenaK));
		cena=Double.parseDouble(cenaK);
		String kolicinaK=null;
		int kolicina=0;
		do {System.out.println("Unesi kolicinu");
			kolicinaK=sc.nextLine();
		}while(!proveriKolicinu(kolicinaK));
		kolicina=Integer.parseInt(kolicinaK);
		String tipString=null;
		do {System.out.println("Unesi tip cveta");
			tipString=sc.nextLine();
		}while(!(tipString.equals("ruze") || tipString.equals("cvetno bilje") || tipString.equals("zeleno bilje") || tipString.equals("dvorisno") || tipString.equals("kaktusi")));
		Cvece cvece = new Cvece(id,nazivVrste,datum,datum1,cena,kolicina,tipString);
		boolean e=cvecara.dodajCvece(cvece);
		if(e) {
			System.out.println("Uspesno dodata vrsta");
		}else
			System.out.println("Neuspesno dodata vrsta");
	
	}
	public static void ispisCveca(Cvecara cvecara) {
		cvecara.ispisCveca();
	}
	public static void izmeniCvece(Cvecara cvecara) {
		int id=0;
		String idString=null;
		do{System.out.println("Unesite id ");
			idString=sc.nextLine();
		}while(!proveriID(idString));
		id=Integer.parseInt(idString);
		System.out.println("Unesite naziv vrste");
		String nazivVrste=sc.nextLine();
		String datumU=null;
		LocalDate datum=null;
		do {System.out.println("Unesite datum uvrstavanja vrste cveta u ponudu");
			datumU=sc.nextLine();
		}while(!proveriDatum(datumU));
		try {datum=LocalDate.parse(datumU,dtf);
		}catch(Exception e) {
			e.printStackTrace();
		}
		String datumS=null;
		LocalDate datum1=null;
		do {System.out.println("Unesite datum prestanka vazenja ponude za vrstu cveta");
			datumS=sc.nextLine();
		}while(!daLiJeVeciDatum(datum, datumS));
		try {datum1=LocalDate.parse(datumS,dtf);
		}catch(Exception e) {
			e.printStackTrace();
		}
		String cenaK=null;
		double cena=0;
		do {System.out.println("Unesite cenu po komadu");
			cenaK=sc.nextLine();
		}while(!proveriCenu(cenaK));
		cena=Double.parseDouble(cenaK);
		String kolicinaK=null;
		int kolicina=0;
		do {System.out.println("Unesi kolicinu");
			kolicinaK=sc.nextLine();
		}while(!proveriKolicinu(kolicinaK));
		kolicina=Integer.parseInt(kolicinaK);
		String tipString=null;
		do {System.out.println("Unesi tip cveta");
			tipString=sc.nextLine();
		}while(!(tipString.equals("ruze") || tipString.equals("cvetno bilje") || tipString.equals("zeleno bilje") || tipString.equals("dvorisno") || tipString.equals("kaktusi")));
		Cvece cvece = new Cvece(id,nazivVrste,datum,datum1,cena,kolicina,tipString);
		boolean e=cvecara.izmeniCvece(cvece);
		if(e) {
			System.out.println("Uspesno izmenjeno cvece");
		}else
			System.out.println("Neuspesno izmenjeno cvece");
	}
	public static void obrisiCvece(Cvecara cvecara) {
		int id=0;
		String idString=null;
		do{System.out.println("Unesite id ");
			idString=sc.nextLine();
		}while(!proveriID(idString));
		id=Integer.parseInt(idString);
		boolean e=cvecara.obrisiCvece(id);
		if(e) {
			System.out.println("Uspesno obrisano cvece");
		}else
			System.out.println("Neuspesno obrisano cvece");
	}
	public static void pretragaNaziva(Cvecara cvecara) {
		System.out.println("Unesite naziv vrste");
		String nazivVrste=sc.nextLine();	
		cvecara.pretragaNaziv(nazivVrste);
	}
	public static void prosecnaCena(Cvecara cvecara) {
		cvecara.prosecnaCenaCvetova();
	}
	public static void iznadProsecnaCenaZaTuKategoriju(Cvecara cvecara) {
		String tipString=null;
		do {System.out.println("Unesi tip cveta");
			tipString=sc.nextLine();
		}while(!(tipString.equals("ruze") || tipString.equals("cvetno bilje") || tipString.equals("zeleno bilje") || tipString.equals("dvorisno") || tipString.equals("kaktusi")));
		cvecara.najvecaCenaPoTipu(tipString);
	}
	public static void ispisPodatakaOCvecari(Cvecara cvecara) {
		System.out.println(cvecara);
	}
	public static void najpovoljnijiCvet(Cvecara cvecara) {
		String datumU=null;
		LocalDate datum=null;
		do {System.out.println("Unesite datum uvrstavanja vrste cveta u ponudu");
			datumU=sc.nextLine();
		}while(!proveriDatum(datumU));
		try {datum=LocalDate.parse(datumU,dtf);
		}catch(Exception e) {
			e.printStackTrace();
		}
		String datumS=null;
		LocalDate datum1=null;
		do {System.out.println("Unesite datum prestanka vazenja ponude za vrstu cveta");
			datumS=sc.nextLine();
		}while(!daLiJeVeciDatum(datum, datumS));
		try {datum1=LocalDate.parse(datumS,dtf);
		}catch(Exception e) {
			e.printStackTrace();
		}
		cvecara.NajpovoljnijeCveceUCvecariOpseg(datum, datum1);
	}
	public static void naslov() {
		System.out.printf("%15s %15s %15s %15s %15s %15s %15s \n","ID","Naziv Vrste","Datum uvrstavanja","Datum prestanka","Cena po komadu","Kolicina","Tip cveta");
		System.out.println("------------------------------------------------------------------------------------------------------------------");
	}
	public static void main(String[] args) {
		Cvecara cvecara= new Cvecara();
		cvecara.load("rad.txt");
		String opcija=null;
		
		do {System.out.println("1:Unos podataka o cvecari");
		 	System.out.println("2:Unos nove vrste cveta");
		 	System.out.println("3:Ispis podataka o cvetovima u ponudi");
			System.out.println("4:Izmena podataka o cvetu(uneti id)");
			System.out.println("5:Brisanje podataka o cvetu(uneti id)");
			System.out.println("6:Pretraga i ispis svih cvetova po nazivu");
			System.out.println("7:Prosecna cena cvetova");
			System.out.println("8:Prikaz najpovoljnijeg cveta iz ponude za dati period");
			System.out.println("9:Prikaz cvetova odredjene kategorije cija cena je veca od proscne cene cveta te kategorije");
			System.out.println("10:Ispis podataka o cvecari i  ukupne vrednosti svakog cveca u cvecari");
			opcija=sc.nextLine();
			
			switch(opcija) {
			case"1":
				unesiCvecaru(cvecara);
				break;
			case"2":
				unesiCvece(cvecara);
				cvecara.save("rad.txt");
				break;
			case"3":
				naslov();
				ispisCveca(cvecara);
				break;
			case"4":
				izmeniCvece(cvecara);
				cvecara.save("rad.txt");
				break;
			case"5":
				obrisiCvece(cvecara);
				cvecara.save("rad.txt");
				break;
			case"6":
				pretragaNaziva(cvecara);
				break;
			case"7":
				prosecnaCena(cvecara);
				break;
			case"8":
				najpovoljnijiCvet(cvecara);
				break;
			case"9":
				iznadProsecnaCenaZaTuKategoriju(cvecara);
				break;
			case"10":
				ispisPodatakaOCvecari(cvecara);
				break;
			case"x":
				break;
			default:
				System.out.println("Pogresan izbor opcije. Pokusajte ponovo.");
			}
		}while(!opcija.equals("x"));
	}

}
