import java.util.*;
class courseWork{
	
	private static Scanner input = new Scanner(System.in);
	private static String[][] credentials = new String[1][2];  // to store credentials
	private static String[][] suppliersArray = new String[0][2]; // to store suppliers
	private static String[] itemCategory = new String[0];  // to store item categories
	private static String[][] items = new String[0][6];  // to store items 
	
	public static void storedCredentials(){
			
			credentials[0][0] = "lahirum";
			credentials[0][1] = "12345";
			
	}
	
	public static void loginPage(){
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                            LOGIN PAGE                              |");
		System.out.println("+--------------------------------------------------------------------+");
		
		L1:
		for (int i = 0; i < 5; i++){ 
			System.out.print("\nUser Name : ");
			String name = input.next();
			L2:
			for (int j = 0; j < credentials.length; j++){   // to check user name
				if(name.equals(credentials[j][0])){
					L3:
					for (int k = 0; k < 3; k++){   // to check password
					System.out.print("\nPassword  : ");
					String password = input.next();
						if (password.equals(credentials[j][1]))	{
							clearConsole();
							homePage();
							return;
						}else{
							if(k==2){	// to terminate the program if the no of attempts to enter the password is over
								System.out.println("Your attempt to enter the password is over. please try again shortly!");
								return;
								}
							System.out.println("password is incorrect. please try again!");
						}
					}
				}
			}
		if(i==4){break L1;} // to terminate the program if the no of attempts to enter the user name is over
		System.out.println("user name invalid. please try again!");			
		}
		System.out.println("Your attempt to enter the user name is over. please try again shortly!");
		return;
	}
	
	public static void clearConsole(){ // to clear the console
		
		try{
			System.out.print("\033\143");
		}catch(final Exception e){
			System.err.println(e.getMessage());
		}
		
	}
	
	public static void homePage(){  // home page
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|              WELCOME TO IJSE STOCK MANAGEMENT SYSTEM               |");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("\n[1] Change the Credentials\t[2] Supplier Manage\n[3] Stock Manage\t\t[4] Log out\n[5] Exit the system");
		
		System.out.print("\nEnter an option to continue > ");
		int hpinput=input.nextInt();
		
		clearConsole();
		switch(hpinput){
			case 1: credentialManage(); break;
			case 2:	supplierManage(); break;
			case 3: stockManage(); break;
			case 4: loginPage(); break;
			case 5: return;
			default:{
			System.out.print("Invalid selection! Enter any key to exit ");
			String in=input.next();
			return;
			}
		}
	}
	
	
	public static void credentialManage(){ // to change credentials 
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                         CREDENTIAL MANAGE                          |");
		System.out.println("+--------------------------------------------------------------------+");
		
		L1:
		for (int i = 0; i < 3; i++){  // to check user name 
			
			System.out.print("\nPlease enter the user name to verify it's you:  ");
			String userName=input.next();
	
			if(userName.equals(credentials[0][0])){
			System.out.println("Hey "+credentials[0][0]);
				
				L2:
				for (int j = 0; j < 3; j++){  // to check password
					
					System.out.print("Enter your current password: ");
					String password=input.next();
			
					if (password.equals(credentials[0][1])){
					System.out.print("Enter your new password: ");
					String newPassword=input.next();
					credentials[0][1]=newPassword;
					System.out.print("\nPassword changed successfully! Do you want to go to home page (Y/N): ");
					char response=input.next().charAt(0);
				
						if((response=='y')||(response=='Y')){clearConsole(); homePage();return;}
						else if((response=='n')||(response=='N')){clearConsole(); return;}
						else{System.out.println("Invalid selection!"); clearConsole(); return;}
					}else{
						if(j==2){System.out.println("Your attempt to enter the password is over. please try again shortly!");return;}
						System.out.println("Incorrect password. try again!\n");
					}
				}
			
			}else{
				if(i==2){
				System.out.println("Your attempt to enter the user name is over. please try again shortly!");
				System.out.print("Enter any key to continue ");
				String in=input.next();
				clearConsole();
				return;
				}
			System.out.println("Invalid user name. try again!");
			}
		}
	}
	
	
	public static void supplierManage(){  // supplier manage page
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                           SUPPLIER MANAGE                          |");
		System.out.println("+--------------------------------------------------------------------+");

		System.out.println("\n[1] Add Supplier\t[2] Update Supplier\n[3] Delete Supplier\t[4] View Suppliers\n[5] Search Supplier\t[6] Home Page");
		System.out.print("\nEnter an option to continue > ");
		int sminput=input.nextInt();
		
		clearConsole();
		switch(sminput){
			case 1: addSupplier(); break;
			case 2:	updateSupplier(); break;
			case 3: deleteSupplier(); break;
			case 4: viewSuppliers(); break;
			case 5: searchSupplier(); break;
			case 6: homePage(); break;
			default:{
			System.out.print("Invalid selection! Enter any key to continue ");
			String in=input.next();
			clearConsole();
			supplierManage();
			}
		}
	}
	
