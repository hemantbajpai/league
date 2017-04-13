package pset2

import cscie56.ps2.Conference
import cscie56.ps2.Game
import cscie56.ps2.League
import cscie56.ps2.Person
import cscie56.ps2.Season
import cscie56.ps2.Team
import cscie56.ps3.GameStats
import cscie56.ps5.BlogEntry
import cscie56.ps5.Role
import cscie56.ps5.User
import cscie56.ps5.UserRole

class BootStrap {

    def init = { servletContext ->

        User admin = new User(username: 'admin', password: 'supersecret', bio: 'Administratot', birthDate: Date.parse("MM-dd-yyyy", "10-04-1984"), birthPlace: 'Boston', height: '6\'2\"', weight: '200', universityAttended: 'Harvard', blogEntries: [], enabled: true)
        admin.save(flush:true,failOnError:true)

        User user1 = new User(username:'user1',password: 'secret', bio:'Great player', height: '6\'11\"', weight: 253, birthDate: Date.parse("MM-dd-yyyy", "03-11-1993"), birthPlace: 'Boston, MA', universityAttended: 'Harvard', blogEntries: [], enabled: true )
        user1.save(flush:true,failOnError:true)

        User user2 = new User(username:'user2',password: 'secret', bio:'Awesome dude', height: '6\'8\"', weight: 240, birthDate: Date.parse("MM-dd-yyyy", "05-29-1984"), birthPlace: 'Boston, MA', universityAttended: 'MIT', blogEntries: [], enabled: true )
        user2.save(flush:true,failOnError:true)

        User user3 = new User(username:'user3',password: 'secret', bio:'Nice dude', height: '6\'3\"', weight: 193, birthDate: Date.parse("MM-dd-yyyy", "03-23-1992"), birthPlace: 'Boston, MA', universityAttended: 'BU', blogEntries: [], enabled: true )
        user3.save(flush:true,failOnError:true)

        User user4 = new User(username:'user4',password: 'secret', bio:'Awesome player', height: '6\'8\"', weight: 199, birthDate: Date.parse("MM-dd-yyyy", "02-23-1995"), birthPlace: 'Boston, MA', universityAttended: 'BU', blogEntries: [], enabled: true )
        user4.save(flush:true,failOnError:true)

        User user5 = new User(username:'user5',password: 'secret', bio:'Nice player', height: '7\'0\"', weight: 265, birthDate: Date.parse("MM-dd-yyyy", "06-13-1989"), birthPlace: 'Boston, MA', universityAttended: 'BU', blogEntries: [], enabled: true )
        user5.save(flush:true,failOnError:true)

        User user6 = new User(username:'user6',password: 'secret', bio:'Awesome guy', height: '6\'11\"', weight: 270, birthDate: Date.parse("MM-dd-yyyy", "08-13-1990"), birthPlace: 'Boston, MA', universityAttended: 'BU', blogEntries: [], enabled: true )
        user6.save(flush:true,failOnError:true)

        User user7 = new User(username:'user7',password: 'secret', bio:'Great guy', height: '6\'10\"', weight: 223, birthDate: Date.parse("MM-dd-yyyy", "04-08-1994"), birthPlace: 'Boston, MA', universityAttended: 'BU', blogEntries: [], enabled: true )
        user7.save(flush:true,failOnError:true)

        User user8 = new User(username:'user8',password: 'secret', bio:'xyz', height: '6\'4\"', weight: 190, birthDate: Date.parse("MM-dd-yyyy", "10-21-1990"), birthPlace: 'Boston, MA', universityAttended: 'BU', blogEntries: [], enabled: true )
        user8.save(flush:true,failOnError:true)

        Role adminRole = new Role(authority: Role.ROLE_ADMIN)
        adminRole.save(flush:true,failOnError:true)
        Role userRole = new Role(authority: Role.ROLE_USER)
        userRole.save(flush:true,failOnError:true)

        UserRole.create(admin, adminRole).save(flush:true, failOnError:true)
        UserRole.create(admin, userRole).save(flush:true, failOnError:true)
        UserRole.create(user1, userRole).save(flush:true, failOnError:true)
        UserRole.create(user2, userRole).save(flush:true, failOnError:true)
        UserRole.create(user3, userRole).save(flush:true, failOnError:true)
        UserRole.create(user4, userRole).save(flush:true, failOnError:true)
        UserRole.create(user5, userRole).save(flush:true, failOnError:true)
        UserRole.create(user6, userRole).save(flush:true, failOnError:true)
        UserRole.create(user7, userRole).save(flush:true, failOnError:true)
        UserRole.create(user8, userRole).save(flush:true, failOnError:true)


        League league = new League()

        Conference eastern = new Conference(teams: [], name:'eastern')
        eastern.league = league

        Conference western = new Conference(teams: [], name:'western')
        western.league = league

        Team clevelandCavaliers = new Team(name: 'Cleveland Cavaliers')
        clevelandCavaliers.conference = eastern
        eastern.teams << clevelandCavaliers

        Person anthony = new Person(firstName: 'Anthony', lastName: 'Davis', role:'player', user: user1)
        anthony.team = clevelandCavaliers
        anthony.gameStats = []
        clevelandCavaliers.players = [] << anthony

        Team bostonCeltics = new Team(name: 'Boston Celtics')
        bostonCeltics.conference = eastern
        eastern.teams << bostonCeltics

        Person carmelo = new Person(firstName: 'Carmelo', lastName: 'Anthony', role:'player', user: user2)
        carmelo.team = bostonCeltics
        carmelo.gameStats = []
        bostonCeltics.players = [] << carmelo

        Team washingtonWizards = new Team(name: 'Washington Wizards')
        washingtonWizards.conference = eastern
        eastern.teams << washingtonWizards

        Person kyrie = new Person(firstName: 'Kyrie', lastName: 'Irving', role:'player', user: user3)
        kyrie.team = washingtonWizards
        kyrie.gameStats = []
        washingtonWizards.players = [] << kyrie

        Team torontoRaptors = new Team(name: 'Toronto Raptors')
        torontoRaptors.conference = eastern
        eastern.teams << torontoRaptors

        Person andrew = new Person(firstName: 'Andrew', lastName: 'Wiggins', role:'player', user: user4)
        andrew.team = torontoRaptors
        andrew.gameStats = []
        torontoRaptors.players = [] << andrew

        Team californiaStateWarriors = new Team(name: 'California State Warriors')
        californiaStateWarriors.conference = western
        western.teams << californiaStateWarriors

        Person hassan = new Person(firstName: 'Hassan', lastName: 'Whiteside', role:'player', user: user5)
        hassan.team = californiaStateWarriors
        hassan.gameStats = []
        californiaStateWarriors.players = [] << hassan

        Team sanAntoniaSpurs = new Team(name: 'San Antonio Spurs')
        sanAntoniaSpurs.conference = western
        western.teams << sanAntoniaSpurs

        Person demarcus = new Person(firstName: 'DeMarcus', lastName: 'Cousins', role:'player', user: user6)
        demarcus.team = sanAntoniaSpurs
        demarcus.gameStats = []
        sanAntoniaSpurs.players = [] << demarcus

        Team houstonRockets = new Team(name: 'Houston Rockets')
        houstonRockets.conference = western
        western.teams << houstonRockets

        Person derio = new Person(firstName: 'Dario', lastName: 'Saric', role:'player', user: user7)
        derio.team = houstonRockets
        derio.gameStats = []
        houstonRockets.players = [] << derio

        Team utahJazz = new Team(name: 'Utah Jazz')
        utahJazz.conference = western
        western.teams << utahJazz

        Person ricky = new Person(firstName: 'Ricky', lastName: 'Rubio', role:'player', user: user8)
        ricky.team = utahJazz
        ricky.gameStats = []
        utahJazz.players = [] << ricky

        league.conferences = [] << eastern << western

        Season season = new Season(name: '2017', startDate:Date.parse("MM/dd/yyyy", "1/1/2017"), endDate:Date.parse("MM/dd/yyyy", "1/31/2017"))
        season.league = league
        league.seasons = [] << season
        season.games = []

        Random rand = new Random()

        league.conferences.each{ conference ->
            for(int i = 0; i < conference.teams.size(); ++i) {
                for (int j = 0; j < conference.teams.size(); ++j) {
                    if (i == j)
                        continue

                    String date = "1/"+(rand.nextInt(30)+1)+"/2017"
                    Game game = new Game(homeTeam: conference.teams[i], awayTeam: conference.teams[j], date: Date.parse("MM/dd/yyyy", date), location: conference.teams[i].name)
                    game.gameStats = []
                    game.generateOutput()
                    game.season = season
                    season.games << game

                    def playersInGame = []
                    conference.teams[i].players.each { player ->
                        playersInGame.add(player)
                    }
                    conference.teams[j].players.each { player ->
                        playersInGame.add(player)
                    }

                    playersInGame.each {player ->
                        GameStats gameStats = new GameStats()
                        gameStats.game = game
                        gameStats.player = player
                        gameStats.generateOutput()
                        player.gameStats << gameStats
                        game.gameStats << gameStats
                    }
                }
            }
        }

        league.save()
    }
    def destroy = {
    }
}
