package cscie56.ps2

class Conference {
    List teams
    static belongsTo = [league:League]
    static hasMany = [teams:Team]

    static constraints = {
        teams minSize: 2
    }

}
