<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/mainCSS/seriescar.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    <script src="/scripts/script.js" defer></script>
    <#--  <script src="/images/carbody/bmw5m/app.js"></script>-->
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>

    <title>BMW ${carInfo.getModel()} series</title>

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
</style>

<#include "../header.html">

<body>

    <div class="videoHeader">
    <div class="videText">
        <p1>THE</p1>
        <p2>${carInfo.getModel()}</p2>
        <div class="videoLogo">

<#--            <img src="/images/main/bmw_m_logo.png">-->
            <p3>BMW ${carInfo.getModel()}</p3>

        </div>

        <div class="harText">

            <div class="harTextBlock">
                <p1>${carInfo.getFuelflow()}</p1>
                <p2>Объем двигателя</p2>
            </div>

            <div class="harTextBlock">
                <p1>${motorType}</p1>
                <p2>Двигатель</p2>
            </div>

            <div class="harTextBlock">
                <p1>${car.getPrice()}</p1>
                <p2>Стоимость от </p2>
            </div>

        </div>

    </div>

    <video src=${carInfo.getTitleVideo()} type="video/mp4" autoplay muted loop></video>

</div>

    <div class="sliderMain">

        <div class="findCarInfo">
            <p2>ВПЕЧАТЛЯЮЩИЕ ОСОБЕННОСТИ ЭКСТЕРЬЕРА</p2>
        </div>

        <div class="wrapper">
            <i id="left" class="fa-solid fa-angle-left"></i>
            <ul class="carousel">
                <#list carSliderListBody as carsliderlist>
                    <li class="card">
                        <div class="img"><img src=${carsliderlist.getImageSlider()} alt="img" draggable="false"></div>
                        <h2>${carsliderlist.getImageinfo()}</h2>
                    </li>
                </#list>

            </ul>
            <i id="right" class="fa-solid fa-angle-right"></i>
        </div>
    </div>

    <div class="carHistory">
        <p2>ИСТОРИЯ BMW ${carInfo.getModel()}</p2>
        <p>${carInfo.getCarhistory()}</p>
    </div>

    <div class="video">
        <p>ОБЗОР BMW ${carInfo.getModel()}</p>
        <video src=${carInfo.getVideoreview()} controls></video>
    </div>

    <div class="carHistory">
        <p2>ДИЗАЙН И ДИНАМИКА ДВИЖЕНИЯ BMW  ${carInfo.getModel()}</p2>
        <p>${carInfo.getCardesign()}</p>
    </div>

    <div class="sliderMain2">
        <div class="findCarInfo2">
            <p2>ВПЕЧАТЛЯЮЩИЕ ОСОБЕННОСТИ ИНТЕРЬЕРА</p2>
        </div>

        <div class="wrapper2">
            <i id="left" class="fa-solid fa-angle-left"></i>
            <ul class="carousel2">
                <#list carSliderListSalon as carsliderlist>
                    <li class="card2">
                        <div class="img"><img src="${carsliderlist.getImageSlider()}" alt="img" draggable="false"></div>
                        <h2>${carsliderlist.getImageinfo()}</h2>
                    </li>
                </#list>
            </ul>
            <i id="right" class="fa-solid fa-angle-right"></i>
        </div>
    </div>

    <div class="konfigMain">
        <div class="konfig">
            <p2>СОБЕРИ СВОЙ BMW</p2>
            <img src=${car.getUrlimage()} alt="img" draggable="false">
            <form action="" method="post">
                <button type="submit">
                    <p1>Конфигуратор</p1>
                </button>
            </form>
        </div>
    </div>


    <div class="priceBlock">
        <img src="/images/priceImage.jpg" alt="">
        <div class="priceTitle">
            <form class="priceTitle" action="/${car.getSeries()}/${car.getModel()}/price" method="post">
                <p1>ПРАЙС-ЛИСТ</p1>
                <p2>Вы можете ознакомиться с доступными опциями и спецификациями автомобиля, скачав прайс-лист</p2>
                <button type="submit" id="submitButton">Скачать прайс лист</button>
            </form>
        </div>
    </div>

</body>

<#include "../footer.html">

</html>