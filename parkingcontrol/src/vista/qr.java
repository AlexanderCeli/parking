package vista;

import com.barcodelib.barcode.QRCode;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTextArea;

 // se crea un codigo qr
public class qr extends JFrame{
    int udm=0, resol=72,rot =0;
    float mi=0.000f, md= 0.00f,ms=0.000f,min=0.000f,tam=5.00f;
    JTextArea qr;
    JButton act = new JButton();
    JPanel ubicar;
     private static int udm1 = 0;
    private static int resolucion = 72;
    private static float margenIzq = 0.000f;
    private static float margenDer = 0.000f;
    private static float margenSup = 0.000f;
    private static float margenInf = 0.000f;
    private static int rotacion = 0;
    private static float tamanoModulo = 5.000f;
    public qr(){
     setSize(1200, 750);
        setVisible(true);
        setTitle("Reportes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pantalla();
}
    public void pantalla() {
        ubicar();
       boton();
       

    }

    public void ubicar() {
        ubicar = new JPanel();
        ubicar.setLayout(null);
        this.add(ubicar);

    }
    private void boton() {
        act = new JButton("ACT");
        act.setBounds(500, 30, 70, 25);
               ubicar.add(act);
               act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              String campo = qr.getText();
                System.out.println(campo);
              generarQR(campo);
            }
        });

        qr = new JTextArea();
         qr.setBounds(300, 30, 60, 25);
        ubicar.add(qr);
    }
    
    public void generarQR(String Dato){
        
//        System.out.println(dato);
        try{
//            QRCode c = new QRCode();
//            c.setData("holaa");
//            c.setDataMode(QRCode.MODE_AUTO);
//            c.setUOM(udm);
//            c.setLeftMargin(mi);
//            c.setRightMargin(md);
//            c.setTopMargin(ms);
//            c.setBottomMargin(min);
//            c.setResolution(resol);
//            c.setRotate(rot);
//            c.setModuleSize(tam);
               QRCode codigoQR = new QRCode();
               codigoQR.setData(Dato);
   codigoQR.setDataMode(QRCode.MODE_BYTE);
             codigoQR.setUOM(udm);
    codigoQR.setLeftMargin(margenIzq);
    codigoQR.setResolution(resolucion);
    codigoQR.setRightMargin(margenDer);
    codigoQR.setTopMargin(margenSup);
    codigoQR.setBottomMargin(margenInf);
    codigoQR.setRotate(rotacion);
    codigoQR.setModuleSize(tamanoModulo);
            
            String archivo = System.getProperty("user.home")+"/qrsistema.gif";
//            String archivo = System.getProperty("user.home") + "/qrcodeDemo.gif";
            codigoQR.renderBarcode(archivo);
//            System.out.println(archivo);
            Desktop d= Desktop.getDesktop();
            d.open(new File(archivo));
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    
}
    public static void main(String[] args) {
        qr c = new qr();
    }
}