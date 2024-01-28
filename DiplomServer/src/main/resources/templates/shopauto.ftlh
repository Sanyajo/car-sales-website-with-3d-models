<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/mainCSS/shopauto.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="shortcut icon" href="/images/bmw_logo.png" type="image/png">
    <title>Shop car</title>
</head>

<body>
    <header class="header">
        <div class="loglink">
            <div class="links">
                <a class="nav__link" href="#">Автомобили</a>
                <a class="nav__link" href="/allauto">Покупка</a>
                <a class="nav__link" href="/bmwinfo">Больше о BMW</a>
            </div>

            <form action="/main" target="">
                <button class="logo_heade_button">
                </button>
            </form>


        </div>
    </header>

    <div class="carBlock">
        <div class="parent">
            <#list listAuto as car>

            <div class="info1">

                    <form action="/shopauto/${car.model}/${car.series}" method="post">
                        <button type="submit">
                            <img src="${car.urlimage}">
                        </button>
                    </form>

                <#if car.series == "series">
                    <p>BMW  ${car.model} series</p>
                <#else>
                    <p>BMW  ${car.series}${car.model} series</p>
                </#if>
                <p>Бензин  <span class="cmp-modelcard__fuel-type--dot">•</span> Дизель</p>

            </div>
            </#list>

        </div>

    </div>

</body>

<footer class="footer">

    <div class="conteiner_footer">
        <div class="contact">
            <p>КОНТАКТЫ</p>
            <nav>
                <a class = "footer_links" href="/testdrive">Тест-драйв</a>
                <a class = "footer_links" href="/feedback">Обратная связь</a>
            </nav>
        </div>

        <form action="https://www.instagram.com/bmw/" target="">
            <button class="logo_foter_button">
            </button>
        </form>

    </div>

</footer>

</html>