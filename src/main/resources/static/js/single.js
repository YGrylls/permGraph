var data=[
    {"id":1,"name":"aaa"},
    {"id":2,"name":"bbb"}
];


function searchData(){
    console.log("search");
    data=[];
    $("#result").html("");
    if(data.length==0){
        $("#enti").html("<h2>"+"没有搜索结果"+"</h2>");
    }
    for(var i=0;i<data.length;i++) {
        str1 = "<tr>" +
            "<td>" + data[i].id + "</td>" +
            "<td>" + data[i].name + "</td>" +
            "<td>"+"<button onclick='showRelation(this)' class='btn btn-secondary' data-id="+data[i].id+">"+"查询实体关系"+"</button>"+ "</td>"+
            "</tr>";
        $("#result").append(str1);
    }
}

function showRelation(tar) {
    var id=tar.getAttribute("data-id");
    console.log(id);
}
