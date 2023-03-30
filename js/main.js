// 사용변수
const GAME_TIME = 9;
let score = 0;
let time = GAME_TIME;
let isPlaying = false;
let timeInterval;
let checkInterval;
let words = [];

const wordInput = document.querySelector('.word-input');
const wordDisplay = document.querySelector('.word-display');
const scoreDisplay = document.querySelector('.score');
const timeDisplay = document.querySelector('.time');
const button = document.querySelector('.button');

// 렌더딩 되었을때 선언
init();

function init() {
  getWords();
  wordInput.addEventListener('input', checkMatch)
}

// 게임 실행
function run() {
  isPlaying = true;
  time = GAME_TIME;
  wordInput.focus();
  scoreDisplay.innerText = 0;
  // 함수를 1초마다 실행시켜주는 인터벌
  timeInterval = setInterval(countDown, 1000);
  checkInterval = setInterval(checkStatus, 50);
  buttonChange('게임 중')
}


function checkStatus() {
  if(!isPlaying && time === 0) {
    buttonChange("게임 시작")
    clearInterval(checkInterval)
  }
}


// 단어 불러오기
function getWords() {
  words = ['Hello', 'Banana', 'Apple', 'Cherry'];
  buttonChange('게임시작');
}


// 단어 일치 체크
function checkMatch () {
    // console.log(wordInput.value.toLowerCase() === wordDisplay.innerText.toLowerCase())
    if(wordInput.value.toLowerCase() === wordDisplay.innerText.toLowerCase()) {
      wordInput.value = "";
      // 게임중이아니면 점수 초기화
      if(!isPlaying) {
        return;
      }
      score++;
      scoreDisplay.innerText = score;
      time = GAME_TIME;
      // 소수점 나오기 때문에 floor 사용
      const randomIndex = Math.floor(Math.random() * words.length);
      wordDisplay.innerText = words[randomIndex]
    }
  }


function countDown() {
  // 남은 시간 0초되면 isPlaying 가 false됨
  time > 0 ? time-- : isPlaying = false;
  if(!isPlaying) {
    clearInterval(timeInterval)
  }
  timeDisplay.innerText = time;
}



function buttonChange(text) {
  button.innerText = text;
  text === '게임시작' ? button.classList.remove('loading') : button.classList.add('loading');
}