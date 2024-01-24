/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const button1 = document.getElementById('b1');
const button2 = document.getElementById('b2');
const button3 = document.getElementById('b3');
const button4 = document.getElementById('b4');
const checkButton = document.getElementById('checkButton');
const nextButton = document.getElementById('nextButton');
var level;
var result;
var userNumber;
var randomNumber;
var seconds = 0;
var minutes = 0;
var total = 0;
var correct = 0;
var wrong = 0;
var upperLimit, lowerLimit;
let keys = [];

button1.addEventListener('click', function(){
    upperLimit = 20;
    lowerLimit = 0;
    seconds = 0;
    minutes = 0;
    start(lowerLimit, upperLimit);
});

button2.addEventListener('click', function(){
    upperLimit = 99;
    lowerLimit = 21;
    seconds = 0;
    minutes = 0;
    start(lowerLimit, upperLimit);
});

button3.addEventListener('click', function(){
    upperLimit = 999;
    lowerLimit = 100;
    seconds = 0;
    minutes = 0;
    start(lowerLimit, upperLimit);
});

button4.addEventListener('click', function(){
    upperLimit = 5000;
    lowerLimit = 1000;
    seconds = 0;
    minutes = 0;
    start(lowerLimit, upperLimit);
});

checkButton.addEventListener('click', check);

nextButton.addEventListener('click', next);

input2=document.getElementById('userNumber');
input2.addEventListener('input', function(){
    var splitValue = input2.value.split('');
    var charactersToFilter = 0;
    var filteredSplitValue = splitValue.map(function(character) {
            if(!new RegExp('\\d').test(character)) {
                charactersToFilter++;
                return '';
            }
            return character;
        });
    if(!charactersToFilter) 
        return;
    input2.value = filteredSplitValue.join('');
    /*
     * We need to keep track of the caret position, which is the `selectionStart`
     * property, otherwise if our caret is in the middle of the value, pressing an
     * invalid character would send our caret to the end of the value.
     */
    var charactersBeforeSelectionStart = filteredSplitValue.slice(0, input2.selectionStart);
    var filteredCharactersBeforeSelectionStart = charactersBeforeSelectionStart.filter(function(character) {
            return !character;
        });
    var totalFilteredCharactersBeforeSelectionStart = filteredCharactersBeforeSelectionStart.length;
    var newSelectionStart = input2.selectionStart - totalFilteredCharactersBeforeSelectionStart;
    
    input2.selectionStart = newSelectionStart;
    input2.selectionEnd = input2.selectionStart;
    
}, false);

input2.addEventListener('input', function(){
    if(input2.value.length > input2.maxlength){
        input2.value = input2.value.substr(0, input2.maxlength);
    }
});

input2.addEventListener('keydown', function(e){
    if(e.key === 'Enter')
        if(keys.length === 0){
            keys.push(e.key);
            check();
        }
        else {
            keys.splice(0,1);
            next();
        }
});

function getRandomIntInclusive(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1) + min); // The maximum is inclusive and the minimum is inclusive
}

function countTime(){
    seconds++;
    if(seconds===60){
        minutes++;
        seconds=0;
    }
    document.getElementById('time').textContent = "Time: " +minutes+":"+seconds;   
}

function start(min, max){
    const div = document.getElementById('content');
    div.style.display = 'flex';
    result = getRandomIntInclusive(min,max);
    random1 = getRandomIntInclusive(min,result);
    random2 = result - random1;
    document.getElementById('randomNumber1').textContent = random1;
    document.getElementById('randomNumber2').textContent = random2;
    setCharLimit();
    if(document.getElementById('time').textContent === "Time: 0:0")
        setInterval(countTime,1000);   
}

function setCharLimit(){
    let answer = Number.parseInt(document.getElementById('randomNumber1').textContent) + Number.parseInt(document.getElementById('randomNumber2').textContent);
    let digit = 1;
    while((Number.parseInt(answer/10))!== 0){
        answer = Number.parseInt(answer/10);
        digit++;
    }
    document.getElementById('userNumber').maxlength = digit;
    input = document.getElementById('userNumber');
}

function check(){
    userNumber = Number.parseInt(document.getElementById('userNumber').value);
    result = Number.parseInt(document.getElementById('randomNumber1').textContent) + Number.parseInt(document.getElementById('randomNumber2').textContent);
    document.getElementById('askimg').style.display = 'none';
    document.getElementById('wrongimg').style.display = 'none';
    document.getElementById('correctimg').style.display = 'none';
    if(userNumber === result){
        correct++;
        document.getElementById('correctimg').style.display = 'flex';
    }else{
        wrong++;
        document.getElementById('wrongimg').style.display = 'flex';
    }
    total=wrong+correct;
    document.getElementById('total').textContent = "Total: "+total;
    document.getElementById('correct').textContent = "Correct: "+correct;
    document.getElementById('wrong').textContent = "Wrong: "+wrong;
    userNumber.value = 'none';
}

function next(){
    result = getRandomIntInclusive(lowerLimit,upperLimit);
    random1 = getRandomIntInclusive(lowerLimit,result);
    random2 = result - random1;
    document.getElementById('randomNumber1').textContent = random1;
    document.getElementById('randomNumber2').textContent = random2;
    document.getElementById('userNumber').value = "";
    document.getElementById('askimg').style.display = 'flex';
    document.getElementById('wrongimg').style.display = 'none';
    document.getElementById('correctimg').style.display = 'none';
    setCharLimit();
}


