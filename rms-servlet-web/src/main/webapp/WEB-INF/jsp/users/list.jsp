<%@include file="../templates/header.jsp"%>

<a href="form"><button class="button">Add User</button></a>
<br/>
<br/>

<form action="${pageContext.request.contextPath}/users/deleteAll" method="post">

    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
        <thead>
            <tr>
                <th>
                    <input type="checkbox" id="check-all" onclick="toggleCheckboxes(this);" />
                </th>
                <th class="mdl-data-table__cell--non-numeric">User Name</th>
                <th>Password</th>
                <th colspan="2" style="text-align: center">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items = "${users}" var="user">
                <tr>
                    <td>
                        <c:if test="${loggedUser != user.id}">
                            <input type="checkbox" name="usernames" value="${user.userName}"
                                   class="single-cb" />
                        </c:if>
                    </td>
                    <td class="mdl-data-table__cell--non-numeric"><c:out value = "${user.userName}"/></td>
                    <td><c:out value = "${user.password}"/></td>
                    <td><a href="form?username=${user.userName}">Update</a></td>
                    <td>
                        <c:if test="${loggedUser != user.id}">
                            <a href="delete?username=${user.userName}"
                               onclick="return confirm('Are you sure want to delete this user?')">Delete</a></td>
                        </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div id="selected-cb"></div>
    <br/>
    <button type="submit" class="button"
            onclick="return confirm('Are you sure want to delete this user?')">Delete Users</button>
    
</form>

<%@include file="../templates/footer.jsp"%>

