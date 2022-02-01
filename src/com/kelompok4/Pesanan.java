package com.kelompok4;

public class Pesanan {
    /** (Materi Information hiding - modul 4 && Materi deklarasikan atribut - Modul 3) */
    private Makanan makanan; // class Makanan
    private int jumlah;

    /**
     * Constructor class Pesanan
     */
    public Pesanan(Makanan makanan, int jumlah) {
        this.makanan = makanan;
        this.jumlah = jumlah;
    }

    /** Method Getter dan Setter */
    public Makanan getMakanan() {
        return makanan;
    }

    public void setMakanan(Makanan makanan) {
        this.makanan = makanan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    /** ------------------------- */
}