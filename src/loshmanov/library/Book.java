/**
 * Book.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-Apr-2023 20:54
 */

package loshmanov.library;

import java.util.Objects;

public class Book {
   private String author;
   private String title;
   private int year;

   public Book(String author, String title, int year) {
      this.author = author;
      this.title = title;
      this.year = year;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year = year;
   }

   @Override
   public String toString() {
      return "[" +
              "author='" + author + '\'' +
              ", title='" + title + '\'' +
              ", year=" + year +
              ']';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Book book = (Book) o;
      return year == book.year && author.equals(book.author) && title.equals(book.title);
   }

   @Override
   public int hashCode() {
      return Objects.hash(author, title, year);
   }
}
