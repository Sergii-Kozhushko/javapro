/**
 * ApplicationStart.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 30-Mar-2023 21:07
 */

package egorov.team;

public class ApplicationStart {
   public static void main(String[] args) {
      LeagueList leagueList = TournamentCreator.createLeagues();
      leagueList.print();
      GameEngine.playOneRoundAllLeagues(leagueList);
      leagueList.print();
   }

}
