<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<div>
    <g:set var="list" value="${list}"/>

    <table>
        <tbody>
            <tr>
                <td><a href="/person/stats/${list.keySet()[0].id}"><img src="${resource(dir:"images", file: "${list.keySet()[0].firstName + ".png"}") }" style="width:24px;height:24px;border:0;"/>${list.keySet()[0].firstName} ${list.keySet()[0].lastName}</a></td>
                <td>${list.values()[0]}</td>
            </tr>
            <tr>
                <td><a href="/person/stats/${list.keySet()[1].id}"><img src="${resource(dir:"images", file: "${list.keySet()[1].firstName + ".png"}") }" style="width:24px;height:24px;border:0;"/>${list.keySet()[1].firstName} ${list.keySet()[1].lastName}</a></td>
                <td>${list.values()[1]}</td>
            </tr>
            <tr>
                <td><a href="/person/stats/${list.keySet()[2].id}"><img src="${resource(dir:"images", file: "${list.keySet()[2].firstName + ".png"}") }" style="width:24px;height:24px;border:0;"/>${list.keySet()[2].firstName} ${list.keySet()[2].lastName}</a></td>
                <td>${list.values()[2]}</td>
            </tr>
            <tr>
                <td><a href="/person/stats/${list.keySet()[3].id}"><img src="${resource(dir:"images", file: "${list.keySet()[3].firstName + ".png"}") }" style="width:24px;height:24px;border:0;"/>${list.keySet()[3].firstName} ${list.keySet()[3].lastName}</a></td>
                <td>${list.values()[3]}</td>
            </tr>
            <tr>
                <td><a href="/person/stats/${list.keySet()[4].id}"><img src="${resource(dir:"images", file: "${list.keySet()[4].firstName + ".png"}") }" style="width:24px;height:24px;border:0;"/>${list.keySet()[4].firstName} ${list.keySet()[4].lastName}</a></td>
                <td>${list.values()[4]}</td>
            </tr>
            <tr>
                <td><a href="/person/stats/${list.keySet()[5].id}"><img src="${resource(dir:"images", file: "${list.keySet()[5].firstName + ".png"}") }" style="width:24px;height:24px;border:0;"/>${list.keySet()[5].firstName} ${list.keySet()[5].lastName}</a></td>
                <td>${list.values()[5]}</td>
            </tr>
            <tr>
                <td><a href="/person/stats/${list.keySet()[6].id}"><img src="${resource(dir:"images", file: "${list.keySet()[6].firstName + ".png"}") }" style="width:24px;height:24px;border:0;"/>${list.keySet()[6].firstName} ${list.keySet()[6].lastName}</a></td>
                <td>${list.values()[6]}</td>
            </tr>
            <tr>
                <td><a href="/person/stats/${list.keySet()[7].id}"><img src="${resource(dir:"images", file: "${list.keySet()[7].firstName + ".png"}") }" style="width:24px;height:24px;border:0;"/>${list.keySet()[7].firstName} ${list.keySet()[7].lastName}</a></td>
                <td>${list.values()[7]}</td>
        </tr>
        </tbody>
    </table>
</div>