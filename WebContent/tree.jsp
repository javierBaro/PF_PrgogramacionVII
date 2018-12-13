<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Materias</title>
<link rel="stylesheet" type="text/css" href="static/ddf.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js?val=0"></script>
	<script type="text/javascript" src="static/createjs-2015.05.21.min.js"></script>
    <script type="text/javascript" src="static/flow.min.js"></script>
</head>
<body>
<%
		String tree = "", noRealizado = "";
		if (request.getAttribute("tree") != null) {
			tree = request.getAttribute("tree").toString();
		}
		if (request.getAttribute("noRealizado") != null) {
			noRealizado = request.getAttribute("noRealizado").toString();
		}
	%>
    <canvas id="canvas1" width="3000" height="900"></canvas>

    <script type="text/javascript">
   window.addEventListener("load", func);
    
    function func(){
        console.log("LOADED");
        
        var a = new flowjs.DiGraph();
        a.addPaths([<%=tree%>]);
        
        var notRed = [<%=noRealizado%>];
        
        // Advanced Example with loading animation
        var cf = new flowjs.DiFlowChart("canvas1", a);
        cf.draw();
        simuLoad(cf, a, notRed );    
    }
    
    
    function simuLoad(flowChart, graph, notRed ){
        var walker = new flowjs.GraphWalker(graph);
        walker.forEach(function(node){
        	var connect = true;
        	for (var i=0, len=notRed.length; i<len; i++) {
        	if(node.id== notRed [i])
        		connect=false;
        	}
            flowChart.updateItem(node.id, function(item){   	  
                    if(connect == true)
                    	{
                    	item.flowItem.color = "red";
                    if (item.connectors === undefined){return;}
                    item.connectors.forEach(function(conn){ conn.color = "red";});
                    	}
            });

        }, this);

    }
         
    </script>

</body>
</html>