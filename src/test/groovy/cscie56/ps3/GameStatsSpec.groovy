package cscie56.ps3

import cscie56.ps2.Game
import cscie56.ps2.Person
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(GameStats)
class GameStatsSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "shotsMade cannot be greater than attempted, threePointersMade cannot be greater than attempted and score should be valid"() {
        when:
            GameStats gameStats = new GameStats(shotsMade: shotsMade, shotsAttempted: shotsAttempted, threePointersMade: threePointersMade, threePointersAttempted: threePointersAttempted, points:points)
            Game game = new Game()
            Person person = new Person()
            gameStats.game = game
            gameStats.player = person
        then:
            gameStats.validate() == result
        where:
        shotsMade         |       shotsAttempted    |       threePointersMade    |      threePointersAttempted      |       points     |      result
        1                 |          2              |             1              |           2                      |        5         |       true
        1                 |          2              |             1              |           2                      |        6         |       false
        2                 |          2              |             1              |           2                      |        7         |       true
        3                 |          2              |             1              |           2                      |        5         |       false
        1                 |          2              |             2              |           2                      |        8         |       true
        1                 |          2              |             3              |           2                      |        5         |       false
    }
}
