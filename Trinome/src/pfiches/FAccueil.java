/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfiches;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

/**
 *
 * @author clary
 */
public class FAccueil extends javax.swing.JFrame {

	/**
	 * Creates new form FAccueil
	 */
	private FJeu fichGame;

	public FAccueil() {
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

        grpRadButt = new javax.swing.ButtonGroup();
        bQuitter = new javax.swing.JButton();
        lNom = new javax.swing.JLabel();
        pBoutons = new javax.swing.JPanel();
        bJeu = new javax.swing.JButton();
        bBonjour = new javax.swing.JButton();
        jRadioN = new javax.swing.JRadioButton();
        jRadioS = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        tfNom = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accueil");

        bQuitter.setText("Quitter");
        bQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bQuitterActionPerformed(evt);
            }
        });

        lNom.setBackground(new java.awt.Color(204, 204, 204));
        lNom.setForeground(new java.awt.Color(51, 0, 51));
        lNom.setText("Entrez vos pseudos");
        lNom.setOpaque(true);

        pBoutons.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bJeu.setText("LANCER UNE PARTIE");
        bJeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bJeuActionPerformed(evt);
            }
        });

        bBonjour.setText("CHARGER (peut-être héhé)");
        bBonjour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBonjourActionPerformed(evt);
            }
        });

        grpRadButt.add(jRadioN);
        jRadioN.setText("NORMALE");
        jRadioN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioNActionPerformed(evt);
            }
        });

        grpRadButt.add(jRadioS);
        jRadioS.setText("SPECIALE");
        jRadioS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBoutonsLayout = new javax.swing.GroupLayout(pBoutons);
        pBoutons.setLayout(pBoutonsLayout);
        pBoutonsLayout.setHorizontalGroup(
            pBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBoutonsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRadioS)
                    .addComponent(jRadioN)
                    .addComponent(bJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bBonjour, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pBoutonsLayout.setVerticalGroup(
            pBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBoutonsLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(pBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBonjour, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioS)
                .addGap(25, 25, 25))
        );

        jTextField1.setText("Pseudo2");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        tfNom.setText("Pseudo1");
        tfNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lNom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(tfNom, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bQuitter)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(pBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(bQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bQuitterActionPerformed
		// TODO add your handling code here:
		System.exit(0);
    }//GEN-LAST:event_bQuitterActionPerformed

    private void bBonjourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBonjourActionPerformed
		// TODO add your handling code here:
		fichGame = new FJeu(this, false, tfNom.getText(), jTextField1.getText());
		fichGame.setVisible(true);
    }//GEN-LAST:event_bBonjourActionPerformed

    private void bJeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bJeuActionPerformed
		// TODO add your handling code here:
		var source = evt.getSource();
		String type = "NORMALE";
		Enumeration<AbstractButton> enu = grpRadButt.getElements();
		while (enu.hasMoreElements()) {
			AbstractButton button = (AbstractButton) enu.nextElement();
			if (button.isSelected()) {
				type = button.getActionCommand();
				break;
			}
		}
		fichGame = new FJeu(this, false, type.equals("SPECIALE"),tfNom.getText(), jTextField1.getText());
		fichGame.setVisible(true);
    }//GEN-LAST:event_bJeuActionPerformed

    private void jRadioNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioNActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jRadioNActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void tfNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_tfNomActionPerformed

    private void jRadioSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioSActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jRadioSActionPerformed

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
			java.util.logging.Logger.getLogger(FAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FAccueil().setVisible(true);
			}
		});

	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBonjour;
    private javax.swing.JButton bJeu;
    private javax.swing.JButton bQuitter;
    private javax.swing.ButtonGroup grpRadButt;
    private javax.swing.JRadioButton jRadioN;
    private javax.swing.JRadioButton jRadioS;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lNom;
    private javax.swing.JPanel pBoutons;
    private javax.swing.JTextField tfNom;
    // End of variables declaration//GEN-END:variables
}
