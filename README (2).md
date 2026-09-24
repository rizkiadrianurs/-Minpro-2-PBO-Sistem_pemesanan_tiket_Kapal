# Minpro 2 PBO — Sistem Pemesanan Tiket Kapal

---

**Nama**  : Rizki Adrianur Saputra  
**NIM**   : 2509116049  
**Kelas** : B

---

## Deskripsi Singkat Program

Program ini merupakan Sistem Pemesanan Tiket Kapal berbasis Java yang dijalankan melalui console/CLI. Program ini merupakan pengembangan dari Minpro 1 dengan menambahkan konsep **Inheritance**, **Encapsulation**, **validasi input**, **dummy data**, **struktur MVC**, dan **Polymorphism**.

Pengguna dapat melakukan beberapa proses, yaitu:

- Menambahkan data pemesanan.
- Menampilkan seluruh data pemesanan.
- Mengubah data pemesanan.
- Menghapus data pemesanan.
- Mengakhiri program melalui menu keluar.

Program menyimpan data pemesanan sementara selama program berjalan menggunakan `ArrayList<Pemesanan>`. Saat program pertama kali dijalankan, `ArrayList` sudah berisi **2 dummy data** sehingga menu Tampilkan Pemesanan langsung menampilkan data tanpa perlu input dari awal.

---

## Struktur Package (MVC)

Program disusun menggunakan pola **MVC (Model – View – Controller)** yang dibagi ke dalam 4 package.

| Package | Kelas | Peran |
|---|---|---|
| `main` | `Sistem_pemesanan_tiket_Kapal` | Titik awal program. Hanya membuat objek controller dan menjalankannya. |
| `model` | `Kapal`, `KapalEkonomi`, `KapalVIP`, `Penumpang`, `Pemesanan` | Menyimpan data serta aturan data (atribut, getter/setter, perhitungan total harga). |
| `view` | `PemesananView` | Mengurus tampilan menu dan seluruh input dari pengguna beserta validasinya. |
| `controller` | `PemesananController` | Mengatur alur program, menyimpan `ArrayList<Pemesanan>`, mengisi dummy data, dan mengelola proses CRUD. |

### Struktur Folder

```text
Sistem_pemesanan_tiket_Kapal/
├── pom.xml
└── src/
    └── main/
        └── java/
            ├── main/
            │   └── Sistem_pemesanan_tiket_Kapal.java
            ├── controller/
            │   └── PemesananController.java
            ├── model/
            │   ├── Kapal.java
            │   ├── KapalEkonomi.java
            │   ├── KapalVIP.java
            │   ├── Pemesanan.java
            │   └── Penumpang.java
            └── view/
                └── PemesananView.java
```

---

## Struktur Kelas

| Kelas | Tanggung Jawab |
|---|---|
| `Kapal` | **Superclass.** Menyimpan data umum kapal berupa nama kapal, tujuan, dan harga tiket. |
| `KapalEkonomi` | **Subclass** dari `Kapal`. Menambahkan atribut `fasilitasEkonomi`. |
| `KapalVIP` | **Subclass** dari `Kapal`. Menambahkan atribut `fasilitasVIP`. |
| `Penumpang` | Menyimpan data penumpang berupa nama, NIK, dan umur. |
| `Pemesanan` | Menggabungkan data `Penumpang` dan `Kapal`, jumlah tiket, serta menghitung total harga. |
| `PemesananView` | Menampilkan menu, menerima input, dan memvalidasi input pengguna. |
| `PemesananController` | Menjalankan alur program dan mengelola proses CRUD data pemesanan. |
| `Sistem_pemesanan_tiket_Kapal` | Class utama yang berisi method `main`. |

---

## Penjelasan Alur Program

### 1. Program Dimulai

Program dijalankan melalui method `main` pada kelas `Sistem_pemesanan_tiket_Kapal`. Method tersebut membuat objek `PemesananController` lalu memanggil `jalankanProgram()`.

### 2. Pengisian Dummy Data

Saat objek `PemesananController` dibuat, constructor memanggil method `isiDummyData()` yang menambahkan 2 data awal ke dalam `ArrayList`:

