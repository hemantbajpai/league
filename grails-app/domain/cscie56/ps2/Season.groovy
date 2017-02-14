package cscie56.ps2

class Season {

    String name
    Date startDate
    Date endDate

    static belongsTo = [league: League]
    static hasMany = [games:Game]

    static constraints = {
        name blank:false, unique: true
        startDate blank:false
        endDate blank:false
    }
}
