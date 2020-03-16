package agentie;

public class Clienti {
	private int CNP;
	private String nume;
	private String adresa;
	private String oras;
	private String mail;
	private String telefon;
	
	public Clienti(int CNP,String nume,String adresa,String oras,String mail,String telefon)
	{
		this.CNP=CNP;
		this.nume=nume;
		this.adresa=adresa;
		this.oras=oras;
		this.mail=mail;
		this.telefon=telefon;
	}
	public int getCNP()
	{
		return CNP;
	}
	public String getnume()
	{
		return nume;
	}
	public String getadresa()
	{
		return adresa;
	}
	public String getoras()
	{
		return oras;
	}
	public String getmail()
	{
		return mail;
	}
	public String gettelefon()
	{
		return telefon;
	}

}
