/**
 * Library.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-Apr-2023 21:01
 */

package loshmanov.library;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
   private List<Book> bookList = new ArrayList<>();
   private List<Reader> readerList = new ArrayList<>();

   public Library(List<Book> bookList) {
      this.bookList = bookList;
   }

   public Library(List<Book> bookList, List<Reader> readerList) {
      this.bookList = bookList;
      this.readerList = readerList;
   }

   public void lendBook(Reader reader, Book book){
      reader.getBookList().add(book);

   }
   public void printBooksOrderByYear(){
      bookList.stream().sorted(Comparator.comparing(Book::getYear)).forEach(System.out::println);
   }

   public List<String> createMailListAll(){
      return readerList.stream().map(Reader::getEmail).collect(Collectors.toList());
   }

   public List<String> createMailListAgree1Book(){
      return readerList.stream()
              .filter(x-> x.isAgreeMailList() && x.getBookList().size() > 0).map(Reader::getEmail)
               .collect(Collectors.toList());
   }


   public List<Book> getAllBorrowedBooks(){
      return readerList
              .stream()
              .flatMap(x->x.getBookList().stream())

              .distinct().collect(Collectors.toList());
   }

   public List<Book> getBookList() {
      return bookList;
   }

   public List<Reader> getReaderList() {
      return readerList;
   }

   public List<Reader> getAllReadersBorrowedByAuthor(String author){
      return readerList
              .stream()
              .filter(x->x.getBookList().stream().anyMatch(y -> y.getAuthor().equals(author)))
              .collect(Collectors.toList());
   }

   public int getMaxBookQuantityLended(){
      return readerList.stream()
              .map(x->x.getBookList().size())
              .max(Integer::compareTo).orElse(0);
   }

//   отправить письма всем, кто согласился на рассылку, — будем рассылать разные тексты двум группам:
//
//   тем, у кого взято меньше двух книг, просто расскажем о новинках библиотеки;
//
//   тем, у кого две книги и больше, напомним о том, что их нужно вернуть в срок.
//   То есть надо написать метод, который вернёт два списка адресов (типа EmailAddress):
//   с пометкой OK — если книг не больше двух,
//   или TOO_MUCH — если их две и больше. Порядок групп не важен.
   Map<String, List<String>> get2Lists(){
       return readerList.stream()
              .collect(Collectors.groupingBy(
                      x->x.getBookList().size()<2?"OK":"TOO MUCH",
                      Collectors.mapping(Reader::getEmail, Collectors.toList())
              ));


      //.collect(Collectors.toMap(, x->x.getEmail()));


      //return null;
   }


}
