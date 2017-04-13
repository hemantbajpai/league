package cscie56.ps3

import cscie56.ps2.League
import cscie56.ps5.Role
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured([Role.ROLE_ANONYMOUS, Role.ROLE_USER, Role.ROLE_ADMIN])
class GameStatsController {

    GameStatsService gameStatsService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond GameStats.list(params), model:[gameStatsCount: GameStats.count()]
    }

    def leaderboard() {
        GameStats gameStats = GameStats.first()
        def allMaps = GameStatsService.getLeaderboardInfo(gameStats.game.season.league)
        render view: 'leaderboard', model:[points: allMaps["pointsMap"].sort{-it.value}, assists: allMaps["assistsMap"].sort{-it.value}, rebounds: allMaps["reboundsMap"].sort{-it.value}, steals: allMaps["stealsMap"].sort{-it.value}, threePointersMade: allMaps["threePointersMadeMap"].sort{-it.value}]
    }

    def leaderboardShowAll() {
        GameStats gameStats = GameStats.first()
        def allMaps = GameStatsService.getLeaderboardInfo(gameStats.game.season.league)
        render view: 'leaderboardShowAll', model:[points: allMaps["pointsMap"].sort{-it.value}, assists: allMaps["assistsMap"].sort{-it.value}, rebounds: allMaps["reboundsMap"].sort{-it.value}, steals: allMaps["stealsMap"].sort{-it.value}, threePointersMade: allMaps["threePointersMadeMap"].sort{-it.value}]
    }

    def show(GameStats gameStats) {
        respond gameStats
    }

    def create() {
        respond new GameStats(params)
    }

    @Transactional
    def save(GameStats gameStats) {
        if (gameStats == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (gameStats.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond gameStats.errors, view:'create'
            return
        }

        gameStats.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'gameStats.label', default: 'GameStats'), gameStats.id])
                redirect gameStats
            }
            '*' { respond gameStats, [status: CREATED] }
        }
    }

    def edit(GameStats gameStats) {
        respond gameStats
    }

    @Transactional
    def update(GameStats gameStats) {
        if (gameStats == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (gameStats.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond gameStats.errors, view:'edit'
            return
        }

        gameStats.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'gameStats.label', default: 'GameStats'), gameStats.id])
                redirect gameStats
            }
            '*'{ respond gameStats, [status: OK] }
        }
    }

    @Transactional
    def delete(GameStats gameStats) {

        if (gameStats == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        gameStats.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'gameStats.label', default: 'GameStats'), gameStats.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'gameStats.label', default: 'GameStats'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
