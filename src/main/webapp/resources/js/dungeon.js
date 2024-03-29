const warriorLevel = document.getElementById("warriorLevel");
const isAlive = document.getElementById("isAlive");

console.log(isAlive.value);

function slime(){
    if(isAlive.value == '사망'){
        alert("-----[던전 입장 불가]-----\n" + 
              "캐릭터가 사망한 상태입니다");
        return false;
    } else{
        if(warriorLevel.value >= 1){
            return confirm("슬라임 던전에 입장하시겠습니까?");
        } else{
            alert("------[던전 입장 불가]------\n" + 
                  "입장 가능한 레벨이 아닙니다!");
            return false;
        }
    }
};

function goblin(){
    if(isAlive.value == '사망'){
        alert("-----[던전 입장 불가]-----\n" + 
              "캐릭터가 사망한 상태입니다");
        return false;
    } else{
        if(warriorLevel.value >= 6){
            return confirm("고블린 던전에 입장하시겠습니까?");
        } else{
            alert("------[던전 입장 불가]------\n" + 
                  "입장 가능한 레벨이 아닙니다!");
            return false;
        }
    }
};

function orc(){
    if(isAlive.value == '사망'){
        alert("-----[던전 입장 불가]-----\n" + 
              "캐릭터가 사망한 상태입니다");
        return false;
    } else{
        if(warriorLevel.value >= 11){
            return confirm("오크 던전에 입장하시겠습니까?");
        } else{
            alert("------[던전 입장 불가]------\n" + 
                  "입장 가능한 레벨이 아닙니다!");
            return false;
        }
    }
};



