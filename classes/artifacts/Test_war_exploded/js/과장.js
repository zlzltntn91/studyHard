
// 테이블 데이터를 JSON 으로

window.onload = () => {


    var divList = document.getElementsByName('test');
    let div;
    let jsonArray = [];

    for (var i = 0; i < divList.length; i++) {
        div = divList[i];
        let jsonData = {};
        for (var j = 0; j < div.children.length; j++) {
            let name = div.children[j].getAttribute('name');
            jsonData[name] = div.children[j].getAttribute('value');
            jsonArray[i] = jsonData;
        }
    }
    console.log(jsonArray);
};