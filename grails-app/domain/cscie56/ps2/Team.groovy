package cscie56.ps2

class Team implements Comparable{

    String name
    String results
    int homeWins
    int awayWins
    int homeLosses
    int awayLosses
    int homeTies
    int awayTies
    int scored
    int allowed

    static belongsTo = [conference:Conference]
    static hasMany = [players: Person, coaches:Person]

    static constraints = {
        name blank:false, unique:true
    }

    def getDelta() {
        int diff = scored - allowed
        if(diff > 0)
            "+" + diff
        else
            diff
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
        int losses = 0
        int ties = 0
        int length = 10
        if(results.length() < length)
            length = results.length()

        for(int i = 0; i < length; ++ i) {
            if(results[i] == "W"){
                ++wins
            }
            else if(results[i] == "L"){
                ++losses
            }
            else if(results[i] == "T"){
                ++ties
            }
        }
        ""+wins+"-"+losses+"-"+ties
    }

    //method to get percentage
    def getPercentage() {
        String.format("%.1f",100*(homeWins + awayWins )/(homeWins + awayWins + homeLosses + awayLosses))
    }


    //compareTo method to sort list of team
    int compareTo(other) {
        if(homeWins + awayWins > other.homeWins + other.awayWins)
            return -1
        else if(homeWins + awayWins < other.homeWins + other.awayWins)
            return 1
        else {
            if(homeTies+awayTies > other.homeTies+other.awayTies)
                return -1
            else if(homeTies+awayTies < other.homeTies+other.awayTies)
                return 1
            else
                return 0
        }
    }
}
