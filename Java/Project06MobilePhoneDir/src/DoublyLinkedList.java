import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class DoublyLinkedList {
	static Scanner scanner = new Scanner(System.in);

	// Represent a node of the doubly linked list
	class Node {
		PhonebookData data;
		Node previous;
		Node next;

		public Node(PhonebookData data) {
			this.data = data;
		}
	}

	// Represent the head and tail of the doubly linked list
	Node head, tail = null;

	// addNode() will add a node to the list
	public void addNode(PhonebookData data) {
		// Create a new node
		Node newNode = new Node(data);

		// If list is empty
		if (head == null) {
			// Both head and tail will point to newNode
			head = tail = newNode;
			// head's previous will point to null
			head.previous = null;
			// tail's next will point to null, as it is the last node of the list
			tail.next = null;
		} else {
			// newNode will be added after tail such that tail's next will point to newNode
			tail.next = newNode;
			// newNode's previous will point to tail
			newNode.previous = tail;
			// newNode will become new tail
			tail = newNode;
			// As it is last node, tail's next will point to null
			tail.next = null;
		}
	}

	// display() will print out the nodes of the list
	public void display() {
		// Node current will point to head
		Node current = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of doubly linked list: ");
		while (current != null) {
			// Prints each node by incrementing the pointer.

			System.out.println(current.data + " ");
			current = current.next;
		}
	}

	public SortedSet searchHeadFirst(String searchItem) {
		SortedSet sortedSet = new TreeSet();
		Node current = head;
		while (current != null) {
			// Checks each node by incrementing the pointer.
//			if (current.data.name.contains(searchItem) || current.data.mobilePhone.contains(searchItem)) {
//				sortedSet.add((PhonebookData) current.data);
//			}
			if (current.data.name.toLowerCase().contains(searchItem.toLowerCase().strip()) 
					|| current.data.mobilePhone.contains(searchItem)) {
				sortedSet.add((PhonebookData) current.data);
			}
			
			current = current.next;
		}
		return sortedSet;
	}
	
	public SortedSet searchTailFirst(String searchItem) {
	    SortedSet sortedSet = new TreeSet();
	    Node current = tail;
	    if (tail == null) {
	        System.out.println("List is empty");
	        return null;
	    }
	    //    System.out.println("Nodes of doubly linked list: ");
	    while (current != null) {
	        //Checks each node by incrementing the pointer.
	        if (current.data.name.toLowerCase().contains(searchItem.toLowerCase().strip()) || current.data.mobilePhone.contains(searchItem)) {
	            sortedSet.add((PhonebookData) current.data);
	        }
	        current = current.previous;
	    }
	    return sortedSet;
	}
	
	public static DoublyLinkedList initializePhoneDirectoryList(String filePath) {
        // Load Phone Directory  from external file
        ReadCSVWithScanner csvReader = new ReadCSVWithScanner();
        DoublyLinkedList phoneDir = csvReader.getPhoneDirectoryFromCSV(filePath);
        return phoneDir;
    }
	
	public static void SearchMenu() {
		 String filePath = "./resources/PhoneDirectory.csv";
        DoublyLinkedList dList = initializePhoneDirectoryList(filePath);

		//Add nodes to the list
		dList.display();
		String menuItem = "";
		String searchItem = "";
		System.out.println("\n\n");	
		do{
			System.out.println("\nEnter number or character \n1 - Head-First search (h)\n2 - Tail-First search (t)\n3 - Display all-nodes (d)"
					+ "\n\n4 - Quit (q):");
			menuItem = scanner.nextLine();
			switch (menuItem) {
			case "h":
			case "1":
				System.out.println("\nStarting search from head-first test...");
				System.out.println("Please enter Name or Phone number: ");
				searchItem = scanner.nextLine();
				while (!searchItem.equals("q")) {
				    SortedSet sortedSet = dList.searchHeadFirst(searchItem);
				    if (sortedSet.size() != 0) {
				        for (Object node : sortedSet) {
				            System.out.println(((PhonebookData) node).toString());
				        }
				    }
				    else {
				        System.out.println("No search results found...");
				    }

				    System.out.print("\nEnter another Name or Phone number ('q' to return to the main menu):");
				    searchItem = scanner.nextLine();
				}
				break;
			case "t":
			case "2":
				System.out.println("\nStarting search from tail-first test...");
				System.out.println("Please enter Name or Phone number: ");
				searchItem = scanner.nextLine();
				while (!searchItem.equals("q")) {
				    SortedSet sortedSet = dList.searchTailFirst(searchItem);
				    if (sortedSet.size() != 0) {
				        for (Object node : sortedSet) {
				            System.out.println(((PhonebookData) node).toString());
				        }
				    }
				    else {
				        System.out.println("No search results found...");
				    }

				    System.out.print("\nEnter another Name or Phone number ('q' to return to the main menu):");
				    searchItem = scanner.nextLine();
				}
				break;
			case "d":
			case "3":
				dList.display();
				System.out.println("\n\n");
				break;
			case "q":
			case "4":
				System.out.println("Good bye!!!");
				scanner.close();
				return;
			default:
				System.out.println("\nNOT A VALID OPTION.\n");
				break;
			}
		}while(true);
	}

	public static void main(String[] args) {
		
		SearchMenu();
		
	}
}
