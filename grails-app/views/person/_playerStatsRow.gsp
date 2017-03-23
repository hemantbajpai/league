<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div class="container">

    <g:set var="statList" value="${statList}"/>

    <table>
        <thead>
            <tr>
                <th class="col-sm-1 col-xs-2">GP</th>
                <th class="col-sm-1 col-xs-2">MP</th>
                <th class="col-sm-1 col-xs-2">P</th>
                <th class="col-sm-1 col-xs-2">A</th>
                <th class="col-sm-1 col-xs-2">R</th>
                <th class="col-sm-1 col-xs-2">ST</th>
                <th class="col-sm-1 hidden-xs">SM</th>
                <th class="col-sm-1 hidden-xs">SA</th>
                <th class="col-sm-1 hidden-xs">S%</th>
                <th class="col-sm-1 hidden-xs">3PM</th>
                <th class="col-sm-1 hidden-xs">3PA</th>
                <th class="col-sm-1 hidden-xs">3P%</th>
                <th class="col-sm-1 hidden-xs">PF</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="col-sm-1 col-xs-2">${statList[0]}</td>
                <td class="col-sm-1 col-xs-2">${statList[1]}</td>
                <td class="col-sm-1 col-xs-2">${statList[2]}</td>
                <td class="col-sm-1 col-xs-2">${statList[3]}</td>
                <td class="col-sm-1 col-xs-2">${statList[4]}</td>
                <td class="col-sm-1 col-xs-2">${statList[5]}</td>
                <td class="col-sm-1 hidden-xs">${statList[6]}</td>
                <td class="col-sm-1 hidden-xs">${statList[7]}</td>
                <td class="col-sm-1 hidden-xs">${statList[8]}</td>
                <td class="col-sm-1 hidden-xs">${statList[9]}</td>
                <td class="col-sm-1 hidden-xs">${statList[10]}</td>
                <td class="col-sm-1 hidden-xs">${statList[11]}</td>
                <td class="col-sm-1 hidden-xs">${statList[12]}</td>
            </tr>
        </tbody>
    </table>
</div>