<%@include file="../templates/header.jsp"%>

<a href="form"><button class="button">Add User</button></a>
<br/>
<br/>

<form action="${pageContext.request.contextPath}/users/deleteAll" method="post">

    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
        <thead>
            <tr>
                <th>
                    <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-data-table__select" for="check-all">
                        <input type="checkbox" id="check-all" class="mdl-checkbox__input" />
                    </label>
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
                        <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-data-table__select">
                            <input type="checkbox" name="usernames" value="${user.userName}" class="mdl-checkbox__input" />
                        </label>
                    </td>
                    <td class="mdl-data-table__cell--non-numeric"><c:out value = "${user.userName}"/></td>
                    <td><c:out value = "${user.password}"/></td>
                    <td><a href="form?username=${user.userName}">Update</a></td>
                    <td><a href="delete?username=${user.userName}"
                           onclick="return confirm('Are you sure want to delete this user?')">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div id="selected-cb"></div>
    <button type="submit" class="button"
            onclick="return confirm('Are you sure want to delete this user?')">Delete Users</button>
    
</form>

<%@include file="../templates/footer.jsp"%>

<script src="js/scripts.js">

</script>