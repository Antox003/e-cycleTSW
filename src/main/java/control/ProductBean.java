package control;

public class ProductBean {
	private int Code;
    private String Nome;
    private String Descrizione;
    private double Prezzo;

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String Descrizione) {
        this.Descrizione = Descrizione;
    }

    public double getPrezzo() {
        return Prezzo;
    }

    public void setPrezzo(double Prezzo) {
        this.Prezzo = Prezzo;
    }
}
