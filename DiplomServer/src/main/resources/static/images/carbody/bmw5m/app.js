const sizes = document.querySelectorAll('.size');
const colors = document.querySelectorAll('.color');
const shoes = document.querySelectorAll('.shoe');
const gradients = document.querySelectorAll('.gradient');
const shoeBg = document.querySelector('.shoeBackground');

const textColorBody = document.querySelectorAll('.textBody');

let prevColor = "blue";
let animationEnd = true;

function changeSize() {
    sizes.forEach(size => size.classList.remove('active'));
    this.classList.add('active');
}

function changeColor() {
    colors.forEach(c => c.classList.remove('active'));
    this.classList.add('active');
    let primary = this.getAttribute('primary');
    let color = this.getAttribute('color');
    let shoe = document.querySelector(`.shoe[color="${color}"]`);
    let gradient = document.querySelector(`.gradient[color="${color}"]`);
    let prevGradient = document.querySelector(`.gradient[color="${prevColor}"]`);

    if (color == prevColor) return;

    document.documentElement.style.setProperty('--primary', primary);

    shoes.forEach(s => s.classList.remove('show'));
    shoe.classList.add('show');

    gradients.forEach(g => g.classList.remove('first', 'second'));
    gradient.classList.add('first');
    prevGradient.classList.add('second');

    prevColor = color;
    animationEnd = false;

    gradient.addEventListener('animationend', () => {
        animationEnd = true;
    });

    // Toggle visibility of textBody elements based on color selection
    textColorBody.forEach((p, index) => {
        p.style.display = index === Array.from(colors).indexOf(this) ? 'block' : 'none';
    });
}

function changeColorAndTextBody(index) {
    const colorText = colors[index].getAttribute('colorText');

    document.documentElement.style.setProperty('--primary', colorText);

    textColorBody.forEach((p, i) => {
        p.style.color = i === index ? colorText : 'white';
        p.style.display = i === index ? 'block' : 'none';
        p.classList.toggle('active', i === index);
    });

    prevColor = colorText;
    animationEnd = false;
}

sizes.forEach(size => size.addEventListener('click', changeSize));

colors.forEach(c => c.addEventListener('click', changeColor));

colors.forEach((span, index) => {
    span.addEventListener('click', () => {
        changeColorAndTextBody(index);
    });
});

textColorBody.forEach(p => p.addEventListener('click', changeTextBodyColor));

let x = window.matchMedia("(max-width: 1000px)");

function changeHeight() {
    if (x.matches) {
        let shoeHeight = shoes[0].offsetHeight;
        shoeBg.style.height = `${shoeHeight * 0.9}px`;
    } else {
        shoeBg.style.height = "475px";
    }
}

changeHeight();

window.addEventListener('resize', changeHeight);
