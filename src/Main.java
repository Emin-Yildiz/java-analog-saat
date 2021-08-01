import javax.swing.*;

public class Main extends JFrame {


    public static void main(String[]args) {

        Main ekran = new Main();

        ekran.setResizable(false); // Bu ve aşağıdaki 2 metod bizim yaptığımız işlemlerin JPanel üzerinde olmasını sağlıcak, ayrıca ekranı kenarlardan büyütüp küçültmeyide engelliyecek.
        ekran.setFocusable(false); // mause klavye gibi işlemlerin JPanel üzerinde olmasını sağlar
        ekran.setTitle("Analog Saat"); // Açılan pencerenin adını angry birds yaptık.



        SaatEkrani saatEkrani = new SaatEkrani();
        saatEkrani.requestFocus(); // Klavye mause gibi işlevleri direk bu komut ile oyuna aktardık burda oyun odağı bana ver diyor.

        saatEkrani.setFocusable(false); // Burda odağı oyuna verdik
        saatEkrani.setFocusTraversalKeysEnabled(false); // Klavye işlemlerinin JPanelin anlaması için gererkli metod

        ekran.add(saatEkrani); // JPaneli JFrame'e ekledik

        //ekran.setSize(oyun.getEkranGenislik(),oyun.getEkranUzunluk());
        ekran.setVisible(true);
        ekran.setSize(saatEkrani.getEkranGenislik(),saatEkrani.getEkranUzunluk()); // Açılaacak pencerenin uzunluğu ve genişliği oyun classında tanımlandı.


    }

}