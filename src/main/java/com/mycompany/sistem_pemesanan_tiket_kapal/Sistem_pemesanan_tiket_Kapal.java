/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistem_pemesanan_tiket_kapal;

import java.util.ArrayList;
import java.util.Scanner;
import model.Kapal;
import model.KapalVIP;
import model.KapalEkonomi;
import model.Penumpang;
import model.Pemesanan;

/**
 *
 * @author ACER
 */
public class Sistem_pemesanan_tiket_Kapal {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            ArrayList<Pemesanan> daftarPemesanan = new ArrayList<>();

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

            int pilihan = 0;

            do {

                System.out.println();
                System.out.println("===================================");
                System.out.println("    SISTEM PEMESANAN TIKET KAPAL");
                System.out.println("===================================");
                System.out.println("1. Tambah Pemesanan");
                System.out.println("2. Tampilkan Pemesanan");
                System.out.println("3. Ubah Pemesanan");
                System.out.println("4. Hapus Pemesanan");
                System.out.println("5. Keluar");
                System.out.println("===================================");

                while (true) {

                    System.out.print("Pilih menu: ");

                    try {

                        pilihan = Integer.parseInt(input.nextLine());

                        if (pilihan >= 1 && pilihan <= 5) {
                            break;
                        }

                        System.out.println("Pilihan menu harus 1-5.");

                    } catch (NumberFormatException e) {

                        System.out.println("Input harus berupa angka.");
                    }
                }

                switch (pilihan) {

                    case 1:

                        System.out.println();
                        System.out.println("===== TAMBAH PEMESANAN =====");

                        String idPemesanan;

                        while (true) {

                            System.out.print("ID Pemesanan   : ");
                            idPemesanan = input.nextLine();

                            if (idPemesanan.trim().isEmpty()) {
                                System.out.println("ID tidak boleh kosong.");
                                continue;
                            }

                            if (idPemesanan.length() != 3) {
                                System.out.println("ID harus terdiri dari 3 angka.");
                                continue;
                            }

                            boolean idAngka = true;

                            for (int i = 0; i < idPemesanan.length(); i++) {

                                if (!Character.isDigit(idPemesanan.charAt(i))) {
                                    idAngka = false;
                                    break;
                                }
                            }

                            if (!idAngka) {
                                System.out.println("ID hanya boleh berisi angka.");
                                continue;
                            }

                            boolean idSudahAda = false;

                            for (Pemesanan p : daftarPemesanan) {

                                if (p.getIdPemesanan().equals(idPemesanan)) {
                                    idSudahAda = true;
                                    break;
                                }
                            }

                            if (idSudahAda) {
                                System.out.println("ID sudah digunakan.");
                            } else {
                                break;
                            }
                        }

                        String nama;

                        while (true) {

                            System.out.print("Nama Penumpang : ");
                            nama = input.nextLine();

                            if (nama.trim().isEmpty()) {
                                System.out.println("Nama tidak boleh kosong.");
                                continue;
                            }

                            boolean namaValid = true;

                            for (int i = 0; i < nama.length(); i++) {

                                char karakter = nama.charAt(i);

                                if (!Character.isLetter(karakter) && karakter != ' ') {
                                    namaValid = false;
                                    break;
                                }
                            }

                            if (!namaValid) {
                                System.out.println("Nama hanya boleh berisi huruf dan spasi.");
                            } else {
                                break;
                            }
                        }

                        String nik;

                        while (true) {

                            System.out.print("NIK            : ");
                            nik = input.nextLine();

                            if (nik.length() != 16) {
                                System.out.println("NIK harus terdiri dari 16 digit.");
                                continue;
                            }

                            boolean nikValid = true;

                            for (int i = 0; i < nik.length(); i++) {

                                if (!Character.isDigit(nik.charAt(i))) {
                                    nikValid = false;
                                    break;
                                }
                            }

                            if (!nikValid) {
                                System.out.println("NIK hanya boleh berisi angka.");
                            } else {
                                break;
                            }
                        }

                        int umur;

                        while (true) {

                            System.out.print("Umur           : ");
                            String inputUmur = input.nextLine();

                            if (inputUmur.trim().isEmpty()) {
                                System.out.println("Umur tidak boleh kosong.");
                                continue;
                            }

                            if (inputUmur.length() > 3) {
                                System.out.println("Umur maksimal 3 angka.");
                                continue;
                            }

                            boolean umurValid = true;

                            for (int i = 0; i < inputUmur.length(); i++) {

                                if (!Character.isDigit(inputUmur.charAt(i))) {
                                    umurValid = false;
                                    break;
                                }
                            }

                            if (!umurValid) {
                                System.out.println("Umur hanya boleh berupa angka.");
                                continue;
                            }

                            umur = Integer.parseInt(inputUmur);

                            if (umur <= 0) {
                                System.out.println("Umur harus lebih dari 0.");
                                continue;
                            }

                            break;
                        }

                        int pilihKapal;

                        while (true) {

                            System.out.println();
                            System.out.println("Pilihan Kapal:");
                            System.out.println("1. KM Bukit Siguntang - Balikpapan - VIP - Rp150000");
                            System.out.println("2. KM Lambelu - Makassar - Ekonomi - Rp200000");
                            System.out.println("3. KM Dorolonda - Parepare - Ekonomi - Rp175000");
                            System.out.print("Pilih kapal: ");

                            try {

                                pilihKapal = Integer.parseInt(input.nextLine());

                                if (pilihKapal >= 1 && pilihKapal <= 3) {
                                    break;
                                }

                                System.out.println("Pilihan kapal hanya 1-3.");

                            } catch (NumberFormatException e) {

                                System.out.println("Input harus berupa angka.");
                            }
                        }

                        Kapal kapal;

                        if (pilihKapal == 1) {

                            kapal = new KapalVIP(
                                    "KM Bukit Siguntang",
                                    "Balikpapan",
                                    150000,
                                    "Kabin pribadi"
                            );

                        } else if (pilihKapal == 2) {

                            kapal = new KapalEkonomi(
                                    "KM Lambelu",
                                    "Makassar",
                                    200000,
                                    "Kursi penumpang"
                            );

                        } else {

                            kapal = new KapalEkonomi(
                                    "KM Dorolonda",
                                    "Parepare",
                                    175000,
                                    "Kursi penumpang"
                            );
                        }

                        int jumlahTiket;

                        while (true) {

                            System.out.print("Jumlah Tiket   : ");

                            try {

                                jumlahTiket = Integer.parseInt(input.nextLine());

                                if (jumlahTiket > 0) {
                                    break;
                                }

                                System.out.println("Jumlah tiket harus lebih dari 0.");

                            } catch (NumberFormatException e) {

                                System.out.println("Jumlah tiket harus berupa angka.");
                            }
                        }

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
                        System.out.println("Total Harga : Rp" + pemesanan.getTotalHarga());

                        break;

                    case 2:

                        System.out.println();
                        System.out.println("===== DAFTAR PEMESANAN =====");

                        if (daftarPemesanan.isEmpty()) {

                            System.out.println("Belum ada data pemesanan.");

                        } else {

                            for (int i = 0; i < daftarPemesanan.size(); i++) {

                                Pemesanan p = daftarPemesanan.get(i);

                                System.out.println();
                                System.out.println("Data ke-" + (i + 1));
                                System.out.println("ID Pemesanan   : " + p.getIdPemesanan());
                                System.out.println("Nama Penumpang : " + p.getPenumpang().getNama());
                                System.out.println("NIK            : " + p.getPenumpang().getNik());
                                System.out.println("Umur           : " + p.getPenumpang().getUmur());

                                p.getKapal().tampilkanInfo();

                                System.out.println("Jumlah Tiket   : " + p.getJumlahTiket());
                                System.out.println("Total Harga    : Rp" + p.getTotalHarga());
                            }
                        }

                        break;

                    case 3:

                        System.out.println();
                        System.out.println("===== UBAH PEMESANAN =====");
                        System.out.print("Masukkan ID Pemesanan: ");

                        String idCari = input.nextLine();
                        boolean ditemukan = false;

                        for (Pemesanan p : daftarPemesanan) {

                            if (p.getIdPemesanan().equals(idCari)) {

                                ditemukan = true;

                                String namaBaru;

                                while (true) {

                                    System.out.print("Nama Penumpang Baru : ");
                                    namaBaru = input.nextLine();

                                    if (namaBaru.trim().isEmpty()) {
                                        System.out.println("Nama tidak boleh kosong.");
                                        continue;
                                    }

                                    boolean namaValid = true;

                                    for (int i = 0; i < namaBaru.length(); i++) {

                                        char karakter = namaBaru.charAt(i);

                                        if (!Character.isLetter(karakter) && karakter != ' ') {
                                            namaValid = false;
                                            break;
                                        }
                                    }

                                    if (!namaValid) {
                                        System.out.println("Nama hanya boleh berisi huruf dan spasi.");
                                    } else {
                                        break;
                                    }
                                }

                                String nikBaru;

                                while (true) {

                                    System.out.print("NIK Baru            : ");
                                    nikBaru = input.nextLine();

                                    if (nikBaru.length() != 16) {
                                        System.out.println("NIK harus terdiri dari 16 digit.");
                                        continue;
                                    }

                                    boolean nikValid = true;

                                    for (int i = 0; i < nikBaru.length(); i++) {

                                        if (!Character.isDigit(nikBaru.charAt(i))) {
                                            nikValid = false;
                                            break;
                                        }
                                    }

                                    if (!nikValid) {
                                        System.out.println("NIK hanya boleh berisi angka.");
                                    } else {
                                        break;
                                    }
                                }

                                int umurBaru;

                                while (true) {

                                    System.out.print("Umur Baru           : ");
                                    String inputUmur = input.nextLine();

                                    if (inputUmur.trim().isEmpty()) {
                                        System.out.println("Umur tidak boleh kosong.");
                                        continue;
                                    }

                                    if (inputUmur.length() > 3) {
                                        System.out.println("Umur maksimal 3 angka.");
                                        continue;
                                    }

                                    boolean umurValid = true;

                                    for (int i = 0; i < inputUmur.length(); i++) {

                                        if (!Character.isDigit(inputUmur.charAt(i))) {
                                            umurValid = false;
                                            break;
                                        }
                                    }

                                    if (!umurValid) {
                                        System.out.println("Umur hanya boleh berupa angka.");
                                        continue;
                                    }

                                    umurBaru = Integer.parseInt(inputUmur);

                                    if (umurBaru <= 0) {
                                        System.out.println("Umur harus lebih dari 0.");
                                        continue;
                                    }

                                    break;
                                }

                                int pilihKapalBaru;

                                while (true) {

                                    System.out.println();
                                    System.out.println("Pilihan Kapal:");
                                    System.out.println("1. KM Bukit Siguntang - Balikpapan - VIP - Rp150000");
                                    System.out.println("2. KM Lambelu - Makassar - Ekonomi - Rp200000");
                                    System.out.println("3. KM Dorolonda - Parepare - Ekonomi - Rp175000");
                                    System.out.print("Pilih kapal baru: ");

                                    try {

                                        pilihKapalBaru = Integer.parseInt(input.nextLine());

                                        if (pilihKapalBaru >= 1 && pilihKapalBaru <= 3) {
                                            break;
                                        }

                                        System.out.println("Pilihan kapal hanya 1-3.");

                                    } catch (NumberFormatException e) {

                                        System.out.println("Input harus berupa angka.");
                                    }
                                }

                                Kapal kapalBaru;

                                if (pilihKapalBaru == 1) {

                                    kapalBaru = new KapalVIP(
                                            "KM Bukit Siguntang",
                                            "Balikpapan",
                                            150000,
                                            "Kabin pribadi"
                                    );

                                } else if (pilihKapalBaru == 2) {

                                    kapalBaru = new KapalEkonomi(
                                            "KM Lambelu",
                                            "Makassar",
                                            200000,
                                            "Kursi penumpang"
                                    );

                                } else {

                                    kapalBaru = new KapalEkonomi(
                                            "KM Dorolonda",
                                            "Parepare",
                                            175000,
                                            "Kursi penumpang"
                                    );
                                }

                                int jumlahBaru;

                                while (true) {

                                    System.out.print("Jumlah Tiket Baru   : ");

                                    try {

                                        jumlahBaru = Integer.parseInt(input.nextLine());

                                        if (jumlahBaru > 0) {
                                            break;
                                        }

                                        System.out.println("Jumlah tiket harus lebih dari 0.");

                                    } catch (NumberFormatException e) {

                                        System.out.println("Jumlah tiket harus berupa angka.");
                                    }
                                }

                                p.getPenumpang().setNama(namaBaru);
                                p.getPenumpang().setNik(nikBaru);
                                p.getPenumpang().setUmur(umurBaru);
                                p.setKapal(kapalBaru);
                                p.setJumlahTiket(jumlahBaru);

                                System.out.println();
                                System.out.println("Data berhasil diubah.");

                                break;
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("ID Pemesanan tidak ditemukan.");
                        }

                        break;

                    case 4:

                        System.out.println();
                        System.out.println("===== HAPUS PEMESANAN =====");
                        System.out.print("Masukkan ID Pemesanan: ");

                        String idHapus = input.nextLine();
                        boolean ditemukanHapus = false;

                        for (int i = 0; i < daftarPemesanan.size(); i++) {

                            Pemesanan p = daftarPemesanan.get(i);

                            if (p.getIdPemesanan().equals(idHapus)) {

                                ditemukanHapus = true;

                                System.out.println();
                                System.out.println("Data ditemukan.");
                                System.out.println("Nama Penumpang : "
                                        + p.getPenumpang().getNama());

                                System.out.println();
                                System.out.println("Apakah yakin ingin menghapus?");
                                System.out.println("1. Ya, hapus data");
                                System.out.println("2. Tidak, batalkan");
                                System.out.print("Pilih: ");

                                int konfirmasi;

                                while (true) {

                                    try {

                                        konfirmasi = Integer.parseInt(input.nextLine());

                                        if (konfirmasi == 1 || konfirmasi == 2) {
                                            break;
                                        }

                                        System.out.println("Pilihan hanya 1 atau 2.");

                                    } catch (NumberFormatException e) {

                                        System.out.println("Input harus berupa angka.");
                                    }
                                }

                                if (konfirmasi == 1) {

                                    daftarPemesanan.remove(i);
                                    System.out.println("Data berhasil dihapus.");

                                } else {

                                    System.out.println("Penghapusan dibatalkan.");
                                }

                                break;
                            }
                        }

                        if (!ditemukanHapus) {
                            System.out.println("ID Pemesanan tidak ditemukan.");
                        }

                        break;

                    case 5:

                        System.out.println();
                        System.out.println("Program selesai.");
                        System.out.println("Terima kasih.");

                        break;
                }

            } while (pilihan != 5);
        }
    }
}