package Words;

// Java program to use JFileChooser to allow multiple selection of files 
import java.io.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.filechooser.*; 
class filechooser extends JFrame implements ActionListener { 
    // Jlabel to show the files user selects 
    static JLabel l; 
    String path;
  
    // a default constructor 
    filechooser() 
    { 
    } 
  
    public static void main(String args[]) 
    { 
        // frame to contains GUI elements 
        JFrame f = new JFrame("file chooser to select multiple files at a time"); 
  
        // set the size of the frame 
        f.setSize(400, 400); 
  
        // set the frame's visibility 
        f.setVisible(true); 
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
        // button to open save dialog 
        JButton button1 = new JButton("File"); 
  
        // button to open open dialog 
        JButton button2 = new JButton("Count"); 
  
        // make an object of the class filechooser 
        filechooser f1 = new filechooser(); 
  
        // add action listener to the button to capture user 
        // response on buttons 
        button1.addActionListener(f1); 
        button2.addActionListener(f1); 
  
        // make a panel to add the buttons and labels 
        JPanel p = new JPanel(); 
  
        // add buttons to the frame 
        p.add(button1); 
        p.add(button2); 
  
        // set the label to its initial value 
        l = new JLabel("no file selected"); 
  
        // add panel to the frame 
        p.add(l); 
        f.add(p); 
  
        f.show(); 
    } 
    public void actionPerformed(ActionEvent evt) 
    { 
        // if the user presses the save button show the save dialog 
        String com = evt.getActionCommand(); 
  
        if (com.equals("File")) { 
            // create an object of JFileChooser class 
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
  
            // allow multiple file selection 
            j.setMultiSelectionEnabled(true); 
  
            // invoke the showsSaveDialog function to show the save dialog 
            int r = j.showSaveDialog(null); 
  
            if (r == JFileChooser.APPROVE_OPTION) { 
                // get the selected files 
                File files[] = j.getSelectedFiles(); 
  
                int t = 0; 
                // set text to blank 
                l.setText(""); 
  
                // set the label to the path of the selected files 
                while (t++ < files.length) 
                    l.setText(l.getText() + ":" + files[t - 1].getName()); 
            } 
            // if the user cancelled the operation 
            else
                l.setText("the user cancelled the operation"); 
        } 
        // if the user presses the count button count the words
  
        else 
        {
        	path = l.getText();
        	String arrOfStr[] = path.split(":", 3);
        	int size = arrOfStr.length;
       
 		   for ( int i=1; i<size; i++) 
 		   {			   
 			   CodeRunner runner = new CodeRunner("C:\\Users\\JJDB\\Documents\\" + arrOfStr[i]);
			   Thread thread = new Thread(runner);
			   thread.start();  
 		   }
        } 
    } 
} 