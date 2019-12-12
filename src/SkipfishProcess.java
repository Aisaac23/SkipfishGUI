package skipfish_gui;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import static skipfish_gui.Skipfish_Frame.recursivelyDisableComponents;

public class SkipfishProcess extends Thread {
    
    private JTextPane consolePane;
    private JTextField jTextField2, jTextField3, jTextField4;
    private JFrame jFrame1;
    private JButton jButton6, jButton8;
    private JPanel jPanel2, jPanel5;
    
    private String processID;
    private List<String> reportsList;
    private String[] startCommands;
    private String[] stopCommands;
    private Process skipfish;
    private HTMLDocument console;
    
    private volatile boolean stopped = true; 

    public SkipfishProcess(JTextPane consolePane, String name) {
        super(name);
        
        this.consolePane = consolePane;
        this.reportsList = new LinkedList();
        consolePane.addHyperlinkListener((HyperlinkEvent e) -> {
            /*Without using Lambda expression: 
            new HyperlinkListener(){
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {*/
            if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
                if(Desktop.isDesktopSupported())
                    try {
                        Desktop.getDesktop().browse(e.getURL().toURI());
                    } catch (IOException | URISyntaxException ex) {
                        
                    }
        });
        console = (HTMLDocument)this.consolePane.getStyledDocument();
        
      
    }
    
    public void setJTextFields(JTextField jTextField2, JTextField jTextField3, JTextField jTextField4)
    {
        this.jTextField2 = jTextField2;
        this.jTextField3 = jTextField3;
        this.jTextField4 = jTextField4;
    }
    
    public void setJPanels(JPanel jPanel2, JPanel jPanel5)
    {
        this.jPanel2 = jPanel2;
        this.jPanel5 = jPanel5;
    }
    
    public void setJFrameConsole(JFrame jFrame1)
    {
        this.jFrame1 = jFrame1;
    }
    
    public void setJButtons(JButton jButton6, JButton jButton8)
    {
        this.jButton6 = jButton6;
        this.jButton8 = jButton8;
    }
    
    public void startSkipfish(String[] commands)
    {
        if(this.stopped)
        {
            this.startCommands = commands;
            this.stopped = false;
            this.start();
        }
    }
    
    @Override
    public void run()
    {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(startCommands[0], startCommands[1], startCommands[2]);
        try
        {
            this.jButton6.setEnabled(true);
            skipfish = processBuilder.start();
            
            BufferedReader reader = new BufferedReader( new InputStreamReader( 
                    skipfish.getInputStream() ) );
            this.hangOn(1000);
            this.getProcessID();
            
            String line;
            while( (line = reader.readLine() ) != null)
                if(!stopped)
                    if(line.equals("\n"))
                        appendToPane("<br>");
                    else if(console.getLength() > 2000)
                    {
                        this.hangOn(1000);
                        console.setInnerHTML(console.getElement("console-place"), line);
                        appendToPane("<p>" + line + "</p>");
                    }
                    else
                        appendToPane("<p>" + line + "</p>");
                    
            appendToPane("<br><br><b>You may see the reports here: </b>"
                        + "<ul style=\"list-style-type:disc;\">");
            reportsList.add("<li><a href=\"" + new File(
                    jTextField4.getText()).toURI().toURL() + "index.html" + "\">" + 
                    jTextField2.getText()+ "-" + jTextField3.getText() + "</a></li>");
            for(String report: reportsList)
                appendToPane(report);
            appendToPane("</ul><br><br>");   

            JOptionPane.showMessageDialog(null, "Skipfish finished! You may now see the report.");
        }
        catch (IOException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (BadLocationException ex) {
            Logger.getLogger(SkipfishProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.consolePane.requestFocus();
        this.jFrame1.setVisible(true);
        this.jButton8.setEnabled(true);
        this.jButton6.setEnabled(false);

        recursivelyDisableComponents(jPanel2, true);
        recursivelyDisableComponents(jPanel5, true);
        
    }

    private void appendToPane(String s)
    {
        try {
           
            console.insertBeforeEnd(console.getElement("console-place"), s);
            this.consolePane.setCaretPosition(console.getLength());
        } catch (BadLocationException | IOException ex) {
            Logger.getLogger(Skipfish_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void hangOn(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(SkipfishProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void smoothlyStop()
    {
        this.stopCommands = new String[]{"bash", "-c", "kill -2 " + this.processID};
        this.jButton6.setEnabled(false);

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(stopCommands[0], stopCommands[1], stopCommands[2]);
        
        try {
            processBuilder.start();
            this.stopped = true;
        } catch (IOException ex) {
            String message = "Error: Wrong commands or operative system not supported";
            JOptionPane.showMessageDialog(null, message);
        }
        
    }
    
    private String getProcessID()
    {
        ProcessBuilder processBuilder = new ProcessBuilder("bash","-c", "pgrep -n -f skipfish;");
        
        try {
                Process grepProcess= processBuilder.start();
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader( grepProcess.getInputStream() ) );

                    String line;
                    while( (line = reader.readLine() ) != null )
                        this.processID = line.length() > 1 ? line : this.processID;
            } catch (IOException ex) {
                String message = "Error: Wrong commands or operative system not supported";
                JOptionPane.showMessageDialog(null, message);
            } 
        return this.processID;
    }
    
}
