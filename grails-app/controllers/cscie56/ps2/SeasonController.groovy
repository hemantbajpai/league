package cscie56.ps2

import cscie56.ps5.Role
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured([Role.ROLE_ANONYMOUS, Role.ROLE_USER, Role.ROLE_ADMIN])
class SeasonController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def showStandings(Season season) {

        def eastResultsMap = [:]
        def westResultsMap = [:]
        season.league.conferences.eachWithIndex{ conference, idx ->
            conference.teams.sort()
            int leadingWins = conference.teams[0].homeWins+conference.teams[0].awayWins
            int leadingLosses = conference.teams[0].homeLosses+conference.teams[0].awayLosses
            conference.teams.eachWithIndex { team, index ->
                def values = []
                values.add(index+1)
                values.add(team.homeWins+team.awayWins)
                values.add(team.homeLosses+team.awayLosses)
                values.add(team.homeTies+team.awayTies)
                values.add(team.getPercentage())
                values.add((leadingWins-team.homeWins-team.awayWins+team.homeLosses+team.awayLosses-leadingLosses)/2)
                values.add("$team.homeWins-$team.homeLosses-$team.homeTies")
                values.add("$team.awayWins-$team.awayLosses-$team.awayTies")
                values.add(team.getLastTen())
                values.add(team.getStreak())
                values.add(team.getDelta())
                if(conference.name == 'eastern')
                    eastResultsMap.put(team, values)
                else
                    westResultsMap.put(team, values)
            }
        }

        render view: 'showStandings', model:[ westResults:westResultsMap, eastResults: eastResultsMap]
    }

}
