<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div>
    <g:set var="map" value="${maps}"/>

    <table>
        <tr>
            <th class="col-sm-2 col-xs-2">Team</th>
            <th class="col-sm-1 col-xs-2">W</th>
            <th class="col-sm-1 col-xs-2">L</th>
            <th class="col-sm-1 col-xs-2">T</th>
            <th class="col-sm-1 col-xs-2">%</th>
            <th class="col-sm-1 hidden-xs">GB</th>
            <th class="col-sm-1 hidden-xs">HOME</th>
            <th class="col-sm-1 hidden-xs">ROAD</th>
            <th class="col-sm-1 col-xs-2">L10</th>
            <th class="col-sm-1 hidden-xs">Streak</th>
            <th class="col-sm-1 hidden-xs">Delta</th>
        </tr>
        <g:each var="map" in="${maps}">
            <tr>
                <td class="col-sm-2 col-xs-2">${map.key.name}</td>
                <td class="col-sm-1 col-xs-2">${map.value[1]}</td>
                <td class="col-sm-1 col-xs-2">${map.value[2]}</td>
                <td class="col-sm-1 col-xs-2">${map.value[3]}</td>
                <td class="col-sm-1 col-xs-2">${map.value[4]}</td>
                <td class="col-sm-1 hidden-xs">${map.value[5]}</td>
                <td class="col-sm-1 hidden-xs">${map.value[6]}</td>
                <td class="col-sm-1 hidden-xs">${map.value[7]}</td>
                <td class="col-sm-1 col-xs-2">${map.value[8]}</td>
                <td class="col-sm-1 hidden-xs">${map.value[9]}</td>
                <td class="col-sm-1 hidden-xs">${map.value[10]}</td>
            </tr>
        </g:each>
    </table>
</div>