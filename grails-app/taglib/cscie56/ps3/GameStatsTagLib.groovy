package cscie56.ps3

class GameStatsTagLib {
    static defaultEncodeAs = [taglib:'raw']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "stats"

    /**
     * @attr person
     */
    def total = { attrs, body ->

        def totalsMap = GameStatsService.getIndividualStatsInfo(attrs.player)

        def listOfTotals = []
        listOfTotals.add(totalsMap["totalMinutesPlayed"])
        listOfTotals.add(totalsMap["totalPoints"])
        listOfTotals.add(totalsMap["totalShotsMade"])
        listOfTotals.add(totalsMap["totalShotsAttempted"])
        listOfTotals.add(((double)totalsMap["totalShotsMade"]/totalsMap["totalShotsAttempted"]).round(1))
        listOfTotals.add(totalsMap["totalThreePointersMade"])
        listOfTotals.add(totalsMap["totalThreePointersAttempted"])
        listOfTotals.add(((double)totalsMap["totalThreePointersMade"]/totalsMap["totalThreePointersAttempted"]).round(1))
        listOfTotals.add(totalsMap["totalRebounds"])
        listOfTotals.add(totalsMap["totalAssists"])
        listOfTotals.add(totalsMap["totalSteals"])
        listOfTotals.add(totalsMap["totalPersonalFouls"])

        out << render(template: 'playerStatsRow', model:[statList: listOfTotals])
    }

    /**
     * @attr person
     */
    def average = { attrs, body ->
        int totalGames = 6;
        def totalsMap = GameStatsService.getIndividualStatsInfo(attrs.player)

        def listOfAverages = []
        listOfAverages.add(((double)totalsMap["totalMinutesPlayed"]/totalGames).round(1))
        listOfAverages.add(((double)totalsMap["totalPoints"]/totalGames).round(1))
        listOfAverages.add(((double)totalsMap["totalShotsMade"]/totalGames).round(1))
        listOfAverages.add(((double)totalsMap["totalShotsAttempted"]/totalGames).round(1))
        listOfAverages.add(((double)totalsMap["totalShotsMade"]/(totalGames*totalsMap["totalShotsAttempted"])).round(1))
        listOfAverages.add(((double)totalsMap["totalThreePointersMade"]/totalGames).round(1))
        listOfAverages.add(((double)totalsMap["totalThreePointersAttempted"]/totalGames).round(1))
        listOfAverages.add(((double)totalsMap["totalThreePointersMade"]/(totalGames*totalsMap["totalThreePointersAttempted"])).round(1))
        listOfAverages.add(((double)totalsMap["totalRebounds"]/totalGames).round(1))
        listOfAverages.add(((double)totalsMap["totalAssists"]/totalGames).round(1))
        listOfAverages.add(((double)totalsMap["totalSteals"]/totalGames).round(1))
        listOfAverages.add(((double)totalsMap["totalPersonalFouls"]/totalGames).round(1))

        out << render(template: 'playerStatsRow', model:[statList: listOfAverages])
    }
}
