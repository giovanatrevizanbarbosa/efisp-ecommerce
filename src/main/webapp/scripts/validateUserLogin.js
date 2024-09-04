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
    return applyValidity(form);
}

function applyValidity(form) {
    let valid = true;
    let count = 0;
    let elements = form.elements;

    for (let i = 0; i < elements.length - 1; i++) {
        let element = elements[i];
        let input = document.querySelector(`input[name=${element.name}]`);

        if (!element.validity.valid) {
            input.classList.add('input-error');
            count++;
        } else {
            input.classList.remove('input-error');
        }
    }

    if (count > 0) {
        valid = false;
    }

    return valid;
}