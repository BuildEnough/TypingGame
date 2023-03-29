// 사용변수
let score = 0;
let time = 3;
let isPlaying = false;
let timeInterval;

const wordInput = document.querySelector('.word-input');
const wordDisplay = document.querySelector('.word-display');
const scoreDisplay = document.querySelector('.score');
const timeDisplay = document.querySelector('.time');
const button = document.querySelector('.button');

wordInput.addEventListener('input', () => {
  console.log(wordInput.value.toLowerCase() === wordDisplay.innerText.toLowerCase())
  if(wordInput.value.toLowerCase() === wordDisplay.innerText.toLowerCase()) {
    score++;
    scoreDisplay.innerText = score;
    wordInput.value = "";
  }
})

buttonChange('게임시작');

function run() {
  // 함수를 1초마다 실행시켜주는 인터벌
  timeInterval = setInterval(countDown, 1000);
}

function countDown() {
  time > 0 ? time-- : isPlaying = false;
  timeDisplay.innerText = time;
}



function buttonChange(text) {
  button.innerText = text;
  text === '게임시작' ? button.classList.remove('loading') : button.classList.add('loading');
}