	public static void addSupplier(){
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                            ADD SUPPLIER                            |");
		System.out.println("+--------------------------------------------------------------------+");
	
		boolean flag = true;
		int count = 0;
		String sID = "";
		L1:
		while (flag){
		System.out.print("\nSupplier ID\t: ");
		sID = input.next();
			L2:
			for (int i = 0; i <suppliersArray.length; i++){
				if(sID.equals(suppliersArray[i][0])){
					System.out.println("already exists. try another supplier! ");
					count++;
					if(count==5){
						System.out.println("Reached the limit of attempts. try again shortly!");
						System.out.print("Enter any key to continue ");
						String in=input.next();
						clearConsole(); supplierManage(); return;}
					continue L1;
				}
			}flag=false;
		}
		count=0;
		System.out.print("Supplier Name\t: ");
		String sName = input.next();
		editSupplierArray(sID,sName);
		System.out.print("added successfully! Do you want to add another supplier(Y/N)? ");
		char response=input.next().charAt(0);
		
			if((response=='y')||(response=='Y')){clearConsole(); addSupplier();return;}
			else if((response=='n')||(response=='N')){clearConsole();supplierManage();return;}
			else{System.out.println("Invalid selection! Enter any key to continue ");
						clearConsole();
						String entry=input.next();
						homePage();return;
			}
	}
	
	public static void editSupplierArray(String sID, String sName){  // to assign new supplier to length increased supplier array
		suppliersArray = growSupAr();
		suppliersArray[suppliersArray.length-1][0]=sID;
		suppliersArray[suppliersArray.length-1][1]=sName;
	}
	
	public static String[][] growSupAr(){  // to increase the lenght of suppliersArray
			String[][] temp = new String[suppliersArray.length+1][2];
			for (int i = 0; i < suppliersArray.length; i++){
				temp[i][0]=suppliersArray[i][0];
				temp[i][1]=suppliersArray[i][1];
			}
			return temp;
	}
	
	public static void updateSupplier(){
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                         UPDATE SUPPLIER                            |");
		System.out.println("+--------------------------------------------------------------------+");

		boolean flag=true;
		int count=0;
		L1:
		while (flag){
			System.out.print("\nSupplier ID\t: ");
			String id=input.next();
			
			L2:
			for (int i = 0; i < suppliersArray.length; i++){
				if(id.equals(suppliersArray[i][0])){
					count=0;
					System.out.println("Supplier Name\t: "+suppliersArray[i][1]);
					System.out.print("\nEnter the new supplier name: ");
					suppliersArray[i][1]=input.next();
					System.out.print("Updated Successfully! Do you want to update another supplier?(Y/N) ");
					char response=input.next().charAt(0);
				
					if((response=='y')||(response=='Y')){clearConsole(); updateSupplier();return;}
					else if((response=='n')||(response=='N')){clearConsole();supplierManage();return;}
					else{System.out.println("Invalid selection! Enter any key to continue ");
						String entry=input.next();
						clearConsole();
						homePage();return;
					}
				}
			}
			count++;
			System.out.println("can't find supplier id. try again! ");
			if(count==5){
				System.out.println("Reached the limit of attempts. try again shortly!");
				System.out.print("Enter any key to continue ");
				String in=input.next();
				clearConsole(); supplierManage(); return;
			}
		}
	}
	