| ID | Penumpang | Kapal | Tujuan | Jenis | Jumlah Tiket |
|---|---|---|---|---|---|
| 101 | Andi | KM Bukit Siguntang | Balikpapan | VIP | 2 |
| 102 | Budi | KM Lambelu | Makassar | Ekonomi | 1 |

### 3. Menu Utama

Program menampilkan menu utama secara berulang menggunakan perulangan `do-while`. Perulangan akan terus berjalan sampai pengguna memilih menu Keluar.

| No. | Menu | Fungsi |
|---|---|---|
| 1 | **Tambah Pemesanan** | Menambahkan data pemesanan tiket kapal. |
| 2 | **Tampilkan Pemesanan** | Menampilkan seluruh data pemesanan yang tersimpan. |
| 3 | **Ubah Pemesanan** | Mengubah data pemesanan yang telah tersimpan. |
| 4 | **Hapus Pemesanan** | Menghapus data pemesanan yang dipilih. |
| 5 | **Keluar** | Mengakhiri program. |

### 4. Penyimpanan Data

Data pemesanan disimpan sementara di dalam memori menggunakan `ArrayList<Pemesanan>`. Data dapat ditambah, ditampilkan, diubah, dan dihapus selama program masih berjalan.

### 5. Program Berakhir

Ketika pengguna memilih menu Keluar, kondisi perulangan `do-while` tidak terpenuhi sehingga perulangan berhenti dan program selesai dijalankan.

---

# Detail Menu Program

## 1. Tambah Pemesanan (Menu 1)

**Alur proses:**

- Pengguna memasukkan ID pemesanan. Sistem memeriksa format ID dan memastikan ID belum dipakai. Jika sudah dipakai, sistem menampilkan pesan "ID sudah digunakan." dan meminta input ulang.
- Pengguna memasukkan nama penumpang, NIK, dan umur.
- Sistem menampilkan tiga pilihan kapal beserta tujuan, jenis, dan harga tiket. Pengguna memilih salah satu.
- Berdasarkan pilihan, method `buatKapal()` pada controller membuat objek `KapalVIP` (pilihan 1) atau `KapalEkonomi` (pilihan 2 dan 3).
- Pengguna memasukkan jumlah tiket.
- Sistem membuat objek `Penumpang` dan `Pemesanan`, lalu menambahkannya ke `ArrayList` `daftarPemesanan`.
- Sistem menampilkan pesan "Pemesanan berhasil ditambahkan." beserta total harga dari `getTotalHarga()`.

**Pilihan kapal:**

| No. | Kapal | Tujuan | Jenis | Harga | Fasilitas |
|---|---|---|---|---|---|
| 1 | KM Bukit Siguntang | Balikpapan | VIP | Rp150000 | Kabin pribadi |
| 2 | KM Lambelu | Makassar | Ekonomi | Rp200000 | Kursi penumpang |
| 3 | KM Dorolonda | Parepare | Ekonomi | Rp175000 | Kursi penumpang |

---

## 2. Tampilkan Pemesanan (Menu 2)

**Alur proses:**

- Sistem memeriksa isi `ArrayList` `daftarPemesanan`.
- Jika belum terdapat data, sistem menampilkan pesan "Belum ada data pemesanan."
- Jika terdapat data, sistem menggunakan perulangan `for` untuk mengambil setiap objek `Pemesanan`.
- Sistem menampilkan ID pemesanan, nama penumpang, NIK, umur, informasi kapal, jumlah tiket, dan total harga.
- Informasi kapal ditampilkan melalui method `tampilkanInfo()`. Hasil tampilan berbeda untuk kapal VIP dan Ekonomi (lihat bagian Polymorphism).

---

## 3. Ubah Pemesanan (Menu 3)

**Alur proses:**

- Pengguna memasukkan ID pemesanan yang ingin diubah.
- Sistem mencari data berdasarkan `idPemesanan` pada `ArrayList`.
- Jika ID ditemukan, pengguna memasukkan data baru berupa nama penumpang, NIK, umur, pilihan kapal, dan jumlah tiket. Semua input baru divalidasi.
- Data `Penumpang` diperbarui menggunakan `setNama()`, `setNik()`, dan `setUmur()`.
- Data kapal dan jumlah tiket pada `Pemesanan` diperbarui menggunakan `setKapal()` dan `setJumlahTiket()`.
- Sistem menampilkan pesan "Data berhasil diubah."
- Jika ID tidak ditemukan, sistem menampilkan pesan "ID Pemesanan tidak ditemukan."

