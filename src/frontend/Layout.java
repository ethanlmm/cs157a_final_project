package frontend;

import javax.swing.*;
import java.awt.*;

public class Layout {

    public final static String MAIN_MENU = "MAIN";
    public final static String PATIENT_MENU = "PATIENT_MENU";
    public final static String VISIT_MENU = "VISIT_MENU";


    public static JFrame frame = new JFrame();
    public static JPanel cards = new JPanel(new CardLayout());

    public Layout(){
        MainMenu MainMenu=new MainMenu();
        PatientMenu PatientMenu=new PatientMenu();
        VisitMenu VisitMenu =new VisitMenu();


        cards.add(MainMenu.getMenu(), MAIN_MENU);
        cards.add(PatientMenu.getMenu(), PATIENT_MENU);
        cards.add(VisitMenu.getMenu(), VISIT_MENU);
        frame.add(cards);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }




    public static void switchCard(String card)
    {
        CardLayout cl = (CardLayout)cards.getLayout();
        cl.show(cards, card);
    }





}
