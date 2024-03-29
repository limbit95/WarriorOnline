const warriorHp = document.getElementById("warriorhp");
const warriormaxHp = document.getElementById("warriormaxhp");

const slimeAttack = document.getElementById("slimeattack");

const hp = (warriorHp.value-slimeAttack.value);

function giveup(){
    if(confirm("전투 도중 도망치면 패널티가 발생합니다. \n도망치시겠습니까?")){
        if(hp < 0){
            alert("한 번의 공격을 허용하여 현재 체력 : [0/" + warriormaxHp.value + "]");
            return true;
        } else{
            alert("한 번의 공격을 허용하여 현재 체력 : [" + hp + "/" + warriormaxHp.value + "]");
            return true;
        }
    } else{
        return false;
    }
};