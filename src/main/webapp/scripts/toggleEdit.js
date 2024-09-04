const submitBtn = document.getElementById('submitEdit');

function toggleEdit(button) {
    const form = button.parentNode.parentNode;
    const inputs = form.querySelectorAll('input');
    const selects = form.querySelectorAll('select');
    const editPasswordButton = document.getElementById('editPasswordBtn');

    inputs.forEach(input => {
        input.classList.remove('pointer-events-none');
        input.classList.add('input-bordered');
        input.readOnly = false;
    });

    selects.forEach(select => {
        select.classList.remove('pointer-events-none');
        select.classList.add('select-bordered');
    })
    button.classList.add('hidden');
    editPasswordButton.classList.remove('hidden');
    submitBtn.classList.remove('hidden');
}

function togglePasswordEdit() {
    const changePasswordDiv = document.querySelector('.change-password');
    const passwordInputs = changePasswordDiv.querySelectorAll('input');

    changePasswordDiv.classList.toggle('hidden');

    passwordInputs.forEach(input => {
        input.classList.remove('pointer-events-none');
        input.classList.add('input-bordered');
        input.readOnly = false;
        input.required = true;
    });
}