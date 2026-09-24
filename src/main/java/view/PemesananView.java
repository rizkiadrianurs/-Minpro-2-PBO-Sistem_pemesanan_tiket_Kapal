/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Pemesanan;

/**
 *
 * @author ACER
 */
public class PemesananView {

    private Scanner input;

    public PemesananView() {
        input = new Scanner(System.in);
    }

    public void tampilkanMenu() {
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
    }

    public int inputPilihanMenu() {
        while (true) {
            System.out.print("Pilih menu: ");

            try {
                int pilihan = Integer.parseInt(input.nextLine());

                if (pilihan >= 1 && pilihan <= 5) {
                    return pilihan;
                }

                System.out.println("Pilihan menu harus 1-5.");

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    public String inputIdPemesanan() {
        while (true) {
            System.out.print("ID Pemesanan   : ");
            String id = input.nextLine();

            if (id.trim().isEmpty()) {
                System.out.println("ID tidak boleh kosong.");
                continue;
            }

            if (id.length() != 3) {
                System.out.println("ID harus terdiri dari 3 angka.");
                continue;
            }

            boolean idValid = true;

            for (int i = 0; i < id.length(); i++) {
                if (!Character.isDigit(id.charAt(i))) {
                    idValid = false;
                    break;
                }
            }

            if (!idValid) {
                System.out.println("ID hanya boleh berisi angka.");
            } else {
                return id;
            }
        }
    }

    public String inputNama() {
        while (true) {
            System.out.print("Nama Penumpang : ");
            String nama = input.nextLine();

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
                return nama;
            }
        }
    }

    public String inputNik() {
        while (true) {
            System.out.print("NIK            : ");
            String nik = input.nextLine();

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
                return nik;
            }
        }
    }

    public int inputUmur() {
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

            int umur = Integer.parseInt(inputUmur);

            if (umur <= 0) {
                System.out.println("Umur harus lebih dari 0.");
                continue;
            }

            return umur;
        }
    }

    public int inputPilihanKapal() {
        while (true) {
            System.out.println();
            System.out.println("Pilihan Kapal:");
            System.out.println("1. KM Bukit Siguntang - Balikpapan - VIP - Rp150000");
            System.out.println("2. KM Lambelu - Makassar - Ekonomi - Rp200000");
            System.out.println("3. KM Dorolonda - Parepare - Ekonomi - Rp175000");
            System.out.print("Pilih kapal: ");

            try {
                int pilihan = Integer.parseInt(input.nextLine());

                if (pilihan >= 1 && pilihan <= 3) {
                    return pilihan;
                }

                System.out.println("Pilihan kapal hanya 1-3.");

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    public int inputJumlahTiket() {
        while (true) {
            System.out.print("Jumlah Tiket   : ");

            try {
                int jumlah = Integer.parseInt(input.nextLine());

                if (jumlah > 0) {
                    return jumlah;
                }

                System.out.println("Jumlah tiket harus lebih dari 0.");

            } catch (NumberFormatException e) {
                System.out.println("Jumlah tiket harus berupa angka.");
            }
        }
    }

    public String inputIdCari() {
        System.out.print("Masukkan ID Pemesanan: ");
        return input.nextLine();
    }

    public int inputPilihanKapalBaru() {
        return inputPilihanKapal();
    }

    public int inputJumlahTiketBaru() {
        System.out.print("Jumlah Tiket Baru   : ");

        while (true) {
            try {
                int jumlah = Integer.parseInt(input.nextLine());

                if (jumlah > 0) {
                    return jumlah;
                }

                System.out.println("Jumlah tiket harus lebih dari 0.");

            } catch (NumberFormatException e) {
                System.out.println("Jumlah tiket harus berupa angka.");
            }

            System.out.print("Jumlah Tiket Baru   : ");
        }
    }

    public int inputKonfirmasiHapus() {
        while (true) {
            System.out.println();
            System.out.println("Apakah yakin ingin menghapus?");
            System.out.println("1. Ya, hapus data");
            System.out.println("2. Tidak, batalkan");
            System.out.print("Pilih: ");

            try {
                int pilihan = Integer.parseInt(input.nextLine());

                if (pilihan == 1 || pilihan == 2) {
                    return pilihan;
                }

                System.out.println("Pilihan hanya 1 atau 2.");

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    public void tampilkanDaftarPemesanan(
            ArrayList<Pemesanan> daftarPemesanan) {

        System.out.println();
        System.out.println("===== DAFTAR PEMESANAN =====");

        if (daftarPemesanan.isEmpty()) {
            System.out.println("Belum ada data pemesanan.");
            return;
        }

        for (int i = 0; i < daftarPemesanan.size(); i++) {

            Pemesanan p = daftarPemesanan.get(i);

            System.out.println();
            System.out.println("Data ke-" + (i + 1));
            System.out.println("ID Pemesanan   : " + p.getIdPemesanan());
            System.out.println("Nama Penumpang : "
                    + p.getPenumpang().getNama());
            System.out.println("NIK            : "
                    + p.getPenumpang().getNik());
            System.out.println("Umur           : "
                    + p.getPenumpang().getUmur());

            p.getKapal().tampilkanInfo();

            System.out.println("Jumlah Tiket   : " + p.getJumlahTiket());
            System.out.println("Total Harga    : Rp" + p.getTotalHarga());
        }
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
}
