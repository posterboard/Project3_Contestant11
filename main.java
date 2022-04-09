import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.text.DecimalFormat;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
//Note: Mezzanine spelled wrong multiple times.
class Main {
  static int orchCount=0;
  static int mezzazineCount=0;
  static int balconyCount=0;
  
  //for the ticket function
  static JLabel orchQuantityLbl = new JLabel("0");
  static JLabel mezzQuantityLbl = new JLabel("0");
  static JLabel balcQuantityLbl = new JLabel("0");
  
  static ArrayList<Purchase> listOfPurchase = new ArrayList<Purchase>();
  
  static DecimalFormat money = new DecimalFormat("0.00");
  static JTextField payedInput;
  static JLabel totalQuantityLbl;
  static JLabel orchestraQuantityLbl;
  static JLabel mezzazineQuantityLbl;
  static JLabel balconyQuantityLbl;
  static JLabel checkoutOrchPriceLbl;
  static JLabel checkoutMezzPriceLbl;
  static JLabel checkoutBalcPriceLbl;
  private static JPasswordField passwordInput;
  
  public static void main(String[] args) {
	  //launches main menu
	  
	  mainMenuF();
  }
  
 
  public static void mainMenuF() {
	  JFrame mainMenu = new JFrame();
	
		mainMenu.setSize(500,500);


		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.getContentPane().setLayout(new BorderLayout(0, 0));
	  mainMenu.getContentPane().setLayout(new BorderLayout(0, 0));
	  
	  JPanel north = new JPanel();
	  mainMenu.getContentPane().add(north, BorderLayout.NORTH);
	  
	  JLabel mainMenuLbl = new JLabel("Main Menu");
	  north.add(mainMenuLbl);
	  
	  JPanel center = new JPanel();
	  mainMenu.getContentPane().add(center, BorderLayout.CENTER);
	  
	  JButton managerBtn = new JButton("Manager");
	  managerBtn.addActionListener(e -> managerMenuF());
	  center.add(managerBtn);
	  
	  JButton checkoutBtn = new JButton("Checkout");
	  checkoutBtn.addActionListener(e -> checkoutMenuF());
	  center.add(checkoutBtn);
	  
	  JButton ticketsBtn = new JButton("Tickets");
	  ticketsBtn.addActionListener(e -> ticketMenuF());
	  center.add(ticketsBtn);
	  
	  mainMenu.setVisible(true);
  }
  
