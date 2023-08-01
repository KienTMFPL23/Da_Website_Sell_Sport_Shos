const  navLinks = document.querySelectorAll('.nav_link');
navLinks.forEach(navLink => {
    navLink.addEventListener('click',()=>{
        document.querySelector('.active').classList.remove('active');
        navLink.classList.add('active');
    });
} );


function filterFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("myDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        txtValue = a[i].textContent || a[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
    }
}