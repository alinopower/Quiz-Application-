import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	 
	public class EsameOnline extends JFrame implements ActionListener {
	       JLabel l;
	       JRadioButton jb[] = new JRadioButton[5];
	       JButton b1, b2;
	       ButtonGroup bg;
	       int count = 0, corrente = 0, x = 1, y = 1, adesso = 0;
	       int m[] = new int[10];
	 
	       EsameOnline(String s) {
	              super(s);
	              l = new JLabel();
	              add(l);
	              bg = new ButtonGroup();
	              for (int i = 0; i < 5; i++) {
	              jb[i] = new JRadioButton();
	              add(jb[i]);
	              bg.add(jb[i]);
	        }
	        b1 = new JButton("Avanti");
	        b2 = new JButton("Bookmark");
	        b1.addActionListener(this);
	        b2.addActionListener(this);
	        add(b1);
	        add(b2);
	        set();
	        l.setBounds(30, 40, 450, 20);
	        jb[0].setBounds(50, 80, 100, 20);
	        jb[1].setBounds(50, 110, 100, 20);
	        jb[2].setBounds(50, 140, 100, 20);
	        jb[3].setBounds(50, 170, 100, 20);
	        b1.setBounds(100, 240, 100, 30);
	        b2.setBounds(270, 240, 100, 30);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(null);
	        setLocation(250, 100);
	        setVisible(true);
	        setSize(600, 350);
	}
	 
	public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == b1) {
	              if (verificare())
	                    count = count + 1;
	                    corrente++;
	                    set();
	              if (corrente == 9) {
	                    b1.setEnabled(false);
	                    b2.setText("Risultato");
	              }
	        }
	        if (e.getActionCommand().equals("Bookmark")) {
	              JButton bk = new JButton("Bookmark" + x);
	              bk.setBounds(480, 20 + 30 * x, 100, 30);
	              add(bk);
	              bk.addActionListener(this);
	              m[x] = corrente;
	              x++;
	              corrente++;
	              set();
	              if (corrente == 9)
	                    b2.setText("Risultato");
	                    setVisible(false);
	                    setVisible(true);
	              }
	              for (int i = 0, y = 1; i < x; i++, y++) {
	                    if (e.getActionCommand().equals("Punteggi" + y)) {
	                          if (verificare())
	                          count = count + 1;
	                          adesso = corrente;
	                          corrente = m[y];
	                          set();
	                          ((JButton) e.getSource()).setEnabled(false);
	                          corrente = adesso;
	                    }
	              }
	 
	              if (e.getActionCommand().equals("Risultato")) {
	                     if (verificare())
	                     count = count + 1;
	                     corrente++;
	                     JOptionPane.showMessageDialog(this, "risposte corrette=" + count);
	                     System.exit(0);
	              }
	        }
	        void set() {
	                 jb[4].setSelected(true);
	                 if (corrente == 0) {
	                     l.setText("Que1: .Quale delle seguenti affermazioni su TypeScript è corretta?");
	                     jb[0].setText("Tutto quanto le risposte. ");
	                     jb[1].setText("Questo è un superset di JavaScript.");
	                     jb[2].setText("TypeScript è gestito da Microsoft.");
	                     jb[3].setText("Angolare si basa su TypeScript.");
	                 }
	                 if (corrente == 1) {
	                     l.setText("Que2: Qual è il decoratore utilizzato per configurare la classe del modulo?");
	                     jb[0].setText("");
	                     jb[1].setText("@NgModule ");
	                     jb[2].setText("Entrambi");
	                     jb[3].setText("Nessuna delle precedenti");
	                 }
	                 if (corrente == 2) {
	                     l.setText("Que3: Che cos'è .subscribe?");
	                     jb[0].setText("Trasmette i dati in modo asincrono");
	                     jb[1].setText("Trasmette i dati in modo sincrono");
	                     jb[2].setText("Entrambi");
	                     jb[3].setText("Nessuna delle precedenti");
	                 }
	                 if (corrente == 3) {
	                     l.setText("Que4: Nel linguaggio Java, per utilizzare la classe esistente \"Date\" è necessario usare l'istruzione");
	                     jb[0].setText("Non è necessario alcun import.");
	                     jb[1].setText("import java.util.Date;");
	                     jb[2].setText("import java.util.Calendar.*;");
	                     jb[3].setText("nessuno");
	                 }
	                 if (corrente == 4) {
	                     l.setText("Que5: Nel linguaggio Java, affinchè un metodo non restituisca alcun valore:" );
	                     jb[0].setText("Si usa la parola chiave void");
	                     jb[1].setText("Non è necessario alcun sistema, poiché i metodi per loro natura non restituiscono mai un valore	");
	                     jb[2].setText("Si usa il limitatore di accesso private	");
	                     jb[3].setText("nessuno");
	                 }
	                 if (corrente == 5) {
	                     l.setText("Que6: Nel linguaggio Java, il codice contenuto nei blocchi \"try\" e \"catch\"");
	                     jb[0].setText("Serve a gestire le eccezioni	");
	                     jb[1].setText("E' scorretto poiché tali blocchi non esistono in Java");
	                     jb[2].setText("Serve a gestire gli eventi	");
	                     jb[3].setText("nessuno");
	                 }
	                 if (corrente == 6) {
	                     l.setText("Que7: Nel linguaggio Java, l'uso dell'istruzione \"break\" in un blocco \"switch\"");
	                     jb[0].setText("E' errata poiché non è permesso usare l'istruzione break nel blocco switch");
	                     jb[1].setText("Permette di uscire dal blocco");
	                     jb[2].setText("Permette di continuare l'esecuzione del blocco");
	                     jb[3].setText("nessuno dei tre");
	                 }
	                 if (corrente == 7) {
	                     l.setText("Que8: La superclasse alla radice della gerarchia delle classi in Java è");
	                     jb[0].setText("Object");
	                     jb[1].setText("Class");
	                     jb[2].setText("Main()");
	                     jb[3].setText("due sono veri");
	                 }
	                 if (corrente == 8) {
	                     l.setText("Que9: Il termine \"public\" in Java:");
	                     jb[0].setText("non esiste");
	                     jb[1].setText("E' un modificatore di accesso");
	                     jb[2].setText("E una classe");
	                     jb[3].setText("nessuno dei tre");
	                 }
	                 if (corrente == 9) {
	                     l.setText("Que10: Quale dei seguenti codici è corretto, relativamente ad un ciclo \"for\" Java?");
	                     jb[0].setText("for(int i = 0; i<10; i++)");
	                     jb[1].setText("for(int i<10; i=0; i++)	");
	                     jb[2].setText("for(int i<10)	");
	                     jb[3].setText("nessuno");
	                 }
	                 l.setBounds(30, 40, 450, 20);
	                 for (int i = 0, j = 0; i <= 90; i += 30, j++)
	                 jb[j].setBounds(50, 80 + i, 200, 20);
	         }
	 
	        boolean verificare() {
	              if (corrente == 0)
	                      return (jb[1].isSelected());
	              if (corrente == 1)
	                      return (jb[2].isSelected());
	              if (corrente == 2)
	                      return (jb[3].isSelected());
	              if (corrente == 3)
	                      return (jb[0].isSelected());
	              if (corrente == 4)
	                      return (jb[2].isSelected());
	              if (corrente == 5)
	                      return (jb[2].isSelected());
	              if (corrente == 6)
	                      return (jb[1].isSelected());
	              if (corrente == 7)
	                      return (jb[3].isSelected());
	              if (corrente == 8)
	                      return (jb[1].isSelected());
	              if (corrente == 9)
	                      return (jb[2].isSelected());
	              return false;
	         }
	 
	         
	}


