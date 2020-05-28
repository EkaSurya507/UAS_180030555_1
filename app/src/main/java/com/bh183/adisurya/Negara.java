package com.bh183.adisurya;



public class Negara {
    private int idNegara;
    private String negara;
    private String pemimpin;
    private String cover;
    private String bahasa;
    private String ibukota;
    private String luas;
    private String lagu;
    private String sejarah;


    public Negara(int idNegara, String negara, String pemimpin, String cover, String bahasa, String ibukota, String luas, String lagu, String sejarah) {
        this.idNegara = idNegara;
        this.negara = negara;
        this.pemimpin = pemimpin;
        this.cover = cover;
        this.bahasa = bahasa;
        this.ibukota = ibukota;
        this.luas = luas;
        this.lagu = lagu;
        this.sejarah = sejarah;

    }

    public Negara(int csrInt, String string, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
    }

    public int getIdNegara() {
        return idNegara;
    }

    public void setIdNegara(int idNegara) {
        this.idNegara = idNegara;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getPemimpin() {
        return pemimpin;
    }

    public void setPemimpin(String pemimpin) {
        this.pemimpin = pemimpin;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getBahasa() {
        return bahasa;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }

    public String getIbukota() {
        return ibukota;
    }

    public void setIbukota(String ibukota) {
        this.ibukota = ibukota;
    }

    public String getLuas() {
        return luas;
    }

    public void setLuas(String luas) {
        this.luas = luas;
    }


    public String getLagu() {
        return lagu;
    }

    public void setLagu(String lagu) {
        this.lagu = lagu;
    }

    public String getSejarah() {
        return sejarah;
    }

    public void setSejarah(String sejarah) {
        this.sejarah = sejarah;
    }
}
