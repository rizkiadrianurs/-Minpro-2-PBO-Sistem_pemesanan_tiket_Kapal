/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Kapal;

/**
 *
 * @author ACER
 */
public class Pemesanan {
    
    private final String idPemesanan;
    private Penumpang penumpang;
    private Kapal kapal;
    private int jumlahTiket;

    public Pemesanan(String idPemesanan, Penumpang penumpang, Kapal kapal, int jumlahTiket) {
        this.idPemesanan = idPemesanan;
        this.penumpang = penumpang;
        this.kapal = kapal;
        this.jumlahTiket = jumlahTiket;
    }

    public String getIdPemesanan() {
        return idPemesanan;
    }

    public Penumpang getPenumpang() {
        return penumpang;
    }

    public Kapal getKapal() {
        return kapal;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }

    public void setPenumpang(Penumpang penumpang) {
        if (penumpang != null) {
            this.penumpang = penumpang;
        }
    }

    public void setKapal(Kapal kapal) {
        if (kapal != null) {
            this.kapal = kapal;
        }
    }

    public void setJumlahTiket(int jumlahTiket) {
        if (jumlahTiket > 0) {
            this.jumlahTiket = jumlahTiket;
        }
    }

    public int getTotalHarga() {
        return kapal.getHargaTiket() * jumlahTiket;
    }
}