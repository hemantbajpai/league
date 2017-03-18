package cscie56.ps2

import cscie56.ps3.GameStats

class Person {

    String firstName
    String lastName
    String role

    String bio
    Date birthDate
    String birthPlace
    String height
    double weight
    String universityAttended

    static belongsTo = [team:Team]
    static hasMany = [gameStats: GameStats]

    static constraints = {
        firstName blank: false
        lastName blank:false
        role inList: ["coach", "player"]
        height (matches: "^(\\d{1,5})\\'((\\s?)(-?)(\\s?)([0-9]|(1[0-1]))\\\")?\$")
    }
}
