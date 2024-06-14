let show = document.querySelector('.search-box__btn')
let searchBox = document.querySelector('.search-box')

let dropdownBtn = document.querySelector('.btn-dropdown')
let dropdownMenu = document.querySelector('.dropdown_content')

let listProduct = document.querySelector('.fr-product-grid')
let iconCartSpan = document.querySelector('.icon.cart span');
let totalQuantity = 0;

// show.addEventListener('click', function(){
//     searchBox.classList.toggle('open')
// })

dropdownBtn.addEventListener('click', function(){
    dropdownMenu.classList.toggle('show')
    dropdownBtn.classList.toggle('rotate')
})

// listProduct.addEventListener('click', (even) =>{
//     let positionClick = even.target;
//     if(positionClick.classList.contains('addCart')){
//         totalQuantity += 1;
//     }
//     addCountToHTML();
//     addCountToMemory();
// })

const addCountToHTML = () =>{
    if(totalQuantity == 0){
        iconCartSpan.classList.remove("shower")
    } else {
        iconCartSpan.classList.add("shower")
    }
    iconCartSpan.innerText = totalQuantity;
}

const addCountToMemory = () => {
    localStorage.setItem('count', JSON.stringify(totalQuantity));
}

const initApp = () => {
    if(localStorage.getItem('count')){
        totalQuantity = JSON.parse(localStorage.getItem('count'));
        addCountToHTML();
    }
}

initApp(); // goi ham