<!doctype html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Meetings</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet">
    </head>
    <body>
        <div class="px-4 py-5 my-5 text-center">
            <h1 class="display-5 fw-bold text-body-emphasis">Встречи</h1>
        </div>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Meeting Name</th>
                    <th scope="col"> Start</th>
                    <th scope="col">Finish</th>
                </tr>
            </thead>
            <tbody>
                <tr th:each="meeting : ${meetings}">
                    <td scope="row" th:text="${meeting.meetingName}">Meeting
                        Name</td>
                    <td scope="row"
                        th:text="${#temporals.format(meeting.meetingStart, 'dd-MM-yyyy HH:mm')}">Start</td>
                    <td scope="row"
                        th:text="${#temporals.format(meeting.meetingFinish, 'dd-MM-yyyy HH:mm')}">Finish</td>
                    <td scope="row">
                        <form
                            th:action="@{/meets/{meetingName}(meetingName=${meeting.meetingName})}"
                            method="post">
                            <input type="hidden" name="_method"
                                value="delete" />
                            <button class="btn btn-dark rounded-pill px-3"
                                type="submit">Remove</button>
                        </form>
                    </td>
                    <td scope="row">
                        <form action="#" method="get">
                            <button type="submit"
                                class="btn btn-dark rounded-pill px-3"
                                formmethod="get">Изменить встречу</button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>

        <form action="/meets/new" method="get">
            <button type="submit"
                class="btn btn-dark rounded-pill px-3"
                formmethod="get">Создать новую встречу</button>
        </form>
    </body>
</html>