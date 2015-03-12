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
import javax.imageio.ImageIO;

/**
 *
 * @author Win7Sion
 */
public class NBGeneticAlgorithm extends javax.swing.JFrame {

    //globals
    Random rNumber = new Random();
    boolean draw = false;

    int foodAmount, preyAmount, predatorAmount;
    long startTime;

    Timer t_preyTimer;
    Timer t_preySearch;

    Food[] foodPop;
    Prey[] preyPop;
    
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
        jbResume = new javax.swing.JButton();

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
        jbStop.setEnabled(false);
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

        jbResume.setText("Resume");
        jbResume.setEnabled(false);
        jbResume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResumeActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbStop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbResume, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jbReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(jbClear)
                    .addComponent(jbResume))
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
        preyAmount = 0;
        jtfFoodPopulation.setText("0");
        jtfPreyPopulation.setText("0");
        jbStart.setEnabled(true);
        jbStop.setEnabled(false);
        jbResume.setEnabled(false);
        draw = false;
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
        
        boolean pass = false;
        ActionListener al_preyLogic;
        ActionListener al_updateTarget;
        al_updateTarget = new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                double distanceX, distanceY, angle;
                
                for(int x = 0; x < preyAmount; x++){
                   preyPop[x].setTargetX(rNumber.nextInt(1 + (599 - 1)));
                    preyPop[x].setTargetY(rNumber.nextInt(1 + (599 - 1)));

                    //System.out.println("distanceX = " + distanceX + ", distanceY = " + distanceY);
                    distanceX = preyPop[x].getTargetX() - preyPop[x].getX();
                    distanceY = preyPop[x].getTargetY() - preyPop[x].getY();
                    
                    angle = Math.toDegrees(Math.atan2(distanceY, distanceX));
                    
                    preyPop[x].setAngle(angle); 
                }
            }
        };
        al_preyLogic = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    
                double rotation, ts, speed,  velocityX, velocityY, currentX , currentY;

                /*
                NOTES FOR CHANGES
                Search state : Choose a random location on screen and move there. If vision hits any food
                switch to Eat state. If no food is found choose a new random location and move there.
                
                Eat state : Go to location of food, eat, switch to Search state. Even if food is eaten by another
                prey.
                
                Escape state : Vision spots predator during search state. Actions are move to a random location opposite
                the predator ignoring food as you pass. Once at that state spin around 360 if predators then run, if not then switch
                to search mode.
                */

                //super convoluted
                for(int x = 0; x < preyAmount; x++){

                    rotation = preyPop[x].getRotation();
                    
                    //System.out.println("angle : " + angle + ", rotation : " + rotation);
                    
                    ts = preyPop[x].getTurnSpeed();
                    speed = preyPop[x].getSpeed();
                    
                    velocityX = Math.sin (rotation * Math.PI / 180) * speed;
                    velocityY = Math.cos (rotation * Math.PI / 180) * -speed;
                    
                    if(rotation >= preyPop[x].getAngle()){
                        rotation -= ts;
                    }
                    else if(rotation <= preyPop[x].getAngle())
                    {
                        rotation += ts;
                    }
                    
                    //System.out.println("targetx " + preyPop[x].getTargetX() + ", targetY "+ preyPop[x].getTargetY());
                    //System.out.println("currentx " + preyPop[x].getX() + ", currentY "+ preyPop[x].getY());

                    currentX = preyPop[x].getX();
                    currentY = preyPop[x].getY();
                    
                    currentX += velocityX;
                    currentY += velocityY;
                    
                    preyPop[x].setRotation(rotation);
                    preyPop[x].setX(currentX);
                    preyPop[x].setY(currentY);

                    //border collision detection
                    if (preyPop[x].getX() + 9 >= viewPort.getWidth()) {
                        preyPop[x].setX(viewPort.getWidth() - 9);
                    } else if (preyPop[x].getX() <= 0) {
                        preyPop[x].setX(0);
                    }

                    if (preyPop[x].getY() <= 0) {
                        preyPop[x].setY(0);
                    } else if (preyPop[x].getY() + 9 >= viewPort.getHeight()) {
                        preyPop[x].setY(viewPort.getHeight() - 9);
                    }
                }
            }
            
        };

        temp = jtfFoodPopulation.getText();
        foodAmount = Integer.parseInt(temp);

        temp = jtfPreyPopulation.getText();
        preyAmount = Integer.parseInt(temp);
        
        if (foodAmount >= 30 && foodAmount <= 1000 && preyAmount >= 1 && preyAmount <= 1000) {
            pass = true;
        } else {
            pass = false;
        }

        //basic but lengthy if statement controls the validation of input.
        //Will only continue with the right numbers input
        if (pass) {
            //Food array preperation
            foodPop = new Food[foodAmount];

            for (int x = 0; x < foodAmount; x++) {
                foodPop[x] = new Food();
            }

            //End of food prep

            //start of prey prep
            preyPop = new Prey[preyAmount];
            for (int x = 0; x < preyAmount; x++) {
                preyPop[x] = new Prey();
            }
            //end of prey prep

            //setting draw to true so display renders graphics
            draw = true;

            /*NOTES : Currently I can stop and start this timer via the buttons on the
             interface. However it also resets the whole timer. Rendering it a bit useless        
             */
            t_preyTimer = new Timer(100, al_preyLogic);
            t_preyTimer.setRepeats(true);
            t_preyTimer.start();
            
            t_preySearch = new Timer(5000, al_updateTarget);
            t_preySearch.setRepeats(true);
            t_preySearch.start();       
            
            //start of predator prep
            //end of predator prep
            jtaConsole.append("\nEverything is correct. Running simulation now...");
            jbStart.setEnabled(false);
            jbStop.setEnabled(true);
        } else {
            jtaConsole.append("\nOne of your inputs is incorrect!");
        }

        /*
         Finally make a note of the current time the simulation is run to control
         generation loop
         */
        startTime = System.currentTimeMillis();
    }//GEN-LAST:event_jbStartActionPerformed

    private void jbStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStopActionPerformed
        // TODO add your handling code here:
        jbResume.setEnabled(true);
        jbStop.setEnabled(false);
        jtaConsole.append("\nPausing Simulation...");
        //Get this to pause the simulation, possibly rename it to pause
    }//GEN-LAST:event_jbStopActionPerformed

    private void viewPortMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPortMouseMoved
        // TODO add your handling code here:
        System.out.println(viewPort.getMousePosition());
    }//GEN-LAST:event_viewPortMouseMoved

    private void jbResumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResumeActionPerformed
        // TODO add your handling code here:
        jbResume.setEnabled(false);
        jbStop.setEnabled(true);
        jtaConsole.append("\nResuming Simulation...");
    }//GEN-LAST:event_jbResumeActionPerformed

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
            if (draw) {
                for (int x = 0; x < foodAmount; x++) {
                    if (foodPop[x].getAlive()) {
                        AffineTransform t = new AffineTransform();
                        t.translate(foodPop[x].getX(), foodPop[x].getY());
                        t.scale(1, 1);
                        g2d.drawImage(grass, t, this);
                    }
                }
                
                for (int x = 0; x < preyAmount; x++) {
                    if (preyPop[x].getAlive()) {
                        AffineTransform t = new AffineTransform();
                        t.translate(preyPop[x].getX(), preyPop[x].getY());
                        //convert the angle to radians so the displayed image is correct to direction of agent
                        t.rotate(Math.toRadians(preyPop[x].getRotation()), 9 / 2, 9 / 2);
                        t.scale(1, 1);
                        
                        g2d.drawImage(prey, t, this);
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
    private javax.swing.JButton jbResume;
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