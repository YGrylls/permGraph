function GroupExplorer(wrapper,config){
    var defaultConfig={
        data:{"nodes":[],"links":[]},
        width:window.innerWidth,
        height:500,
        distance:100
    };
    $.extend(true,defaultConfig,config);
    defaultConfig.data.links.forEach(function (e) {
        if(typeof e.source!="number"&&typeof e.target!="number"){
            var sourceNode = defaultConfig.data.nodes.filter(function (n) {
                    return n.name === e.source;
                })[0],
                targetNode = defaultConfig.data.nodes.filter(function (n) {
                    return n.name === e.target;
                })[0];
            e.source = sourceNode;
            e.target = targetNode;
        }
    });
    var _this=this,highlighted=null,dependsNode=[],dependsLinkAndText=[];
    this.color = d3.scale.category20();
    var zoom = d3.behavior.zoom()
        .scaleExtent([0.2,10])
        .on("zoom",function(){
            _this.zoomed();
        });

    this.vis = d3.select("#result").append("svg:svg")
        .attr("width", defaultConfig.width)
        .attr("height", defaultConfig.height)
        .call(zoom).on("dblclick.zoom", null);

    this.vis=this.vis.append('g').attr('class','all')
        .attr("width", defaultConfig.width)
        .attr("height", defaultConfig.height)


    this.force = d3.layout.force()
        .nodes(defaultConfig.data.nodes)
        .links(defaultConfig.data.links)
        .gravity(.0001)
        .distance(defaultConfig.distance)
        .charge(function(d){
            return (-10* d.index)
        })
        .size([defaultConfig.width,defaultConfig.height])
        .start();
    this.vis.append("svg:defs").selectAll("marker")
        .data(["end"])
        .enter().append("svg:marker")
        .attr("id","arrow")
        .attr('class','arrow')
        .attr("viewBox", "0 -5 10 10")
        .attr("refX", 27)
        .attr("refY", 0)
        .attr("markerWidth", 9)
        .attr("markerHeight", 16)
        .attr("markerUnits","userSpaceOnUse")
        .attr("orient", "auto")
        .append("svg:path")
        .attr("d", "M0,-5L10,0L0,5")
        .attr('fill','#666');

    this.link = this.vis.selectAll("line.link")
        .data(defaultConfig.data.links)
        .enter().append("svg:line")
        .attr("class", "link")
        .attr('stroke-width',1)
        .attr("x1", function(d) {
            return d.source.x;
        })
        .attr("y1", function(d) { return d.source.y; })
        .attr("x2", function(d) { return d.target.x; })
        .attr("y2", function(d) { return d.target.y; })
        .attr("marker-end","url(#arrow)")
        .attr('stroke','#999');

    var dragstart=function(d, i) {
        _this.force.stop();
        d3.event.sourceEvent.stopPropagation();
    };

    var dragmove=function(d, i) {
        d.px += d3.event.dx;
        d.py += d3.event.dy;
        d.x += d3.event.dx;
        d.y += d3.event.dy;
        _this.tick();
    };

    var dragend=function(d, i) {
        d.fixed = true;
        _this.tick();
        _this.force.resume();
    };

    this.nodeDrag = d3.behavior.drag()
        .on("dragstart", dragstart)
        .on("drag", dragmove)
        .on("dragend", dragend);


    this.highlightObject=function(obj){
        if (obj) {
            var objIndex= obj.index;
            dependsNode=dependsNode.concat([objIndex]);
            dependsLinkAndText=dependsLinkAndText.concat([objIndex]);
            defaultConfig.data.links.forEach(function(lkItem){
                if(objIndex==lkItem['source']['index']){
                    dependsNode=dependsNode.concat([lkItem.target.index])
                }else if(objIndex==lkItem['target']['index']){
                    dependsNode=dependsNode.concat([lkItem.source.index])
                }
            });
            _this.node.classed('inactive',function(d){
                return (dependsNode.indexOf(d.index)==-1)
            });
            _this.link.classed('inactive', function(d) {

                return ((dependsLinkAndText.indexOf(d.source.index)==-1)&&(dependsLinkAndText.indexOf(d.target.index)==-1))
            });

            _this.linetext.classed('inactive',function(d){
                return ((dependsLinkAndText.indexOf(d.source.index)==-1)&&(dependsLinkAndText.indexOf(d.target.index)==-1))
            });
        } else {
            _this.node.classed('inactive', false);
            _this.link.classed('inactive', false);
            _this.linetext.classed('inactive', false);
        }
    };

    this.highlightToolTip=function(obj){
        if(obj){
            _this.tooltip.html("<div class='title'>"+obj.permID+"的资料</div><table class='detail-info'><tr><td class='td-label'>照片：</td><td>xxx</td></tr>" +
                "<tr><td class='td-label'>其他：</td><td>xxx</td></tr><tr><td class='td-label'>链接：</td><td><a href='http://www.cnblogs.com/leyi'>韭菜茄子的博客</a></td></tr></table>")
                .style("left",(d3.event.pageX+20)+"px")
                .style("top",(d3.event.pageY-20)+"px")
                .style("opacity",1.0);
        }else{
            _this.tooltip.style("opacity",0.0);
        }
    };

    this.tooltip=d3.select("body").append("div")
        .attr("class","tooltip")
        .attr("opacity",0.0)
        .on('dblclick',function(){
            d3.event.stopPropagation();
        })
        .on('mouseover',function(){
            if (_this.node.mouseoutTimeout) {
                clearTimeout(_this.node.mouseoutTimeout);
                _this.node.mouseoutTimeout = null;
            }
        })
        .on('mouseout',function(){
            if (_this.node.mouseoutTimeout) {
                clearTimeout(_this.node.mouseoutTimeout);
                _this.node.mouseoutTimeout = null;
            }
            _this.node.mouseoutTimeout=setTimeout(function() {
                _this.highlightToolTip(null);
            }, 300);
        });

    this.node = this.vis.selectAll("g.node")
        .data(defaultConfig.data.nodes)
        .enter().append("svg:g")
        .attr("class", "node")
        .call(_this.nodeDrag)
        .on('mouseover', function(d) {
            if (_this.node.mouseoutTimeout) {
                clearTimeout(_this.node.mouseoutTimeout);
                _this.node.mouseoutTimeout = null;
            }
            _this.highlightToolTip(d);
        })
        .on('mouseout', function() {
            if (_this.node.mouseoutTimeout) {
                clearTimeout(_this.node.mouseoutTimeout);
                _this.node.mouseoutTimeout = null;
            }
            _this.node.mouseoutTimeout=setTimeout(function() {
                _this.highlightToolTip(null);
            }, 300);
        })
        .on('dblclick',function(d){
            _this.highlightObject(d);
            d3.event.stopPropagation();
        });
    d3.select("body").on('dblclick',function(){
        dependsNode=dependsLinkAndText=[];
        _this.highlightObject(null);
    });


    this.node.append("svg:image")
        .attr("class", "circle")
        .attr("xlink:href", "images/mobile.png")
        .attr("x", "-15px")
        .attr("y", "-15px")
        .attr("width", "30px")
        .attr("height", "30px");

    this.node.append("svg:text")
        .attr("class", "nodetext")
        .attr("dy", "30px")
        .attr('text-anchor','middle')
        .text(function(d) { return d.name })
        .attr('fill',function(d,i){
            return _this.color(i);
        });

    this.linetext=this.vis.selectAll('.linetext')
        .data(defaultConfig.data.links)
        .enter()
        .append("text")
        .attr("class", "linetext")
        .attr("x",function(d){ return (d.source.x + d.target.x) / 2})
        .attr("y",function(d){ return (d.source.y + d.target.y) / 2})
        .text(function (d) {
            return d.relation
        })
        .attr('fill',function(d,i){
            return _this.color(i);
        })
        .call(this.force.drag);

    this.zoomed=function(){
        _this.vis.attr("transform","translate("+d3.event.translate+") scale("+d3.event.scale+")")
    };


    var findMaxWeightNode=function(){
        var baseWeight= 0,baseNode;
        defaultConfig.data.nodes.forEach(function(item){
            if(item.weight>baseWeight){
                baseWeight=item.weight;
                baseNode=item
            }
        });
        if(typeof baseNode=="undefined"){
            return defaultConfig.data.nodes[0];
        }
        return baseNode;
    };

    this.tick=function() {
        var findMaxWeightNodeIndex=findMaxWeightNode().index;
        defaultConfig.data.nodes[findMaxWeightNodeIndex].x = defaultConfig.width / 2;
        defaultConfig.data.nodes[findMaxWeightNodeIndex].y = defaultConfig.height / 2;
        _this.link.attr("x1", function(d) { return d.source.x; })
            .attr("y1", function(d) { return d.source.y; })
            .attr("x2", function(d) { return d.target.x})
            .attr("y2", function(d) { return d.target.y;});
        _this.linetext.attr("x",function(d){ return (d.source.x + d.target.x) / 2})
            .attr("y",function(d){ return (d.source.y + d.target.y) / 2});
        _this.node.attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });
    };
    _this.force.on("tick", this.tick);

}

