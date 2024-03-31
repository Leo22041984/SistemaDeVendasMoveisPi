/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import Sistema.Venda;
import Sistema.Funcionario;
import Sistema.GeradorArquivoVenda;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class TelaVenda extends javax.swing.JFrame {

    /**
     * Creates new form TelaVenda
     */
    private Funcionario funcionario;
    private Connection con;
    private Venda venda;

    public TelaVenda() {
        initComponents();
        funcionario = new Funcionario();

        // Adicionando um ouvinte de evento ao ComboBoxTpPag
        ComboBoxTpPag.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {

                // Verificando se o tipo de pagamento selecionado é "Cartão de Crédito"
                if (ComboBoxTpPag.getSelectedItem().toString().equals("Cartão de Crédito")) {

                    // Tornando os campos txtDadosCartao e txtQtdParc obrigatórios
                    txtDadosCartao.setEnabled(true);
                    txtQtdParc.setEnabled(true);
                } else {

                    // Resetando os campos e tornando-os não obrigatórios
                    txtDadosCartao.setText("");
                    txtQtdParc.setText("");
                    txtDadosCartao.setEnabled(false);
                    txtQtdParc.setEnabled(false);
                }
            }
        });

        txtIdFunc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdFuncKeyPressed(evt);
            }
        });
        txtIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdClienteKeyPressed(evt);
            }
        });
        txtDtVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDtVendaKeyPressed(evt);
            }
        });
        txtDtPag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDtPagKeyPressed(evt);
            }
        });
        txtDtEnvio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDtEnvioKeyPressed(evt);
            }
        });
        txtIdProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdProdutoKeyPressed(evt);
            }
        });
        txtQtdProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtdProdKeyPressed(evt);
            }
        });
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescKeyPressed(evt);
            }
        });
        txtAcrec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAcrecKeyPressed(evt);
            }
        });

    }

    // Método para conectar ao banco de dados
    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sistema_de_venda_moveis_db_PI", "root", "227442");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }
    // Método para lidar com o evento de pressionar Enter no campo txtIdFuncionario

    private void txtIdFuncKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int idFuncionario;
            try {
                idFuncionario = Integer.parseInt(txtIdFunc.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ID de funcionário válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Funcionario funcionarioEncontrado = funcionario.consultarFuncionario(idFuncionario);
            if (funcionarioEncontrado != null) {
                txtFunc.setText(funcionarioEncontrado.getNomeFuncionario());
            } else {
                JOptionPane.showMessageDialog(this, "Funcionário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                txtFunc.setText(""); // Limpa o campo txtFunc se o funcionário não for encontrado
            }
        }
    }
    // Método para lidar com o evento de pressionar Enter no campo txtIdCliente

    private void txtIdClienteKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int idCliente;
            try {
                idCliente = Integer.parseInt(txtIdCliente.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ID de cliente válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nomeCliente = consultarNome(idCliente);
            if (nomeCliente != null) {
                txtCliente.setText(nomeCliente);
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                txtCliente.setText(""); // Limpa o campo txtCliente se o cliente não for encontrado
            }
        }
    }
    // Método para lidar com o evento de pressionar Enter no campo txtDtVenda

    private void txtDtVendaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!validarData(txtDtVenda.getText())) {
                JOptionPane.showMessageDialog(this, "Data de venda inválida. O formato deve ser dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                txtDtVenda.setText("");
                return;
            }
            txtDtPag.requestFocus();
        }
    }
    // Método para lidar com o evento de pressionar Enter no campo txtDtPag

    private void txtDtPagKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!validarData(txtDtPag.getText())) {
                JOptionPane.showMessageDialog(this, "Data de pagamento inválida. O formato deve ser dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                txtDtPag.setText("");
                return;
            }
            txtDtEnvio.requestFocus();
        }
    }
    // Método para lidar com o evento de pressionar Enter no campo txtDtEnvio

    private void txtDtEnvioKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!validarData(txtDtEnvio.getText())) {
                JOptionPane.showMessageDialog(this, "Data de envio inválida. O formato deve ser dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                txtDtEnvio.setText("");
                return;
            }
            efetuarVenda();
        }
    }
    // Método para lidar com o evento de pressionar Enter no campo txtIdProduto

    private void txtIdProdutoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int idProduto;
            try {
                idProduto = Integer.parseInt(txtIdProduto.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ID de produto válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nomeProduto = consultarNomeProduto(idProduto);
            if (nomeProduto != null) {
                txtProduto.setText(nomeProduto);
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                txtProduto.setText(""); // Limpa o campo txtProduto se o produto não for encontrado
            }
        }
    }
    // Método para lidar com o evento de pressionar Enter no campo txtQtdProd

    private void txtQtdProdKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            calcularValorProduto(); // Chama o método para calcular o valor do produto
        }
    }
    // Método para lidar com o evento de pressionar Enter no campo txtDesc

    private void txtDescKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtDesc.getText().isEmpty()) {
                try {
                    double desconto = Double.parseDouble(txtDesc.getText());
                    double valorProduto = Double.parseDouble(txtValProd.getText());

                    // Aplica o desconto ao valor do produto
                    double novoValor = valorProduto - (valorProduto * (desconto / 100));

                    // Atualiza o campo txtValProd com o novo valor
                    txtValProd.setText(String.valueOf(novoValor));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    // Método para lidar com o evento de pressionar Enter no campo txtAcrec

    private void txtAcrecKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtAcrec.getText().isEmpty()) {
                try {
                    double acrescimo = Double.parseDouble(txtAcrec.getText());
                    double valorProduto = Double.parseDouble(txtValProd.getText());

                    // Aplica o acréscimo ao valor do produto
                    double novoValor = valorProduto + acrescimo;

                    // Atualiza o campo txtValProd com o novo valor
                    txtValProd.setText(String.valueOf(novoValor));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Método para validação de data no formato dd/mm/yyyy
    private boolean validarData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date dt = sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    // Método para efetuar a conclusão da venda após as validações

    private void efetuarVenda() {
        if (txtIdCliente.getText().isEmpty() || txtIdProduto.getText().isEmpty()
                || txtQtdProd.getText().isEmpty() || txtValProd.getText().isEmpty()
                || txtIdFunc.getText().isEmpty() || txtDtVenda.getText().isEmpty()
                || txtDtPag.getText().isEmpty() || txtDtEnvio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Venda venda = new Venda();

        venda.setClienteIdCliente(Integer.parseInt(txtIdCliente.getText()));
        venda.setProdutoIdProduto(Integer.parseInt(txtIdProduto.getText()));
        venda.setQtdProduto(Integer.parseInt(txtQtdProd.getText()));
        venda.setValor(Double.parseDouble(txtValProd.getText()));
        venda.setFuncionarioIdFuncionario(Integer.parseInt(txtIdFunc.getText()));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            venda.setData(sdf.parse(txtDtVenda.getText()));
            venda.setDataPagamento(sdf.parse(txtDtPag.getText()));
            venda.setDataEnvioProduto(sdf.parse(txtDtEnvio.getText()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao converter data.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (inserirVendaNoBanco(venda)) {
            JOptionPane.showMessageDialog(this, "Venda efetuada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            // Limpar campos após a efetuação da venda
            limparCampos();
            // Armazenar a venda para a posterior geração dos arquivos
            this.venda = venda;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao efetuar a venda.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Método para inserir os dados da venda no banco de dados após as validações confirmadas

    private boolean inserirVendaNoBanco(Venda venda) {
        String sql = "INSERT INTO venda (Cliente_idCliente, Data_venda, Data_pagamento, Data_envio_produto, Valor_venda, Tipo_pagamento, Dados_Cartao_credito, Qtd_parcelas, Funcionario_idFuncionario, Produto_idProduto, Qtd_Produto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, venda.getClienteIdCliente());
            stmt.setDate(2, new java.sql.Date(venda.getData().getTime()));
            stmt.setDate(3, new java.sql.Date(venda.getDataPagamento().getTime()));
            stmt.setDate(4, new java.sql.Date(venda.getDataEnvioProduto().getTime()));
            stmt.setDouble(5, venda.getValor());

            // Defina o tipo de pagamento e os campos relacionados com base na escolha do usuário
            if (ComboBoxTpPag.getSelectedItem().toString().equals("Cartão de Crédito")) {
                stmt.setString(6, "C"); // Tipo de pagamento para cartão de crédito
                stmt.setString(7, txtDadosCartao.getText()); // Dados do cartão de crédito
                stmt.setInt(8, Integer.parseInt(txtQtdParc.getText())); // Quantidade de parcelas
            } else {
                stmt.setString(6, "D"); // Tipo de pagamento para dinheiro
                stmt.setNull(7, java.sql.Types.VARCHAR); // Dados do cartão de crédito (nulo para pagamento em dinheiro)
                stmt.setNull(8, java.sql.Types.INTEGER); // Quantidade de parcelas (nulo para pagamento em dinheiro)
            }

            stmt.setInt(9, venda.getFuncionarioIdFuncionario());
            stmt.setInt(10, venda.getProdutoIdProduto());
            stmt.setInt(11, venda.getQtdProduto());

            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir venda: " + ex.getMessage());
            return false;
        }
    }

    // Método para consultar nome do cliente em busca no banco de dados
    private String consultarNome(int idCliente) {
        String nomeCliente = null;
        try {
            if (conectar()) {
                String sql = "SELECT Nome FROM Cliente WHERE idCliente = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, idCliente);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    nomeCliente = rs.getString("Nome");
                }
                rs.close();
                stmt.close();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar o banco de dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return nomeCliente;
    }
    // Método para consultar nome do produto em busca no banco de dados

    private String consultarNomeProduto(int idProduto) {
        String nomeProduto = null;
        try {
            if (conectar()) {
                String sql = "SELECT Nome_Produto FROM Produto WHERE idProduto = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, idProduto);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    nomeProduto = rs.getString("Nome_Produto");
                }
                rs.close();
                stmt.close();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar o banco de dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return nomeProduto;
    }
    // Método para calcular o valor total do produto com base na quantidade digitada

    private void calcularValorProduto() {
        if (!txtIdProduto.getText().isEmpty() && !txtQtdProd.getText().isEmpty()) {
            int idProduto = Integer.parseInt(txtIdProduto.getText());
            int qtdProduto = Integer.parseInt(txtQtdProd.getText());

            // Consulta o banco de dados para obter o valor unitário do produto
            double valorUnitario = consultarValorUnitarioProduto(idProduto);

            // Calcula o valor total do produto
            double valorTotal = valorUnitario * qtdProduto;

            // Exibe o valor total no campo txtValProd
            txtValProd.setText(String.valueOf(valorTotal));
        }
    }

    // Método para consultar o valor unitário do produto no banco de dados
    private double consultarValorUnitarioProduto(int idProduto) {
        double valorUnitario = 0.0;
        try {
            if (conectar()) {
                String sql = "SELECT Valor_unitario FROM Produto WHERE idProduto = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, idProduto);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    valorUnitario = rs.getDouble("Valor_unitario");
                }
                rs.close();
                stmt.close();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar o banco de dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return valorUnitario;
    }

    // Método para limpar os campos após finalizações de ações ou ao clicar no botão limpar
    private void limparCampos() {
        txtIdCliente.setText("");
        txtCliente.setText("");
        txtIdProduto.setText("");
        txtQtdProd.setText("");
        txtValProd.setText("");
        txtIdFunc.setText("");
        txtFunc.setText("");
        txtDtVenda.setText("");
        txtDtPag.setText("");
        txtDtEnvio.setText("");
        txtProduto.setText("");
        txtDesc.setText("");
        txtDadosCartao.setText("");
        txtQtdParc.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField15 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbnIdCliente = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        lbnCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        lbnDtVenda = new javax.swing.JLabel();
        txtDtVenda = new javax.swing.JTextField();
        lbnDtPag = new javax.swing.JLabel();
        txtDtPag = new javax.swing.JTextField();
        lbnDtEnvio = new javax.swing.JLabel();
        txtDtEnvio = new javax.swing.JTextField();
        lbnIdProduto = new javax.swing.JLabel();
        txtIdProduto = new javax.swing.JTextField();
        lbnProduto = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        lbnQtdProd = new javax.swing.JLabel();
        txtQtdProd = new javax.swing.JTextField();
        lbnValProd = new javax.swing.JLabel();
        txtValProd = new javax.swing.JTextField();
        lbnIdFunc = new javax.swing.JLabel();
        txtIdFunc = new javax.swing.JTextField();
        lbnFunc = new javax.swing.JLabel();
        txtFunc = new javax.swing.JTextField();
        lbnDesc = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        lbnAcrec = new javax.swing.JLabel();
        txtAcrec = new javax.swing.JTextField();
        lbnTpPag = new javax.swing.JLabel();
        ComboBoxTpPag = new javax.swing.JComboBox<>();
        lbnDadosCartao = new javax.swing.JLabel();
        txtDadosCartao = new javax.swing.JTextField();
        lbnQtdParc = new javax.swing.JLabel();
        txtQtdParc = new javax.swing.JTextField();
        btnEfetivar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        jTextField15.setText("jTextField15");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Vendas");

        lbnIdCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnIdCliente.setText("Codigo do Cliente:");

        lbnCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnCliente.setText("Cliente:");

        lbnDtVenda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnDtVenda.setText("Data da Venda:");

        lbnDtPag.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnDtPag.setText("Data do Pagamento:");

        lbnDtEnvio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnDtEnvio.setText("Data de Envio:");

        lbnIdProduto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnIdProduto.setText("Codigo do Produto:");

        lbnProduto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnProduto.setText("Produto:");

        lbnQtdProd.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnQtdProd.setText("Qtd Produto:");

        lbnValProd.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnValProd.setText("Valor do Produto:");

        lbnIdFunc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnIdFunc.setText("Codigo do Funcionario:");

        lbnFunc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnFunc.setText("Funcionario:");

        lbnDesc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnDesc.setText("Desconto:");

        lbnAcrec.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnAcrec.setText("Acrecimo:");

        lbnTpPag.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnTpPag.setText("Tipo de Pagamento:");

        ComboBoxTpPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cartão de Crédito", "Cartao de Debito", "Dinheiro", "Boleto" }));

        lbnDadosCartao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnDadosCartao.setText("Dados do Cartao:");

        lbnQtdParc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbnQtdParc.setText("Qtd de Parcelas:");

        btnEfetivar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnEfetivar.setText("Efetivar");
        btnEfetivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfetivarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbnIdProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbnProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProduto))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbnQtdProd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtQtdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbnValProd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtValProd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbnTpPag)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ComboBoxTpPag, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbnDadosCartao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDadosCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(lbnQtdParc)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbnAcrec)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAcrec))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbnDesc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDesc))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtQtdParc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbnDtEnvio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDtEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbnDtVenda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbnDtPag)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDtPag, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnEfetivar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(358, 358, 358)
                                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbnIdFunc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbnIdCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdCliente)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbnFunc)
                                    .addComponent(lbnCliente))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCliente)
                                    .addComponent(txtFunc))))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnIdFunc)
                    .addComponent(txtIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnFunc)
                    .addComponent(txtFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnIdCliente)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnCliente)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnDtVenda)
                    .addComponent(txtDtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnDtPag)
                    .addComponent(txtDtPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnDtEnvio)
                    .addComponent(txtDtEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnIdProduto)
                    .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnProduto)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnQtdProd)
                    .addComponent(txtQtdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnValProd)
                    .addComponent(txtValProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnDesc)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnAcrec)
                    .addComponent(txtAcrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnTpPag)
                    .addComponent(ComboBoxTpPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnDadosCartao)
                    .addComponent(txtDadosCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnQtdParc)
                    .addComponent(txtQtdParc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEfetivar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void btnEfetivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfetivarActionPerformed
        // Chamada de método no botão efetivar

        efetuarVenda();

        // Após a efetivação da venda, chame os métodos para gerar os arquivos PDF e DOCX
        if (this.venda != null) {
            GeradorArquivoVenda geradorArquivo = new GeradorArquivoVenda();
            geradorArquivo.gerarPDF(venda);
            geradorArquivo.gerarDOCX(venda);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao gerar arquivos. Venda não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnEfetivarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // Chamada de método no botão limpar

        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // Chamada de método no botão sair

        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxTpPag;
    private javax.swing.JButton btnEfetivar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JLabel lbnAcrec;
    private javax.swing.JLabel lbnCliente;
    private javax.swing.JLabel lbnDadosCartao;
    private javax.swing.JLabel lbnDesc;
    private javax.swing.JLabel lbnDtEnvio;
    private javax.swing.JLabel lbnDtPag;
    private javax.swing.JLabel lbnDtVenda;
    private javax.swing.JLabel lbnFunc;
    private javax.swing.JLabel lbnIdCliente;
    private javax.swing.JLabel lbnIdFunc;
    private javax.swing.JLabel lbnIdProduto;
    private javax.swing.JLabel lbnProduto;
    private javax.swing.JLabel lbnQtdParc;
    private javax.swing.JLabel lbnQtdProd;
    private javax.swing.JLabel lbnTpPag;
    private javax.swing.JLabel lbnValProd;
    private javax.swing.JTextField txtAcrec;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDadosCartao;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtDtEnvio;
    private javax.swing.JTextField txtDtPag;
    private javax.swing.JTextField txtDtVenda;
    private javax.swing.JTextField txtFunc;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdFunc;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQtdParc;
    private javax.swing.JTextField txtQtdProd;
    private javax.swing.JTextField txtValProd;
    // End of variables declaration//GEN-END:variables
}
