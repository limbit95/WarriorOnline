const statPoint = document.getElementById("statpoint");


function add(){
    if(confirm("해당 능력치를 추가하시겠습니까?")){
        if(statPoint.value == 0){
            alert("-----[스탯 포인트 부족]-----");
            return;
        } else{
            alert("능력치 추가 성공!!!");
            return;
        }
    } else{
        return false;
    }
};