/**
 * ApplicationStart.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-Apr-2023 21:10
 */

package loshmanov.library;

import java.util.ArrayList;
import java.util.List;

public class ApplicationStart {
    public static void main(String[] args) {
        Library library = new Library(List.of(
                new Book("Merry Shelly", "Drakula", 1998),
                new Book("Unknown", "Bible", 2002),
                new Book("Pelevin", "Generation P", 1995),
                new Book("A.C. Doyle", "Sherlock Holmes", 1985),
                new Book("J Oruell", "1984", 1985)
        ),
                List.of(
                        new Reader("Ivanov II", "user1@gmail.com", true),
                        new Reader("Petrov S.I.", "user2@gmail.com", true),
                        new Reader("Sidorov A.V.", "user3@gmail.com", true),
                        new Reader("Kuznecov B.B", "user4@gmail.com", false),
                        new Reader("Baumann H.J.", "user5@gmail.com", true)

                ));
        library.lendBook(library.getReaderList().get(0), library.getBookList().get(0));
        library.lendBook(library.getReaderList().get(0), library.getBookList().get(1));
        library.lendBook(library.getReaderList().get(0), library.getBookList().get(2));
        library.lendBook(library.getReaderList().get(1), library.getBookList().get(3));
        library.lendBook(library.getReaderList().get(2), library.getBookList().get(4));


        System.out.println("Все читатели:\n" + library.createMailListAll() + "\n");
        System.out.println("Читатели, согласившиеся на рассылку, и взявшие хоть одну книгу:\n " + library.createMailListAgree1Book() + "\n");

        System.out.println("Список всех книг, которые выданы читателям: " + library.getAllBorrowedBooks());

        String author = "J Oruell";
        System.out.println("Список книга автора '" + author + "': \n" + library.getAllReadersBorrowedByAuthor(author) + "\n");

        System.out.println("Максимальное количество книг на руках: " + library.getMaxBookQuantityLended());
        System.out.println("Емейлы читателей по группам: OK < 2 книг, TOO_MUCH: >= 2 книг:\n" +library.get2Lists());
    }

}
