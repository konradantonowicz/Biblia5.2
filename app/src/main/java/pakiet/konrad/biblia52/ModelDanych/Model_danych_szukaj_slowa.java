package pakiet.konrad.biblia52.ModelDanych;

public class Model_danych_szukaj_slowa {

    public Model_danych_szukaj_slowa(String nazwa_ksiegi_numer_rozdzialu, String numer_wersu_tresc_wersu) {
        this.nazwa_ksiegi_numer_rozdzialu = nazwa_ksiegi_numer_rozdzialu;
        this.numer_wersu_tresc_wersu = numer_wersu_tresc_wersu;
    }

    public String getNazwa_ksiegi_numer_rozdzialu() {
        return nazwa_ksiegi_numer_rozdzialu;
    }

    public void setNazwa_ksiegi_numer_rozdzialu(String nazwa_ksiegi_numer_rozdzialu) {
        this.nazwa_ksiegi_numer_rozdzialu = nazwa_ksiegi_numer_rozdzialu;
    }

    public String getNumer_wersu_tresc_wersu() {
        return numer_wersu_tresc_wersu;
    }

    public void setNumer_wersu_tresc_wersu(String numer_wersu_tresc_wersu) {
        this.numer_wersu_tresc_wersu = numer_wersu_tresc_wersu;
    }

    private String nazwa_ksiegi_numer_rozdzialu;
    private String numer_wersu_tresc_wersu;






}
