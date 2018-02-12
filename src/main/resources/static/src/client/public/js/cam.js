var img=null;
document.addEventListener('DOMContentLoaded', function () {

    var video = document.querySelector('#camera-stream'),
        image = document.querySelector('#snap'),
        error_message = document.querySelector('#error-message');

    navigator.getMedia = (

        navigator.getUserMedia ||
        navigator.webkitGetUserMedia ||
        navigator.mozGetUserMedia ||
        navigator.msGetUserMedia ||
        navigator.mediaDevices.getUserMedia
    );


    if(!navigator.getMedia){
        displayErrorMessage("Your browser doesn't have support for the navigator.getUserMedia interface.");
    }
    else navigator.getMedia(
        {
            video: true,
            audio: false
        },
        function (stream) {
            video.src = window.URL.createObjectURL(stream);

            video.play();

            video.onplay = function () {
                showVideo();
            };

        },
        function (err) {
            displayErrorMessage("There was an error with accessing the camera stream: " + err.name, err);
        }
    );
    function takeSnapshot() {

        var hidden_canvas = document.querySelector('canvas'),
            context = hidden_canvas.getContext('2d');

        var width = video.videoWidth,
            height = video.videoHeight;

        if (width && height) {

            hidden_canvas.width = width;
            hidden_canvas.height = height;

            context.drawImage(video, 0, 0, width, height);

            return hidden_canvas.toDataURL('image/png');
        }
    }

    function takingSnap(){
        setTimeout(function (){var snap = takeSnapshot();
            img=snap;
            video.pause();
            image.setAttribute('src', snap);


            },10000);


    }


    function takingSnap(){
        var setIntervalId = setInterval(function(){var snap = takeSnapshot();
        img=snap;
        image.setAttribute('src', snap);

            var a={image:img};
            $.ajax({
                type: "POST",
                url: "/controlImg",
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                data: JSON.stringify(a),
                success: function(dataString) {
                    if(dataString.status==="success"){
                        updateStatus(20);
                        document.getElementById("loader").style.visibility="visible";
                        clearInterval(setIntervalId);
                        video.pause();
                        updateStatus(40);
                        $.ajax({
                            type: "POST",
                            url: "/recognize",
                            contentType: 'application/json; charset=utf-8',
                            dataType: 'json',
                            data: JSON.stringify(a),
                            success:function(detailsString){
                                updateStatus(60);
                                document.getElementById("loader").style.display = "none";
                                detailsContainer=document.getElementById("container2");
                                if(detailsString.employeeId===null){
                                    updateStatus(100);
                                    detailsContainer.innerHTML="<div><h2>NO PERSON DETAILS FOUND.</h2></br><h3>Try again by following the instructions or consult the admin</h3></br><button id='register' onclick='register()'>REGISTER</button></div>"
                                    updateStatus(0);
                                    document.getElementById("loader").style.visibility="hidden";
                                }
                                else {
                                    updateStatus(100);
                                    detailsContainer.innerHTML = "<div><h2>PERSON DETAILS:</h2> </br></br> <ul> <li>ID:" + detailsString.employeeId + "</li> <li>Name: " + detailsString.name + "</li> <li>Designation: " + detailsString.designation + "</li> </ul></div></<br><button id='openDoor' onclick='opendoor()'>OPEN DOOR</button></div>";
                                }
                                function opendoor(){
                                    updateStatus(0);
                                    video.play();
                                    document.getElementById("loader").style.visibility="hidden";
                                    takingSnap();
                                }

                            }

                    })}




                }
            });

    },1000);};









    function showVideo() {
        hideUI();
        video.classList.add("visible");
        takingSnap();
    }


    function displayErrorMessage(error_msg, error) {
        error = error || "";
        if(error){
            console.error(error);
        }

        error_message.innerText = error_msg;

        hideUI();
        error_message.classList.add("visible");
    }


    function hideUI() {
        video.classList.remove("visible");
        snap.classList.remove("visible");
        error_message.classList.remove("visible");
        document.getElementById("loader").style.display = "block";
    }

});

function updateStatus(percentageStatus){
    var Status = document.getElementById("statusBar");
    Status.style.width = percentageStatus+"%";
    //updtateStatusWithTime(Status,percentageStatus);
    if(percentageStatus!= 100 && percentageStatus!= 0){
        setTimeout(function(){
            updateStatus(percentageStatus+10);
        },2000);
    }

}
/*function updateStatusWithTime(Status,percentageStatus){
    setInterval(function(Status,percentageStatus){
        Status.style.width = percentageStatus+"%";
        percentageStatus++;
    },1000);
}*/