package cscie56.ps2

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Season)
class SeasonSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "name should be unique "() {
        when:
            League league = new League()
            Season season = new Season(name: '2017', startDate: Date.parse("MM/dd/yyyy", "1/1/2017"), endDate: Date.parse("MM/dd/yyyy", "1/31/2017"))
            season.league = league
            season.save(flush:true)
            Season season1 = new Season(name: '2017', startDate: Date.parse("MM/dd/yyyy", "1/1/2017"), endDate: Date.parse("MM/dd/yyyy", "1/31/2017"))
            season1.league = league
            season1.save(flush:true)
        then:
            season.validate()
            !season1.validate()
        when:
            season1.name = '2016'
            season1.save(flush:true)
        then:
            season1.validate()
    }

    void "name should not be blank and enddate should be after startdate"() {
        when:
            League league = new League()
            Season season = new Season(name:name, startDate: Date.parse("MM/dd/yyyy", startDate), endDate: Date.parse("MM/dd/yyyy", endDate))
            season.league = league
        then:
            season.validate() == result
        where:
        name         |      startDate         |        endDate        |     result
        '2017'       |      "1/1/2017"        |       "1/31/2017"     |     true
        ''           |      "1/1/2017"        |       "1/31/2017"     |     false
        '2016'       |      "1/31/2017"       |       "1/1/2017"      |     false
    }
}
