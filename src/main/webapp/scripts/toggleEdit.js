const submitBtn = document.getElementById('submitEdit');

function toggleEdit(button) {
    const form = document.querySelector('.change-profile');
    const inputs = form.querySelectorAll('input');
    const editPasswordButton = document.getElementById('editPasswordBtn');

    inputs.forEach(input => {
        input.classList.remove('pointer-events-none');
        input.classList.add('input-bordered');
        input.readOnly = false;
    });

    button.classList.add('hidden');
    editPasswordButton.classList.remove('hidden');
    submitBtn.classList.remove('hidden');
}

function togglePasswordEdit() {
    const changePasswordDiv = document.querySelector('.change-password');
    const toggleEditPasswordButton = document.getElementById('editPasswordBtn');
    const passwordInputs = changePasswordDiv.querySelectorAll('input');

    changePasswordDiv.classList.toggle('hidden');
    if(toggleEditPasswordButton.innerText === 'Manter Senha'){
        toggleEditPasswordButton.innerText = 'Alterar Senha'
    } else {
        toggleEditPasswordButton.innerText = 'Manter Senha';
    }

    passwordInputs.forEach(input => {
        input.classList.toggle('pointer-events-none');
        input.classList.toggle('input-bordered');
        input.readOnly = !input.readOnly;
        input.required = !input.required;
    });
}