/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbgeneticalgorithm;

/**
 *
 * @author Win7Sion
 */
import java.util.Random;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;

/**
 *
 * @author Win7Sion
 */
public class NBGeneticAlgorithm extends javax.swing.JFrame {

    //globals
    Random rNumber = new Random();

    boolean test = false;
    int foodAmount = 0;
    long startTime;
    
    Timer timer;
    
    //Limit of foodpopulation is 1000
    Bot[] foodPop = new Bot[1000];

    /**
     * Creates new form NBGeneticAlgorithmGUI
     */
    public NBGeneticAlgorithm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewPort = new MyPanel(0,0,600,600);
        jlPreyPopulation = new javax.swing.JLabel();
        jtfPreyPopulation = new javax.swing.JTextField();
        jlPredatorPopulation = new javax.swing.JLabel();
        jtfPredatorPopulation = new javax.swing.JTextField();
        jlFoodPopulation = new javax.swing.JLabel();
        jtfFoodPopulation = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaConsole = new javax.swing.JTextArea();
        jbStart = new javax.swing.JButton();
        jbStop = new javax.swing.JButton();
        jbReset = new javax.swing.JButton();
        jbClear = new javax.swing.JButton();
        jlFoodPopulationHint = new javax.swing.JLabel();
        jlPreyPopulationHint = new javax.swing.JLabel();
        jlPredatorPopulationHint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        viewPort.setBackground(new java.awt.Color(0, 0, 0));
        viewPort.setFocusable(false);
        viewPort.setName("viewPort"); // NOI18N
        viewPort.setPreferredSize(new java.awt.Dimension(600, 600));
        viewPort.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                viewPortMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout viewPortLayout = new javax.swing.GroupLayout(viewPort);
        viewPort.setLayout(viewPortLayout);
        viewPortLayout.setHorizontalGroup(
            viewPortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        viewPortLayout.setVerticalGroup(
            viewPortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jlPreyPopulation.setText("Prey Population");

        jtfPreyPopulation.setText("0");

        jlPredatorPopulation.setText("Predator Population");

        jtfPredatorPopulation.setText("0");

        jlFoodPopulation.setText("Food Population");

        jtfFoodPopulation.setText("0");

        jtaConsole.setColumns(20);
        jtaConsole.setRows(5);
        jtaConsole.setText("This is the console");
        jScrollPane1.setViewportView(jtaConsole);

        jbStart.setText("Start");
        jbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStartActionPerformed(evt);
            }
        });

        jbStop.setText("Stop");
        jbStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStopActionPerformed(evt);
            }
        });

        jbReset.setText("Reset");
        jbReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResetActionPerformed(evt);
            }
        });

        jbClear.setText("Clear");
        jbClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClearActionPerformed(evt);
            }
        });

        jlFoodPopulationHint.setText("30 - 1000");

        jlPreyPopulationHint.setText("30 - 1000");

        jlPredatorPopulationHint.setText("30 - 1000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlFoodPopulation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfFoodPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlPreyPopulation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfPreyPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jlPredatorPopulation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfPredatorPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlFoodPopulationHint)
                            .addComponent(jlPreyPopulationHint)
                            .addComponent(jlPredatorPopulationHint))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbStop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jbClear)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPreyPopulation)
                    .addComponent(jtfPreyPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPreyPopulationHint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPredatorPopulation)
                    .addComponent(jtfPredatorPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPredatorPopulationHint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFoodPopulation)
                    .addComponent(jtfFoodPopulation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlFoodPopulationHint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbStart)
                    .addComponent(jbStop)
                    .addComponent(jbReset)
                    .addComponent(jbClear))
                .addGap(15, 15, 15))
        );

        viewPort.getAccessibleContext().setAccessibleName("");
        viewPort.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     Reset Button
     What it does : When this button is pressed it will delete all current information
     and restore all input values to default (usually 0) and re-enable any buttons
     */
    private void jbResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResetActionPerformed
        // TODO add your handling code here:
        foodAmount = 0;

        jtfFoodPopulation.setText("0");
        jbStart.setEnabled(true);
        timer.stop();
    }//GEN-LAST:event_jbResetActionPerformed

    /*
     Console Button
     What it does : Will clear the text from the console.
     */
    private void jbClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearActionPerformed
        // TODO add your handling code here:
        jtaConsole.setText("Console Cleared...");
    }//GEN-LAST:event_jbClearActionPerformed
      
    /*
     Start Button 
     What it does : The start button takes all the input of the user, 
     validates it and then uses it to create the initial populations and
     finally begin running the simulation until the stop button is pressed
     Validation : Will only run the simulation if all values entered are
     correct. Otherwise will prompt user with message to the console
     with what is wrong.
     */
    private void jbStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStartActionPerformed
        // TODO add your handling code here:
        String temp;

        temp = jtfFoodPopulation.getText();
        foodAmount = Integer.parseInt(temp);

        if (foodAmount >= 30 && foodAmount <= 1000) {
            for (int x = 0; x < foodAmount; x++) {
                foodPop[x] = new nbgeneticalgorithm.Bot();
            }

            //method here to fill in attributes of food
            sortFood(foodAmount);

            //method here to fill in attributes of prey
            //method here to fill in attributes of predator
            jtaConsole.append("\nEverything is correct. Running simulation now...");
            jbStart.setEnabled(false);
        } else {
            jtaConsole.append("\nOne of your inputs is incorrect!");
        }

        /*
        UNFINISHED : May want to change it so that its 5 percent every time
         and actually remove the food item from the array instead of just pretending
         that it is gone.
        */
        ActionListener removeFood;
        removeFood = new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                int fivePercent = foodAmount / 5;
                
                for(int i = 0; i < fivePercent; i++){
                    int r = rNumber.nextInt(foodAmount);
                    System.out.println(i+" : "+r);
                    foodPop[r].setAlive(false);
                }
                
            }
            
        };
        
        timer = new Timer(3000, removeFood);
        timer.setRepeats(true);
        timer.start();
        
        startTime = System.currentTimeMillis();
    }//GEN-LAST:event_jbStartActionPerformed

    private void jbStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbStopActionPerformed

    private void viewPortMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPortMouseMoved
        // TODO add your handling code here:
        System.out.println(viewPort.getMousePosition());
    }//GEN-LAST:event_viewPortMouseMoved


    /*
     sortFood
     What it does :
     This method will assign random values to the x and y coordinates for the
     food bots stored in foodPop.
     */
    public void sortFood(int amount) {
        double r;
        for (int x = 0; x < foodAmount; x++) {
            r = 1 + (599 - 1) * rNumber.nextDouble();
            foodPop[x].setX(r);
        }

        for (int y = 0; y < foodAmount; y++) {
            r = 1 + (599 - 1) * rNumber.nextDouble();

            foodPop[y].setY(r);
        }

        for (int z = 0; z < foodAmount; z++) {
            foodPop[z].setAlive(true);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NBGeneticAlgorithm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NBGeneticAlgorithm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NBGeneticAlgorithm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NBGeneticAlgorithm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NBGeneticAlgorithm().setVisible(true);
            }
        });

        //Code goes here
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
//This class is a custom JPanel class that allows
//overrides so that it is possible to draw to the
//panel
//For simplicity sake everything graphic related i.e, loading images are done here
    class MyPanel extends JPanel {

        BufferedImage grass;
        BufferedImage prey;
        BufferedImage predator;
        public Graphics2D g2d;
        private double width, height;
        private BufferedImage scene;
        
        //create the 3 populations for grass, prey and predator.
        //Base them off of the input from the user
        public MyPanel(int x, int y, int w, int h) {
            width = w;
            height = h;
            
            /* setup the memory image, which supports sub-pixel (double) precision */
            scene = new BufferedImage(w, h, 1);
            g2d = scene.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            /* setup the ui component */
            this.setLocation(x, y);
            this.setSize(w, h);

            try {
                grass = ImageIO.read(this.getClass().getResource("Resources/grass.png"));
                prey = ImageIO.read(this.getClass().getResource("Resources/prey.png"));
                predator = ImageIO.read(this.getClass().getResource("Resources/predator.png"));
            } catch (IOException e) {
                System.out.println("Couldn't find grass image");
            }
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g2d.clearRect(0, 0, (int) width, (int) height);

            //draw all of the grass as long as they are alive
            if (foodAmount >= 30) {
                for (int x = 0; x < foodAmount; x++) {
                    if (foodPop[x].getAlive()) {
                        AffineTransform t = new AffineTransform();
                        t.translate(foodPop[x].getX(), foodPop[x].getY());
                        t.scale(1, 1);
                        g2d.drawImage(grass, t, this);
                    }
                }
            }

            g.drawImage(scene, 0, 0, this);
            repaint();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbClear;
    private javax.swing.JButton jbReset;
    private javax.swing.JButton jbStart;
    private javax.swing.JButton jbStop;
    private javax.swing.JLabel jlFoodPopulation;
    private javax.swing.JLabel jlFoodPopulationHint;
    private javax.swing.JLabel jlPredatorPopulation;
    private javax.swing.JLabel jlPredatorPopulationHint;
    private javax.swing.JLabel jlPreyPopulation;
    private javax.swing.JLabel jlPreyPopulationHint;
    private javax.swing.JTextArea jtaConsole;
    private javax.swing.JTextField jtfFoodPopulation;
    private javax.swing.JTextField jtfPredatorPopulation;
    private javax.swing.JTextField jtfPreyPopulation;
    private javax.swing.JPanel viewPort;
    // End of variables declaration//GEN-END:variables
}
