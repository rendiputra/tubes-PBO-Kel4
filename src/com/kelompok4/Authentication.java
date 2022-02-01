package com.kelompok4;

public class Authentication {
    /** (Materi Information hiding - modul 4 && Materi deklarasikan atribut - Modul 3) */
    private String username = "admin";
    private String password = "admin123";

    /** berfungsi untuk mengecek validasi username dan password
     *
     * @return Boolean
     */
    public boolean login(String paramUsername, String paramPassword) {
        // memeriksa error saat runtime(running) program | (Materi Exeption - modul 9)
        try{
            if(paramUsername.equals(getUsername()) && paramPassword.equals(getPassword())){
                System.out.println("\nLogin berhasil!");
                return true;
            } else {
                System.out.println("\nLogin gagal! Username dan password tidak valid!");
                return false;
            }

        // menangkap error dan menampilkan pesan errornya
        } catch (Exception e){
            System.out.println("500: Server Error | " + e.getMessage());
            return false;
        }
    }

    /** (Materi Enkapsulasi - modul 4) */
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
