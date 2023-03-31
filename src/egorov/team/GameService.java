/**
 * Generator.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 30-Mar-2023 20:55
 */

package egorov.team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameService {
    public static final String[] TEAM_NAMES = new String[]
            {"Milan", "Juventus", "Chelsea", "Dynamo (Kyiv)", "Napoli", "Bayern München", "Real Madrid", "Barcelona",
                    "Arsenal", "Benfica", "Liverpool", "Paris SG", "Borussia Dortmund", "Inter Milan", "Athletico Madrid", "Ajax",
                    "AC Milan", "Feynoord", "Lazio", "PSV Eindhoven", "FK Red Star Belgrade", "Flora Tallin", "Sporting",
                    "Bayer Leverkuzen", "Tottenham", "Newcastle"};
    public static final int NUMBER_TEAMS_IN_LEAGUE = 6;

    public static List<League> leagues = new ArrayList<>();


    // генерирует случайное незанятое название команды
    public static String generateUniqTeamName(ArrayList<Team> currentTeams) {
        boolean isNewNameUniq = false;
        String newName = "";
        while (!isNewNameUniq) {
            newName = TEAM_NAMES[new Random().nextInt(TEAM_NAMES.length)];
            isNewNameUniq = true;
            for (League league : leagues) {
                for (Team team : league.getTeams()) {
                    if (team.getName().equals(newName)) {
                        isNewNameUniq = false;
                        break;
                    }
                }
            }
            // проверяет не занято ли имя в текущей создаваемой лиге
            for (Team team : currentTeams) {
                if (team.getName().equals(newName)) {
                    isNewNameUniq = false;
                    break;
                }
            }
        }
        return newName;
    }

    // создает одну лигу
    public static League createOneLeague(LeagueName leagueName) {
        League league = new League(leagueName);
        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < NUMBER_TEAMS_IN_LEAGUE; i++) {
            teams.add(new Team(generateUniqTeamName(teams), leagueName));

        }
        league.setTeams(teams);
        return league;
    }

    // создает все лиги
    public static void createLeagues() {
        if (NUMBER_TEAMS_IN_LEAGUE * LeagueName.values().length > TEAM_NAMES.length){
            System.out.println("Не могу создать уникальные команды, не хватает уникальных названий");
            return;
        }
        for (LeagueName ln : LeagueName.values()) {
            leagues.add(createOneLeague(ln));
        }
    }

    // сыграть одну основную игру
    public static void playOneMainGame(Team player1, Team player2) {
        int result = new Random().nextInt(3);
        switch (result) {
            case (0) -> player1.setMainScore(player1.getMainScore() + 2);
            case (1) -> {
                player1.setMainScore(player1.getMainScore() + 1);
                player2.setMainScore(player2.getMainScore() + 1);
            }
            case (2) -> player2.setMainScore(player2.getMainScore() + 2);
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
    public static void playOneRoundAllLeagues() {
        for (League league : leagues) {
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
        for (Team team : teams) {
            if (temp == -1) {
                temp = team.getAdditionalScore();
            } else if (temp != team.getAdditionalScore()) {
                // если у команд различаются очки за доп игры, то больше не надо играть
                doWeNeedMoreAdditionalGames = false;
                break;
            }
        }
        if (doWeNeedMoreAdditionalGames) {
            for (int i = 0; i < teams.size() - 1; i++) {
                for (int j = i + 1; j < teams.size(); j++) {
                    playOneAdditionalGame(teams.get(i), teams.get(j));
                }
            }
            playAdditionalGamesGroup(teams);
        }
    }

    public static void playAdditionalGames(League league) {
        // определяем какие игроки должны играть доп игры
        // делаем хешмап с распределением по основным набранным очкам
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

        // теперь надо сыграть доп игры
        for (Integer score : sortedTeams.keySet()) {
            // если игроки имеют одинаковое количество главных очков, то играть доп игры
            if (sortedTeams.get(score).size() > 1) {
                ArrayList<Team> teamsAdditional = sortedTeams.get(score);
                playAdditionalGamesGroup(teamsAdditional);
            }
        }
    }

}


