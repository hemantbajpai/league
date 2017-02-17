package cscie56.ps2

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Conference)
class ConferenceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Conference should have teams greater than 1"() {
        when:
            def league = new League()
            Conference eastern = new Conference( name:'eastern', teams:[])
            eastern.league = league
            eastern.save(flush:true)
        then:
            !eastern.validate()
        when:
            eastern.teams << new Team()
            eastern.save(flush:true)
        then:
            !eastern.validate()
        when:
            eastern.teams << new Team()
            eastern.save(flush:true)
        then:
            eastern.validate()
    }
}
