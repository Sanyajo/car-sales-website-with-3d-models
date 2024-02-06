document.addEventListener('DOMContentLoaded', function() {
    const fioInput = document.getElementById('fioInput');
    const phoneNumberInput = document.getElementById('phoneNumberInput');
    const submitButton = document.getElementById('submitButton');
    const carSelect = document.getElementById('carSelection');

    function checkInputs() {
        if (fioInput.value.trim() !== '' && phoneNumberInput.value.trim() !== '' && carSelect.value.trim() !== '') {
            submitButton.classList.add('enabled');
            submitButton.removeAttribute('disabled');
        } else {
            submitButton.classList.remove('enabled');
            submitButton.setAttribute('disabled', true);
        }
    }

    fioInput.addEventListener('input', checkInputs);
    phoneNumberInput.addEventListener('input', checkInputs);
    carSelect.addEventListener('change', checkInputs);
});
