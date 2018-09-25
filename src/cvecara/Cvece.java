package cvecara;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cvece {
	public DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	private int id;
	private String nazivVrste;
	private LocalDate datumUvrstavanja;
	private LocalDate datumPrestanka;
	private double cenaKomad;
	private int kolicina;
	private String tipCveta;
	public Cvece() {
		
	}
	public Cvece(int id, String nazivVrste, LocalDate datumUvrstavanja, LocalDate datumPrestanka, double cenaKomad,
			int kolicina, String tipCveta) {
		super();
		this.id = id;
		this.nazivVrste = nazivVrste;
		this.datumUvrstavanja = datumUvrstavanja;
		this.datumPrestanka = datumPrestanka;
		this.cenaKomad = cenaKomad;
		this.kolicina = kolicina;
		this.tipCveta = tipCveta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazivVrste() {
		return nazivVrste;
	}
	public void setNazivVrste(String nazivVrste) {
		this.nazivVrste = nazivVrste;
	}
	public LocalDate getDatumUvrstavanja() {
		return datumUvrstavanja;
	}
	public void setDatumUvrstavanja(LocalDate datumUvrstavanja) {
		this.datumUvrstavanja = datumUvrstavanja;
	}
	public LocalDate getDatumPrestanka() {
		return datumPrestanka;
	}
	public void setDatumPrestanka(LocalDate datumPrestanka) {
		this.datumPrestanka = datumPrestanka;
	}
	public double getCenaKomad() {
		return cenaKomad;
	}
	public void setCenaKomad(double cenaKomad) {
		this.cenaKomad = cenaKomad;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public String getTipCveta() {
		return tipCveta;
	}
	public void setTipCveta(String tipCveta) {
		this.tipCveta = tipCveta;
	}
	@Override
	public String toString() {
		return String.format("%15s %15s %15s %15s %15s %15s %15s",id,nazivVrste,dtf.format(datumUvrstavanja),dtf.format(datumPrestanka),cenaKomad,kolicina,tipCveta);
		
	}
	
}
