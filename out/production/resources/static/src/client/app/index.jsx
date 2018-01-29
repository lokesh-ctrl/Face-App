import React from 'react'
import ReactDOM from 'react-dom'

class App extends React.Component{
    render(){
        return(<div>
            <h2>Instructions:</h2>
            <li>
                <ul>put face staright to the camera</ul>
                <ul></ul>
                <ul></ul>
                <ul></ul>
            </li>
            </div>
        )
    }
}
ReactDOM.render(<App />, document.getElementById("container2"));
