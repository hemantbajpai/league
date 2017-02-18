package cscie56.ps2

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Game)
class GameSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "date should be between enddate and startdate of season"() {
        when:
            Season season = new Season(name:'2017', startDate: Date.parse("MM/dd/yyyy", "1/1/2017"), endDate: Date.parse("MM/dd/yyyy", "1/31/2017"))
            Game game = new Game(homeTeam: new Team(), awayTeam: new Team(), homeTeamScore: 6, awayTeamScore: 7, date: Date.parse("MM/dd/yyyy", date), location: 'location')
            game.season = season
        then:
            game.validate() == result
        where:
        date              |        result
        '1/15/2017'       |        true
        '1/15/2016'       |        false
        '2/15/2017'       |        false
    }
}
