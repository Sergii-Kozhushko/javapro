/**
 * Generator.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 30-Mar-2023 20:55
 */

package egorov.team;

import java.util.*;

public class TournamentCreator {
    public static final String[] TEAM_NAMES = new String[]
            {"Milan", "Juventus", "Chelsea", "Dynamo (Kyiv)", "Napoli", "Bayern München", "Real Madrid", "Barcelona",
                    "Arsenal", "Benfica", "Liverpool", "Paris SG", "Borussia Dortmund", "Inter Milan", "Athletico Madrid", "Ajax",
                    "AC Milan", "Feynoord", "Lazio", "PSV Eindhoven", "FK Red Star Belgrade", "Flora Tallin", "Sporting",
                    "Bayer Leverkuzen", "Tottenham", "Newcastle"};
    public static final int NUMBER_TEAMS_IN_LEAGUE = 6;


    // генерирует случайное незанятое название команды


    // создает одну лигу
    public static League createOneLeague(LeagueName leagueName, ArrayList<String> leagueNamesList) {
        League league = new League(leagueName);
        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < leagueNamesList.size(); i++) {
            teams.add(new Team(leagueNamesList.get(i), leagueName));
        }
        league.setTeams(teams);
        return league;
    }

    // создает все лиги
    public static LeagueList createLeagues() {
        LeagueList<League> result = new LeagueList<>();
        if (NUMBER_TEAMS_IN_LEAGUE * LeagueName.values().length > TEAM_NAMES.length) {
            System.out.println("Не могу создать уникальные команды, не хватает уникальных названий");
            return null;
        }
        // создаем из массива имен сет, где названия команд расположены случайно
        List<String> names = new ArrayList<>(Arrays.asList(TEAM_NAMES));// Arrays.stream(TEAM_NAMES).toList();
        Collections.shuffle(names);
        for (LeagueName ln : LeagueName.values()) {
            Iterator<String> iterator = names.iterator();
            int counter = 0;
            ArrayList<String> namesInOneLeague = new ArrayList<>();
            while (iterator.hasNext()) {
                if (counter < NUMBER_TEAMS_IN_LEAGUE) {
                    namesInOneLeague.add(iterator.next());
                    iterator.remove();
                    counter++;
                } else {
                    break;
                }
            }

            result.getLeagues().add(createOneLeague(ln, namesInOneLeague));

        }
        return result;
    }







}


