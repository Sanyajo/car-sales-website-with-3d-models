<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="/css/footer.css">
  <link rel="stylesheet" href="/css/header.css">
  <link rel="stylesheet" href="/css/mainCSS/car.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
  <script src="/images/carslider/bmw5m/script.js" defer></script>
<#--  <script src="/images/carbody/bmw5m/app.js"></script>-->
  <script src="https://kit.fontawesome.com/a81368914c.js"></script>

  <title>BMW  ${carInfo.getSeries()}${carInfo.getModel()} series</title>

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

<header class="header">
  <div class="loglink">
    <div class="links">
      <a class="nav__link" href="/allauto">Автомобили</a>
      <a class="nav__link" href="#">Покупка</a>
      <a class="nav__link" href="/bmwinfo">Больше о BMW</a>
    </div>

    <form action="/returnmain" target="">
      <button class="logo_heade_button">
      </button>
    </form>


  </div>
</header>


<body>

    <div class="videoHeader">
      <div class="videText">
        <p1>THE</p1>
        <p2>${carImage.getSeries()}${carImage.getModel()}</p2>
        <div class="videoLogo">

          <img src="/images/main/bmw_m_logo.png">
          <p3>BMW ${carImage.getSeries()}${carImage.getModel()}</p3>

        </div>

        <div class="harText">

          <div class="harTextBlock">
            <p1>${carInfo.getFuelflow()}</p1>
            <p2>Объем двигателя</p2>
          </div>

          <div class="harTextBlock">
            <p1>${carInfo.getMotortype()}</p1>
            <p2>Двигатель</p2>
          </div>

        </div>

      </div>

      <video src=${carImage.getTitleImg()} type="video/mp4" autoplay muted loop></video>

    </div>

    <div class="carHistory">
      <p2>История BMW  ${carInfo.getSeries()}${carInfo.getModel()} series</p2>
      <p>${carInfo.getCarhistory()}</p>
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

    <div class="video">
      <p>ОБЗОР BMW  ${carInfo.getSeries()}${carInfo.getModel()} series</p>
      <video src=${carInfo.getVideoreview()} controls></video>
    </div>

    <div class="carHistory">
      <p2>ДИЗАЙН И ДИНАМИКА ДВИЖЕНИЯ BMW  ${carInfo.getSeries()}${carInfo.getModel()} series xDRIVE</p2>
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


    <div class="priceBlock">
      <img src="/images/priceImage.jpg" alt="">
      <div class="priceTitle">
        <p1>ПРАЙС-ЛИСТ</p1>
        <p2>Вы можете ознакомиться с доступными опциями и спецификациями автомобиля, скачав прайс-лист</p2>
        <a href=${carInfo.getPdfurl()} target="_blank">Скачать прайс-лист</a>
      </div>
    </div>

</body>

<footer class="footer">

  <div class="conteiner_footer">
    <div class="contact">
      <p>КОНТАКТЫ</p>
      <nav>
        <a class = "footer_links" href="#">Тест-драйв</a>
        <a class = "footer_links" href="#">Обратная связь</a>
      </nav>
    </div>

    <button class="logo_foter_button">

    </button>

  </div>

</footer>

</html>