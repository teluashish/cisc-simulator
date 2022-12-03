package front;

import java.awt.Component;
//import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import alu.instruction.AbstractInstruction;
import cpu.Registers;
import memory.Cache.CacheLine;
import memory.MCU;
import util.Const;
import util.MachineFaultException;
import util.StringUtil;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrontPanel {

    /**
     * 0 - the registers panel is not enabled. </br>
     * 1 - the registers panel has been enabled.
     */
	
	
    static boolean checkValidString(String word) {
    	for(int i=0;i<word.length();i++) {
    		if(word.charAt(i)!='1' && word.charAt(i)!='0') {
                JOptionPane.showMessageDialog(null, "Enter only binary values!" + word.charAt(i));
                return false;
    		}
    	}
    	return true;
    }
    
    static String removeLeadingZeores(String str) {
        int ind = 0;
        for (int i = 0; i < str.length(); i++) {
            char p = str.charAt(i);
            if (p != '0') {
                ind = i;
                break;
            }
        }
        return str.substring(ind, str.length());
    }
	
	
	
	
	
	
    private int enableFlag;
    private int prog1Step;
    private int prog2Step;

    JFrame frmCsciClassProject;
    private JPanel pnlRegisters;
    private JPanel pnlR0;
    private JLabel lblR;

    private JTextField textFieldR0;
    private JTextField textFieldR1;
    private JButton btnStoreR0;
    private JPanel pnlR1;
    private JLabel lblR_1;

    private JButton btnStoreR1;
    private JPanel pnlR2;
    private JLabel lblR_2;

    private JTextField textFieldR2;
    private JButton btnStoreR2;
    private JPanel pnlR3;
    private JLabel lblR_3;

    private JTextField textFieldR3;
    private JButton btnStoreR3;
    private JPanel pnlX1;
    private JLabel lblX;

    private JTextField textFieldX1;
    private JButton btnStoreX1;
    private JPanel pnlX2;
    private JLabel lblX_1;

    private JTextField textFieldX2;
    private JButton btnStoreX2;
    private JPanel pnlX3;
    private JLabel lblX_2;

    private JTextField textFieldX3;
    private JButton btnStoreX3;
    private JPanel pnlMAR;
    private JLabel lblMAR;

    private JTextField textFieldMAR;
    private JButton btnStoreMAR;
    private JPanel pnlMBR;
    private JLabel lblMBR;

    private JTextField textFieldMBR;
    private JButton btnStoreMBR;
    private JPanel pnlMSR;
    private JLabel lblMSR;

    private JTextField textFieldMSR;
    private JButton btnStoreMSR;
    private JPanel pnlIR;
    private JLabel lblIR;

    private JTextField textFieldIR;
    private JButton btnStoreIR;
    private JPanel pnlPC;
    private JLabel lblPC;

    private JTextField textFieldPC;
    private JButton btnStorePC;
    private JPanel pnlCC;
    private JLabel lblCC;

    private JTextField textFieldCC;
    private JButton btnStoreCC;
    private JPanel pnlMFR;
    private JLabel lblMFR;

    private JTextField textFieldMFR;
    private JButton btnStoreMFR;
    private JButton btnIPL;
    private Registers registers;
    private MCU mcu;
    private JPanel pnlIns;
    private JLabel lblIns;

    private JButton btnExecute;
    private JTextArea consolePrinter;
    private JScrollPane scrollPane1;
    private JTextField textFieldAddress;
    private JTextField textFieldValue;
    private JPanel testPanel;
    private JPanel pnlAddress;
    private JLabel lblAddress;
    private JPanel pnlValue;
    private JLabel lblValue;
    private JPanel pnlButton;
    private JButton btnStore;
    private JButton btnLoad;
    private JLabel lblPrinter;
    private JLabel lblTestPanel;
    private JPanel pnlPrinter;

    private JLabel lblKeyboard;

    private JScrollPane scrollPane2;

    private JTextArea consoleKeyboard;
    private JPanel pnlOp;
    private JTable tableCache;

    private JPanel pnlCache;

    private JLabel lblCache;

    private JScrollPane scrollPane3;

    private JButton btnNums;
    private JPanel pnlProgram1;

    private JLabel lblProgram1;

    private JButton btnCompare;
    private JPanel pnlKeyb;
    private JButton btnRunSingleStep;
    private JPanel pnlProgram2;
    private JLabel lblProgram;
    private JButton btnLoadSentences;
    private JButton btnFindWord;
    private JPanel pnlFR0;
    private JLabel lblFr;

    private JTextField textFieldFR0;
    private JButton btnStoreFR0;
    private JPanel pnlFR1;
    private JLabel lblFr_1;

    private JTextField textFieldFR1;
    private JButton btnStoreFR1;
    private JButton btnExample;

    private JLabel lblNewLabel_2;

    /**
     * Launch the application.
     */
    

    /**
     * Create the application.
     */
    public FrontPanel() {
        initComponents();
        addListeners();

    }

    /**
     * initialize the registers and the memory control unit
     */
    private void initCPU() {
        registers = new Registers();
        mcu = new MCU();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initComponents() {
        frmCsciClassProject = new JFrame();
        frmCsciClassProject.setTitle("CISC SIMULATOR GROUP - 6");
        frmCsciClassProject.setBounds(100, 100, 1097, 980);
        frmCsciClassProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnlRegisters = new JPanel();
        pnlRegisters.setBounds(16, 225, 656, 381);

        pnlR3 = new JPanel();

        lblR_3 = new JLabel("R3");
        pnlR3.add(lblR_3);

        
        JTextField textFieldR3R = new JTextField();
        textFieldR3R.setEditable(true);
        textFieldR3R.setColumns(16);
        pnlR3.add(textFieldR3R);
        
        textFieldR3 = new JTextField();
        textFieldR3.setEditable(false);
        textFieldR3.setColumns(10);


        btnStoreR3 = new JButton("Load");
        pnlR3.add(btnStoreR3);

        // Panel for X1 Register
        pnlX1 = new JPanel();
        lblX = new JLabel("X1");
        pnlX1.add(lblX);

        JTextField textFieldX1R = new JTextField();
        textFieldX1R.setEditable(true);
        textFieldX1R.setColumns(16);
        pnlX1.add(textFieldX1R); 
        
        textFieldX1 = new JTextField();
        textFieldX1.setEditable(false);
        textFieldX1.setColumns(10);


        btnStoreX1 = new JButton("Load");
        pnlX1.add(btnStoreX1);

//      Panel for X2 Register
        pnlX2 = new JPanel();

        lblX_1 = new JLabel("X2");
        pnlX2.add(lblX_1);

        JTextField textFieldX2R = new JTextField();
        textFieldX2R.setEditable(true);
        textFieldX2R.setColumns(16);
        pnlX2.add(textFieldX2R);
        
        textFieldX2 = new JTextField();
        textFieldX2.setEditable(false);
        textFieldX2.setColumns(10);

        btnStoreX2 = new JButton("Load");
        pnlX2.add(btnStoreX2);
        
        
//		Panel for X3 Register
        pnlX3 = new JPanel();

        lblX_2 = new JLabel("X3");
        pnlX3.add(lblX_2);

        JTextField textFieldX3R = new JTextField();
        textFieldX3R.setEditable(true);
        textFieldX3R.setColumns(16);
        pnlX3.add(textFieldX3R);

        textFieldX3 = new JTextField();
        textFieldX3.setEditable(false);
        textFieldX3.setColumns(10);


        btnStoreX3 = new JButton("Load");
        pnlX3.add(btnStoreX3);
        
        
//		Panel for MAR Register
        pnlMAR = new JPanel();

        lblMAR = new JLabel("MAR");
        pnlMAR.add(lblMAR);

        JTextField textFieldMARR = new JTextField();
        textFieldMARR.setEditable(true);
        textFieldMARR.setColumns(16);
        pnlMAR.add(textFieldMARR);

        textFieldMAR = new JTextField();
        textFieldMAR.setEditable(false);
        textFieldMAR.setColumns(10);


        btnStoreMAR = new JButton("Load");
        pnlMAR.add(btnStoreMAR);

        
//		Panel for MBR Register
        pnlMBR = new JPanel();

        lblMBR = new JLabel("MBR");
        pnlMBR.add(lblMBR);

        JTextField textFieldMBRR = new JTextField();
        textFieldMBRR.setEditable(true);
        textFieldMBRR.setColumns(16);
        pnlMBR.add(textFieldMBRR);

        textFieldMBR = new JTextField();
        textFieldMBR.setEditable(false);
        textFieldMBR.setColumns(10);


        btnStoreMBR = new JButton("Load");
        pnlMBR.add(btnStoreMBR);

        
//		Panel for MSR Register        
        pnlMSR = new JPanel();

        lblMSR = new JLabel("MSR");
        pnlMSR.add(lblMSR);

        JTextField textFieldMSRR = new JTextField();
        textFieldMSRR.setEditable(true);
        textFieldMSRR.setColumns(16);
        pnlMSR.add(textFieldMSRR);
        
        textFieldMSR = new JTextField();
        textFieldMSR.setEditable(false);
        textFieldMSR.setColumns(10);


        btnStoreMSR = new JButton("Load");
        pnlMSR.add(btnStoreMSR);

        
//		Panel for IR Register   
        pnlIR = new JPanel();

        lblIR = new JLabel("IR");
        pnlIR.add(lblIR);

        JTextField textFieldIRR = new JTextField();
        textFieldIRR.setEditable(true);
        textFieldIRR.setColumns(16);
        pnlIR.add(textFieldIRR);

        textFieldIR = new JTextField();
        textFieldIR.setEditable(false);
        textFieldIR.setColumns(10);


        btnStoreIR = new JButton("Load");
        btnStoreIR.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        pnlIR.add(btnStoreIR);

        
//		Panel for PC Register   
        pnlPC = new JPanel();

        lblPC = new JLabel("PC");
        pnlPC.add(lblPC);

        
        JTextField textFieldPCR = new JTextField();
        textFieldPCR.setEditable(true);
        textFieldPCR.setColumns(16);
        pnlPC.add(textFieldPCR);     

        textFieldPC = new JTextField();
        textFieldPC.setEditable(false);
        textFieldPC.setColumns(10);


        btnStorePC = new JButton("Load");
        pnlPC.add(btnStorePC);

        
//		Panel for R0 Register   
        pnlR0 = new JPanel();

        lblR = new JLabel("R0");
        pnlR0.add(lblR);

        JTextField textFieldR0R = new JTextField();
        textFieldR0R.setEditable(true);
        textFieldR0R.setColumns(16);
        pnlR0.add(textFieldR0R);   

        textFieldR0 = new JTextField();
        textFieldR0.setEditable(false);
        textFieldR0.setColumns(10);

        btnStoreR0 = new JButton("Load");
        btnStoreR0.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        pnlRegisters.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlR0.add(btnStoreR0);
        pnlRegisters.add(pnlR0);

//		Panel for R1 Register   
        pnlR1 = new JPanel();

        lblR_1 = new JLabel("R1");
        pnlR1.add(lblR_1);


        JTextField textFieldR1R = new JTextField();
        textFieldR1R.setEditable(true);
        textFieldR1R.setColumns(16);
        pnlR1.add(textFieldR1R);

        textFieldR1 = new JTextField();
        textFieldR1.setEditable(false);
        textFieldR1.setColumns(10);


        btnStoreR1 = new JButton("Load");
        pnlR1.add(btnStoreR1);
        pnlRegisters.add(pnlR1);

//		Panel for R2 Register   
        pnlR2 = new JPanel();

        lblR_2 = new JLabel("R2");
        pnlR2.add(lblR_2);

        JTextField textFieldR2R = new JTextField();
        textFieldR2R.setEditable(true);
        textFieldR2R.setColumns(16);
        pnlR2.add(textFieldR2R);

        textFieldR2 = new JTextField();
        textFieldR2.setEditable(false);
        textFieldR2.setColumns(10);


        btnStoreR2 = new JButton("Load");
        pnlR2.add(btnStoreR2);
        pnlRegisters.add(pnlR2);
        pnlRegisters.add(pnlR3);
        pnlRegisters.add(pnlX1);
        pnlRegisters.add(pnlX2);
        pnlRegisters.add(pnlX3);
        pnlRegisters.add(pnlMAR);
        pnlRegisters.add(pnlMBR);
        pnlRegisters.add(pnlMSR);
        pnlRegisters.add(pnlPC);
        pnlRegisters.add(pnlIR);

        
//		Panel for CC Register   
        pnlCC = new JPanel();

        lblCC = new JLabel("CC");
        pnlCC.add(lblCC);

        JTextField textFieldCCR = new JTextField();
        textFieldCCR.setEditable(true);
        textFieldCCR.setColumns(16);
        pnlCC.add(textFieldCCR);

        textFieldCC = new JTextField();
        textFieldCC.setEditable(false);
        textFieldCC.setColumns(10);
        

        btnStoreCC = new JButton("Load");
        pnlCC.add(btnStoreCC);
        pnlRegisters.add(pnlCC);

        btnIPL = new JButton("IPL");
        btnIPL.setBounds(684, 60, 132, 23);

        testPanel = new JPanel();
        testPanel.setBounds(697, 140, 200, 165);
        testPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        lblTestPanel = new JLabel("Main Memory");
        testPanel.add(lblTestPanel);

        pnlAddress = new JPanel();
        testPanel.add(pnlAddress);
        pnlAddress.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblAddress = new JLabel("address");
        pnlAddress.add(lblAddress);

        textFieldAddress = new JTextField();
        textFieldAddress.setText("0");
        pnlAddress.add(textFieldAddress);
        textFieldAddress.setColumns(10);

        pnlValue = new JPanel();
        testPanel.add(pnlValue);
        pnlValue.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblValue = new JLabel("value");
        pnlValue.add(lblValue);

        textFieldValue = new JTextField();
        textFieldValue.setText("0");
        pnlValue.add(textFieldValue);
        textFieldValue.setColumns(10);

        pnlButton = new JPanel();
        testPanel.add(pnlButton);
        pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        btnLoad = new JButton("load");
        pnlButton.add(btnLoad);
        
                btnStore = new JButton("store");
                pnlButton.add(btnStore);
        setEnableForPanel(pnlRegisters, false);

        pnlPrinter = new JPanel();
        pnlPrinter.setBounds(684, 317, 193, 130);
        pnlPrinter.setLayout(new BoxLayout(pnlPrinter, BoxLayout.Y_AXIS));

        lblPrinter = new JLabel("Output");
        pnlPrinter.add(lblPrinter);

        scrollPane1 = new JScrollPane();
        pnlPrinter.add(scrollPane1);

        consolePrinter = new JTextArea();
        consolePrinter.setLineWrap(true);
        consolePrinter.setEditable(false);
        scrollPane1.setViewportView(consolePrinter);

        pnlOp = new JPanel();
        pnlOp.setBounds(158, 113, 527, 49);
        pnlOp.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        pnlIns = new JPanel();
        pnlOp.add(pnlIns);
        pnlIns.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblIns = new JLabel("Enter Instruction to be Executed");
        pnlIns.add(lblIns);

        JTextField textFieldInsR = new JTextField();
        textFieldInsR.setEditable(true);
        textFieldInsR.setColumns(16);
        pnlIns.add(textFieldInsR);
        
        btnExecute = new JButton("Run");
        btnExecute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        pnlIns.add(btnExecute);

        // set the panels to disabled
        // after you push the IPL button on the frontpanel, these panels will be
        // set to enabled
        setEnableForPanel(pnlIns, false);

        pnlCache = new JPanel();
        pnlCache.setBounds(909, 150, 167, 118);

        lblCache = new JLabel("Cache");

        scrollPane3 = new JScrollPane();

        tableCache = new JTable(16, 2);
        tableCache.setEnabled(false);
        scrollPane3.setViewportView(tableCache);
        tableCache.setModel(new DefaultTableModel(
                new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
                        { null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
                        { null, null }, { null, null }, { null, null }, { null, null }, { null, null }, },
                new String[] { "Tag", "Data" }));
        pnlCache.setLayout(new BoxLayout(pnlCache, BoxLayout.Y_AXIS));
        pnlCache.add(lblCache);
        pnlCache.add(scrollPane3);

        pnlProgram1 = new JPanel();
        pnlProgram1.setBounds(694, 470, 162, 92);

        lblProgram1 = new JLabel("Program 1");
        pnlProgram1.add(lblProgram1);

        btnNums = new JButton("Read(nums: 20)");
        pnlProgram1.add(btnNums);

        btnCompare = new JButton("Find Closest");
        pnlProgram1.add(btnCompare);
        setEnableForPanel(pnlProgram1, false);
        frmCsciClassProject.getContentPane().setLayout(null);
        frmCsciClassProject.getContentPane().add(pnlOp);
        frmCsciClassProject.getContentPane().add(pnlRegisters);
        
        // Panel for MFR Register
        pnlMFR = new JPanel();
        
        lblMFR = new JLabel("MFR");
        pnlMFR.add(lblMFR);
        
        JTextField textFieldMFRR = new JTextField();
        textFieldMFRR.setEditable(true);
        textFieldMFRR.setColumns(16);
        pnlMFR.add(textFieldMFRR);
        
                                                            
		btnStoreMFR = new JButton("Load");
		btnStoreMFR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlMFR.add(btnStoreMFR);
		pnlRegisters.add(pnlMFR);
        
        pnlFR0 = new JPanel();
        pnlRegisters.add(pnlFR0);
        
        lblFr = new JLabel("FR0");
        pnlFR0.add(lblFr);
        

        
        JTextField textFieldFR0R = new JTextField();
        textFieldFR0R.setEditable(true);
        textFieldFR0R.setColumns(10);
        pnlFR0.add(textFieldFR0R);
        
        textFieldFR0 = new JTextField();
        textFieldFR0.setEditable(false);
        textFieldFR0.setColumns(10);

        
        btnStoreFR0 = new JButton("Load");
        btnStoreFR0.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        pnlFR0.add(btnStoreFR0);
        
        pnlFR1 = new JPanel();
        pnlRegisters.add(pnlFR1);
        
        lblFr_1 = new JLabel("FR1");
        pnlFR1.add(lblFr_1);

        
        JTextField textFieldFR1R = new JTextField();
        textFieldFR1R.setEditable(true);
        textFieldFR1R.setColumns(10);
        pnlFR1.add(textFieldFR1R);
        
        textFieldFR1 = new JTextField();
        textFieldFR1.setEditable(false);
        textFieldFR1.setColumns(10);

        
        btnStoreFR1 = new JButton("Load");
        pnlFR1.add(btnStoreFR1);
                                                        
		textFieldMFR = new JTextField();
		textFieldMFR.setEditable(false);
		textFieldMFR.setColumns(10);
		
        frmCsciClassProject.getContentPane().add(btnIPL);
        frmCsciClassProject.getContentPane().add(pnlPrinter);
        frmCsciClassProject.getContentPane().add(testPanel);
        frmCsciClassProject.getContentPane().add(pnlProgram1);
        frmCsciClassProject.getContentPane().add(pnlCache);

        pnlKeyb = new JPanel();
        pnlKeyb.setBounds(889, 317, 187, 130);
        frmCsciClassProject.getContentPane().add(pnlKeyb);
        pnlKeyb.setLayout(new BoxLayout(pnlKeyb, BoxLayout.Y_AXIS));

        lblKeyboard = new JLabel("Input");
        pnlKeyb.add(lblKeyboard);

        scrollPane2 = new JScrollPane();
        pnlKeyb.add(scrollPane2);

        consoleKeyboard = new JTextArea();
        consoleKeyboard.setLineWrap(true);
        scrollPane2.setViewportView(consoleKeyboard);

        btnRunSingleStep = new JButton("Single Step");
        btnRunSingleStep.setBounds(828, 60, 132, 23);
        btnRunSingleStep.setEnabled(false);
        frmCsciClassProject.getContentPane().add(btnRunSingleStep);

        pnlProgram2 = new JPanel();
        pnlProgram2.setBounds(899, 470, 147, 118);
        frmCsciClassProject.getContentPane().add(pnlProgram2);

        lblProgram = new JLabel("Program 2");
        pnlProgram2.add(lblProgram);

        btnLoadSentences = new JButton("Load Sentences");
        pnlProgram2.add(btnLoadSentences);

        btnFindWord = new JButton("Find Word");
        pnlProgram2.add(btnFindWord);
        setEnableForPanel(pnlProgram2, false);
        
        btnExample = new JButton("VADD Example");
        btnExample.setBounds(959, 55, 119, 32);
        frmCsciClassProject.getContentPane().add(btnExample);
        
        JLabel lblNewLabel = new JLabel("Common Bus");
        lblNewLabel.setBounds(103, 197, 111, 16);
        frmCsciClassProject.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Common Bus");
        lblNewLabel_1.setBounds(415, 197, 99, 16);
        frmCsciClassProject.getContentPane().add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("CISC Simulator | Group - 6 | Complete Project - 4");
        lblNewLabel_2.setBounds(256, 48, 323, 16);
        frmCsciClassProject.getContentPane().add(lblNewLabel_2);
        enableFlag = 0;

    }

    /**
     * Add listeners to the components
     */
    
    
    private boolean check(String word) {
    	for(int i=0;i<word.length();i++) {
    		if(word.charAt(i)!='0' && word.charAt(i)!='1' ) {
    			return false;
    		}
    	}
    	return true;
    }
    
    
    
    
    private void addListeners() {

        // add listener to the store button of R0. when you push the store
        // button, the selecting status of the radio buttons will be read, and
        // this method will calculate the value of the register, then put it
        // into the text field and store it into the
        // register. no effective value will be read from text field
        btnStoreR0.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();
                int i = 0;
                boolean sign = false;

                JTextField field = (JTextField) pnlR0.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                	sign = (fieldText.charAt(0)=='1') && (fieldText.length()==16);
                	int value = StringUtil.signedBinaryToDecimal(buffer.toString(), sign);
                	//textFieldR0.setText(String.valueOf(value));
                	registers.setR0(value);
                	printConsole("R0 is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");
            }
        });
        // add listener to the store button of R1
        btnStoreR1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();
                int i = 0;
                boolean sign = false;

                JTextField field = (JTextField) pnlR1.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                	sign = (fieldText.charAt(0)=='1') && (fieldText.length()==16);
                    int value = StringUtil.signedBinaryToDecimal(buffer.toString(), sign);
                    textFieldR1.setText(String.valueOf(value));
                    registers.setR1(value);
                    System.out.println("R1 is set to: " + value);
                    printConsole("R1 is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");


            }
        });
        // add listener to the store button of R2
        btnStoreR2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();
                int i = 0;
                boolean sign = false;


                JTextField field = (JTextField) pnlR2.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                	sign = (fieldText.charAt(0)=='1') && (fieldText.length()==16);
                    int value = StringUtil.signedBinaryToDecimal(buffer.toString(), sign);
                    textFieldR2.setText(String.valueOf(value));
                    registers.setR2(value);
                    System.out.println("R2 is set to: " + value);
                    printConsole("R2 is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");




            }
        });
        // add listener to the store button of R3
        btnStoreR3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();
                int i = 0;
                boolean sign = false;

                JTextField field = (JTextField) pnlR3.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                	sign = (fieldText.charAt(0)=='1') && (fieldText.length()==16);
                    int value = StringUtil.signedBinaryToDecimal(buffer.toString(), sign);
                    textFieldR3.setText(String.valueOf(value));
                    registers.setR3(value);
                    System.out.println("R3 is set to: " + value);
                    printConsole("R3 is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");






            }
        });
        // add listener to the store button of X1
        btnStoreX1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();

                JTextField field = (JTextField) pnlX1.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                    int value = StringUtil.binaryToDecimal(buffer.toString());
                    textFieldX1.setText(String.valueOf(value));
                    registers.setX1(value);
                    System.out.println("X1 is set to: " + value);
                    printConsole("X1 is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");






            }
        });
        // add listener to the store button of X2
        btnStoreX2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();

                JTextField field = (JTextField) pnlX2.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                    int value = StringUtil.binaryToDecimal(buffer.toString());
                    textFieldX2.setText(String.valueOf(value));
                    registers.setX2(value);
                    System.out.println("X2 is set to: " + value);
                    printConsole("X2 is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");



            }
        });
        // add listener to the store button of X3
        btnStoreX3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();


                JTextField field = (JTextField) pnlX3.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                    int value = StringUtil.binaryToDecimal(buffer.toString());
                    textFieldX3.setText(String.valueOf(value));
                    registers.setX1(value);
                    System.out.println("X3 is set to: " + value);
                    printConsole("X3 is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");





            }
        });
        // add listener to the store button of MAR
        btnStoreMAR.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();

                JTextField field = (JTextField) pnlMAR.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                    int value = StringUtil.binaryToDecimal(buffer.toString());
                    textFieldMAR.setText(String.valueOf(value));
                    registers.setMAR(value);
                    System.out.println("MAR is set to: " + value);
                    printConsole("MAR is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");





            }
        });
        // add listener to the store button of MBR
        btnStoreMBR.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();


                JTextField field = (JTextField) pnlMBR.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);

                    int value = StringUtil.binaryToDecimal(buffer.toString());
                    textFieldMBR.setText(String.valueOf(value));
                    registers.setMBR(value);
                    System.out.println("MBR is set to: " + value);
                    printConsole("MBR is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");




            }
        });
        // add listener to the store button of MSR
        btnStoreMSR.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();

                JTextField field = (JTextField) pnlMSR.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);

                    int value = StringUtil.binaryToDecimal(buffer.toString());
                    textFieldMSR.setText(String.valueOf(value));
                    registers.setMSR(value);
                    System.out.println("MSR is set to: " + value);
                    printConsole("MSR is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");





            }
        });
        // add listener to the store button of MFR
        btnStoreMFR.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();

                JTextField field = (JTextField) pnlMFR.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                    int value = StringUtil.binaryToDecimal(buffer.toString());
                    textFieldMFR.setText(String.valueOf(value));
                    registers.setMFR(value);
                    System.out.println("MFR is set to: " + value);
                    printConsole("MFR is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");



            }
        });
        // add listener to the store button of PC
        btnStorePC.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();

                JTextField field = (JTextField) pnlPC.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                    int value = StringUtil.binaryToDecimal(buffer.toString());
                    textFieldPC.setText(String.valueOf(value));
                    registers.setPC(value);
                    System.out.println("PC is set to: " + value);
                    printConsole("PC is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");




            }
        });
        // add listener to the store button of IR
        btnStoreIR.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();

                JTextField field = (JTextField) pnlIR.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                    int value = StringUtil.binaryToDecimal(buffer.toString());
                    textFieldIR.setText(String.valueOf(value));
                    registers.setIR(value);
                    System.out.println("IR is set to: " + value);
                    printConsole("IR is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");






            }
        });
        // add listener to the store button of CC
        btnStoreCC.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();

                JTextField field = (JTextField) pnlCC.getComponent(1);
                String fieldText = field.getText();
                if(check(fieldText)) {
                	buffer = buffer.append(fieldText);
                    int value = StringUtil.binaryToDecimal(buffer.toString());
                    textFieldCC.setText(String.valueOf(value));
                    registers.setCC(value);
                    System.out.println("CC is set to: " + value);
                    printConsole("CC is set to: " + value);
                } else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");





            }
        });      
        // add listener to the store button of FR0
        btnStoreFR0.addMouseListener(new MouseAdapter() {
        	 public void mousePressed(MouseEvent e) {
                 StringBuffer buffer = new StringBuffer();

                 JTextField field = (JTextField) pnlFR0.getComponent(1);
                 String fieldText = field.getText();
                 if(check(fieldText)) {
                	 buffer = buffer.append(fieldText);
                	 int value = StringUtil.binaryToDecimal(buffer.toString());
                	 registers.setFR0(value);
                	 textFieldFR0.setText(String.valueOf(registers.getConvertFRByNum(0)));
                 
                	 System.out.println("FR0 is set to: " + value);
                	 printConsole("FR0 is set to: " + value);
                 }else JOptionPane.showMessageDialog(null,
                         "Enter Valid Binary Values");
             }
        });
        
        // add listener to the store button of FR1
        btnStoreFR1.addMouseListener(new MouseAdapter() {
       	 public void mousePressed(MouseEvent e) {
             StringBuffer buffer = new StringBuffer();

             JTextField field = (JTextField) pnlFR1.getComponent(1);
             String fieldText = field.getText();
             if(check(fieldText)) {
            	 buffer = buffer.append(fieldText);
            	 int value = StringUtil.binaryToDecimal(buffer.toString());
            	 registers.setFR1(value);
            	 textFieldFR1.setText(String.valueOf(registers.getConvertFRByNum(0)));
             
            	 System.out.println("FR1 is set to: " + value);
            	 printConsole("FR1 is set to: " + value);
             }else JOptionPane.showMessageDialog(null,
                     "Enter Valid Binary Values");
         }
       });
        
        // add listener to the execute button of instruction
        btnExecute.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                StringBuffer buffer = new StringBuffer();


                JTextField inss = (JTextField) pnlIns.getComponent(1);
                buffer = buffer.append(inss.getText());
      
                if(check(buffer.toString())) {

                int value = StringUtil.binaryToDecimal(buffer.toString());
                 refreshRegistersPanel();

                mcu.storeIntoCache(registers.getPC(), value);
                registers.setMAR(registers.getPC());
                registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                registers.setIR(registers.getMBR());
                refreshRegistersPanel();
                String ins = registers.getBinaryStringIr();
                printConsole("PC: " + registers.getPC() + ", instruction: " + ins);
                runInstruction(ins, registers, mcu);

                refreshRegistersPanel();
                }else JOptionPane.showMessageDialog(null,
                        "Enter Valid Binary Values");
            }

        });
        this.btnRunSingleStep.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                registers.setMAR(registers.getPC());
                registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                registers.setIR(registers.getMBR());
                String ins = registers.getBinaryStringIr();
                printConsole("PC: " + registers.getPC() + ", instruction: " + ins);
                runInstruction(ins, registers, mcu);
            }
        });
        // add listener to the IPL button
        btnIPL.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                initCPU();
                mcu.loadProgram(Const.TB);
                if (enableFlag == 0) {
                    setEnableForPanel(pnlIns, true);
                    setEnableForPanel(pnlRegisters, true);
                    setEnableForPanel(pnlProgram1, true);
                    setEnableForPanel(pnlProgram2, true);
                    btnRunSingleStep.setEnabled(true);

                    enableFlag = 1;

                }

                registers.setPC(Const.BOOT_PROG_BASE);

                refreshRegistersPanel();
      
            }
        });



        btnLoad.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	String addressString = textFieldAddress.getText();
            	if(check(addressString)) {
            		int address = Integer.parseInt(addressString,2);
            		if (address > mcu.getCurrentMemorySize() - 1 || address < 0) {
            			JOptionPane.showMessageDialog(null,
            					"Memory between 0 and " + (mcu.getCurrentMemorySize() - 1) + "!");
            		} else {
            			int value = mcu.fetchFromMemory(address);
            			textFieldValue.setText(Integer.toBinaryString(value));
            		}
            	}
            	else JOptionPane.showMessageDialog(null,
    					"Enter Valid Binary String");
            }
        });

        btnStore.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

            	String addressString = textFieldAddress.getText();
            	String valueString = textFieldAddress.getText();
            	if(check(addressString) && check(valueString)) {
                int address = Integer.parseInt(textFieldAddress.getText(),2);
                int value = Integer.parseInt(textFieldValue.getText(),2);
                if (address > mcu.getCurrentMemorySize() - 1 || address < 0) {
                    JOptionPane.showMessageDialog(null,
                            "Memory between 0 and " + (mcu.getCurrentMemorySize() - 1) + "!");
                } else if (value > 0xffff || value < 0) {
                    JOptionPane.showMessageDialog(null, "Value between 0 and 65535!");
                } else {
                    mcu.storeIntoMemory(address, value);
                    textFieldAddress.setText("0");
                    textFieldValue.setText("0");
                    printConsole("store memory address " + address + " with value " + value);
                }
            	} else JOptionPane.showMessageDialog(null,
    					"Enter Valid Binary String");
            }
        });

        textFieldAddress.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent arg0) {
                textFieldAddress.selectAll();
            }

            @Override
            public void focusLost(FocusEvent arg0) {

            }
        });
        textFieldValue.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent arg0) {
                textFieldValue.selectAll();
            }

            @Override
            public void focusLost(FocusEvent arg0) {

            }
        });
        
        
        
        
        
        
        consoleKeyboard.addKeyListener(new KeyAdapter() { 
            public void keyReleased(KeyEvent e) {
                mcu.setKeyboardBuffer(consoleKeyboard.getText());
                System.out.println(mcu.getKeyboardBuffer());
               
            }
        });

        btnNums.addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent e) {
                if (prog1Step == 0) {
                    // read 20 numbers from the console keyboard
 
                    if (consoleKeyboard.getText() == null || consoleKeyboard.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Enter 20 numbers");

                    } else {
                        printConsole("your 20 numbers are: ");
                        mcu.loadProgram(Const.Pre);
                        mcu.loadProgram(Const.PG1_20);
                        registers.setPC(Const.PG_20_BASE);

                        do {

                            registers.setMAR(registers.getPC());
                            registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                            registers.setIR(registers.getMBR());
                            runInstruction(registers.getBinaryStringIr(), registers, mcu);

                        } while (registers.getPC() <= Const.PG_20_END && registers.getPC() >= Const.PG_20_BASE);
                        refreshRegistersPanel();
                        prog1Step = 1;
                    }
                }

            }
        });

        btnCompare.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (prog1Step == 1) {
                    mcu.loadProgram(Const.PG1_20);
                    registers.setPC(Const.PG_20_BASE);

                    do {

                        registers.setMAR(registers.getPC());
                        registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                        registers.setIR(registers.getMBR());
                        runInstruction(registers.getBinaryStringIr(), registers, mcu);

                    } while (registers.getPC() <= Const.PG_20_END && registers.getPC() >= Const.PG_20_BASE);

      
                    printConsole("The closest number is:");
                    mcu.loadProgram(Const.PG1_10);
                    registers.setPC(Const.PG_10BASE);

                    do {
                        registers.setMAR(registers.getPC());
                        registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                        registers.setIR(registers.getMBR());
                        runInstruction(registers.getBinaryStringIr(), registers, mcu);
                    } while (registers.getPC() <= Const.PG_10END && registers.getPC() >= Const.PG_10BASE);

                    System.out.println("print the result in m(30)");
                    mcu.loadProgram(Const.PG_P);
                    registers.setPC(Const.PG_P_BASE);
                    do {
                        registers.setMAR(registers.getPC());
                        registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                        registers.setIR(registers.getMBR());
                        runInstruction(registers.getBinaryStringIr(), registers, mcu);
                    } while (registers.getPC() <= Const.PG_P_END && registers.getPC() >= Const.PG_P_BASE);

                    refreshRegistersPanel();
                    prog1Step = 0;

                }
            }
        });
        
        // Program 1 - When the Load sentences button is pressed, all the sentences will be loaded into memory
        this.btnLoadSentences.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (prog2Step == 0) {
                    String sentences = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
                            + "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
                            + "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. "
                            + "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. "
                            + "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout."
                            + "he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.";
                    mcu.setCardBuffer(sentences);
                    System.out.println("start to read sentences");

                    mcu.loadProgram(Const.PRE_PROG2);
                    mcu.loadProgram(Const.PROG2_0);
                    registers.setPC(Const.PG2_0_BASE);
                    do {
                        registers.setMAR(registers.getPC());
                        registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                        registers.setIR(registers.getMBR());
                        runInstruction(registers.getBinaryStringIr(), registers, mcu);
                    } while (registers.getPC() <= Const.PG2_0_END && registers.getPC() >= Const.PG2_0_BASE);
                    printConsole("Enter a word in the console input and press the Find Word button. ");

                    refreshRegistersPanel();
                    prog2Step = 1;
                }
            }
        });

        // When Find Word button is pressed, all words in sentences are compared to check against the input word  
        this.btnFindWord.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (prog2Step == 1) {
                    
                    if (consoleKeyboard.getText() == null || consoleKeyboard.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "type a word in the console input");

                    } else {
                        // read the word
                        printConsole("input word: ");
                        mcu.loadProgram(Const.PROG2_1);
                        registers.setPC(Const.PG2_1_BASE);
                        do {
                            registers.setMAR(registers.getPC());
                            registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                            registers.setIR(registers.getMBR());
                            runInstruction(registers.getBinaryStringIr(), registers, mcu);
                        } while (registers.getPC() <= Const.PG2_1_END && registers.getPC() >= Const.PG2_1_BASE);
                        // find the word
                        printConsole("word number: ");
                        mcu.loadProgram(Const.PROG2_2);
                        registers.setPC(Const.PG2_2_BASE);
                        do {
                            registers.setMAR(registers.getPC());
                            registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                            registers.setIR(registers.getMBR());
                            runInstruction(registers.getBinaryStringIr(), registers, mcu);
                        } while (registers.getPC() <= Const.PG2_2_END && registers.getPC() >= Const.PG2_2_BASE);
                       

                        mcu.loadProgram(Const.PG_P1);
                        registers.setPC(Const.PG_P1_BASE);
                        do {
                            registers.setMAR(registers.getPC());
                            registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                            registers.setIR(registers.getMBR());
                            runInstruction(registers.getBinaryStringIr(), registers, mcu);
                        } while (registers.getPC() <= Const.PG_P1_END && registers.getPC() >= Const.PG_P1_BASE);
                      
                        printConsole("sentence number: ");
                        mcu.loadProgram(Const.PG_P2);
                        registers.setPC(Const.PG_P2_BASE);
                        do {
                            registers.setMAR(registers.getPC());
                            registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                            registers.setIR(registers.getMBR());
                            runInstruction(registers.getBinaryStringIr(), registers, mcu);
                        } while (registers.getPC() <= Const.PG_P2_END && registers.getPC() >= Const.PG_P2_BASE);

                        refreshRegistersPanel();
                        prog2Step = 0;
                    }
                }
            }
        });
        
        btnExample.addMouseListener(new MouseAdapter() {
            
        	public void mousePressed(MouseEvent e){
            	mcu.loadProgram(Const.Pre3);
            	mcu.loadProgram(Const.PG_3);
                 registers.setPC(Const.PG_3_BASE);
                do {
                    registers.setMAR(registers.getPC());
                    registers.setMBR(mcu.fetchFromCache(registers.getMAR()));
                    registers.setIR(registers.getMBR());
                    runInstruction(registers.getBinaryStringIr(), registers, mcu);
                } while (registers.getPC() <= Const.PG_3_END && registers.getPC() >= Const.PG_3_BASE);

                refreshRegistersPanel();
            }
        });

    }

    private void refreshCacheTable() {
        int row = 0;
        for (CacheLine line : mcu.getCache().getCacheLines()) {
            this.tableCache.setValueAt(line.getTag(), row, 0);
            this.tableCache.setValueAt(line.getData(), row, 1);
            row++;
        }

    }

    private void pushConsoleBuffer() {
        if (mcu.getPrinterBuffer() != null) {
            consolePrinter.append(mcu.getPrinterBuffer());
            mcu.setPrinterBuffer("");
        }
        if (mcu.getKeyboardBuffer() != null) {
            consoleKeyboard.setText(mcu.getKeyboardBuffer());
        }
    }

    /**
     * This method will read the value of every register and set the radio
     * buttons and text field according to the value of the register.
     */
    private void refreshRegistersPanel() {
        for (Component com : pnlRegisters.getComponents()) {
            if (com instanceof JPanel) {
                JPanel pnl = (JPanel) com;
                int regVal = 0;
                int bitLong = 0;
                String bitString = "";
                int i = 0;
                int j=0;
                for (Component comm : pnl.getComponents()) {

                    if (comm instanceof JLabel) {
                        JLabel lbl = (JLabel) comm;
                        regVal = registers.getRegistersByName(lbl.getText());
                        bitLong = registers.getBitLongByName(lbl.getText());
                        bitString = StringUtil.decimalToBinary(regVal, bitLong);
                        i = bitLong;
                    }


                    if (comm instanceof JTextField) {
                    	if(j==0) {
                    		JTextField txt = (JTextField) comm;
                    		txt.setText(Integer.toBinaryString(regVal));
                    		j+=1;
                    	}
                    	if(j==1) {
                        JTextField txt = (JTextField) comm;
                        txt.setText(Integer.toBinaryString(regVal));
                        j=0;
                    	}
                    }
                }
            }
        }
    }

    /**
     * 
     * set every component in the panel enabled/disabled according to the flag
     * 
     * @param panel
     * @param flag
     *            true: enable; false: disable
     * 
     */
    private void setEnableForPanel(JPanel panel, boolean flag) {
        for (Component com : panel.getComponents()) {
            if (com instanceof JPanel) {
                JPanel subPanel = (JPanel) com;
                this.setEnableForPanel(subPanel, flag);
            } else {
                com.setEnabled(flag);
            }
        }
    }

    /**
     * 
     * print a message in the console
     * 
     * @param message
     *            the message you want to print
     * 
     */
    private void printConsole(String message) {
        consolePrinter.append(message + "\n");
    }

    /**
     * 
     * run the instruction
     * 
     * @param instruction
     *            instruction in binary String, for example "0000000000000000".
     * @param registers
     * @param mcu
     * 
     */
    private void runInstruction(String instruction, Registers registers, MCU mcu) {

        // execute button event
        String opCode = instruction.substring(0, 6);
        try {
            if (Const.OPCODE.containsKey(opCode)) {

                @SuppressWarnings("deprecation")
				AbstractInstruction instr = (AbstractInstruction) Class
                        .forName("alu.instruction." + Const.OPCODE.get(opCode)).newInstance();
                instr.execute(instruction, registers, mcu);
                System.out.println("PC: " + registers.getPC() + ", instruction: " + instruction);
                // printConsole("instruction: " + instruction);
                refreshCacheTable();
                pushConsoleBuffer();

                String message = instr.getExecuteMessage();
                System.out.println(message);
                //
                // TODO do something with this message
                //

            } else {
                // we don't have that kind of instruction
                throw new MachineFaultException(Const.FaultCode.ILL_OPRC.getValue(),
                        Const.FaultCode.ILL_OPRC.getMessage());
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MachineFaultException t) {
            // handle the machine fault

            t.printStackTrace();
            handleMachineFault(t.getFaultCode(), t.getMessage());
        }
    }

    private void handleMachineFault(int faultCode, String message) {
        // when a machine fault occurs, we should save current values of PC and
        // MSR into reserved locations in memory.
        registers.setMAR(4);
        registers.setMBR(registers.getPC());
        mcu.storeIntoCache(registers.getMAR(), registers.getMBR());

        registers.setMAR(5);
        registers.setMBR(registers.getMSR());
        mcu.storeIntoCache(registers.getMAR(), registers.getMBR()); // location
                                                                    // 5 in
                                                                    // memory is
                                                                    // not used,
                                                                    // so we can
                                                                    // store MSR
                                                                    // for
                                                                    // machine
                                                                    // fault in
                                                                    // address 5

        registers.setMFR(faultCode);

        JOptionPane.showMessageDialog(null, message, "Fault Code: " + faultCode, JOptionPane.WARNING_MESSAGE);

        // now we should fetch from location 1 into the PC
        registers.setPC(mcu.fetchFromCache(1));

    }
}