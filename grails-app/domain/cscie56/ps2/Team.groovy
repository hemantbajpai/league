package cscie56.ps2

class Team implements Comparable{

    String name
    String results
    int homeWins
    int awayWins
    int homeLosses
    int awayLosses
    int ties

    static belongsTo = [conference:Conference]
    static hasMany = [players: Person, coaches:Person]

    static constraints = {
        name blank:false, unique:true
    }

    //method to get streak
    def getStreak() {
        int count  = 1;
        String firstChar = results[0]
        for(int i = 1; i < results.length(); ++ i) {
            if(results[i] == firstChar){
                ++count
            }
            else {
                break;
            }
        }
        firstChar+count
    }

    //method to get last 10
    def getLastTen() {
        int wins = 0
        int losses
        int length = 10
        if(results.length() < length)
            length = results.length()

        for(int i = 0; i < length; ++ i) {
            if(results[i] == "W"){
                ++wins
            }
            else if(results[i] == "L"){
                ++losses;
            }
        }
        ""+wins+"-"+losses
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
