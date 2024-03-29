// 유효성 검사 객체
const checkObj = {"warriorName" : false};



// 아이디 유효성 검사
const warriorName = document.getElementById("warriorName");

warriorName.addEventListener("change", function() {
    const regExp = /^[a-z, ㄱ-힣, 0-9]{2,10}$/;

    if(regExp.test(this.value)) {
        this.style.backgroundColor = "green";
        this.style.color = "white";
        checkObj["warriorName"] = true;
    } else {
        this.style.backgroundColor = "red";
        this.style.color = "white";
        checkObj["warriorName"] = false;
    }
});

// 최종적으로 유효성 검사 객체인 checkObj 안에 있는 모든 value 가
// true 인지 확인해주는 함수
// 만약 모두 true이면 -> 서버로 submit
// 만약 하나라도 false면 -> 유효성 검사가 완료되지 않았습니다.
function validate() {
    if( !checkObj["warriorName"] ) {
        alert("작성 조건에 부합하지 않는 이름입니다!");
        return false;
    }
    return true;
};