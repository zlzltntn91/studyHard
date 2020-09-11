// "use strict";

let arr = [];

function Obj() {
    this.key1 = "value1";
    this.key2 = "value2";
    this.length = Object.keys(this).length;
}

let objectConstructor = new Obj();

console.log(objectConstructor);

function Ajax(url, options) {
    if (typeof url === 'object') {
        this.options = url;
    }

    this.method = options.method;
    this.url = options.url || url;

    let xhr = new XMLHttpRequest();
    this.open = () => xhr.open(this.method, this.url);
    this.getStatus = xhr.status;
    xhr.onreadystatechange = () => console.log(xhr.statusText);
    this.send = () => xhr.send();
}

let testCall = new Ajax("http://211.232.75.144:8080", {
    url: "http://211.232.75.144:8080",
    method: "GET"
});

console.log(testCall);

console.log(testCall.open());
console.log(testCall.send());

console.log(testCall.getStatus);