import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainThread
{

    JFrame frame;

    static JEditorPane nameInput = new JEditorPane();
    static JEditorPane shopList = new JEditorPane();
    static JEditorPane PriceInput = new JEditorPane();
    static JEditorPane CountInput = new JEditorPane();
    static JEditorPane FullPrice = new JEditorPane();
    static ArrayList<Prodact> ShoppingList=new ArrayList<Prodact>();
    private static int iterator = 0;
    public static int full_price;
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    MainThread window = new MainThread();
                    window.frame.setVisible(true);
                }catch (Exception e) {e.printStackTrace();}
            }
        });
    }

    public MainThread (){
        init();

    }

    public void init(){
        frame = new JFrame("Калькулятор товаров");
        frame.setBounds(100,100,650,430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
/******************************/
        JLabel nameLab = new JLabel("Название товара:");
        nameLab.setBounds(16,25,120,20);

        frame.getContentPane().add(nameLab);

        JLabel PriceLab = new JLabel("Цена единицы (руб.):");
        PriceLab.setBounds(16,80,130,20);

        frame.getContentPane().add(PriceLab);

        JLabel Count = new JLabel("Число единиц:");
        Count.setBounds(16,135,150,20);

        frame.getContentPane().add(Count);

        JLabel FullPriceLab = new JLabel("Общая стоимость в списке:");
        FullPriceLab.setBounds(360,5,259,20);
        frame.getContentPane().add(FullPriceLab);

        JLabel Sum = new JLabel("Итоговая сумма покупок:");
        Sum.setBounds(360,244, 150,20);
        frame.getContentPane().add(Sum);
/******************************/

        nameInput.setBounds(160,25,150,20);
        nameInput.setBorder(new javax.swing.border.EtchedBorder());
        frame.getContentPane().add(nameInput);

        shopList.setBounds(350,25,259,194);
        shopList.setBorder(new javax.swing.border.EtchedBorder());
        frame.getContentPane().add(shopList);

        PriceInput.setBounds(160,80,150,20);
        PriceInput.setBorder(new javax.swing.border.EtchedBorder());
        frame.getContentPane().add(PriceInput);

        CountInput.setBounds(160,135,150,20);
        CountInput.setBorder(new javax.swing.border.EtchedBorder());
        frame.getContentPane().add(CountInput);

        FullPrice.setBounds(350,270,259,20);
        FullPrice.setBorder(new javax.swing.border.EtchedBorder());
        frame.getContentPane().add(FullPrice);
/******************************/

        JButton btnStart = new JButton("Получить стоимость позиции и добавить в список");
        btnStart.setFont(new Font ("Tahoma", Font.PLAIN,11));
        btnStart.addActionListener(new Trans());
        btnStart.setBounds(16,190,300,35);
        frame.getContentPane().add(btnStart);

/******************************/
}

    class Trans implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Translate t = new Translate();
            t.start();

        }
    }


    static class Translate extends Thread {
    	
        public void run(){
            String src = nameInput.getText();
            int priceT = Integer.parseInt(PriceInput.getText());
            int countT = Integer.parseInt(CountInput.getText());
            ShoppingList.add(iterator++,new Prodact(countT,priceT,src));
            redraw();
        }
        public static void redraw () {
            shopList.setText("");//обнуляем
            for (int i = 0; i <iterator ; i++) {
                shopList.setText(shopList.getText()+ShoppingList.get(i).getName()+" "+String.valueOf(ShoppingList.get(i).getProiz())+"\n");
            }
            int temp=0;
            for (int i = 0; i < iterator; i++) {
                temp+=ShoppingList.get(i).getProiz();
            }
            FullPrice.setText("");
            FullPrice.setText(String.valueOf(temp));
            
           
        }
    }


}
