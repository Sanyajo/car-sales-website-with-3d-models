<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/arcars.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="shortcut icon" href="/images/bmw_logo.png" type="image/png">
    <title>Авто в дополненной реальности</title>
</head>

<style>
    @font-face {
        font-family: Roboto;
        src: url("/fonts/SportsWorld.otf");
    }
    @font-face {
        font-family: Price;
        src: url("/fonts/textStyle.ttf");
    }
    @font-face{
        font-family: Tonky;
        src: url("/fonts/tonkyFont.ttf");
    }
    @font-face {
        font-family: New;
        src: url("/fonts/newFont.ttf");
    }

    .header{
        /*background: black;*/
        width: 100%;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        position: static;
        /*background: linear-gradient(274deg, rgba(255, 255, 255, 0) 0%, rgba(0, 0, 0, 0.06206232492997199) 0%);*/
    }


    .loglink a {
        /* text-transform: uppercase; */
        text-decoration: none;
        font-size: 33px;
        color: #D9D6D2;
    }
    hr {
        border: none; /* Убираем границу */
        background-color: #767A80; /* Цвет линии */
        color: #767A80; /* Цвет линии для IE6-7 */
        height: 2px; /* Толщина линии */
    }

    .footer{
        /*position: absolute;*/
        bottom: 0;
        left: 0;

    }

</style>

<#include "../header.html">

<hr>

<body>

    <div class="carBlock">

        <div class="parent">
            <#list listAuto as car>
                <div class="info1" data-seriestype="${car.getSeries()}${car.getModel()}" data-series="${car.getSeries()}">
                    <img src="${car.getImageUrl()}">
                    <#if car.getSeriestype() == "M">
                        <p1>BMW  ${car.getSeriestype()}${car.getSeries()} ${car.getModel()}</p1>
                    <#else>
                        <p1>BMW  ${car.getSeries()} ${car.getModel()}</p1>
                    </#if>
                    <form action="/arcar/${car.getModel()}" method="post">
                        <button type="submit">
                            Просмотр в виртуальной реальности
                        </button>
                    </form>
                </div>
            </#list>
        </div>

    </div>

    <#include "../footer.html">
</body>



</html>