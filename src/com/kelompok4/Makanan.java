package com.kelompok4;

public class Makanan {
    /** (Materi Information hiding - modul 4 && Materi deklarasikan atribut - Modul 3) */
    private String nama;
    private int harga;

    /**
     * Constructor class Makanan
     */
    public Makanan(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    /** Method Getter dan Setter */
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    /** ------------------------- */
}
