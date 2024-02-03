// Первый слайдер
const wrapper = document.querySelector(".wrapper");
const carousel = document.querySelector(".carousel");
const firstCardWidth = carousel.querySelector(".card").offsetWidth;
const arrowBtns = document.querySelectorAll(".wrapper i");
const carouselChildrens = [...carousel.children];

let isDragging = false, isAutoPlay = true, startX, startScrollLeft, timeoutId;

// Получаем количество карточек, которые могут поместиться в карусели одновременно
let cardPerView = Math.round(carousel.offsetWidth / firstCardWidth);

// Добавляем копии последних нескольких карточек в начало карусели для бесконечной прокрутки
carouselChildrens.slice(-cardPerView).reverse().forEach(card => {
    carousel.insertAdjacentHTML("afterbegin", card.outerHTML);
});

// Добавляем копии первых нескольких карточек в конец карусели для бесконечной прокрутки
carouselChildrens.slice(0, cardPerView).forEach(card => {
    carousel.insertAdjacentHTML("beforeend", card.outerHTML);
});

// Прокручиваем карусель в правильное положение, чтобы скрыть первые несколько дубликатов карточек в Firefox
carousel.classList.add("no-transition");
carousel.scrollLeft = carousel.offsetWidth;
carousel.classList.remove("no-transition");

// Добавляем обработчики событий для стрелок, чтобы прокручивать карусель влево и вправо
arrowBtns.forEach(btn => {
    btn.addEventListener("click", () => {
        carousel.scrollLeft += btn.id == "left" ? -firstCardWidth : firstCardWidth;
    });
});

const dragStart = (e) => {
    isDragging = true;
    carousel.classList.add("dragging");
    // Запоминаем начальную позицию курсора и прокрутки карусели
    startX = e.pageX;
    startScrollLeft = carousel.scrollLeft;
}

const dragging = (e) => {
    if(!isDragging) return; // Если isDragging равно false, выходим
    // Обновляем позицию прокрутки карусели на основе движения курсора
    carousel.scrollLeft = startScrollLeft - (e.pageX - startX);
}

const dragStop = () => {
    isDragging = false;
    carousel.classList.remove("dragging");
}

const infiniteScroll = () => {
    // Если карусель находится в начале, прокручиваем в конец
    if(carousel.scrollLeft === 0) {
        carousel.classList.add("no-transition");
        carousel.scrollLeft = carousel.scrollWidth - (2 * carousel.offsetWidth);
        carousel.classList.remove("no-transition");
    }
    // Если карусель находится в конце, прокручиваем в начало
    else if(Math.ceil(carousel.scrollLeft) === carousel.scrollWidth - carousel.offsetWidth) {
        carousel.classList.add("no-transition");
        carousel.scrollLeft = carousel.offsetWidth;
        carousel.classList.remove("no-transition");
    }

    // Очищаем существующий таймаут и запускаем автопрокрутку, если курсор мыши не находится над каруселью
    clearTimeout(timeoutId);
    if(!wrapper.matches(":hover")) autoPlay();
}

// Получаем все изображения в карточках
const images = document.querySelectorAll('.card .img img');

// Добавляем обработчик события клика на каждое изображение
images.forEach(image => {
    // Добавляем состояние для отслеживания текущего размера изображения
    let isZoomed = false;

    function zoomImage() {
        image.classList.add('zoomed'); // Добавляем класс для увеличенного изображения
        isZoomed = true;
    }

// Функция для сброса размеров изображения
    function resetImage() {
        image.classList.remove('zoomed'); // Удаляем класс для увеличенного изображения
        isZoomed = false;
    }

    // Обработчик события клика на изображение
    image.addEventListener('click', () => {
        // Если изображение не увеличено, увеличиваем его, иначе возвращаем к обычным размерам
        if (!isZoomed) {
            zoomImage();
        } else {
            resetImage();
        }
    });

    // Обработчик события нажатия клавиши Esc для закрытия изображения
    document.addEventListener('keydown', (event) => {
        if (isZoomed && event.key === 'Escape') {
            resetImage();
        }
    });
});

carousel.addEventListener("mousedown", dragStart);
carousel.addEventListener("mousemove", dragging);
document.addEventListener("mouseup", dragStop);
carousel.addEventListener("scroll", infiniteScroll);
wrapper.addEventListener("mouseenter", () => clearTimeout(timeoutId));




