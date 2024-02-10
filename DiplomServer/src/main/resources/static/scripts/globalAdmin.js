// Тест драйв скрипты
function refMarkYes(id, testdrivecar) {
    $.ajax({
        url: "/cars/" + id + "/yes",
        type: "PUT",
        data: { testdrivecar: testdrivecar},
        success: function(result) {
            location.reload();
        }
    });
}
function refMarkNo(id, testdrivecar) {
    $.ajax({
        url: "/cars/" + id + "/no",
        type: "PUT",
        data: { testdrivecar: testdrivecar },
        success: function(result) {
            location.reload();
        }
    });
}
function deleteHuman(id, testdrivecar){
    $.ajax({
        url: "/cars/" + id + "/delete",
        type: "PUT",
        data: { testdrivecar: testdrivecar },
        success: function(result) {
            location.reload();
        }
    });
}

// _______________Машины скрипты_____________
function refMarkCarYes(id, carmodel, carseries) {
    $.ajax({
        url: "/cars/" + id + "/serviceYes",
        type: "PUT",
        data: { carModel: carmodel, carseries: carseries   },
        success: function(result) {
            location.reload();
        }
    });
}
function refMarkCarNo(id, carmodel) {
    $.ajax({
        url: "/cars/" + id + "/serviceNo",
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
        else if (mark.innerText === "service") {
            mark.classList.add("mark-service");
        }else if(mark.innerText === "carinservice"){
            mark.classList.add("mark-carinservice");
        }
    });
});

//     ____________________________


//     __________________________
document.addEventListener("DOMContentLoaded", function () {
    const testdriveUsersButton = document.getElementById("testdriveUsers");
    const tableMain = document.querySelector(".testDriveUsersTable");

    const carTestDriveReserveTableButton = document.getElementById("carReserve");
    const carTestDriveReserveTable = document.querySelector(".carTestDriveReserveTable");

    const allCarButton = document.getElementById("allCar");
    const allCarTable = document.querySelector(".allCarTable");

    const carInsertButton = document.getElementById("carInsert");
    const carInputFormTable = document.querySelector(".carInputForm");

    const carDeleteButton = document.getElementById("carDelete");
    const carDeleteFormTable = document.querySelector(".carDeleteForm");

    const carSliderButton = document.getElementById("allSliderCar");
    const carSliderFormTable = document.querySelector(".carSliderTableForm");

    const wallpers = document.querySelector(".bmwServiceLogo");

    const carSliderInputButton = document.getElementById("sliderInput");
    const carSliderInputFormTable = document.querySelector(".carSliderTableInputForm");

    const carSliderDeleteButton = document.getElementById("sliderDelete");
    const carSliderDeleteFormTable = document.querySelector(".carSliderDeleteForm");

    tableMain.style.display="none";
    carTestDriveReserveTable.style.display="none";
    carInputFormTable.style.display="none";
    carDeleteFormTable.style.display="none";
    allCarTable.style.display="none";
    carSliderFormTable.style.display="none";
    carSliderInputFormTable.style.display="none";
    carSliderDeleteFormTable.style.display="none";


    let currentButton = null;

    testdriveUsersButton.addEventListener("click", function () {
        toggleUnderline(testdriveUsersButton);
        tableMain.style.display = "flex";
        carTestDriveReserveTable.style.display="none";
        carDeleteFormTable.style.display="none";
        carSliderInputFormTable.style.display="none";
        carSliderDeleteFormTable.style.display="none";
        allCarTable.style.display="none";
        carSliderFormTable.style.display="none";
        carInputFormTable.style.display="none";
        wallpers.style.display="none";
    });

    carTestDriveReserveTableButton.addEventListener("click", function () {
        toggleUnderline(carTestDriveReserveTableButton);
        wallpers.style.display="none";
        tableMain.style.display = "none";
        carSliderDeleteFormTable.style.display="none";
        carInputFormTable.style.display="none";
        carSliderInputFormTable.style.display="none";
        carSliderFormTable.style.display="none";
        carDeleteFormTable.style.display="none";
        allCarTable.style.display="none";
        carTestDriveReserveTable.style.display="flex";
    });

    carInsertButton.addEventListener("click", function (){
        wallpers.style.display="none";
        toggleUnderline(carInsertButton);
        tableMain.style.display = "none";
        carSliderDeleteFormTable.style.display="none";
        carTestDriveReserveTable.style.display="none";
        carSliderInputFormTable.style.display="none";
        carSliderFormTable.style.display="none";
        carDeleteFormTable.style.display="none";
        allCarTable.style.display="none";
        carInputFormTable.style.display="flex";
    });

    carDeleteButton.addEventListener("click", function(){
        wallpers.style.display="none";
        toggleUnderline(carDeleteButton);
        carSliderDeleteFormTable.style.display="none";
        tableMain.style.display = "none";
        carSliderInputFormTable.style.display="none";
        carTestDriveReserveTable.style.display="none";
        carSliderFormTable.style.display="none";
        carInputFormTable.style.display="none";
        allCarTable.style.display="none";
        carDeleteFormTable.style.display="flex";
    });

    allCarButton.addEventListener("click", function (){
        wallpers.style.display="none";
        toggleUnderline(allCarButton);
        carSliderDeleteFormTable.style.display="none";
        tableMain.style.display = "none";
        carSliderFormTable.style.display="none";
        carTestDriveReserveTable.style.display="none";
        carInputFormTable.style.display="none";
        carDeleteFormTable.style.display="none";
        carSliderInputFormTable.style.display="none";
        allCarTable.style.display="flex";

    });

    carSliderButton.addEventListener("click", function (){
        wallpers.style.display="none";
        toggleUnderline(carSliderButton);
        tableMain.style.display = "none";
        carSliderDeleteFormTable.style.display="none";
        carTestDriveReserveTable.style.display="none";
        carInputFormTable.style.display="none";
        carDeleteFormTable.style.display="none";
        allCarTable.style.display="none";
        carSliderInputFormTable.style.display="none";
        carSliderFormTable.style.display="flex";
    });

    carSliderInputButton.addEventListener("click", function (){
        wallpers.style.display="none";
        toggleUnderline(carSliderInputButton);
        carSliderDeleteFormTable.style.display="none";
        tableMain.style.display = "none";
        carTestDriveReserveTable.style.display="none";
        carInputFormTable.style.display="none";
        carDeleteFormTable.style.display="none";
        allCarTable.style.display="none";
        carSliderFormTable.style.display="none";
        carSliderInputFormTable.style.display="flex";
    });

    carSliderDeleteButton.addEventListener("click", function (){
        wallpers.style.display="none";
        toggleUnderline(carSliderDeleteButton);
        tableMain.style.display = "none";
        carTestDriveReserveTable.style.display="none";
        carInputFormTable.style.display="none";
        carDeleteFormTable.style.display="none";
        allCarTable.style.display="none";
        carSliderFormTable.style.display="none";
        carSliderInputFormTable.style.display="none";
        carSliderDeleteFormTable.style.display="flex";
    });


    function toggleUnderline(button) {
        if (currentButton) {
            currentButton.classList.remove("underline");
        }

        button.classList.add("underline");
        currentButton = button;
    }
});