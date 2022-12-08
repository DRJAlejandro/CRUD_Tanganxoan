let box = document.getElementById("box");
let shadowB = "";
for (var i = 0; i < 200; i++) {
  shadowB +=
    (shadowB ? "," : "") +
    i * 1 +
    "px " +
    i * 1 +
    "px 0 rgba(37, 115, 149, 0.111)";
}
box.style.boxShadow = shadowB;

let circleC = document.getElementById("circle-c");
let shadowC = "";
for (var i = 0; i < 20; i++) {
  shadowC +=
    (shadowC ? "," : "") +
    i * 1 +
    "px " +
    i * 1 +
    "px 0 rgba(0, 0, 0, 0.011)";
}
circleC.style.boxShadow = shadowC;

let iconClient = document.getElementById("icon-client");
let shdowI = "";
for (var i = 0; i < 20; i++) {
  shdowI +=
    (shdowI ? "," : "") +
    i * 1 +
    "px " +
    i * 1 +
    "px 0 rgba(0, 0, 0, 0.011)";
}
iconClient.style.textShadow = shdowI;



let title = document.getElementById("title");
let shdowT = "";
for (var i = 0; i < 10; i++) {
  shdowT +=
    (shdowT ? "," : "") +
    i * 1 +
    "px " +
    i * 1 +
    "px 0 rgba(0, 0, 0, 0.011)";
}
title.style.textShadow = shdowT;


let iconX = document.getElementById("icon-x");
let shdowIX = "";
for (var i = 0; i < 15; i++) {
  shdowIX +=
    (shdowIX ? "," : "") +
    i * 1 +
    "px " +
    i * 1 +
    "px 0 rgba(0, 0, 0, 0.011)";
}
iconX.style.textShadow = shdowIX;

let circleX = document.getElementById("circle-x");
circleX.style.boxShadow = shadowC;

const dName = document.getElementById("forms__name");
const dLastName = document.getElementById("forms__last-name");
const dPhone = document.getElementById("forms__phone");
const dDescription = document.getElementById("forms__description");
const dPrice = document.getElementById("forms__price");
const dDate = document.getElementById("forms__date");
const dCost = document.getElementById("forms__cost");
const dButtonAdd = document.getElementById("forms__add");
const dButtonAddClient = document.getElementById("forms__addClient");
const dButtonAddEmploye = document.getElementById("forms__addEmploye");
const dButtonAddHorse = document.getElementById("forms__addHorse");
const dButtonAddService = document.getElementById("forms__addService");
const dButtonAddSale = document.getElementById("forms__addSale");
const form = document.getElementById("box");
const dModal = document.getElementById("modal");
const dcerrar = document.getElementById("button__cerrar");
const dModalT = document.getElementById("modal__text");

const symbols = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;
const numbers = /[1234567890]/;
const letters = /[ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz]/;
const spaces = /[ ]/;



//dButtonAdd.onclick = clickAdd;
//dcerrar.addEventListener("click", function () { modal.style.display = "none" });

dcerrar.addEventListener("click", function () { modal.style.display = "none"});

if(dButtonAddClient != null){
  dButtonAddClient.addEventListener("click", clickAddClient);
} else if (dButtonAddEmploye != null){
  dButtonAddEmploye.addEventListener("click", clickAddEmploye);
} else if(dButtonAddHorse != null){
  dButtonAddHorse.addEventListener("click", clickAddHorse);
} else if(dButtonAddService){
  dButtonAddService.addEventListener("click", clickAddService);
} if (dButtonAddSale){
  dButtonAddSale.addEventListener("click", clickAddSale);
}


function showModal(message) {
  modal.style.display = "flex";
  dModalT.textContent = message;
}

function validateName() {
  let bandera = false
  let name = dName.value;

  if (name.length == 0) {
    showModal("No deje el nombre vacio");
  }
  else if (symbols.test(name)) {
    showModal("No se permiten simbolos en el nombre");
  }
  else if (numbers.test(name)) {
    showModal("No se permiten numeros en el nombre");
  }
  else if (spaces.test(name)) {
    showModal("No se permiten espacios en el nombre");
  }
  else {
    bandera = true;
  }
  return bandera;
}