	public static void deleteSupplier(){
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                         DELETE SUPPLIER                            |");
		System.out.println("+--------------------------------------------------------------------+");
		
		boolean flag=true;
		int count=0;
		
		L1:
		while (flag){
			System.out.print("\nSupplier ID\t: ");
			String id=input.next();
			
			L2:
			for (int i = 0; i < suppliersArray.length; i++){
				if(id.equals(suppliersArray[i][0])){
					count=0;
					deleteFromAr(id);
					System.out.print("deleted successfully! Do you want to delete another?(Y/N) ");
					char response=input.next().charAt(0);
				
					if((response=='y')||(response=='Y')){clearConsole(); deleteSupplier();return;}
					else if((response=='n')||(response=='N')){ clearConsole(); supplierManage();return;}
					else{
						System.out.println("Invalid selection! Enter any key to continue ");
						String entry=input.next();
						clearConsole();
						homePage();return;
					}
				}
			}
			count++;
			System.out.println("can't find supplier id. try again!");
			if(count==5){
				System.out.println("Reached the limit of attempts. try again shortly!");
				System.out.print("Enter any key to continue ");
				String in=input.next();
				clearConsole();
				supplierManage();
				return;
			}
			continue L1;
		}
	}
	
	public static void deleteFromAr(String id){  // to assign length decresed array to the suppliersArray
		
		suppliersArray = decrementAr(id);
		
	}
	
	public static String[][] decrementAr(String id){  // to decrese the length of the suppliersArray
		
		String[][] temp = new String[suppliersArray.length-1][2];
		
		int j=0;
		L1:
		for (int i = 0; i < suppliersArray.length; i++){
			if(id.equals(suppliersArray[i][0])){
				continue L1;
			}
			temp[j][0]=suppliersArray[i][0];
			temp[j][1]=suppliersArray[i][1];
			j++;
		}
	
		return temp;
	}
	
	public static void viewSuppliers(){
		
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                           VIEW SUPPLIER                            |");
		System.out.println("+--------------------------------------------------------------------+");
	    
	    System.out.println();
		System.out.println("+----------------------+----------------------+");
		System.out.println("|      SUPPLIER ID     |     SUPPLIER NAME    |");
		System.out.println("+----------------------+----------------------+");
		
		for (int i = 0; i < suppliersArray.length; i++){

			System.out.printf("|        %-6s        |    %-14s    |%n",suppliersArray[i][0],suppliersArray[i][1]);
		}
		System.out.println("+----------------------+----------------------+");
		System.out.print("Do you want to go to supplier manage page(Y/N)? ");
		char response=input.next().charAt(0);
		 
			if((response=='y')||(response=='Y')){clearConsole(); supplierManage();return;}
			else if((response=='n')||(response=='N')){ clearConsole(); System.exit(0);return;}
		    else{
				System.out.println("Invalid selection! Enter any key to continue ");
				String entry=input.next();
				clearConsole();
				homePage();return;
			}
			
	}
	
	public static void searchSupplier(){
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                         SEARCH SUPPLIER                            |");
		System.out.println("+--------------------------------------------------------------------+");

		boolean flag=true;
		int count=0;
		
		while(flag){
			System.out.print("\nSupplier ID\t: ");
			String id=input.next();
		
			for (int i = 0; i < suppliersArray.length; i++){
				if(id.equals(suppliersArray[i][0])){
					count=0;
					System.out.println("Supplier Name\t: "+suppliersArray[i][1]);
					flag=false;
					System.out.print("added successfully! Do you want to add another find(Y/N)? ");
					char response=input.next().charAt(0);
				
					if((response=='y')||(response=='Y')){clearConsole(); searchSupplier();return;}
					else if((response=='n')||(response=='N')){ clearConsole(); supplierManage();return;}
					else{
						System.out.println("Invalid selection! Enter any key to continue ");
						String entry=input.next();
						clearConsole();
						homePage();return;
					}
				}
			}
			count++;
			System.out.println("can't find supplier id. try again!");
			if(count==5){
				System.out.println("Reached the limit of attempts. try again shortly!");
				System.out.print("Enter any key to continue ");
				String in=input.next();
				clearConsole();
				supplierManage();
				return;
			}
		}
	}
	
	
	public static void stockManage(){
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                            STOCK MANAGE                            |");
		System.out.println("+--------------------------------------------------------------------+");

		System.out.println("\n[1] Manage Item Categories\t[2] Add Item\n[3] Get Items Supplier Wise\t[4] View Items\n[5] Rank Items Per Unit Price\t[6] Home Page");
		System.out.print("\nEnter an option to continue > ");
		int stminput=input.nextInt();
		
		clearConsole();
		switch(stminput){
			case 1: manageItemCategories(); break;
			case 2:	addItems(); break;
			case 3: getItemsBySuppliers(); break;
			case 4: viewItems(); break;
			case 5: rankItemsByUnitPrice(); break;
			case 6: homePage(); break;
			default:{
			System.out.print("Invalid selection! Enter any key to continue ");
			String in=input.next();
			clearConsole();
			stockManage();
			}
		}
	}
	
