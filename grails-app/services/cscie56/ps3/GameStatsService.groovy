package cscie56.ps3

import cscie56.ps2.League
import cscie56.ps2.Person
import grails.transaction.Transactional

@Transactional
class GameStatsService {

    def static getIndividualStatsInfo(Person player) {

        int totalMinutesPlayed = 0, totalPoints = 0, totalAssists = 0, totalRebounds = 0
        int totalSteals = 0, totalShotsMade = 0, totalShotsAttempted = 0
        int totalThreePointersMade= 0, totalThreePointersAttempted = 0, totalPersonalFouls = 0
        player.gameStats.each{gameStats ->
            totalMinutesPlayed += gameStats.minutesPlayed
            totalPoints += gameStats.points
            totalAssists += gameStats.assists
            totalRebounds += gameStats.rebounds
            totalSteals += gameStats.steals
            totalShotsMade += gameStats.shotsMade
            totalShotsAttempted += gameStats.shotsAttempted
            totalThreePointersMade += gameStats.threePointersMade
            totalThreePointersAttempted += gameStats.threePointersAttempted
            totalPersonalFouls += gameStats.personalFouls
        }
        return [totalMinutesPlayed: totalMinutesPlayed, totalPoints: totalPoints, totalAssists: totalAssists,
                totalRebounds: totalRebounds, totalSteals: totalSteals, totalShotsMade: totalShotsMade,
                totalShotsAttempted:totalShotsAttempted, totalThreePointersMade:totalThreePointersMade,
                totalThreePointersAttempted:totalThreePointersAttempted, totalPersonalFouls:totalPersonalFouls]
    }

    def static getLeaderboardInfo(League league) {

        def playerList = []
        league.conferences.each{ conference ->
            conference.teams.each {team ->
                team.players.each {player ->
                    playerList.add(player)
                }
            }
        }

        def pointsMap = [:]
        def assistsMap = [:]
        def reboundsMap = [:]
        def stealsMap = [:]
        playerList.each{player ->
            int points = 0, assists = 0, rebounds = 0, steals = 0
            player.gameStats.each{gameStats ->
                points += gameStats.points
                assists += gameStats.assists
                rebounds += gameStats.rebounds
                steals += gameStats.steals
            }
            pointsMap.put(player, points)
            assistsMap.put(player, assists)
            reboundsMap.put(player, rebounds)
            stealsMap.put(player, steals)
        }

        return [pointsMap: pointsMap, assistsMap: assistsMap, reboundsMap: reboundsMap, stealsMap: stealsMap]
    }
}
