<!doctype html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Meetings</title>
    </head>
    <body>
        <h1>Meetings</h1>
        <div th:if="${error}" style="color:red;">
            <p th:text="${error}"></p>
        </div>

        <form action="#" th:action="@{/meets/new}" th:object="${meeting}"
            method="post">
            <label for="name">Name:</label>
            <input type="text" id="meetingName"
                th:field="*{meetingName}" /><br />

            <label for="meetingStart">Meeting Start:</label>
            <input type="datetime-local" id="meetingStart"
                th:field="*{meetingStart}" /><br />

            <label for="meetingFinish">Meeting Finish:</label>
            <input type="datetime-local" id="meetingFinish"
                th:field="*{meetingFinish}" /><br />

            <input type="submit" value="Create" />
        </form>

        <a href="/meets">View all meetings</a></body>
</html>