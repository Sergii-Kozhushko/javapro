/**
 * Reader.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-Apr-2023 20:56
 */

package loshmanov.library;

import java.util.ArrayList;
import java.util.List;

public class Reader {
   private String fio;
   private String email;
   private boolean isAgreeMailList = false;
   private List<Book> bookList = new ArrayList<>();

   public Reader(String fio, String email, boolean isAgreeMailList) {
      this.fio = fio;
      this.email = email;
      this.isAgreeMailList = isAgreeMailList;
   }

   public String getFio() {
      return fio;
   }

   public void setFio(String fio) {
      this.fio = fio;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public boolean isAgreeMailList() {
      return isAgreeMailList;
   }

   public void setAgreeMailList(boolean agreeMailList) {
      isAgreeMailList = agreeMailList;
   }

   public List<Book> getBookList() {
      return bookList;
   }

   public void setBookList(List<Book> bookList) {
      this.bookList = bookList;
   }

   @Override
   public String toString() {
      return "{" +
              "fio='" + fio + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}