	public static void manageItemCategories(){	
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                       MANAGE ITEM CATEGORY                         |");
		System.out.println("+--------------------------------------------------------------------+");
		
		System.out.println("\n[1] Add New Item Category\t[2] Delete Item Category\n[3] Update Item Category\t[4] Stock Management");
		System.out.print("\nEnter an option to continue > ");
		int micinput=input.nextInt();
		
		clearConsole();
		switch(micinput){
			case 1: addItemCategory(); break;
			case 2:	deleteItemCategory(); break;
			case 3: updateItemCategory(); break;
			case 4: stockManage(); break;
			default:{
			System.out.print("Invalid selection! Enter any key to continue ");
			String in=input.next();
			clearConsole();
			manageItemCategories();
			}
		}
	}
	
	public static void addItemCategory(){
				
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                         ADD ITEM CATEGORY                          |");
		System.out.println("+--------------------------------------------------------------------+");

		boolean flag=true;
		int count=0;
		L1: 
		while(flag){
			System.out.print("\nEnter the new item category: ");
			String cat=input.next();
		
			for (int i = 0; i < itemCategory.length; i++){
				if(cat.equals(itemCategory[i])){
					System.out.println("already added. try another category!");		
					count++;
					if(count==5){
						System.out.println("Reached the limit of attempts. try again shortly!");
						System.out.print("Enter any key to continue ");
						String in=input.next();
						clearConsole();
						manageItemCategories();
						return;
					}
					continue L1;
				}
			}
			itemCategory = growCatAr();
			itemCategory[itemCategory.length-1]=cat;
			System.out.print("added successfully! Do you want to add another category(Y/N)?");
			char response=input.next().charAt(0);
			
			if((response=='y')||(response=='Y')){ count=0;clearConsole(); addItemCategory();return;}
			else if((response=='n')||(response=='N')){ clearConsole(); manageItemCategories();return;}
			else{
				System.out.println("Invalid selection! Enter any key to continue ");
				String entry=input.next();
				clearConsole();
				manageItemCategories();return;
			}
		}
	}
	
	public static String[] growCatAr(){  // to increase the length of the itemCategory array
		
		String[] temp = new String[itemCategory.length+1];
		for (int i = 0; i < itemCategory.length; i++){
			temp[i]=itemCategory[i];
		}
		return temp;
	}
	
	public static void deleteItemCategory(){
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                       DELETE ITEM CATEGORY                         |");
		System.out.println("+--------------------------------------------------------------------+");
		
		boolean flag = true;
		int count=0;
		L1:
		while(flag){
			System.out.print("\nEnter the item category: ");
			String cat=input.next();
			
			L2:
			for (int i = 0; i < itemCategory.length; i++){
				if(cat.equals(itemCategory[i])){
					itemCategory=decrementCatAr(cat);
					
					System.out.print("deleted successfully! Do you want to delete another category(Y/N)?");
					char response=input.next().charAt(0);
			
					if((response=='y')||(response=='Y')){clearConsole(); deleteItemCategory();return;}
					else if((response=='n')||(response=='N')){ clearConsole(); manageItemCategories();return;}
					else{
						System.out.println("Invalid selection! Enter any key to continue ");
						String entry=input.next();
						clearConsole();
						manageItemCategories();
						return;
					}
				}
			}
			System.out.println("can't find item category. try another item category!");		
			count++;
			if(count==5){
				System.out.println("Reached the limit of attempts. try again shortly!");
				System.out.print("Enter any key to continue ");
				String in=input.next();
				clearConsole();
				manageItemCategories();
				return;
			}
		}
	}
	
