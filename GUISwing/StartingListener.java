import java.awt.event.*;

public class StartingListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("YOU PRESSED THE START BUTTON");
        System.exit(0);
    }
}
