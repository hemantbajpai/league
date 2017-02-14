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

    void "Team name not null"() {
        when:
            Team team = new Team(name:'name')
            team.save(flush:true)
        then:
            team.validate()
    }
}