	public static String[] decrementCatAr(String cat){  // to decrease the length of the itemCategory array
			
		String[] temp = new String[itemCategory.length-1];
		
		int j=0;
		L1:
		for (int i = 0; i < itemCategory.length; i++){
			if(cat.equals(itemCategory[i])){
				continue L1;
			}
			temp[j]=itemCategory[i];
			j++;
		}
		return temp;
	}
	
	public static void updateItemCategory(){
				
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                        UPDATE ITEM CATEGORY                        |");
		System.out.println("+--------------------------------------------------------------------+");

		boolean flag=true;
		int count=0;
		L1:
		while (flag){
			System.out.print("\nEnter the item category: ");
			String cat=input.next();
			
			L2:
			for (int i = 0; i < itemCategory.length; i++){
				if(cat.equals(itemCategory[i])){
					System.out.print("\nEnter the new category name: ");
					itemCategory[i]=input.next();
					System.out.print("Updated Successfully! Do you want to update another category?(Y/N) ");
					char response=input.next().charAt(0);
				
					if((response=='y')||(response=='Y')){clearConsole(); updateItemCategory();return;}
					else if((response=='n')||(response=='N')){clearConsole();manageItemCategories();return;}
					else{System.out.println("Invalid selection! Enter any key to continue ");
						String entry=input.next();
						clearConsole();
						manageItemCategories();
						return;
					}
				}
			}
			count++;
			System.out.println("can't find item category. try again! ");
			if(count==5){
				System.out.println("Reached the limit of attempts. try again shortly!");
				System.out.print("Enter any key to continue ");
				String in=input.next();
				clearConsole(); 
				manageItemCategories();
				return;
			}
		}
	}
	
	
	public static void addItems(){	
						
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                             ADD ITEM                               |");
		System.out.println("+--------------------------------------------------------------------+");

		int countCat=0;
		L1:
		for (int i = 0; i < itemCategory.length; i++){
			if (itemCategory[i]==null){
				countCat++;
			}
		}
		if (countCat==itemCategory.length){
			System.out.println("\nOOPS! It seems that you don't have any item categories in the system.");
			System.out.print("Do you want to add a new item category?(Y/N) ");
			char responseCat=input.next().charAt(0);
			
			if((responseCat=='y')||(responseCat=='Y')){ clearConsole(); addItemCategory();return;}
			else if((responseCat=='n')||(responseCat=='N')){ clearConsole(); stockManage();return;}
			else{
				System.out.println("Invalid selection! Enter any key to continue ");
				String entry=input.next();
				clearConsole();
				stockManage();
				return;
			}
		}
		
		int countSup=0;
		L2:
		for (int i = 0; i < suppliersArray.length; i++){
			if (suppliersArray[i][0]==null){
				countSup++;
			}
		}
		if (countSup==suppliersArray.length){
			System.out.println("\nOOPS! It seems that you don't have any suppliers in the system.");
			System.out.print("Do you want to add a new supplier?(Y/N) ");
			char responseSup=input.next().charAt(0);
			
			if((responseSup=='y')||(responseSup=='Y')){ clearConsole(); addSupplier();return;}
			else if((responseSup=='n')||(responseSup=='N')){ clearConsole(); stockManage();return;}
			else{
				System.out.println("Invalid selection! Enter any key to continue ");
				String entry=input.next();
				clearConsole();
				stockManage();
				return;
			}
		}
		
		boolean flag=true;
		int count=0;
		String itemCode=null;
		L3:
		while (flag){
			System.out.print("\nItem Code\t: ");
			itemCode=input.next();
		
			L4:
			for (int i = 0; i < items.length; i++){
				if(itemCode.equals(items[i][2])){
					count++;
					if(count==5){
						System.out.println("Reached the limit of attempts. try again shortly!");
						System.out.print("Enter any key to continue ");
						String in=input.next();
						clearConsole();
						stockManage();
						return;
					}
					System.out.println("already added. try another item code!");
					continue L3;
				}
			}
			count=0;
			flag=false;
		}
		
		System.out.println("\nSuppliers list: ");
		System.out.println("+---------------+----------------------+----------------------+");
		System.out.println("|       #       |      SUPPLIER ID     |     SUPPLIER NAME    |");
		System.out.println("+---------------+----------------------+----------------------+");
		
		L5:
		for (int i = 0; i < suppliersArray.length; i++){
			System.out.printf("|%-8s       |        %-6s        |    %-14s    |%n",(i+1),suppliersArray[i][0],suppliersArray[i][1]);
		}
		
		System.out.println("+---------------+----------------------+----------------------+");
		
		System.out.print("\nEnter the supplier number > ");
		int supNum=input.nextInt();
			if (supNum<1||supNum>suppliersArray.length){
				System.out.print("Invalid number!. Enter any key to continue ");
				String in=input.next();
				clearConsole();
				addItems();
				return;
			}
		
		System.out.println("\nItem Categories: ");
		System.out.println("+---------------+----------------------+");
		System.out.println("|       #       |    CATEGORY NAME     |");
		System.out.println("+---------------+----------------------+");
		
		for (int i = 0; i < itemCategory.length; i++){
			System.out.printf("|%-8s       |    %-14s    |%n",(i+1),itemCategory[i]);
		}
		
		System.out.println("+---------------+----------------------+");
		
		System.out.print("\nEnter the category number > ");
		int catNum=input.nextInt();
			if (catNum<1||catNum>itemCategory.length){
				System.out.print("Invalid number!. Enter any key to continue ");
				String in=input.next();
				clearConsole();
				addItems();
				return;
			}
			
		items=editItemsAr();
		items[items.length-1][2]=itemCode;	
		
		items[items.length-1][1]=suppliersArray[supNum-1][0];
			
		items[items.length-1][0]=itemCategory[catNum-1];
		
		System.out.print("\nDescription\t: ");
		String desc=input.next();
		items[items.length-1][3]=desc;
		
		System.out.print("Unit price\t: ");
		double unitPrice=input.nextDouble();		
		items[items.length-1][4]=String.valueOf(unitPrice);
		
		System.out.print("Qty on hand\t: ");
		int qty=input.nextInt();
		items[items.length-1][5]=String.valueOf(qty);
		
		System.out.print("added successfully! Do you want to add another Item(Y/N)? ");
		char response=input.next().charAt(0);
		
		if((response=='y')||(response=='Y')){clearConsole(); addItems();return;}
		else if((response=='n')||(response=='N')){clearConsole();stockManage();return;}
		else{System.out.println("Invalid selection! Enter any key to continue ");
			String entry=input.next();
			clearConsole();
			stockManage();
			return;
		}
	}
	
