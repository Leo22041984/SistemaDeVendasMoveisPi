/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import Sistema.Produto;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class TelaProduto extends javax.swing.JFrame {

    /**
     * Creates new form TelaProduto
     */
    public TelaProduto() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbnNomeProduto = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        lbnDescProduto = new javax.swing.JLabel();
        txtDescProduto = new javax.swing.JTextField();
        lbnEstProduto = new javax.swing.JLabel();
        txtFabriProduto = new javax.swing.JTextField();
        lbnFabriProduto = new javax.swing.JLabel();
        txtEstProduto = new javax.swing.JTextField();
        lbnValProduto = new javax.swing.JLabel();
        txtValProduto = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lbnIdProduto = new javax.swing.JLabel();
        txtIdProduto = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Produto");

        lbnNomeProduto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnNomeProduto.setText("Nome:");

        lbnDescProduto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnDescProduto.setText("Descricao:");

        lbnEstProduto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnEstProduto.setText("Estoque:");

        lbnFabriProduto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnFabriProduto.setText("Fabrica:");

        lbnValProduto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnValProduto.setText("Valor:");

        btnCadastrar.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbnIdProduto)
                        .addGap(135, 135, 135)
                        .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbnNomeProduto)
                            .addGap(41, 41, 41)
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbnDescProduto)
                                .addComponent(lbnEstProduto)
                                .addComponent(lbnFabriProduto)
                                .addComponent(lbnValProduto))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDescProduto)
                                .addComponent(txtFabriProduto)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtEstProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtValProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(152, 152, 152)
                                    .addComponent(jLabel1)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(12, 12, 12)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbnIdProduto)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnNomeProduto)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnDescProduto)
                    .addComponent(txtDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFabriProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnFabriProduto))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnEstProduto))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnValProduto)
                    .addComponent(txtValProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar)
                    .addComponent(btnSair)
                    .addComponent(btnConsultar)
                    .addComponent(btnExcluir))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        cadastrarProduto();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        excluirProduto();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        consultarProduto();
    }//GEN-LAST:event_btnConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbnDescProduto;
    private javax.swing.JLabel lbnEstProduto;
    private javax.swing.JLabel lbnFabriProduto;
    private javax.swing.JLabel lbnIdProduto;
    private javax.swing.JLabel lbnNomeProduto;
    private javax.swing.JLabel lbnValProduto;
    private javax.swing.JTextField txtDescProduto;
    private javax.swing.JTextField txtEstProduto;
    private javax.swing.JTextField txtFabriProduto;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtValProduto;
    // End of variables declaration//GEN-END:variables

    private void cadastrarProduto() {
        try {
            // Validações dos campos
            if (txtNomeProduto.getText().isEmpty() || txtDescProduto.getText().isEmpty()
                    || txtFabriProduto.getText().isEmpty() || txtEstProduto.getText().isEmpty()
                    || txtValProduto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos antes de cadastrar o produto.");
                return;
            }

            // Validar se o estoque e valor são números válidos
            try {
                int qtdEstoque = Integer.parseInt(txtEstProduto.getText());
                double valorUnitario = Double.parseDouble(txtValProduto.getText());

                // Verifica se a quantidade de estoque e valor são não negativos
                if (qtdEstoque < 0 || valorUnitario < 0) {
                    JOptionPane.showMessageDialog(this, "A quantidade de estoque e o valor devem ser não negativos.");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "A quantidade de estoque e o valor devem ser números válidos.");
                return;
            }

            // Instancia um novo produto e preenche os campos com os dados da tela
            Produto produto = new Produto();
            produto.setNomeProduto(txtNomeProduto.getText());
            produto.setDescricao(txtDescProduto.getText());
            produto.setFabricacao(txtFabriProduto.getText());
            produto.setQtdEstoque(Integer.parseInt(txtEstProduto.getText()));
            produto.setValorUnitario(Double.parseDouble(txtValProduto.getText()));

            // Chama o método de cadastrarProduto da classe Produto
            produto.cadastrarProduto();

            // Limpa os campos após cadastrar
            limparCampos();

            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao cadastrar o produto:\n" + e.getMessage());
        }
    }

    private void limparCampos() {
        // Limpa os campos do formulário
        txtNomeProduto.setText("");
        txtDescProduto.setText("");
        txtFabriProduto.setText("");
        txtEstProduto.setText("");
        txtValProduto.setText("");
    }

    private void excluirProduto() {
        try {
            // Pede ao usuário para inserir o ID do produto a ser excluído
            String idInput = JOptionPane.showInputDialog(this, "Informe o ID do produto a ser excluído:");

            // Verifica se o usuário cancelou a entrada ou deixou em branco
            if (idInput == null || idInput.trim().isEmpty()) {
                return;  // Saia se o usuário cancelou ou deixou em branco
            }

            // Obtém o ID do produto a ser excluído
            int idProduto;

            // Validar se o ID é um número válido
            try {
                idProduto = Integer.parseInt(idInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID do produto deve ser um número válido.");
                return;
            }

            // Instancia um novo produto e verifica se o produto com o ID fornecido existe
            Produto produto = new Produto();
            if (!produto.verificarExistenciaProduto(idProduto)) {
                JOptionPane.showMessageDialog(this, "Produto com o ID informado não existe.");
                return;
            }

            // Chama o método de excluirProduto
            produto.excluirProduto(idProduto);

            // Limpa os campos após excluir
            limparCampos();

            JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao excluir o produto:\n" + e.getMessage());
        }
    }

    private void consultarProduto() {
        try {
            // Pede ao usuário para inserir o ID do produto a ser consultado
            String idInput = JOptionPane.showInputDialog(this, "Informe o ID do produto a ser consultado:");

            // Verifica se o usuário cancelou a entrada ou deixou em branco
            if (idInput == null || idInput.trim().isEmpty()) {
                return;  // Saia se o usuário cancelou ou deixou em branco
            }

            // Obtém o ID do produto a ser consultado
            int idProduto;

            // Validar se o ID é um número válido
            try {
                idProduto = Integer.parseInt(idInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID do produto deve ser um número válido.");
                return;
            }

            // Instancia um novo produto
            Produto produto = new Produto();

            // Verifica se o produto com o ID fornecido existe
            if (!produto.verificarExistenciaProduto(idProduto)) {
                JOptionPane.showMessageDialog(this, "Produto com o ID informado não existe.");
                return;
            }

            // Obtém os dados do produto
            produto = produto.consultarProduto(idProduto);

            // Preenche os campos da tela com os dados do produto
            txtIdProduto.setText(String.valueOf(produto.getIdProduto()));
            txtNomeProduto.setText(produto.getNomeProduto());
            txtDescProduto.setText(produto.getDescricao());
            txtFabriProduto.setText(produto.getFabricacao());
            txtEstProduto.setText(String.valueOf(produto.getQtdEstoque()));
            txtValProduto.setText(String.valueOf(produto.getValorUnitario()));

            JOptionPane.showMessageDialog(this, "Produto consultado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao consultar o produto:\n" + e.getMessage());
        }
    }

}