var template={
    "nodes":[
        {
            "name": value,
            "group": 1
        },
        {
            "name": "Napoleon",
            "group": 1
        },
        {
            "name": "Mlle.Baptistine",
            "group": 1
        },
        {
            "name": "Mme.Magloire",
            "group": 1
        },
        {
            "name": "CountessdeLo",
            "group": 1
        },
        {
            "name": "Geborand",
            "group": 1
        },
        {
            "name": "Champtercier",
            "group": 1
        },
        {
            "name": "Cravatte",
            "group": 1
        },
        {
            "name": "Count",
            "group": 1
        },
        {
            "name": "OldMan",
            "group": 1
        }
    ],
    "links":[
        // {
        //     "source": 0,
        //     "target": 1,
        // },
        // {
        //     "source": 8,
        //     "target": 9,
        // }
    ]
};

$("#search").click(function (event) {
    event.preventDefault();
    $("#result").html("");
    var name=$("#name").val();
    var category=$("#category").val();
    var data={
        "dbID1": 2042357,
        "dbID2": 2072872,
        "depth": 2

    };
    data=JSON.stringify(data);
    console.log(data);
    $.ajax({
        url:"/api/pathquery",
        type:"POST",
        data:data,
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        success:function (result) {
            console.log(result);
            GroupExplorer('#result',{
                data:template
            });
            console.log(data);
        },
        error:function (error) {
            console.log(error);
        }

    });
    // GroupExplorer('#result',
    //     {
    //         data: data
    //     });
});