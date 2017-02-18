package cscie56.ps2

import grails.test.mixin.*
import spock.lang.*

@TestFor(SeasonController)
@Mock(Season)
class SeasonControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        League league = new League()
        Conference eastern = new Conference(name: "eastern", teams: [])
        Team team1 = new Team(name:"team1", homeWins: 1, awayWins: 1, homeLosses: 1, awayLosses: 1, ties: 0, results: "WWLL")
        Team team2 = new Team(name:"team2", homeWins: 1, awayWins: 1, homeLosses: 1, awayLosses: 1, ties: 0, results: "LLWW")
        eastern.teams << team1 << team2
        Conference western = new Conference(name: "western", teams: [])
        Team team3 = new Team(name:"team3", homeWins: 1, awayWins: 1, homeLosses: 1, awayLosses: 1, ties: 0, results: "WWLL")
        Team team4 = new Team(name:"team4", homeWins: 1, awayWins: 1, homeLosses: 1, awayLosses: 1, ties: 0, results: "LLWW")
        western.teams << team3 << team4
        league.conferences = [] << eastern << western

        params << [name:'2017', startDate:Date.parse("MM/dd/yyyy", "1/1/2017"), endDate:Date.parse("MM/dd/yyyy", "1/31/2017"), league: league, games: []]
    }

    void "Test the showStandings return correct model" () {

        when:"The showStandings is executed"
            populateValidParams(params)
            def season = new Season(params)
            controller.showStandings(season)

        then: "The model is correct"
            model.westResults
            model.eastResults
    }

}
