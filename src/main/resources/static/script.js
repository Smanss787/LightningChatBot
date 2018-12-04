var $firstName ="Prenom";
var $lastNAme = "Nom"
function getdate(){
	var currentdate = new Date();
	var datetime = currentdate.getDate() + "/"
    + (currentdate.getMonth()+1)  + "/" 
    + currentdate.getFullYear() + " at "  
    + currentdate.getHours() + ":"  
    + currentdate.getMinutes() + ":" 
    + currentdate.getSeconds();
	return datetime;
}



function connect() {
	var socket = new SockJS('/chat-messaging');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		console.log("connected: " + frame);
		stompClient.subscribe('/chat/messages', function(response) {
			var data = JSON.parse(response.body);
			draw("left", data.message, data.firstName);
		});
	});
}

function draw(side, text, firstName) {
	console.log("drawing...");
	var $date = getdate();
    var $message;
    $message = $($('.message_template').clone().html());
    $message.addClass(side).find('.text').html(text);
    $message.addClass(side).find('.name').html($firstName+" : ");
    $message.addClass(side).find('.date').html($date);
    $('.messages').append($message);
    return setTimeout(function () {
        return $message.addClass('appeared');
    }, 0);

}
function disconnect(){
	stompClient.disconnect();
}
function sendMessage(){
	var $date = getdate();
	stompClient.send("/app/message", {}, JSON.stringify({'message': $("#message_input_value").val(),
														 'from' : $firstName,
														 'date' : $date
														 }));

}