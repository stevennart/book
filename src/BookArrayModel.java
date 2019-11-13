import javax.swing.AbstractListModel;

/**
 * A book array model used by {@link javax.swing.JList}.
 */
public class BookArrayModel extends AbstractListModel<String> {
    private Book[] bookArray;

    // sets the bookarray with an array of Books through the parameters.
    
    // constructor.
    public BookArrayModel(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    // sets the bookarray with an array of Books through the parameters.
    public void setBookArray(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    @Override
    public int getSize() {
    	// returns the whole size of how many books are inside the array. 
        return bookArray.length;
    }

    @Override
    public String getElementAt(int index) {
    	// returns a specific book object's name by passing the index. 
        return bookArray[index].getTitle();
    }
}
