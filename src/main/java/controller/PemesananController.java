/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Kapal;
import model.KapalEkonomi;
import model.KapalVIP;
import model.Pemesanan;
import model.Penumpang;
import view.PemesananView;

/**
 *
 * @author ACER
 */
public class PemesananController {

    private final ArrayList<Pemesanan> daftarPemesanan;
    private final PemesananView view;

    public PemesananController() {
        daftarPemesanan = new ArrayList<>();
        view = new PemesananView();

        isiDummyData();
    }

    private void isiDummyData() {

        Penumpang penumpang1 = new Penumpang(
                "Andi",
                "6471012345678901",
                20
        );

        Kapal kapal1 = new KapalVIP(
                "KM Bukit Siguntang",
                "Balikpapan",
                150000,
                "Kabin pribadi"
        );

        Pemesanan pemesanan1 = new Pemesanan(
                "101",
                penumpang1,
                kapal1,
                2
        );

        Penumpang penumpang2 = new Penumpang(
                "Budi",
                "6471012345678902",
                21
        );

        Kapal kapal2 = new KapalEkonomi(
                "KM Lambelu",
                "Makassar",
                200000,
                "Kursi penumpang"
        );

        Pemesanan pemesanan2 = new Pemesanan(
                "102",
                penumpang2,
                kapal2,
                1
        );

        daftarPemesanan.add(pemesanan1);
        daftarPemesanan.add(pemesanan2);
    }

    public void jalankanProgram() {

        int pilihan;

        do {
            view.tampilkanMenu();
            pilihan = view.inputPilihanMenu();

            switch (pilihan) {

                case 1 -> tambahPemesanan();

                case 2 -> tampilkanPemesanan();

                case 3 -> ubahPemesanan();

                case 4 -> hapusPemesanan();

                case 5 -> {
                    view.tampilkanPesan("\nProgram selesai.");
                    view.tampilkanPesan("Terima kasih.");
                }
            }

        } while (pilihan != 5);
    }

    private void tambahPemesanan() {

        System.out.println();
        System.out.println("===== TAMBAH PEMESANAN =====");

        String idPemesanan;

        while (true) {

            idPemesanan = view.inputIdPemesanan();

            if (idSudahAda(idPemesanan)) {
                System.out.println("ID sudah digunakan.");
            } else {
                break;
            }
        }

        String nama = view.inputNama();
        String nik = view.inputNik();
        int umur = view.inputUmur();

        int pilihKapal = view.inputPilihanKapal();

        Kapal kapal = buatKapal(pilihKapal);

        int jumlahTiket = view.inputJumlahTiket();

        Penumpang penumpang = new Penumpang(
                nama,
                nik,
                umur
        );

        Pemesanan pemesanan = new Pemesanan(
                idPemesanan,
                penumpang,
                kapal,
                jumlahTiket
        );

        daftarPemesanan.add(pemesanan);

        System.out.println();
        System.out.println("Pemesanan berhasil ditambahkan.");
        System.out.println("Total Harga : Rp"
                + pemesanan.getTotalHarga());
    }

    private void tampilkanPemesanan() {
        view.tampilkanDaftarPemesanan(daftarPemesanan);
    }

    private void ubahPemesanan() {

        System.out.println();
        System.out.println("===== UBAH PEMESANAN =====");

        String idCari = view.inputIdCari();

        for (Pemesanan p : daftarPemesanan) {

            if (p.getIdPemesanan().equals(idCari)) {

                String namaBaru = view.inputNama();
                String nikBaru = view.inputNik();
                int umurBaru = view.inputUmur();

                int pilihKapalBaru = view.inputPilihanKapalBaru();

                Kapal kapalBaru = buatKapal(pilihKapalBaru);

                int jumlahBaru = view.inputJumlahTiketBaru();

                p.getPenumpang().setNama(namaBaru);
                p.getPenumpang().setNik(nikBaru);
                p.getPenumpang().setUmur(umurBaru);

                p.setKapal(kapalBaru);
                p.setJumlahTiket(jumlahBaru);

                System.out.println();
                System.out.println("Data berhasil diubah.");

                return;
            }
        }

        System.out.println("ID Pemesanan tidak ditemukan.");
    }

    private void hapusPemesanan() {

        System.out.println();
        System.out.println("===== HAPUS PEMESANAN =====");

        String idHapus = view.inputIdCari();

        for (int i = 0; i < daftarPemesanan.size(); i++) {

            Pemesanan p = daftarPemesanan.get(i);

            if (p.getIdPemesanan().equals(idHapus)) {

                System.out.println();
                System.out.println("Data ditemukan.");
                System.out.println("Nama Penumpang : "
                        + p.getPenumpang().getNama());

                int konfirmasi = view.inputKonfirmasiHapus();

                if (konfirmasi == 1) {

                    daftarPemesanan.remove(i);
                    System.out.println("Data berhasil dihapus.");

                } else {

                    System.out.println("Penghapusan dibatalkan.");
                }

                return;
            }
        }

        System.out.println("ID Pemesanan tidak ditemukan.");
    }

    private boolean idSudahAda(String idPemesanan) {

        for (Pemesanan p : daftarPemesanan) {

            if (p.getIdPemesanan().equals(idPemesanan)) {
                return true;
            }
        }

        return false;
    }

    private Kapal buatKapal(int pilihan) {

        if (pilihan == 1) {

            return new KapalVIP(
                    "KM Bukit Siguntang",
                    "Balikpapan",
                    150000,
                    "Kabin pribadi"
            );

        } else if (pilihan == 2) {

            return new KapalEkonomi(
                    "KM Lambelu",
                    "Makassar",
                    200000,
                    "Kursi penumpang"
            );

        } else {

            return new KapalEkonomi(
                    "KM Dorolonda",
                    "Parepare",
                    175000,
                    "Kursi penumpang"
            );
        }
    }
}
