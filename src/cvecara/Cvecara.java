package cvecara;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Cvecara {
	public DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	private String naziv;
	private String webAdresa;
	private String telefon;
	private ArrayList<Cvece>cvet=new ArrayList<Cvece>();
	public Cvecara() {
		this.cvet=new ArrayList<Cvece>();
	}
	public Cvecara(String naziv, String webAdresa, String telefon) {
		super();
		this.naziv = naziv;
		this.webAdresa = webAdresa;
		this.telefon = telefon;
		this.cvet=new ArrayList<Cvece>();
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getWebAdresa() {
		return webAdresa;
	}
	public void setWebAdresa(String webAdresa) {
		this.webAdresa = webAdresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public ArrayList<Cvece> getCvet() {
		return cvet;
	}
	public void setCvet(ArrayList<Cvece> cvet) {
		this.cvet = cvet;
	}
	public boolean dodajCvece(Cvece cvece) {
		for(int i=0;i<this.cvet.size();i++) {
			if(this.cvet.get(i).getId()==cvece.getId()) {
				return false;
			}
		}
		this.cvet.add(cvece);
		return true;
	}
	public boolean izmeniCvece(Cvece cvece) {
		for(int i=0;i<this.cvet.size();i++) {
			if(this.cvet.get(i).getId()==cvece.getId()) {
				this.cvet.set(i, cvece);
				return true;
			}
		}
		return false;
	}
	public boolean obrisiCvece(int id) {
		for(int i=0;i<this.cvet.size();i++) {
			if(this.cvet.get(i).getId()==id) {
				this.cvet.remove(i);
				return true;
			}
		}
		return false;
	}
	public void ispisCveca() {
		for(int i=0;i<this.cvet.size();i++) {
			System.out.println(this.cvet.get(i));
		}
	}
	public ArrayList<Cvece> pretragaNaziv(String naziv){
		ArrayList<Cvece>lista=new ArrayList<Cvece>();
		for(int i=0;i<this.cvet.size();i++) {
			if(this.cvet.get(i).getNazivVrste().equalsIgnoreCase(naziv)) {
				lista.add(this.cvet.get(i));
				System.out.println(this.cvet.get(i));
			}
		}
		return lista;
	}
	public void prosecnaCenaCvetova() {
		double ukupno=0;
		for(int i=0;i<this.cvet.size();i++) {
			ukupno+=this.cvet.get(i).getCenaKomad()*this.cvet.get(i).getKolicina();
		}
		//System.out.println("Ukupna cena je " + ukupno);
		double prosek=0;
		prosek=ukupno/this.cvet.size();
		System.out.println("Prosecna cena svih cvetova iznosi " + prosek);
	}
	public void najvecaCenaPoTipu(String tip) {
		ArrayList<Cvece>lista=new ArrayList<Cvece>();
		for(int i=0;i<this.cvet.size();i++) {
			if(this.cvet.get(i).getTipCveta().equals(tip)) {
				lista.add(this.cvet.get(i));
				
			}
		}
		double cena=lista.get(0).getCenaKomad()*lista.get(0).getKolicina();
		for(int i=1;i<lista.size();i++) {
			if(cena<(lista.get(i).getCenaKomad()*lista.get(i).getKolicina())) {
				System.out.println(lista.get(i));
				//cena=(lista.get(i).getCenaKomad()*lista.get(i).getKolicina());
			}
		}
	}
	public double ukupnaVrednostCveca() {
		double ukupno=0;
		for(int i=0;i<this.cvet.size();i++) {
			ukupno+=this.cvet.get(i).getCenaKomad()*this.cvet.get(i).getKolicina();
		}
		return ukupno;
	}
	public void NajpovoljnijeCveceUCvecariOpseg(LocalDate min,LocalDate max) {
		ArrayList<Cvece>lista=new ArrayList<Cvece>();
		for(int i=0;i<this.cvet.size();i++) {
			if(this.cvet.get(i).getDatumUvrstavanja().compareTo(min)<0 &&
				this.cvet.get(i).getDatumPrestanka().compareTo(max)>0) {
				lista.add(this.cvet.get(i));
			}
		}
		double najeftinije=lista.get(0).getCenaKomad();
		for(int i=1;i<lista.size();i++) {
			if(najeftinije>lista.get(i).getCenaKomad()) {
				najeftinije=lista.get(i).getCenaKomad();
			}
		}
		//System.out.println(najeftinije);
		for(int i=0;i<this.cvet.size();i++) {
			if(this.cvet.get(i).getCenaKomad()==najeftinije) {
				System.out.println(this.cvet.get(i));
			}
		}
	}
	
	public void save(String path) {
		ArrayList<String>lines= new ArrayList<String>();
		lines.add(this.naziv);
		lines.add(this.webAdresa);
		lines.add(this.telefon);
		for(int i=0;i<this.cvet.size();i++) {
			Cvece cvet=this.cvet.get(i);
			String line=cvet.getId() + ";" + cvet.getNazivVrste() + ";" + dtf.format(cvet.getDatumUvrstavanja()) + ";" +
			dtf.format(cvet.getDatumPrestanka()) + ";" + cvet.getCenaKomad() + ";" + cvet.getKolicina() + ";" +cvet.getTipCveta();
			lines.add(line);
		}
		try {Files.write(Paths.get(path), lines, Charset.defaultCharset());
			
		}catch(IOException e) {
			System.out.println("Doslo je do greske" + path + "se ne moze sacuvati");
		}	
	}
	public void load(String path) {
		this.cvet.clear();
		List<String>lines;
		try {lines=Files.readAllLines(Paths.get(path), Charset.defaultCharset());
			this.naziv=lines.get(0);
			this.webAdresa=lines.get(1);
			this.telefon=lines.get(2);
			lines.remove(0);
			lines.remove(0);
			lines.remove(0);
		for(String line:lines) {
			String[]atribut=line.split(";");
			int id=Integer.parseInt(atribut[0]);
			String naziv=atribut[1];
			LocalDate datum=null;
			try {datum=LocalDate.parse(atribut[2],dtf);
			}catch(Exception e) {
				e.printStackTrace();
			}
			LocalDate datum1=null;
			try {datum1=LocalDate.parse(atribut[3],dtf);
			}catch(Exception e) {
				e.printStackTrace();
			}
			double cena=Double.parseDouble(atribut[4]);
			int kolicina=Integer.parseInt(atribut[5]);
			String tip=atribut[6];
			Cvece cvece=new Cvece(id,naziv,datum,datum1,cena,kolicina,tip);
			this.cvet.add(cvece);
			
		}
		}catch(IOException e) {
			System.out.println("Doslo je do greske pri ucitavanju");
		}
	}
	
	@Override
	public String toString() {
		String temp="";
		temp+="Naziv cvecare= " + naziv + "\n";
		temp+="Adresa cvecare= " + webAdresa + "\n";
		temp+="Telefon= " + telefon + "\n";
		temp+="Ukupna vrednost cveca u cvecari iznosi= " + ukupnaVrednostCveca();
		return temp;
	}
	
}
