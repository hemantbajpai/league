package cscie56.ps2

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Person role should be coach or player"() {
        when:
            Team team = new Team()
            Person person = new Person(firstName: "first", lastName: "last", role: "coach", bio: "xyz", birthDate: new Date(), birthPlace: "Boston, MA", height: "6\'11\"", weight: "190", universityAttended: "Harvard")
            person.team = team
            person.save(flush:true)
        then:
            person.validate()
        when:
            person.role = "player"
            person.save(flush:true)
        then:
            person.validate()
        when:
            person.role = "person"
            person.save(flush:true)
        then:
            !person.validate()
    }

    void "Person first name can not be blank"() {
        when:
            Team team = new Team()
            Person person = new Person(firstName: "", lastName: "last", role: "coach", bio: "xyz", birthDate: new Date(), birthPlace: "Boston, MA", height: "6\'11\"", weight: "190", universityAttended: "Harvard")
            person.team = team
            person.save(flush: true)
        then:
            !person.validate()
        when:
            person.firstName = "first"
            person.save(flush:true)
        then:
            person.validate()
    }

    void "Person last name can not be blank"() {
        when:
            Team team = new Team()
            Person person = new Person(firstName: "first", lastName: "", role: "coach", bio: "xyz", birthDate: new Date(), birthPlace: "Boston, MA", height: "6\'11\"", weight: "190", universityAttended: "Harvard")
            person.team = team
            person.save(flush: true)
        then:
            !person.validate()
        when:
            person.lastName = "last"
            person.save(flush:true)
        then:
            person.validate()
    }

    void "Person should belong to a team"() {
        when:
            Person person = new Person(firstName: "first", lastName: "last", role: "coach", bio: "xyz", birthDate: new Date(), birthPlace: "Boston, MA", height: "6\'11\"", weight: "190", universityAttended: "Harvard")
            person.save(flush: true)
        then:
            !person.validate()
        when:
            Team team = new Team()
            person.team = team
            person.save(flush:true)
        then:
            person.validate()
    }
}
