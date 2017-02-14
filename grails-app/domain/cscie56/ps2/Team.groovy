package cscie56.ps2

class Team implements Comparable{

    String name

    int homeWins
    int awayWins
    int homeLosses
    int awayLosses
    int ties
    int scored
    int allowed
    String streakStr
    int streakCount

    static belongsTo = [conference:Conference]
    static hasMany = [players: Person, coaches:Person]

    static constraints = {
        name blank:false, unique:true
    }

    //method to get percentage
    def getPercentage() {
        String.format("%.3f",(homeWins + awayWins )/(homeWins + awayWins + homeLosses + awayLosses))
    }


    //compareTo method to sort list of team
    int compareTo(other) {
        if(homeWins + awayWins > other.homeWins + other.awayWins)
            return -1
        else if(homeWins + awayWins < other.homeWins + other.awayWins)
            return 1
        else {
            if(ties > other.ties)
                return -1
            else if(ties < other.ties)
                return 1
            else
                return 0
        }
    }
}
