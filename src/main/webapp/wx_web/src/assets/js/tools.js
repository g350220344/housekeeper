let getQueryString = function getQueryString(key){
    var reg = new RegExp("(^|&)"+key+"=([^&]*)(&|$)");
    var result = location.search.substr(1).match(reg);
    return result?decodeURIComponent(result[2]):null;
}

let getLength = function(str) {
    return str.replace(/[\u0391-\uFFE5]/g,"aa").length;  //先把中文替换成两个字节的英文，在计算长度
};  

export default {
    'getQueryString': getQueryString,
    'getLength': getLength
}