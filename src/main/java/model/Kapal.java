/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Kapal {

    private String namaKapal;
    private String tujuan;
    private int hargaTiket;

    public Kapal(String namaKapal, String tujuan, int hargaTiket) {
        this.namaKapal = namaKapal;
        this.tujuan = tujuan;
        this.hargaTiket = hargaTiket;
    }

    public String getNamaKapal() {
        return namaKapal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public int getHargaTiket() {
        return hargaTiket;
    }

    public void setNamaKapal(String namaKapal) {
        if (namaKapal != null && !namaKapal.trim().isEmpty()) {
            this.namaKapal = namaKapal;
        }
    }

    public void setTujuan(String tujuan) {
        if (tujuan != null && !tujuan.trim().isEmpty()) {
            this.tujuan = tujuan;
        }
    }

    public void setHargaTiket(int hargaTiket) {
        if (hargaTiket > 0) {
            this.hargaTiket = hargaTiket;
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama Kapal  : " + namaKapal);
        System.out.println("Tujuan      : " + tujuan);
        System.out.println("Harga Tiket : Rp" + hargaTiket);
    }
}