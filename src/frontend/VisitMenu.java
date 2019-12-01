package frontend;

import javax.swing.*;
import java.awt.*;

public class VisitMenu {

    private JButton createVisitAppButton = new JButton("Make a Visit");
    private JButton editVisitButton = new JButton("View/Edit Visit");
    private JButton returnMainB = new JButton("Main Menu");



    public JPanel getMenu(){
        JPanel visitCard = new JPanel();
        visitCard.setLayout(new FlowLayout());

        returnMainB.addActionListener(e -> {
            Layout.switchCard(Layout.MAIN_MENU);
        });

        createVisitAppButton.addActionListener(e -> {
            //Layout.switchCard(Layout.VISIT_MENU);
        });
        editVisitButton.addActionListener(e -> {
            //Layout.switchCard(Layout.VISIT_MENU);
        });





        visitCard.add(createVisitAppButton);
        visitCard.add(editVisitButton);
        visitCard.add(returnMainB);
        return visitCard;
    }
}
