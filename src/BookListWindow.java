import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * BookListWindow
 */
public class BookListWindow extends JFrame implements ActionListener {

	// ======== Top ========
	private JPanel topPanel;
	private JTextField searchTextField;
	private JButton searchButton;
	private JButton clearButton;

	// ======== Middle ========
	private JScrollPane titleListScrollPane;
	private JList<String> bookTitleList;

	// ======== Bottom ========
	private JPanel bottomPanel;
	private JButton addButton;
	private JButton detailButton;
	private JButton removeButton;

	// ======== Data ========
	private BookStorage bookStorage;
	private BookArrayModel bookListModel;

	public BookListWindow(BookStorage bookStorage) {
		this.bookStorage = bookStorage;

		// sets the bookListModel with a book array that is sorted by their title in
		// alphabetical order.
		// bookStorage is an array of Book objects.
		bookListModel = new BookArrayModel(bookStorage.getAll());
		//

		initComponents();
	}

	/**
	 * Clears the search results and list all the books.
	 */
	public void resetToAll() {
		// Does the exact same thing as bookListModel = new
		// BookArrayModel(bookStorage.getAll());
		bookListModel.setBookArray(bookStorage.getAll());
		//
		searchTextField.setText("");
		bookTitleList.updateUI();
	}

	/**
	 * Returns the book storage.
	 */
	public BookStorage getBookStorage() {
		return bookStorage;
	}

	/**
	 * Initializes the components.
	 */
	private void initComponents() {
		Container contentPane = getContentPane();
		//this.setContentPane(contentPane); || automatically called when setting the layout of contentPane.     
		

		// this references to JFrame when setting title, JFrame is the entire window for
		// the application;
		this.setTitle("Book Management");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// ======== Top ========
		topPanel = new JPanel();
		searchTextField = new JTextField();
		searchButton = new JButton("SEARCH");
		clearButton = new JButton("CLEAR");
		
		// makes the size for the search bar  
		searchTextField.setColumns(12); // the height wont watch the buttons if u only use this statement. 
		searchTextField.setPreferredSize(searchButton.getPreferredSize()); // this statement will adjust the height & width to the buttons sizes

		searchButton.addActionListener(this);
		clearButton.addActionListener(this);

		{
			// Set the layout for topPanel and add the buttons.
			// TODO Add your code here...

			topPanel.setLayout(new FlowLayout());
			topPanel.add(searchTextField);
			topPanel.add(searchButton);
			topPanel.add(clearButton);

			/*
			 * topPanel.setLayout(new contentPane(topPanel, contentPane.PAGE_AXIS));
			 * topPanel.add(contentPane); getContentPane().add(topPanel,
			 * contentPane.CENTER);
			 * 
			 * JPanel centerPane = new JPanel(new FlowLayout());
			 * centerPane.add(openReportSelection); centerPane.add(closeButton);
			 * 
			 * add(topPanel);
			 */

		}

		// ======== Middle ========
		
		bookTitleList = new JList<String>(bookListModel);   // optional to put String within the <> like <String> since it is already declared at the top of the code.
		titleListScrollPane = new JScrollPane(bookTitleList); 
		
		
		
		{
			// Configure the bookTitleList 1) Use single selection
			// TODO Add your code here...
			
			bookTitleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			bookTitleList.setLayoutOrientation(JList.VERTICAL);
			bookTitleList.setVisibleRowCount(10);  // shows 10 items in the list before you have to start scrolling down.
			
			//titleListScrollPane.setPreferredSize(new Dimension(10, 10));

		}

		titleListScrollPane.setViewportView(bookTitleList);

		// ======== Bottom ========
		bottomPanel = new JPanel();
		addButton = new JButton("ADD");
		detailButton = new JButton("DETAIL");
		removeButton = new JButton("REMOVE");

		addButton.addActionListener(this);
		detailButton.addActionListener(this);
		removeButton.addActionListener(this);

		{
			// Set the layout for bottomPanel and add the buttons.
			// TODO Add your code here...
			
			
			bottomPanel.setLayout(new FlowLayout()); 
			bottomPanel.add(addButton);
			bottomPanel.add(detailButton);
			bottomPanel.add(removeButton);

			
			
		}

		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS)); 
		//contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));  this one does same thing as y_axis i assume, idk if problems will come up later on
		{
			// Add the components to contentPane with proper layout options.
			// TODO Add your code here...

			contentPane.add(topPanel);
			//titleListScrollPane.add(bookTitleList);
			contentPane.add(titleListScrollPane);
			contentPane.add(bottomPanel);
			
			  
		}
 
		this.pack();
		this.setLocationRelativeTo(getOwner());

	} // END OF initComponents() method.

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchButton) {
			// Action for the SEARCH button
			// TODO Add your code here...
			add(searchTextField);

		} else if (e.getSource() == clearButton) {
			// Action for the CLEAR button
			// TODO Add your code here...

		} else if (e.getSource() == addButton) {
			// Action for the ADD button
			// TODO Add your code here...

		} else if (e.getSource() == detailButton) {
			// Action for the DETAIL button
			// TODO Add your code here...

		} else if (e.getSource() == removeButton) {
			// Action for the REMOVE button
			if (!bookTitleList.isSelectionEmpty()) {
				bookStorage.remove(bookTitleList.getSelectedValue());
				JOptionPane.showMessageDialog(this, "Remove Successful!");
				resetToAll();
			}
		}
	} // END of actionPerformed() method.

	public static void main(String[] args) {
		BookStorage bookStore = new BookStorage(); // creates an array of books called bookStore.
		bookStore.initBooks(); // adds the initial 11 books into the array with abitrary info for each book.

		// bookListWindow has all the buttons and search bar for the application, also
		// calls initComponents() inside its constructor.
		BookListWindow bookListWindow = new BookListWindow(bookStore);

		bookListWindow.setVisible(true); // sets the default window for the entire application to be shown.

		// console.log
	}
}
