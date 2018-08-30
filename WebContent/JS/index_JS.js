/**
 * 
 */
var socket;

function connect() {
	
	
	socket=new WebSocket("ws://localhost:8080/MultiChoiceJSAssignment/navData");
	socket.onopen=function(evnt)
	{
		alert("Inside Open !!!");
		socket.send("Hi this is the message from Open Method !!");
	};
	socket.onclose=function(closeEvnt)
	{	
		alert("OnClose Event: "+closeEvnt);
	};
	socket.onmessage=function(evt) {    
		 	
		alert("Inside Message !!"+JSON.stringfy(evt.data));
		
		
        document.getElementById("rate").innerHTML=evt.data;          
     };
	
}

function onSendClick(title) {
	alert("socket ReadyState: "+socket.readyState+"Socket Open: "+socket.OPEN+" Title: "+title);
    if (socket.readyState != socket.OPEN) {
    	alert("Socket is not opening !!!");
        console.error("webSocket is not open: " + socket.readyState);
        return;
    }
    var msg ="Hello";
    alert("Message: "+msg);
    socket.send(msg);
}

