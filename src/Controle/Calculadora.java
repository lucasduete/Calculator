package Controle;

import java.awt.Color;
import java.text.DecimalFormat;

/**
 *
 * @author Lucas Duete
 */
public class Calculadora extends javax.swing.JFrame {

    //Instancias Begin
    
    DecimalFormat df = new DecimalFormat("###.##");
    StringBuffer temp_buffer;
    StringBuffer equacao_buffer;
    
    //Instancias End

    //Atributos Begin
    
    char operacao;
    String copiar;
    String temp;
    boolean r = false;
    boolean pi = false;
    boolean res = false;
    boolean porcentagem = false;
    boolean virgula = false;
    double num1;
    double num2;
    double porc;
    int tamanho = 0;
    int op_cont = 0;
    int fist = 0;
    int pri = 0;
    
    //Atributos End

    /**
     * Creates new form Calculadora
     */
    public Calculadora() {
        initComponents();
        setTitle("Calculadora");
        setLocation(500, 250);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        jTVisor.setVisible(false);
        jTBackup.setVisible(false);
    }

    //Metodos Begin
    
    public void num(String i) {
        if (op_cont == 0) {
            if (i.equals(".")) {
                if (virgula == true) {

                } else {
                    if (jTVisor.getText().equals("")) {
                        temp = jTVisor.getText();;
                        temp = "0" + temp + i;
                        jTVisor.setText(temp);
                        jTEquacao.setText(temp);
                        virgula = true;
                    } else {
                        temp = jTVisor.getText();
                        temp = temp + i;
                        jTVisor.setText(temp);
                        jTEquacao.setText(temp);
                        virgula = true;
                    }
                }
            } else {
                if(i.equals("π")) {
                    temp = jTVisor.getText();
                    temp = temp + "3.1415";
                    jTVisor.setText(temp);
                    jTEquacao.setText(i);
                } else {
                    temp = jTVisor.getText();
                    temp = temp + i;
                    jTVisor.setText(temp);
                    jTEquacao.setText(temp);
                }
            }
            
        } else {
            if (i.equals(".")) {
                if (virgula == true) {

                } else {
                    if (jTVisor.getText().equals("")) {
                        temp = jTVisor.getText();
                        temp = "0" + temp + i;
                        jTVisor.setText(temp);
                        jTEquacao.setText(jTEquacao.getText() + i);
                        virgula = true;
                    } else {
                        temp = jTVisor.getText();
                        temp = temp + i;
                        jTVisor.setText(temp);
                        jTEquacao.setText(jTEquacao.getText() + i);
                        virgula = true;
                    }
                }
            } else {
                if (i.equals("π")) {
                    temp = jTVisor.getText();
                    temp = temp + "3.1415";
                    jTVisor.setText(temp);
                    jTEquacao.setText(jTEquacao.getText() + i);
                } else {
                    temp = jTVisor.getText();
                    temp = temp + i;
                    jTVisor.setText(temp);
                    jTEquacao.setText(jTEquacao.getText() + i);
                }
            }
        }
    }

    public void op(char y) {
        if (fist == 0) {
            if (y == 'x') {
                if (pi == true) {
                    num1 = 3.1415;
                    operacao = y;
                    opm(operacao);
                    virgula = false;
                    jTVisor.setText(null);
                } else {
                    num1 = Double.parseDouble(jTVisor.getText());
                    operacao = y;
                    opm(operacao);
                    virgula = false;
                    jTVisor.setText(null);
                }
            } else {
                if (pi == true){
                    num1 = Double.parseDouble(jTVisor.getText());
                    operacao = y;
                    virgula = false;
                    jTVisor.setText(null);
                } else {
                    num1 = Double.parseDouble(jTVisor.getText());
                    operacao = y;
                    virgula = false;
                    jTVisor.setText(null);
                }
            }
        } else {
            if (pri == 10) {
                if (y == 'x') {
                    operacao = y;
                    r = false;
                    virgula = false;
                    jTVisor.setText(null);
                    jTEquacao.setText(jTEquacao.getText() + "² ");
                } else { 
                    operacao = y;
                    r = false;
                    virgula = false;
                    jTVisor.setText(null);
                    jTEquacao.setText(jTEquacao.getText() + ' ' + y + ' ');
                }
            } else {
                if (pi == true) {
                    jTVisor.setText(String.valueOf(3.1415));
                    operacao = y;
                    opm(operacao);
                    virgula = false;
                    jTVisor.setText(null);
                } else {
                    opm(operacao);
                    operacao = y;
                    virgula = false;
                    jTVisor.setText(null);
                }
            }
        }
        if (res == false) {
            if (y == 'x'){ 
                jTEquacao.setText(jTEquacao.getText() + "² ");
                jTBackup.setText(jTEquacao.getText());
            } else{ 
                jTEquacao.setText(jTEquacao.getText() + ' ' + y + ' ');
                jTBackup.setText(jTEquacao.getText());
            }
        }
        op_cont++;
        fist++;
        pi = false;

    }

