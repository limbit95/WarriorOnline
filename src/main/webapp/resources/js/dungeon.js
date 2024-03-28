const warriorLevel = document.getElementById("warriorLevel");


function slime(){
    if(warriorLevel.value >= 1 && warriorLevel.value <= 5){
        return confirm("슬라임 던전에 입장하시겠습니까?");
    } else{
        alert("입장 가능한 레벨이 아닙니다!");
        return false;
    }
};

function goblin(){
    if(warriorLevel.value >= 6 && warriorLevel.value <= 10){
        return confirm("고블린 던전에 입장하시겠습니까?");
    } else{
        alert("입장 가능한 레벨이 아닙니다!");
        return false;
    }
};

function orc(){
    if(warriorLevel.value >= 11 && warriorLevel.value <= 15){
        return confirm("오크 던전에 입장하시겠습니까?");
    } else{
        alert("입장 가능한 레벨이 아닙니다!");
        return false;
    }
};



