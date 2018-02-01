var img=null;
document.addEventListener('DOMContentLoaded', function () {

    var video = document.querySelector('#camera-stream'),
        image = document.querySelector('#snap'),
        start_camera = document.querySelector('#start-camera'),
        controls = document.querySelector('.controls'),
        take_photo_btn = document.querySelector('#take-photo'),
        delete_photo_btn = document.querySelector('#delete-photo'),
        download_photo_btn = document.querySelector('#download-photo'),
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
    else{
        navigator.getMedia(
            {
                video: true,
                audio: false
            },
            function(stream) {

                video.src = window.URL.createObjectURL(stream);

                video.play();
                video.onplay = function() {
                    showVideo();
                };

            },
            function(err) {
                displayErrorMessage("There was an error with accessing the camera stream: " + err.name, err);
            }
        );
    }


    start_camera.addEventListener("click", function(e) {

        e.preventDefault();

        video.play();
        showVideo();

    });


    take_photo_btn.addEventListener("click", function(e) {

        e.preventDefault();

        var snap = takeSnapshot();
        img=snap;
        image.setAttribute('src', snap);
        image.classList.add("visible");

        delete_photo_btn.classList.remove("disabled");
        download_photo_btn.classList.remove("disabled");
        video.pause();

    });

    download_photo_btn.addEventListener("click", function(e) {
        var a={image:img};
        $.ajax({
            type: "POST",
            url: "/controlImg",
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(a),
            success: function(dataString) {
                console.log(dataString.employeeId);
                var detailsContainer=document.getElementById('container2');
                detailsContainer.innerHTML="<div> <li> <ul>ID:"+dataString.employeeId+"</ul> <ul>Name: "+dataString.name+"</ul> <ul>Designation: "+dataString.designation+"</ul> </li></div>";

            }
        });
    });


    delete_photo_btn.addEventListener("click", function(e) {

        e.preventDefault();

        image.setAttribute('src', "");
        image.classList.remove("visible");

        delete_photo_btn.classList.add("disabled");
        download_photo_btn.classList.add("disabled");

        video.play();

    });



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


    function showVideo() {
        hideUI();
        video.classList.add("visible");
        controls.classList.add("visible");
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


        controls.classList.remove("visible");
        start_camera.classList.remove("visible");
        video.classList.remove("visible");
        snap.classList.remove("visible");
        error_message.classList.remove("visible");
    }

});
