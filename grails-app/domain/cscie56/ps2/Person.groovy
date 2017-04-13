package cscie56.ps2

import cscie56.ps3.GameStats
import cscie56.ps5.User

class Person {

    String firstName
    String lastName
    String role

    User user

    static belongsTo = [team:Team]
    static hasMany = [gameStats: GameStats]

    static constraints = {
        firstName blank: false
        lastName blank:false
        role inList: ["coach", "player"]
    }
}
