let form = document.forms.regForm;

let alert = document.getElementById('alertFormNotValid');

for (let field of form) {

    if (field.type === 'password') {

        field.nextElementSibling.addEventListener('pointerover', f => { field.type = 'text' });

        field.nextElementSibling.addEventListener('pointerout', f => { field.type = 'password' });

    }

    if(field.name === 'submitButton'){

        field.addEventListener('click', processForm);

    }

    if(field.name === 'submitButton2'){

        field.addEventListener('click', processForm);

    }

}

function containsNumber(inputString) {

    return /\d/.test(inputString);

}

function mailValidation() {

    let mail = document.getElementById('email').value;

    return (mail.match('[Aa-zZ||0-9]+@[[Aa-zZ||0-9]+\.[Aa-zZ]{2,}')) ? true : false ;

}

function passValidation() {

    let password = document.getElementById("password").value;

    let password2 = document.getElementById("password2").value;

    if (password.includes(" ")) { 

        return false;

    }

    return (password === password2 && isBetween(password.length, 2, 12) && containsNumber(password)) ? true : false;

}

function numTelfValidation() {

    let numTelf = document.getElementById("ntelf-field-reg");

    return (isBetween(numTelf, 9, 12)) ? true : false;

}

//todo process form

function processForm () {

let validation = true;

if(!mailValidation()){

    validation = false;

}

if(!passValidation()){

    validation = false;

}

if(!numTelfValidation()){

    validation = false;

}

if(validation) {

    form.submit();

}else{

    alert('No se puede enviar el formulario');

}

}