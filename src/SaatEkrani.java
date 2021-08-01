import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.Calendar;

public class SaatEkrani extends JPanel implements ActionListener {

    private int ekranGenislik = 400;

    private int ekranUzunluk = 400;

    private final int derece = 6;//her dakika arasındaki açı

    private int yariCap = 180;

    private Point center=new Point(200,200);// saat dairesinin merkez noktası olması gerekriyor.

    private final int delay = 10;

    Timer timer = new Timer(delay, this);




    public SaatEkrani(){
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
         //Eğer bu nesneyi metod dışında tanımlarsak anlık olarak dakika, saat ve saniyeyi alamıyoruz.
        Graphics2D g2d = (Graphics2D) g;
        Calendar calender = Calendar.getInstance();
        drawSaat(g2d,calender);
        drawSaniye(g2d,calender);
        drawAkrep(g2d,calender);
        drawYelkovan(g2d,calender);

    }

    private void drawSaat(Graphics2D g2d, Calendar calender) {
        g2d.drawOval(13,0,yariCap*2,yariCap*2);//saatin oval kısmını çizdirdik.

        for(int i=1;i<=12;i++){ //Bu döngü saatin 12 rakamınıda yazmak için kullanılıyor.
            double hour=Math.PI/6; //pi sayısını 6ya bölmemizin sebebi 12 sayınında ekrana çizdirilmesidir. eğer 3 yaparsak 6 ane sayı ekrana yazdırılır.
            int x=(int)(center.x-10+(yariCap-8)*Math.sin(i*hour));//birim çemberde x ekseni ekseni sinustur.
            int y=(int)(center.y-13-(yariCap-8)*Math.cos(i*hour));//birim çemberde y ekseni cosinusdür.
            g2d.setPaint(Color.black);
            g2d.drawString(Integer.toString(i),x,y);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    /*
       Aşağıdaki yarıçapı 20,35 ve 15 kısaltmamızın sebebi çizilen çizgilerin uzunluğunu kısaltmak.
     */
    private void drawYelkovan(Graphics2D g2d, Calendar calender) {
        int minute=calender.get(Calendar.MINUTE);
        double radian=Math.toRadians(derece*minute);
        int x=(int)(center.x+(yariCap-20)*Math.sin(radian));
        int y=(int)(center.y-(yariCap-20)*Math.cos(radian)+ -10);
        g2d.setPaint(Color.black);
        g2d.drawLine(center.x,center.y-15,x,y);
    }

    private void drawAkrep(Graphics2D g2d, Calendar calender) {
        int hour = calender.get(Calendar.HOUR);
        int minute=calender.get(Calendar.MINUTE);
        double radian=Math.toRadians(30*hour+minute/2);
        int x=(int)(center.x+(yariCap-35)*Math.sin(radian));
        int y=(int)(center.y-(yariCap-35)*Math.cos(radian)-15);
        g2d.setPaint(Color.black);
        g2d.drawLine(center.x,center.y-15,x,y);
    }

    private void drawSaniye(Graphics2D g2d, Calendar calender) {
        int second = calender.get(Calendar.SECOND);
        double radian=Math.toRadians(derece*second);
        int x=(int)(center.x+(yariCap-15)*Math.sin(radian));
        int y=(int)(center.y-(yariCap-15)*Math.cos(radian));
        g2d.setPaint(Color.red);
        g2d.drawLine(center.x,center.y-15,x,y);
    }


    public int getEkranGenislik() {
        return ekranGenislik;
    }

    public int getEkranUzunluk(){
        return ekranUzunluk;
    }

    public void setEkranGenislik(int ekranGenislik){
        this.ekranGenislik = ekranGenislik;
    }

    public void setEkranUzunluk(int ekranUzunluk){
        this.ekranUzunluk = ekranUzunluk;
    }
}
