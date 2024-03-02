<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/arCarModel.css">
    <link rel="shortcut icon" href="/images/bmw_logo.png" type="image/png">
    <title>${car.getModel()} AR</title>
</head>

<body>
    <div class="qrCont">
        <img src="${car.getQrUrl()}">
        <p>Сканируйте код и осмотрите автомобиль в дополненной реальности</p>
    </div>
    <div class="cont3d"></div>
    <div class="logoCont">
        <form action="/returnmain" target="">
            <button class="logo_heade_button">
            </button>
        </form>
        <#if car.getSeriestype() == "M">
            <p1>THE  ${car.getSeriestype()}${car.getSeries()} ${car.getModel()}</p1>
        <#else>
            <p1>THE  ${car.getModel()}</p1>
        </#if>
    </div>
</body>

</html>