    public void opm(char y) {
        switch (y) {
            case '+':
                num1 = num1 + Double.parseDouble(jTVisor.getText());
            break;
            case '-':
                num1 = num1 - Double.parseDouble(jTVisor.getText());
                break;
            case '*':
                num1 = num1 * Double.parseDouble(jTVisor.getText());
            break;
            case '/':
                num1 = num1 / Double.parseDouble(jTVisor.getText());
            break;
            case 'x':
                num1 = num1 * num1;
            break;   
            default:
                

        }
    }

    public void teste() {
        if (r == false) {

        } else {
            jTVisor.setText(null);
            jTEquacao.setText(null);
            jTBackup.setText(null);
            num1 = 0;
            num2 = 0;
            fist = 0;
            op_cont = 0;
            pri = 0;
            virgula = false;
            r = false;
            pi = false;
            res = false;
            porcentagem = false; 
        }
    }
    
    //Metodos End

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jB6 = new javax.swing.JButton();
        jB1 = new javax.swing.JButton();
        jB2 = new javax.swing.JButton();
        jB3 = new javax.swing.JButton();
        jB9 = new javax.swing.JButton();
        jB4 = new javax.swing.JButton();
        jB7 = new javax.swing.JButton();
        jB8 = new javax.swing.JButton();
        jB5 = new javax.swing.JButton();
        jB0 = new javax.swing.JButton();
        jBIgual = new javax.swing.JButton();
        jBSubitracao = new javax.swing.JButton();
        jBMultiplicacao = new javax.swing.JButton();
        jBDivisao = new javax.swing.JButton();
        jBAdicao = new javax.swing.JButton();
        jBVirgula = new javax.swing.JButton();
        jBCE = new javax.swing.JButton();
        jBClr = new javax.swing.JButton();
        jBSinais = new javax.swing.JButton();
        jBC = new javax.swing.JButton();
        jTVisor = new javax.swing.JTextField();
        jTEquacao = new javax.swing.JTextField();
        jTBackup = new javax.swing.JTextField();
        jBPorcentagens = new javax.swing.JButton();
        jBQuadrado = new javax.swing.JButton();
        jBPI = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jB6.setText("6");
        jB6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB6ActionPerformed(evt);
            }
        });

        jB1.setText("1");
        jB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB1ActionPerformed(evt);
            }
        });

        jB2.setText("2");
        jB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB2ActionPerformed(evt);
            }
        });

        jB3.setText("3");
        jB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB3ActionPerformed(evt);
            }
        });

        jB9.setText("9");
        jB9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB9ActionPerformed(evt);
            }
        });

        jB4.setText("4");
        jB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB4ActionPerformed(evt);
            }
        });

        jB7.setText("7");
        jB7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB7ActionPerformed(evt);
            }
        });

        jB8.setText("8");
        jB8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB8ActionPerformed(evt);
            }
        });

        jB5.setText("5");
        jB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB5ActionPerformed(evt);
            }
        });

        jB0.setText("0");
        jB0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB0ActionPerformed(evt);
            }
        });

        jBIgual.setText("=");
        jBIgual.setToolTipText("Efetua o calculo");
        jBIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIgualActionPerformed(evt);
            }
        });

        jBSubitracao.setText("-");
        jBSubitracao.setToolTipText("Efetua subitração");
        jBSubitracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSubitracaoActionPerformed(evt);
            }
        });

        jBMultiplicacao.setText("*");
        jBMultiplicacao.setToolTipText("Efetua Multiplicação");
        jBMultiplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMultiplicacaoActionPerformed(evt);
            }
        });

        jBDivisao.setText("/");
        jBDivisao.setToolTipText("Efetua Divisão");
        jBDivisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDivisaoActionPerformed(evt);
            }
        });

        jBAdicao.setText("+");
        jBAdicao.setToolTipText("Efetua soma");
        jBAdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicaoActionPerformed(evt);
            }
        });

        jBVirgula.setText(".");
        jBVirgula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVirgulaActionPerformed(evt);
            }
        });

        jBCE.setText("CE");
        jBCE.setToolTipText("Apaga o último termo digitado");
        jBCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCEActionPerformed(evt);
            }
        });

        jBClr.setText("Clr");
        jBClr.setToolTipText("Reinicia os calculos");
        jBClr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClrActionPerformed(evt);
            }
        });

        jBSinais.setText("+/-");
        jBSinais.setToolTipText("Troca a polaridade do número");
        jBSinais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSinaisActionPerformed(evt);
            }
        });

        jBC.setText("C");
        jBC.setToolTipText("Apaga o último número digitado");
        jBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCActionPerformed(evt);
            }
        });

        jTVisor.setEditable(false);

        jTEquacao.setEditable(false);
        jTEquacao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTBackup.setEditable(false);

        jBPorcentagens.setText("%");
        jBPorcentagens.setToolTipText("Calcula a porcentagem");
        jBPorcentagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPorcentagensActionPerformed(evt);
            }
        });

        jBQuadrado.setText("x²");
        jBQuadrado.setToolTipText("Eleva o número ao quadrado");
        jBQuadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuadradoActionPerformed(evt);
            }
        });

        jBPI.setText("π");
        jBPI.setToolTipText("Insere o número pi");
        jBPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTEquacao)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jBC, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBCE, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBClr, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jB0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                    .addComponent(jB4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jB1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jB7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jB8, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                            .addComponent(jB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jB5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jB3, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                            .addComponent(jB6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jB9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jBVirgula, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBMultiplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBAdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBSubitracao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBDivisao, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBPorcentagens, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBQuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBPI, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBSinais, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTVisor, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTEquacao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTVisor, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBC)
                    .addComponent(jBClr)
                    .addComponent(jBCE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB1)
                    .addComponent(jB2)
                    .addComponent(jB3)
                    .addComponent(jBAdicao)
                    .addComponent(jBSinais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB4)
                    .addComponent(jB5)
                    .addComponent(jB6)
                    .addComponent(jBSubitracao)
                    .addComponent(jBPorcentagens))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB8)
                    .addComponent(jB9)
                    .addComponent(jB7)
                    .addComponent(jBMultiplicacao)
                    .addComponent(jBQuadrado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDivisao)
                    .addComponent(jBIgual)
                    .addComponent(jBVirgula)
                    .addComponent(jB0)
                    .addComponent(jBPI))
                .addGap(40, 40, 40))
        );

        jMenu1.setMnemonic('c');
        jMenu1.setText("Calculadora");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setMnemonic('e');
        jMenu2.setText("Editar");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Copiar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Colar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setMnemonic('s');
        jMenu3.setText("Sobre");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setMnemonic('e');
        jMenu4.setText("Sair");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        new JFSobre().show();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        copiar = jTVisor.getText();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        jTVisor.setText(copiar);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCActionPerformed
        // TODO add your handling code here:
        temp_buffer = new StringBuffer(temp);
        tamanho = temp.length();
        temp_buffer.deleteCharAt((tamanho - 1));
        jTVisor.setText(temp_buffer.toString());
        equacao_buffer = new StringBuffer(jTEquacao.getText());
        tamanho = equacao_buffer.length();
        equacao_buffer.deleteCharAt((tamanho - 1));
        jTEquacao.setText(equacao_buffer.toString());
        virgula = false;
    }//GEN-LAST:event_jBCActionPerformed

    private void jBSinaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSinaisActionPerformed
        // TODO add your handling code here:
        if (pi == false) {
            if (temp.startsWith("-")) {
                temp = temp.replace("-", "+");
            } else if (temp.startsWith("+")) {
                temp = temp.replace("+", "-");
            } else {
                temp = "-" + temp;
            }
            jTVisor.setText(temp);
            jTEquacao.setText(jTBackup.getText() + "(" + jTVisor.getText() + ")");
        } else {
            if (temp.startsWith("-")) {
                temp = temp.replace("-", "+");
                jTVisor.setText(temp);
                temp = "-" + "π";
                temp = temp.replace("-", "+");
            } else if (temp.startsWith("+")) {
                temp = temp.replace("+", "-");
                jTVisor.setText(temp);
                temp = "+" + "π";
                temp = temp.replace("+", "-");
            } else {
                temp = "-" + temp;
                jTVisor.setText(temp);
                temp = "π";
                temp = "-" + temp;
            }
            jTEquacao.setText(jTBackup.getText() + "(" + temp + ")");
            temp = "";
        }
    }//GEN-LAST:event_jBSinaisActionPerformed

    private void jBClrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClrActionPerformed
        // TODO add your handling code here:
        num1 = 0;
        num2 = 0;
        fist = 0;
        pri = 0;
        op_cont = 0;
        temp = "";
        virgula = false;
        r = true;
        pi = false;
        porcentagem = false;
        jTVisor.setText(null);
        jTEquacao.setText(null);
        jTBackup.setText(null);
        
        System.gc();
        
    }//GEN-LAST:event_jBClrActionPerformed

    private void jBCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCEActionPerformed
        // TODO add your handling code here
        if (r == true){
            num1 = 0;
            num2 = 0;
            fist = 0;
            pri = 0;
            op_cont = 0;
            temp = "";
            virgula = false;
            r = true;
            pi = false;
            porcentagem = false;
            jTVisor.setText(null);
            jTEquacao.setText(null);
            jTBackup.setText(null);
        } else {
            jTVisor.setText(String.valueOf(num1));
            jTVisor.setText(null);
            jTEquacao.setText(jTBackup.getText());
            virgula = false;
            pi = false;
        }
        
        System.gc();
        
    }//GEN-LAST:event_jBCEActionPerformed

    private void jBVirgulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVirgulaActionPerformed
        // TODO add your handling code here:
        teste();
        num(".");
    }//GEN-LAST:event_jBVirgulaActionPerformed

    private void jBAdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdicaoActionPerformed
        // TODO add your handling code here:
        op('+');
    }//GEN-LAST:event_jBAdicaoActionPerformed

    private void jBDivisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDivisaoActionPerformed
        // TODO add your handling code here:
        op('/');
    }//GEN-LAST:event_jBDivisaoActionPerformed

    private void jBMultiplicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMultiplicacaoActionPerformed
        // TODO add your handling code here:
        op('*');
    }//GEN-LAST:event_jBMultiplicacaoActionPerformed

    private void jBSubitracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSubitracaoActionPerformed
        // TODO add your handling code here:
        op('-');
    }//GEN-LAST:event_jBSubitracaoActionPerformed

    private void jBIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIgualActionPerformed
        // TODO add your handling code here:
        res = true;
        if (pri == 0) {
            if (operacao == 'x') {
                jTVisor.setText(String.valueOf(df.format(num1)));
                jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                r = true;
                pi = false;
                pri = 10; 
            } else if (pi == true) {
                num2 = 3.1415;
                op(operacao);
                jTVisor.setText(String.valueOf(df.format(num1)));
                jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                r = true;
                pi = false;
                pri = 10;
            } else if (porcentagem == true) {
                porc = (( num1 * num2) / 100);
                switch (operacao) {
                    case '+':
                        num1 = num1 + porc;
                        jTVisor.setText(String.valueOf(df.format(num1)));
                        jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                    break;
                    case '-':
                        num1 = num1 - porc;
                        jTVisor.setText(String.valueOf(df.format(num1)));
                        jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                    break;
                    case '*':
                        num1 = num1 * porc;
                        jTVisor.setText(String.valueOf(num1));
                        jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                    break;
                    case '/':
                        num1 = num1 / porc;
                        jTVisor.setText(String.valueOf(df.format(num1)));
                        jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                    break;
                    case 'x':
                    num1 = num1 * porc;
                    jTVisor.setText(String.valueOf(df.format(num1)));
                    jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                    break;
                }
                r = true;
                pri = 10;
            } else {
                num2 = Double.parseDouble(jTVisor.getText());
                op(operacao);
                jTVisor.setText(String.valueOf(df.format(num1)));
                jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                r = true;
                pri = 10;
            }
        } else {
            switch (operacao) {
                case '+':
                    num1 = num1 + num2;
                    jTVisor.setText(String.valueOf(df.format(num1)));
                    jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                break;
                case '-':
                    num1 = num1 - num2;
                    jTVisor.setText(String.valueOf(df.format(num1)));
                    jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                break;
                case '*':
                    num1 = num1 * num2;
                    jTVisor.setText(String.valueOf(num1));
                    jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                break;
                case '/':
                    num1 = num1 / num2;
                    jTVisor.setText(String.valueOf(df.format(num1)));
                    jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                break;
                case 'x':
                    num1 = num1 * num1;
                    jTVisor.setText(String.valueOf(df.format(num1)));
                    jTEquacao.setText(jTEquacao.getText() + " = " + jTVisor.getText());
                break;
            }
            r = true;
        }
    }//GEN-LAST:event_jBIgualActionPerformed

    private void jB0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB0ActionPerformed
        // TODO add your handling code here:
        teste();
        num("0");
    }//GEN-LAST:event_jB0ActionPerformed

    private void jB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB5ActionPerformed
        // TODO add your handling code here:
        teste();
        num("5");
    }//GEN-LAST:event_jB5ActionPerformed

    private void jB8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB8ActionPerformed
        // TODO add your handling code here:
        teste();
        num("8");
    }//GEN-LAST:event_jB8ActionPerformed

    private void jB7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB7ActionPerformed
        // TODO add your handling code here:
        teste();
        num("7");
    }//GEN-LAST:event_jB7ActionPerformed

    private void jB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB4ActionPerformed
        // TODO add your handling code here:
        teste();
        num("4");
    }//GEN-LAST:event_jB4ActionPerformed

    private void jB9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB9ActionPerformed
        // TODO add your handling code here:
        teste();
        num("9");
    }//GEN-LAST:event_jB9ActionPerformed

    private void jB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB3ActionPerformed
        // TODO add your handling code here:
        teste();
        num("3");
    }//GEN-LAST:event_jB3ActionPerformed

    private void jB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB2ActionPerformed
        // TODO add your handling code here:
        teste();
        num("2");
    }//GEN-LAST:event_jB2ActionPerformed

    private void jB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB1ActionPerformed
        // TODO add your handling code here:
        teste();
        num("1");
    }//GEN-LAST:event_jB1ActionPerformed

    private void jB6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB6ActionPerformed
        // TODO add your handling code here:
        teste();
        num("6");
    }//GEN-LAST:event_jB6ActionPerformed

    private void jBPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPIActionPerformed
        // TODO add your handling code here:
        teste();
        pi = true;
        num("π");
    }//GEN-LAST:event_jBPIActionPerformed

    private void jBQuadradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuadradoActionPerformed
        // TODO add your handling code here:
        op('x');
    }//GEN-LAST:event_jBQuadradoActionPerformed

    private void jBPorcentagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPorcentagensActionPerformed
        // TODO add your handling code here:
        jTEquacao.setText(jTEquacao.getText() + "%");
        num2 = Double.parseDouble(jTVisor.getText());
        porcentagem = true;
    }//GEN-LAST:event_jBPorcentagensActionPerformed

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
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB0;
    private javax.swing.JButton jB1;
    private javax.swing.JButton jB2;
    private javax.swing.JButton jB3;
    private javax.swing.JButton jB4;
    private javax.swing.JButton jB5;
    private javax.swing.JButton jB6;
    private javax.swing.JButton jB7;
    private javax.swing.JButton jB8;
    private javax.swing.JButton jB9;
    private javax.swing.JButton jBAdicao;
    private javax.swing.JButton jBC;
    private javax.swing.JButton jBCE;
    private javax.swing.JButton jBClr;
    private javax.swing.JButton jBDivisao;
    private javax.swing.JButton jBIgual;
    private javax.swing.JButton jBMultiplicacao;
    private javax.swing.JButton jBPI;
    private javax.swing.JButton jBPorcentagens;
    private javax.swing.JButton jBQuadrado;
    private javax.swing.JButton jBSinais;
    private javax.swing.JButton jBSubitracao;
    private javax.swing.JButton jBVirgula;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTBackup;
    private javax.swing.JTextField jTEquacao;
    private javax.swing.JTextField jTVisor;
    // End of variables declaration//GEN-END:variables
}
