/**
 * 
 */

function test()
{
	
alert("Hello ");

}

var socket;

function connect() {
	
	alert("Hello Web Socket Connect !!!");
	socket=new WebSocket("ws://localhost:8080/MultiChoiceJSAssignment/navData");
	socket.onclose=function(closeEvnt)
	{
		alert("OnClose Event: "+closeEvnt);
	};
	socket.onmessage=function(evt) {    
		 	
		alert("Inside Message !!"+evt.data);
		
		
        document.getElementById("rate").innerHTML=evt.data;          
     };
	
}


function onSendClick() {
	alert("socket ReadyState: "+socket.readyState+"Socket Open: "+socket.OPEN);
    /*if (socket.readyState != socket.OPEN) {
    	alert("Socket is not opening !!!");
        console.error("webSocket is not open: " + socket.readyState);
        return;
    }*/
    var msg = "Connection Established !!";
    alert("Message: "+msg);
    socket.send(msg);
}