  //GUI code for ticket option
  public static void ticketMenuF() {
	  JFrame ticketMenu = new JFrame();
	  ticketMenu.setSize(500,500);
	  ticketMenu.getContentPane().setLayout(new BorderLayout(0, 0));
	  
	  JPanel north = new JPanel();
	  ticketMenu.getContentPane().add(north, BorderLayout.NORTH);
	  
	   JLabel ticketTitleLbl = new JLabel("Tickets");
	  north.add(ticketTitleLbl);
	  
	  JPanel center = new JPanel();
	  ticketMenu.getContentPane().add(center, BorderLayout.CENTER);
	  GridBagLayout gbl_center = new GridBagLayout();
	  gbl_center.columnWidths = new int[]{106, 110, 42, 0, 0, 0};
	  gbl_center.rowHeights = new int[]{14, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	  gbl_center.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	  gbl_center.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	  center.setLayout(gbl_center);
	  
	  JLabel quantityLbl = new JLabel("Quantity");
	  GridBagConstraints gbc_quantityLbl = new GridBagConstraints();
	  gbc_quantityLbl.anchor = GridBagConstraints.NORTHWEST;
	  gbc_quantityLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_quantityLbl.gridx = 2;
	  gbc_quantityLbl.gridy = 0;
	  center.add(quantityLbl, gbc_quantityLbl);
	  
	  JLabel orchestraLbl = new JLabel("Orchestra Ticket: $150");
	  GridBagConstraints gbc_orchestraLbl = new GridBagConstraints();
	  gbc_orchestraLbl.anchor = GridBagConstraints.NORTHWEST;
	  gbc_orchestraLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_orchestraLbl.gridx = 1;
	  gbc_orchestraLbl.gridy = 1;
	  center.add(orchestraLbl, gbc_orchestraLbl);
	  
	  
	  GridBagConstraints gbc_orchQuantityLbl = new GridBagConstraints();
	  gbc_orchQuantityLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_orchQuantityLbl.gridx = 2;
	  gbc_orchQuantityLbl.gridy = 1;
	  center.add(orchQuantityLbl, gbc_orchQuantityLbl);
	  
	  JButton orchIncreaseBtn = new JButton("+");
	  orchIncreaseBtn.setFont(new Font("Calibri", Font.PLAIN, 9));
	  GridBagConstraints gbc_OrchIncreaseBtn = new GridBagConstraints();
	  gbc_OrchIncreaseBtn.insets = new Insets(0, 0, 5, 5);
	  gbc_OrchIncreaseBtn.gridx = 3;
	  gbc_OrchIncreaseBtn.gridy = 1;
	  orchIncreaseBtn.addActionListener(e -> updateTicketValues(0,1));
	  center.add(orchIncreaseBtn, gbc_OrchIncreaseBtn);
	  
	  JButton orchDecreaseBtn = new JButton("-");
	  orchDecreaseBtn.setFont(new Font("Calibri", Font.PLAIN, 9));
	  GridBagConstraints gbc_orchDecreaseBtn = new GridBagConstraints();
	  gbc_orchDecreaseBtn.insets = new Insets(0, 0, 5, 0);
	  gbc_orchDecreaseBtn.gridx = 4;
	  gbc_orchDecreaseBtn.gridy = 1;
	  if(orchCount>=0) {
		  orchDecreaseBtn.addActionListener(e -> updateTicketValues(0,-1));
	  }
	  center.add(orchDecreaseBtn, gbc_orchDecreaseBtn);
	  
	  JLabel mezzanineLbl = new JLabel("MezzanineTicket: $125");
	  GridBagConstraints gbc_mezzanineLbl = new GridBagConstraints();
	  gbc_mezzanineLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_mezzanineLbl.gridx = 1;
	  gbc_mezzanineLbl.gridy = 2;
	  center.add(mezzanineLbl, gbc_mezzanineLbl);
	  
	  
	  GridBagConstraints gbc_mezzQuantityLbl = new GridBagConstraints();
	  gbc_mezzQuantityLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_mezzQuantityLbl.gridx = 2;
	  gbc_mezzQuantityLbl.gridy = 2;
	  center.add(mezzQuantityLbl, gbc_mezzQuantityLbl);
	  
	  JButton mezzIncreaseBtn = new JButton("+");
	  mezzIncreaseBtn.setFont(new Font("Calibri", Font.PLAIN, 9));
	  GridBagConstraints gbc_mezzIncreaseBtn = new GridBagConstraints();
	  gbc_mezzIncreaseBtn.insets = new Insets(0, 0, 5, 5);
	  gbc_mezzIncreaseBtn.gridx = 3;
	  gbc_mezzIncreaseBtn.gridy = 2;
	  mezzIncreaseBtn.addActionListener(e -> updateTicketValues(1,1));
	  center.add(mezzIncreaseBtn, gbc_mezzIncreaseBtn);
	  
	  JButton mezzDecreaseBtn = new JButton("-");
	  mezzDecreaseBtn.setFont(new Font("Calibri", Font.PLAIN, 9));
	  GridBagConstraints gbc_mezzDecreaseBtn = new GridBagConstraints();
	  gbc_mezzDecreaseBtn.insets = new Insets(0, 0, 5, 0);
	  gbc_mezzDecreaseBtn.gridx = 4;
	  gbc_mezzDecreaseBtn.gridy = 2;
	  if(mezzazineCount>=0) {
		  mezzDecreaseBtn.addActionListener(e -> updateTicketValues(1,-1));
	  }
	  center.add(mezzDecreaseBtn, gbc_mezzDecreaseBtn);
	  
	  JLabel BalconyLbl = new JLabel("Balcony Ticket: $75");
	  GridBagConstraints gbc_BalconyLbl = new GridBagConstraints();
	  gbc_BalconyLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_BalconyLbl.gridx = 1;
	  gbc_BalconyLbl.gridy = 3;
	  center.add(BalconyLbl, gbc_BalconyLbl);
	  
	  
	  GridBagConstraints gbc_balcQuantityLbl = new GridBagConstraints();
	  gbc_balcQuantityLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_balcQuantityLbl.gridx = 2;
	  gbc_balcQuantityLbl.gridy = 3;
	  
	  center.add(balcQuantityLbl, gbc_balcQuantityLbl);
	  
	  JButton balcIncreaseBtn = new JButton("+");
	  balcIncreaseBtn.setFont(new Font("Calibri", Font.PLAIN, 9));
	  GridBagConstraints gbc_balcIncreaseBtn = new GridBagConstraints();
	  gbc_balcIncreaseBtn.insets = new Insets(0, 0, 5, 5);
	  gbc_balcIncreaseBtn.gridx = 3;
	  gbc_balcIncreaseBtn.gridy = 3;
	  balcIncreaseBtn.addActionListener(e -> updateTicketValues(2,1));
	  center.add(balcIncreaseBtn, gbc_balcIncreaseBtn);
	  
	  JButton balcDecreaseBtn = new JButton("-");
	  balcDecreaseBtn.setFont(new Font("Calibri", Font.PLAIN, 9));
	  GridBagConstraints gbc_balcDecreaseBtn = new GridBagConstraints();
	  gbc_balcDecreaseBtn.insets = new Insets(0, 0, 5, 0);
	  gbc_balcDecreaseBtn.gridx = 4;
	  gbc_balcDecreaseBtn.gridy = 3;
	  if(balconyCount>=0) {
		  balcDecreaseBtn.addActionListener(e->updateTicketValues(2,-1));
	  }
	  center.add(balcDecreaseBtn, gbc_balcDecreaseBtn);
	  
	  JPanel panel = new JPanel();
	  ticketMenu.getContentPane().add(panel, BorderLayout.SOUTH);
	  
	  JButton backBtn = new JButton("Back");
	  panel.add(backBtn);
	  backBtn.addActionListener(e -> ticketMenu.dispose());
	 
	  
	  ticketMenu.setVisible(true);
  }
  
  //GUI code for checkout option
  public static void checkoutMenuF() {
	  JFrame checkoutMenu = new JFrame();
	  checkoutMenu.setSize(500,500);
	  checkoutMenu.getContentPane().setLayout(new BorderLayout(0, 0));
	  
	  JPanel center = new JPanel();
	  checkoutMenu.getContentPane().add(center, BorderLayout.CENTER);
	  GridBagLayout gbl_center = new GridBagLayout();
	  gbl_center.columnWidths = new int[]{120, 46, 0, 0, 0, 0};
	  gbl_center.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	  gbl_center.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	  gbl_center.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	  center.setLayout(gbl_center);
	  
	  orchestraQuantityLbl = new JLabel(Integer.toString(orchCount));
	  GridBagConstraints gbc_orchestraQuantityLbl = new GridBagConstraints();
	  gbc_orchestraQuantityLbl.anchor = GridBagConstraints.WEST;
	  gbc_orchestraQuantityLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_orchestraQuantityLbl.gridx = 2;
	  gbc_orchestraQuantityLbl.gridy = 1;
	  center.add(orchestraQuantityLbl, gbc_orchestraQuantityLbl);
	  
	  checkoutOrchPriceLbl = new JLabel("$"+orchCount*150);
	  GridBagConstraints gbc_checkoutOrchPriceLbl = new GridBagConstraints();
	  gbc_checkoutOrchPriceLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_checkoutOrchPriceLbl.gridx = 3;
	  gbc_checkoutOrchPriceLbl.gridy = 1;
	  center.add(checkoutOrchPriceLbl, gbc_checkoutOrchPriceLbl);
	  
	  JLabel mezzazineLbl = new JLabel("Mezzanine Quantity: ");
	  GridBagConstraints gbc_mezzazineLbl = new GridBagConstraints();
	  gbc_mezzazineLbl.anchor = GridBagConstraints.WEST;
	  gbc_mezzazineLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_mezzazineLbl.gridx = 1;
	  gbc_mezzazineLbl.gridy = 2;
	  center.add(mezzazineLbl, gbc_mezzazineLbl);
	  
	  JLabel orchestraLbl = new JLabel("Orchestra Quantity: ");
	  GridBagConstraints gbc_orchestraLbl = new GridBagConstraints();
	  gbc_orchestraLbl.anchor = GridBagConstraints.NORTHWEST;
	  gbc_orchestraLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_orchestraLbl.gridx = 1;
	  gbc_orchestraLbl.gridy = 1;
	  center.add(orchestraLbl, gbc_orchestraLbl);
	  
	  mezzazineQuantityLbl = new JLabel(Integer.toString(mezzazineCount));
	  GridBagConstraints gbc_mezzazineQuantityLbl = new GridBagConstraints();
	  gbc_mezzazineQuantityLbl.anchor = GridBagConstraints.WEST;
	  gbc_mezzazineQuantityLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_mezzazineQuantityLbl.gridx = 2;
	  gbc_mezzazineQuantityLbl.gridy = 2;
	  center.add(mezzazineQuantityLbl, gbc_mezzazineQuantityLbl);
	  
	  checkoutMezzPriceLbl = new JLabel("$"+mezzazineCount*125);
	  GridBagConstraints gbc_checkoutMezzPriceLbl = new GridBagConstraints();
	  gbc_checkoutMezzPriceLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_checkoutMezzPriceLbl.gridx = 3;
	  gbc_checkoutMezzPriceLbl.gridy = 2;
	  center.add(checkoutMezzPriceLbl, gbc_checkoutMezzPriceLbl);
	  
	  JLabel balconyLbl = new JLabel("Balcony Quantity: ");
	  GridBagConstraints gbc_balconyLbl = new GridBagConstraints();
	  gbc_balconyLbl.anchor = GridBagConstraints.WEST;
	  gbc_balconyLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_balconyLbl.gridx = 1;
	  gbc_balconyLbl.gridy = 3;
	  center.add(balconyLbl, gbc_balconyLbl);
	  
	  balconyQuantityLbl = new JLabel(Integer.toString(balconyCount));
	  GridBagConstraints gbc_balconyQuantityLbl = new GridBagConstraints();
	  gbc_balconyQuantityLbl.anchor = GridBagConstraints.WEST;
	  gbc_balconyQuantityLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_balconyQuantityLbl.gridx = 2;
	  gbc_balconyQuantityLbl.gridy = 3;
	  center.add(balconyQuantityLbl, gbc_balconyQuantityLbl);
	  
	  checkoutBalcPriceLbl = new JLabel("$"+balconyCount*75);
	  GridBagConstraints gbc_checkoutBalcPriceLbl = new GridBagConstraints();
	  gbc_checkoutBalcPriceLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_checkoutBalcPriceLbl.gridx = 3;
	  gbc_checkoutBalcPriceLbl.gridy = 3;
	  center.add(checkoutBalcPriceLbl, gbc_checkoutBalcPriceLbl);
	  
	  JLabel feeLbl = new JLabel("Processing Fee: ");
	  GridBagConstraints gbc_feeLbl = new GridBagConstraints();
	  gbc_feeLbl.anchor = GridBagConstraints.WEST;
	  gbc_feeLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_feeLbl.gridx = 1;
	  gbc_feeLbl.gridy = 4;
	  center.add(feeLbl, gbc_feeLbl);
	  
	  JLabel feeQuantityLbl = new JLabel("$10");
	  GridBagConstraints gbc_feeQuantityLbl = new GridBagConstraints();
	  gbc_feeQuantityLbl.anchor = GridBagConstraints.WEST;
	  gbc_feeQuantityLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_feeQuantityLbl.gridx = 2;
	  gbc_feeQuantityLbl.gridy = 4;
	  center.add(feeQuantityLbl, gbc_feeQuantityLbl);
	  
	  JLabel totalLbl = new JLabel("Total Due:");
	  GridBagConstraints gbc_totalLbl = new GridBagConstraints();
	  gbc_totalLbl.anchor = GridBagConstraints.WEST;
	  gbc_totalLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_totalLbl.gridx = 1;
	  gbc_totalLbl.gridy = 5;
	  center.add(totalLbl, gbc_totalLbl);
	  
	  totalQuantityLbl = new JLabel("$"+money.format(getCost()));
	  GridBagConstraints gbc_totalQuantityLbl = new GridBagConstraints();
	  gbc_totalQuantityLbl.anchor = GridBagConstraints.WEST;
	  gbc_totalQuantityLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_totalQuantityLbl.gridx = 2;
	  gbc_totalQuantityLbl.gridy = 5;
	  center.add(totalQuantityLbl, gbc_totalQuantityLbl);
	  
	  Component gap = Box.createVerticalStrut(20);
	  GridBagConstraints gbc_gap = new GridBagConstraints();
	  gbc_gap.insets = new Insets(0, 0, 5, 5);
	  gbc_gap.gridx = 1;
	  gbc_gap.gridy = 6;
	  center.add(gap, gbc_gap);
	  
	  JLabel paymentLbl = new JLabel("Amount Payed:");
	  GridBagConstraints gbc_paymentLbl = new GridBagConstraints();
	  gbc_paymentLbl.anchor = GridBagConstraints.WEST;
	  gbc_paymentLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_paymentLbl.gridx = 1;
	  gbc_paymentLbl.gridy = 7;
	  center.add(paymentLbl, gbc_paymentLbl);
	  
	  payedInput = new JTextField();
	  GridBagConstraints gbc_payedInput = new GridBagConstraints();
	  gbc_payedInput.insets = new Insets(0, 0, 5, 5);
	  gbc_payedInput.gridx = 2;
	  gbc_payedInput.gridy = 7;
	  center.add(payedInput, gbc_payedInput);
	  payedInput.setColumns(6);
	  
	  JLabel changeDisplay = new JLabel("");
	  GridBagConstraints gbc_changeDisplay = new GridBagConstraints();
	  gbc_changeDisplay.insets = new Insets(0, 0, 0, 5);
	  gbc_changeDisplay.gridx = 2;
	  gbc_changeDisplay.gridy = 8;
	  center.add(changeDisplay, gbc_changeDisplay);
	  
	  JPanel header = new JPanel();
	  checkoutMenu.getContentPane().add(header, BorderLayout.NORTH);
	  
	  JLabel checkoutTitleLbl = new JLabel("Checkout");
	  header.add(checkoutTitleLbl);
	  
	  JPanel footer = new JPanel();
	  checkoutMenu.getContentPane().add(footer, BorderLayout.SOUTH);
	  
	  JButton checkoutBackBtn = new JButton("Back");
	  checkoutBackBtn.addActionListener(e -> clearData(checkoutMenu));
	  footer.add(checkoutBackBtn);
	  
	  JButton payBtn = new JButton("Pay");
	  payBtn.addActionListener(e -> displayPay(getChange(getCost(),payedInput.getText())));
	  footer.add(payBtn);
	  checkoutMenu.setVisible(true);
  }
 
  //GUI code for manager option, uses "password" function to determine password and opens another GUI from there
  public static void managerMenuF() {
	  JFrame managerMenu = new JFrame();
	  managerMenu.setSize(525,400);
	  managerMenu.getContentPane().setLayout(new BorderLayout(0, 0));
	  
	  JPanel north = new JPanel();
	  managerMenu.getContentPane().add(north, BorderLayout.NORTH);
	  
	  JLabel managerTitleLbl = new JLabel("Manager");
	  north.add(managerTitleLbl);
	  
	  JPanel panel = new JPanel();
	  managerMenu.getContentPane().add(panel, BorderLayout.CENTER);
	  GridBagLayout gbl_panel = new GridBagLayout();
	  gbl_panel.columnWidths = new int[]{217, 0, 0, 0, 0, 0, 50, 0};
	  gbl_panel.rowHeights = new int[]{14, 0, 0, 0, 0};
	  gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
	  gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	  panel.setLayout(gbl_panel);
	  
	  JLabel passwordLbl = new JLabel("Password:");
	  GridBagConstraints gbc_passwordLbl = new GridBagConstraints();
	  gbc_passwordLbl.insets = new Insets(0, 0, 5, 5);
	  gbc_passwordLbl.anchor = GridBagConstraints.NORTH;
	  gbc_passwordLbl.gridx = 1;
	  gbc_passwordLbl.gridy = 0;
	  panel.add(passwordLbl, gbc_passwordLbl);
	  
	  passwordInput = new JPasswordField();
	  passwordInput.setColumns(5);
	  passwordInput.setHorizontalAlignment(SwingConstants.LEFT);
	  GridBagConstraints gbc_passwordInput = new GridBagConstraints();
	  gbc_passwordInput.insets = new Insets(0, 0, 5, 5);
	  gbc_passwordInput.gridx = 1;
	  gbc_passwordInput.gridy = 1;
	  panel.add(passwordInput, gbc_passwordInput);
	  
	  JButton managerSubmitBtn = new JButton("Submit");
	  GridBagConstraints gbc_managerSubmitBtn = new GridBagConstraints();
	  gbc_managerSubmitBtn.insets = new Insets(0, 0, 0, 5);
	  gbc_managerSubmitBtn.gridx = 1;
	  gbc_managerSubmitBtn.gridy = 3;
	  managerSubmitBtn.addActionListener(e -> password(passwordInput.getText()));
	  panel.add(managerSubmitBtn, gbc_managerSubmitBtn);
	  
	  
	  
	  
	  
	  managerMenu.setVisible(true);
  }
  
  
  
  //misc functions 
  public static void password(String passAttempt){
	
	  if(passAttempt.equals("7777")){
		  	
		  
		 int mCount=0;
		 int bCount = 0;
		 int oCount = 0;
		 double gross=0;
		 for(Purchase i: listOfPurchase) {
			 mCount+=i.getMezzanineCount();
			 bCount+=i.getBalconyCount();
			 oCount+=i.getOrchestraCount();
			 gross+=i.getSales();
		 }
		//compile data  
		  
		//create GUI to display information
		JFrame pass = new JFrame();
			 
			 
			 
		pass.setSize(500,500);
		pass.getContentPane().setLayout(new BorderLayout(0, 0));
			 
		JLabel lblNewLabel = new JLabel("Sale Statistics");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pass.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
			 
		JPanel center = new JPanel();
		pass.getContentPane().add(center, BorderLayout.CENTER);
		GridBagLayout gbl_center = new GridBagLayout();
		gbl_center.columnWidths = new int[]{199, 0, 86, 0};
		gbl_center.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0};
		gbl_center.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_center.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		center.setLayout(gbl_center);
			 
		JLabel managerGrossSaleLbl = new JLabel("Gross Sale:");
		managerGrossSaleLbl.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_managerGrossSaleLbl = new GridBagConstraints();
		gbc_managerGrossSaleLbl.insets = new Insets(0, 0, 5, 5);
		gbc_managerGrossSaleLbl.gridx = 0;
		gbc_managerGrossSaleLbl.gridy = 2;
		center.add(managerGrossSaleLbl, gbc_managerGrossSaleLbl);
			 
		JLabel managerGrossStatLbl = new JLabel("$"+money.format(gross));
		GridBagConstraints gbc_managerGrossStatLbl = new GridBagConstraints();
		gbc_managerGrossStatLbl.insets = new Insets(0, 0, 5, 5);
		gbc_managerGrossStatLbl.gridx = 1;
		gbc_managerGrossStatLbl.gridy = 2;
		center.add(managerGrossStatLbl, gbc_managerGrossStatLbl);
			 
		JLabel managerOrchLbl = new JLabel("Orchestra Tickets sold: ");
		managerOrchLbl.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_managerOrchLbl = new GridBagConstraints();
		gbc_managerOrchLbl.insets = new Insets(0, 0, 5, 5);
		gbc_managerOrchLbl.gridx = 0;
		gbc_managerOrchLbl.gridy = 3;
		center.add(managerOrchLbl, gbc_managerOrchLbl);
			 
		JLabel managerOrchStatLbl = new JLabel(Integer.toString(oCount));
		GridBagConstraints gbc_managerOrchStatLbl = new GridBagConstraints();
		gbc_managerOrchStatLbl.anchor = GridBagConstraints.EAST;
		gbc_managerOrchStatLbl.insets = new Insets(0, 0, 5, 5);
		gbc_managerOrchStatLbl.gridx = 1;
		gbc_managerOrchStatLbl.gridy = 3;
		center.add(managerOrchStatLbl, gbc_managerOrchStatLbl);
			 
		JLabel managerMezzLbl = new JLabel("Mezzanine Tickets sold: ");
		GridBagConstraints gbc_managerMezzLbl = new GridBagConstraints();
		gbc_managerMezzLbl.insets = new Insets(0, 0, 5, 5);
		gbc_managerMezzLbl.gridx = 0;
		gbc_managerMezzLbl.gridy = 4;
		center.add(managerMezzLbl, gbc_managerMezzLbl);
			 
		JLabel managerMezzStatLbl = new JLabel(Integer.toString(mCount));
		GridBagConstraints gbc_managerMezzStatLbl = new GridBagConstraints();
		gbc_managerMezzStatLbl.insets = new Insets(0, 0, 5, 5);
		gbc_managerMezzStatLbl.gridx = 1;
		gbc_managerMezzStatLbl.gridy = 4;
		center.add(managerMezzStatLbl, gbc_managerMezzStatLbl);
			 
		JLabel managerBalcLbl = new JLabel("Balcony Tickets Sold: ");
		GridBagConstraints gbc_managerBalcLbl = new GridBagConstraints();
		gbc_managerBalcLbl.insets = new Insets(0, 0, 0, 5);
		gbc_managerBalcLbl.gridx = 0;
		gbc_managerBalcLbl.gridy = 5;
		center.add(managerBalcLbl, gbc_managerBalcLbl);
			 
		JLabel managerBalconyStatLbl = new JLabel(Integer.toString(bCount));
		GridBagConstraints gbc_managerBalconyStatLbl = new GridBagConstraints();
		gbc_managerBalconyStatLbl.insets = new Insets(0, 0, 0, 5);
		gbc_managerBalconyStatLbl.gridx = 1;
		gbc_managerBalconyStatLbl.gridy = 5;
		center.add(managerBalconyStatLbl, gbc_managerBalconyStatLbl);
		pass.setVisible(true);
	  }else {
	    JFrame fail = new JFrame();
	    fail.setSize(200,200);  
	    	  	
	    JLabel noticeLbl = new JLabel("Incorrect Password.");
	    noticeLbl.setHorizontalAlignment(SwingConstants.CENTER);
	    fail.getContentPane().add(noticeLbl, BorderLayout.CENTER);
	    	 
	    fail.setVisible(true);
	    	
	    }
  }
  public static void updateTicketValues(int type, int increment) {
	  switch(type) {
	  case 0:
		  
		  orchCount+=increment;
		  
		  break;
	  case 1:
		  mezzazineCount+=increment;
		  break;
	  case 2:
		  balconyCount+=increment;
		  break;
	  default: 
		  break;
	  }
	  
	  if(orchCount<0) {
		  orchCount=0;
	  }
	  if(mezzazineCount<0) {
		  mezzazineCount = 0;
	  }
	  if(balconyCount<0) {
		  balconyCount=0;
	  }
	  orchQuantityLbl.setText( Integer.toString(orchCount));
	  mezzQuantityLbl.setText(Integer.toString(mezzazineCount));
	  balcQuantityLbl.setText(Integer.toString(balconyCount));
  }
  public static void displayPay(double amountOwed) {
	  JFrame changeMenu = new JFrame();
	  String outputMsg;
	 
	  changeMenu.setSize(400,200);
	  changeMenu.getContentPane().setLayout(new BorderLayout(0, 0));
	  
	  JLabel changeLbl = new JLabel("Change");
	  changeLbl.setHorizontalAlignment(SwingConstants.CENTER);
	  changeLbl.setVerticalAlignment(SwingConstants.TOP);
	  changeMenu.getContentPane().add(changeLbl, BorderLayout.NORTH);
	 
	  JLabel outputLbl = new JLabel("");
	  outputLbl.setHorizontalAlignment(SwingConstants.CENTER);
	  changeMenu.getContentPane().add(outputLbl, BorderLayout.CENTER);
//All will be cleared whether or not the bill has been payed. If the bill has been successfully payed, data will be stored..
//If not, then the data will just be erased  
	  if(amountOwed>=0) {
		  listOfPurchase.add(new Purchase(orchCount,mezzazineCount,balconyCount,getCost()));
		  outputMsg = "Purchase Complete. Amount owed: $"+money.format(amountOwed);
	  }else if(amountOwed==-1){
		  outputMsg ="Insufficent funds provided.";
	  }else {
		  outputMsg="Syntax error.";
	  }
	  outputLbl.setText(outputMsg);
	  changeMenu.setVisible(true);
	  orchCount = 0;
	  mezzazineCount= 0;
	  balconyCount = 0;
	  JButton exitBtn = new JButton("Exit");
	  exitBtn.addActionListener(e ->clearData(changeMenu));
	  changeMenu.getContentPane().add(exitBtn, BorderLayout.SOUTH);
	  
	 
	  
	  
	  
	  
  }
  public static double getCost() {
	  double price=(orchCount*120)+(mezzazineCount*125)+(balconyCount*75);
	  price+=10;//processing fee;
	  price*=100;
	  return price/100;
  }
  public static double getChange(double cost,String pricePaid) {
	  double pricePaidDouble=0;
	  if(isDouble(pricePaid)) {
		  pricePaidDouble = Double.parseDouble(pricePaid);
		  if(pricePaidDouble>=cost) {
			  return pricePaidDouble-cost;
		  }else {
			  return -1;
		  }
	  }else {
		  return -2;
	  }
  }
  public static void clearData(JFrame currentFrame) {
	  	  orchCount = 0;
	  mezzazineCount = 0;
	  balconyCount = 0;
	  currentFrame.dispose();
	  
	  //update labels in ticket gui
	  orchQuantityLbl.setText("0");
	  mezzQuantityLbl.setText("0");
	  balcQuantityLbl.setText("0");
	  totalQuantityLbl.setText("$10");
	  orchestraQuantityLbl.setText("0");
	  mezzazineQuantityLbl.setText("0");
	  balconyQuantityLbl.setText("0");
	  checkoutOrchPriceLbl.setText("$0");
	  checkoutMezzPriceLbl.setText("$0");
	  checkoutBalcPriceLbl.setText("$0");
  }
 
  // input validation using Scanner
  public static boolean isDouble(String in) {
	 Scanner reader = new Scanner(in);
	 if(reader.hasNextDouble()) {
		 return true;
	 }else {
		 return false;
	 }
 }
}
