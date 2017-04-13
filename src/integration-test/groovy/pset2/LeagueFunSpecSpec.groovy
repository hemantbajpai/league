package pset2

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class LeagueFunSpecSpec extends GebSpec {

    def setup() {

    }

    def cleanup() {
    }

    void "test something"() {
        when:"The home page is visited"
            go '/'

        then:"The title is correct"
        	title == "Welcome to Grails"
    }

    void "create blog"() {
        when: "stat page is visited"
            go '/person/stats/1'


        then:"The title is correct"
            title == "Show Season"
    }
}
