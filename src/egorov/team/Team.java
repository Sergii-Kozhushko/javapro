/**
 * Player.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 30-Mar-2023 20:49
 */

package egorov.team;

public class Team implements Comparable<Team> {

   private String name;
   private LeagueName league;
   private int mainScore;

   private int additionalScore;

   public Team(String name, LeagueName league) {
      this.name = name;
      this.league = league;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAdditionalScore() {
      return additionalScore;
   }

   public void setAdditionalScore(int additionalScore) {
      this.additionalScore = additionalScore;
   }

   public void setLeague(LeagueName league) {
      this.league = league;
   }

   public void setMainScore(int mainScore) {
      this.mainScore = mainScore;
   }

   public int getMainScore() {
      return mainScore;
   }

   public LeagueName getLeague() {
      return league;
   }


   @Override
   public int compareTo(Team o) {
      if (o.getMainScore() != mainScore) {
         return o.getMainScore() - mainScore;
      }
      else {
         return o.getAdditionalScore() - additionalScore;
      }
   }
}