---

## 4. Hapus Pemesanan (Menu 4)

**Alur proses:**

- Pengguna memasukkan ID pemesanan yang ingin dihapus.
- Sistem mencari data berdasarkan `idPemesanan`.
- Jika ID ditemukan, sistem menampilkan nama penumpang lalu meminta konfirmasi (`1` = Ya, `2` = Tidak).
- Jika pengguna memilih `1`, objek `Pemesanan` dihapus dari `ArrayList` menggunakan `remove()` dan sistem menampilkan "Data berhasil dihapus."
- Jika pengguna memilih `2`, sistem menampilkan "Penghapusan dibatalkan."
- Jika ID tidak ditemukan, sistem menampilkan pesan "ID Pemesanan tidak ditemukan."

---

## 5. Keluar (Menu 5)

**Alur proses:**

- Pengguna memilih menu **5. Keluar**.
- Sistem menampilkan pesan "Program selesai." dan "Terima kasih."
- Nilai `pilihan` menjadi `5`, sehingga kondisi pada perulangan `do-while` tidak terpenuhi dan program berhenti.

---

# Penerapan Konsep Wajib

## 1. Access Modifier

| Modifier | Penerapan |
|---|---|
| `private` | Seluruh atribut pada kelas model (`Kapal`, `KapalEkonomi`, `KapalVIP`, `Penumpang`, `Pemesanan`), atribut `daftarPemesanan` dan `view` pada controller, atribut `input` (`Scanner`) pada view, serta method bantu pada controller seperti `isiDummyData()`, `tambahPemesanan()`, `ubahPemesanan()`, `hapusPemesanan()`, `idSudahAda()`, dan `buatKapal()`. |
| `public` | Constructor, getter, setter, `tampilkanInfo()`, `getTotalHarga()`, method input pada view, dan `jalankanProgram()` pada controller. |

Dengan demikian, data tidak dapat diakses secara langsung dari luar kelas dan hanya dapat diakses melalui method yang disediakan.

## 2. Encapsulation

Setiap atribut dibuat `private` dan diakses melalui **getter** dan **setter**. Setter juga berfungsi sebagai penjaga agar data yang masuk tetap valid.

| Kelas | Atribut | Getter | Setter | Aturan pada Setter |
|---|---|---|---|---|
| `Kapal` | `namaKapal` | `getNamaKapal()` | `setNamaKapal()` | Tidak boleh `null` atau kosong. |
| `Kapal` | `tujuan` | `getTujuan()` | `setTujuan()` | Tidak boleh `null` atau kosong. |
| `Kapal` | `hargaTiket` | `getHargaTiket()` | `setHargaTiket()` | Harus lebih dari 0. |
| `KapalEkonomi` | `fasilitasEkonomi` | `getFasilitasEkonomi()` | `setFasilitasEkonomi()` | Tidak boleh `null` atau kosong. |
| `KapalVIP` | `fasilitasVIP` | `getFasilitasVIP()` | `setFasilitasVIP()` | Tidak boleh `null` atau kosong. |
| `Penumpang` | `nama` | `getNama()` | `setNama()` | Tidak boleh `null` atau kosong. |
| `Penumpang` | `nik` | `getNik()` | `setNik()` | Tidak boleh `null` atau kosong. |
| `Penumpang` | `umur` | `getUmur()` | `setUmur()` | Harus lebih dari 0. |
| `Pemesanan` | `idPemesanan` | `getIdPemesanan()` | — | Dibuat `final` sehingga ID tidak dapat diubah setelah dibuat. |
| `Pemesanan` | `penumpang` | `getPenumpang()` | `setPenumpang()` | Tidak boleh `null`. |
| `Pemesanan` | `kapal` | `getKapal()` | `setKapal()` | Tidak boleh `null`. |
| `Pemesanan` | `jumlahTiket` | `getJumlahTiket()` | `setJumlahTiket()` | Harus lebih dari 0. |

## 3. Inheritance

Program memiliki **1 superclass** dan **2 subclass**.

