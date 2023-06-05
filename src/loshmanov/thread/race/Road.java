/**
 * Road.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 04-Jun-2023 22:29
 */

package loshmanov.thread.race;



public class Road extends Stage {

   public Road(int length) {
      this.length = length;
      this.name = "Road " + length + "m";
   }

}
