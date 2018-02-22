var popUp = document.getElementById('cameraPopUp');
var video = document.querySelector('#camera-stream')
var btn = document.getElementsByClassName("takePhotoButton")
var takePhotoButton = document.getElementById("snapButtonInPopUp");
var span = document.getElementsByClassName("close")[0];
var images = [];


function displayPopUp() {
    popUp.style.display = "block";
    ClickedElement = event.target;
    console.log(event.target);
}


span.onclick = function() {
    popUp.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == popUp) {
        popUp.style.display = "none";
    }
}

navigator.getMedia = (

    navigator.getUserMedia ||
    navigator.webkitGetUserMedia ||
    navigator.mozGetUserMedia ||
    navigator.msGetUserMedia ||
    navigator.mediaDevices.getUserMedia
);


if(!navigator.getMedia){
    consnole.log("Your browser doesn't have support for the navigator.getUserMedia interface.");
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
        console.log("SOme error"+err.message);
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

function showVideo() {
    video.classList.add("visible");

}

takePhotoButton.addEventListener('click',function(){
    var image = takeSnapshot();
    img = image;
    images[images.length]=img;
    popUp.style.display = "none";
    var parentElement = ClickedElement.parentNode;
    console.log(parentElement);
    var img = document.createElement("img");
    img.src =image;
    img.classList.add('imageClass');
    parentElement.replaceChild(img,ClickedElement);
});

function register() {
    var name = document.getElementById("nameOfThePerson").value;
    var id = document.getElementById("employeeId").value;
    var designation = document.getElementById("designation").value;
    console.log(name + id + designation);
    if (images.length < 5) {
        alert("Take all the five images");
    }
    else {
        if (!name) {
            alert("Employee name can not be empty");
        }
        else {
            if (!id) {
                alert("Employee id cannot be empty");
            }
            else {
                if (!designation) {
                    alert("Employee designation cannot be empty");
                }
                else {
                    var a = {
                        employeeName: name,
                        employeeImages: images,
                        employeeId: id,
                        employeeDesignation: designation
                    };
                    console.log(a);

                    $.ajax({
                        type: "POST",
                        url: "/register",
                        contentType: 'application/json; charset=utf-8',
                        dataType: 'json',
                        data: JSON.stringify(a),
                        success: function (dataString) {
                            if (dataString.status == "success") {
                                console.log(' Registration Successed');
                                var container = document.getElementsByClassName("container");
                                container.innerHTML = "<div>Registration success</div>";
                                setTimeout(function () {
                                    window.location = '../../../../index.html';
                                }, 1000);
                            }
                        }

                    })
                }
            }
        }
    }
}