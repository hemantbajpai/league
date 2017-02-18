package cscie56.ps2

import grails.test.mixin.*
import spock.lang.*

@TestFor(SeasonController)
@Mock(Season)
class SeasonControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        League league = new League()
        Conference eastern = new Conference(name: "eastern", teams: [])
        Team team1 = new Team(name:"team1", homeWins: 1, awayWins: 1, homeLosses: 1, awayLosses: 1, ties: 0, results: "WWLL")
        Team team2 = new Team(name:"team2", homeWins: 1, awayWins: 1, homeLosses: 1, awayLosses: 1, ties: 0, results: "LLWW")
        eastern.teams << team1 << team2
        Conference western = new Conference(name: "western", teams: [])
        Team team3 = new Team(name:"team3", homeWins: 1, awayWins: 1, homeLosses: 1, awayLosses: 1, ties: 0, results: "WWLL")
        Team team4 = new Team(name:"team4", homeWins: 1, awayWins: 1, homeLosses: 1, awayLosses: 1, ties: 0, results: "LLWW")
        western.teams << team3 << team4
        league.conferences = [] << eastern << western

        params << [name:'2017', startDate:Date.parse("MM/dd/yyyy", "1/1/2017"), endDate:Date.parse("MM/dd/yyyy", "1/31/2017"), league: league, games: []]
    }

    void "Test the showStandings return correct model" () {

        when:"The showStandings is executed"
            populateValidParams(params)
            def season = new Season(params)
            controller.showStandings(season)

        then: "The model is correct"
            model.westResults
            model.eastResults
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.seasonList
            model.seasonCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.season!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def season = new Season()
            season.validate()
            controller.save(season)

        then:"The create view is rendered again with the correct model"
            model.season!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            season = new Season(params)

            controller.save(season)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/season/show/1'
            controller.flash.message != null
            Season.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def season = new Season(params)
            controller.show(season)

        then:"A model is populated containing the domain instance"
            model.season == season
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def season = new Season(params)
            controller.edit(season)

        then:"A model is populated containing the domain instance"
            model.season == season
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/season/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def season = new Season()
            season.validate()
            controller.update(season)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.season == season

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            season = new Season(params).save(flush: true)
            controller.update(season)

        then:"A redirect is issued to the show action"
            season != null
            response.redirectedUrl == "/season/show/$season.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/season/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def season = new Season(params).save(flush: true)

        then:"It exists"
            Season.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(season)

        then:"The instance is deleted"
            Season.count() == 0
            response.redirectedUrl == '/season/index'
            flash.message != null
    }
}
