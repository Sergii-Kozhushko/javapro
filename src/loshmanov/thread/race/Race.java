/**
 * Race.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 04-Jun-2023 22:29
 */

package loshmanov.thread.race;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {

   private ArrayList<Stage> stages;

   public Race(Stage... stages) {
      this.stages = new ArrayList<>(Arrays.asList(stages));
   }

   public ArrayList<Stage> getStages() {
      return stages;
   }
}
