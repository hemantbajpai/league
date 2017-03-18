package cscie56.ps3

import cscie56.ps2.Conference
import cscie56.ps2.Game
import cscie56.ps2.League
import cscie56.ps2.Person
import cscie56.ps2.Season
import cscie56.ps2.Team
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(GameStatsService)
class GameStatsServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test getIndividualStatsInfo"() {
        when:
            Person player = new Person()
            Game game = new Game()
            GameStats gameStats = new GameStats(game:game, player: player)
            gameStats.generateOutput()
            player.gameStats = [] << gameStats
        then:
            service.getIndividualStatsInfo(player).totalMinutesPlayed == gameStats.minutesPlayed
            service.getIndividualStatsInfo(player).totalPoints == gameStats.points
            service.getIndividualStatsInfo(player).totalAssists == gameStats.assists
            service.getIndividualStatsInfo(player).totalRebounds == gameStats.rebounds
            service.getIndividualStatsInfo(player).totalSteals == gameStats.steals
            service.getIndividualStatsInfo(player).totalShotsMade == gameStats.shotsMade
            service.getIndividualStatsInfo(player).totalShotsAttempted == gameStats.shotsAttempted
            service.getIndividualStatsInfo(player).totalThreePointersMade == gameStats.threePointersMade
            service.getIndividualStatsInfo(player).totalThreePointersAttempted == gameStats.threePointersAttempted
            service.getIndividualStatsInfo(player).totalPersonalFouls == gameStats.personalFouls
    }

    void "test getLeaderboardInfo"() {
        when:
            League league = new League(conferences: [], seasons: [])
            Conference conference = new Conference(name: "eastern", teams: [], league:league)

            Team team1 = new Team(name:"team1", homeWins: 1, awayWins: 0, homeLosses: 0, awayLosses: 0, ties: 0, results: "W", players: [], conference: conference)
            Person player = new Person(firstName: 'Anthony', lastName: 'Davis', role:'player', bio:'xyz', height: '6\'11\"', weight: 253, birthDate: Date.parse("MM-dd-yyyy", "03-11-1993"), birthPlace: 'Boston, MA', universityAttended: 'Harvard', team: team1)
            team1.players << player
            Team team2 = new Team(name:"team2", homeWins: 0, awayWins: 0, homeLosses: 0, awayLosses: 1, ties: 0, results: "L", conference: conference)
            conference.teams << team1 << team2

            Season season = new Season(name:'2017', startDate:Date.parse("MM/dd/yyyy", "1/1/2017"), endDate:Date.parse("MM/dd/yyyy", "1/31/2017"), league: league, games: [])
            Game game = new Game(homeTeam: team1, awayTeam: team2, date: Date.parse("MM/dd/yyyy", "1/13/2017"), location: team1.name, season: season)
            season.games << game

            league.seasons  << season

            league.conferences << conference
            GameStats gameStats = new GameStats(game:game, player:player)
            gameStats.generateOutput()
            game.gameStats = [] << gameStats
            player.gameStats = [] << gameStats

        then:
            service.getLeaderboardInfo(league).pointsMap[player] == gameStats.points
            service.getLeaderboardInfo(league).assistsMap[player] == gameStats.assists
            service.getLeaderboardInfo(league).reboundsMap[player] == gameStats.rebounds
            service.getLeaderboardInfo(league).stealsMap[player] == gameStats.steals
    }
}
