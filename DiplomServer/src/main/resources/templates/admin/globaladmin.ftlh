<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/adminCSS/globaladmin.css">
    <link rel="shortcut icon" href="/images/bmw_logo.png" type="image/png">
    <script src="/scripts/globalAdmin.js" defer></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Admin</title>
</head>

<body>

    <div class="container">
        <div class="bodyCongButton">
            <button id="testdriveUsers">Тестдрайв заявки</button>
            <button id="carReserve">Занятость машин</button>
            <hr>
            <button id="shopuser">Покупки заявки</button>
            <hr>
            <button id="allCar">Все машины</button>
            <button id="carInsert">Добавить машину</button>
            <button id="carDelete">Удалить машину</button>
            <hr>
            <button id="allSliderCar">Просм машины стр инфо</button>
            <button id="sliderInput">Добавить инфо слайд</button>
            <button id="sliderDelete">Удалить инфо слайд</button>
            <button id="editRecord">Изменить запись</button>
            <hr>
            <button id="deleteRep">Удалить папку</button>
        </div>

        <div class="bmwServiceLogo">
            <img src="/images/bmwService.jpeg">
        </div>


        <div class="testDriveUsersTable">

            <div class="infotestDriveUsersTable">
                <table>
                    <td class="greenInfo">ЦВЕТ</td><td>Забронировал</td>
                    <td class="redInfo">ЦВЕТ</td><td>Не обработан</td>
                    <td class="yellowInfo">ЦВЕТ</td><td>Машина попала в сервис</td>
                </table>
            </div>

            <table>
                <tr>
                    <th>ФИО</th>
                    <th>Номер телефона</th>
                    <th>Почта</th>
                    <th>Машина</th>
                    <th>Отметка</th>
                    <th>Действие</th>
                </tr>
                <#list listHuman as human>
                    <tr>
                        <td>${human.getFullName()}</td>
                        <td>${human.getTelephoneNumber()}</td>
                        <td>${human.getEmail()}</td>
                        <td>${human.getTestDriveCar()}</td>
                        <td class="mark">${human.getMark()}</td>
                        <td><button onclick="refMarkYes(${human.getId()}, '${human.getTestDriveCar()}')">Бронь</button><button onclick="refMarkNo(${human.getId()}, '${human.getTestDriveCar()}')">Отказ</button></td>
                        <td><button onclick="deleteHuman(${human.getId()}, '${human.getTestDriveCar()}')">Удалить ползователя</button></td>
                    </tr>
                </#list>
            </table>
        </div>

        <div class="carTestDriveReserveTable">
            <div class="infotestDriveUsersTable">
                <table>
                    <td class="greenInfo">ЦВЕТ</td><td>Забронирована</td>
                    <td class="redInfo">ЦВЕТ</td><td>Свободна</td>
                    <td class="orangeInfo">ЦВЕТ</td><td>Сервис</td>
                </table>
            </div>

            <table>
                <tr>
                    <th>Серия</th>
                    <th>Модель</th>
                    <th>Отметка</th>
                    <th>Действие</th>
                </tr>
                <#list listCar as car>
                    <tr>
                        <#if car.getSeriestype() == "M">
                            <td>${car.getSeriestype()}${car.getSeries()}</td>
                        <#else>
                            <td>${car.getSeries()}</td>
                        </#if>
                        <td>${car.getModel()}</td>
                        <td class="mark">${car.getMarkCar()}</td>
                        <td><button onclick="refMarkCarYes(${car.getId()},'${car.getModel()}', '${car.getSeries()}')">В ремонте</button><button onclick="refMarkCarNo(${car.getId()},'${car.getModel()}')">Готова</button></td>
                        <#--                    <td><button onclick="refMarkNo(${human.getId()})">Нет</button></td>-->
                    </tr>
                </#list>
            </table>
        </div>


        <div class="shopUsersTable">
            <div class="shopUsersTableB">
                <table>
                    <tr>
                    <th>ФИО</th>
                    <th>Номер телефона</th>
                    <th>Почта</th>
                    <th>Машина</th>
                    <th>Отметка</th>
                    <th>Действие</th>
                    </tr>

                    <#list shopUsersList as user>
                    <tr>
                        <td>${user.getFullName()}</td>
                        <td>${user.getPhoneNumber()}</td>
                        <td>${user.getEmail()}</td>
                        <td>${user.getCar()}</td>
                        <td class="mark">${user.getCheckValue()}</td>
                    </tr>
                    </#list>

                </table>
            </div>
        </div>


        <div class="allCarTable">
            <table>
                <tr>
                    <th>Тип</th>
                    <th>Серия</th>
                    <th>Модель</th>
                    <th>Тип двигателя</th>
                </tr>
                <#list listCar as car>
                    <tr>
                        <td>${car.getSeriestype()}</td>
                        <td>${car.getSeries()}</td>
                        <td>${car.getModel()}</td>
                        <td>${car.getMotortype()}</td>
                    </tr>
                </#list>
            </table>
        </div>

        <div class="carInputForm">
            <div class="carInputFormB">
                <form class="login-form" action="/addCarInputForm" enctype="multipart/form-data" method="post">
                    <input type="text" id="model" name="model" placeholder="Модель"/>
                    <input type="text" id="series" name="series" placeholder="Серия"/>
                    <input type="text" id="motortype" name="motortype" placeholder="Тип мотора"/>
                    <select name="seriestype" id="seriestype">
                        <option value="">Выберите серию тип</option>
                        <option value="M">М</option>
                        <option value="stock">stock</option>
                    </select>
                    <input type="file" id="photo" name="photo" multiple accept="image/*,image/jpeg"/>


                    <button type="submit" id="submitButton" >Добавить</button>
                </form>
            </div>

        </div>

        <div class="carDeleteForm">
            <div class="carDeleteFormB">

                <form class="carDeleteForm" action="/carDeleteForm"  method="post">
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

                    <button type="sumbit" id="sumbitButton">Удалить</button>
                </form>

            </div>
        </div>

        <div class="carSliderTableForm">
            <div class="carSliderForm">
                <form class="carSliderAllButton" action="/carSliderAllButton" method="post">
                    <table>

                    <tr>
                        <#list carSliderTableNameList as carslidercolumnname>
                            <th>${carslidercolumnname}</th>
                        </#list>
                    </tr>

                        <#list listSlider as carSlider>
                        <tr>

                            <td>${carSlider.getId()}</td>
                            <td>${carSlider.getModel()}</td>
                            <td>${carSlider.getSeries()}</td>
                            <td><a href="${carSlider.getImageSlider()}" target="_blank">${carSlider.getImageSlider()}</a></td>
                            <td>${carSlider.getImageinfo()}</td>
                            <td>${carSlider.getType()}</td>
                            <td>${carSlider.getSeriestype()}</td>
                        </tr>
                        </#list>

                    </table>
                </form>
            </div>
        </div>

        <div class="carSliderTableInputForm">
            <div class="carSliderTableInputFormB">
                <div class="dirTableForm">
                    <h>Директории</h>
                    <table>
                        <tr>
                            <#list listDirct as dir>
                                <td>${dir}</td>
                            </#list>
                        </tr>
                    </table>
                </div>
                <form class="login-form" action="/addcarsliderform" enctype="multipart/form-data" method="post">
                    <input type="text" id="model" name="model" placeholder="Модель"/>
                    <input type="text" id="series" name="series" placeholder="Серия"/>
                    <input type="file" id="image" name="image" multiple accept="image/*,image/jpeg"/>
                    <input type="text" id="foldername" name="foldername" placeholder="Название папки"/>
                    <input type="text" id="imageinfo" name="imageinfo" placeholder="Информация о картинке"/>

                    <select name="type" id="type">
                        <option value="">Выберите тип</option>
                        <option value="salon">Салон</option>
                        <option value="carbody">Интерьер</option>
                    </select>

                    <select name="seriestype" id="seriestype">
                        <option value="">Выберите серию</option>
                        <option value="M">М</option>
                        <option value="stock">stock</option>
                    </select>

                    <button type="submit" id="submitButton" >Добавить</button>
                </form>
            </div>
        </div>

        <div class="carSliderDeleteForm">
            <form class="login-form" action="/carsliderdelete" method="post">
                <input type="text" id="carid" name="carid" placeholder="Введите id записи"/>
                <button type="submit" id="submitButton" >Удалить</button>
            </form>
        </div>

        <div class="deleteRepFormTable">
            <div class="dirTableForm">
                <h>Директории</h>
                <table>
                    <tr>
                        <#list listDirct as dir>
                            <td>${dir}</td>
                        </#list>
                    </tr>
                </table>
            </div>
            <form class="login-form" action="/deleteRepFormTable" method="post">
            <input type="text" id="repName" name="repName" placeholder="Введите название директории"/>
            <button type="submit" id="submitButton" >Удалить</button>
            </form>
        </div>


        <div class="editRecordFormTable">
            <form class="login-form" action="/editRecordId" method="post">
                <input type="text" id="id" name="id" placeholder="Введите id записи для изменения"/>
                <button type="submit" id="editRecordFormTableButtonFromTable" >Изменить</button>
            </form>

            <div class="editRecordFormTableNewB">
                <#if listEdit??>
                    <form class="login-form" action="/updateRecord" enctype="multipart/form-data" method="post">
                        <input type="text" id="id" name="id" placeholder="${listEdit.getId()}" value="${listEdit.getModel()}" readonly>
                        <input type="text" id="model" name="model" placeholder="Модель" value="${listEdit.getModel()}">
                        <input type="text" id="series" name="series" placeholder="Серия" value="${listEdit.getSeries()}"/>
                        <input type="text" id="image" name="image" multiple accept="image/*,image/jpeg" value="${listEdit.getImageSlider()}"/>
                        <input type="text" id="imageinfo" name="imageinfo" placeholder="Инфо картинка" value="${listEdit.getImageinfo()}"/>


                        <select name="type" id="type">
                            <option value="${listEdit.getType()}">${listEdit.getType()}</option>
                            <option value="salon">Салон</option>
                            <option value="carbody">Интерьер</option>
                        </select>

                        <select name="seriestype" id="seriestype">
                            <option value="${listEdit.getSeriestype()}">${listEdit.getSeriestype()}</option>
                            <option value="M">М</option>
                            <option value="stock">stock</option>
                        </select>
                        <button type="submit" id="submitButton" >Изменить</button>
                    </form>
                </#if>
            </div>

        </div>


    </div>

</body>

</html>