package pakiet.konrad.biblia52.ModelDanych;

public class NazwyKsiagCzyJestKomentarz
{
    String NazwaKsiegi;
    Integer IkonaKomentarza;

    public NazwyKsiagCzyJestKomentarz(String nazwaKsiegi, Integer ikonaKomentarza) {
       this.NazwaKsiegi = nazwaKsiegi;
        this.IkonaKomentarza = ikonaKomentarza;
    }

    public String getNazwaKsiegi() {
        return NazwaKsiegi;
    }

    public void setNazwaKsiegi(String nazwaKsiegi) {
        NazwaKsiegi = nazwaKsiegi;
    }

    public Integer getIkonaKomentarza() {
        return IkonaKomentarza;
    }

    public void setIkonaKomentarza(Integer ikonaKomentarza) {
        IkonaKomentarza = ikonaKomentarza;
    }
}
