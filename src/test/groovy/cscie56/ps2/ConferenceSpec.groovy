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
            league.conferences = []
            league.conferences << new Conference()
            league.conferences << new Conference()
            league.save(flush:true)
        then:
            league.validate()
    }
}
