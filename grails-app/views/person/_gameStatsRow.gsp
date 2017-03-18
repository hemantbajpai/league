<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div class="container">

    <g:set var="gameStat" value="${bean}"/>
    <tr>
        <td>${gameStat.game.awayTeam.name} @ ${gameStat.game.homeTeam.name}</td>
        <td>${gameStat.minutesPlayed}</td>
        <td>${gameStat.points}</td>
        <td>${gameStat.shotsMade}</td>
        <td>${gameStat.shotsAttempted}</td>
        <td>${gameStat.shotsPercentage()}</td>
        <td>${gameStat.threePointersMade}</td>
        <td>${gameStat.threePointersAttempted}</td>
        <td>${gameStat.threePointerPercentage()}</td>
        <td>${gameStat.rebounds}</td>
        <td>${gameStat.assists}</td>
        <td>${gameStat.steals}</td>
        <td>${gameStat.personalFouls}</td>
    </tr>
</div>