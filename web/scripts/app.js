/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global isSeatBooked */

 function getSeatingDetails(isSeatBooked) {
    var ajaxRequest = $.ajax("BookingServlet?isSeatBooked=" + isSeatBooked);
    if (isSeatBooked) {
        for (var id in document) {
         document.getElementById(id).style.property = 'color:red';   
        }
    }
    return ajaxRequest.promise();
}
;

 function getLatestSeatingLayout(seatingLayout) {
    var ajaxRequest = $.ajax({url: "BookingServlet", type: "GET", data: {seats: seatingLayout}});

    return ajaxRequest.promise();

}
;

/*Calls the Servlet with message in parameter*/
 function postTwitAboutProduct(message, imgURI) {
    var aReqTwitPromise = $.ajax({url: "TwitterServlet", type: "POST", data: {msg: message, imgUri: encodeURI(imgURI)}}).promise();
    return aReqTwitPromise;
}
;

function showEvents(color){
 if(color==='event-all'){
   $('button').css(document.getElementById(id).style.property = 'color:red');
 }else{
   $('button').css('display','none');
   $('button.'+color.replace('event-','')).css('display','block');
 }
}