function validateLastName() {
  let bandera = false
  let lastName = dLastName.value;

  if (lastName.length == 0) {
    showModal("No deje el apellido vacio");
  }
  else if (symbols.test(lastName)) {
    showModal("No se permiten simbolos en los apellidos");
  }
  else if (numbers.test(lastName)) {
    showModal("No se permiten simbolos en los apellidos");
  }
  else {
    bandera = true;
  }
  return bandera;
}

function validatePhone() {
  let bandera = false
  let phone = dPhone.value;

  if (phone.length == 0) {
    showModal("No deje el numero de telefono vacio");
  }
  else if (symbols.test(phone)) {
    showModal("No se permiten simbolos en el telefono");
  }
  else if (spaces.test(phone)) {
    showModal("No ponga espacios en telefono");
  }
  else if (letters.test(phone)) {
    showModal("No ponga letras en el telefono");
  }
  else {
    bandera = true;
  }
  return bandera;
}

function validateDescription() {
  let bandera = false
  let description = dDescription.value;

  if (description.length == 0) {
    showModal("No deje la descripcion vacia");
  }
  else {
    bandera = true;
  }
  return bandera;
}

function validatePrice() {
  let bandera = false
  let price = dPrice.value;

  if (price.length == 0) {
    showModal("No deje el precio vacio");
  }
  else if (symbols.test(price)) {
    showModal("No se permiten simbolos en el precio");
  }
  else if (spaces.test(price)) {
    showModal("No ponga espacios en precio");
  }
  else if (letters.test(price)) {
    showModal("No ponga letras en el precio");
  }
  else {
    bandera = true;
  }
  return bandera;
}

function validateCost() {
  let bandera = false
  let cost = dCost.value;

  if (cost.length == 0) {
    showModal("No deje el costo total vacio");
  }
  else if (symbols.test(cost)) {
    showModal("No se permiten simbolos en el costo total");
  }
  else if (spaces.test(cost)) {
    showModal("No ponga espacios en costo total");
  }
  else if (letters.test(cost)) {
    showModal("No ponga letras en el costo total");
  }
  else {
    bandera = true;
  }
  return bandera;
}

function validateDate() {
  let bandera = false
  let date = dDate.value;

  if (date.length == 0) {
    showModal("No deje la fecha vacia");
  }
  else if (spaces.test(date)) {
    showModal("No ponga espacios en la fecha");
  }
  else if (letters.test(date)) {
    showModal("No ponga letras en la fecha");
  }
  else {
    bandera = true;
  }
  return bandera;
}

//function clickAdd() {
//Para Equino
  //if (dLastName == null && dPhone == null && dDescription == null && dPrice == null) {
   // if (validateName()) {

    //  form.submit();

   // }
 // } //Cliente y Empleado
 // else if (dDescription == null && dPrice == null) {
  // if (validateName() && validateLastName() && validatePhone()) {
  //    form.submit();

  //  }
 // } //Servicio
 // else if (dLastName == null && dPhone == null) {
 //   if (validateName() && validateDescription() && validatePrice()) {
      //form.submit();
 //  }
 // }
//  else {
//    if (validateName() && validateLastName() && validatePhone() && validateDescription && validatePrice) {
//      form.submit();
//    }
//  }

//Agregar y Udate Cliente
function clickAddClient(){
  if (validateName() && validateLastName() && validatePhone()){
    form.submit();
  }
}
function clickAddEmploye(){
  if(validateName() && validateLastName() && validatePhone()){
    form.submit();
  }
}
function clickAddHorse(){
  if(validateName()){
    form.submit();
  }
}
function clickAddService(){
  if(validateName() && validateDescription() && validatePrice()){
    form.submit();
  }
}
function clickAddSale(){
  if(validateDate() && validateCost()){
    form.submit();
  }
}

const updateButton = document.getElementsByClassName("update__buton");
