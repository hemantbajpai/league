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
    int threePointersAttempted
    int threePointersMade
    int personalFouls

    static belongsTo = [game:Game, player:Person]

    static constraints = {
        shotsMade validator: {val, obj, errors ->
            if(val > obj.shotsAttempted) {
                errors.rejectValue('shotsMade', 'shotsMadeLessThanAttempted')
            }
        }
        threePointersMade validator: {val, obj, errors ->
            if(val > obj.threePointersAttempted) {
                errors.rejectValue('threePointersMade', 'threePointersMadeLessThanAttempted')
            }
        }
        points validator: {val, obj, errors ->
            if(val != 2*obj.shotsMade+3*obj.threePointersMade) {
                errors.rejectValue('points', 'pointsShouldBeThis')
            }
        }
    }

    def shotsPercentage() {
        if(shotsAttempted == 0)
            "0.0"
        else
            String.format("%.1f",(100*shotsMade)/(shotsAttempted))
    }

    def threePointerPercentage() {
        if(threePointersAttempted == 0)
            "0.0"
        else
            String.format("%.1f",(100*threePointersMade )/(threePointersAttempted))
    }

    def generateOutput() {
        Random rand = new Random()
        minutesPlayed = rand.nextInt(20)

        assists = rand.nextInt(15)
        rebounds = rand.nextInt(20)
        steals = rand.nextInt(5)
        shotsAttempted = 1+rand.nextInt(25)
        shotsMade = rand.nextInt(shotsAttempted)
        threePointersAttempted = 1+rand.nextInt(10)
        threePointersMade = rand.nextInt(threePointersAttempted)
        personalFouls = rand.nextInt(5)

        points = 2*shotsMade + 3*threePointersMade
    }
}