	public static String[][] editItemsAr(){  // grow items array and assign its existing values
		
		String[][] temp=new String[items.length+1][6];
		
		L1:
		for (int i = 0; i < items.length; i++){
			L2:
			for (int j = 0; j < items[i].length; j++){
				temp[i][j]=items[i][j];
			}
		}
		return temp;
	}
	
	public static void getItemsBySuppliers(){
					
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                          SEARCH SUPPLIER                           |");
		System.out.println("+--------------------------------------------------------------------+");
		
			System.out.print("\nEnter supplier Id: ");
			String id=input.next();
		
			L1:
			for (int i = 0; i < suppliersArray.length; i++){
				if(id.equals(suppliersArray[i][0])){
					System.out.println("Supplier Name: "+suppliersArray[i][1]);
					viewSuppliersWise(id);
					
					System.out.print("search successfully! Do you want to search another?(Y/N) ");
					char response=input.next().charAt(0);
						if((response=='y')||(response=='Y')){clearConsole(); getItemsBySuppliers();return;}
						else if((response=='n')||(response=='N')){clearConsole();stockManage();return;}
						else{System.out.println("Invalid selection! Enter any key to continue ");
							String entry=input.next();
							clearConsole();
							stockManage();
							return;
						}
				}
			}
			System.out.println("can't find supplier!"); 
			System.out.print( "Do you want to search again?(Y/N) ");
			char responseSup=input.next().charAt(0);
			
				if((responseSup=='y')||(responseSup=='Y')){ clearConsole(); getItemsBySuppliers();return;}
				else if((responseSup=='n')||(responseSup=='N')){ clearConsole(); stockManage();return;}
				else{
					System.out.println("Invalid selection! Enter any key to continue ");
					String entry=input.next();
					clearConsole();
					stockManage();
					return;
				}
		}
		
