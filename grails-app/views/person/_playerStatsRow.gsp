<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div class="container">

    <g:set var="statList" value="${statList}"/>

    <table>
        <thead>
            <tr>
                <th>MIN</th>
                <th>PTS</th>
                <th>FGM</th>
                <th>FGA</th>
                <th>FG%</th>
                <th>3PM</th>
                <th>3PA</th>
                <th>3P%</th>
                <th>REB</th>
                <th>AST</th>
                <th>STL</th>
                <th>PF</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${statList[0]}</td>
                <td>${statList[1]}</td>
                <td>${statList[2]}</td>
                <td>${statList[3]}</td>
                <td>${statList[4]}</td>
                <td>${statList[5]}</td>
                <td>${statList[6]}</td>
                <td>${statList[7]}</td>
                <td>${statList[8]}</td>
                <td>${statList[9]}</td>
                <td>${statList[10]}</td>
                <td>${statList[11]}</td>
            </tr>
        </tbody>
    </table>
</div>