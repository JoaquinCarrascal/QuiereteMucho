const form = document.getElementById("login");

for (let field of form) {

    if (field.type === 'password') {

        field.nextElementSibling.addEventListener('pointerover', f => { field.type = 'text' });

        field.nextElementSibling.addEventListener('pointerout', f => { field.type = 'password' });

    }

}