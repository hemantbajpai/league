package pset2

import cscie56.ps2.Conference
import cscie56.ps2.Game
import cscie56.ps2.League
import cscie56.ps2.Season
import cscie56.ps2.Team

class BootStrap {

    def init = { servletContext ->
        League league = new League()

        Conference eastern = new Conference(teams: [])
        eastern.league = league

        Conference western = new Conference(teams: [])
        western.league = league

        Team clevelandCavaliers = new Team(name: 'Cleveland Cavaliers')
        clevelandCavaliers.conference = eastern
        eastern.teams << clevelandCavaliers

        Team bostonCeltics = new Team(name: 'Boston Celtics')
        bostonCeltics.conference = eastern
        eastern.teams << bostonCeltics

        Team washingtonWizards = new Team(name: 'Washington Wizards')
        washingtonWizards.conference = eastern
        eastern.teams << washingtonWizards

        Team torontoRaptors = new Team(name: 'Toronto Raptors')
        torontoRaptors.conference = eastern
        eastern.teams << torontoRaptors

        Team californiaStateWarriors = new Team(name: 'California State Warriors')
        californiaStateWarriors.conference = western
        western.teams << californiaStateWarriors

        Team sanAntoniaSpurs = new Team(name: 'San Antonio Spurs')
        sanAntoniaSpurs.conference = western
        western.teams << sanAntoniaSpurs

        Team houstonRockets = new Team(name: 'Houston Rockets')
        houstonRockets.conference = western
        western.teams << houstonRockets

        Team utahJazz = new Team(name: 'Utah Jazz')
        utahJazz.conference = western
        western.teams << utahJazz

        league.conferences = [] << eastern << western

        Season season = new Season(name: '2017', startDate: new Date(2017, 1, 1), endDate: new Date(2017, 2, 12))
        season.league = league
        league.seasons = [] << season

        league.conferences.each { conference ->
            for(int i = 0; i < conference.teams.size(); ++i) {
                for (int j = 0; j < conference.teams.size(); ++j) {
                    if (i == j)
                        continue;

                    Game game = new Game(homeTeam: conference.teams[i], awayTeam: conference.teams[j], date: new Date(), location: conference.teams[i].name)
                    game.generateOutput()
                    game.season = season
                    //season.games << game
                    //game.save()
                }
            }
        }
        league.save()
    }
    def destroy = {
    }
}
