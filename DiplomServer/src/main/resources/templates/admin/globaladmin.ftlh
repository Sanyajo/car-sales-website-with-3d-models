<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/adminCSS/globaladmin.css">
    <link rel="shortcut icon" href="/images/bmw_logo.png" type="image/png">
    <title>Admin</title>
</head>

<body>


    <div class="container">
        <div class="bodyCongButton">
            <button id="testdriveUsers">Тестдрайв заявки</button>
            <button id="carReserve">Занятость машин</button>
            <button id="Тестдрайв заявки">Тестдрайв заявки</button>
            <button id="Тестдрайв заявки">Тестдрайв заявки</button>
        </div>
        <div class="testDriveUsersTable">
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
                        <td><button onclick="refMarkYes(${human.getId()}, '${human.getTestDriveCar()}')">Да</button><button onclick="refMarkNo(${human.getId()}, '${human.getTestDriveCar()}')">Нет</button></td>
                        <#--                    <td><button onclick="refMarkNo(${human.getId()})">Нет</button></td>-->
                    </tr>
                </#list>
            </table>
        </div>
        <div class="carTestDriveReserveTable">
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
                        <td><button onclick="refMarkCarYes(${car.getId()},'${car.getModel()}')">Да</button><button onclick="refMarkCarNo(${car.getId()},'${car.getModel()}')">Нет</button></td>
                        <#--                    <td><button onclick="refMarkNo(${human.getId()})">Нет</button></td>-->
                    </tr>
                </#list>
            </table>
        </div>
    </div>





<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>

    <#--    Тест драйв скрипты-->
    function refMarkYes(id, testdrivecar) {
        $.ajax({
            url: "/humans/" + id + "/yes",
            type: "PUT",
            data: { testdrivecar: testdrivecar },
            success: function(result) {
                location.reload();
            }
        });
    }
    function refMarkNo(id, testdrivecar) {
        $.ajax({
            url: "/humans/" + id + "/no",
            type: "PUT",
            data: { testdrivecar: testdrivecar },
            success: function(result) {
                location.reload();
            }
        });
    }

    // _______________Машины скрипты_____________
    function refMarkCarYes(id, carmodel) {
        $.ajax({
            url: "/cars/" + id + "/yes",
            type: "PUT",
            data: { carModel: carmodel },
            success: function(result) {
                location.reload();
            }
        });
    }

    function refMarkCarNo(id, carmodel) {
        $.ajax({
            url: "/cars/" + id + "/no",
            type: "PUT",
            data: { carModel: carmodel },
            success: function(result) {
                location.reload();
            }
        });
    }


    document.addEventListener("DOMContentLoaded", function() {
        var marks = document.querySelectorAll(".mark");
        marks.forEach(function(mark) {
            if (mark.innerText === "yes") {
                mark.classList.add("mark-yes");
            } else if (mark.innerText === "no") {
                mark.classList.add("mark-no");
            }
        });
    });


//     __________________________
    document.addEventListener("DOMContentLoaded", function () {
        const testdriveUsersButton = document.getElementById("testdriveUsers");
        const tableMain = document.querySelector(".testDriveUsersTable");

        const carTestDriveReserveTableButton = document.getElementById("carReserve");
        const carTestDriveReserveTable = document.querySelector(".carTestDriveReserveTable");

        carTestDriveReserveTable.style.display="none";


        let currentButton = null;

        testdriveUsersButton.addEventListener("click", function () {
            toggleUnderline(testdriveUsersButton);
            tableMain.style.display = "flex";
            carTestDriveReserveTable.style.display="none";
        });

        carTestDriveReserveTableButton.addEventListener("click", function () {
            toggleUnderline(carTestDriveReserveTableButton);
            tableMain.style.display = "none";
            carTestDriveReserveTable.style.display="flex";
        });


        function toggleUnderline(button) {
            if (currentButton) {
                currentButton.classList.remove("underline");
            }

            button.classList.add("underline");
            currentButton = button;
        }
    });

</script>

</body>
</html>