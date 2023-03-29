// 사용변수
let score = 0;
let time = 9;
let isPlaying = false;

const wordInput = document.querySelector('.word-input');
const wordDisplay = document.querySelector('.word-display');
const scoreDisplay = document.querySelector('.score');
const timeDisplay = document.querySelector('.time');

wordInput.addEventListener('input', () => {
  console.log(wordInput.value.toLowerCase() === wordDisplay.innerText.toLowerCase())
  if(wordInput.value.toLowerCase() === wordDisplay.innerText.toLowerCase()) {
    score++;
    scoreDisplay.innerText = score;
    wordInput.value = "";
  }
})

// 함수를 1초마다 실행시켜주는 인터벌
setInterval(countDown, 1000);

function countDown(){
  time > 0 ? time-- : isPlaying = false;
  timeDisplay.innerText = time;
}