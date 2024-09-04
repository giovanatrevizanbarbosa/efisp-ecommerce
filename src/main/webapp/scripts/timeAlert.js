document.addEventListener('DOMContentLoaded', () => {
    let alert = document.querySelector('.alert');

    if (alert) {
        alert.classList.remove('hidden');

        setTimeout(() => {
            alert.classList.add('hidden');
        }, 2500);
    }
});