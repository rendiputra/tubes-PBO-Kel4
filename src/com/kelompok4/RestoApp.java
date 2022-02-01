package com.kelompok4;

/** Import package (Materi Mengelola Class - modul 5)*/
import java.util.Scanner;
import java.util.ArrayList;

public class RestoApp {
    // Menu makanan
    public static Makanan[] menu = {
            new Makanan("Pizza", 90_000),
            new Makanan("Burger", 15_000),
            new Makanan("Cola", 8000),
            new Makanan("Lemon", 9000),
    };

    public static ArrayList<Pesanan> keranjang = new ArrayList<>();

    public static void main(String[] args) {
        // memeriksa error saat runtime(running) program | (Materi Exeption - modul 9)
        try {
            /** deklarasi */
            Authentication auth = new Authentication();

            // (Materi Input dan Tipe data - modul 2)
            Scanner scan = new Scanner(System.in);
            boolean authCheck = false;
            String username, password;

            /** login */
            do {
                System.out.print("Masukan username: ");
                username = scan.nextLine();
                System.out.print("Masukan password: ");
                password = scan.nextLine();

                /** memanggil method login() dari class Authentication untuk memvalidasi username dan password */
                authCheck = auth.login(username, password);
            } while (!authCheck); // mengulang terus-menerus sampai nilai variable authCheck bernilai True

            /** memesan pesanan */
            tampilMenu(); // memanggil method tampilMenu() untuk menampilkan menu

        // menangkap error dan menampilkan pesan errornya
        } catch (Exception e){
            System.out.println("500: Server Error | " + e.getMessage());
        }
    }

    /** Berfungsi untuk menampilkan menu
     *
     *  @return void
     */
    public static void tampilMenu() {
        // memeriksa error saat runtime(running) program | (Materi Exeption - modul 9)
        try {
            // (Materi Input dan Tipe data - modul 2)
            Scanner scan = new Scanner(System.in);
            char ulangMenu = 'N';
            int pilihan, qty;

            // mengulangi memilih menu hingga variable ulangMenu bernilai selain 'Y'
            do {
                // Untuk menampilkan menu
                System.out.println("Daftar menu hidangan:");
                for(int i=0; i<menu.length; i++) {
                    System.out.println((i+1) + ". " + menu[i].getNama() + " - Rp " + menu[i].getHarga());
                }
                System.out.print("Masukan pilihan menu: ");
                pilihan = scan.nextInt() - 1;

                if(pilihan >= 0 && pilihan < menu.length) {
                    System.out.print("Masukan banyak pesanan: ");
                    qty = scan.nextInt();

                    // Minyimpan pesanan kedalam array list
                    keranjang.add(new Pesanan(menu[pilihan], qty));
                } else {
                    System.out.println("Error: Tolong pilih yang benar!\n");
                }

                System.out.print("\nApakah anda ingin melakukan pemesanan lagi? ('Y'/'N') : ");
                ulangMenu = scan.next().toUpperCase().charAt(0);
            } while (ulangMenu == 'Y');

            // panggil method rekapPesanan
            rekapPesanan();

        // menangkap error dan menampilkan pesan errornya
        } catch (Exception e){
            System.out.println("500: Server Error | " + e.getMessage());
        }
    }


    /** method untuk menampilkan daftar pesanan dan total biayanya
     *
     * @return void
     */
    public static void rekapPesanan(){
        // memeriksa error saat runtime(running) program | (Materi Exeption - modul 9)
        try {
            // (Materi Tipe data - modul 2)
            int total = 0;

            System.out.println(
                    "\n\n=========================================================================\n" +
                    "\t\t\t\t\t\t\tRekap Pesanan\n" +
                    "=========================================================================\n" +
                    "Nama pesanan\t\tKunatitas\t\tharga\t\t\t\tSubTotal\n" +
                    "-------------------------------------------------------------------------"
            );

            // mengeluarkan data dari ArrayList
            for (int i = 0; i < keranjang.size(); i++) {
                int subBiaya = keranjang.get(i).getMakanan().getHarga() * keranjang.get(i).getJumlah();
                total += subBiaya;
                System.out.println(
                        keranjang.get(i).getMakanan().getNama()+ "\t\t\t\t" +
                        keranjang.get(i).getJumlah() + " porsi" + "\t\t\t" +
                        "Rp. " + keranjang.get(i).getMakanan().getHarga() + "\t\t\t" +
                        "Rp. " + subBiaya
                );
            }
            System.out.println(
                    "-------------------------------------------------------------------------\n" +
                    "\t\t\t\t\t\t\t\t\tTotal:\t\t\t\t" + "Rp. " + total + "\n" +
                    "========================================================================="
            );

            // menangkap error dan menampilkan pesan errornya
        } catch (Exception e){
            System.out.println("500: Server Error | " + e.getMessage());
        }
    }
}
