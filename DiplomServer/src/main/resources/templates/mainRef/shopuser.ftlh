<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>BMW Test Drive</title>
    <link rel="stylesheet" href="/css/mainCSS/shopuser.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">
    <script src="/scripts/testdrive.js" defer></script>
    <!--    <script src="/scripts/shopauto.js" defer></script>-->
    <link rel="shortcut icon" href="/images/bmw_logo.png" type="image/png">

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

    #submitButton {
        opacity: 0.5;
        cursor: not-allowed;
    }

    #submitButton.enabled {
        cursor: pointer;
        opacity: 1;
    }


</style>

<#include "../header.html">

<body>
<div class="login-page">
    <div class="form">
        <form class="login-form" action="/getshopuser" method="post">
            <input type="text" id="fioInput" name="fio" placeholder="ФИО"/>
            <input type="text" id="phoneNumberInput" name="phoneNumber" placeholder="Номер телефона"/>


            <select name="carSelection" id="carSelection">
                <option value="">Выберите машину</option>
                <#list listCar as car>
                    <#if car.getSeriestype() == "stock">
                        <option value="${car.getSeries()} ${car.getModel()}" id="car">${car.getSeries()} ${car.getModel()}</option>
                    <#else>
                        <option value="${car.getSeriestype() }${car.getSeries()} ${car.getModel()}" id="car">${car.getSeriestype() }${car.getSeries()} ${car.getModel()}</option>
                    </#if>
                </#list>
            </select>


            <input type="text" id="emailInput" name="email" placeholder="E-mail (не обязательно)"/>
            <button type="submit" id="submitButton" disabled>Отправить</button>
        </form>
    </div>
</div>

</body>

<#include "../footer.html">

</html>