```text
                Kapal  (superclass)
                  │   namaKapal, tujuan, hargaTiket
        ┌─────────┴─────────┐
  KapalEkonomi           KapalVIP   (subclass)
  + fasilitasEkonomi     + fasilitasVIP
```

- `KapalEkonomi` dan `KapalVIP` mewarisi atribut dan method dari `Kapal` menggunakan kata kunci `extends`.
- Constructor subclass memanggil constructor superclass menggunakan `super(namaKapal, tujuan, hargaTiket)`.
- Setiap subclass menambahkan atribut khusus, yaitu `fasilitasEkonomi` pada `KapalEkonomi` dan `fasilitasVIP` pada `KapalVIP`.
- Subclass mengambil data dari superclass melalui getter (`getNamaKapal()`, `getTujuan()`, `getHargaTiket()`) karena atribut superclass bersifat `private`.

## 4. Validasi Input

Validasi input diterapkan di dua lapisan: pada **view** (saat pengguna mengetik) dan pada **setter model** (sebagai lapisan pengaman data). Jika input tidak valid, sistem menampilkan pesan kesalahan dan meminta pengguna memasukkan ulang sampai benar.

| Input | Aturan Validasi | Pesan Kesalahan |
|---|---|---|
| Pilihan menu | Harus angka dan bernilai 1–5. | "Input harus berupa angka." / "Pilihan menu harus 1-5." |
| ID Pemesanan | Tidak boleh kosong, harus 3 karakter, hanya angka, dan tidak boleh sama dengan ID yang sudah ada. | "ID tidak boleh kosong." / "ID harus terdiri dari 3 angka." / "ID hanya boleh berisi angka." / "ID sudah digunakan." |
| Nama Penumpang | Tidak boleh kosong, hanya huruf dan spasi. | "Nama tidak boleh kosong." / "Nama hanya boleh berisi huruf dan spasi." |
| NIK | Harus tepat 16 karakter dan hanya angka. | "NIK harus terdiri dari 16 digit." / "NIK hanya boleh berisi angka." |
| Umur | Tidak boleh kosong, maksimal 3 angka, hanya angka, dan harus lebih dari 0. | "Umur tidak boleh kosong." / "Umur maksimal 3 angka." / "Umur hanya boleh berupa angka." / "Umur harus lebih dari 0." |
| Pilihan kapal | Harus angka dan bernilai 1–3. | "Input harus berupa angka." / "Pilihan kapal hanya 1-3." |
| Jumlah tiket | Harus angka dan lebih dari 0. | "Jumlah tiket harus berupa angka." / "Jumlah tiket harus lebih dari 0." |
| Konfirmasi hapus | Harus angka `1` atau `2`. | "Input harus berupa angka." / "Pilihan hanya 1 atau 2." |

Selain itu, `NumberFormatException` ditangani dengan `try-catch` sehingga program tidak berhenti ketika pengguna memasukkan huruf pada input yang seharusnya angka.

## 5. Dummy Data

Method `isiDummyData()` pada `PemesananController` dipanggil di dalam constructor sehingga `ArrayList<Pemesanan>` sudah berisi 2 data (ID `101` dan `102`) ketika program pertama kali berjalan. Menu Tampilkan Pemesanan langsung menampilkan data tersebut tanpa perlu menambah data terlebih dahulu.

---

# Penerapan Nilai Tambah

## 1. Struktur MVC

Nilai tambah MVC diterapkan dengan memisahkan program ke dalam package `model`, `view`, dan `controller` (penjelasan lengkap pada bagian **Struktur Package (MVC)** di atas).

| Komponen | Letak | Contoh Penerapan |
|---|---|---|
| **Model** | package `model` | `Kapal`, `KapalEkonomi`, `KapalVIP`, `Penumpang`, dan `Pemesanan` menyimpan data dan menghitung total harga. |
| **View** | package `view` | `PemesananView` menampilkan menu, menerima input, memvalidasinya, dan menampilkan daftar pemesanan. |
| **Controller** | package `controller` | `PemesananController` menghubungkan model dan view, menyimpan `ArrayList`, serta menjalankan proses tambah, tampil, ubah, dan hapus. |

## 2. Polymorphism (Method Overriding)

Method `tampilkanInfo()` didefinisikan pada superclass `Kapal`, lalu **di-override** pada masing-masing subclass agar menampilkan fasilitas yang sesuai.

