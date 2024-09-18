// Получаем элементы
const modal = document.getElementById("modal");
const openModalBtn = document.getElementById("openModalBtn");
const closeModalBtn = document.querySelector(".close-btn");
const closeModalActions = document.querySelector(".close-modal");

// Открытие модального окна
openModalBtn.onclick = function() {
    modal.style.display = "flex";
}

// Закрытие модального окна по клику на кнопку "Закрыть"
closeModalBtn.onclick = function() {
    modal.style.display = "none";
}

closeModalActions.onclick = function() {
    modal.style.display = "none";
}

// Закрытие модального окна при клике вне его
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
