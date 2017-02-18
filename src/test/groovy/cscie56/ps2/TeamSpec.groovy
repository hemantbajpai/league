package cscie56.ps2

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Team)
class TeamSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Team name not blank and unique"() {
        when:
            Conference conference = new Conference()
            Team team = new Team(name:'', homeWins: 1, awayWins: 1, homeLosses: 1, awayLosses: 1, ties: 0, results: 'WWLL')
            team.conference = conference
            team.save(flush:true)
        then:
            !team.validate()
        when:
            team.name='team'
            team.save(flush:true)
        then:
            team.validate()
        when:
            Team team1 = new Team(name:'team', homeWins: 1, awayWins: 1, homeLosses: 1, awayLosses: 1, ties: 0, results: 'WWLL')
            team1.conference = conference
            team1.save(flush:true)
        then:
            !team1.validate()
        when:
            team1.name = 'team1'
            team1.save(flush:true)
        then:
            team1.validate()
    }
}
