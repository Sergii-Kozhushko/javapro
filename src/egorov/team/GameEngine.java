/**
 * GameEngine.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 31-Mar-2023 20:41
 */

package egorov.team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameEngine {

   // сыграть одну основную игру
   public static void playOneMainGame(Team team1, Team team2) {
      int result = new Random().nextInt(3);
      switch (result) {
         case (0) -> team1.setMainScore(team1.getMainScore() + 2);
         case (1) -> {
            team1.setMainScore(team1.getMainScore() + 1);
            team2.setMainScore(team2.getMainScore() + 1);
         }
         case (2) -> team2.setMainScore(team2.getMainScore() + 2);
      }
   }

   // Дополнительная игра
   public static void playOneAdditionalGame(Team team1, Team team2) {
      int result = new Random().nextInt(3);
      switch (result) {
         case (0) -> team1.setAdditionalScore(team1.getAdditionalScore() + 2);
         case (1) -> {
            team1.setAdditionalScore(team1.getAdditionalScore() + 1);
            team2.setAdditionalScore(team2.getAdditionalScore() + 1);
         }
         case (2) -> team2.setAdditionalScore(team2.getAdditionalScore() + 2);
      }
   }

   // метод играет игры всех лиг + доп игры. Игрок каждый с каждым
   public static void playOneRoundAllLeagues(LeagueList<League> leagues) {
      for (League league : leagues.getLeagues()) {
         // играем игры каждый-с-каждым в одной лиге
         List<Team> teams = league.getTeams();
         // 1 2 3 4 5
         for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
               playOneMainGame(teams.get(i), teams.get(j));
            }
         }
         playAdditionalGames(league);
         league.printTable();
      }
   }

   // метод играет доп игры между командами пока они не получат разное количество очков
   public static void playAdditionalGamesGroup(ArrayList<Team> teams) {
      boolean doWeNeedMoreAdditionalGames = true;
      if (teams.size() == 1) return;
      int temp = -1;
      //  проверяем доп очки команд - надо ли им еще играть доп игры
      for (Team team : teams) {
         if (temp == -1) {
            temp = team.getAdditionalScore();
         } else if (temp != team.getAdditionalScore()) {
            // если у команд различаются очки за доп игры, то больше не надо играть
            doWeNeedMoreAdditionalGames = false;
            break;
         }
      }
      // если надо, то играем доп игры каждый-с-каждым
      if (doWeNeedMoreAdditionalGames) {
         for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
               playOneAdditionalGame(teams.get(i), teams.get(j));
            }
         }
         // запускаем рекурсивно, пока доп очик не будут различаться
         playAdditionalGamesGroup(teams);
      }
   }

   public static void playAdditionalGames(League league) {
      // определяем какие игроки должны играть доп игры
      // делаем хешмап с распределением по основным набранным очкам
      // 3 -> (список команд набравших 3 очка) 2-> (команды, набравшие 2 очка)
      HashMap<Integer, ArrayList<Team>> sortedTeams = new HashMap<>();
      for (Team team : league.getTeams()) {
         if (sortedTeams.containsKey(team.getMainScore())) {
            sortedTeams.get(team.getMainScore()).add(team);
         } else {
            ArrayList<Team> al = new ArrayList<>();
            al.add(team);
            sortedTeams.put(team.getMainScore(), al);
         }
      }

      // играем доп игры, там где больше одной команды в списке
      for (Integer score : sortedTeams.keySet()) {
         // если игроки имеют одинаковое количество главных очков, то играть доп игры
         if (sortedTeams.get(score).size() > 1) {
            ArrayList<Team> teamsAdditional = sortedTeams.get(score);
            playAdditionalGamesGroup(teamsAdditional);
         }
      }
   }


}
