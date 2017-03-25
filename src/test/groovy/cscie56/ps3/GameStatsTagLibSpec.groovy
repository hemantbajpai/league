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
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(GameStatsTagLib)
class GameStatsTagLibSpec extends Specification {
    Map render
    Person player
    def setup() {
        tagLib.metaClass.render = { Map attrs ->
            render = attrs
        }

        player = new Person(gameStats: [])
        Game game = new Game(gameStats: [])
        GameStats gameStats = new GameStats(game:game, player: player)
        gameStats.generateOutput()
        game.gameStats << gameStats
        player.gameStats << gameStats

    }

    def cleanup() {
    }

    void "test total tag"() {
        when:
            setup()
            tagLib.total(player: player)
        then:
            render.template == 'playerStatsRow'
            render.model['statList'].size() == 13
            render.model['statList'][0] == 6
            render.model['statList'][1] == player.gameStats[0].minutesPlayed
            render.model['statList'][2] == player.gameStats[0].points
            render.model['statList'][3] == player.gameStats[0].assists
            render.model['statList'][4] == player.gameStats[0].rebounds
            render.model['statList'][5] == player.gameStats[0].steals
            render.model['statList'][6] == player.gameStats[0].shotsMade
            render.model['statList'][7] == player.gameStats[0].shotsAttempted
            render.model['statList'][9] == player.gameStats[0].threePointersMade
            render.model['statList'][10] == player.gameStats[0].threePointersAttempted
            render.model['statList'][12] == player.gameStats[0].personalFouls
    }

    void "test average tag"() {
        when:
            setup()
            tagLib.average(player: player)
        then:
            render.template == 'playerStatsRow'
            render.model['statList'].size() == 13
    }
}
