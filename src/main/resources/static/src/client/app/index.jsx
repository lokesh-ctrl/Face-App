import React from 'react'
import ReactDOM from 'react-dom'


class App extends React.Component{
    render(){
        return(<div>
                <div><h2><b>Instructions:</b></h2></div>
                <ul>
                <li>Take care while capturing, it should be center aligned</li>
                    <li>Click on "SNAP" button to take the picture.</li>
                    <li>Use "RETAKE" button, if any problems arises in step2 </li>
                    <li>Click on "GET DETAILS" button to get the details.</li>
                </ul>
            </div>
            )

    }
    componentWillMount(){
    }
}

ReactDOM.render(<App />, document.getElementById("container2"));


class Status extends React.Component{
    render(){
        return(<div>
                <div><h2><b>Status:</b></h2></div>
                <div id="myStatus">
                    <div id="statusBar"></div>
                </div>
            </div>
        )

    }
    componentWillMount(){
    }
}

ReactDOM.render(<Status />, document.getElementById("container3"));