// Второй слайдер
const wrapper2 = document.querySelector(".wrapper2");
const carousel2 = document.querySelector(".carousel2");
const firstCardWidth2 = carousel2.querySelector(".card2").offsetWidth;
const arrowBtns2 = document.querySelectorAll(".wrapper2 i");
const carouselChildrens2 = [...carousel2.children];

let isDragging2 = false, isAutoPlay2 = true, startX2, startScrollLeft2, timeoutId2;

// Получаем количество карточек, которые могут поместиться в карусели одновременно
let cardPerView2 = Math.round(carousel2.offsetWidth / firstCardWidth2);

// Добавляем копии последних нескольких карточек в начало карусели для бесконечной прокрутки
carouselChildrens2.slice(-cardPerView2).reverse().forEach(card => {
    carousel2.insertAdjacentHTML("afterbegin", card.outerHTML);
});

// Добавляем копии первых нескольких карточек в конец карусели для бесконечной прокрутки
carouselChildrens2.slice(0, cardPerView2).forEach(card => {
    carousel2.insertAdjacentHTML("beforeend", card.outerHTML);
});

// Прокручиваем карусель в правильное положение, чтобы скрыть первые несколько дубликатов карточек в Firefox
carousel2.classList.add("no-transition");
carousel2.scrollLeft = carousel2.offsetWidth;
carousel2.classList.remove("no-transition");

// Добавляем обработчики событий для стрелок, чтобы прокручивать карусель влево и вправо
arrowBtns2.forEach(btn => {
    btn.addEventListener("click", () => {
        carousel2.scrollLeft += btn.id == "left" ? -firstCardWidth2 : firstCardWidth2;
    });
});

const dragStart2 = (e) => {
    isDragging2 = true;
    carousel2.classList.add("dragging");
    // Запоминаем начальную позицию курсора и прокрутки карусели
    startX2 = e.pageX;
    startScrollLeft2 = carousel2.scrollLeft;
}

const dragging2 = (e) => {
    if(!isDragging2) return; // Если isDragging равно false, выходим
    // Обновляем позицию прокрутки карусели на основе движения курсора
    carousel2.scrollLeft = startScrollLeft2 - (e.pageX - startX2);
}

const dragStop2 = () => {
    isDragging2 = false;
    carousel2.classList.remove("dragging");
}

const infiniteScroll2 = () => {
    // Если карусель находится в начале, прокручиваем в конец
    if(carousel2.scrollLeft === 0) {
        carousel2.classList.add("no-transition");
        carousel2.scrollLeft = carousel2.scrollWidth - (2 * carousel2.offsetWidth);
        carousel2.classList.remove("no-transition");
    }
    // Если карусель находится в конце, прокручиваем в начало
    else if(Math.ceil(carousel2.scrollLeft) === carousel2.scrollWidth - carousel2.offsetWidth) {
        carousel2.classList.add("no-transition");
        carousel2.scrollLeft = carousel2.offsetWidth;
        carousel2.classList.remove("no-transition");
    }

    // Очищаем существующий таймаут и запускаем автопрокрутку, если курсор мыши не находится над каруселью
    clearTimeout(timeoutId2);
    if(!wrapper2.matches(":hover")) autoPlay2();
}

// Получаем все изображения в карточках
const images2 = document.querySelectorAll('.card2 .img img');

// Добавляем обработчик события клика на каждое изображение
images2.forEach(image => {
    // Добавляем состояние для отслеживания текущего размера изображения
    let isZoomed = false;

    // Функция для увеличения изображения
    function zoomImage() {
        image.classList.add('zoomed'); // Добавляем класс для увеличенного изображения
        isZoomed = true;
    }

// Функция для сброса размеров изображения
    function resetImage() {
        image.classList.remove('zoomed'); // Удаляем класс для увеличенного изображения
        isZoomed = false;
    }


    // Обработчик события клика на изображение
    image.addEventListener('click', () => {
        // Если изображение не увеличено, увеличиваем его, иначе возвращаем к обычным размерам
        if (!isZoomed) {
            zoomImage();
        } else {
            resetImage();
        }
    });

    // Обработчик события нажатия клавиши Esc для закрытия изображения
    document.addEventListener('keydown', (event) => {
        if (isZoomed && event.key === 'Escape') {
            resetImage();
        }
    });
});


carousel2.addEventListener("mousedown", dragStart2);
carousel2.addEventListener("mousemove", dragging2);
document.addEventListener("mouseup", dragStop2);
carousel2.addEventListener("scroll", infiniteScroll2);
wrapper2.addEventListener("mouseenter", () => clearTimeout(timeoutId2));
