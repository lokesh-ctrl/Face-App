import React from 'react'
import ReactDOM from 'react-dom'


class App extends React.Component{
    render(){
        return(<div id='instructions'>
                <div><h2><b>Instructions:</b></h2></div>
                <ul>
                <li>Take care while capturing, it should be center aligned</li>
                    <li>Follow the status bar</li>
                    <li>After recognizing your face, it will show your details</li>
                    <li>Please click on opendoor button, to open the door.</li>
                </ul>
            </div>
            )

    }
    componentWillMount(){
    }
}

ReactDOM.render(<App />, document.getElementById("container2"));