	public static void viewSuppliersWise(String id){
		
		System.out.println("\n");
		System.out.println("+---------------+---------------+---------------+---------------+---------------+");
		System.out.println("|    ITEM CODE  |   DESCRIPTION |   UNIT PRICE  |  QTY ON HAND  |   CATEGORY    |");
		System.out.println("+---------------+---------------+---------------+---------------+---------------+");
		
		L1:
		for (int i = 0; i < items.length; i++){
			if(id.equals(items[i][1])){
				System.out.printf("|   %10S  |   %10S  |   %10S  |   %10S  |   %10S  |%n",items[i][2],items[i][3],Double.parseDouble(items[i][4]),Integer.parseInt(items[i][5]),items[i][0]);
			}
		}
		System.out.println("+---------------+---------------+---------------+---------------+---------------+");
			
	}
	
	
	public static void viewItems(){
						
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                            VIEW ITEMS                              |");
		System.out.println("+--------------------------------------------------------------------+");

		L1:
		for (int i = 0; i < itemCategory.length; i++){
			System.out.println("\n"+itemCategory[i]+":");
			System.out.println("+---------------+---------------+-----------------+---------------+---------------+");
			System.out.println("|      SID      |      CODE     |       DESC      |     PRICE     |      QTY      |");
			System.out.println("+---------------+---------------+-----------------+---------------+---------------+");
			
			int j=0;
			L2:
			for (j = 0; j < items.length; j++){
				if(itemCategory[i].equals(items[j][0]))
				System.out.printf("|  %8S     |  %8S     |   %10S    |   %8S    |  %8S     |%n",items[j][1],items[j][2],items[j][3],Double.parseDouble(items[j][4]),Integer.parseInt(items[j][5]));
	
			}
			System.out.println("+---------------+---------------+-----------------+---------------+---------------+");
		}
		System.out.print("Do you want to go to stock manage page?(Y/N)");
		char response=input.next().charAt(0);
		
			if((response=='y')||(response=='Y')){ clearConsole(); stockManage();return;}
			else if((response=='n')||(response=='N')){ clearConsole(); System.exit(0);}
			else{System.out.println("Invalid selection! Enter any key to continue ");
				String entry=input.next();
				clearConsole();
				stockManage();
				return;
			}
	}
	
	public static void rankItemsByUnitPrice(){
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|                        RANKED UNIT PRICE                           |");
		System.out.println("+--------------------------------------------------------------------+");
		
		String[] temp;
		L1:
		for (int i = 1; i < items.length; i++){   // for sorting the item array by unit price
			L2:
			for (int j = 0; j < i; j++){
				if (Double.parseDouble(items[i][4])<Double.parseDouble(items[j][4])){
					temp=items[i];
					for (int k = i; k > j; k--){
						items[k]=items[k-1];
					}
					items[j]=temp;
				}
			}
		}
		
		System.out.println("\n");
		System.out.println("+---------------+---------------+---------------+---------------+---------------+---------------+");
		System.out.println("|      SID      |      CODE     |      DESC     |     PRICE     |      QTY      |      CAT      |");
		System.out.println("+---------------+---------------+---------------+---------------+---------------+---------------+");
		
		L3:
		for (int i = 0; i < items.length; i++){   // for print sorted array
			System.out.printf("|   %10S  |   %10S  |   %10S  |   %10S  |   %10S  |   %10S  |%n",items[i][1],items[i][2],items[i][3],Double.parseDouble(items[i][4]),Integer.parseInt(items[i][5]),items[i][0]);
		}
		
		System.out.println("+---------------+---------------+---------------+---------------+---------------+---------------+");
		
		System.out.print("Do you want to go to stock manage page?(Y/N)");
		char response=input.next().charAt(0);
		
			if((response=='y')||(response=='Y')){ clearConsole(); stockManage();return;}
			else if((response=='n')||(response=='N')){ clearConsole(); System.exit(0);}
			else{System.out.println("Invalid selection! Enter any key to continue ");
				String entry=input.next();
				clearConsole();
				stockManage();
				return;
			}
	}
	
	
	public static void main(String args[]){
		
		storedCredentials();
		loginPage();
			
	}
}
