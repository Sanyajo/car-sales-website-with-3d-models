<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/mainCSS/shopauto.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="shortcut icon" href="/images/bmw_logo.png" type="image/png">
    <script src="/scripts/shopauto.js" defer></script>
    <title>Выбор машины</title>
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
        background: black;
        width: 100%;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        position: static;
        /*background: linear-gradient(274deg, rgba(255, 255, 255, 0) 0%, rgba(0, 0, 0, 0.06206232492997199) 0%);*/
    }

    .footer{
        position: absolute;
        bottom: 0;
        left: 0;
    }

</style>

<#include "header.html">

<body>

    <div class="selectButton">
        <button id="allModels">Все серии</button>
        <button id="M">M</button>
        <button id="4">4</button>
        <button id="5">5</button>
    </div>

    <div class="carBlock">

        <div class="parent">
        <#list listAuto as car>
            <div class="info1" data-seriestype="${car.getSeriestype()}" data-series="${car.getSeries()}">
                <form action="/shopauto/${car.getSeriestype()}/${car.getSeries()}/${car.getModel()}" method="post">
                    <button type="submit">
                        <img src="${car.urlimage}">
                    </button>
                </form>
                <#if car.getSeriestype() == "M">
                    <p1>BMW  ${car.getSeriestype()}${car.getSeries()} ${car.getModel()}</p1>
                <#else>
                    <p1>BMW  ${car.getSeries()} ${car.getModel()}</p1>
                </#if>
                <p>${car.getMotortype()}</p>
            </div>
        </#list>
    </div>

    </div>

</body>

<#include "footer.html">

</html>
