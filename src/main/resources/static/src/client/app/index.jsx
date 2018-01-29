import React from 'react'
import ReactDOM from 'react-dom'

class App extends React.Component{
    render(){
        return(<div>
            <h2>Instructions:</h2>
            <li>
                <ul>Click on scan button to take the snap</ul>
                <ul>Take care while capturing, it should be center aligned</ul>
                <ul>Use retake button, if any problem arises in step 2</ul>
            </li>
            </div>
        )
    }
}
ReactDOM.render(<App />, document.getElementById("container2"));
