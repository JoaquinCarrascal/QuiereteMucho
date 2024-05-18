const password = document.getElementById("password");
const password2 = document.getElementById("password2");
const email = document.getElementById("email");
const phoneNumberInput = document.getElementById("ntelf");
const form = document.getElementById("regForm");
const alertPass = document.getElementById("notTheSamePass");
const alertMail = document.getElementById("invalidMail");
const alertTelf = document.getElementById("invalidTelf");



for (let field of form) {

    if (field.type === 'password') {

        field.nextElementSibling.addEventListener('pointerover', f => { field.type = 'text' });

        field.nextElementSibling.addEventListener('pointerout', f => { field.type = 'password' });

    }

}

form.addEventListener("submit", function (event) {

    if (password.value !== password2.value) {

        alertPass.classList.remove('d-none');

        event.preventDefault();

    }

    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    
    if (!emailPattern.test(email.value)) {

        alertMail.classList.remove('d-none');

        event.preventDefault();
        
    }

    const phoneNumber = phoneNumberInput.value.replace(/[\s-]/g, "");

    if (phoneNumber.length < 9 || !/^[67]/.test(phoneNumber)) {

        alertTelf.classList.remove('d-none');

        event.preventDefault();

    }

});