var img=null;
document.addEventListener('DOMContentLoaded', function () {

    var video = document.querySelector('#camera-stream'),
        image = document.querySelector('#snap'),
        error_message = document.querySelector('#error-message'),
        status = document.getElementById('statusBar');
    var statusMessageElement = document.getElementById('statusMessage');


    navigator.getMedia = (

        navigator.getUserMedia ||
        navigator.webkitGetUserMedia ||
        navigator.mozGetUserMedia ||
        navigator.msGetUserMedia ||
        navigator.mediaDevices.getUserMedia
    );


    if (!navigator.getMedia) {
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
        updateStatusMessage("Streaming on");
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

    setTimeout(function () {
        takingSnap();

    }, 1000);


    function takingSnap() {
        var snap = takeSnapshot();
        img = snap;


        image.setAttribute('src', snap);

        var a = {image: img};
        $.ajax({
            type: "POST",
            url: "/controlImg",
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(a),
            success: function (dataString) {
                if (dataString.status === "success") {
                    updateStatus(20);
                    updateStatusMessage("Person Found");
                    document.getElementById("loader").style.visibility = "visible";
                    video.pause();
                    updateStatus(40);
                    updateStatusMessage("Recognizing Person..");
                    $.ajax({
                        type: "POST",
                        url: "/recognize",
                        contentType: 'application/json; charset=utf-8',
                        dataType: 'json',
                        data: JSON.stringify(a),
                        success: function (detailsString) {
                            updateStatus(60);
                            document.getElementById("loader").style.display = "none";
                            detailsContainer = document.getElementById("container2");
                            if (detailsString.employeeId === null) {
                                updateStatus(100);
                                updateStatusMessage("No details found in the database");
                                detailsContainer.innerHTML = "<div><h2>NO PERSON DETAILS FOUND.</h2></br><h3>Try Again (Or) Register</h3></br><button id='tryAgain'>TRY AGAIN</button><button id='register'>REGISTER</button></div>"
                                updateStatus(0);
                                document.getElementById("loader").style.visibility = "hidden";


                                var tryAgain = document.getElementById("tryAgain");
                                var register = document.getElementById("register");
                                tryAgain.addEventListener('click', function () {
                                    updateStatus(0);
                                    video.play();
                                    document.getElementById("loader").style.visibility = "hidden";
                                    setTimeout(function () {
                                        takingSnap();
                                    }, 100);
                                });
                                register.addEventListener('click', function () {
                                    window.location = "/src/client/public/html/Register.html";

                                });

                            }
                            else {
                                updateStatusMessage("Person Details Found");
                                updateStatus(100);
                                detailsContainer.innerHTML = "<div id='details'><h2>PERSON DETAILS:</h2> </br></br> <ul> <li>ID:" + detailsString.employeeId + "</li> <li>Name: " + detailsString.name + "</li> <li>Designation: " + detailsString.designation + "</li> </ul></div></<br><button id='openDoor'>OPEN DOOR</button></div>";
                                var opendoor = document.getElementById("openDoor");
                                opendoor.addEventListener('click', function () {


                                    detailsContainer.innerHTML = "<div id='instructions'><h2><b>Instructions:</b></h2><ul><li>Take care while capturing, it should be center aligned</li><li>Follow the status bar</li><li>After recognizing your face, it will show your details</li><li>Please click on opendoor button, to open the door.</li></ul></div>";
                                    updateStatus(0);
                                    video.play();
                                    document.getElementById("loader").style.visibility = "hidden";
                                    setTimeout(function () {
                                        takingSnap();
                                    }, 1000);
                                });

                            }

                        }
                    })
                }
                else if (dataString.status == "Failure") {
                    takingSnap();
                    updateStatus(0);

                }


            }

        });

    }

    function showVideo() {
        hideUI();
        video.classList.add("visible");
        updateStatusMessage("Streaming On");

    }


    function displayErrorMessage(error_msg, error) {
        error = error || "";
        if (error) {
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

    function updateStatus(percentageStatus) {
        status.style.width = percentageStatus + "%";

    }

    function updateStatusMessage(message) {
        statusMessageElement.innerText = message;
    }
}
);

