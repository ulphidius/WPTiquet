package ovh.workparadise.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import ovh.workparadise.classedb.ConnectionDB;
import ovh.workparadise.classedb.HardwareCommand;
import ovh.workparadise.classedb.HardwareCommandList;
import ovh.workparadise.classedb.HardwareCommandListManager;
import ovh.workparadise.classedb.HardwareCommandManager;
import ovh.workparadise.classedb.MakeReservation;
import ovh.workparadise.classedb.MakeReservationManager;
import ovh.workparadise.classedb.Message;
import ovh.workparadise.classedb.MessageManager;
import ovh.workparadise.classedb.ReservationRoom;
import ovh.workparadise.classedb.ReservationRoomManager;
import ovh.workparadise.classedb.Room;
import ovh.workparadise.classedb.RoomManager;
import ovh.workparadise.classedb.ServiceCommand;
import ovh.workparadise.classedb.ServiceCommandList;
import ovh.workparadise.classedb.ServiceCommandListManager;
import ovh.workparadise.classedb.ServiceCommandManager;
import ovh.workparadise.classedb.Site;
import ovh.workparadise.classedb.SiteManager;
import ovh.workparadise.classedb.SubUser;
import ovh.workparadise.classedb.SubUserManager;
import ovh.workparadise.classedb.Subscription;
import ovh.workparadise.classedb.SubscriptionManager;
import ovh.workparadise.classedb.Ticket;
import ovh.workparadise.classedb.TicketManager;
import ovh.workparadise.classedb.TicketMessage;
import ovh.workparadise.classedb.TicketMessageManager;
import ovh.workparadise.classedb.User;
import ovh.workparadise.classedb.UserManager;

public class ProcessExport {
	private HSSFWorkbook wb = null;
	private HSSFSheet sheet = null;
	private HSSFRow row = null;
	private String filename;
	
