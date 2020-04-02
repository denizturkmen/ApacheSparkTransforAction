package com.deniz.Transformation;

import java.io.Serializable;

public class CupModel implements Serializable {

    String yil;
    String evSahibi;
    String birinci;
    String ikinci;
    String ucuncu;
    String dorduncu;
    int toplamgol;
    int toplamulke;
    int toplammac;
    double toplamkatilimci;

    public CupModel(String yil, String evSahibi, String birinci, String ikinci, String ucuncu, String dorduncu, int toplamgol, int toplamulke, int toplammac, double toplamkatilimci) {
        this.yil = yil;
        this.evSahibi = evSahibi;
        this.birinci = birinci;
        this.ikinci = ikinci;
        this.ucuncu = ucuncu;
        this.dorduncu = dorduncu;
        this.toplamgol = toplamgol;
        this.toplamulke = toplamulke;
        this.toplammac = toplammac;
        this.toplamkatilimci = toplamkatilimci;
    }

    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public String getEvSahibi() {
        return evSahibi;
    }

    public void setEvSahibi(String evSahibi) {
        this.evSahibi = evSahibi;
    }

    public String getBirinci() {
        return birinci;
    }

    public void setBirinci(String birinci) {
        this.birinci = birinci;
    }

    public String getIkinci() {
        return ikinci;
    }

    public void setIkinci(String ikinci) {
        this.ikinci = ikinci;
    }

    public String getUcuncu() {
        return ucuncu;
    }

    public void setUcuncu(String ucuncu) {
        this.ucuncu = ucuncu;
    }

    public String getDorduncu() {
        return dorduncu;
    }

    public void setDorduncu(String dorduncu) {
        this.dorduncu = dorduncu;
    }

    public int getToplamgol() {
        return toplamgol;
    }

    public void setToplamgol(int toplamgol) {
        this.toplamgol = toplamgol;
    }

    public int getToplamulke() {
        return toplamulke;
    }

    public void setToplamulke(int toplamulke) {
        this.toplamulke = toplamulke;
    }

    public int getToplammac() {
        return toplammac;
    }

    public void setToplammac(int toplammac) {
        this.toplammac = toplammac;
    }

    public double getToplamkatilimci() {
        return toplamkatilimci;
    }

    public void setToplamkatilimci(double toplamkatilimci) {
        this.toplamkatilimci = toplamkatilimci;
    }
}
