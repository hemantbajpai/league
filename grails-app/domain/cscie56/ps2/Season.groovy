package cscie56.ps2

class Season {

    String name
    Date startDate
    Date endDate

    static belongsTo = [league: League]
    static hasMany = [games:Game]

    static constraints = {
        name blank:false, unique: true
        endDate validator: {val, obj, errors ->
            if(val < obj.startDate) {
                errors.rejectValue('endDate', 'endDateBeforeStartDate')
            }
        }
    }
}
