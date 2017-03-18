package cscie56.ps2

import cscie56.ps3.GameStats

class Game {

    Team homeTeam
    Team awayTeam
    int homeTeamScore
    int awayTeamScore
    Date date
    String location

    static belongsTo = [season:Season]
    static hasMany = [gameStats: GameStats]

    static constraints = {
        date validator: {val, obj, errors ->
            if(val > obj.season.endDate ||  val < obj.season.startDate) {
                errors.rejectValue('date', 'dateBeforeStartDateOrAfterEndDate')
            }
        }
    }

    def generateOutput() {

        //generating scores
        Random rand = new Random()
        homeTeamScore = rand.nextInt(10)
        awayTeamScore = rand.nextInt(10)

        //updating team classes variables
        if(homeTeamScore > awayTeamScore) {
            ++homeTeam.homeWins
            homeTeam.results = "W" + homeTeam.results

            ++awayTeam.awayLosses
            awayTeam.results = "L" + awayTeam.results
        }
        else if(homeTeamScore < awayTeamScore) {
            ++homeTeam.homeLosses
            homeTeam.results = "L" + homeTeam.results

            ++awayTeam.awayWins
            awayTeam.results = "W" + awayTeam.results
        }
        else {
            homeTeam.results = "T" + homeTeam.results
            ++homeTeam.ties

            awayTeam.results = "T" + awayTeam.results
            ++awayTeam.ties
        }
    }
}