	/**
	 * Envoie du nom du fichier pour la création.
	 * @param name
	 */
	public ProcessExport(String name) {
		this.filename = "Excel/" + name + ".xlsx";
		this.wb = new HSSFWorkbook();
		FileOutputStream fileOut;
		try {
		      fileOut = new FileOutputStream(this.filename);
		      wb.write(fileOut);
		      fileOut.close();
		    
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "L'ouverture du flux a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
		    e.printStackTrace();
		    
		}catch (IOException e) {
			JOptionPane.showMessageDialog(null, "La fermeture du flux a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		   
		}
	}
	
	/**
	 * Création du feuille Excel au sein du classeur.
	 * @param name
	 */
	public void createSheet(String name) {
		this.sheet = this.wb.createSheet(name);
	    FileOutputStream fileOut;
	    try {
	      fileOut = new FileOutputStream(this.filename);
	      	wb.write(fileOut);
	      fileOut.close();  
	    } catch (FileNotFoundException e) {
	    	JOptionPane.showMessageDialog(null, "L'ouverture du flux a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	JOptionPane.showMessageDialog(null, "La fermeture du flux a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
	    	e.printStackTrace();
	    }
	}	
	
	/**
	 * Génération d'une cellule numérique à partir d'une valeur, de ça position sur l'axe x et un boolean pour savoir si c'est une cellule titre. 
	 * @param value
	 * @param position
	 * @param form
	 */
	public void generateCellNum(float value, int position, boolean form) {
	    
	    HSSFCell cell = this.row.createCell((short)position);
	    HSSFCellStyle cellStyle = this.wb.createCellStyle();
		HSSFFont font = this.wb.createFont();
		
		font.setColor((short) 2);
		cellStyle.setFont(font);
	    cell.setCellValue(value);
		
	    if(form == true) {
			cell.setCellStyle(cellStyle);	
		}
		
	    FileOutputStream fileOut;
	    try {
	      fileOut = new FileOutputStream(filename);
	      wb.write(fileOut);
	      fileOut.close();  
	    } catch (FileNotFoundException e) {
	    	JOptionPane.showMessageDialog(null, "L'ouverture du flux a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	JOptionPane.showMessageDialog(null, "La fermeture du flux a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
	    	e.printStackTrace();
	    }
	}
	
	/**
	 * Génération d'une cellule textuel à partir d'une valeur, de ça position sur l'axe x et un boolean pour savoir si c'est une cellule titre. 
	 * @param value
	 * @param position
	 * @param form
	 */	
	public void generateCellString(String value, int position, boolean form) {
		
		HSSFCell cell = this.row.createCell((short)position);
		HSSFCellStyle cellStyle = this.wb.createCellStyle();
		HSSFFont font = this.wb.createFont();
		
		font.setColor((short) 2);
		cellStyle.setFont(font);
	    
		cell.setCellValue(new HSSFRichTextString(value));
		
		if(form == true) {
			cell.setCellStyle(cellStyle);	
		}
		
	    FileOutputStream fileOut;
	    try {
		      fileOut = new FileOutputStream(filename);
		      wb.write(fileOut);
		      fileOut.close();  
		    } catch (FileNotFoundException e) {
		    	JOptionPane.showMessageDialog(null, "L'ouverture du flux a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    } catch (IOException e) {
		    	JOptionPane.showMessageDialog(null, "La fermeture du flux a échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    }
	}
	
	/**
	 * Exportation de User prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportUser(String name, ConnectionDB db) {
		UserManager user = new UserManager();
		ArrayList<User> list = user.loadAllUser(db);
		ArrayList<String> listName = this.textUser();
		
		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {    
		    this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).getId(), 0, false);
			this.generateCellString(list.get(i).getFirstname(), 1, false);
			this.generateCellString(list.get(i).getLastname(), 2, false);
			this.generateCellString(list.get(i).getEmail(), 3, false);
			this.generateCellString(list.get(i).getPhoneN(), 4, false);
			this.generateCellString(list.get(i).getPwd(), 5, false);
			this.generateCellString(list.get(i).getSecret(), 6, false);
			this.generateCellString(this.checkBoolean(list.get(i).getStatus()), 7, false);
			this.generateCellString(this.checkBoolean(list.get(i).getAdmin()), 8, false);
		}
	
	}
	
	/**
	 * Exportation de SubUser prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */	
	public void exportSubUser(String name, ConnectionDB db) {
		SubUserManager user = new SubUserManager();
		ArrayList<SubUser> list = user.loadAllUser(db);
		ArrayList<String> listName = this.textSubUser();
		
		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {    
		    this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).get_idUser(), 0, false);
			this.generateCellNum(list.get(i).get_idSub(), 1, false);
			this.generateCellString(this.checkBoolean(list.get(i).get_engaged()), 2, false);
			this.generateCellString(list.get(i).get_dateStart().toString(), 3, false);
			this.generateCellString(list.get(i).get_dateEnd().toString(), 4, false);
		}
	}
	
	/**
	 * Exportation de Suscription prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportSubscription(String name, ConnectionDB db) {
		SubscriptionManager manager = new SubscriptionManager();
		ArrayList<Subscription> list = manager.loadAllUser(db);
		ArrayList<String> listName = this.textSubscription();
		
		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {    
		    this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).get_id(), 0, false);
			this.generateCellString(list.get(i).get_name(), 1, false);
			this.generateCellString(list.get(i).get_description(), 2, false);
			this.generateCellNum(list.get(i).get_hourRate(), 3, false);
			this.generateCellNum(list.get(i).get_dayRate(), 4, false);
			this.generateCellNum(list.get(i).get_studentRate(), 5, false);
			this.generateCellNum(list.get(i).get_engagementRate(), 6, false);
			this.generateCellNum(list.get(i).get_notEngagementRate(), 7, false);
			this.generateCellNum(list.get(i).get_engagementTime(), 8, false);
		}		
		
	}
	
	/**
	 * Exportation de Site prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportSite(String name, ConnectionDB db) {
		SiteManager site = new SiteManager();
		ArrayList<Site> list = site.loadAllUser(db);
		ArrayList<String> listName = this.textSite();

		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {
			this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).get_id(), 0, false);
			this.generateCellString(list.get(i).get_name(), 1, false);
			this.generateCellString(list.get(i).get_address(), 2, false);
			this.generateCellString(list.get(i).get_openHourWeek().toString(), 3, false);
			this.generateCellString(list.get(i).get_endHourWeek().toString(), 4, false);
			this.generateCellString(list.get(i).get_openHourFriday().toString(), 5, false);
			this.generateCellString(list.get(i).get_openHourWeekend().toString(), 6, false);
			this.generateCellString(list.get(i).get_endHourWeekend().toString(), 7, false);
		}
	}
	
	/**
	 * Exportation de ServiceCommandList prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportServiceCommandList(String name, ConnectionDB db) {
		ServiceCommandListManager service = new ServiceCommandListManager();
		ArrayList<ServiceCommandList> list = service.loadAllUser(db);
		ArrayList<String> listName = this.textServiceCommandList();

		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {
			this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).getId(), 0, false);
			this.generateCellNum(list.get(i).getIdService(), 1, false);
			this.generateCellNum(list.get(i).getQuantity(), 2, false);
		}
	}
	
	/**
	 * Exportation de ServiceCommand prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportServiceCommand(String name, ConnectionDB db) {
		ServiceCommandManager service = new ServiceCommandManager();
		ArrayList<ServiceCommand> list = service.loadAllUser(db);
		ArrayList<String> listName = this.textServiceCommand();

		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {
			this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).getId(), 0, false);
			this.generateCellString(list.get(i).getServiceType(), 1, false);
			this.generateCellString(list.get(i).getInformation(), 2, false);
			this.generateCellNum(list.get(i).getPrice(), 3, false);
			this.generateCellNum(list.get(i).getQuantity(), 4, false);
			this.generateCellNum(list.get(i).getSite(), 5, false);
		}
	}
	
	/**
	 * Exportation de Room prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportRoom(String name, ConnectionDB db) {
		RoomManager room = new RoomManager();
		ArrayList<Room> list = room.loadAllUser(db);
		ArrayList<String> listName = this.textRoom();
	
		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {
			this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).getId(), 0, false);
			this.generateCellNum(list.get(i).getSite(), 1, false);
			this.generateCellString(list.get(i).getType(), 2, false);
			this.generateCellString(list.get(i).getDescription(), 3, false);
			this.generateCellNum(list.get(i).getRoomNumber(), 4, false);
			this.generateCellString(list.get(i).getRoomStatus(), 5, false);
		}
	}
	
	/**
	 * Exportation de ReservationRoom prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportReservationRoom(String name, ConnectionDB db) {
		ReservationRoomManager reservationRoom = new ReservationRoomManager();
		ArrayList<ReservationRoom> list = reservationRoom.loadAllUser(db);
		ArrayList<String> listName = this.textReservationRoom();
		
		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {
			this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).getId(), 0, false);
			this.generateCellNum(list.get(i).getIdRoom(), 1, false);
			this.generateCellString(list.get(i).getDateR().toString(), 2, false);
			this.generateCellString(list.get(i).getDateStart().toString(), 3, false);
			this.generateCellString(list.get(i).getDateEnd().toString(), 4, false);
			this.generateCellString(list.get(i).getOriginalState(), 5, false);
			this.generateCellString(list.get(i).getAfterState(), 6, false);
		}
	}
	
	/**
	 * Exportation de Message prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportMessage(String name, ConnectionDB db) {
		MessageManager message = new MessageManager();
		ArrayList<Message> list = message.loadAllUser(db);
		ArrayList<String> listName = this.textMessage();
		
		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {
			this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).getId(), 0, false);
			this.generateCellString(list.get(i).getEmail(), 1, false);
			this.generateCellString(list.get(i).getMessage(), 2, false);
		}
	}
	
	/**
	 * Exportation de MakeReservation prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportMakeReservation(String name, ConnectionDB db) {
		MakeReservationManager makeReservation = new MakeReservationManager();
		ArrayList<MakeReservation> list = makeReservation.loadAllUser(db);
		ArrayList<String> listName = this.textMakeReservation();
		
		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {
			this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).getIdUser(), 0, false);
			this.generateCellNum(list.get(i).getIdReservation(), 1, false);
			this.generateCellString(list.get(i).getStatus(), 2, false);
		}
	}
	
	/**
	 * Exportation de HardwareCommandList prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportHardwareCommandList(String name, ConnectionDB db) {
		HardwareCommandListManager hardware = new HardwareCommandListManager();
		ArrayList<HardwareCommandList> list = hardware.loadAllUser(db);
		ArrayList<String> listName = this.textHardwareCommandList();
		
		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {
			this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).getId(), 0, false);
			this.generateCellNum(list.get(i).getIdReservation(), 1, false);
			this.generateCellNum(list.get(i).getIdHardware(), 2, false);
			this.generateCellString(list.get(i).getOriginalState(), 3, false);
			this.generateCellString(list.get(i).getAfterState(), 4, false);
		}
	}
	
	/**
	 * Exportation de HardwareCommand prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportHardwareCommand(String name, ConnectionDB db) {
		HardwareCommandManager harware = new HardwareCommandManager();
		ArrayList<HardwareCommand> list = harware.loadAllUser(db);
		ArrayList<String> listName = this.textHardwareCommand();
		
		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listName);
		
		for(int i = 0; i < list.size(); i++) {
			this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).getId(), 0, false);
			this.generateCellString(list.get(i).getMatricule(), 1, false);
			this.generateCellString(list.get(i).getHardwareType(), 2, false);
			this.generateCellString(list.get(i).getInformation(), 3, false);
			this.generateCellString(list.get(i).getStatus(), 4, false);
			this.generateCellNum(list.get(i).getPrice(), 5, false);
			this.generateCellNum(list.get(i).getSite(), 6, false);
		}
	}
	
	/**
	 * Exportation de Ticket prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportTicket(String name, ConnectionDB db) {
		TicketManager ticket = new TicketManager();
		ArrayList<Ticket> list = ticket.loadAll(db);
		ArrayList<String> listname = this.textTicket();
		
		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listname);
		
		for(int i = 0; i < list.size(); i++) {
			this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).getId(), 0, false);
			this.generateCellNum(list.get(i).getIdUser(), 1, false);
			this.generateCellString(list.get(i).getCategorie(), 2, false);
			this.generateCellString(list.get(i).getSubject(), 3, false);
			this.generateCellString(this.checkBoolean(list.get(i).getStatus()), 4, false);
		}
	}
	
	/**
	 * Exportation de TicketMessage prend entrée le nom de la feuille et la connection à la base de donnée
	 * @param name
	 * @param db
	 */
	public void exportTicketMessage(String name, ConnectionDB db) {
		TicketMessageManager ticket = new TicketMessageManager();
		ArrayList<TicketMessage> list = ticket.loadAll(db);
		ArrayList<String> listname = this.textTicketMessage();
		
		this.createSheet(name);
		this.row = this.sheet.createRow(0);
		this.setHeader(listname);
		
		for(int i = 0; i < list.size(); i++) {
			this.row = sheet.createRow(i + 1);
			this.generateCellNum(list.get(i).getId(), 0, false);
			this.generateCellNum(list.get(i).getIdTicket(), 1, false);
			this.generateCellString(list.get(i).getContent(), 2, false);
			if(list.get(i).getDateSend() != null) {
				this.generateCellString(list.get(i).getDateSend().substring(0, list.get(i).getDateSend().length()-2), 3, false);	
			}
			
			this.generateCellString(this.checkBoolean(list.get(i).getType()), 4, false);
		}
		
		
	}
	
	/**
	 * Exportation de l'intégralité de la base de donnée prend en entrée la connexion à la base de donnée 
	 * @param db
	 */
	public void exportExcel(ConnectionDB db) {
		this.exportUser("User", db);
		this.exportSubUser("Sub User", db);
		this.exportSubscription("Subscription", db);
		this.exportSite("Site", db);
		this.exportServiceCommand("Service Command", db);
		this.exportServiceCommandList("Service Command List", db);
		this.exportRoom("Room", db);
		this.exportReservationRoom("Reservation Room", db);
		this.exportMakeReservation("Make a Reservation", db);
		this.exportHardwareCommand("Hardware Command", db);
		this.exportHardwareCommandList("Hardware Command List", db);
		this.exportMessage("Message", db);
		this.exportTicket("Ticket", db);
		this.exportTicketMessage("TicketMessage", db);
		
	}
	
	/**
	 * Exportation des Tiquets prend en entrée la connexion à la base de donnée 
	 * @param db
	 */
	public void exportExcelTicket(ConnectionDB db) {
		this.exportTicket("Ticket", db);
		this.exportTicketMessage("TicketMessage", db);
		
	}
	
	/**
	 * Transformation d'un boolean en String, prend en entrée le booelan à vérifier
	 * @param target
	 * @return
	 */
	private String checkBoolean(Boolean target) {
		if(target == true) {
			return "true";
		}else{
			return "false";
		}
	}
	
	/**
	 * Génération d'une ligne de nom de colonnes, prend en entrée une liste avec les noms 
	 * @param list
	 */
	private void setHeader(ArrayList<String> list) {
		for(int i = 0; i < list.size(); i++) {
			this.generateCellString(list.get(i), i, true);
		}
	}
	
	// Fonctions de donnée en dure pour les noms des colonnes
	private ArrayList<String> textUser(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Id");
		list.add("Firstname");
		list.add("Lastname");
		list.add("Email");
		list.add("Phone number");
		list.add("Password");
		list.add("Secret");
		list.add("Status");
		list.add("Admin");
		return list;
	}
	
	private ArrayList<String> textSubUser(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("IdUser");
		list.add("IdSub");
		list.add("Engaged");
		list.add("DateStart");
		list.add("DateEnd");
		return list;
	}
	
	private ArrayList<String> textSubscription(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Id");
		list.add("Name");
		list.add("Description");
		list.add("Hour Rate");
		list.add("Day Rate");
		list.add("Student Rate");
		list.add("Engagement Rate");
		list.add("Not Engagement Rate");
		list.add("Engagement Time");
		return list;
		
	}
	
	private ArrayList<String> textSite(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Id");
		list.add("Name");
		list.add("Address");
		list.add("Open Hour On Week");
		list.add("Closing Hour On Week");
		list.add("Open Hour on Friday");
		list.add("Open Hour On Weekend");
		list.add("Closing Hour On Weekend");
		return list;
	}
	
	private ArrayList<String> textServiceCommandList(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Id");
		list.add("Id Service");
		list.add("Quantity");
		return list;
	}
	
	private ArrayList<String> textServiceCommand(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Id");
		list.add("Service Type");
		list.add("Information");
		list.add("Price");
		list.add("Quantity");
		list.add("Site");
		return list;
	}
	
	private ArrayList<String> textRoom(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Id");
		list.add("Site");
		list.add("Type");
		list.add("Description");
		list.add("Room Number");
		list.add("Room Status");
		return list;
	}
	
	private ArrayList<String> textReservationRoom(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Id");
		list.add("Id Room");
		list.add("Date Reservation");
		list.add("Date Start");
		list.add("Date End");
		list.add("Original State");
		list.add("After State");
		return list;
	}
	
	private ArrayList<String> textMessage(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Id");
		list.add("Email");
		list.add("Message");
		return list;
	}
	
	private ArrayList<String> textMakeReservation(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Id");
		list.add("Id Reservation");
		list.add("Status");
		return list;
	}
	
	private ArrayList<String> textHardwareCommandList(){
		ArrayList<String> list= new ArrayList<String>();
		list.add("Id");
		list.add("Id Reservation");
		list.add("Id Hardware");
		list.add("Original State");
		list.add("After State");
		return list;
	}
	
	private ArrayList<String> textHardwareCommand(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("Id");
		list.add("Matricule");
		list.add("Hardware Type");
		list.add("Information");
		list.add("Status");
		list.add("Price");
		list.add("Site");
		return list;
	}
	
	private ArrayList<String> textTicket(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("id");
		list.add("idUser");
		list.add("categorie");
		list.add("subject");
		list.add("status");
		return list;
	}
	
	private ArrayList<String> textTicketMessage(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("id");
		list.add("idTicket");
		list.add("content");
		list.add("dataSend");
		list.add("type");
		return list;
	}
}
