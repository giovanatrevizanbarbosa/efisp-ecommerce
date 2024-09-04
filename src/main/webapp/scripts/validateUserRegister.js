window.onload = initPage;

function initPage() {
    let form = document.querySelector('form');

    form.noValidate = true;

    form.addEventListener('submit', function(e) {
        let valid = processValidity(this);
        if (!valid) {
            e.preventDefault();
        }
    });
}

function processValidity(form) {
    validatePassword(form);
    return applyValidity(form);
}

function applyValidity(form) {
    let valid = true;
    let count = 0;
    let elements = form.elements;

    for (let i = 0; i < elements.length - 1; i++) {
        let element = elements[i];
        let span = document.getElementById(`error-${element.name}`);
        let input = document.querySelector(`input[name=${element.name}]`);

        if (!element.validity.valid) {
            span.innerHTML = element.validationMessage;
            span.classList.remove('hidden');
            input.classList.add('input-error');
            count++;
        } else {
            span.innerHTML = "";
            span.classList.add('hidden');
            input.classList.remove('input-error');
        }
    }

    if (count > 0) {
        valid = false;
    }

    return valid;
}

function validatePassword(form) {
    let password = form.querySelector('input[name=password]');
    let confirmPassword = form.querySelector('input[name=confirmPassword]');

    if (password.value !== confirmPassword.value) {
        password.setCustomValidity('Os valores dos campos de senha e confirmação de senha são diferentes.');
    } else {
        password.setCustomValidity('');
    }
}