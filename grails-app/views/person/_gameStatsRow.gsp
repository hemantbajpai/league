<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div class="container">

    <g:set var="gameStat" value="${bean}"/>
    <tr>
        <td class="col-sm-1 col-xs-2">${gameStat.game.awayTeam.name} (${gameStat.game.awayTeamScore}) @ ${gameStat.game.homeTeam.name} (${gameStat.game.homeTeamScore})</td>
        <td class="col-sm-1 col-xs-2">${gameStat.minutesPlayed}</td>
        <td class="col-sm-1 col-xs-2">${gameStat.points}</td>
        <td class="col-sm-1 col-xs-2">${gameStat.assists}</td>
        <td class="col-sm-1 col-xs-2">${gameStat.rebounds}</td>
        <td class="col-sm-1 col-xs-2">${gameStat.steals}</td>
        <td class="col-sm-1 hidden-xs">${gameStat.shotsMade}</td>
        <td class="col-sm-1 hidden-xs">${gameStat.shotsAttempted}</td>
        <td class="col-sm-1 hidden-xs">${gameStat.shotsPercentage()}</td>
        <td class="col-sm-1 hidden-xs">${gameStat.threePointersMade}</td>
        <td class="col-sm-1 hidden-xs">${gameStat.threePointersAttempted}</td>
        <td class="col-sm-1 hidden-xs">${gameStat.threePointerPercentage()}</td>
        <td class="col-sm-1 hidden-xs">${gameStat.personalFouls}</td>
    </tr>
</div>