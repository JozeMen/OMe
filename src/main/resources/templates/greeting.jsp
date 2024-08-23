<!doctype html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Omeeting</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet">
    </head>
    <body>
        <div class="px-4 py-5 my-5 text-center">
            <h1 class="display-5 fw-bold text-body-emphasis">Приложение для
                управления личными встречами </h1>
            <div class="col-lg-6 mx-auto">
                <p class="lead mb-4">Встреча – событие, которое планируется
                    заранее, для которой всегда известно время начала и
                    примерное время окончания</p>
                <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
                    <form action="/meets" method="get">
                        <button type="submit"
                            class="btn btn-dark rounded-pill px-3"
                            formmethod="get">Просмотреть встречи</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>