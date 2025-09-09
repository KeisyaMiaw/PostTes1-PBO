// Nama: Keisya Siti Nafisa Andini
// NIM: 2409116115

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PostTest1;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // class Kos
    static class Kos {
        private int nomorKamar;
        private String namaPenyewa;
        private Boolean statusKamar;
        private String nomorTelepon;
        private int lantai;

        // constructor
        Kos(int nomorKamar, String namaPenyewa, Boolean statusKamar, String nomorTelepon, int lantai) {
            this.nomorKamar = nomorKamar;
            this.namaPenyewa = namaPenyewa;
            this.statusKamar = statusKamar;
            this.nomorTelepon = nomorTelepon;
            this.lantai = lantai;
        }

        // method getter
        public int getNomorKamar() { 
            return nomorKamar; }
        public String getNamaPenyewa() { 
            return namaPenyewa; }
        public Boolean getStatusKamar() { 
            return statusKamar; }
        public String getNomorTelepon() { 
            return nomorTelepon; }
        public int getLantai() { 
            return lantai; }

//        method setter
        public void setNomorKamar(int nomorKamar) { 
            this.nomorKamar = nomorKamar; }
        public void setNamaPenyewa(String namaPenyewa) { 
            this.namaPenyewa = namaPenyewa; }
        public void setStatusKamar(Boolean statusKamar) { 
            this.statusKamar = statusKamar; }
        public void setNomorTelepon(String nomorTelepon) { 
            this.nomorTelepon = nomorTelepon; }
        public void setLantai(int lantai) { 
            this.lantai = lantai; }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Kos> daftarKos = new ArrayList<>();
            int pilih;
            
            do {
                System.out.println("\n ~~~> Menu Admin Kos <~~~");
                System.out.println("1. Tambah Data Kos");
                System.out.println("2. Lihat Data Kos");
                System.out.println("3. Update Data Kos");
                System.out.println("4. Hapus Data Kos");
                System.out.println("5. Keluar");
                pilih = sc.nextInt();
                sc.nextLine();
                
                switch (pilih) {
                    case 1 -> {
                        System.out.print("Nomor Kamar: ");
                        int nomorKamar = sc.nextInt(); sc.nextLine();
                        System.out.print("Nama Penyewa: ");
                        String namaPenyewa = sc.nextLine();
                        System.out.print("Status Kamar (true=Terisi, false=Kosong): ");
                        Boolean status = sc.nextBoolean(); sc.nextLine();
                        System.out.print("Nomor Telepon: ");
                        String noTelp = sc.nextLine();
                        System.out.print("Lantai: ");
                        int lantai = sc.nextInt();
                        
                        daftarKos.add(new Kos(nomorKamar, namaPenyewa, status, noTelp, lantai));
                        System.out.println("Data kos telah ditambahkan");
                    }
                        
                    case 2 -> {
                        if (daftarKos.isEmpty()) {
                            System.out.println("Data kos masih kosong");
                        } else {
                            System.out.println("\n >>> Daftar Kos <<<");
                            for (Kos k : daftarKos) {
                                System.out.println("Kamar: " + k.getNomorKamar()
                                        + " / Penyewa: " + k.getNamaPenyewa()
                                        + " / Status: " + (k.getStatusKamar() ? "Terisi" : "Kosong")
                                        + " / No Telp: " + k.getNomorTelepon()
                                        + " / Lantai: " + k.getLantai());
                            }
                        }
                    }
                        
                    case 3 -> {
                        // Update
                        System.out.print("Masukkan nomor kamar yang ingin diupdate: ");
                        int updateNo = sc.nextInt(); sc.nextLine();
                        boolean ketemu = false;
                        
                        for (Kos k : daftarKos) {
                            if (k.getNomorKamar() == updateNo) {
                                System.out.print("Nama: ");
                                k.setNamaPenyewa(sc.nextLine());
                                System.out.print("Status (true=Terisi, false=Kosong): ");
                                k.setStatusKamar(sc.nextBoolean()); sc.nextLine();
                                System.out.print("Nomor Telepon: ");
                                k.setNomorTelepon(sc.nextLine());
                                System.out.print("Lantai: ");
                                k.setLantai(sc.nextInt());
                                ketemu = true;
                                System.out.println("Data telah diupdate");
                                break;
                            }
                        }
                        if (!ketemu) {
                            System.out.println("Data kamar tidak valid");
                        }
                    }
                        
                    case 4 -> {
                        // Hapus
                        System.out.print("Masukkan nomor kamar yang ingin dihapus: ");
                        int hapusNo = sc.nextInt(); sc.nextLine();
                        Kos hapus = null;
                        for (Kos k : daftarKos) {
                            if (k.getNomorKamar() == hapusNo) {
                                hapus = k;
                                break;
                            }
                        }
                        if (hapus != null) {
                            daftarKos.remove(hapus);
                            System.out.println("Data berhasil dihapus");
                        } else {
                            System.out.println("Data kamar tidak valid");
                        }
                    }
                        
                    case 5 -> System.out.println("Anda telah keluar dari program");
                        
                    default -> System.out.println("Menu tidak tersedia");
                }
            } while (pilih != 5);
        }
    }
}