| Kelas | Letak Method | Hasil Tampilan |
|---|---|---|
| `Kapal` | `model/Kapal.java` | Nama kapal, tujuan, dan harga tiket. |
| `KapalEkonomi` | `model/KapalEkonomi.java` | Nama kapal, tujuan, harga tiket, dan **Fasilitas Ekonomi**. |
| `KapalVIP` | `model/KapalVIP.java` | Nama kapal, tujuan, harga tiket, dan **Fasilitas VIP**. |

**Letak pemanggilan polymorphism:** pada `PemesananView.tampilkanDaftarPemesanan()` terdapat pemanggilan `p.getKapal().tampilkanInfo()`. Tipe variabelnya adalah `Kapal`, tetapi objek yang sebenarnya bisa berupa `KapalVIP` atau `KapalEkonomi`. Java secara otomatis memilih versi `tampilkanInfo()` yang sesuai dengan jenis objek pada saat program berjalan.

Selain itu, method `buatKapal()` pada controller mengembalikan tipe `Kapal` tetapi membuat objek `KapalVIP` atau `KapalEkonomi` (upcasting), sehingga satu `ArrayList<Pemesanan>` dapat menampung berbagai jenis kapal.

---

# Gambaran Output

## 1. Menu Utama

<img width="403" height="238" alt="Screenshot 2026-09-24 164227" src="https://github.com/user-attachments/assets/0bda7e13-9d02-411f-a5cd-a475a39341f4" />

Pada bagian ini, sistem menampilkan 5 menu utama, yaitu Tambah Pemesanan, Tampilkan Pemesanan, Ubah Pemesanan, Hapus Pemesanan, dan Keluar.

---

## 2. Tambah Pemesanan

<img width="495" height="571" alt="image" src="https://github.com/user-attachments/assets/c3aec39e-03c5-44d4-bd4f-3f72a6fda8f7" />

Pada bagian ini, pengguna memasukkan data penumpang, memilih kapal, dan menentukan jumlah tiket. Sistem menyimpan data serta menghitung total harga secara otomatis.

---

## 3. Tampilkan Pemesanan (Dummy Data)

<img width="393" height="997" alt="image" src="https://github.com/user-attachments/assets/b6837b5b-68f7-45d7-9151-e1a8bf909c69" />

Pada bagian ini, data dummy langsung tampil tanpa perlu menambah data terlebih dahulu. Informasi kapal VIP dan Ekonomi ditampilkan dengan fasilitas yang berbeda (polymorphism).

---

## 4. Ubah Pemesanan

<img width="512" height="545" alt="image" src="https://github.com/user-attachments/assets/f470d58c-5cde-4c0e-8a46-ce6e891a78db" />

Pada bagian ini, pengguna memasukkan ID pemesanan yang ingin diperbarui. Setelah data baru dimasukkan, sistem memperbarui informasi pemesanan dan menampilkan pesan "Data berhasil diubah."

### Output Perubahan

<img width="412" height="258" alt="image" src="https://github.com/user-attachments/assets/c9ec51dc-a76f-490b-b3fc-0278f00f0a6d" />

---

## 5. Hapus Pemesanan

📷 **Tempat gambar: proses hapus dengan konfirmasi**

<img width="358" height="257" alt="image" src="https://github.com/user-attachments/assets/69bed670-a2fd-4bde-a9ac-f15ce10b6b83" />

Pada bagian ini, pengguna memasukkan ID pemesanan dan mengonfirmasi penghapusan. Jika pengguna memilih "Ya", sistem menghapus data dari `ArrayList` dan menampilkan pesan "Data berhasil dihapus."

### Output Perubahan

<img width="436" height="782" alt="image" src="https://github.com/user-attachments/assets/d567e4d3-e13f-4afb-a167-e62530fe79ae" />

---

## 6. Keluar

📷 **Tempat gambar: tampilan setelah memilih menu Keluar**

<img width="678" height="410" alt="image" src="https://github.com/user-attachments/assets/e96bbc89-6a94-4b55-924d-9572432a0415" />

Pada bagian ini, pengguna memilih menu Keluar untuk mengakhiri program. Sistem menghentikan perulangan dan menampilkan pesan "Program selesai." dan "Terima kasih."
