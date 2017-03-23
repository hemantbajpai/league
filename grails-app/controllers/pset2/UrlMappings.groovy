package pset2

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/leaderboard"(controller: "GameStats", action: "leaderboard")
        "/leaderboardShowAll"(controller: "GameStats", action: "leaderboardShowAll")
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
