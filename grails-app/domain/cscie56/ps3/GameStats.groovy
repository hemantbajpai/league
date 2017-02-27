package cscie56.ps3

import cscie56.ps2.Game
import cscie56.ps2.Person

class GameStats {

    int minutesPlayed
    int points
    int assists
    int rebounds
    int steals
    int shotsAttempted
    int shotsMade
    //double shotsPercentage
    int threePointersAttempted
    int threePointersMade
    //double threePointerPercentage
    int personalFouls

    static belongsTo = [game:Game, player:Person]

    static constraints = {
    }

    def shotsPercentage() {
        if(shotsAttempted == 0)
            "0.0"
        else
            String.format("%.1f",(100*shotsMade)/(shotsAttempted))
            //(100*((double)shotsMade)/((double)shotsAttempted)).round(1)
    }

    def threePointerPercentage() {
        if(threePointersAttempted == 0)
            "0.0"
        else
            String.format("%.1f",(100*threePointersMade )/(threePointersAttempted))
            //(100*((double)threePointersMade)/((double)threePointersAttempted)).round(1)
    }

    def generateOutput() {
        Random rand = new Random()
        minutesPlayed = rand.nextInt(20)

        assists = rand.nextInt(15)
        rebounds = rand.nextInt(20)
        steals = rand.nextInt(5)
        shotsAttempted = 1+rand.nextInt(25)
        shotsMade = rand.nextInt(shotsAttempted)
        //shotsPercentage = shotsPercentage()
        threePointersAttempted = 1+rand.nextInt(10)
        threePointersMade = rand.nextInt(threePointersAttempted)
        //threePointerPercentage = threePointerPercentage()
        personalFouls = rand.nextInt(5)

        points = 2*shotsMade + 3*threePointersMade
    }
}
