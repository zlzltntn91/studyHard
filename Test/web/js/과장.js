
// 테이블 데이터를 JSON 으로

window.onload = () => {
    console.log(this);
    var divList = document.getElementsByName('test');
    let parent;
    let jsonArray = [];

    for (var i = 0; i < divList.length; i++) {
        parent = divList[i];
        let jsonData = {};
        for (var j = 0; j < parent.children.length; j++) {
            let name = parent.children[j].getAttribute('name');
            jsonData[name] = parent.children[j].getAttribute('value');
            jsonArray[i] = jsonData;
        }
    }

    console.log(jsonArray);

};