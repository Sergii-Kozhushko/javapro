/**
 * League.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 30-Mar-2023 20:50
 */

package egorov.team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {
    private final LeagueName name;
    private List<Team> teams = new ArrayList<>();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public League(LeagueName name) {
        this.name = name;
    }

    public LeagueName getName() {
        return name;
    }


    public void printTable() {
        Collections.sort(teams);
        System.out.println("Лига " + name + ". Турнирная таблица");
        for (int i = 0; i < teams.size(); i++) {
            String color = i == 0 || i == 1 ? ANSI_RED : ANSI_RESET;

            System.out.printf("%s%d. %-20s%s : %d (%d)%n",color, i + 1,
                    teams.get(i).getName(), ANSI_RESET, teams.get(i).getMainScore(), teams.get(i).getAdditionalScore() );
        }
    }

}
